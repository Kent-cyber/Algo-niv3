package Exercices;

import java.util.Scanner;

public class Exo3 {

    static Scanner sc = new Scanner(System.in);

    public static int EvenOdd(int a, int b) {
        int resultat = a + b;

        if (resultat % 2 == 0) {
            System.out.println("le résultat vaut " + resultat);
            System.out.println("c'est paire !");

        } else {
            System.out.println("le résultat vaut " + resultat);
            System.out.println("c'est impaire !");
        }
        return resultat;
    }
    public static void main(String[] args) {

        System.out.println("Donnez deux nombres :");

        try {

            int a = sc.nextInt();
            int b = sc.nextInt();
            EvenOdd(a, b);

        } catch (Exception e) {
            System.out.println("Erreur de saisi !");
            main(args);
        }
    }
}
