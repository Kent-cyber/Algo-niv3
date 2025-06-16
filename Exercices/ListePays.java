/* A l'aide de boucle, tableau, exception et fonction. Me faire un tableau contenant 5 noms de pays (Vous pouvez choisir vos propres pays),
créer une méthode pour afficher les pays du tableau numéroté par ligne et autre une méthode pour choisir un pays selon 
la position de sa cellule du tableau et puis affichera un message de bienvenue dans la langue du pays choisi.:

Bonjour, quel pays voulez-vous visiter ?

0 - France 
1 - Angleterre
2 - Espagne
3 - Italie
4 - Allemagne

0
Bienvenue en France !

Voulez-vous visiter un autre pays ? (O/N)
O

1
Welcome to England !

Voulez-vous visiter un autre pays ? (O/N)
O

2
Bienvenido a España !
Voulez-vous visiter un autre pays ? (O/N)
O


3
Benvenuto in Italia !
Voulez-vous visiter un autre pays ? (O/N)
O

4
Willkommen in Deutschland !
Voulez-vous visiter un autre pays ? (O/N)
O


5
Désolé, ce pays n'est pas sur la liste !
Voulez-vous visiter un autre pays ? (O/N)
O

Votre voyage est terminé :) !

*/
package Exercices;

import java.util.*;

public class ListePays {

    public static void countryList(String[] countryList) {
        for (int i = 0; i < countryList.length; i++) {
            System.out.println(i + " - " + countryList[i]);
        }
    }

    public static void countryChoice(int choice) {
        switch (choice) {
            case 0:
                System.out.println("Bienvenue en France !");
                break;
            
            case 1:
                System.out.println("Welcome to England !");
                break;

            case 2:
                System.out.println("Bienvenido a España !");
                break;

            case 3:
                System.out.println("Benvenuto in Italia !");
                break;

            case 4:
                System.out.println("Willkommen in Deutschland !");
                break;
        
            default:
                System.out.println("Désolé, ce pays n'est pas sur la liste !");
                break;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] countryList = {"France", "Angleterre", "Espagne", "Italie", "Allemagne"};
        boolean answer = true;

        System.out.println("Bonjour, quel pays voulez-vous visiter ?");

        try {

            while (answer == true) {

                countryList(countryList);
                int choice = sc.nextInt();
                countryChoice(choice);

                System.out.println("Voulez-vous visiter un autre pays ? (true/false)");
                answer = sc.nextBoolean();
            }

            System.out.println("Votre voyage est terminé :) !");

        } catch (Exception e) {
            System.out.println("Erreur de saisi !");
            main(args);
        }

        sc.close();
    }
}
