package Jalon_niv3;

import java.util.List;
import java.util.Scanner;

public class OtherMethods {

    static Scanner sc = new Scanner(System.in);

    public static double calculPrix(int age, double prixInit) { // Fonction qui calcul le prix initiale en fonction de l'âge de la personne
        if (age < 18 || age > 60) {
            return prixInit * 0.2;
        }
        return prixInit * 0.4;
    }

    public static boolean questionYesNo(String question) { // Fonction qui retourne en boolean les questions oui et non

        while (true) {

            System.out.print(question);
            List<String> positive = List.of("o", "oui", "y", "yes", "t", "true" );
            List<String> negative = List.of("n", "non", "no", "f", "false");

            try {
                String response = sc.nextLine().trim().toLowerCase();

                if (positive.contains(response)) {
                    return true;
                } else if (negative.contains(response)) {
                    return false;
                }
            } catch (Exception e) {
                System.out.println("Répondez par oui ou non");
            }
        }
    }

    public static String capitalize(String inputString) { // Fonction qui de mettre seulement en majuscule la première lettre d'un mot
        if (inputString == null || inputString.isEmpty()) { // Retourne la chaîne originale si elle est nulle ou vide
            return inputString;
        }
        char firstLetter = inputString.charAt(0); // Prend la première lettre de la chaîne
        char capitalFirstLetter = Character.toUpperCase(firstLetter); // La convertit en majuscule

        return inputString.replace(inputString.charAt(0), capitalFirstLetter); // La retourne dans la chaîne de caractère avec le majuscule
    }
}
