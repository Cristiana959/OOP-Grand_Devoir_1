import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.io.*;
import java.util.Scanner;
/** Author : Nae Sebastian-Ion
 * Sectia : IS
 * Grupa : 313AC*/
public class TestGame {
    public static int cord_X = 0, cord_Y = 0;
    public static boolean endGame = false;
    public static String collect_command;
    public static String battle_enemy;

    public static void randomResponse()
    {
        //TODO : Implement a random event when var temp is 0 go to a attack else other defend
    }
    public static void generateBattleScreen(Personnage character,Personnage enemy)
    {

        System.out.println("----------Battle-------------");
        System.out.println("Health : " + character.getHealth());
        System.out.println("Enemy health : " +  enemy.getHealth());
        System.out.println("------------------------------");
        System.out.println("Inventory : " + character.afficheInventarie());
        System.out.println("----------Command-------------");
        Scanner scan = new Scanner(System.in);
        String command = scan.nextLine();
        while(enemy.getHealth()!=0 || character.getHealth()!=0)
        {
            switch (command){
                case "X":
                case "x":
                    int temp = enemy.getHealth();
                    enemy.setHealth(temp--);
                    randomResponse();
                    //TODO : Add random event
                    break;
                case "Z":
                case "z":
                    System.out.println("Not implemented");
                    //TODO : Defend
                    break;
                case "C":
                case "c":
                default:
                    System.out.println("Not implemented");
                    break;
            }
            break;
        }
    }

    public static void battleEnemy(Personnage character, Personnage enemy) {
        clearScreen();

        System.out.println("You are about to battle " + enemy.getName());
        System.out.println("Do you wish to battle now?");
        System.out.println("Y/N?");

        Scanner scan = new Scanner(System.in);
        String command = scan.nextLine();

        battle_enemy = command;

        while (true) {
            switch (command) {
                case "Y":
                case "y":
                    clearScreen();
                    //TODO : Implement a combat system
                    generateBattleScreen(character,enemy);
                    break;
                case "N":
                case "n":
                    System.out.println("You skipped the battle for now");
                    clearScreen();
                    break;
                default:
                    System.out.println("Unsupported command please try again");
                    clearScreen();
            }
            break;
        }
    }

    public static void collectObject(Personnage character, Object obj) {
        clearScreen();

        System.out.println("You are about to collect item" + obj.getDescription());
        System.out.println("Do you wish to collect it now?");
        System.out.println("Y/N?");


        Scanner scan = new Scanner(System.in);
        String command = scan.nextLine();

        while (true) {
            switch (command) {
                case "Y":
                case "y":
                    character.ajouterObject(obj);
                    System.out.println("You collected the object " + obj.getDescription());
                    collect_command = command;
                    break;
                case "N":
                case "n":
                    System.out.println("You skipped the object" + obj.getDescription());
                    collect_command = command;
                    break;
                default:
                    System.out.println("Unsupported command please try again");
                    clearScreen();
            }
            break;
        }
    }

    public static void updateMap(Personnage character, Niveau level, String command, int i, int j) {
        Element element = level.getElement(i, j);
        Element[][] low_level = level.carte;
        if (level.decritCarte(i, j).equals("case vide")) {
            level.deleteElement(i, j);
            level.setElement(i, j, character);
        } else if (element.getType().equals(types.PERSONAGE)) {
            //TODO : The items is deleted, can't pe retrived back,
            //TODO: Need this bug to be fixed ASAP
            System.out.println("Character to battle");
            battleEnemy(character, (Personnage) element);
        } else if (element.getType().equals(types.OBJECT)) {
            Object obj = (Object) element;
            collectObject(character, obj);
            //TODO : The items is deleted, can't pe retrived back,
            //TODO: Need this bug to be fixed ASAP
            if(collect_command.equals("Y"))
            {
                level.deleteElement(i, j);
                level.setElement(i, j, character);
            }
            else
            {
                level.setElement(i, j, character);
            }
        }
    }

    public static void listOfCommand() {
        ArrayList<String> listCommands = new ArrayList<>(Arrays.asList("Help --help","Inventory - I/i","Up - W/w Down - S/s Left - A/a Right - D/d" ,"Reload Level - R/r", "It supports lowercase as well as uppercase", "Attack - X/x", "Defend - Z/z" , "Inventory detailed - ID/id", "Use item from inventory with index - C/c"));
        for(String str : listCommands)
        {
            System.out.println(str);
        }
        System.out.println();
    }

