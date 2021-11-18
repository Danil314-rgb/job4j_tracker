package ru.job4j.stremapi;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ProfilesTest {

    @Test
    public void whenAddress() {
        Address address1 = new Address("Moscow", "Red", 15, 55);
        Address address2 = new Address("Moscow", "Green", 56, 78);

        List<Profile> profiles = List.of(new Profile());

    }

}