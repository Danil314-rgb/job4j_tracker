package ru.job4j.tracker;


import java.time.format.DateTimeFormatter;

public class StartUI {

    public static void main(String[] args) {

        Item item = new Item();
        item.getCreated();

        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
        String currentDateTimeFormat = item.getCreated().format(format);
        System.out.println("Текущая дата и время: " + currentDateTimeFormat);
    }
}
