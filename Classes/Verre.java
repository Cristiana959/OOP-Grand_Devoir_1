/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idlegame;

import static idlegame.Roche.nombreTotalRoches;

/**
 *
 * @author crist
 */
public class Verre extends Ressource {
    public static int nombreTotalVerre;

    public Verre(String utilite) {
        super(utilite);
       
    }

    Verre() {
        
    }
    
    public static void setNombreVerre(int x){
        nombreTotalVerre = x;
    }
   
     //function that reduces the number of pieces of glass in order to build a house
   @Override
   public void utiliserRessource(){
         if(nombreTotalVerre >= Maison.getCoutConstructionMaisonVerre())
           nombreTotalVerre -= Maison.getCoutConstructionMaisonVerre();
       else
           System.out.println("You don't have enough glass.");
   }

    public static int getNombreTotalVerre() {
        return nombreTotalVerre;
    }

    
    
}
