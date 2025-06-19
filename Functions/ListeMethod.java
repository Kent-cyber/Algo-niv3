package Functions;

import java.util.ArrayList;

public class ListeMethod {

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
}
