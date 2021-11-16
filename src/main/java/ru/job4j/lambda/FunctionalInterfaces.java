package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.*;

public class FunctionalInterfaces {

    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        BiConsumer<Integer, String> biCon = (i, s) -> map.put(i, s);
        List<String> list = List.of("one", "two", "three", "four", "five", "six", "seven");
        int it = 1;
        for (String item : list) {
            biCon.accept(it++, item);
        }

        BiPredicate<Integer, String> biPred = (i, s) -> (i % 2 == 0 || s.length() == 4);
        for (Integer i : map.keySet()) {

            if (biPred.test(i, map.get(i))) {
                System.out.println("key: " + i + " value: " + map.get(i));
            }
        }

        Supplier<List<String>> sup = () -> new ArrayList<String>(map.values());
        Consumer<String> con = (s) -> System.out.println(s);
        Function<String, String> func = s -> s.toUpperCase();
        for (String s : sup.get()) {
            con.accept(func.apply(s));
        }
    }
}
