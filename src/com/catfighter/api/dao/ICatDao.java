package com.catfighter.api.dao;

import com.catfighter.entities.Cat;

import java.util.List;


public interface ICatDao {

    List<Cat> getCats();

    List<Cat> getFightCats();

    void addCat(List<Cat> cats, Cat cat);

    Cat getByName(String name);

    int getCatHealth(String name);

}
