package Exercices;

import java.util.Scanner;

public class Exo16 {
    
    static Scanner sc = new Scanner(System.in);

    public static String calculerPrixFinal(int age, String business, double price, int nbPlaces, double totalPrice) {

        totalPrice = price;

        if (age < 18 || nbPlaces > 60) {
            totalPrice -= price * 0.2;

        } else if (age > 60) {
            totalPrice -= price * 0.4;

        } else if (business.equalsIgnoreCase("oui") || nbPlaces < 20) {
            totalPrice += price * 0.2;

        }

        String result = "Le prix final est de " + Math.round(totalPrice) + " euros";
        System.out.println(result);
        return result;
    }
    public static void main(String[] args) {

        double totalPrice = 0;

        System.out.println("Quel est l'âge de votre passager ?");
        int age = sc.nextInt();

        System.out.println("Le passager veut-il une classe business (oui/non) ?");
        String business = sc.nextLine();

        System.out.println("Le prix du vol :");
        double price = sc.nextDouble();

        System.out.println("Nombre de places disponibles :");
        int nbPlaces = sc.nextInt();

        calculerPrixFinal(age, business, price, nbPlaces, totalPrice);
    }
}
