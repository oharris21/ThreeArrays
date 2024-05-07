package com.example.arrays.app;

import com.example.arrays.dto.ArrayDTO;
import com.example.arrays.service.GeneratorServiceImpl;
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
class GeneratorServiceTests {

    static List<List<Integer>> arrays;

    @BeforeAll
    static void generateArrays(@Autowired GeneratorServiceImpl generatorService, @Autowired ArrayDTO arrayDto) {
        arrays = generatorService.generateAll(arrayDto).getAllArrays();
    }

    @Test
    void contextLoads() {
    }

    @Test
    void generateAllSetsAllThreeArrays() {
        assertEquals(3, arrays.size());
    }

    @Test
    void generateAllSetsAllThreeArraysWithFifteenElements() {
        assertEquals(GeneratorServiceImpl.SIZE, arrays.get(0).size());
        assertEquals(GeneratorServiceImpl.SIZE, arrays.get(1).size());
        assertEquals(GeneratorServiceImpl.SIZE, arrays.get(2).size());
    }

    @Test
    void arrayElementsDoNotExceedTheRange() {
        assertTrue(arrays.get(0).stream().allMatch(i -> i <= GeneratorServiceImpl.RANGE));
        assertTrue(arrays.get(1).stream().allMatch(i -> i <= GeneratorServiceImpl.RANGE));
        assertTrue(arrays.get(2).stream().allMatch(i -> i <= GeneratorServiceImpl.RANGE));
    }

}
