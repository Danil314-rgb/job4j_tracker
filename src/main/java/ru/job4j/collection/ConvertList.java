package ru.job4j.collection;

import java.util.ArrayList;
import java.util.List;

public class ConvertList {

    public static List<Integer> convert(List<int[]> list) {
        List<Integer> rsl = new ArrayList<>();
        for (int[] item : list) {
            for (int res : item) {
                rsl.add(res);
            }
        }
        return rsl;
    }
}
