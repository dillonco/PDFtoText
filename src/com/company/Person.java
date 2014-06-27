package com.company;

/**
 * Created by Inder on 6/27/2014.
 */
public class Person {

    private Name name;
    private Address address;
    private int id;

    public Person(Name name,Address address)
    {
        this.name = name;
        this.address = address;
    }

    public Person(Name name,Address address, int id)
    {
        this.name = name;
        this.address = address;
        this.id = id;
    }

    public int getId()
    {
        return id;
    }

    public void setId()
    {
        this.id = id;
    }

    public String toString()
    {
        return "\nPerson # "+ id + " " + name.toString() + "\n"  + address.toString();
    }
}
