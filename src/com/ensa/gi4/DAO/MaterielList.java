package com.ensa.gi4.DAO;

import com.ensa.gi4.modele.Chaise;
import com.ensa.gi4.modele.Livre;
import com.ensa.gi4.modele.Materiel;

import java.util.ArrayList;

public class MaterielList {
    public ArrayList<Materiel> list = new ArrayList<>();
    public MaterielList(){
        list.add(new Livre(1,"Livre1"));
        list.add(new Chaise(2,"Chaise1"));
    }


    public ArrayList<Materiel> getList() {
        return list;
    }

    public void setList(ArrayList<Materiel> list) {
        this.list = list;
    }
}
