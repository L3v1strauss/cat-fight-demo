package com.catfighter.utils;

import com.catfighter.entities.Cat;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Names {

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
}
