package ru.job4j.stremapi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MatrixTransform {

    public static List<Integer> matrixTransform(Integer[][] arr) {
        return Stream.of(arr).flatMap(Arrays::stream).collect(Collectors.toList());
    }
}
