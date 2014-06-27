package com.company;

import java.util.*;

public final class Main {
     public static void main (String[] args){
       /* System.out.println("Creating 10 random integers between 1 and 100");

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
        **/

         Scanner sc = new Scanner(System.in);
         System.out.println("Please Enter First Name");
         String firstName = sc.nextLine();
         System.out.println("Please Enter Last Name");
         String lastName = sc.nextLine();

         Name name = new Name(firstName, lastName);

         System.out.println("Please Enter Your House Number and Street Name");
         String street = sc.nextLine();
         System.out.println("Please Enter Your City Name");
         String city = sc.nextLine();
         System.out.println("Please Enter Your State/Province Name");
         String state = sc.nextLine();
         System.out.println("Please Enter Your ZIP Code");
         String zip = sc.nextLine();

         Address address = new Address(street, city, state, zip);

         Person person = new Person(name, address, "1");

         System.out.println(person.toString());

    }

}
