package com.catfighter.dao;

import com.catfighter.api.dao.ICatDao;
import com.catfighter.entities.Cat;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CatDao implements ICatDao {

    private List<Cat> cats = new ArrayList<>();

    @Override
    public List<Cat> getCats() {
        return cats;
    }

    @Override
    public Cat getByName(String name) {
        Optional<Cat> optionalCat = cats.stream()
                .filter(x -> x.getName().equals(name))
                .findFirst();
//       Cat cat = optionalCat.orElse(null);
        return optionalCat.orElse(null);
    }

    @Override
    public void updateCatStrenght(String name, int strenght) {
        Cat cat = this.getByName(name);
        cat.setStrenght(strenght);
        System.out.println("Cat was added NEW: " + cat.toString());
    }

    @Override
    public void addCat(Cat cat) {
        cats.add(cat);
        System.out.println("Cat was added: " + cat.toString());
    }

    public void setCats(List<Cat> cats) {
        this.cats = cats;
    }
}