    public static void showLevel(Niveau level, Personnage character) {
        for (int i = 0; i < level.carte.length; i++) {
            for (int j = 0; j < level.carte.length; j++) {
                Element my_element = level.getElement(i, j);
                if (level.decritCarte(i, j) == "case vide")
                    System.out.print("-");
                else {
                    if (my_element.getType().equals(types.OBJECT))
                        System.out.print("X");
                    else if (my_element.getType().equals(types.PERSONAGE)) {
                        if (my_element.getDescription().equals(character.getDescription()))
                            System.out.print("P");
                        else
                            System.out.print("Y");
                    } else
                        System.out.print("Z");
                }
            }
            System.out.println();
        }
    }


    /*Movement & abilities commands*/

    public static void characterMovement(Personnage character, Niveau level) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        while (true) {
            switch (command) {
                case "W":
                case "w":
                    updateMap(character, level, command, cord_X - 1, cord_Y);
                    level.deleteElement(cord_X, cord_Y);
                    cord_X = cord_X - 1;
                    cord_Y = cord_Y;
                    break;
                case "S":
                case "s":
                    updateMap(character, level, command, cord_X + 1, cord_Y);
                    level.deleteElement(cord_X, cord_Y);
                    cord_X = cord_X + 1;
                    cord_Y = cord_Y;
                    break;
                case "A":
                case "a":
                    updateMap(character, level, command, cord_X, cord_Y - 1);
                    level.deleteElement(cord_X, cord_Y);
                    cord_X = cord_X;
                    cord_Y = cord_Y - 1;
                    break;
                case "D":
                case "d":
                    updateMap(character, level, command, cord_X, cord_Y + 1);
                    level.deleteElement(cord_X, cord_Y);
                    cord_X = cord_X;
                    cord_Y = cord_Y + 1;
                    break;
                case "I":
                case "i":
                    System.out.println(character.afficheInventarie());
                    break;
                case "ID":
                case "id":
                    character.showInventoryWithIndices();
                    break;
                case "F":
                    break;
                case "R":
                    break;
                case "-help":
                    clearScreen();
                    listOfCommand();
                    break;
                case "stop":
                    endGame = true;
                case "god_mode":
                    character.setMaxHealth(100000);
                    character.setAttackPower(1000000);
                default:
                    System.out.println("Unsupported command please try again");
                    clearScreen();
            }
            break;
        }
    }

    /*Tried something to clear the output didnt work
     * Ended up doing this*/
    public static void clearScreen() {
        for (int i = 0; i < 20; i++)
            System.out.println();
        System.out.println("---------Update-------------");
    }

    /*Creating the scene for the game*/
    public static void initAll() {
        /*Objects*/
        Object sword = new Object();
        sword.setDescription("Sword");
        Object potion = new Object();
        potion.setDescription("Potion Health");
        Object magic_clock = new Object();
        magic_clock.setDescription("Magic Clock");

        /*Decor*/
        Decor plant = new Decor();
        Decor wall = new Decor();

        /*Characters*/
        Personnage main_character_boy = new Personnage("MemeMaster Alex", 100, 150);
        Personnage main_character_girl = new Personnage("Croft Iulia", 100, 150);
        Personnage dummy = new Personnage("Evil Kermit", 1, 1);
        Personnage oger = new Personnage("Success Kid", 10, 10);
        Personnage archer = new Personnage("Grumpy Cat", 25, 25);


        /*Level*/
        Niveau firstLevel = new Niveau();
        firstLevel.setTitre("MemeLand");

        /*Create Layout*/
        firstLevel.setElement(0, 0, main_character_boy);

        firstLevel.setElement(3, 2, sword);
        firstLevel.setElement(5, 6, potion);
        firstLevel.setElement(1, 0, magic_clock);
        firstLevel.setElement(1, 1, magic_clock);
        firstLevel.setElement(1, 2, magic_clock);

        firstLevel.setElement(2, 3, dummy);
        firstLevel.setElement(4, 7, dummy);
        firstLevel.setElement(1, 6, oger);
        firstLevel.setElement(7, 9, archer);

        firstLevel.setElement(4, 6, plant);
        firstLevel.setElement(3, 3, wall);

        while (endGame == false) {
            showLevel(firstLevel, main_character_boy);
            characterMovement(main_character_boy, firstLevel);
        }

        //TODO : Implement a choosing system
    }

    public static void main(String[] args) {
        initAll();

    }
}
