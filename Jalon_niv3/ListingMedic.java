/* Bonjour les Avengers du Dev,

Nous sommes le cabinet médical Hypocamp, nous voulons avoir un système qui nous permet de lister nos rendez-vous avec les informations suivantes :

-Nom, et prénom du client
-Age : si le client est mineur ou senior (minimum de 60 ans) l'assurance maladie prendra en charge 80% de sa consultation
-Type de consultation (Prix):
    Bilan de santé (code : BS, Prix : 120€),
    Cardiologie (code : CD, Prix : 200€),
    Vaccinations (code : VC, Prix : Gratuit),
    Certification médical (code : CM, Prix : 100€),
    Général (code : GN, Prix : 70€),
    Suivi médical (code : SM, Prix : 60€),
-Date et heure de rendez-vous : le cabinet est ouvert du lundi au vendredi de 8h-12h et de 14h-17h, fermé les week-ends et jour férié.
    Donc en dehors de ces horaires, il est impossible de réserver une consultation.
-Code de référence : qui se génère automatiquement, le code de référence nous permettra de retrouver rapidement la consultation, le code est composé
    des initiales du client, de la date de consultation et du code de consultation exemple :
    EK202506301501BS
-Prix initale : afficher le prix total de consultation, et le prix pour le client, c'est-à-dire le prix initial -60% de prise en charge de l'assurance maladie

On peut ajouter ou annuler le rendez-vous, il sera dans ce cas enlever de la liste, on peut aussi décaler un rendez-vous pour une date ou une heure
différente. Bien sûr on ne peut pas prendre de rendez-vous à une date antérieur, ce qui serait absurde. On ne peut pas non plus placer un rendez-vous
au même horaire même si la consultation est différente nous avions hélas qu'un seul médecin généraliste. On peut rechercher ou filtrer des rendez-vous
en fonction du code de référence, il ne serait pas nécessaire de mettre tout le code entier. Il nous faudra un menu pour naviguer sur ses fonctionnalités.
*/package Jalon_niv3;

import java.util.*;
import java.time.*;

public class ListingMedic {

    static Scanner sc = new Scanner(System.in); // Appelle le scanner
    
    public static void main(String[] args) {
        
        ArrayList<String> rdv = new ArrayList<>(); // Création de la liste des rendez-vous
        ArrayList<String> referenceCode = new ArrayList<>(); // Création de la liste des codes de référence
        ArrayList<LocalDateTime> datesRDV = new ArrayList<>();
        int choice = 0; // Initialise le choix de l'utilisateur

        while (choice != 6) { // Affiche le menu et ses fonctionnalités
            System.out.println("=== Menu ===");
            System.out.println("1 : Afficher les rendez-vous"); // Méthode acquis et validé
            System.out.println("2 : Ajouter un rendez-vous"); // Méthode acquis et validé
            System.out.println("3 : Modifier un rendez-vous"); // Méthode acquis et validé
            System.out.println("4 : Rechercher un rendez-vous"); // Méthode acquis et validé
            System.out.println("5 : Annuler un rendez-vous"); // Méthode acquis et validé
            System.out.println("6 : Quitter");
            System.out.print("Entrez votre choix : ");
            choice = sc.nextInt(); // L'utilisateur entre un nombre pour choisir

            switch (choice) {
                case 1:
                    MenuMethods.afficherRDV(rdv); // Appelle la liste des rendez-vous
                    break;
                    
                case 2:
                    MenuMethods.ajoutRDV(rdv, referenceCode, datesRDV); // Appelle la méthode d'ajout de rendez-vous
                    break;

                case 3:
                    MenuMethods.modifierRDV(rdv, referenceCode); // Appelle la méthode pour modifier un rendez-vous
                    break;

                case 4:
                    MenuMethods.rechercherRDV(rdv, referenceCode); // Appelle la méthode de recherche de rendez-vous
                    break;

                case 5:
                    MenuMethods.annulerRDV(rdv, referenceCode); // Appelle la méthode pour supprimer la liste des rendez-vous
                    break;
                    
                case 6:
                    System.out.println("Merci d'avoir consulté, au revoir !"); // Ferme le programme
                    break;

                default:
                    System.out.println("Option invalide, réessayez"); // Si ça ne demande pas à la réponse de l'utilisateur
            }
        } 
    }
}
