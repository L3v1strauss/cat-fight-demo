package com.catfighter.utils;

import com.catfighter.Exceptions.DiceGameException;
import com.catfighter.entities.Cat;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DiceGame {

    public static int rollDice() {
        Random random = new Random();
        int x = random.nextInt(12);
        try {
            zero(x);
        } catch (DiceGameException exception) {
            System.out.println("У одного из котов кости упали на ребро");
        }
        return x;

    }

    public static void zero(int value) throws DiceGameException {
        if (value == 0) {
            throw new DiceGameException("Error");
        }

    }

    public static void nameCats(List<Cat> cats) throws IOException {
        Path path = Path.of("resources", "names", "Names.txt");
        Stream<String> lines = Files.lines(path);
        List<String> names = new ArrayList<>();
        lines.forEach(names::add);
        int skipCounter = 0;
        for (Cat cat : cats) {
            cat.setName(names.stream()
                    .filter(Pattern.compile("[a-zA-Z]+").asPredicate())
                    .skip(skipCounter++)
                    .limit(1)
                    .collect(Collectors.joining()));
        }

    }

    public static void thatFighters(Map<Cat, Integer> fightCats, List<Cat> cats) {
        for (Cat cat : cats) {
            fightCats.put(cat, rollDice());
        }
        fightCats.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .forEach(x -> System.out.format("%s кинул кости и кости показали %d%n",
                        x.getKey().getName(), x.getValue()));
        String fighterName1 = fightCats.entrySet().stream().sorted(Map.Entry.comparingByValue())
                .limit(1).map(x -> x.getKey().getName())
                .collect(Collectors.joining());
        System.out.println("На арену выходит " + fighterName1);
        String fighterName2 = fightCats.entrySet().stream().sorted(Map.Entry.comparingByValue())
                .skip(1).limit(1).map(x -> x.getKey().getName())
                .collect(Collectors.joining());
        System.out.println("На арену выходит " + fighterName2);
    }

    public static String fighterName1(Map<Cat, Integer> fightCats) {
        return fightCats.entrySet().stream().sorted(Map.Entry.comparingByValue())
                .limit(1).map(x -> x.getKey().getName())
                .collect(Collectors.joining());
    }

    public static String fighterName2(Map<Cat, Integer> fightCats) {
        return fightCats.entrySet().stream().sorted(Map.Entry.comparingByValue())
                .skip(1).limit(1).map(x -> x.getKey().getName())
                .collect(Collectors.joining());
    }
}
