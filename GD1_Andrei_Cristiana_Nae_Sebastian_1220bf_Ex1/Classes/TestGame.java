package seb.devoir;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * Author : Nae Sebastian-Ion
 * Sectia : IS
 * Grupa : 313AC
 */
public class TestGame {
    public static int cord_X = 0, cord_Y = 0;
    public static boolean endGame = false;
    public static String collect_command;
    public static String battle_enemy;
    public static ArrayList<Personnage> list_char = new ArrayList<>();
    public static ArrayList<Personnage> list_enemies = new ArrayList<>();
    public static ArrayList<Object> list_objects = new ArrayList<>();
    public static Niveau firstLevel = new Niveau();
    public static int nr_enemies;

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static int randomResponse() {
        Random rnd = new Random();
        int rnd_Val = rnd.nextInt(2);
        return rnd_Val;
    }

    public static void generateBattleScreen(Personnage character, Personnage enemy) {

        Scanner scan = new Scanner(System.in);

        while (enemy.getHealth() > 0 && character.getHealth() > 0) {

            System.out.println("----------Battle-------------");
            System.out.println("Health : " + character.getHealth());
            System.out.println("Enemy health : " + enemy.getHealth());
            System.out.println("------------------------------");
            System.out.println("Inventory : " + character.afficheInventarie());
            System.out.println("----------Command-------------");
            System.out.println("\t Attack/Use item - X");
            System.out.println("\t Defense - Z");
            String command = scan.nextLine();
            switch (command) {
                case "X":
                case "x":
                    int temp = enemy.getHealth();

                    int character_dmg = 1;
                    if (character.objList.size() >= 1) {
                        System.out.println("-----Do you want to use an item ?-------");
                        System.out.println("Y/N?");
                        String items = scan.nextLine();
                        if (items.equals("Y") || items.equals("y")) {
                            System.out.println("-----Which item do you want to use?-------");
                            System.out.println("----- Select your item from inventory -------");
                            character.showInventoryWithIndices();
                            System.out.println("----- The item's number -------");
                            int index = scan.nextInt();
                            Object obj = character.objList.get(index);
                            if (obj.getDescription().equals("Sword")) {
                                character_dmg = 10;
                                enemy.setHealth(enemy.getHealth() - character_dmg);
                                break;
                            } else if (obj.getDescription().equals("Potion Health")) {
                                int temp_heal = character.getHealth();
                                character.setHealth(temp_heal + 5);
                                break;
                            } else if (obj.getDescription().equals("Magic Clock")) {
                                character_dmg = 2;
                                enemy.setHealth(enemy.getHealth() - character_dmg);
                                break;
                            }
                        }
                    }

                    if (randomResponse() == 1) {
                        System.out.println("-----Succesfull attack-------");
                        enemy.setHealth(enemy.getHealth() - character_dmg);
                        if (randomResponse() == 1) {
                            System.out.println("-----You've been attack-------");
                            character.setHealth(character.getHealth() - 2);

                        }
                    } else {
                        System.out.println("-----Attack dodged by Enemy-------");
                    }
                    //Add random event Status Done
                    break;
                case "Z":
                case "z":
                    if (randomResponse() == 0) {
                        if (randomResponse() == 1) {
                            System.out.println("-----You've been attack-------");
                            character.setHealth(character.getHealth() - 2);
                        }
                    } else {
                        System.out.println("-----Attack dodged-------");
                    }
                    //System.out.println("Not implemented");
                    // Defend STATUS DONE
                    break;
                default:
                    System.out.println("Wrong command please try again");
                    break;
            }
            System.out.println(ConsoleColors.GREEN_BOLD_BRIGHT);
            clearScreen();
            if (character.getHealth() < 0) {
                System.out.println("------You died-------");
                endGame = true;
            }
        }
    }

    public static void battleEnemy(Personnage character, Personnage enemy) {
        //clearScreen();

        System.out.println("You are about to battle " + enemy.getName());
        //System.out.println("Press Y to continue");

        //Scanner scan = new Scanner(System.in);
        //String command = scan.nextLine();

        battle_enemy = "Y";
        generateBattleScreen(character, enemy);
        //clearScreen();
    }


