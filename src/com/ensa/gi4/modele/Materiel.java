package com.ensa.gi4.modele;

public abstract class Materiel {
    private String name;
    private int id;

    public Materiel(int id, String name) {
        this.name = name;
        this.id = id;
    }
    public Materiel() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
