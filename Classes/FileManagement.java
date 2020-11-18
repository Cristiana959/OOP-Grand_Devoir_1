/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idlegame;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author crist
 */
public class FileManagement {
    
    //function that reads the user data from file
     public  Profil lecture(String file){
        
    FileReader fr = null;
    Profil p = new Profil();
   
    
        try {
           fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String strLine;
            String[] str ;
            
            
            
            while((strLine = br.readLine()) != null){
                 str = strLine.split("/");
                 
            
                 p = new Profil(str[0],  Double.parseDouble(str[1]), Integer.parseInt(str[2]), Integer.parseInt(str[3]),Integer.parseInt(str[4]),Integer.parseInt(str[5]),Integer.parseInt(str[6]),Integer.parseInt(str[7]),Integer.parseInt(str[8]),Integer.parseInt(str[9]),Integer.parseInt(str[10]),Integer.parseInt(str[11]));
                 
                 /* System.out.println(list.get(0));
                
                Money.setTotalMoney(Double.parseDouble(str[1]));
                Cereale.setNombreTotalCereale(Integer.parseInt(str[2]));
                Bois.setNombreTotalBois(Integer.parseInt(str[3]));
                Fer.setNombreTotalFer(Integer.parseInt(str[4]));
                Argent.setNombreTotalArgent(Integer.parseInt(str[5]));
                Roche.setNombreRoches(Integer.parseInt(str[6]));
                Verre.setNombreVerre(Integer.parseInt(str[7]));
                
                
                batimentList.add(Integer.parseInt(str[8]));
                batimentList.add(Integer.parseInt(str[9]));
                batimentList.add(Integer.parseInt(str[10]));
                batimentList.add(Integer.parseInt(str[11]));
                
             
            
            p.setBatiments(batimentList);
            p.setRessources(ressourceList);*/
            } } catch (IOException ex) {
            Logger.getLogger(Profil.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
          
              try {
                  fr.close();
              } catch (IOException ex) {
                  Logger.getLogger(Profil.class.getName()).log(Level.SEVERE, null, ex);
              }
          }
        
     return p;
    }
     public ArrayList sauvegardeRessources(Profil p){
       ArrayList list = new ArrayList();

       list.add(0, Money.getTotalMoney()); 
       list.add(1, Cereale.getNombreTotalCereale());
       list.add(2, Bois.getNombreTotalBois());
       list.add(3, Fer.getNombreTotalFer());
       list.add(4, Argent.getNombreTotalArgent());
       list.add(5, Roche.nombreTotalRoches);
       list.add(6, Verre.nombreTotalVerre);
       return list;
    }
     public ArrayList sauvegardeBatiments(Profil p){
       ArrayList list = new ArrayList();

       list.add(0, Ferme.getNombreDeFermes()); 
       list.add(1, Scierie.getNombreDeScieries());
       list.add(2, MineFer.getNombreDeMinesFer());
       list.add(3, MineArgent.getNombreDeMinesArgent());
      
       return list;
    }
    
     //function that writes the user's progress in a file
     public  void sauvegarde(Profil p){
         try {
             File outFile = new File("userProgress.txt");
             outFile.createNewFile();
             FileWriter fw = null;
             try {
                 fw = new FileWriter(outFile);
                 
                 String nom = p.getNomDeJoueur();
                 fw.write(nom);
                 fw.write("\n");
                 fw.write(sauvegardeRessources(p).toString());
                 fw.write("\n");
                 fw.write(sauvegardeBatiments(p).toString());
                 
             } catch (IOException ex) {
                 Logger.getLogger(FileManagement.class.getName()).log(Level.SEVERE, null, ex);
             } finally {
                 try {
                     fw.close();
                 } catch (IOException ex) {
                     Logger.getLogger(FileManagement.class.getName()).log(Level.SEVERE, null, ex);
                 }
             }
         } catch (IOException ex) {
             Logger.getLogger(FileManagement.class.getName()).log(Level.SEVERE, null, ex);
         }
     }
}
