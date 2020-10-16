package com.catfighter.entities;

import java.io.Serializable;

public class Animal implements Serializable {

    private int health;
    private int damage;
    private int agility;
    private int strenght;

    public Animal(int health, int damage, int agility, int strenght) {
        this.health = health;
        this.damage = damage;
        this.agility = agility;
        this.strenght = strenght;
    }

    Animal() {
        health = 100;
        damage = 3;
        agility = 5;
        strenght = 5;

    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public int getStrenght() {
        return strenght;
    }

    public void setStrenght(int strenght) {
        this.strenght = strenght;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "health=" + health +
                ", damage=" + damage +
                ", agility=" + agility +
                ", strenght=" + strenght +
                '}';
    }
}
