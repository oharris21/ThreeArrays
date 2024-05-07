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
    private List<Integer> array1 = new ArrayList<>();
    private List<Integer> array2 = new ArrayList<>();
    private List<Integer> array3 = new ArrayList<>();

    public List<List<Integer>> getAllArrays() {
        return Arrays.asList(array1, array2, array3);
    }
}
