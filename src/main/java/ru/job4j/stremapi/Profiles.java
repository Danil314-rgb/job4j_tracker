package ru.job4j.stremapi;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Profiles {

    public List<Address> collect(List<Profile> profiles) {

        return profiles.stream()
                .map(Profile::getAddress)
                .collect(Collectors.toList()
                );
    }

    public List<Address> doubleColl(List<Profile> profiles) {
        return profiles.stream()
                .map(Profile::getAddress)
                .sorted(Comparator.comparing(Address::getCity).thenComparing(Address::getStreet))
                .distinct()
                .collect(Collectors.toList()
                );
    }
}
