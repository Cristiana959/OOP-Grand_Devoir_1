/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idlegame;

import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author crist
 */
public class IdleGame {

    /**
     */
    
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void displayMainMenu() {
        System.out.println(" \n \n What would you like to do next? \n D -> diplay you current resources/buildings \n T -> transform your resources \n B -> build a new building \n C -> collect your resources \n S -> save your progress \n X -> exit");

    }
    public static void help(){
         System.out.println("There are 7 types of resources in this game: cereals, wood, iron, silver, rocks, glass and money.\n"
                + "The first 4 resources are generated for you by the 4 types of buildings available: farm, sawmill, iron mine, and silver mine and can be sold in order to get money.\n"
                + "The buildings can be bought with money and each of them will provide you with a revenue of its specific resource which will increase as you build more buldings.The price of each type of building will also increase as you build more buildings.\n"
                + "There is a special type of building, the House, which can be built by using rocks and glass.You can't use money to buy it."
                + "You can obtain rocks and glass by trading the first 4 resources for them.Again, you can't buy rocks ang glass using money.\n"
                + "You can collect the resources provided by your buildings 5 times/session.(5 times in total, not each kind of resource 5 times)"
                + "You can check your status and inventory at any time by pressing the D key in the main menu.\n"
                + "All the commands work in lower case.");
    }
    
