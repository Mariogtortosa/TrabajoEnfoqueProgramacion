/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wordle_trabajoenfoque;

import com.sun.source.tree.TryTree;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mariogarsia
 */
public class RevisarLista {
  

    public static void main(String[] args) {
          File archivo = new File("/Users/mariogarsia/Desktop/Ejercicios_Java_MEDAC/Wordle_TrabajoEnfoque/Archivos/ListaPalabras.txt");
        FileReader fr = null;
        BufferedReader br = null;
        ArrayList <String> p = new ArrayList<>();
        
    
        try{
     fr = new FileReader(archivo);
        br = new BufferedReader(fr);
    
}catch (FileNotFoundException FnE){
            System.out.println(FnE.getMessage());
}
        String linea; 
        
      try{
          while ((linea = br.readLine()) != null){
              p.add(linea);
          }
      } catch (IOException IoE) {
          System.err.println(IoE.getMessage());
      }
      
        System.out.println(p.size());
        
    }
    
    
   
    
    
    
}
