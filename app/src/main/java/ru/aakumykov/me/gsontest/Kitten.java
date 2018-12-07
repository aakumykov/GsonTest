package ru.aakumykov.me.gsontest;

public class Kitten {

    private String name;

    public Kitten(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Котёнок { имя: "+name+" }";
    }
}
