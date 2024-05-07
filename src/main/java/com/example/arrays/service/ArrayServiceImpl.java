package com.example.arrays.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class ArrayServiceImpl implements ArrayService {
    public static final LinkedList<Integer> primeNumbersZeroToFifty =
            new LinkedList<>(Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47));

    public List<Integer> extract(List<List<Integer>> arrays) {
        List<Integer> availableNumbersList = IntStream.range(1, GeneratorServiceImpl.RANGE).boxed().toList();
        Map<Integer, Integer> availableNumbers =
                availableNumbersList.stream().collect(Collectors.toMap(i -> i, i -> i));

        for (List<Integer> currentArray : arrays) {
            for (Integer i : currentArray) {
                availableNumbers.remove(i);
            }
        }

        return availableNumbers.values().stream().toList();
    }

    public Integer findLargestPrimeNumber(List<List<Integer>> arrays) {
        LinkedList<Integer> primeNumbers = primeNumbersZeroToFifty;

        for (List<Integer> currentArray : arrays) {
            for (Integer i : currentArray) {
                primeNumbers.remove(i);
            }
        }

        return primeNumbers.getLast();
    }
}
