package com.company;

/**
 * Created by Inder on 6/27/2014.
 */
public class Name {
    private String firstName;
    private char inital;
    private String lastName;

    public Name(String firstName, String lastName)
    {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Name(String firstName, char inital, String lastName)
    {
        this.firstName = firstName;
        this.inital = inital;
        this.lastName = lastName;
    }



    public String toString()
    {
        if (inital == ' ')
        {
            return "\nFirst Name: " + firstName + "\nMiddle: " + inital + "\nLast Name: " + lastName;
        }
        else
        {
            return "\nFirst Name: " + firstName + "\nLast Name: " + lastName;
        }
    }
}
