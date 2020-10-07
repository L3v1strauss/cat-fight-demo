package com.catfighter.api.services;

import com.catfighter.entities.Cat;

import java.util.List;
import java.util.Map;

public interface ICatService {

    List<Cat> getCats();

    Map<Cat, Integer> getFightCats();

    void addCat(List<Cat> cats, Cat cat);

    Cat getByName(String name);

    int getCatHealth(String name);
}



