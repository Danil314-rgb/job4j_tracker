package ru.job4j.stremapi;

public class Profile {

    public Profile(Address address) {
        this.address = address;
    }

    private Address address;

    public Address getAddress() {
        return address;
    }
}
