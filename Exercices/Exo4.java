package Exercices;

import java.util.Scanner;

public class Exo4 {
    public static int divisible(int a) {

        if (a % 2 == 0) {
            System.out.println("a = " + a);
            System.out.println("a est bien divisible !");

        } else {
            System.out.println("a = " + a);
            System.out.println("a n'est pas divisible !");
        }
        return a;
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Donnez un nombre et je vous dirai s'il est divisible :");

        try {

            int a = sc.nextInt();
            divisible(a);

        } catch (Exception e) {
            System.out.println("Erreur de saisi !");
            main(args);
        }
        
        sc.close();
    }
}
