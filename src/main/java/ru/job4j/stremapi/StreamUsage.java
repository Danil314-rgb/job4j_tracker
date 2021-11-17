package ru.job4j.stremapi;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamUsage {

    public static void main(String[] args) {
        List<Integer> list = List.of(
                1, 2, 3, 0, -1, -3, -99, 4
        );

        List<Integer> filterList = list.stream().filter(
                filter -> filter > 0
        ).collect(Collectors.toList());
        filterList.forEach(System.out::println);

    }

}
