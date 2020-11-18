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
public class MineFer extends Batiment {
    private static int revenueParSeconde=1;
    protected static double coutConstructionMineFer=40;
    private final double f=0.7;
    private static int nombreDeMinesFer=-1;
   
   

    /**
     *
     * @param f
     */
    
    //function that increases the construction cost of the Iron Mine
    @Override
     public void augumenterCoutConstruction(double f){
         
             coutConstructionMineFer+=coutConstructionMineFer*f;
     }
     
     //function that increases the revenue 
     public void augumenterRevenu(){
         revenueParSeconde++;
     }

    public MineFer(String description, String nom) {
        super(description, nom);
    
    }

    //when we build a new iron mine, the total number of iron mines, the construction cost and the revenu/seconde increase and the total number of money decreases
    public MineFer() {
        if(Money.getTotalMoney() >= coutConstructionMineFer){
        Money.setTotalMoney(Money.getTotalMoney() - coutConstructionMineFer);
        augumenterCoutConstruction(f);
        augumenterRevenu();
        nombreDeMinesFer++;
        }
        else
            System.out.println("You don't have enough money to build a new iron mine.");
    }

    public static void setNombreDeMinesFer(int x){
        nombreDeMinesFer = x;
    }

    public static int getRevenueParSeconde() {
        return revenueParSeconde;
    }
   
    
    //function that adds to the total number of iron ingots the revenue/second 
    @Override
    public void fournitLaRessource(){
        Fer.setNombreTotalFer(Fer.getNombreTotalFer() + revenueParSeconde);
       
    }
    /**
     *
     * @return
     */
    @Override
    public String afficherLeNombreDeBatiments(){
        return "You have "+nombreDeMinesFer+" iron mines.";
    }

    public static int getNombreDeMinesFer() {
        return nombreDeMinesFer;
    }
    public static double getCoutConstructionMineFer(){
        return coutConstructionMineFer;
    }

   
    
}
