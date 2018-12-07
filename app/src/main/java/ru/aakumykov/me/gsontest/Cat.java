package ru.aakumykov.me.gsontest;

import java.util.List;
import java.util.Map;

public class Cat {

    private Map<String,List<Kitten>> kittenMap;

    Cat(){}

    @Override
    public String toString() {
        return "Кошка { name: "+
                ", kittens: "+kittenMap.getClass().getSimpleName()+"("+kittenMap.size()+")"+
        " }";
    }


    public Map<String, List<Kitten>> getKittenMap() {
        return kittenMap;
    }

    public void setKittenMap(Map<String, List<Kitten>> kittenMap) {
        this.kittenMap = kittenMap;
    }
}