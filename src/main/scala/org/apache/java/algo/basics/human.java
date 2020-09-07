package org.apache.java.algo.basics;

// Class Human is a blueprint which can be used to clone 'n' number of objects
//
public class human {
    //    Common characterisicts of human that we need to replicate.
    String name;
    Integer age;
    Integer heightinInches;

    public human(String name, Integer age, Integer heightinInches) {
        this.name = name;
        this.age = age;
        this.heightinInches = heightinInches;
    }

    //Methods are the behaviour
    public void speak() {
        System.out.println("Hello my name in " + name);
        System.out.println("My age is " + age);
        System.out.println("My height is " + heightinInches);
    }

    public void eat() {
        System.out.println("Eating...");
    }

    public void work() {
        System.out.println("Working...");
    }


}
