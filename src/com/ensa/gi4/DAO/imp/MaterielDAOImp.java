package com.ensa.gi4.DAO.imp;

import com.ensa.gi4.DAO.MaterielList;
import com.ensa.gi4.DAO.api.MaterielDAO;
import com.ensa.gi4.modele.Materiel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Scanner;
@Component("materielDAO")
public class MaterielDAOImp implements MaterielDAO {
    MaterielList malist = null;

    private MaterielDAOImp materielDAOImp = null;
    @Autowired
    public MaterielDAOImp(MaterielList malist) {
        this.malist = malist;
    }

    @Override
    public void lister() {
        System.out.println("-------------- Liste des materiels : --------------");
        if(malist.getList().isEmpty())
            System.out.println("La liste est vide");
        else{
            for (int i = 0; i < malist.getList().size(); i++) {
                System.out.println(malist.getList().get(i).getId() + " : " + malist.getList().get(i).getName());
            }
        }
        System.out.println("---------------------------------------------------");
    }

    @Override
    public void ajouter(Materiel materiel) {

        ArrayList<Materiel> list = malist.getList();

        for (int i = 0; i <list.size() ; i++){
            if(list.get(i).getId() == materiel.getId()){
                System.out.println("Id deja existant");
                System.out.println("--------- NB: liste des ids existants ----------");
                for (int j = 0; j <list.size() ; j++){
                    System.out.println(list.get(j).getId() + " ");
                }
                System.out.println("Veuillez entrez un id n'existant pas sur la liste:");
                Scanner sc = new Scanner(System.in);
                int newId = sc.nextInt();
                materiel.setId(newId);
                break;
            }
        }
        list.add(materiel);
        System.out.println("Materiel ajouté");
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
