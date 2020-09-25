package com.catfighter.api.services;

import com.catfighter.entities.Cat;

import java.util.List;

public interface ICatService {

    List<Cat> getCats();

    void addCat(Cat cat);

    Cat getByName(String name);

    public void updateCatStrenght(String name, int strenght);
}
