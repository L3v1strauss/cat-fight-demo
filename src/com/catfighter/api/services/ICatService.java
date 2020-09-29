package com.catfighter.api.services;

import com.catfighter.entities.Cat;

import java.util.List;
import java.util.Map;

public interface ICatService {

    List<Cat> getCats();

    void addCat(Cat cat);

    Cat getByName(String name);

    int getCatDamage(String name);

    int getCatAgility(String name);

    int getCatStrenght(String name);

    int getCatHealth(String name);

    void updateCatHealth(String name, int health);

    int getCatDiceSide(String name);

    void rollCatDice(String name);


}



