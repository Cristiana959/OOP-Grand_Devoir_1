/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idlegame;

import java.util.ArrayList;

/**
 *
 * @author crist
 */
public class Profil {

    private String nomDeJoueur;
   
    private ArrayList<Integer> batiments = new ArrayList();
    private ArrayList ressources;

    Profil(String nomDeJoueur) {
        this.nomDeJoueur = nomDeJoueur;
       
    }

    Profil() {

    }
//constructor for the file reading method
    Profil(String nomDeJoueur, double money, int nrCereale, int nrBois, int nrFer, int nrArgent, int nrRoche, int nrVerre, int nrFermes, int nrScieries, int nrMinesFer, int nrMinesArgent) {
        this.nomDeJoueur = nomDeJoueur;
        Money.setTotalMoney(money);
        Cereale.setNombreTotalCereale(nrCereale);
        Bois.setNombreTotalBois(nrBois);
        Fer.setNombreTotalFer(nrFer);
        Argent.setNombreTotalArgent(nrArgent);
        Roche.setNombreRoches(nrRoche);
        Verre.setNombreVerre(nrVerre);
        Ferme.setNombreDeFermes(nrFermes);
        Scierie.setNombreDeScieries(nrScieries);
        MineFer.setNombreDeMinesFer(nrMinesFer);
        MineArgent.setNombreDeMinesArgent(nrMinesArgent);
    }

    public String getNomDeJoueur() {
        return nomDeJoueur;
    }

    public ArrayList getBatiments() {
        return batiments;
    }

    public ArrayList getRessources() {
        return ressources;
    }

    public void setNomDeJoueur(String nomDeJoueur) {
        this.nomDeJoueur = nomDeJoueur;
    }

    public void setBatiments(ArrayList batiments) {
        this.batiments = batiments;
    }

    public void setRessources(ArrayList ressources) {
        this.ressources = ressources;
    }
    
    //function that displays the current number of buildings
    public void displayCurrentBuildings() {
        System.out.println("Your current buildings are: ");
        System.out.println("Farms: " + Ferme.getNombreDeFermes() + "  Revenue: " + Ferme.getRevenueParSeconde());
        System.out.println("Sawmills: " + Scierie.getNombreDeScieries() + "  Revenue: " + Scierie.getRevenueParSeconde());
        System.out.println("Iron mines: " + MineFer.getNombreDeMinesFer() + "  Revenue: " + MineFer.getRevenueParSeconde());
        System.out.println("Silver mines: " + MineArgent.getNombreDeMinesArgent() + "  Revenue: " + MineArgent.getRevenueParSeconde());
    }

    //function that displays the current number of resources
    public void displayCurrentRessources() {
        System.out.println("You currently have: ");
        System.out.println("Money: " + Money.getTotalMoney());
        System.out.println("Rocks: " + Roche.nombreTotalRoches);
        System.out.println("Glass: " + Verre.nombreTotalVerre);
        System.out.println("Cereals: " + Cereale.getNombreTotalCereale());
        System.out.println("Wood: " + Bois.getNombreTotalBois());
        System.out.println("Iron: " + Fer.getNombreTotalFer());
        System.out.println("Silver: " + Argent.getNombreTotalArgent());
    }

    public void setRessources(int money, int cereale, int bois, int fer, int argent, int roche, int verre) {
        Money.setTotalMoney(money);
        Cereale.setNombreTotalCereale(cereale);
        Bois.setNombreTotalBois(bois);
        Fer.setNombreTotalFer(fer);
        Argent.setNombreTotalArgent(argent);
        Roche.nombreTotalRoches = roche;
        Verre.nombreTotalVerre = verre;

    }
    
    //function that returns the type of user depending on the type of building that has the largest number of buildings
    public String typeUtilisateur() {
        batiments.add(0, Ferme.getNombreDeFermes());
        batiments.add(1, Scierie.getNombreDeScieries());
        batiments.add(2, MineFer.getNombreDeMinesFer());
        batiments.add(3, MineArgent.getNombreDeMinesArgent());
        batiments.add(4, Maison.getNombreDeMaisons());
        int maxP = -1;
        int max = -1;
        for (int i = 0; i < batiments.size(); i++) {
            if (batiments.get(i) > max) {
                maxP = i;
                max = batiments.get(i);
            }
        }
        if (maxP == 0) {
            return UserType.FARMER.toString();
        } else if (maxP == 1) {
            return UserType.LUMBERJACK.toString();
        } else if (maxP == 2) {
            return UserType.IRON_MINER.toString();
        } else if (maxP == 3) {
            return UserType.SILVER_MINER.toString();
        } else if(maxP == 4) {
            return UserType.VILLAGE_LEADER.toString();
        }
        else
            return UserType.NEW_VILLAGER.toString();

    }
}
