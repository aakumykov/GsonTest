package ru.aakumykov.me.gsontest;

public class Cat {

    private String name;
    private int age;
    private String color;
    private Flea[] fleas;

    Cat(){}

    @Override
    public String toString() {
        return "Кошка { name: "+ name+
                ", age: "+age+
                ", color: "+color+
                ", fleas: "+fleas.getClass().getSimpleName()+"["+fleas.length+"]"+
                " }";
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Flea[] getFleas() {
        return fleas;
    }

    public void setFlea(Flea[] fleas) {
        this.fleas = fleas;
    }
}