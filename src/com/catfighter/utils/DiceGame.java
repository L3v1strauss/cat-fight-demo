package com.catfighter.utils;

import com.catfighter.entities.Cat;

import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class DiceGame {

    public static int rollDice() throws RuntimeException {
        Random random = new Random();
        int x = random.nextInt(12);
        try {
            zero(x);
        } catch (RuntimeException exception) {
            System.out.println("У одного из котов кости упали на ребро");
            exception.printStackTrace();
        }
        return x;

    }

    public static void zero(int value) {
        if (value == 0) {
            throw new RuntimeException();
        }

    }

    public static void whosFighters(List<Cat> cats, List<Cat> fightCats) {
        cats.stream()
                .sorted(Comparator.comparing(Cat::getDiceSide))
                .forEach(x -> System.out.format("%s кинул кости и кости показали %d%n", x.getName(), x.getDiceSide()));
        System.out.println();
        fightCats.add((cats.stream()
                .sorted(Comparator.comparing(Cat::getDiceSide))
                .limit(1)
                .peek(x -> System.out.format("Первым бойцом назначен %s%n%n", x.getName()))
                .min(Comparator.comparing(Cat::getDiceSide))
                .orElse(null)));
        fightCats.add((cats.stream()
                .sorted(Comparator.comparing(Cat::getDiceSide))
                .skip(1)
                .limit(1)
                .peek(x -> System.out.format("Вторым бойцом назначен %s%n%nПервым аттакует %s", x.getName(), x.getName()))
                .min(Comparator.comparing(Cat::getDiceSide))
                .orElse(null)));

    }
}
