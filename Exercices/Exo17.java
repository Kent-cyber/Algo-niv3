package Exercices;

import java.util.Scanner;

public class Exo17 {
    
    static Scanner sc = new Scanner(System.in);

    public static String GazoleDepense(double distance) {

        String dString = "Pour " + Math.round(distance) + " km, vous allez dépenser en moyenne : " + Math.round((distance * (5.5 / 100)) * 1.588 * 100.0) / 100.0 + " euros";
        System.out.println(dString);
        return dString;
    }

    public static String SP95Depense(double distance) {

        String dString = "Pour " + Math.round(distance) + " km, vous allez dépenser en moyenne : " + Math.round((distance * (6.5 / 100)) * 1.700 * 100.0) / 100.0 + " euros";
        System.out.println(dString);
        return dString;
    }

    public static String SP98Depense(double distance) {

        String dString = "Pour " + Math.round(distance) + " km, vous allez dépenser en moyenne : " + Math.round((distance * (6.5 / 100)) * 1.794 * 100.0) / 100.0 + " euros";
        System.out.println(dString);
        return dString;
    }
    public static void main(String[] args) {

        // Affiche les choix
        System.out.println("1 : Gazole");
        System.out.println("2 : Sans Plomb 95");
        System.out.println("3 : Sans Plomb 98");

        try {
            System.out.println("Quel est votre type de carburant ? Tapez un des chiffres ci-dessus");
            int choice = sc.nextInt();

            System.out.println("Quel est la distance à parcourir (en km) ?");
            double distance = sc.nextDouble();

            switch (choice) {
                case 1:
                    System.out.println(GazoleDepense(distance));
                    break;
                case 2:
                    System.out.println(SP95Depense(distance));
                    break;
                case 3:
                    System.out.println(SP98Depense(distance));
                    break;
                default:
                    System.out.println("Ne tapez pas n'importe quoi !");
        }

        } catch (Exception e) {
            System.out.println("Erreur de saisi !");
        }

    }
}
