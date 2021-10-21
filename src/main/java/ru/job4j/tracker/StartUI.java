package ru.job4j.tracker;


import java.time.format.DateTimeFormatter;
//import java.util.Scanner;

public class StartUI {

    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            showMenu();
            String str = "Select: ";
            int select = Integer.parseInt(input.askStr(str));
            if (select == 0) {
                System.out.println("=== Create a new Item ===");
                String msg = "Enter name: ";
                String name = input.askStr(msg);
                Item item = new Item(name);
                tracker.add(item);
                System.out.println("Добавленная заявка: " + item);
            } else if (select == 1) {
                System.out.println("=== Show all items ===");
                Item[] items = tracker.findAll();
                if (items.length > 0) {
                    for (Item item : items) {
                        System.out.println(item);
                    }
                } else {
                    System.out.println("Хранилище еще не содержит заявок");
                }
            } else if (select == 2) {
                System.out.println("=== Edit item ===");
                String msg = "Enter id: ";
                int id = Integer.parseInt(input.askStr(msg));
                System.out.println("Enter name: ");
                String name = input.askStr(msg);
                Item item = new Item(name);
                if (tracker.replace(id, item)) {
                    System.out.println("Заявка изменена успешно");
                } else {
                    System.out.println("Ошибка замены заявки");
                }
            } else if (select == 3) {
                System.out.println("=== Delete item ===");
                String msg = "Enter id: ";
                int id = Integer.parseInt(input.askStr(msg));
                if (tracker.delete(id)) {
                    System.out.println("Заявку успешно удалена");
                } else {
                    System.out.println("Ошибка удаления заявки");
                }
            } else if (select == 4) {
                System.out.println("=== Find item by id ===");
                String msg = "Enter id: ";
                int id = Integer.parseInt(input.askStr(msg));
                Item item = tracker.findById(id);
                if (item != null) {
                    System.out.println(item);
                } else {
                    System.out.println("Заявка с введенным id: " + id + " не найдена");
                }
            } else if (select == 5) {
                System.out.println("=== Find items by name ===");
                String msg = "Enter name: ";
                String name = input.askStr(msg);
                Item[] items = tracker.findByName(name);
                if (items.length > 0) {
                    for (Item item : items) {
                        System.out.println(item);
                    }
                } else {
                    System.out.println("Заявка с введенным name: " + name + " не найдена");
                }
            } else if (select == 6) {
                run = false;
            }
        }
    }

    private void showMenu() {
        String[] menu = {
                "Add new Item", "Show all items", "Edit item",
                "Delete item", "Find item by id", "Find items by name",
                "Exit Program"
        };
        System.out.println("Menu:");
        for (int i = 0; i < menu.length; i++) {
            System.out.println(i + ". " + menu[i]);
        }

    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);

    }
}
