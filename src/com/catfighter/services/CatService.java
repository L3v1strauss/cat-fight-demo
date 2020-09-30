package com.catfighter.services;

import com.catfighter.api.dao.ICatDao;
import com.catfighter.api.services.ICatService;
import com.catfighter.dao.CatDao;
import com.catfighter.entities.Cat;

import java.util.List;


public class CatService implements ICatService {

    private final ICatDao catDao = new CatDao();

    @Override
    public List<Cat> getCats() {
        return catDao.getCats();
    }

    @Override
    public List<Cat> getFightCats() {
        return catDao.getFightCats();
    }

    @Override
    public void addCat(List<Cat> cats, Cat cat) {
        catDao.addCat(cats, cat);
    }

    @Override
    public Cat getByName(String name) {
        return catDao.getByName(name);
    }

    @Override
    public int getCatHealth(String name) {
        return catDao.getCatHealth(name);
    }

}





