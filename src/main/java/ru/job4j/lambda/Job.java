package ru.job4j.lambda;

public class Job implements Comparable<Job> {

    private String name;
    private int priority;

    public Job(String name, int property) {
        this.name = name;
        this.priority = property;
    }

    public String getName() {
        return name;
    }

    public int getPriority() {
        return priority;
    }

    @Override
    public String toString() {
        return "Job{" + name + ", " + priority + '}';
    }

    @Override
    public int compareTo(Job another) {
        return Integer.compare(priority, another.priority);
    }
}
