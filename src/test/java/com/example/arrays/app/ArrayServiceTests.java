package com.example.arrays.app;

import com.example.arrays.dto.ArrayDTO;
import com.example.arrays.service.GeneratorServiceImpl;
import com.example.arrays.service.ArrayServiceImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.example.arrays"})
class ArrayServiceTests {

	@Autowired
	private ArrayServiceImpl service;

	static List<List<Integer>> arrays;

	@BeforeAll
    static void generateArrays(@Autowired GeneratorServiceImpl generatorService, @Autowired ArrayDTO arrayDto) {
		arrays = generatorService.generateAll(arrayDto).getAllArrays();
	}

	@Test
	void contextLoads() {
	}

	@Test
	void availableNumbersIsNotNull() {
		List<Integer> availableNumbers = service.extract(arrays);

		assertNotNull(availableNumbers);
	}

	@Test
	void availableNumbersDoNotExistInAnyOfTheThreeArrays() {
		List<Integer> availableNumbers = service.extract(arrays);

		assertFalse(arrays.get(0).stream().anyMatch(availableNumbers::contains));
		assertFalse(arrays.get(1).stream().anyMatch(availableNumbers::contains));
		assertFalse(arrays.get(2).stream().anyMatch(availableNumbers::contains));
	}

	@Test
	void largestPrimeNumberIsPrime() {
		int number = service.findLargestPrimeNumber(arrays);
		boolean isPrime = ArrayServiceImpl.primeNumbersZeroToFifty.contains(number);

		assertTrue(isPrime);
	}

//	@Test
//	void largestPrimeNumberIsTheLargest() {
//		int number = service.findLargestPrimeNumber(arrays);
//
//	}

}
