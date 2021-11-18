package ru.job4j.stremapi;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class MatrixTransformTest {

    @Test
    public void whenTwoListInList() {
        List<List<Integer>> list = List.of(
                List.of(1, 2),
                List.of(3, 4)
        );
        List<Integer> res = MatrixTransform.matrixTransform(list);
        List<Integer> expected = List.of(1, 2, 3, 4);
        assertThat(res, is(expected));
    }

    @Test
    public void whenThreeLstInList() {
        List<List<Integer>> list = List.of(
                List.of(1, 2),
                List.of(3, 4),
                List.of(5, 6, 7)
        );
        List<Integer> res = MatrixTransform.matrixTransform(list);
        List<Integer> expected = List.of(1, 2, 3, 4, 5, 6, 7);
        assertThat(res, is(expected));
    }
}