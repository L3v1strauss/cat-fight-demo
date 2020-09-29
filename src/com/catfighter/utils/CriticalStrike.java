package com.catfighter.utils;

import com.catfighter.api.services.ICatService;
import com.catfighter.services.CatService;

import java.util.Random;

public class CriticalStrike {

    ICatService catService = new CatService();

    public boolean isCriticalChance(String name) {
        boolean criticalChance;
        Random random = new Random();
        criticalChance = random.nextInt(30 / (catService.getCatAgility(name) + catService.getCatStrenght(name))) == 0;
        return criticalChance;
    }

    public  int criticalStrike(String name) {
        return (catService.getCatDamage(name) * 2) + (catService.getCatAgility(name) + catService.getCatStrenght(name)) / 2;


    }
}
