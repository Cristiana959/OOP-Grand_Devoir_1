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
public abstract class Ressource {
    protected String utilite;
    

  

    public Ressource() {
    }
    

    public String getUtilite() {
        return utilite;
    }

    public Ressource(String utilite) {
        this.utilite = utilite;
    }
    
    public abstract void utiliserRessource();
    
    
   
}


