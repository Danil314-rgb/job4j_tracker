package ru.job4j.stremapi;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class MatrixTransformTest {

    @Test
    public void whenTwoMatrix() {
        Integer[][] arr = {
                {1, 2},
                {3, 4}
        };
        List<Integer> res = MatrixTransform.matrixTransform(arr);
        List<Integer> expected = List.of(1, 2, 3, 4);
        assertThat(res, is(expected));
    }

    @Test
    public void whenThreeMatrix() {
        Integer[][] arr = {
                {1, 2},
                {3, 4},
                {5, 6, 7}
        };
        List<Integer> res = MatrixTransform.matrixTransform(arr);
        List<Integer> expected = List.of(1, 2, 3, 4, 5, 6, 7);
        assertThat(res, is(expected));
    }
}