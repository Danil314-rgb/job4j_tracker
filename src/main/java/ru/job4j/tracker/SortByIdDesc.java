package ru.job4j.tracker;

import java.util.Comparator;

public class SortByIdDesc implements Comparator<Item> {

    @Override
    public int compare(Item first, Item second) {
        return Integer.compare(second.getId(), first.getId());
    }
}
