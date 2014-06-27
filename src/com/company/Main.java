package com.company;

import java.util.*;

public final class Main {
     public static void main (String[] args){
        System.out.println("Creating 10 random integers between 1 and 100");

        Random randomGenerator = new Random();
        for (int i = 1; i <= 10; ++i){
            int randomInt = randomGenerator.nextInt(100);
            System.out.println("Random " + i + " : " + randomInt);
        }

        for (int i = 1; i <= 10; i++){
            double randomInt2 = Math.floor(Math.random() * 100);
            System.out.println("Random 2 " + i + ": " + randomInt2);
        }

        System.out.println("Monster Ranchers Double Swag");
    }

}

Dicks
