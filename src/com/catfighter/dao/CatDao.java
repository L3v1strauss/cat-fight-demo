package com.catfighter.dao;

import com.catfighter.api.dao.ICatDao;
import com.catfighter.entities.Cat;

import java.util.*;

public class CatDao implements ICatDao {

    private final List<Cat> cats = new ArrayList<>();
    private final Map<Cat, Integer> fightCats = new HashMap<>();

    @Override
    public List<Cat> getCats() {
        return cats;
    }

    @Override
    public Map<Cat, Integer> getFightCats() {
        return fightCats;
    }

    @Override
    public void addCat(List<Cat> cats, Cat cat) {
        cats.add(cat);
    }

    @Override
    public Cat getByName(String name) {
        try {
            return fightCats.keySet().stream()
                    .filter(cat -> cat.getName().equals(name))
                    .findFirst()
                    .orElse(null);
        } catch (NullPointerException exception) {
            System.out.println();
        }
        return null;
    }

    @Override
    public int getCatHealth(String name) {
        Cat cat = this.getByName(name);
        return cat.getHealth();
    }
}


