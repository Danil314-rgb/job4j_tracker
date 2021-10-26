package ru.job4j.tracker;

import java.util.Arrays;

public final class SingleTracker {

    private static Tracker tracker = new Tracker();

    private SingleTracker() {

    }

    public static Tracker getInstance() {
        if (tracker == null) {
            tracker = new Tracker();
        }
        return tracker;
    }

    public Item add(Item item) {
        return tracker.add(item);
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index == -1 ? null : tracker.findById(id);
    }

    public int indexOf(int id) {
        return id;
    }

    public Item[] findByName(String key) {
        return null;
    }

    public Item[] findAll() {
        return null;
    }

    public boolean replace(int id, Item item) {
        return false;
    }

    public boolean delete(int id) {
        return false;
    }
}
