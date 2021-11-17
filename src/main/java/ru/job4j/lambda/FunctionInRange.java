package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class FunctionInRange {

    public static List<Double> diapason(int start, int end, Function<Double, Double> func) {
        List<Double> db = new ArrayList<>();
        for (int i = start; i < end; i++) {
            db.add(func.apply((double) i));
        }
        return db;
    }
}
