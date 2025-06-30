package Jalon_blanc;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import Functions.*; // Appelle à mes méthodes que j'ai crée

public class Methods {
    
    static Scanner sc = new Scanner(System.in); // Appelle le scanner

    public static double calculPrix(String dateProduct, boolean solde, double prixInit) { // Calcul le prix final en fonction de la date et du solde
        LocalDate dtf = LocalDate.parse(dateProduct, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        long mois = ChronoUnit.MONTHS.between(dtf, LocalDate.now());
        double prixFinal = prixInit;

        if (mois >= 4) {
            prixFinal -= prixInit * 0.1;

        } else if (solde) {
            prixFinal -= prixInit * 0.4;
        }
        return prixFinal;
    }

    public static void ajoutProduits(ArrayList<String> products, ArrayList<Integer> ids) { // Ajoute des produits à la liste en demandant les informations à l'utilisateur

        int id = 1; // Initialise l'ID
        while (true) {
            System.out.println("\n=== Registre du produit ===");
            
            System.out.print("Nom du produit : ");
            String productName = sc.nextLine();

            String productType = "";
            while (productType.isEmpty()) { // Tant que l'utilisateur n'a pas répondu la chaîne de caractères reste vide
                System.out.print("Type de produit (tv / électro-ménager / micro-informatique / audio) : ");
                List<String> type = List.of("tv", "électro-ménager", "micro-informatique", "audio"); // Créer la liste des types de produits

                try {
                    String response = sc.nextLine().trim().toLowerCase();
                    if (type.contains(response)) {
                        productType = StringMethod.capitalize(response);
                    } else {
                        System.out.println("Ce type de produit n'existe pas'");
                    }
                } catch (Exception e) {
                    System.out.println("Répondez correctement");
                }
            }

            String dateProduct = DateMethod.saisirDate(null); // Rentre la date en chaîne de caractères
            boolean solde = ListeMethod.questionYesNo("Est-il soldé (oui/non) ? ");

            double prixInit = 0;
            while (prixInit <= 0) {
                try {
                    System.out.print("Prix initial : ");
                    prixInit = Double.parseDouble(sc.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Veuillez entrer un prix valide");
                }
            }

            double prixFinal = calculPrix(dateProduct, solde, prixInit);
            ids.add(id);

            // Récapitule le produit dans son ensemble
            String product = "ID : " + id + " | " + StringMethod.capitalize(productName) + " | " + productType + " | " + dateProduct
                            + " | " + (solde ? "Oui" : "Non") + " | " + prixFinal;
            
            products.add(product); // Ajoute à la liste des produits
            id++;

            if (!ListeMethod.questionYesNo("Ajouter un autre produit (oui/non) ? ")) break; // Si l'utilisateur dit non la boucle s'arrête
        }
    }

    public static void afficherListe(ArrayList<String> products) { // Affiche tous les produits enregistrés
        System.out.println("\n=== Liste des produits ===");
        for (String product : products) {
            System.out.println(product);
        }
    }

    public static void rechercherParId(ArrayList<String> products, ArrayList<Integer> ids) { // Recherche le produit par l'ID
        int idRecherche = 0;
        while (idRecherche <= 0) {
            try {
                System.out.print("Recherchez par ID (Entrez l'ID) : ");
                idRecherche = Integer.parseInt(sc.nextLine());
                if (ids.contains(idRecherche)) {
                    System.out.println("Produit trouvé : " + products.get(ids.indexOf(idRecherche)));
                } else {
                    System.out.println("Aucun produit avec cet ID");
                }
            } catch (NumberFormatException e) {
                System.out.println("Veuillez entrer un ID valide");
            }
        } 
    }

    public static void supprimerListe(ArrayList<String> products, ArrayList<Integer> ids) { // Supprime le produit de la liste par son ID
        int idSupp = 0;
        while (idSupp <= 0) {
            try {
                System.out.print("Supprimer par ID (Entrez l'ID) : ");
                idSupp = Integer.parseInt(sc.nextLine());
                if (ids.contains(idSupp)) {
                    int index = ids.indexOf(idSupp);
                    ids.remove(index);
                    products.remove(index);
                    System.out.println("Produit supprimé avec succès");
                } else {
                    System.out.println("Aucun produit avec cet ID");
                }
            } catch (NumberFormatException e) {
                System.out.println("Veuillez entrer un ID valide");
            }
        } 
    }
}
