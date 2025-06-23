package Functions;

import java.util.*;

public class Calculette {
    
    static Scanner sc = new Scanner(System.in);

    public static double calculette() {

        System.out.print("Entrez le premier nombre : ");
        double nb1 = sc.nextDouble();

        System.out.print("Entrez le deuxième nombre : ");
        double nb2 = sc.nextDouble();

        System.out.print("Entrez l'opérateur pour calculer. ex : +, -, *, / : ");
        String o = sc.nextLine();

        switch (o) {
            case "+":
                return (nb1 + nb2);
            case "-":
                return (nb1 - nb2);
            case "*":
                return (nb1 * nb2);
            case "/":
                if (nb2 != 0) {
                    return (nb1 / nb2);
                } else {
                    System.out.println("Erreur : Division par zéro");
                    return Double.NaN;
                }
            default:
                System.out.println("Opérateur invalide");
                return Double.NaN;
        }
    }
}
