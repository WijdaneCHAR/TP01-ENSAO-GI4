package com.ensa.gi4.DAO.api;

import com.ensa.gi4.modele.Materiel;

public interface MaterielDAO {
    void lister();
    void ajouter(Materiel materiel);
    void supprimer(int id);
    void modifier(int id,String newname);
    void rechercher(String name);
}
