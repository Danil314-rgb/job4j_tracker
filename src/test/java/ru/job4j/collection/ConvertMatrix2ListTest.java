package ru.job4j.collection;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ConvertMatrix2ListTest {

    @Test
    public void when() {
        ConvertMatrix2List list = new ConvertMatrix2List();
        int[][] input = {{1, 2}, {3, 4}};
        List<Integer> expected = List.of(1, 2, 3, 4);
        List<Integer> result = list.toList(input);
        assertThat(result, is(expected));
    }

}