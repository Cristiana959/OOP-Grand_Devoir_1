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
public class Roche extends Ressource {
    public static  int nombreTotalRoches;

    public Roche(String utilite) {
        super(utilite);
    }

    Roche() {
        
    }
   public static void setNombreRoches(int x){
       nombreTotalRoches = x;
   }
    
    /**
     *
     */
   
   //function that reduces the number of rocks in order to build a house
    @Override
   public void utiliserRessource(){
       if(nombreTotalRoches >= Maison.getCoutConstructionMaisonRoche())
           nombreTotalRoches -= Maison.getCoutConstructionMaisonRoche();
       else
           System.out.println("You don't have enough rocks.");
   }

   
   
    
}
