/* Bonjour les Avengers, 

Nous sommes le site ecommerce ElectroDepot, nous aurions besoin d’un programme qui nous permettrait de gérer notre stock de produit,
l’afficher sous forme de liste avec : 

 

N°id du produit : Qui se crée automatiquement en incrémentation 

Nom du produit :  

Type de produit : TV/Electro-ménager/Micro-Informatique/Audio/  

Date de stockage du produit : Date de création du produit, 
        (si la date dépasse 4 mois, alors on applique une réduction de 10%, mais attention ça ne veut pas dire qu’il est soldé) 

Solde : Si le produit est soldé alors il aura une réduction de 40% de son prix
        (Les soldes ne sont pas cumulatifs avec les réductions précédemment évoqués) 

Prix : Le prix de base du produit 

 

On veut gérer cette liste en ajoutant ou supprimant nos produits. On peut aussi rechercher un produit en fonction de son ID */
package Jalon_blanc;

import java.util.*;

public class Jalonblanc {

    static Scanner sc = new Scanner(System.in); // Appelle le scanner
    public static void main(String[] args) {
        
        ArrayList<String> products = new ArrayList<>(); // Créer la liste des produits
        ArrayList<Integer> ids = new ArrayList<>(); // Créer la liste des IDs
        int choice = 0; // Initialise le choix de l'utilisateur

        while (choice != 5) { // Le choix dans le menu pour l'utilisateur
            System.out.println("1 : Consulter la liste");
            System.out.println("2 : Ajouter un produit");
            System.out.println("3 : Rechercher un produit par ID");
            System.out.println("4 : Supprimer un produit");
            System.out.println("5 : Quitter");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    Methods.afficherListe(products); // Appelle la liste des produits
                    if (products.isEmpty()) {
                        System.out.println("La liste est vide");
                    }
                    break;
                
                case 2:
                    Methods.ajoutProduits(products, ids); // Appelle la méthode d'ajout de produits
                    break;

                case 3:
                    Methods.rechercherParId(products, ids); // Appelle la méthode de recherche par l'ID
                    break;

                case 4:
                    Methods.supprimerListe(products, ids); // Appelle la méthode pour supprimer la liste de produits
                    break;
                
                case 5:
                    System.out.println("Merci d'avoir consulté, au revoir !"); // Ferme le programme
                    break;

                default:
                    System.out.println("Option invalide, réessayez"); // Si ça ne demande pas à la réponse de l'utilisateur
            }
        }
    }
}
