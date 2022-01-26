package ru.job4j.tracker.mem.tracker.action;

import ru.job4j.tracker.mem.tracker.input.Input;
import ru.job4j.tracker.mem.tracker.model.Item;
import ru.job4j.tracker.mem.tracker.output.Output;
import ru.job4j.tracker.mem.tracker.store.MemTracker;

public class CreateAction implements UserAction {

    private final Output out;

    public CreateAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Create a new Item ====";
    }

    @Override
    public boolean execute(Input input, MemTracker tracker) {
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        tracker.add(item);
        out.println("Item successfully added!");
        return true;
    }
}
