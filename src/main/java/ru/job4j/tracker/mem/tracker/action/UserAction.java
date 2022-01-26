package ru.job4j.tracker.mem.tracker.action;

import ru.job4j.tracker.mem.tracker.input.Input;
import ru.job4j.tracker.mem.tracker.store.MemTracker;

public interface UserAction {
    String name();

    boolean execute(Input input, MemTracker tracker);
}
