package Functions;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListeMethod {

    static Scanner sc = new Scanner(System.in);

    public static void afficherListe(ArrayList<String> stagiaire) {

        for (String nom : stagiaire) {
            System.out.println(nom);
        }
    }

    public static void trouverNoms(ArrayList<String> stagiaire, String searchName) {

        if (stagiaire.contains(searchName)) {

            System.out.println(searchName + " existe dans la liste");

        } else {

            System.out.println("Nom introuvable");
        }
    }

    public static void supprimerNoms(ArrayList<String> stagiaire, String searchName) {

        if (stagiaire.contains(searchName)) {

            stagiaire.remove(searchName);
            System.out.println(searchName + " a été supprimé");

        } else {

            System.out.println("Nom introuvable");
        }
    }

    public static boolean questionYesNo(String question) {

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
                System.out.println("Répondez par un des choix proposés");
            }
        }
    }
}
