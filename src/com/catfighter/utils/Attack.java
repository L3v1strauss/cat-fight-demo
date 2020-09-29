package com.catfighter.utils;

import com.catfighter.api.services.ICatService;
import com.catfighter.entities.Cat;
import com.catfighter.services.CatService;

public class Attack {

    ICatService catService = new CatService();
    CriticalStrike crit = new CriticalStrike();
    public int firstAttacker;

    public void singleAttack(String name1, String name2) {
        if (crit.isCriticalChance(name1) && catService.getCatHealth(name2) > 0
                && catService.getCatHealth(name2) <= crit.criticalStrike(name1)) {
            catService.updateCatHealth(name2, 0);
            System.out.println(name1 + " одерживает победу");
        } else if (catService.getCatHealth(name2) > 0
                && catService.getCatHealth(name2) <= catService.getCatDamage(name1)) {
            catService.updateCatHealth(name2, 0);
            System.out.println(name1 + " одерживает победу");
        } else if (crit.isCriticalChance(name1)) {
            System.out.println(name1 + " аттакует и наносит критический урон "
                    + crit.criticalStrike(name1));
            catService.updateCatHealth(name2, catService.getCatHealth(name2)
                    - crit.criticalStrike(name1));
        } else {
            System.out.println(name1 + " аттакует и наносит урон " + catService.getCatDamage(name1));
            catService.updateCatHealth(name1, catService.getCatHealth(name2) - catService.getCatDamage(name1));
        }
    }


}
