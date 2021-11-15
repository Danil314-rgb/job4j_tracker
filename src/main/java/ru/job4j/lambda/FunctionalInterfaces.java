package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.*;

public class FunctionalInterfaces {

    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        BiConsumer<Integer, String> biCon = (b, b1) -> map.put(b, b1);
        List<String> list = List.of("one", "two", "three", "four", "five", "six", "seven");
        int it = 1;
        for (String item : list) {
            biCon.accept(it++, item);
        }

        BiPredicate<Integer, String> biPred = (u, s) -> (u % 2 == 0 || s.length() == 4);
        for (Integer i : map.keySet()) {

            if (biPred.test(i, map.get(i))) {
                System.out.println("key: " + i + " value: " + map.get(i));
            }
        }

        Supplier<List<String>> sup = () -> new ArrayList<String>(map.values());
        List<String> strings = new ArrayList<>(sup.get());

        Consumer<String> con = (s) -> System.out.println(s);
        Function<String, String> func = s -> s.toUpperCase();
        for (String s : strings) {
            con.accept(func.apply(s));
        }
    }
}
