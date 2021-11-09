package ru.job4j.tracker;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SortByIdItemTest {

    @Test
    public void whenSortAscend() {
        List<Item> items = Arrays.asList(
                new Item(1, "test1"),
                new Item(4, "test4"),
                new Item(3, "test3")
        );

        List<Item> expected = Arrays.asList(
                new Item(1, "test1"),
                new Item(3, "test3"),
                new Item(4, "test4")
        );
        Collections.sort(items, new SortByIdAsc());
        assertEquals(expected, items);
    }

    @Test
    public void whenSortDecrease() {
        List<Item> items = Arrays.asList(
                new Item(1, "test1"),
                new Item(4, "test4"),
                new Item(3, "test3")
        );

        List<Item> expected = Arrays.asList(
                new Item(4, "test4"),
                new Item(3, "test3"),
                new Item(1, "test1")
        );
        Collections.sort(items, new SortByIdDesc());
        assertEquals(expected, items);
    }
}