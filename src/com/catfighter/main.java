package com.catfighter;

import com.catfighter.api.services.ICatService;
import com.catfighter.entities.Cat;
import com.catfighter.services.CatService;

public class main {

    public static void main(String[] args) {
        ICatService catService = new CatService();

        Cat vaska = new Cat("Vaska", 5, 10);
        catService.addCat(vaska);
    }


}
