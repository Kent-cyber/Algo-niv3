package Exercices;

import java.util.Scanner;

public class Exo10 {

    static Scanner sc = new Scanner(System.in); // Déclaration du scanner

    public static String quiz(String[][] quiz) {

        int score = 0; // initialise le score à 0
        
        for (int i = 0; i < quiz.length; i++) { // Déroule chaque question et vérifie la réponse
            
            String question = quiz[i][0];
            String answer = quiz[i][1];

            System.out.println(question); //Affiche la question
            
            String userAnswer = sc.nextLine(); // Réponse de l'utilisateur
            
            if (userAnswer.equalsIgnoreCase(answer)) { // Vérifie les réponses et donne les points

                System.out.println("Bien joué !!");
                score++;

            } else {

                System.out.println("Dommage. La réponse est " + answer + ".");
            }
             
        }
        String resultat = "Ton score est " + score + " sur " + quiz.length + ".";

        System.out.println(resultat); // Affiche le résultat final
        return resultat;
    }
    public static void main(String[] args) {

        String[][] quiz = { // Quiz avec question et réponse
            {"Quelle est la capitale de la Suisse ?", "Berne"},
            {"Quelle est la plus grosse planète du système solaire ?", "Jupiter"},
            {"Quelle est la ville la plus peuplée du monde ?", "Tokyo"},
            {"Quel est le lac le plus grand de France ?", "Lac du Bourget"},
            {"Quel est le plus petit pays du monde ?", "Vatican"}
        };

        try {

            quiz(quiz);

        } catch (Exception e) {

            System.out.println("Erreur de saisi, veullez recommencer !");
        }

    }
}
