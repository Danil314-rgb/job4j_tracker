package ru.job4j.stremapi;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class School {

    public List<Student> collect(List<Student> students, Predicate<Student> predicate) {
        return students.stream()
                .filter(predicate)
                .collect(Collectors.toList()
                );
    }

    public Map<String, Student> transformation(List<Student> students) {
        return students.stream().collect(Collectors.toMap(
                Student::getSurname, student -> student, (k1, k2) -> k1)
        );
    }

}
