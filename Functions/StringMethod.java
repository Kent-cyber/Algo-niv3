package Functions;

public class StringMethod {
    
    public static String capitalize(String inputString) {
        if (inputString == null || inputString.isEmpty()) { // Retourne la chaîne originale si elle est nulle ou vide
            return inputString;
        }
        char firstLetter = inputString.charAt(0); // Prend la première lettre de la chaîne
        char capitalFirstLetter = Character.toUpperCase(firstLetter); // La convertit en majuscule

        return inputString.replace(inputString.charAt(0), capitalFirstLetter); // La retourne dans la chaîne de caractère avec le majuscule
    }
}
