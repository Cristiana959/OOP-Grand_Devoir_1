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
public class Cereale extends Ressource {

    /**
     *
     */
    private static int nombreTotalCereale;   

    public Cereale(String utilite) {
        super(utilite);
       
    }

    Cereale() {
       
    }
   //function that transforms cereals into money
   @Override
   public void utiliserRessource(){
           if(nombreTotalCereale >= 12){
           nombreTotalCereale -= 12;
           Money.setTotalMoney(Money.getTotalMoney() + 10);
           }
           else
               System.out.println("You don't have enough cereals to sell for money.");
   }
   //function that coverts cereals into rocks
   public void convertirRoche(){
       if(nombreTotalCereale >= 20){
           nombreTotalCereale -= 20;
           Roche.nombreTotalRoches ++;
           
       }
       else
           System.out.println("You don't have enough cereals to trade for rocks");
   }
   
   //function that converts cereals into glass
   public void convertirVerre(){
       if(nombreTotalCereale >= 25){
           nombreTotalCereale -= 25;
           Verre.nombreTotalVerre ++;
           
       }
       else
           System.out.println("You don't have enough cereals to trade for glass.");
   }

    /**
     *
     * @return
     */
    public static  int getNombreTotalCereale() {
        return nombreTotalCereale;
    }

    public static void setNombreTotalCereale(int x) {
        nombreTotalCereale = x;
    }
    
   
}
