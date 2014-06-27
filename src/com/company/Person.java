package com.company;

/**
 * Created by Inder on 6/27/2014.
 */
public class Person {

    private Name name;
    private Address address;
    private String id;

    public Person(Name name,Address address)
    {
        this.name = name;
        this.address = address;
    }

    public Person(Name name,Address address, String id)
    {
        this.name = name;
        this.address = address;
        this.id = id;
    }

    public String getId()
    {
        return id;
    }

    public void setId()
    {
        this.id = id;
    }

    public String toString()
    {
        return "Person # "+ id + " " + name.toString() + "\n"  + address.toString();
    }
}
