package Exercices;

import java.util.Scanner;

public class Exo13 {

    public static String cmToMeter(int centimeter) {

        final double METER = 0.01;
        double meter = centimeter * METER; // Converti cm en m

        String result = centimeter + " cm vaut " + meter + " m";
        System.out.println(result);
        return result;
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Donner une taille en centimètre ?");

        try {

            int centimeter = sc.nextInt();
            cmToMeter(centimeter);

        } catch (Exception e) {

            System.out.println("Erreur de saisi, veuillez recommencer !");
            main(args);
        }

        sc.close();
    }
}
