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
public class Fer extends Ressource {
    private static  int nombreTotalFer=0;
    

    public Fer(String utilite) {
        super(utilite);
       
    }

    Fer() {
       
    }
   //function that transform iron ingots into money
   @Override
   public void utiliserRessource(){
       if(nombreTotalFer >= 6){
           nombreTotalFer -= 6;
           Money.setTotalMoney(Money.getTotalMoney() + 30);
       }
       else
           System.out.println("You don't have enough iron to sell for money.");
   }
   public static int getNombreTotalFer(){
       return nombreTotalFer;
   }

    public static void setNombreTotalFer(int x) {
      nombreTotalFer = x;
    }
   //function that converts iron ingots into rocks 
   public void convertirRoche(){
       if(nombreTotalFer >= 10){
           nombreTotalFer -= 10;
           Roche.nombreTotalRoches ++;
           
       }
       else
           System.out.println("You don't have enough iron to trade for rocks.");
   }
   
   //function that converts iron ingots into glass
   public void convertirVerre(){
       if(nombreTotalFer >= 15){
           nombreTotalFer -= 15;
            Verre.nombreTotalVerre ++;
           
       }
       else
           System.out.println("You don't have enough iron to trade for glass.");
   }

    
    
}
