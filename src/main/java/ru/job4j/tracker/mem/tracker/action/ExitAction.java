package ru.job4j.tracker.mem.tracker.action;

import ru.job4j.tracker.mem.Store;
import ru.job4j.tracker.mem.tracker.input.Input;

public class ExitAction implements UserAction {
    @Override
    public String name() {
        return "=== Exit ====";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        return false;
    }
}
