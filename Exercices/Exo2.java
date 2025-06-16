package Exercices;

import java.util.Scanner;

public class Exo2 {

    public static int Soustraction(int a, int b) {
        int resultat = a - b;
        return resultat;
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Donnez deux nombres :");

        try {

            int a = sc.nextInt();
            int b = sc.nextInt();
            System.out.println("Le résultat vaut " + Soustraction(a, b));

        } catch (Exception e) {
            System.out.println("Erreur de saisi !");
            main(args);
        }
        
        sc.close();
    }
}
