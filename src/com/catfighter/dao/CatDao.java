package com.catfighter.dao;

import com.catfighter.api.dao.ICatDao;
import com.catfighter.entities.Cat;

import java.util.*;

public class CatDao implements ICatDao {

    private final List<Cat> cats = new ArrayList<>();
    private final List<Cat> fightCats = new ArrayList<>();

    @Override
    public List<Cat> getCats() {
        return cats;
    }

    @Override
    public List<Cat> getFightCats() {
        return fightCats;
    }

    @Override
    public void addCat(List<Cat> cats, Cat cat) {
        cats.add(cat);
    }

    @Override
    public Cat getByName(String name) {
        Optional<Cat> optionalCat = fightCats.stream()
                .filter(x -> x.getName().equals(name))
                .findFirst();
        return optionalCat.orElse(null);
    }

    @Override
    public int getCatHealth(String name) {
        Cat cat = this.getByName(name);
        return cat.getHealth();
    }

}


