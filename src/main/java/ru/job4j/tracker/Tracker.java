package ru.job4j.tracker;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items[index] : null;
    }

    private int indexOf(int id) {
        int result = -1;
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
                result = index;
                break;
            }
        }
        return result;
    }

    public Item[] findByName(String key) {
        Item[] result = new Item[items.length];
        for (int index = 0; index < items.length; index++) {
            Item item = items[index];
            if (items[index] != null && item.getName().equals(key)) {
                result[index] = item;
                size++;
            }
        }
        result = Arrays.copyOf(result, size);
        return result;
    }

    public Item[] findAll() {
        Item[] itemNotNull = new Item[items.length];
        for (int i = 0; i < items.length; i++) {
            Item item = items[i];
            if (item != null) {
                itemNotNull[i] = item;
                size++;
            }
        }
        itemNotNull = Arrays.copyOf(itemNotNull, size);
        for (int i = 0; i < itemNotNull.length; i++) {
            System.out.println(itemNotNull[i]);
        }
        return itemNotNull;
    }

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        if (index > 0) {

            return true;
        }
        return false;
    }
}