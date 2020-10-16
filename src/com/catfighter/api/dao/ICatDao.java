package com.catfighter.api.dao;

import com.catfighter.entities.Cat;

import java.util.List;
import java.util.Map;


public interface ICatDao {

    List<Cat> getCats();

    Map<Cat, Integer> getFightCats();

    void addCat(Cat cat);

    Cat getByName(String name);

    int getCatHealth(String name);
}
