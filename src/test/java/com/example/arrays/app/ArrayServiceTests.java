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

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.example.arrays"})
class ArrayServiceTests {

	@Autowired
	private ArrayServiceImpl service;

	private static List<List<Integer>> arrays;

	@BeforeAll
    static void generateArrays(@Autowired GeneratorServiceImpl generatorService, @Autowired ArrayDTO arrayDto) {
		arrays = generatorService.generateAll();
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
		Integer number = service.findLargestPrimeNumber(List.of(43, 47, 48, 49, 50)).orElse(null);
		boolean isPrime = ArrayServiceImpl.PRIME_NUMBERS_ZERO_TO_FIFTY.contains(number);

		assertTrue(isPrime);
	}

	@Test
	void largestPrimeNumberIsCorrect() {
		Integer number = service.findLargestPrimeNumber(List.of(43, 47, 48, 49, 50)).orElse(null);

		assertEquals(47, number);
	}

	@Test
	void primeNumbersThatAreNotTheLargestReturnFalse() {
		Integer number = service.findLargestPrimeNumber(List.of(1, 2, 3, 4, 5)).orElse(null);

        assertNotEquals(2, number);
        assertNotEquals(3, number);
        assertEquals(5, number);
	}

}
