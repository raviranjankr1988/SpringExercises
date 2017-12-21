package com.springexercises.springaop.model;

public class Circle {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("setName on circle is called");
        this.name = name;
    }

    public String setNameandReturn(String name) {
        System.out.println("in setNameandReturn");
        this.name = name;
        return name;
    }
}
