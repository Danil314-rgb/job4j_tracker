package ru.job4j.tracker.mem.tracker.action;

import ru.job4j.tracker.mem.Store;
import ru.job4j.tracker.mem.tracker.input.Input;
import ru.job4j.tracker.mem.tracker.model.Item;
import ru.job4j.tracker.mem.tracker.output.Output;

public class ReplaceAction implements UserAction {

    private final Output out;

    public ReplaceAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Edit item ====";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        int id = Integer.parseInt(input.askStr("Enter id: "));
        String name = input.askStr("Enter name: ");
        if (tracker.replace(id, new Item(name))) {
            out.println("Item is successfully replaced!");
        } else {
            out.println("Wrong id!");
        }
        return true;
    }
}
