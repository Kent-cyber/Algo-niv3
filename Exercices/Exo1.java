    /* EXO1 : A l'aide de Scanner et Print, me faire afficher le résultat d'une addition de deux entiers        
 * 
 * 
* **********************AFFICHAGE ATTENDU ****************:
 * 
 * a = 2
 * b = 3
 * 
 * resultat = a + b
 * 
 * resulat vaut 5
 * 
 * 
 * 
*/
package Exercices;

import java.util.*;

public class Exo1 {

    static Scanner sc = new Scanner(System.in);
    
    public static int Addition(int a, int b) {
        return a + b;
    }
    public static void main(String[] args) {

        while (true) {
            try {
                System.out.println("Donnez deux nombres (ou tapez 'q' pour quitter) :");
                String input = sc.next();
                if (input.equalsIgnoreCase("q")) {
                    System.out.println("Fermeture du programme");
                    break;
                }
                int a = Integer.parseInt(input);
                int b = sc.nextInt();
                System.out.println("Le résultat vaut " + Addition(a, b));

            } catch (NumberFormatException e) {
                System.out.println("Veuillez entrer un nombre valide");
            } catch (InputMismatchException e) {
                System.out.println("Entrée invalide. Veuillez entrer des nombres");
                sc.next();
            }
        }
    }
}
