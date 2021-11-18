package ru.job4j.stremapi;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MatrixTransform {

    public static List<Integer> matrixTransform(List<List<Integer>> list) {
        return list.stream().flatMap(l -> l.stream()).collect(Collectors.toList());
    }
}
