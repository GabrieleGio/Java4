package com.spring.base.controller;

import java.util.ArrayList;
import java.util.Random;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path= "/random")

public class RandomController {
	@GetMapping(path="/prova90")
	//Funzione per generare 10 numeri casuali tra 0 e 90
	public ArrayList<Integer> getRandomNumbers(){
	 ArrayList<Integer> randomNumbers = new ArrayList<>();

    Random rand = new Random();
    
    for (int i = 0; i < 10; i++) {
        int randomNum = rand.nextInt(91);
        randomNumbers.add(randomNum);
    }
    return randomNumbers;
	}
}
