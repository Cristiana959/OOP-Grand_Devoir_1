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
public class Bois extends Ressource {

    /**
     *
     */
    private static  int nombreTotalBois=0;

    public Bois(String nom) {
        super(nom);
       
    }

    Bois() {
       
    }
   // function that transforms wood into money
   @Override
   public void utiliserRessource(){
       if(nombreTotalBois >= 9){
           nombreTotalBois -= 9;
           Money.setTotalMoney(Money.getTotalMoney() + 20);
       }
        else
           System.out.println("You don't have enough wood to sell for money,");
   }
   
   //function that converts wood into rocks
   public void convertirRoche(){
       if(nombreTotalBois >= 15){
           nombreTotalBois -= 15;
           Roche.nombreTotalRoches ++;
           
       }
       else
           System.out.println("You don't have enough wood to trade for rocks.");
   }
   
   //function that converts wood into glass
   public void convertirVerre() {
           if(nombreTotalBois >= 20){
           nombreTotalBois -= 20;
           Verre.nombreTotalVerre ++;
           
       }
       else
           System.out.println("You don't have enough wood to trade for glass.");
   }

    public static int getNombreTotalBois() {
        return nombreTotalBois;
    }

    public static void setNombreTotalBois(int x) {
      nombreTotalBois = x;
    }

    
    
}
