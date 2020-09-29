package com.catfighter;

import com.catfighter.api.services.ICatService;
import com.catfighter.entities.Cat;
import com.catfighter.services.CatService;
import com.catfighter.utils.Attack;

public class Main {

    public static void main(String[] args) {
        ICatService catService = new CatService();
        catService.addCat(new Cat("Killer", 100, 5, 5, 5));
        catService.addCat(new Cat("Finisher", 100, 5, 5, 5));
        catService.addCat(new Cat("Lucky", 100, 5, 5, 5));
        catService.addCat(new Cat("Finisher", 100, 5, 5, 5));
        catService.addCat(new Cat("Finisher", 100, 5, 5, 5));
        catService.addCat(new Cat("Finisher", 100, 5, 5, 5));
        catService.rollCatDice("Killer");
        catService.rollCatDice("Finisher");
        System.out.println(catService.getCatDiceSide("Killer"));

        if (catService.getCatDiceSide("Killer") > catService.getCatDiceSide("Finisher")) {
            while (catService.getCatHealth("Killer") > 0 && catService.getCatHealth("Finisher") > 0) {
                Attack.singleAttack(catService.getByName("Killer"), catService.getByName("Finisher"));
                Attack.singleAttack(catService.getByName("Finisher"), catService.getByName("Killer"));
            }
        } else {
            while (catService.getCatHealth("Killer") > 0 && catService.getCatHealth("Finisher") > 0) {
                 Attack.singleAttack(catService.getByName("Finisher"), catService.getByName("Killer"));
                Attack.singleAttack(catService.getByName("Killer"), catService.getByName("Finisher"));
            }
        }

    }
}
