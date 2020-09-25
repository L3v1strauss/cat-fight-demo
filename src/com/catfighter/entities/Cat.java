package com.catfighter.entities;

public class Cat {

    private String name;

    private int age;

    private int strenght;

    public Cat() {
    }

    public Cat(String name, int age, int strenght) {
        this.name = name;
        this.age = age;
        this.strenght = strenght;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getStrenght() {
        return strenght;
    }

    public void setStrenght(int strenght) {
        this.strenght = strenght;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", strenght=" + strenght +
                '}';
    }
}
