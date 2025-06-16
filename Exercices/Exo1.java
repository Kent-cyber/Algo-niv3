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
    
    public static int Addition(int a, int b) {
        int resultat = a + b;
        return resultat;
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Donnez deux nombres :");

        try {

            int a = sc.nextInt();
            int b = sc.nextInt();
            System.out.println("Le résultat vaut " + Addition(a, b));

        } catch (Exception e) {
            System.out.println("Erreur de saisi !");
            main(args);
        }
        
        sc.close();
    }
}
