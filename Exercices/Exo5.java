package Exercices;

import java.util.Scanner;

public class Exo5 {
    public static int equation(int a, int b, int c) {
        int resultat = a * b / c;

        if (resultat > 15) {
            System.out.println("le résultat vaut " + resultat);
            System.out.println("l'équation est supérieure !");

        } else {
            System.out.println("le résultat vaut " + resultat);
            System.out.println("l'équation n'est pas supérieure !");
        }
        return resultat;
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Equation de :");

        try {

            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            equation(a, b, c);

        } catch (Exception e) {
            System.out.println("Erreur de saisi !");
            main(args);
        }
        
        sc.close();
    }
}
