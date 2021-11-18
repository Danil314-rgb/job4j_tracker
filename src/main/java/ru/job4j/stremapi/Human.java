package ru.job4j.stremapi;

public class Human {

    private String name;
    private String surname;
    private byte age;
    private double weight;
    private double height;
    private boolean children;
    private boolean job;

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", weight=" + weight +
                ", height=" + height +
                ", children=" + children +
                ", job=" + job +
                '}';
    }

    static class Builder {
        private String name;
        private String surname;
        private byte age;
        private double weight;
        private double height;
        private boolean children;
        private boolean job;

        Builder buildName(String name) {
            this.name = name;
            return this;
        }

        Builder buildSurname(String surname) {
            this.surname = surname;
            return this;
        }

        Builder buildAge(byte age) {
            this.age = age;
            return this;
        }

        Builder buildWeight(double weight) {
            this.weight = weight;
            return this;
        }

        Builder buildHeight(double height) {
            this.height = height;
            return this;
        }

        Builder buildChildren(boolean children) {
            this.children = children;
            return this;
        }

        Builder buildJob(boolean job) {
            this.job = job;
            return this;
        }

        Human build() {
            Human human = new Human();
            human.name = name;
            human.surname = surname;
            human.age = age;
            human.weight = weight;
            human.height = height;
            human.children = children;
            human.job = job;
            return human;
        }

        public static void main(String[] args) {
            Human human = new Builder().buildName("Dan")
                    .buildSurname("Bod")
                    .buildAge((byte) 21)
                    .buildWeight(77)
                    .buildHeight(165)
                    .buildChildren(false)
                    .buildJob(false)
                    .build();
            System.out.println(human);

        }
    }
}
