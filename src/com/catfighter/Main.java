package com.catfighter;

import com.catfighter.api.services.ICatService;
import com.catfighter.entities.Animal;
import com.catfighter.entities.Cat;
import com.catfighter.services.CatService;
import com.catfighter.utils.Attack;

import java.util.Map;

public class Main {

    public static void main(String[] args) {
        ICatService catService = new CatService();
        catService.addCat(new Cat("Killer", 100, 5, 5, 5));
        catService.addCat(new Cat("Finisher", 100, 5, 5, 5));
        catService.rollCatDice("Killer");
        catService.rollCatDice("Finisher");
        System.out.println(catService.getCatDiceSide("Killer"));

        if (catService.getCatDiceSide("Killer") > catService.getCatDiceSide("Finisher")) {
            while (catService.getCatHealth("Killer") > 0 && catService.getCatHealth("Finisher") > 0) {
                new Attack().singleAttack("Killer", "Finisher");
                new Attack().singleAttack("Finisher", "Killer");
            }
        } else {
            while (catService.getCatHealth("Killer") > 0 && catService.getCatHealth("Finisher") > 0) {
                new Attack().singleAttack("Finisher", "Killer");
                new Attack().singleAttack("Killer", "Finisher");
            }
        }

    }
}
