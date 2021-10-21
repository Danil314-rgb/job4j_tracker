package ru.job4j.tracker;

public class Bus implements Transport {

    @Override
    public void drive() {
        System.out.println("Едем на автобусе");
    }

    @Override
    public void passengers(int passengers) {
        System.out.println("В автобесе едет " + passengers + " человек");
    }

    @Override
    public double refuel(double count) {
        return  count * 52;
    }
}
