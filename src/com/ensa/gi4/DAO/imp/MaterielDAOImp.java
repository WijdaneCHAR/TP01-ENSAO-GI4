package com.ensa.gi4.DAO.imp;

import com.ensa.gi4.DAO.MaterielList;
import com.ensa.gi4.DAO.api.MaterielDAO;
import com.ensa.gi4.modele.Materiel;

import java.util.ArrayList;

public class MaterielDAOImp implements MaterielDAO {
    MaterielList malist = null;

    private MaterielDAOImp materielDAOImp = null;
    public MaterielDAOImp(MaterielList malist) {
     this.malist = malist;
    }

    @Override
    public void lister() {
        System.out.println("-------------- Liste des materiels : --------------");
        for (int i = 0; i < malist.getList().size(); i++) {
            System.out.println(malist.getList().get(i).getId() + " : " + malist.getList().get(i).getName());
        }
    }

    @Override
    public void ajouter(Materiel materiel) {
        ArrayList<Materiel> list = malist.getList();
        list.add(materiel);
    }

    @Override
    public void supprimer(int id) {
        for (int i = 0; i < malist.getList().size(); i++) {
            if (malist.getList().get(i).getId() == id) {
                malist.getList().remove(i);
            }
        }
    }

    @Override
    public void modifier(int id, String newname) {
        for (int i = 0; i <malist.getList().size(); i++) {
            if (malist.getList().get(i).getId() == id) {
                malist.getList().get(i).setName(newname);
            }
        }
    }

    @Override
    public void rechercher(String name) {
        boolean bool = false;

        for (int i = 0; i < malist.getList().size(); i++) {
            if(malist.getList().get(i).getName().equals(name)){
                bool = true;
            }

        }
        if(bool){
            System.out.println(name+" est sur la liste");
        }
        else{
            System.out.println(name+" n'existe pas");
        }

    }
}
