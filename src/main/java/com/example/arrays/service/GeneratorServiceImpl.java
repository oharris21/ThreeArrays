package com.example.arrays.service;

import com.example.arrays.dto.ArrayDTO;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.IntStream;

@Service
public class GeneratorServiceImpl implements GeneratorService {

    public static final int RANGE = 50;
    public static final int SIZE = 15;

    public ArrayDTO generateAll(ArrayDTO array) {
        array.setArray1(IntStream.generate(() -> new Random().nextInt(RANGE)).limit(SIZE).boxed().toList());
        array.setArray2(IntStream.generate(() -> new Random().nextInt(RANGE)).limit(SIZE).boxed().toList());
        array.setArray3(IntStream.generate(() -> new Random().nextInt(RANGE)).limit(SIZE).boxed().toList());
        return array;
    }

}
