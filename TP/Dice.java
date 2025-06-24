/*Vous êtes en charge de la réalisation d’un algorithme de statistiques d’un jeu de dès.

Le jeu se joue à 3 joueurs, chaque joueur démarre avec 0 point.

A chaque tour de jeu, Les joueurs lancent 2 dès chacun leur tour. Les joueurs jouent autant de tours qu’ils le souhaitent.

Pour chaque lancer, le joueur qui a jeté les dès gagne ou perd des points selon la somme des valeurs des 2 dès:

inférieur à 6 = 0 point
entre 6 et 10 = +1 points
supérieur à 10 = +3 points
Les doubles (valeur des 2 dès identiques) outrepassent les règles précédentes et font perdre 2 points au joueur.

Lorsqu’un joueur lance les dès, le résultat obtenu est enregistré (numéro joueur, score dé 1, score dé 2).

Votre travail consiste à analyser les résultats d’une partie et retourner le score de chaque joueur.

Un joueur ne peut avoir un score négatif.*/
package TP;

import java.util.*;

public class Dice {

    static Scanner sc = new Scanner(System.in);

    public static void statistiques(int[] scores) {

        Random ranNum = new Random();
        System.out.print("Entrez le nombre de jet : ");
        int numberOfRound = 0;
        try {
            numberOfRound = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Entrée invalide. Veuillez entrer un nombre");
            return;
        }

        for (int round = 0; round < numberOfRound; round++) {
            for (int player = 0; player < 3; player++) {
                int dice1 = ranNum.nextInt(6) + 1;
                int dice2 = ranNum.nextInt(6) + 1;
                if (dice1 == dice2) {
                    scores[player] = Math.max(0, scores[player] - 2);
                } else {
                    int sum = dice1 + dice2;
                    if (sum < 6) {
                        scores[player] += 0;
                    } else if (sum > 10) {
                        scores[player] += 3;
                    } else {
                        scores[player] += 1;
                    }
                }
            }
        }

        for (int i = 0; i < 3; i++) {
            System.out.println("Joueur "+ (i + 1)+ " : " + scores[i]);
        }
    }

    public static void main(String[] args) {

         
        int[] scores = new int[3];

        System.out.println("Bienvenue au jeu de dé");
        statistiques(scores);
        
    }
}
