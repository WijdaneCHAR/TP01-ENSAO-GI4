package com.ensa.gi4.service.impl;

import com.ensa.gi4.DAO.api.MaterielDAO;
import com.ensa.gi4.DAO.imp.MaterielDAOImp;
import com.ensa.gi4.modele.Materiel;
import com.ensa.gi4.service.api.GestionMaterielService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("gestionMaterielService")
public class GestionMaterielServiceImpl implements GestionMaterielService {
    public MaterielDAOImp materielDAOImp;
    @Autowired
    public GestionMaterielServiceImpl(MaterielDAOImp materielDAOImp) {
        this.materielDAOImp = materielDAOImp;
    }

    // bd goes here
    @Override
    public void init() {
        System.out.println("inititialisation du service");
    }

    @Override
    public void lister() {
        materielDAOImp.lister();
    }

    @Override
    public void ajouter(Materiel materiel) {
        materielDAOImp.ajouter(materiel);
    }

    @Override
    public void supprimer(int id){
        materielDAOImp.supprimer(id);
    }

    @Override
    public void modifier(int id, String newname) {
        materielDAOImp.modifier(id,newname);
    }

    @Override
    public void rechercher(String name) {
        materielDAOImp.rechercher(name);
    }
}
