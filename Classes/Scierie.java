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
public class Scierie extends Batiment {
    private static int revenueParSeconde=1;
    protected static double coutConstructionScierie=30;
    private final double f=0.6;
    private static int nombreDeScieries=-1;
    
   

    /**
     *
     * @param f
     */
    
    //function that increases the construction cost of the Sawmill
    @Override
     public void augumenterCoutConstruction(double f){
         
             coutConstructionScierie+=coutConstructionScierie*f;
     }
     
     //function that increases the revenue 
      public void augumenterRevenu(){
        revenueParSeconde += 2;
    }

    public Scierie(String description, String nom) {
        super(description, nom);
        
    }

    //when we build a new sawmill, the total number of sawmills, the construction cost and the revenu/seconde increase and the total number of money decreases
    public Scierie() {
        if(Money.getTotalMoney() >= coutConstructionScierie){
        Money.setTotalMoney(Money.getTotalMoney() - coutConstructionScierie);
        augumenterCoutConstruction(f);
        augumenterRevenu();
        nombreDeScieries++;
        }
        else
            System.out.println("Ypu don't have enough money to build a new sawmill.");
    }

    public static int getRevenueParSeconde() {
        return revenueParSeconde;
    }
    

    public static void setNombreDeScieries(int x){
        nombreDeScieries = x;
    }
   

    
    //function that adds to the total number of wood the revenue/second 
    @Override
    public void fournitLaRessource(){
      Bois.setNombreTotalBois(Bois.getNombreTotalBois() + revenueParSeconde);
      
    }
    /**
     *
     * @return
     */
    @Override
    public String afficherLeNombreDeBatiments(){
        return "You have "+nombreDeScieries+" sawmills.";
    }

    public static int getNombreDeScieries() {
        return nombreDeScieries;
    }
    public static double getCoutConstructionScierie(){
        return coutConstructionScierie;
    }

   
    
}
