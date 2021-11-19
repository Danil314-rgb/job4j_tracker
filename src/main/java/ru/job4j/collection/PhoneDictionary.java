package ru.job4j.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Predicate;

public class PhoneDictionary {

    private ArrayList<Person> persons = new ArrayList<Person>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        Predicate<Person> predicateName = n -> n.getName().contains(key);
        Predicate<Person> predicateSurname = s -> s.getSurname().contains(key);
        Predicate<Person> predicatePhone = p -> p.getPhone().contains(key);
        Predicate<Person> predicateAddress = a -> a.getAddress().contains(key);

        Predicate<Person> combine = predicateName.or(predicateSurname).or(predicatePhone).or(predicateAddress);
        ArrayList<Person> result = new ArrayList<>();
        for (var person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}
