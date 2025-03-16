/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package wordle_trabajoenfoque;

import java.util.Scanner;

/**
 *
 * @author Mario Garcia Tortosa
 *
 * Esta clase debe contener toda la lógica principal del juego Debe contar con
 * varios métodos que gestionen las palabras, la interacción con el usuario y la
 * retroalimentación en cada intento
 */
public class WorldeGame {

    private int max_tries;
    private int word_length;
    private String[] fileWords;
    private String secretWord;
    private int remainingAttempts;
    private String[] triesHistory;
    private String userWord;

    //CONSTRUCTORES
    public WorldeGame() {
        max_tries = 6;
        word_length = 5;
        secretWord = "";
        remainingAttempts = max_tries;

    }

    public WorldeGame(int max_tries, int word_length, String[] fileWords, String secretWord, int remainingAttempts, String[] triesHistory, String userWord) {
        this.max_tries = max_tries;
        this.word_length = word_length;
        this.fileWords = fileWords;
        this.secretWord = secretWord;
        this.remainingAttempts = remainingAttempts;
        this.triesHistory = triesHistory;
        this.userWord = userWord;

        //GETTERS
    }

    public int getMax_tries() {
        return max_tries;
    }

    public int getWord_length() {
        return word_length;
    }

    public String[] getFileWords() {
        return fileWords;
    }

    public String getSecretWord() {
        return secretWord;
    }

    public int getRemainingAttempts() {
        return remainingAttempts;
    }

    public String[] getTriesHistory() {
        return triesHistory;
    }

    public String getUserWord() {
        return userWord;
    }

    //SETTERS
    public void setMax_tries(int max_tries) {
        this.max_tries = max_tries;
    }

    public void setWord_length(int word_length) {
        this.word_length = word_length;
    }

    public void setFileWords(String[] fileWords) {
        this.fileWords = fileWords;
    }

    public void setSecretWord(String secretWord) {
        this.secretWord = secretWord;
    }

    public void setRemainingAttempts(int remainingAttempts) {
        this.remainingAttempts = remainingAttempts;
    }

    public void setTriesHistory(String[] triesHistory) {
        this.triesHistory = triesHistory;
    }

    public void setUserWord(String userWord) {
        this.userWord = userWord;
    }

    //MÉTODOS

//MÉTODO PARA ESCOGER UNA PALABRA AL AZAR DE LA LISTA DE PALABRAS
    public String selectRandomWord(String[] words) {
        WordleFileManager palabra = new WordleFileManager();
        int numero = (int) (Math.random() * 101);

        palabra.ListaPalabra("Archivos/ListaPalabras.txt");
        secretWord = palabra.lista[numero];
        return secretWord;

    }

//MÉTODO PARA MOSTRAR POR PANTALLA LAS PALABRAS INTRODUCIDAS POR LA PERSONA
    public void showTriesHistory() {       
       for (String palabra : triesHistory){
           if (palabra != null){
              System.out.println(palabra.toUpperCase()); 
           }
       }
    }

    
//MÉTODO QUE PIDE AL USUARIO INGRESAR PALABRAS Y INDICA UN ERROR EN CASO DE QUE NO SEA DE LA LONGITUD ADECUADA
    public String getUserInput(Scanner teclado) {
        teclado = new Scanner(System.in);

        do {
            System.out.print("Introduce una palabra de " + word_length + " letras: ");
            userWord = teclado.next();
            if (userWord.length() != word_length) {
                System.err.println("Error! La palabra introducida no tiene " + word_length + " letras.");
            }
        } while (userWord.length() != 5);

        return userWord;

    }

//MÉTODO QUE INICIA LA PARTIDA
    public void start() {

        //VARIABLES Y OBJETOS
        Scanner teclado = new Scanner(System.in);
        WordleFileManager p = new WordleFileManager();
        p.ListaPalabra("Archivos/ListaPalabras.txt");
        int turno = 0;
        triesHistory = new String[max_tries];

        selectRandomWord(p.lista);

        System.out.println("Bienvenido/a a Wordle!");
        System.out.println("Intenta adivinar la palabra secreta, tienes " + max_tries + " intentos.");
        System.out.println("");

        // CON ESTE SYSTEMOUT SE PUEDE VER LA PALABRA SECRETA EN CONSOLA SI SE NECESITA HACER ALGUNA PRUEBA
        //System.out.println(secretWord);
        
//BUCLE QUE HACE ITERACIÓN HASTA QUE LA PERSONA ADIVINA LA PALABRA O SE QUEDA SIN INTENTOS
        do {

            triesHistory[turno] = getUserInput(teclado);
            System.out.println("");
            showTriesHistory();
            System.out.println("");
            System.out.println(WordleFeedBack.feedBackString(userWord, secretWord));

//SI EL USUARIO NO ACIERTA, MUESTRA EL MENSAJE
            if (!userWord.toLowerCase().equals(secretWord.toLowerCase())) {
                remainingAttempts--;

                System.out.println("Incorrecto! Te quedan " + remainingAttempts + " intentos.");

            }
            turno++;

        } while (!userWord.toLowerCase().equals(secretWord.toLowerCase()) && remainingAttempts != 0);

//SI GANA MUESTRA MENSAJE DE VICTORIA
        if (userWord.toLowerCase().equals(secretWord.toLowerCase())) {
            System.out.println("Enhorabuena! Has ganado la partida!");

//SI SE QUEDA SIN INTENTOS MUESTRA MENSAJE DE DERROTA
        } else {
            System.out.println("");
            System.out.println("Has perdido la partida :(");
            System.out.println("La palabra era: " + secretWord.toUpperCase());
        }
//MÉTODO PARA GUARDAR LA PARTIDA EN UN ARCHIVO DE TEXTO
        p.GuardarPartida("Archivos/GuardarPartida.txt", triesHistory);
    }

}
