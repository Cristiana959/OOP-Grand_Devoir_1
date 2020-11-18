/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idlegame;

/**
 *
 * @author crist
 */
public abstract class Batiment {
  
    private String description;
    private String nom;
    
    
    

    public Batiment() {
    }

    public Batiment(String description, String nom) {
        this.description = description;
        this.nom= nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    
    
    public abstract void fournitLaRessource();
    
    public abstract  String afficherLeNombreDeBatiments();
    
    public abstract void augumenterCoutConstruction(double f);
    public abstract void augumenterRevenu();
    
}
