package com.catfighter.services;

import com.catfighter.api.dao.ICatDao;
import com.catfighter.api.services.ICatService;
import com.catfighter.dao.CatDao;
import com.catfighter.entities.Cat;

import java.util.List;

public class CatService implements ICatService {

    ICatDao catDao = new CatDao();

    @Override
   public List<Cat> getCats(){
    return catDao.getCats();
}
     @Override
    public void addCat(Cat cat){
        catDao.addCat(cat);
    }

   @Override
    public Cat getByName(String name){
        return catDao.getByName(name);
}

    @Override
    public void updateCatStrenght(String name, int strenght) {
        catDao.updateCatStrenght(name, strenght);
    }

}
