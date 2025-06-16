package Exercices;

import java.util.Scanner;

public class Exo8 {
    public static String formulaire(String name, String surname, String mail, String password, String confirm) {
        String inscription = "Merci " + name + " " + surname.toUpperCase() + 
        ", votre inscription est effectuée, vous recevrez un mail de confirmation à l'adresse : " + mail;

        String denied = "Access Denied";
        
        if (confirm.equals(password)) {
            System.out.println(inscription);
            return inscription;
        } else {
            System.out.println(denied);
            return denied;
        }
    }
    public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);

            try {

                System.out.println("Votre prénom ?");
                String name = sc.nextLine();

                System.out.println("Votre nom ?");
                String surname = sc.nextLine();

                System.out.println("Votre adresse mail ?");
                String mail = sc.nextLine();

                System.out.println("Votre mot de passe ?");
                String password = sc.nextLine();

                System.out.println("Confirmer votre mot de passe ?");
                String confirm = sc.nextLine();

                formulaire(name, surname, mail, password, confirm);

            } catch (Exception e) {
                System.out.println("Erreur de saisi, veuillez recommencez !");
                main(args);
            }

            sc.close();

        }
}
