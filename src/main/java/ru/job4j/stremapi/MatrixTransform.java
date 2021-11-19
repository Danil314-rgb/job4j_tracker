package ru.job4j.stremapi;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MatrixTransform {

    public static List<Integer> matrixTransform(List<List<Integer>> list) {
        return Stream.of(list).flatMap(List::stream).flatMap(List::stream).collect(Collectors.toList());
    }
}
