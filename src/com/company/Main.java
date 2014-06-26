package com.company;

import java.util.Random;

public final class Main {
    public static final void main(String... aArgs){
        System.out.println("Creating 10 random integers between 1 and 100");

        Random randomGenerator = new Random();
        for (int i = 1; i <= 10; ++i){
            int randomInt = randomGenerator.nextInt(100);
            System.out.println("Random " + i + " : " + randomInt);
        }

        System.out.println("Mission Accomplished....... ");
    }

}

