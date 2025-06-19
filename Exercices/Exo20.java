package Exercices;

import java.util.Scanner;

public class Exo20 {

    static Scanner sc = new Scanner(System.in);

    public static String calculElection(int votant) {

        System.out.println("Combien de gens ont voté pour Joseline Inutile ?"); // Affiche la question demandé
        double voteJose = sc.nextInt(); // donne le nombre donné par l'utilisateur

        System.out.println("Combien de gens ont voté pour Vincent Escreau ?"); // Affiche la question demandé
        double voteVince = sc.nextInt(); // donne le nombre donné par l'utilisateur

        if (voteJose + voteVince > votant || voteJose < 0 || voteVince < 0) {
            String error = "Erreur, le total des votes est invalide.";
            System.out.println(error);
            return error;
        }

        double blanc = votant - (voteJose + voteVince); // Calcul le reste en vote blanc
        System.out.println("Vous avez " + Math.round(blanc) + " d'abstentions, ils seront compté nul"); // Affiche le vote blanc en arrondissant
            
        double resultJose = (voteJose * 100) / (votant - blanc); // Calcul le pourcentage des votes de Joseline
        double resultVince = (voteVince * 100) / (votant - blanc); // Calcul le pourcentage des votes de Vincent

        System.out.println("Joseline Inutile : " + Math.round(resultJose * 10.0) / 10.0 + "%"); // Affiche le résultat en arrondissant à un nombre après la virgule
        System.out.println("Vincent Escreau : " + Math.round(resultVince * 10.0) / 10.0 + "%");

        if (resultJose >= 60) { // Si le pourcentage de votes de Joseline est supérieur ou égale à 60
            String jose = "Joseline Inutile est la nouvelle maire de Mulhouse";
            System.out.println(jose);
            return jose;

        } else if (resultVince >= 60) { // Si le pourcentage de votes de Vincent est supérieur ou égale à 60
            String vince = "Vincent Escreau est le nouveau Maire de Mulhouse";
            System.out.println(vince);
            return vince;

        } else {
            String secondTour = "Il y aura un second tour";
            System.out.println(secondTour);
            return secondTour;

        } 
    }
    public static void main(String[] args) {

        int votant = 150000;

        try {

            if (votant < 0) {
                System.out.println("Erreur, nombre de votants invalide");
                return;

            }
            calculElection(votant);
            

        } catch (Exception e) {

            System.out.println("Erreur de saisi !");
        }

    }
}
