package com.example.robodog.model;

public class Dog {

    private int age;
    private String name;
    private EBreed EBreed;

    public Dog(int age, String name, EBreed EBreed) {
        this.age = age;
        this.name = name;
        this.EBreed = EBreed;
    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public com.example.robodog.model.EBreed getEBreed() {
        return EBreed;
    }

    public void setEBreed(com.example.robodog.model.EBreed EBreed) {
        this.EBreed = EBreed;
    }
}
