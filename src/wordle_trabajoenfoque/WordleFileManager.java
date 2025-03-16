/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wordle_trabajoenfoque;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mario Garcia Tortosa
 */
public class WordleFileManager {

//VARIABLES, ARRAY Y OBJETOS READER
    FileReader archivo;
    BufferedReader lector;
    String[] lista;
    static BufferedWriter escritor;

//MÉTODO PARA LEER LA LISTA DE PALABRAS. EL PARÁMETRO ÉS LA RUTA DE ACCESO AL .TXT
    public void ListaPalabra(String dirección) {

        lista = new String[100];
        //BLOQUE TRY - CATCH QUE COMPRUEBE QUE EL ARCHIVO ES CORRECTO
        try {
            archivo = new FileReader(dirección);
            if (archivo.ready()) {
                lector = new BufferedReader(archivo);

                //BUCLE FOR PARA CARGAR LAS PALABRAS DE LA LISTA EN EL ARRAY "LISTA"
                for (int i = 0; i < lista.length; i++) {
                    lista[i] = lector.readLine();
                }

            } else {
                System.err.println("El archivo no está listo.");
            }

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }

    }
    
   
//MÉTODO PARA GUARDAR LAS PALABRAS INTRODUCIDAS POR EL USUARIO (triesHistory) EN UN .TXT ESPECIFICADO EN DIRECCION    
public void GuardarPartida(String direccion, String[] lista){
        try {
            escritor = new BufferedWriter(new FileWriter(direccion));
                        
            for (String palabra : lista){
                if (palabra != null){
                    escritor.write(palabra.toUpperCase() + "\n");
                }
            }
            escritor.close();
            
        } catch (IOException ioe) {
            System.err.println("Error en el archivo: " + ioe.toString());;
        }
    }

   
       
    }


