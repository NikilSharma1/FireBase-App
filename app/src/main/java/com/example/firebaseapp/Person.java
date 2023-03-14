package com.example.firebaseapp;

public class Person {
    private String name;
    private String age;
    public Person(){

    }
    public Person(String age,String name){
        this.age=age;
        this.name=name;
    }
    public String getAge(){return age;}

    public void setAge(String age) {
        this.age=age;
    }

    public String getName(){return name;}

    public void setName(String name){
        this.name=name;
    }




}
