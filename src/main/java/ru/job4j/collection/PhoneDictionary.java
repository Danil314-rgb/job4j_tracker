package ru.job4j.collection;

import java.util.ArrayList;

public class PhoneDictionary {

    private ArrayList<Person> persons = new ArrayList<Person>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        ArrayList<Person> result = new ArrayList<>();
        for (Person item : persons) {
            if (item.getName().contains(key) || item.getSurname().contains(key)
                    || item.getPhone().contains(key) || item.getAddress().contains(key)) {
                result.add(item);
            }
        }
        return result;
    }
}
