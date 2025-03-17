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
   //VARIABLES 
        File archivo = new File("/Users/mariogarsia/Desktop/Ejercicios_Java_MEDAC/Wordle_TrabajoEnfoque/Archivos/ListaPalabras.txt");
        FileReader fr = null;
        BufferedReader br = null;
        ArrayList <String> p = new ArrayList<>();
        
   //BLOQUE TRY 1 (LEE EL ARCHIVO) 
        try{
        fr = new FileReader(archivo);
        br = new BufferedReader(fr);
    
}catch (FileNotFoundException FnE){
            System.out.println(FnE.getMessage());
}
        String linea; 
        
        
  //BLOQUE TRY 2 (AÑADE LÍNEAS MEDIANTE LA VARIABLE "linea" A LA ARRAYLIST "p")
        boolean correctas = true;
        int n_linea = 1;
      try{
          while ((linea = br.readLine()) != null){
              p.add(linea);
              
              if ((linea.length()) > 5 || (linea.length()) < 5){
                       System.err.println("Palabra con longitud érronea.");
                       System.err.println("La palabra es: " + linea + " y esta en la línea: " + n_linea);
                       correctas = false;
                   } 
              n_linea ++;
          }
      } catch (IOException IoE) {
          System.err.println(IoE.getMessage());
      }
      
      //MENSAJES DE CONFIRMACIÓN
      if (correctas == true){
          System.out.println("Todas las palabras tienen una longitud correcta.");
      } 
      if (p.size() == 100){
          System.out.println("En la lista hay un total de: " + p.size() + " palabras.");
      } else {
          System.err.println("El número de palabras de la lista no es correcto. Hay: " + p.size());
      }
       
    }
    
}
