package com.catfighter;

import com.catfighter.api.services.ICatService;
import com.catfighter.entities.Cat;
import com.catfighter.services.CatService;
import com.catfighter.utils.Attack;
import com.catfighter.utils.DiceGame;

import java.util.Comparator;

import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        ICatService catService = new CatService();
        catService.addCat(catService.getCats(), new Cat("Catzilla", 100, 5, 5, 5, DiceGame.rollDice()));
        catService.addCat(catService.getCats(), new Cat("Catkong", 100, 3, 10, 10, DiceGame.rollDice()));
        catService.addCat(catService.getCats(), new Cat("LuckyCat", 100, 1, 15, 15, DiceGame.rollDice()));
        catService.addCat(catService.getCats(), new Cat("NoMercyCat", 100, 10, 2, 2, DiceGame.rollDice()));
        catService.addCat(catService.getCats(), new Cat("MadCat", 100, 6, 3, 4, DiceGame.rollDice()));
        catService.addCat(catService.getCats(), new Cat("PsyhoCat", 100, 4, 7, 3, DiceGame.rollDice()));
        DiceGame.whosFighters(catService.getCats(), catService.getFightCats());
        String fighterName1 = catService.getFightCats().stream().map(Cat::getName).limit(1).collect(Collectors.joining());
        String fighterName2 = catService.getFightCats().stream().max(Comparator.comparing(Cat::getDiceSide)).map(Cat::getName).orElse("null");
        System.out.println();
        while (catService.getCatHealth(fighterName2) > 0 && catService.getCatHealth(fighterName1) > 0) {
            Attack.singleAttack(catService.getByName(fighterName2), catService.getByName(fighterName1));
            Attack.singleAttack(catService.getByName(fighterName1), catService.getByName(fighterName2));
        }

    }

}

