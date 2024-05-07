package com.example.arrays.service;

import java.util.List;
import java.util.Optional;

public interface ArrayService {
    List<Integer> extract(List<List<Integer>> arrays);
    Optional<Integer> findLargestPrimeNumber(List<Integer> numbers);
}
