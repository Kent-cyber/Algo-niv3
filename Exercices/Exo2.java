package Exercices;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exo2 {

    static Scanner sc = new Scanner(System.in);

    public static int Soustraction(int a, int b) {
        return a - b;
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
                System.out.println("Le résultat vaut " + Soustraction(a, b));

            } catch (NumberFormatException e) {
                System.out.println("Veuillez entrer un nombre valide");
            } catch (InputMismatchException e) {
                System.out.println("Entrée invalide. Veuillez entrer des nombres");
                sc.next();
            }
        }
    }
}
