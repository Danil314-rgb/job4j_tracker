package ru.job4j.stremapi.att;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Analyze {

    public static double averageScore(Stream<Pupil> stream) {
        return stream.flatMap(s -> s.getSubjects().stream())
                .mapToInt(Subject::getScore)
                .average()
                .orElse(0D);
    }

    public static List<Tuple> averageScoreBySubject(Stream<Pupil> stream) {
        return stream.map(t -> new Tuple(t.getName(),
                        t.getSubjects()
                                .stream()
                                .mapToInt(Subject::getScore)
                                .average()
                                .orElse(0D)))
                .collect(Collectors.toList());
    }

    public static List<Tuple> averageScoreByPupil(Stream<Pupil> stream) {
        return stream.flatMap(s -> s.getSubjects().stream())
                .collect(Collectors.groupingBy(Subject::getName, LinkedHashMap::new,
                        Collectors.averagingDouble(Subject::getScore)))
                .entrySet()
                .stream()
                .map(t -> new Tuple(t.getKey(), t.getValue()))
                .collect(Collectors.toList());
    }

    public static Tuple bestStudent(Stream<Pupil> stream) {
        return stream.map(t -> new Tuple(t.getName(),
                        t.getSubjects()
                                .stream()
                                .mapToInt(Subject::getScore)
                                .sum()))
                .max(Comparator.comparing(Tuple::getScore)).orElse(null);
    }

    public static Tuple bestSubject(Stream<Pupil> stream) {
        return stream.flatMap(s -> s.getSubjects().stream())
                .collect(Collectors.groupingBy(Subject::getName,
                        Collectors.summingDouble(Subject::getScore)))
                .entrySet()
                .stream()
                .map(t -> new Tuple(t.getKey(), t.getValue()))
                .max(Comparator.comparing(Tuple::getScore))
                .orElse(null);
    }
}
