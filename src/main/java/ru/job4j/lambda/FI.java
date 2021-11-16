package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class FI {

    public static List<Double> diapason(int start, int end, Function<Double, Double> func) {
        List<Double> db = new ArrayList<>();
        double number = 0;
        for (double i = start; i < end; i++) {
            number = func.apply(i);
            db.add(number);
        }
        return db;
    }
}
