package com.catfighter.dao;

import com.catfighter.api.dao.ICatDao;
import com.catfighter.entities.Cat;

import java.util.*;

public class CatDao implements ICatDao {

    private final List<Cat> cats = new ArrayList<>();

    @Override
    public List<Cat> getCats() {
        return cats;
    }

    @Override
    public void addCat(Cat cat) {
        cats.add(cat);
    }

    @Override
    public Cat getByName(String name) {
        Optional<Cat> optionalCat = cats.stream()
                .filter(x -> x.getName().equals(name))
                .findFirst();
        return optionalCat.orElse(null);
    }

    @Override
    public int getCatDamage(String name) {
        Cat cat = this.getByName(name);
        return cat.getDamage();
    }

    @Override
    public int getCatAgility(String name) {
        Cat cat = this.getByName(name);
        return cat.getAgility();
    }

    @Override
    public int getCatStrenght(String name) {
        Cat cat = this.getByName(name);
        return cat.getStrenght();
    }

    @Override
    public int getCatHealth(String name) {
        Cat cat = this.getByName(name);
        return cat.getHealth();
    }

    @Override
    public void updateCatHealth(String name, int health) {
        Cat cat = this.getByName(name);
        cat.setHealth(health);
        System.out.println("Оставшееся здоровье " + cat.getName() + ": " + cat.getHealth() + " едениц");
    }

    @Override
    public int getCatDiceSide(String name) {
        Cat cat = this.getByName(name);
        return cat.getDiceSide();
    }

    @Override
    public void rollCatDice(String name) {
        Random random = new Random();
        int diceSide = random.nextInt(6);
        Cat cat = this.getByName(name);
        cat.setDiceSide(diceSide);
        System.out.println("Игральные кости " + cat.getName() + " показали " + cat.getDiceSide());
    }

}







//    @Override
//    public void updateCatStrenght(String name, int strenght) {
//        Cat cat = this.getByName(name);
//        cat.setStrenght(strenght);
//        System.out.println("Cat was added NEW: " + cat.toString());
//    }

