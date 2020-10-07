package com.catfighter.entities;

import java.util.function.Function;
import java.util.stream.Stream;

public class Cat extends Animal {

    private String name;
    private int luck;

    public Cat(int health, int damage, int agility, int strenght, int luck) {
        super(health, damage, agility, strenght);
        this.luck = luck;

    }

    public int getLuck() {
        return luck;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setHealth(int health) {
        super.setHealth(health);
        System.out.println("Оставшееся здоровье " + this.getName() + ": " + this.getHealth() + " едениц");

    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                '}';
    }
}
