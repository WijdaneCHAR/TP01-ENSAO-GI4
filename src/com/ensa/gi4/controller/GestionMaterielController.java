package com.ensa.gi4.controller;

import com.ensa.gi4.DAO.imp.MaterielDAOImp;
import com.ensa.gi4.modele.Chaise;
import com.ensa.gi4.modele.Livre;
import com.ensa.gi4.modele.Materiel;
import com.ensa.gi4.service.api.GestionMaterielService;

import java.util.Scanner;

public class GestionMaterielController {

    private GestionMaterielService gestionMaterielService;

    public void listerMateriel() {
        gestionMaterielService.lister();
    }
    public void ajouterMateriel(Materiel materiel) {
        gestionMaterielService.ajouter(materiel);
    }
    public void supprimerMateriel(int id) {
        gestionMaterielService.supprimer(id);
    }
    public void modifierMateriel(int id,String newname) {
        gestionMaterielService.modifier(id,newname);
    }
    public void rechercherMateriel(String name) {
        gestionMaterielService.rechercher(name);
    }

    public void afficherMenu() {
        System.out.println("1- pour lister le matériel, entrer 1");
        System.out.println("2- pour ajouter un nouveau matériel, entrer 2");
        System.out.println("0- pour sortir de l'application, entrer 0");
        System.out.println("3- pour supprimer un matériel, entrer 3");
        System.out.println("5- pour modifier un matériel, entrer 5");
        System.out.println("4- pour chercher un matériel, entrer 4");
        Scanner scanner = new Scanner(System.in);
        String next = scanner.next();
        if ("0".equals(next)) {
            sortirDeLApplication();
        } else if ("1".equals(next)) {
            listerMateriel();
        } else if ("2".equals(next)) {
            System.out.println("Tapez 1 pour Livre et 2 pour Chaise: ");
            Scanner scannerA = new Scanner(System.in);
            String num = scannerA.next();
            switch (num) {
                case "1" -> {
                    Livre livre = new Livre();
                    System.out.println("Entrez le nom de votre materiel livre:");
                    Scanner scanner1 = new Scanner(System.in);
                    String nameLivre = scanner1.nextLine();
                    livre.setName(nameLivre);
                    System.out.println("Entrez son id :");
                    Scanner scanner3 = new Scanner(System.in);
                    int idLivre = scanner3.nextInt();
                    livre.setId(idLivre);
                    ajouterMateriel(livre);
                }
                case "2" -> {
                    Chaise chaise = new Chaise();
                    System.out.println("Enter le nom de votre materiel chaise:");
                    Scanner scanner2 = new Scanner(System.in);
                    String nameChaise = scanner2.next();
                    chaise.setName(nameChaise);
                    System.out.println("Entrez son id :");
                    Scanner scanner4 = new Scanner(System.in);
                    int idChaise = scanner4.nextInt();
                    chaise.setId(idChaise);
                    ajouterMateriel(chaise);
                    System.out.println("Chaise bien ajoutée!");
                }
                default -> throw new IllegalStateException("Unexpected value: " + num);
            }
        } else if ("3".equals(next)) {
            System.out.println("Entrez l'id du materiel à supprimer:");
            Scanner scanner5 = new Scanner(System.in);
            int idsupp = scanner5.nextInt();
            supprimerMateriel(idsupp);
            System.out.println("Matériel Supprimé!");
        }else if ("4".equals(next)) {
            System.out.println("Entrez le nom du materiel à chercher:");
            Scanner scanner7 = new Scanner(System.in);
            String name = scanner7.nextLine();
            rechercherMateriel(name);
        }
        else if ("5".equals(next)) {
            System.out.println("Entrez l'id du materiel à modifier: ");
            Scanner scanner6 = new Scanner(System.in);
            int i = scanner6.nextInt();
            System.out.println("Entrez le nouveau nom souhaité: ");
            Scanner newscanner = new Scanner(System.in);
            String newname = newscanner.next();
            modifierMateriel(i,newname);
            System.out.println("Nom modifié");
        }
        else {
            System.out.println("choix invalide");
        }
    }

    private void sortirDeLApplication() {
        System.exit(0);
    }

    public void setGestionMaterielService(GestionMaterielService gestionMaterielService) {
        // injection par accesseur
        this.gestionMaterielService = gestionMaterielService;
    }
}
