package ru.job4j.tracker;

public interface Transport {

    void drive();

    void passengers(int passengers);

    double refuel(double count);
}
