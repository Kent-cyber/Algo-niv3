package Exercices;

import java.util.Scanner;

public class Exo9 {

    static Scanner sc = new Scanner(System.in);

    public static String[] formulaire(String[] formulaire) {
        
        String[] userAnswer = new String[formulaire.length];

        for (int i = 0; i < formulaire.length; i++) {

            System.out.println(formulaire[i]); // Déroule chaque question
            userAnswer[i] = sc.nextLine();
        }
        
        if (userAnswer[4].equals(userAnswer[3])) {

            String inscription = "Merci " + userAnswer[0] + " " + userAnswer[1].toUpperCase() + 
            ", votre inscription est effectuée, vous recevrez un mail de confirmation à l'adresse : " + userAnswer[2];
            System.out.println(inscription);
            return userAnswer;
        } else {
            
            String denied = "Access Denied";
            System.out.println(denied);
            return null;
        }
    }

    public static String connection(String mail, String password) {

        System.out.println("Pour vous connecter, renseignez votre email :");
        String mailConfirm = sc.nextLine();

        System.out.println("Renseignez votre mot de passe :");
        String passwordConfirm = sc.nextLine();

        if (mailConfirm.equals(mail) && passwordConfirm.equals(password)) {
            String reussi = "Connexion réussie";
            System.out.println(reussi);
            return reussi;

        } else {
            String echoue = "Connexion refusée";
            System.out.println(echoue);
            return echoue;
        }
        
    }
    public static void main(String[] args) {

            String[] formulaire = {"Votre prénom ?", "Votre nom ?", "Votre adresse ?", "Votre mot de passe ?", "Confirmer votre mot de passe ?"};
            String[] userAnswer = null;

            System.out.println("Veuillez me renseigner notre formulaire, s'il vous plaît :");

            try {

                userAnswer = formulaire(formulaire);

                if (userAnswer == null) {
                    System.out.println("Formulaire invalide. Fin du programme.");
                    return;
                }
            
            } catch (Exception e) {
                System.out.println("Erreur de saisi, veuillez recommencez !");
                return;
            }

            String mail = userAnswer[2];
            String password = userAnswer[3];

            try {

                connection(mail, password);

            } catch (Exception f) {
                System.out.println("Erreur de saisi, veuillez recommencez !");
            }

        }
}
