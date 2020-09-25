package com.catfighter.api.dao;

import com.catfighter.entities.Cat;

import java.util.List;

public interface ICatDao {

    List<Cat> getCats();

    void addCat(Cat cat);

    Cat getByName(String name);

    public void updateCatStrenght(String name, int strenght);
}
