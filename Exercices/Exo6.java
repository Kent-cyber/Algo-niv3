package Exercices;

import java.util.Scanner;

public class Exo6 {

    static Scanner sc = new Scanner(System.in);
    
    public static String presentation(String name, int age) {
        String presentation = "Je m'appelle " + name + ", j'ai " + age + " ans";
        System.out.println(presentation);
        return presentation;
    }
    public static void main(String[] args) {

        System.out.println("Entrez votre nom et votre âge :");

        try {

            String name = sc.nextLine();
            int age = sc.nextInt();
            presentation(name, age);

        } catch (Exception e) {
            System.out.println("Erreur de saisi !");
            main(args);
        }
    }
}
