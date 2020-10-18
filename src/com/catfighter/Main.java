package com.catfighter;

import com.catfighter.api.services.ICatService;
import com.catfighter.entities.Cat;
import com.catfighter.services.CatService;
import com.catfighter.utils.Attack;
import com.catfighter.utils.DiceGame;
import com.catfighter.utils.Names;
import com.catfighter.utils.SavedGame;

import java.io.IOException;


public class Main {

    public static void main(String[] args) throws IOException {
        ICatService catService = new CatService();
        catService.addCat(new Cat(100, 5, 5, 5));
        catService.addCat(new Cat(100, 3, 10, 10));
        catService.addCat(new Cat(100, 1, 15, 15));
        catService.addCat(new Cat(100, 10, 2, 2));
        catService.addCat(new Cat(100, 6, 3, 4));
        catService.addCat(new Cat(100, 4, 7, 3));
        Names.nameCats(catService.getCats());
        DiceGame.thatFighters(catService.getFightCats(),catService.getCats());
        System.out.println();
        while (catService.getCatHealth(DiceGame.fighterName2(catService.getFightCats())) > 0
                && catService.getCatHealth(DiceGame.fighterName1(catService.getFightCats())) > 0) {
            SavedGame.saved(catService.getByName(DiceGame.fighterName1(catService.getFightCats())),
                    catService.getByName(DiceGame.fighterName2(catService.getFightCats())));
            Attack.singleAttack(catService.getByName(DiceGame.fighterName2(catService.getFightCats())),
                    catService.getByName(DiceGame.fighterName1(catService.getFightCats())));
            Attack.singleAttack(catService.getByName(DiceGame.fighterName1(catService.getFightCats())),
                    catService.getByName(DiceGame.fighterName2(catService.getFightCats())));
        }
        SavedGame.gameContinued();
    }
}


