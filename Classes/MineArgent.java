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
public class MineArgent extends Batiment {

    private static int revenueParSeconde = 0;
    protected static double coutConstructionMineArgent=50;
    private final double f = 0.8;
    private static int nombreDeMinesArgent=-1;
   

    /**
     *
     * @param f
     */
    
   //function that increases the construction cost of the Silver Mine
    @Override
    public void augumenterCoutConstruction(double f) {

        coutConstructionMineArgent += coutConstructionMineArgent * f + 1;
    }
    
    //function that increases the revenue 
    public void augumenterRevenu(){
        revenueParSeconde ++;
    }
    
    public MineArgent(String description, String nom) {
        super(description, nom);
       
    }

    //when we build a new silver mine, the total number of silver mines, the construction cost and the revenu/seconde increase and the total number of money decreases
    public MineArgent() {
        if(Money.getTotalMoney() >= coutConstructionMineArgent){
        Money.setTotalMoney(Money.getTotalMoney() - coutConstructionMineArgent);
        augumenterCoutConstruction(f);
        augumenterRevenu();
        nombreDeMinesArgent++;
        }
        else
            System.out.println("You don't have enough money to build a new silver mine.");
    }

    public static int getRevenueParSeconde() {
        return revenueParSeconde;
    }
    
    public static  void setNombreDeMinesArgent(int x){
        nombreDeMinesArgent = x;
    }
//function that adds to the total number of silver ingots the revenue/second 
    @Override
    public void fournitLaRessource() {
        Argent.setNombreTotalArgent(Argent.getNombreTotalArgent() + revenueParSeconde);
       
    }

    /**
     *
     * @return
     */
    @Override
    public String afficherLeNombreDeBatiments() {
        return "You have " + nombreDeMinesArgent + " silver mines.";
    }

    public static int getNombreDeMinesArgent() {
        return nombreDeMinesArgent;
    }
    public static double getCoutConstructionMineArgent(){
        return coutConstructionMineArgent;
    }

}
