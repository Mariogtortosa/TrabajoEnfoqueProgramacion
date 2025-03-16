/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wordle_trabajoenfoque;

import java.util.HashMap;



/**
 *
 * @author Mario Garcia Tortosa
 */
public class WordleFeedBack {

    private static final int WORD_LENGTH = 5;
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[13m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

//MÉTODO PARA APLICAR COLOR
    private static String applyColor(String letter, String color) {
        String letra = "";
        if (color.equalsIgnoreCase("rojo")) {
            letra = ANSI_RED + letter + ANSI_RESET;
        } else if (color.equalsIgnoreCase("verde")) {
            letra = ANSI_GREEN + letter + ANSI_RESET;
        } else if (color.equalsIgnoreCase("naranja")) {
            letra = ANSI_YELLOW + letter + ANSI_RESET;
        }
        return letra;
    }

    public static String feedBackString(String guess, String secretWord) {
        StringBuilder feedback = new StringBuilder();
        //HashMap<Character, Integer> contador = new HashMap <>();
        //HashMap<Character, Integer> contador_2 = new HashMap <>();
        
        /*//CONTADOR DE LETRAS
        for (char l : guess.toLowerCase().toCharArray()){
            contador.put(l, contador.getOrDefault(l, 0) + 1);
        }
        
        for (char r : secretWord.toLowerCase().toCharArray()){
            contador_2.put(r, contador_2.getOrDefault(r, 0) + 1);
        }
        
        System.out.println(contador);
        System.out.println(contador_2);*/
        
          
       for (int i = 0; i < secretWord.length(); i++) {

            char letra = Character.toLowerCase(guess.charAt(i));
            char letraSecreta = Character.toLowerCase(secretWord.charAt(i));

            if (letra == letraSecreta) {
                
                String a = String.valueOf(guess.charAt(i)).toUpperCase();
                feedback.append(applyColor(a, "verde"));
                //contador.put(letra, contador.get(letra) -1 );
                
               } else if (secretWord.toLowerCase().contains(String.valueOf(letra))) {
                String a = String.valueOf(guess.charAt(i)).toUpperCase();
                feedback.append(applyColor(a, "naranja"));
                //contador.put(letra, contador.get(letra) -1 );
            
            } else {
                String a = String.valueOf(guess.charAt(i)).toUpperCase();
                feedback.append(a);
            }
        }
       
      // System.out.println(contador);
        String resultado = feedback.toString();
        return resultado;
    }

}
