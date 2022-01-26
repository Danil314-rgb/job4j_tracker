package ru.job4j.tracker.mem.tracker.action;

import ru.job4j.tracker.mem.Store;
import ru.job4j.tracker.mem.tracker.input.Input;
import ru.job4j.tracker.mem.tracker.model.Item;
import ru.job4j.tracker.mem.tracker.output.Output;

import java.util.List;

public class FindAllAction implements UserAction {

    private final Output out;

    public FindAllAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Show all items ====";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        List<Item> items = tracker.findAll();
        for (Item item : items) {
            out.println(item);
        }
        return true;
    }

}
