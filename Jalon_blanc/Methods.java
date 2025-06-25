package Jalon_blanc;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Methods {
    
    static Scanner sc = new Scanner(System.in); // Appelle le scanner

    public static String saisirDate(LocalDate dateDep) { // Demande à l'utilisateur de saisir une date valide
        
        while (dateDep == null) {
            try {
                System.out.print("Date de départ (dd/MM/yyyy) : ");
                dateDep = LocalDate.parse(sc.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                // Lire la date entrée par l'utilisateur
            } catch (DateTimeParseException e) {
                System.out.println("Date de format invalide, réessayez");
            }
        }
        return dateDep.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    public static boolean questionYesNo(String question) { // Pose une question à choix fermés

        while (true) {
            System.out.print(question);
            List<String> positive = List.of("o", "oui", "y", "yes", "t", "true");
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

        int id = 1;
        while (true) {
            System.out.println("\n=== Registre du produit ===");
            
            System.out.print("Nom du produit : ");
            String productName = sc.nextLine();

            String productType = "";
            while (productType.isEmpty()) {
                System.out.print("Type de produit : ");
                List<String> type = List.of("TV", "Electro-ménager", "Micro-Informatique", "Audio");

                try {
                    String response = sc.nextLine().trim();
                    if (type.contains(response)) {
                        productType = response;
                    } else {
                        System.out.println("Ce type de produit n'existe pas");
                    }
                } catch (Exception e) {
                    System.out.println("Répondez correctement");
                }
            }

            String dateProduct = saisirDate(null);
            boolean solde = questionYesNo("Est-il soldé (oui/non) ? ");

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

            String product = "ID : " + id + " | " + productName + " | " + productType + " | " + dateProduct
                            + " | " + (solde ? "Oui" : "Non") + " | " + prixFinal;
            
            products.add(product);
            id++;

            if (!questionYesNo("Ajouter un autre produit (oui/non) ? ")) break;
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
