package ru.job4j.tracker.mem.tracker.action;

import ru.job4j.tracker.mem.Store;
import ru.job4j.tracker.mem.tracker.input.Input;

public interface UserAction {
    String name();

    boolean execute(Input input, Store tracker);
}
