package Jalon_niv3;

import java.time.*;
import java.time.format.*;
import java.util.*;

public class MenuMethods {
    static Scanner sc = new Scanner(System.in); // Appelle le scanner

    public static void afficherRDV(ArrayList<String> rdvs) { // Fonction qui affiche tous les rendez-vous enregistrés
        if (rdvs.isEmpty()) { // Vérifie si la liste n'est pas vide
            System.out.println("Aucun Rendez-vous");
            return;
        }
        System.out.println("\n=== Liste des rendez-vous ==="); // Affiche la liste
        for (String rdv : rdvs) {
            System.out.println(rdv);
        }
    }

    public static void ajoutRDV(ArrayList<String> rdvs, ArrayList<String> referenceCode, ArrayList<LocalDateTime> datesRDV) { // Fonction qui ajoute un rendez-vous avec les informations demandées
        Map<String, String> labelle = Map.of( // Création de l'objet Java Map avec les clés (initial) et leurs valeurs (consultation)
            "BS", "Bilan de santé", 
            "CD", "Cardiologie",
            "VC", "Vaccinations",
            "CM", "Certification médical",
            "GN", "Général",
            "SM", "Suivi médical"
        );

        Map<String, Double> tarifs = Map.of( // Idem avec les prix de ces initiales
            "BS", 120.0,
            "CD", 200.0,
            "VC", 0.0,
            "CM", 100.0,
            "GN", 70.0,
            "SM", 60.0
        );

        while (true) {
            System.out.println("\n=== Registre de rendez-vous");
            System.out.print("Nom : ");
            String nom = OtherMethods.capitalize(sc.nextLine()); // le mettre sous forme de la méthode captalize()
            System.out.print("Prénom : ");
            String prenom = OtherMethods.capitalize(sc.nextLine());

            int age = 0;
            while (age <= 0 || age >= 120) {
                try {
                    System.out.print("Age : ");
                    age = Integer.parseInt(sc.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Veuillez entrer un âge valide");
                }
            }

            System.out.println("Voici les types de consultation :"); // Affiche les consultations disponibles et leurs initiales
            for (String code : labelle.keySet()) {
                System.out.printf("%s - %s %n", code, labelle.get(code));
            }

            String inputcode = null;
            while (true) {
                System.out.print("Choisissez en tapant le code : ");
                inputcode = sc.nextLine().toUpperCase();
                if (labelle.containsKey(inputcode)) break;
                System.out.println("Code invalide");
            }
            
            LocalDateTime date;
            while (true) {
                date = DateMethods.saisirDateHeure(null); // Entre la date avec des paramètres de la fonction
                if (!datesRDV.contains(date)) {
                    datesRDV.add(date);
                    break;
                } else {
                    System.out.println("Un rendez-vous existe déjà à cette date et heure. Veuillez entrer une autre");
                }
            }
            
            // Chaîne de caractère du code de référence demandé par le client
            String initialeCode = prenom.substring(0, 1).toUpperCase() + nom.substring(0, 1).toUpperCase() +
                date.format(DateTimeFormatter.ofPattern("yyyyMMddHHmm")) + inputcode;
            referenceCode.add(initialeCode);

            double prixInit = 0;
            while (prixInit <= 0) {
                try {
                    System.out.print("Prix initial : ");
                    prixInit = Double.parseDouble(sc.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Veuillez entrer un prix valide");
                }
            }

            double prixFinal = OtherMethods.calculPrix(age, prixInit); // Calcul le prix donné

            // chaîne de caractère qui récapitule les données enregistrées et les mettre dans la liste
            String recapRDV = "Nom et prénom : " + nom + " " + prenom + 
                "\nAge : " + age + 
                "\nType de consultation : " + labelle.get(inputcode) +
                "\nDate et heure de rendez-vous : " + date.format(DateTimeFormatter.ofPattern("EEEE d MMMM yyyy à HH:mm", Locale.FRANCE)) +
                "\nCode de référence : " + initialeCode + 
                "\nPrix total de la consultation : "+ tarifs.get(inputcode) + 
                "\nPrix total du client : " + prixFinal;
            rdvs.add(recapRDV);

            if (!OtherMethods.questionYesNo("Ajouter un autre rendez-vous (oui/non) ? ")) break; // Si l'utilisateur dit non la boucle s'arrête
        }
    }

    public static void modifierRDV(ArrayList<String> rdvs, ArrayList<String> referenceCode) { // Fonction qui permet de modifier les rendez-vous
        System.out.print("Entrez un fragment du code de référence : ");
        String inputcode = sc.nextLine().trim().toUpperCase();

        boolean found = false;
        for (int i = 0; i < rdvs.size(); i++) {
            String rdv = rdvs.get(i);
            if (referenceCode.contains(inputcode)) {
                System.out.println("Rendez-vous trouvé");

                int[] decalages = DateMethods.demanderDecalage(sc); // Demande du décalage en jours et heures
                String newVersion = DateMethods.decalerRDV(rdv, decalages[0], decalages[1]); // Tentative de mise à jour du rendez-vous

                if (newVersion != null) {
                    rdvs.set(i, newVersion);
                    System.out.println("Rendez-vous décalé avec succès :");
                    System.out.println(newVersion);
                } else {
                    System.out.println("Erreur lors du décalage du rendez-vous");
                }
            }
        }
        if (!found) {
            System.out.println("Aucun rendez-vous correspondant trouvé");
        }
    }

    public static void rechercherRDV(ArrayList<String> rdvs, ArrayList<String> referenceCode) { // Fonction qui permet de rechercher les rendez-vous par le code de référence
        System.out.print("Entrez un fragment du code de référence : ");
        String fragment = sc.nextLine().trim().toUpperCase();

        boolean found = false;
        for (String code : referenceCode) {
            if (code.toUpperCase().contains(fragment)) {
                System.out.println(rdvs);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Aucun rendez-vous trouvé");
        }
    }

    public static void annulerRDV(ArrayList<String> rdvs, ArrayList<String> referenceCode) { // Fonction qui permet d'annuler les rendez-vous
        System.out.print("Entrez le code de référence complet : ");
        String inputCode = sc.nextLine().toUpperCase();

        boolean removed = false;
        for (int i = 0; i < rdvs.size(); i++) {
        // On compare avec la référence à l’indice i
            if (referenceCode.get(i).equals(inputCode)) {
                rdvs.remove(i);
                referenceCode.remove(i);
                removed = true;
                break;  // Sortir de la boucle, un seul RDV à annuler
            }
        }

        if (removed) {
            System.out.println("Rendez-vous annulé avec succès");
        } else {
            System.out.println("Aucun rendez-vous correspondant trouvé");
        }
    }
}
