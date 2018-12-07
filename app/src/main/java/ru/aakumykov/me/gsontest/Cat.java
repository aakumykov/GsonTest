package ru.aakumykov.me.gsontest;

import java.util.List;
import java.util.Map;

public class Cat {

    private String name;
    private int age;
    private String color;
    private Map<String,List<Kitten>> kittenMap;

    Cat(){}

    @Override
    public String toString() {
        return "Кошка { name: "+ name+
                ", age: "+age+
                ", color: "+color+
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

    public Map<String, List<Kitten>> getKittenMap() {
        return kittenMap;
    }

    public void setKittenMap(Map<String, List<Kitten>> kittenMap) {
        this.kittenMap = kittenMap;
    }
}