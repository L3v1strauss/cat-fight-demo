package com.catfighter.entities;

public class Cat extends Animal {

    private String name;
    private int diceSide;

    public Cat(String name, int health, int damage, int agility, int strenght) {
        super(health, damage, agility, strenght);
        this.name = name;
    }

    public int getDiceSide() {
        return diceSide;
    }

    public void setDiceSide(int diceSide) {
        this.diceSide = diceSide;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                '}';
    }
}
