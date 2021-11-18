package ru.job4j.stremapi;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ProfilesTest {

    @Test
    public void whenAddress() {
        Address address1 = new Address("Moscow", "Red", 15, 55);
        Address address2 = new Address("Moscow", "Green", 56, 78);
        Profile profile1 = new Profile(address1);
        Profile profile2 = new Profile(address2);
        List<Profile> listProf = List.of(profile1, profile2);

        Profiles profiles = new Profiles();
        List<Address> res = profiles.collect(listProf);
        List<Address> expected = List.of(address1, address2);
        assertThat(res, is(expected));
    }

    @Test
    public void whenAddressSort() {
        Address address1 = new Address("Moscow", "Red", 15, 55);
        Address address2 = new Address("Moscow", "Green", 56, 78);
        Address address3 = new Address("Moscow", "Red", 15, 55);
        Address address4 = new Address("Moscow", "Green", 56, 78);
        Profile profile1 = new Profile(address1);
        Profile profile2 = new Profile(address2);
        Profile profile3 = new Profile(address3);
        Profile profile4 = new Profile(address4);
        List<Profile> listProf = List.of(profile1, profile2, profile3, profile4);

        Profiles profiles = new Profiles();
        List<Address> result = profiles.doubleColl(listProf);
        List<Address> expected = List.of(address2, address1);
        assertThat(result, is(expected));
    }
}