package Exercices;

import java.util.Scanner;

public class Exo7 {

    public static String questionning(String user) {
        String yes = "yes";
        String no = "no";
        
        if (user.equalsIgnoreCase(yes)) {
            System.out.println("Nice to meet you !");

        } else if (user.equalsIgnoreCase(no)) {
            System.out.println("You suck in english !");

        } else {

            System.out.println("This is not an answer !");
        }
        return user;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Déclaration du scanner

        System.out.println("Do you speak English ?");
        try {
            String userAnswer = sc.nextLine();

            questionning(userAnswer);

        } catch (Exception e) {
            System.out.println("Erreur de saisi !");
            main(args);
        }

        sc.close(); // Ferme le scanner
    }
}
