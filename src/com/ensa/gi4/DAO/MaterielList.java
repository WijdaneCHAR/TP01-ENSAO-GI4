package com.ensa.gi4.DAO;

import com.ensa.gi4.modele.Chaise;
import com.ensa.gi4.modele.Livre;
import com.ensa.gi4.modele.Materiel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
@Component("materielList")
public class MaterielList {
    public ArrayList<Materiel> list = new ArrayList<>();
    public MaterielList(){
    }


    public ArrayList<Materiel> getList() {
        return list;
    }

    public void setList(ArrayList<Materiel> list) {
        this.list = list;
    }
}