    public static void collectObject(Personnage character, Object obj) {
        clearScreen();

        System.out.println("You are about to collect item" + obj.getDescription());
        System.out.println("If you don't collect it you can't go back to get it");
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
                    clearScreen();
                    System.out.println("Unsupported command please try again");
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
            // NOW IT'S A FEATURE :))))
            System.out.println("Character to battle");
            battleEnemy(character, (Personnage) element);
            level.deleteElement(i, j);
            level.setElement(i, j, character);
        } else if (element.getType().equals(types.OBJECT)) {
            Object obj = (Object) element;
            collectObject(character, obj);
            //TODO : The items is deleted, can't pe retrived back,
            //TODO: Need this bug to be fixed ASAP
            // NOW IT'S A FEATURE :))))
            if (collect_command.equals("Y")) {
                level.deleteElement(i, j);
                level.setElement(i, j, character);
            } else {
                level.setElement(i, j, character);
            }
        }
        int all_enemies = 0;
        for (int k = 0; k < low_level.length; k++) {
            for (int t = 0; t < low_level.length; t++) {
                //TODO : It throws a nullPointerException and if it does just skip
                try {
                    Element el = level.getElement(k, t);
                    if (el.getType().equals(types.PERSONAGE))
                        all_enemies++;
                } catch (Exception e) {
                    continue;
                }
            }
        }
        nr_enemies = all_enemies - 2;
        System.out.println("Enemies to battle : " + (all_enemies - 2));
    }

    public static void listOfCommand() {
        ArrayList<String> listCommands = new ArrayList<>(Arrays.asList("Help --help", "Inventory - I/i", "Up - W/w\nDown - S/s\nLeft - A/a\nRight - D/d", "Exit - stop", "R - Kill PID", "It supports lowercase as well as uppercase", "Attack - X/x", "Defend - Z/z", "Inventory detailed - ID/id"));
        for (String str : listCommands) {
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
                        System.out.print(ConsoleColors.ANSI_CYAN + "T" + ConsoleColors.RESET + ConsoleColors.YELLOW_BOLD);
                    else if (my_element.getType().equals(types.PERSONAGE)) {
                        if (my_element.getDescription().equals(character.getDescription()))
                            System.out.print(ConsoleColors.GREEN_BOLD + "P" + ConsoleColors.ANSI_RESET + ConsoleColors.YELLOW_BOLD);
                        else
                            System.out.print(ConsoleColors.RED_BOLD + "Y" + ConsoleColors.ANSI_RESET + ConsoleColors.YELLOW_BOLD);
                    } else
                        System.out.print("Z");
                }
            }
            System.out.println();
        }

        if (nr_enemies == 0) {
            System.out.println(ConsoleColors.GREEN_BOLD + "Won" + ConsoleColors.ANSI_RESET);
            endGame = true;
            System.exit(0);
        }
    }


    /*Movement & abilities commands*/

    public static void characterMovement(Personnage character, Niveau level) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        clearScreen();
        while (true) {
            switch (command) {
                case "W":
                case "w":
                    try {
                        updateMap(character, level, command, cord_X - 1, cord_Y);
                        level.deleteElement(cord_X, cord_Y);
                        cord_X = cord_X - 1;
                        cord_Y = cord_Y;
                        break;
                    } catch (Exception e) {
                        System.out.println("----The Character cant move there------");
                        break;
                    }
                case "S":
                case "s":
                    try {
                        updateMap(character, level, command, cord_X + 1, cord_Y);
                        level.deleteElement(cord_X, cord_Y);
                        cord_X = cord_X + 1;
                        cord_Y = cord_Y;
                        break;
                    } catch (Exception e) {
                        System.out.println("----The Character cant move there------");
                        break;
                    }
                case "A":
                case "a":
                    try {
                        updateMap(character, level, command, cord_X, cord_Y - 1);
                        level.deleteElement(cord_X, cord_Y);
                        cord_X = cord_X;
                        cord_Y = cord_Y - 1;
                        break;
                    } catch (Exception e) {
                        System.out.println("----The Character cant move there------");
                        break;
                    }
                case "D":
                case "d":
                    try {
                        updateMap(character, level, command, cord_X, cord_Y + 1);
                        level.deleteElement(cord_X, cord_Y);
                        cord_X = cord_X;
                        cord_Y = cord_Y + 1;
                        break;
                    } catch (Exception e) {
                        System.out.println("----The Character cant move there------");
                        break;
                    }
                case "I":
                case "i":
                    System.out.println(character.afficheInventarie());
                    break;
                case "ID":
                case "id":
                    character.showInventoryWithIndices();
                    break;
                case "R":
                    System.out.println(ConsoleColors.CYAN + "THANKS FOR PLAYING" + ConsoleColors.RESET);
                    System.exit(0);
                    break;
                case "-help":
                    clearScreen();
                    listOfCommand();
                    break;
                case "stop":
                    endGame = true;
                    System.out.println(ConsoleColors.CYAN + "THANKS FOR PLAYING" + ConsoleColors.RESET);
                    System.exit(0);
                case "god_mode":
                    character.setMaxHealth(100000);
                    character.setAttackPower(1000000);
                default:
                    clearScreen();
                    System.out.println("Unsupported command please try again");
            }
            //clearScreen();
            System.out.println("------UPDATE--------");
            listOfCommand();
            break;
        }
    }

    /*Tried something to clear the output didnt work
     * Ended up doing this*/
    /*public static void clearScreen() {
        for (int i = 0; i < 20; i++)
            System.out.println();
        System.out.println("---------Update-------------");
    }*/


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
        Personnage main_character_boy = new Personnage("MemeMaster Alex", 15, 150);
        Personnage main_character_girl = new Personnage("Hawkeye Iulia", 15, 150);

        Personnage dummy = new Personnage("Dummy", 1, 1);
        Personnage oger = new Personnage("Skeleton", 10, 10);
        Personnage archer = new Personnage("General Grievous", 25, 25);

        list_char.add(main_character_boy);
        list_char.add(main_character_girl);

        list_objects.add(sword);
        list_objects.add(magic_clock);
        list_objects.add(potion);
        list_objects.add(magic_clock);
        list_objects.add(potion);
        list_objects.add(potion);
        list_objects.add(potion);


        list_enemies.add(dummy);
        list_enemies.add(dummy);
        list_enemies.add(oger);
        list_enemies.add(archer);

        nr_enemies = list_enemies.size();

    }


    public static Niveau generateLevel(Niveau level, ArrayList<Object> objectArrayList, ArrayList<Personnage> enemies) {
        Random rng = new Random();

        for (Object obj : objectArrayList) {
            level.setElement(rng.nextInt(8), rng.nextInt(8), obj);
        }

        for (Personnage enemy : enemies) {
            level.setElement(rng.nextInt(8), rng.nextInt(8), enemy);
        }

        return level;
    }

    public static void showGameDetails() {
        System.out.println(ConsoleColors.PURPLE_BOLD_BRIGHT + "This game was made using Java with JDK15");
        System.out.println("Was made for the OOP Course");
        System.out.println("Authors:");
        System.out.println("\t Andrei Cristiana");
        System.out.println("\t Nae Sebastian-Ion");
        System.out.println("We're glad that you wanted to play it");
    }

    public static Personnage StartGame(ArrayList<Personnage> character_list) {
        int i = 0;
        System.out.println("------Select your character-------");
        for (Personnage p : character_list) {
            System.out.println(i + " " + p.toString());
            i++;
        }
        System.out.println("-----Please select an option --------");
        Scanner scanner = new Scanner(System.in);
        Integer index = scanner.nextInt();
        firstLevel.setElement(0, 0, character_list.get(index));
        generateLevel(firstLevel, list_objects, list_enemies);
        return character_list.get(index);
    }

    public static void mainMenu() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println(ConsoleColors.PURPLE_BOLD_BRIGHT + "-----RPG Game : MEMES LAND --------");
            System.out.println(ConsoleColors.PURPLE_BOLD_BRIGHT + "1.Start game");
            System.out.println(ConsoleColors.PURPLE_BOLD_BRIGHT + "2.See options");
            System.out.println(ConsoleColors.PURPLE_BOLD_BRIGHT + "3.Show details about the game");
            System.out.println(ConsoleColors.PURPLE_BOLD_BRIGHT + "4.Quit game");
            System.out.println(ConsoleColors.PURPLE_BOLD_BRIGHT + "-----Please select an option --------");
            String comand = scanner.nextLine();
            switch (comand) {
                case "1":
                    Personnage character = StartGame(list_char);
                    while (endGame == false) {
                        //listOfCommand();
                        showLevel(firstLevel, character);
                        characterMovement(character, firstLevel);
                    }
                    clearScreen();
                    System.out.println(ConsoleColors.GREEN_BOLD + "-----Game Ended---------");
                    System.out.println(ConsoleColors.ANSI_RESET);
                    break;
                case "2":
                    listOfCommand();
                    break;
                case "3":
                    showGameDetails();
                    break;
                case "4":
                    System.out.println(ConsoleColors.YELLOW_BOLD + "Thanks for playing");
                    System.out.println(ConsoleColors.ANSI_RESET);
                    System.exit(0);
                    break;
                default:
                    System.out.println(ConsoleColors.RED_BOLD + "Wrong command");
                    break;
            }
        }
    }

    public static void main(String[] args) {
        initAll();
        mainMenu();
    }
}
