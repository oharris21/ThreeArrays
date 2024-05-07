package com.example.arrays.service;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrintServiceImpl implements PrintService{
    public void printAllArrays(List<List<Integer>> arrays) {
        int arrayId = 0;

        for (List<Integer> currentArray : arrays) {
            arrayId ++;
            System.out.print("Array " + arrayId + ": ");
            printWithArrayFormat(currentArray);
            System.out.println(" ");
        }
    }

    public void printAvailableNumbers(List<Integer> availableNumbers) {
        System.out.print("\nAvailable Numbers: ");
        printWithArrayFormat(availableNumbers);
    }

    public void printLargestPrimeNumber(Integer largestPrimeNumber) {
        System.out.println("\nLargest Prime Number: " + largestPrimeNumber);
    }

    private void printWithArrayFormat(List<Integer> array) {
        for (int i = 0; i < array.size(); i++) {
            if (i == 0) {
                System.out.print("[ " + array.get(i) + ", ");
            } else if (i == array.size() -1) {
                System.out.print(array.get(i) + " ]");
            } else {
                System.out.print(array.get(i) + ", ");
            }
        }
    }
}
