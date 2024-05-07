package com.example.arrays.service;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class ArrayServiceImpl implements ArrayService {
    public static final List<Integer> PRIME_NUMBERS_ZERO_TO_FIFTY =
            Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47);
    public static final List<Integer> AVAILABLE_NUMBERS =
            IntStream.range(1, GeneratorServiceImpl.RANGE).boxed().toList();

    public List<Integer> extract(List<List<Integer>> arrays) {
        Map<Integer, Integer> availableNumbers = AVAILABLE_NUMBERS.stream().collect(Collectors.toMap(i -> i, i -> i));

        for (List<Integer> currentArray : arrays) {
            for (Integer i : currentArray) {
                availableNumbers.remove(i);
            }
        }

        return availableNumbers.values().stream().toList();
    }

    public Optional<Integer> findLargestPrimeNumber(List<Integer> numbers) {
        return numbers.stream().filter(PRIME_NUMBERS_ZERO_TO_FIFTY::contains).reduce(Integer::max);
    }
}
