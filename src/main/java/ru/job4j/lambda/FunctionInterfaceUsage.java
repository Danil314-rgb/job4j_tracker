package ru.job4j.lambda;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.BinaryOperator;
import java.util.function.Supplier;

public class FunctionInterfaceUsage {

    @FunctionalInterface
    public interface Consumer<T> {
        void accept(T t);
    }

    @FunctionalInterface
    public interface BiConsumer<T, U> {
        void accept(T t, U u);
    }

    @FunctionalInterface
    public interface Predicate<T> {
        boolean test(T t);
    }

    @FunctionalInterface
    public interface BiPredicate<T, U> {
        boolean test(T t, U u);
    }

    @FunctionalInterface
    public interface Function<T, R> {
        R apply(T t);
    }

    @FunctionalInterface
    public interface BiFunction<T, U, R> {
        R apply(T t, U u);
    }

    @FunctionalInterface
    public interface UnaryOperator<T> extends Function<T, T> { }

    @FunctionalInterface
    public interface BiUnaryOperator<T> extends BiFunction<T, T, T> { }

    public static void main(String[] args) {
        Supplier<String> sup = () -> "New String For Interface";
        Consumer<String> consumer = (s) -> System.out.println(s);
        consumer.accept(sup.get());

        /*Supplier<String> sup1 = () -> "New String For Interface";
        BiConsumer<String, String> consumer1 = (s, s1) -> System.out.println(s + s1);
        consumer1.accept(sup.get(), " and Second String");*/

        /*List<String> list = List.of("one", "two", "three", "one", "two", "three");
        Supplier<Set<String>> sup = () -> new HashSet<>(list);
        BiConsumer<Integer, String> consumer = (s, s1) -> System.out.println(s + s1);
        Set<String> strings = sup.get();
        int i = 1;
        for (String s : strings) {
            consumer.accept(i++, " is " + s);
        }*/

        /*Predicate<String> pred = s -> s.isEmpty();
        System.out.println("Строка пустая: " + pred.test(""));
        System.out.println("Строка пустая: " + pred.test("test"));

        BiPredicate<String, Integer> cond = (s, i) -> s.contains(i.toString());
        System.out.println("Строка содержит подстроку: " + cond.test("Name123", 123));
        System.out.println("Строка содержит подстроку: " + cond.test("Name", 123));*/

        /*Function<String, Character> func = s -> s.charAt(2);
        System.out.println(func.apply("first"));
        System.out.println(func.apply("second"));*/

        /*BiFunction<String, Integer, String> biFunc = (s, i) -> s.concat(" ").concat(i.toString());
        System.out.println("Результат работы бифункции: " + biFunc.apply("Name", 123));
        System.out.println("Результат работы бифункции: " + biFunc.apply("String number", 12345));*/

        /*UnaryOperator<StringBuilder> builder = b -> b.reverse();
        System.out.println("Строка после реверса: " + builder.apply(new StringBuilder("String for test")));
        System.out.println("Строка после реверса: " + builder.apply(new StringBuilder("tset rof gnirtS")));*/

        BinaryOperator<StringBuilder> builder = (b1, b2) -> b1.append(" ").append(b2);
        System.out.println(
                "Строка после объединения: " + builder.apply(
                        new StringBuilder("First string"),
                        new StringBuilder("Second string")
                )
        );
    }
}