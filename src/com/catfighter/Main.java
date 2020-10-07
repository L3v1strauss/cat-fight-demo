package com.catfighter;

import com.catfighter.Exceptions.DiceGameException;
import com.catfighter.api.services.ICatService;
import com.catfighter.entities.Cat;
import com.catfighter.services.CatService;
import com.catfighter.utils.Attack;
import com.catfighter.utils.DiceGame;

import java.io.IOException;
import java.util.Comparator;

import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        ICatService catService = new CatService();
        catService.addCat(catService.getCats(), new Cat(100, 5, 5, 5, 1));
        catService.addCat(catService.getCats(), new Cat(100, 3, 10, 10, 1));
        catService.addCat(catService.getCats(), new Cat(100, 1, 15, 15, 1));
        catService.addCat(catService.getCats(), new Cat(100, 10, 2, 2, 1));
        catService.addCat(catService.getCats(), new Cat(100, 6, 3, 4, 1));
        catService.addCat(catService.getCats(), new Cat(100, 4, 7, 3, 1));
        DiceGame.nameCats(catService.getCats());
        DiceGame.thatFighters(catService.getFightCats(),catService.getCats());
        System.out.println();
        while (catService.getCatHealth(DiceGame.fighterName2(catService.getFightCats())) > 0
                && catService.getCatHealth(DiceGame.fighterName1(catService.getFightCats())) > 0) {
            Attack.singleAttack(catService.getByName(DiceGame.fighterName2(catService.getFightCats())),
                    catService.getByName(DiceGame.fighterName1(catService.getFightCats())));
            Attack.singleAttack(catService.getByName(DiceGame.fighterName1(catService.getFightCats())),
                    catService.getByName(DiceGame.fighterName2(catService.getFightCats())));
        }
    }
}


