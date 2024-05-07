package com.example.arrays.service;

import java.util.List;

public interface ArrayService {
    List<Integer> extract(List<List<Integer>> arrays);
    Integer findLargestPrimeNumber(List<List<Integer>> arrays);
}
