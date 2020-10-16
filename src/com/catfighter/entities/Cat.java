package com.catfighter.entities;

import java.io.Serializable;

public class Cat extends Animal implements Serializable {

    private String name;
    private int luck;

    public Cat(int health, int damage, int agility, int strenght, int luck) {
        super(health, damage, agility, strenght);
        this.luck = luck;

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
                "name='" + name + '\'' + "health" + getHealth() +
                '}';
    }
}
