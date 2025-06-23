package Functions;

import java.time.*;
import java.time.format.*;
import java.util.Scanner;

public class DateMethod {

    static Scanner sc = new Scanner(System.in);
    
    public static String saisirDate(LocalDate date) {

        while (date == null) {
            try {
                System.out.print("Saisir une date (dd/MM/yyyy) : ");
                date = LocalDate.parse(sc.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            } catch (DateTimeParseException e) {
                System.out.println("Date de format invalide, réessayer");
            }
        }
        return date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    public static String saisirHeure(LocalTime time) {

        while (time == null) {
            try {
                System.out.print("Saisir une heure et des minutes (H:mm) : ");
                time = LocalTime.parse(sc.nextLine(), DateTimeFormatter.ofPattern("H:mm"));
            } catch (DateTimeParseException e) {
                System.out.println("Heure de format invalide, réessayer");
            }
        }
        return time.format(DateTimeFormatter.ofPattern("H:mm"));
    }

    public static void main(String[] args) {

        System.out.println("Test");
        String date = saisirDate(null);
        String time = saisirHeure(null);

        System.out.println(date);
        System.out.println(time);
    }
}
