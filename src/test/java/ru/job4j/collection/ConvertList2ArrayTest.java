package ru.job4j.collection;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ConvertList2ArrayTest {

    @Test
    public void whenArray() {
        int[][] result = ConvertList2Array.toArray(Arrays.asList(1, 2, 3, 4, 5, 6, 7), 3);
        int[][] expected = {{1, 2, 3}, {4, 5, 6}, {7, 0, 0}};
        assertThat(result, is(expected));
    }
}