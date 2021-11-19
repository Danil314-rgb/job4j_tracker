package ru.job4j.stremapi;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StudentLevelTest {

    @Test
    public void whenSorted() {
        List<Student> students = new ArrayList<>();
        students.add(new Student(28, "Masha"));
        students.add(new Student(55, "Petr"));
        List<Student> expected = List.of(
                new Student(28, "Masha"),
                new Student(55, "Petr")
        );
        assertThat(StudentLevel.levelOf(students, 25), is(expected));
    }

    @Test
    public void whenOnlyNull() {
        List<Student> input = new ArrayList<>();
        input.add(null);
        List<Student> expected = List.of();
        assertThat(StudentLevel.levelOf(input, 100), is(expected));
    }

    @Test
    public void whenHasNull() {
        List<Student> input = new ArrayList<>();
        input.add(null);
        input.add(new Student(28, "Pety"));
        List<Student> expected = List.of(new Student(28, "Pety"));
        assertThat(StudentLevel.levelOf(input, 10), is(expected));
    }

}