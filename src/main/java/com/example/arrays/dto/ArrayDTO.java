package com.example.arrays.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Component
public class ArrayDTO {
    private List<Integer> array1;
    private List<Integer> array2;
    private List<Integer> array3;
    private List<List<Integer>> allArrays;
    private List<Integer> availableNumbers;
    private Integer largestPrimeNumber;
}
