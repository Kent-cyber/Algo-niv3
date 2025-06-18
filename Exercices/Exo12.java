package Exercices;

import java.util.Scanner;

public class Exo12 {

    public static String reduc(double prix) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Votre réduction (en pourcentage %)");
        double reduc = sc.nextDouble(); // la réduction donné en pourcentage par l'utilisateur
        sc.close();
        double sum = prix * (1 - reduc / 100);

        String result = "Prix final après réduction de " + Math.round(reduc) + " : " + Math.round(sum*100.0)/100.0;
        System.out.println(result);
        return result;
    }
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in); // Création du scanner
        System.out.println("Donnez un prix ?");

        try {

            double prix = sc.nextDouble(); // prix donné par l'utilisateur
            reduc(prix);

        } catch (Exception e) {

            System.out.println("Erreur de saisi, veuillez recommencer !");
            main(args);
        }

        sc.close();
    }
}
