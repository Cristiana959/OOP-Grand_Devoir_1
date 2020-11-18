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
public class Argent extends Ressource {
    private static  int nombreTotalArgent=0;

    public Argent(String nom) {
        super(nom);
       
    }

    Argent() {
        
    }
   
   @Override
   //function that transforms slver ingots into money
   public void utiliserRessource(){
       if(nombreTotalArgent >= 3){
           nombreTotalArgent -= 3;
           Money.setTotalMoney(Money.getTotalMoney() + 40);
       }
        else
           System.out.println("You don't have enough silver to sell for money.");
   }
   
   //function that converts silver ingots into rocks
   public void convertirRoche(){
       if(nombreTotalArgent >= 5){
           nombreTotalArgent -= 5;
           Roche.nombreTotalRoches ++;
           
       }
       else
           System.out.println("You don't have enough silver to trade for rocks.");
   }
   
   //function that converts silver ingots into glass 
   public void convertirVerre(){
       if(nombreTotalArgent >= 10){
           nombreTotalArgent -= 10;
           Verre.nombreTotalVerre ++;
           
       }
       else
           System.out.println("You don't have enough silver to trade for glass.");
   }

    public static  int getNombreTotalArgent() {
        return nombreTotalArgent;
    }

    public static void setNombreTotalArgent(int x) {
       nombreTotalArgent = x;
    }
    
}
