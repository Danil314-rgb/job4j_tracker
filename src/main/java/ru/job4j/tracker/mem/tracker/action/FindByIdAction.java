package ru.job4j.tracker.mem.tracker.action;

import ru.job4j.tracker.mem.tracker.input.Input;
import ru.job4j.tracker.mem.tracker.model.Item;
import ru.job4j.tracker.mem.tracker.output.Output;
import ru.job4j.tracker.mem.tracker.store.MemTracker;

public class FindByIdAction implements UserAction {

    private final Output out;

    public FindByIdAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Find item by Id ====";
    }

    @Override
    public boolean execute(Input input, MemTracker tracker) {
        int id = Integer.parseInt(input.askStr("Enter id: "));
        Item item = tracker.findById(id);
        if (item != null) {
            out.println(item);
        } else {
            out.println("Wrong id! Not found");
        }
        return true;
    }
}
