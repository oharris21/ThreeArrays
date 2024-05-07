package com.example.arrays.app;

import com.example.arrays.dto.ArrayDTO;
import com.example.arrays.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.arrays"})
public class ArraysApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext appContext = SpringApplication.run(ArraysApplication.class, args);
		System.out.println("\nArrays Application Started!\n");

		// Can't do typical annotation driven autowiring here because the main method is static, so this is a way to
		// explicitly tell Spring to return the bean after the injection completes.
		ArrayDTO arrayDTO = appContext.getBean(ArrayDTO.class);
		GeneratorServiceImpl generatorService = appContext.getBean(GeneratorServiceImpl.class);
		ArrayServiceImpl arrayService = appContext.getBean(ArrayServiceImpl.class);
		PrintService printService = appContext.getBean(PrintServiceImpl.class);

		// business logic from requirements
		List<List<Integer>> arrays = generatorService.generateAll(arrayDTO).getAllArrays();
		List<Integer> availableNumbers = arrayService.extract(arrays);
		Integer largestPrimeNumber = arrayService.findLargestPrimeNumber(arrays);

		// logic for printing to console
		printService.printAllArrays(arrays);
		printService.printAvailableNumbers(availableNumbers);
		printService.printLargestPrimeNumber(largestPrimeNumber);
	}

	// TODO
	// docker
	// largestPrimeNumberIsTheLargest

}
