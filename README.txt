Authors : Andrei Cristiana
	  Nae Sebastian

Groupe : 1220bF

Ex 2:

THE COMMANDS WORK WITH LOWERCASE LETTERS

Controls:D-display buildings/resources/type of user
         T-transform your resources
         B-build a new type of building
         C-collect the resources provided by the buildings
         S-save the progress
         X-exit

General rules:

You can collect resources 4 times/session.
The buildings can be built only by using money, except for the house.
You must use rocks and glass to build the house.
Cereals, wood, iron and silver can be transformed into money or rocks or glass.

CLASS IdleGame IS THE TEST CLASS

In the Classes folder are all of the java classes used for the project

In the Windows Runner are the jar file, run.bat and run.py You need to have Python3 installed for the script to run

In the Linux Runner are the jar file, run.sh 

In the macOS Runner are the jar file, run.sh

Windows : Double click the run.bat file
Linux & macOS : Run the run.sh file


Modifications from the original task:

Class Profil:
-a new method displayBuildings()-displays the current number of each type of building
-a new method displayResources()-display the current number of each type of resource
-a new method TypeUtilisateur()-returns the type of user you are by the largest number of buildings 
                                from all the type of buildings

Class Batiment:
-a new method fournitLaRessource()-adds the revenue/second to the total number of resource given by each building
-a new method augumenterRevenu()-increments the revenu/second each time you build a new building
-the method incrementerLeNombreDeBatiments(int i) is not used, instead each class that inherits the class Batiment
 has an attribut (ex:nombreDeFermes) that is incremented in the constructor each time the class is instanciated

Classes Ferme, Scierie, MineFer, MineArgent, Maison:
-the functions augumenterCoutConstruction(double f) and augumenterRevenu() are called in the constructor so that
each time you build a new building of a certain type the next one will be more expensive, but the revenue for all the other buildings
of this type will increase

Class Ressource:
-this class is abstract
-the method incrementerRevenueCereale() isn't used, as it was moved in class Batiment

Classes Cereale, Bois, Fer, Argent:
-new classes that inherit class Ressource
-the method utiliserRessource()-transforms the resource into money
-the method convertirRoche()-transforms the resource into rocks
-the method convertirVerre()-transforms the resource into glass

Classes Roche, Verre:
-new classes that inherit class Ressource
-the method utiliserResource()-used to build the house

Class Money:
-new class that stores the total balance of the user

 


         