    public static void main(String[] args) throws FileNotFoundException {

        Cereale c = new Cereale();
        Bois b = new Bois();
        Fer f = new Fer();
        Argent a = new Argent();
        Ferme f0 = new Ferme();
        Scierie s0 = new Scierie();
        MineFer mf0 = new MineFer();
        MineArgent ma0 = new MineArgent();
        Maison m0 = new Maison();
        FileManagement saveProfile = new FileManagement();
        int collectLimit = 4;

        System.out.println("-------------Welcome to River Valley-------------");
        System.out.println("To get started you have to pick your username!");
        System.out.print("Your username is: " + "\n");
        String username;
        //with the sequence below that is commented you can enter from the keyboard you username and begin a new game
        //  username = sc.next();
        //Profil p = new Profil(username);
        //p.setNomDeJoueur(username);
        Scanner sc = new Scanner(System.in);
        //username = sc.next();
        //Profil p = new Profil(username);
        
        //we read the username and the other user data from a file
        Profil p = saveProfile.lecture("userData.txt");

        System.out.println("Hello " + p.getNomDeJoueur() + "!");
        System.out.println();
        System.out.println(" Now, before you begin your journey there are some things you should know:");
        System.out.println();

        help();

        System.out.println();
        System.out.println("Let's start!");
        System.out.println("What would you like to do? \n D -> display you current resources/buildings \n T -> transform your resources \n B -> build a new building \n C -> collect your resources \n S -> save your progress \n X -> exit  \n H -> help");
        String choice = "a";
        do {
            choice = sc.next();

            switch (choice) {
                // case to display your resources, buildings and type of user
                //depending on the key that is pressed one of the functions from the class Profil is called
                case "d":
                    clearScreen();
                    System.out.println("What would you like to display?" + "\n" + " R -> current resources \n B -> current buildings \n U -> find out what kind of user you are \n X -> go back to the main menu");
                    String display = sc.next();
                    while ((!(display.equals("u"))) && (!(display.equals("r"))) && (!(display.equals("b"))) && (!(display.equals("x")))) {
                        System.out.println("Please enter a valid choice.");
                        display = sc.next();
                    }
                    while (!display.equals("x")) {
                        if (display.equals("r")) {
                            p.displayCurrentRessources();
                        } else if (display.equals("b")) {
                            p.displayCurrentBuildings();
                        } else if (display.equals("u")) {
                            System.out.println("You are a(n) " + p.typeUtilisateur());
                        }
                        else
                            System.out.println("Please enter a valid choice.");
                        display = sc.next();
                    }

                    clearScreen();
                    displayMainMenu();
                    break;
                    
                //case to transform the resources in money or rocks and glass    
                case "t":
                    clearScreen();

                    System.out.println("Which resource would you like to transform? \n C -> cereals \n W -> wood \n I -> iron \n S -> silver \n X -> go back to main menu");
                    String transform = sc.next();
                    while ((!(transform.equals("c"))) && (!(transform.equals("w"))) && (!(transform.equals("i"))) && (!(transform.equals("s"))) && (!(transform.equals("x")))) {
                        
                        System.out.println("Please enter a valid choice.");
                        transform = sc.next();
                    }
                    while(!transform.equals("x")){
                    switch (transform) {
                        case "c":
                            System.out.println("Do you want to transform the cereals into : \n M -> money \n R -> rocks \n G -> glaass \n X -> go back to main menu");
                            String transformChoice = null;

                            transformChoice = sc.next();

                            while ((!(transformChoice.equals("m"))) && (!(transformChoice.equals("r"))) && (!(transformChoice.equals("g"))) && (!(transformChoice.equals("x")))) {
                                
                                System.out.println("Please enter a valid choice.");
                                transformChoice = sc.next();
                            }

                            while (!(transformChoice.equals("x"))) {
                                
                                switch (transformChoice) {
                                    case "m":
                                        System.out.println("The conversion is: 12 cereals = 10 $ \n");

                                        c.utiliserRessource();
                                        System.out.println("You currently have: " + Cereale.getNombreTotalCereale() + " cereals. \n");
                                        System.out.println("Your balance is: " + Money.getTotalMoney() + " $");
                                        System.out.println("Press x once to go back and change the resource you want to tranform of press x twice to return to the main menu.");
                                        break;
                                    case "r":
                                        System.out.println("The conversion is: 20 cereals = 1 rock \n");

                                        c.convertirRoche();
                                        System.out.println("You currently have: " + Cereale.getNombreTotalCereale() + " cereals. \n");
                                        System.out.println("You currently have: " + Roche.nombreTotalRoches + " rocks.");
                                        System.out.println("Press x once to go back and change the resource you want to tranform of press x twice to return to the main menu.");
                                        break;
                                    case "g":
                                        System.out.println("The conversion is: 25 cereals = 1 piece of glass");
                                        c.convertirVerre();
                                        System.out.println("You currently have: " + Cereale.getNombreTotalCereale() + " cereals. \n");
                                        System.out.println("You currently have: " + Verre.getNombreTotalVerre() + " pieces of glass.");
                                        System.out.println("Press x once to go back and change the resource you want to tranform of press x twice to return to the main menu.");
                                        break;

                                    default:
                                        System.out.println("Please select an existing resource or go back and choose another action.");

                                }
                                transformChoice = sc.next();
                            }

                            clearScreen();
                              System.out.println("Please press x once again in order to return to the main menu or c/w/i/s to choose a new resource.");
                            break;

                        case "w":
                            System.out.println("Do you want to transform the wood into : \n M -> money \n R -> rocks \n G -> glaass \n X -> go back to the main menu");
                            String transformChoiceW = null;

                            transformChoiceW = sc.next();

                            while ((!(transformChoiceW.equals("m"))) && (!(transformChoiceW.equals("r"))) && (!(transformChoiceW.equals("g"))) && (!(transformChoiceW.equals("x")))) {
                                System.out.println("Please enter a valid choice.");
                                transformChoiceW = sc.next();
                            }

                            while (!(transformChoiceW.equals("x"))) {
                                switch (transformChoiceW) {
                                    case "m":
                                        System.out.println("The conversion is: 9 pieces of wood = 20 $");

                                        b.utiliserRessource();
                                        System.out.println("You currently have: " + Bois.getNombreTotalBois() + " pieces of wood.");
                                        System.out.println("Your balance is: " + Money.getTotalMoney() + " $");
                                        System.out.println("Press x once to go back and change the resource you want to tranform of press x twice to return to the main menu.");
                                        break;
                                    case "r":
                                        System.out.println("The conversion is: 15 pieces of wood = 1 rock");

                                        b.convertirRoche();
                                        System.out.println("You currently have: " + Bois.getNombreTotalBois() + " pieces of wood.");
                                        System.out.println("You currently have: " + Roche.nombreTotalRoches + " rocks.");
                                        System.out.println("Press x once to go back and change the resource you want to tranform of press x twice to return to the main menu.");
                                        break;
                                    case "g":
                                        System.out.println("The conversion is: 20 pieces of wood = 1 piece of glass");

                                        b.convertirVerre();
                                        System.out.println("You currently have: " + Bois.getNombreTotalBois() + " pieces of wood.");
                                        System.out.println("You currently have: " + Verre.getNombreTotalVerre() + " pieces of glass.");
                                        System.out.println("Press x once to go back and change the resource you want to tranform of press x twice to return to the main menu.");
                                        break;

                                    default:
                                        System.out.println("Please select an existing resource or go back and choose another action.");

                                }
                                transformChoiceW = sc.next();
                            }
                            clearScreen();
                            System.out.println("Please press x once again in order to return to the main menu or c/w/i/s to choose a new resource.");
                            break;

                        case "i":
                            System.out.println("Do you want to transform the iron into : \n M -> money \n R -> rocks \n G -> glaass \n X -> go back to the main menu");
                            String transformChoiceI = null;
                            transformChoiceI = sc.next();

                            while ((!(transformChoiceI.equals("m"))) && (!(transformChoiceI.equals("r"))) && (!(transformChoiceI.equals("g"))) && (!(transformChoiceI.equals("x")))) {
                                System.out.println("Please enter a valid choice.");
                                transformChoiceI = sc.next();
                            }

                            while (!(transformChoiceI.equals("x"))) {
                                switch (transformChoiceI) {
                                    case "m":
                                        System.out.println("The conversion is: 6 iron igots = 30 $");

                                        f.utiliserRessource();
                                        System.out.println("You currently have: " + Fer.getNombreTotalFer() + " iron igots.");
                                        System.out.println("Your balance is: " + Money.getTotalMoney() + " $");
                                        System.out.println("Press x once to go back and change the resource you want to tranform of press x twice to return to the main menu.");
                                        break;
                                    case "r":
                                        System.out.println("The conversion is: 10 iron ingots = 1 rock");

                                        f.convertirRoche();
                                        System.out.println("You currently have: " + Fer.getNombreTotalFer() + " iron igots.");
                                        System.out.println("You currently have: " + Roche.nombreTotalRoches + " rocks.");
                                        System.out.println("Press x once to go back and change the resource you want to tranform of press x twice to return to the main menu.");
                                        break;
                                    case "g":
                                        System.out.println("The conversion is: 15 iron ingots = 1 piece of glass");

                                        f.convertirVerre();
                                        System.out.println("You currently have: " + Fer.getNombreTotalFer() + " iron igots.");
                                        System.out.println("You currently have: " + Verre.getNombreTotalVerre() + " pieces of glass.");
                                        System.out.println("Press x once to go back and change the resource you want to tranform of press x twice to return to the main menu.");
                                        break;

                                    default:
                                        System.out.println("Please select an existing resource or go back and choose another action.");
                                    break;
                                     
                                }
                                transformChoiceI = sc.next();
                                
                            }
                           
                            clearScreen();
                    System.out.println("Please press x once again in order to return to the main menu or c/w/i/s to choose a new resource.");
                            break;
                            
                        case "s":
                            System.out.println("Do you want to transform the silver into : \n M -> money \n R -> rocks \n G -> glaass \n X -> go back to the main menu");
                            String transformChoiceS = null;
                             transformChoiceS = sc.next();
                            while ((!(transformChoiceS.equals("m"))) && (!(transformChoiceS.equals("r"))) && (!(transformChoiceS.equals("g"))) && (!(transformChoiceS.equals("x")))) {
                                System.out.println("Please enter a valid choice.");
                                transformChoiceS = sc.next();
                            }

                           
                            while (!(transformChoiceS.equals("x"))) {
                                switch (transformChoiceS) {
                                    case "m":
                                        System.out.println("The conversion is: 3 silver ingots = 40 $");
                                        System.out.println("You currently have: " + Argent.getNombreTotalArgent() + " silver ingots.");
                                        a.utiliserRessource();
                                        System.out.println("Your balance is: " + Money.getTotalMoney() + " $.");
                                        System.out.println("Press x once to go back and change the resource you want to tranform of press x twice to return to the main menu.");
                                                
                                        break;
                                    case "r":
                                        System.out.println("The conversion is: 5 silver ingots = 1 rock");
                                        System.out.println("You currently have: " + Argent.getNombreTotalArgent() + " silver ingots.");
                                        a.convertirRoche();
                                        System.out.println("You currently have: " + Roche.nombreTotalRoches + " rocks.");
                                        System.out.println("Press x once to go back and change the resource you want to tranform of press x twice to return to the main menu.");
                                        break;
                                    case "g":
                                        System.out.println("The conversion is: 10 silver ingots = 1 piece of glass \n");

                                        a.convertirVerre();
                                        System.out.println("You currently have: " + Argent.getNombreTotalArgent() + " silver ingots.\n");
                                        System.out.println("You currently have: " + Verre.getNombreTotalVerre() + " pieces of glass.");
                                        System.out.println("Press x once to go back and change the resource you want to tranform of press x twice to return to the main menu.");
                                        break;

                                    default:
                                        System.out.println("Please select an existing resource or go back and choose another action.");

                                }
                                transformChoiceS = sc.next();
                            }

                            clearScreen();
                            System.out.println("Please press x once again in order to return to the main menu or c/w/i/s to choose a new resource.");
                            break;
                        default:
                            System.out.println("Please select a valid choice.");
                    }
                    transform = sc.next();
                    }      clearScreen();
                            displayMainMenu();
                            break;
                        
                        //case to build a new type of building
                        case "b":
                            clearScreen();
                            System.out.println("Which type of building would you like to build? \n F -> Farm           Price: " + Ferme.getCoutConstructionFerme() + "$ \n S -> Sawmill        Price: " + Scierie.getCoutConstructionScierie() + "$ \n I -> Iron mine      Price: " + MineFer.getCoutConstructionMineFer() + "$ \n M -> Silver mine    Price: " + MineArgent.getCoutConstructionMineArgent() + "$ \n H -> House          Price: " + Maison.coutConstructionMaison + "rocks , glass" + "\n X -> go back to the main menu");
                            System.out.println("Your current balance is: " + Money.getTotalMoney() + " $");
                            String build = sc.next();
                            while ((!(build.equals("f"))) && (!(build.equals("s"))) && (!(build.equals("i"))) && (!(build.equals("m"))) && (!(build.equals("h"))) && (!(build.equals("x")))) {
                                
                                System.out.println("Please enter a valid choice.");
                                build = sc.next();
                            }
                            if (!build.equals("x")) {
                                switch (build) {
                                    case "f":

                                        Ferme f1 = new Ferme();
                                        System.out.println(f1.afficherLeNombreDeBatiments());
                                        System.out.println("Your balance is: " + Money.getTotalMoney() + " $.");
                                        break;

                                    case "s":
                                        Scierie s1 = new Scierie();
                                        System.out.println(s1.afficherLeNombreDeBatiments());
                                        System.out.println("Your balance is: " + Money.getTotalMoney() + " $.");
                                        break;
                                    case "i":
                                        MineFer mf = new MineFer();
                                        System.out.println(mf.afficherLeNombreDeBatiments());
                                        System.out.println("Your balance is: " + Money.getTotalMoney() + " $.");
                                        break;
                                    case "m":
                                        MineArgent ma = new MineArgent();
                                        System.out.println(ma.afficherLeNombreDeBatiments());
                                        System.out.println("Your balance is: " + Money.getTotalMoney() + " $.");
                                        break;
                                    case "h":
                                        Maison m1 = new Maison();
                                        System.out.println(m1.afficherLeNombreDeBatiments());
                                        System.out.println("You now have: " + Roche.nombreTotalRoches + " rocks and " + Verre.getNombreTotalVerre() + " pieces of glass.");
                                    default:
                                        System.out.println("Please select a valid choice or go back and choose another action.");
                                }
                                }
                                clearScreen();
                                displayMainMenu();
                                break;
                        
                        //case to collect the resources from the buildings
                        //maximum number of times to collect/session:4
                        case "c":
                            if(collectLimit > 0){
                            collectLimit--;
                            clearScreen();
                            System.out.println("Which resource would you like to collect? \n C -> cereals \n W -> wood \n I -> iron \n S -> silver \n M -> money(only if you built a house) \n X -> go back to the main menu");
                            String collect = sc.next();
                            while ((!(collect.equals("c"))) && (!(collect.equals("w"))) && (!(collect.equals("i"))) && (!(collect.equals("s"))) && (!(collect.equals("m"))) && (!(collect.equals("x")))) {
                                
                                
                                System.out.println("Please enter a valid choice.");
                                collect = sc.next();
                            }
                            if (!(collect.equals("x"))) {
                                switch (collect) {
                                    case "c":
                                        if (Ferme.getNombreDeFermes() > 0) {
                                            for (int i = 0; i < Ferme.getNombreDeFermes(); i++) {
                                                f0.fournitLaRessource();
                                            }
                                            System.out.println("You now have: " + Cereale.getNombreTotalCereale() + " cereals.");
                                        } else {
                                            System.out.println("You haven't built any farms yet.");
                                        }
                                        break;
                                    case "w":
                                        if (Scierie.getNombreDeScieries() > 0) {
                                            for (int i = 0; i < Scierie.getNombreDeScieries(); i++) {
                                                s0.fournitLaRessource();
                                            }
                                            System.out.println("You now have: " + Bois.getNombreTotalBois() + " pieces of wood");
                                        } else {
                                            System.out.println("You haven't built any sawmills yet.");
                                        }
                                        break;
                                    case "i":
                                        if (MineFer.getNombreDeMinesFer() > 0) {
                                            for (int i = 0; i < MineFer.getNombreDeMinesFer(); i++) {
                                                mf0.fournitLaRessource();
                                            }
                                            System.out.println("You now have: " + Fer.getNombreTotalFer() + " iron ingots");
                                        } else {
                                            System.out.println("You haven't built any iron mines yet.");
                                        }
                                        break;
                                    case "s":
                                        if (MineArgent.getNombreDeMinesArgent() > 0) {
                                            for (int i = 0; i < MineArgent.getNombreDeMinesArgent(); i++) {
                                                ma0.fournitLaRessource();
                                            }
                                            System.out.println("You now have: " + Argent.getNombreTotalArgent() + " silver ingots.");
                                        } else {
                                            System.out.println("You haven't built any silver mines yet.");
                                        }
                                        break;
                                    case "m":
                                        if (Maison.getNombreDeMaisons() > 0) {
                                            for (int i = 0; i < Maison.getNombreDeMaisons(); i++) {
                                                m0.fournitLaRessource();
                                            }

                                            System.out.println("You now have: " + Money.getTotalMoney() + "$.");
                                        } else {

                                            System.out.println("You haven't built any houses yet.");
                                        }
                                    default:
                                        System.out.println("Please select a valid choice");
                                }
                                
                            }}
                                    
                            else{
                                System.out.println("You can't collect anymore resources in this session.Please come back later. ");
                            }
                            clearScreen();
                            displayMainMenu();
                            break;
                            
                        //case to save the number of buildings and resources in a file
                        case "s":
                            clearScreen();
                            System.out.println("Would you like to save your progress? \n Y -> Yes \n N -> No");
                            String save = sc.next();

                            while ((!(save.equals("y"))) && (!(save.equals("n")))) {
                                System.out.println("Please enter a valid choice.");
                                save = sc.next();
                            }

                            if (save.equals("y")) {
                                saveProfile.sauvegarde(p);
                            } else {
                                clearScreen();
                            displayMainMenu();
                            break;                                
                            }
                            clearScreen();
                            displayMainMenu();
                            break;
                            
                        //case to display the help text    
                        case "h":
                            clearScreen();
                            help();
                            System.out.println("\nPress x to go back to the main menu");
                            String back = sc.next();
                            while(!back.equals("x")){
                                System.out.println("Please press x.");
                                     back = sc.next();
                            }
                            clearScreen();
                            displayMainMenu();
                            break;  
                               
                        case "x":
                            System.out.println("Goodbye!");
                            break;
                                    
                        default:
                            System.out.println("Please select a valid choice.");
                    }

            }
            while (!choice.equals("x"));

        }
        }
    
