package ru.aakumykov.me.gsontest;

public class Flea {

    private String name;
    private int size;

    // TODO: попробовать пустой конструктор
    Flea(String name, int size) {
        this.name = name;
        this.size = size;
    }


    @Override
    public String toString() {
        return "Блоха { name: "+name+
                ", size: "+size+
                " }";
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
