package Jalon_niv3;

import java.time.*;
import java.time.format.*;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateMethods {

    static Scanner sc = new Scanner(System.in);

    public static boolean horaireValide(LocalDateTime date) { // Fonction qui permet de vérifier si la date est valide
        DayOfWeek d = date.getDayOfWeek();
        if (d == DayOfWeek.SATURDAY || d == DayOfWeek.SUNDAY) { // Retourne faux si le jour tombe un samedi ou un dimanche
            return false;
        }
        LocalTime time = date.toLocalTime();
        boolean matin = !time.isBefore(LocalTime.of(8,0)) && time.isBefore(LocalTime.of(12, 0)); // Retourne vrai si l'heure est entre ces deux périodes
        boolean apresmidi = !time.isBefore(LocalTime.of(14, 0)) && time.isBefore(LocalTime.of(17, 0));
        return matin || apresmidi; // Retourne un des deux périodes de temps
    }

    public static LocalDateTime saisirDateHeure(LocalDateTime date) { // Fonction qui rentre la date avec des conditions à respecter

        while (date == null) {
            try {
                System.out.print("Saisir une date (dd/MM/yyyy) et l'heure de rendez-vous (HH:mm): ");
                date = LocalDateTime.parse(sc.nextLine(), DateTimeFormatter.ofPattern("d/MM/yyyy H:mm"));
                if (date.isBefore(LocalDateTime.now())) { // Vérifie si la date n'est pas avant aujourd'hui
                    System.out.println("Impossible de réserver dans le passé !");
                    date = null;
                } else if (!horaireValide(date)) { // Vérifie si la date est rentré dans la bonne période
                    System.out.println("Cabinet fermé à cet horaire");
                    date = null;
                } else if (ferie(date)) { // Vérifie si la date ne tombe pas à un jour férié
                    System.out.println("Cabinet fermé ce jour-là");
                    date = null;
                }
            } catch (DateTimeParseException e) {
                System.out.println("Date de format invalide, réessayer comme ceci : 01/01/2025 14:30");
            }
        }
        return date;
    }

    public static int[] demanderDecalage(Scanner sc) { // Demande décalage en jours et en heures, avec validation
        int jours = 0;
        int heures = 0;
        boolean valide = false;
        while (!valide) {
            try {
                System.out.print("Combien de jours voulez-vous décaler (positif pour avancer/negatif pour reculer) ? ");
                jours = Integer.parseInt(sc.nextLine());
                System.out.print("Combien d'heures voulez-vous décaler (positif pour avancer/negatif pour reculer) ? ");
                heures = Integer.parseInt(sc.nextLine());
                valide = true;
            } catch (NumberFormatException e) {
                System.out.println("Entrée invalide : veuillez entrer un nombre entier");
            }
        }
        return new int[]{jours, heures};
    }

    public static String decalerRDV(String rdv, int jours, int heures) { // Décale la date d'un rendez-vous en validant la nouvelle date
        String regex = "Date et heure de rendez-vous : (.*)";
        Matcher matcher = Pattern.compile(regex).matcher(rdv);

        if (!matcher.find()) {
            System.out.println("Impossible d'extraire la date du rendez-vous");
            return null;
        }

        String dateStr = matcher.group(1);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("EEEE d MMMM yyyy à HH:mm", Locale.FRANCE);

        try {
            LocalDateTime date = LocalDateTime.parse(dateStr, dtf);
            date = date.plusDays(jours).plusHours(heures); // Applique le décalage

            if (date.isBefore(LocalDateTime.now())) {
                System.out.println("Erreur : la nouvelle date est avant aujourd'hui. Décalage annulé");
                return null;
            }
            if (!DateMethods.horaireValide(date)) {
                System.out.println("Erreur : la nouvelle date tombe un week-end. Décalage annulé");
                return null;
            }
            if (DateMethods.ferie(date)) {
                System.out.println("Erreur : la nouvelle date tombe un jour férié. Décalage annulé");
                return null;
            }

            String nouvelleDateStr = date.format(dtf); // Remplace la date en chaîne de caractères dans le texte original
            return rdv.replaceFirst(regex, "Date et heure de rendez-vous : " + nouvelleDateStr);

        } catch (DateTimeParseException e) {
            System.out.println("Format de date invalide dans le rendez-vous. Modification impossible.");
            return null;
        }
    }

    public static boolean ferie(LocalDateTime date) {
		final int day = date.getDayOfMonth();
		switch (date.getMonth()) {
		case JANUARY:
			if (day == 1) {
				// Jour de l'an
				return true;
			}
			break;
		case MAY:
			if (day == 1 || day == 8) {
				// Fête du travail et Victoire 1945
				return true;
			}
			break;
		case JULY:
			if (day == 14) {
				// Fête Nationale
				return true;
			}
			break;
		case AUGUST:
			if (day == 15) {
				// Assomption
				return true;
			}
			break;
		case NOVEMBER:
			if (day == 1 || day == 11) {
				// Toussaint et Armistice 1918
				return true;
			}
			break;
		case DECEMBER:
			if (day == 25) {
				// Noël
				return true;
			}
			break;
		default:
		}
 
		if (date.getMonthValue() < 7) {
			// Avant juillet on doit aussi vérifier les fêtes liées à Paques
			LocalDate paques = paques(date.getYear());
			int days = (int) ChronoUnit.DAYS.between(paques, date);
			switch (days) {
			case 0: // Paques
			case 1: // lundi de Pâques : 1 jour après Pâques
			case 39: // Ascension : 39 jours après Pâques
			case 50: // Pentecôte : 50 jours après Pâques
			case 51: // L. de Pentecôte : 51 jours après Paques
				return true;
			}
		}
		return false;
    }
    
    // Calcul de la date de Pâques selon l'algorithme de Meeus/Jones/Butcher
    public static LocalDate paques(int year) {
        int a = year % 19;
        int b = year / 100;
        int c = year % 100;
        int d = b / 4;
        int e = b % 4;
        int f = (b + 8) / 25;
        int g = (b - f + 1) / 3;
        int h = (19 * a + b - d - g + 15) % 30;
        int i = c / 4;
        int k = c % 4;
        int l = (32 + 2 * e + 2 * i - h - k) % 7;
        int m = (a + 11 * h + 22 * l) / 451;
        int month = (h + l - 7 * m + 114) / 31;
        int day = ((h + l - 7 * m + 114) % 31) + 1;
        return LocalDate.of(year, month, day);
    }
}
