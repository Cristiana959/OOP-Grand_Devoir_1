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
public class Ferme extends Batiment {

    
    private  static int revenueParSeconde=2;
    private static double coutConstructionFerme=20;
    private static final double f=0.5;
    private static int nombreDeFermes=-1;
   
   

    /**
     *
     * @param f
     */
    //function that increases the construction cost of the Ferme
    @Override
     public void augumenterCoutConstruction(double f){
         
             coutConstructionFerme+=coutConstructionFerme*f;
     }
     //function that increases the revenue 
     public void augumenterRevenu(){
         revenueParSeconde += 2;
     }

    public Ferme(String description, String nom) {
        super(description, nom);

    }
    
    //when we build a new farm, the total number of farms, the construction cost and the revenu/seconde increase and the total number of money decreases
    public Ferme() {
        if(Money.getTotalMoney() >= coutConstructionFerme){
         Money.setTotalMoney(Money.getTotalMoney()-coutConstructionFerme);
          nombreDeFermes += 1;
        augumenterCoutConstruction(f);
        augumenterRevenu();
        }
        else
            System.out.println("You don't have enough money to build a new farm.");
       
    }
    
    public static void setNombreDeFermes(int x){
        nombreDeFermes = x;
    }

    public static double getCoutConstructionFerme() {
        return coutConstructionFerme;
    }

    public static int getRevenueParSeconde() {
        return revenueParSeconde;
    }
    
    

    
    //function that adds to the total number of cereals the revenue/second 
    @Override
    public void fournitLaRessource(){
        Cereale.setNombreTotalCereale(revenueParSeconde+Cereale.getNombreTotalCereale()); 
       
        
    }
    
    /**
     * 
     *
     * @return
     */
    @Override
    public String afficherLeNombreDeBatiments(){
        return "You have "+getNombreDeFermes()+" farms.";
    }

    public static int getNombreDeFermes() {
        return nombreDeFermes;
    }
    
   
    
   
   
}
