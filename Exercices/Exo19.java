package Exercices;

import java.util.Scanner;

public class Exo19 {

    static Scanner sc = new Scanner(System.in);

    public static String calculHours(int seconds) {

        // Calcul des secondes en heures, minutes et secondes
        int S = seconds % 60; // Calcul les secondes restantes
        int H = seconds / 60; // Converti les secondes en minutes
        int M = H % 60; // Calcul les heures restantes en minutes
        H = H / 60; // Converti les heures en minutes

        String result = seconds + " secondes correspond à " + H + " heures, " + M + " minutes et " + S + " secondes";
        System.out.println(result);
        return result;
    }

    public static void main(String[] args) {


        System.out.println("Combien de secondes ?"); // Affiche le texte

        try {

            int seconds = sc.nextInt(); // Les secondes données par l'utilisateur
        
            calculHours(seconds);

        } catch (Exception e) {
            System.out.println("Erreur de saisi !");
        }
        
    }
}
