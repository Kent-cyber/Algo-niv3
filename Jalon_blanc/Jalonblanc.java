/* Bonjour les Avengers, 

Nous sommes le site ecommerce ElectroDepot, nous aurions besoin d’un programme qui nous permettrait de gérer notre stock de produit,
l’afficher sous forme de liste avec : 

 

N°id du produit : Qui se crée automatiquement en incrémentation 

Nom du produit : Ville / Pays 

Type de produit : TV/Electro-ménager/Micro-Informatique/Audio/  

Date de stockage du produit : Date de création du produit, 
        (si la date dépasse 4 mois, alors on applique une réduction de 10%, mais attention ça ne veut pas dire qu’il est soldé) 

Solde : Si le produit est soldé alors il aura une réduction de 40% de son prix
        (Les soldes ne sont pas cumulatifs avec les réductions précédemment évoqués) 

Prix : Le prix de base du produit 

 

On veut gérer cette liste en ajoutant ou supprimant nos produits. On peut aussi rechercher un produit en fonction de son ID */
package Jalon_blanc;

import java.util.*;
import Jalon_blanc.Methods;

public class Jalonblanc {

    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        
        ArrayList<String> products = new ArrayList<>();
        ArrayList<Integer> ids = new ArrayList<>();
        int choice = 0;
        
        Methods.ajoutProduits(products, ids);

        while (choice != 5) {
            System.out.println("1 : Consulter la liste");
            System.out.println("2 : Ajouter un produit");
            System.out.println("3 : Rechercher un produit par ID");
            System.out.println("4 : Supprimer un produit");
            System.out.println("5 : Quitter");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    Methods.afficherListe(products);
                    break;
                
                case 2:
                    Methods.ajoutProduits(products, ids);
                    break;

                case 3:
                    Methods.rechercherParId(products, ids);
                    break;

                case 4:
                    Methods.supprimerListe(products, ids);
                
                case 5:
                    System.out.println("Merci d'avoir consulté, au revoir !");
                    break;

                default:
                    System.out.println("Option invalide, réessayez");
            }
        }
    }
}
