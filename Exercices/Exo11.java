package Exercices;

import java.util.Scanner;

public class Exo11 {

    public static String retirer(int money) {
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Bonjour, combien voulez-vous retirer ?");
        int montant = sc.nextInt();
        sc.close();
        int sum = money - montant;

        if (sum < 0) {
            String refus = "Opération refusée, fond insuffisant !";
            System.out.println(refus);
            return refus;

        } else {
            String reussie = "Transaction réussie !";
            System.out.println(reussie);
            return reussie;
        }
    }
    public static void main(String[] args) {

        int money = 3000; // Argent sur le compte

        Scanner sc = new Scanner(System.in); // Création du scanner

        try {

            retirer(money);

        } catch (Exception e) {
            System.out.println("Erreur de saisi, veuillez recommencer !");
            main(args);
        }
        
        sc.close();

        
    }
}
