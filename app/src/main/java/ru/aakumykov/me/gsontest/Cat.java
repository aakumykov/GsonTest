package ru.aakumykov.me.gsontest;

import java.util.Map;

public class Cat {

    private String name;
    private int age;
    private String color;
    private Flea[] fleas;
    private Map<String,Kitten> kittenMap;

    Cat(){}

    @Override
    public String toString() {
        return "Кошка { name: "+ name+
                ", age: "+age+
                ", color: "+color+
                ", fleas: "+fleas.getClass().getSimpleName()+"["+fleas.length+"]"+
                ", kittens: "+kittenMap.getClass().getSimpleName()+"("+kittenMap.size()+")"+
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

    public void setFleas(Flea[] fleas) {
        this.fleas = fleas;
    }

    public Map<String, Kitten> getKittenMap() {
        return kittenMap;
    }

    public void setKittenMap(Map<String, Kitten> kittenMap) {
        this.kittenMap = kittenMap;
    }
}