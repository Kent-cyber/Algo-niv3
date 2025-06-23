package Functions;

import java.util.*;

public class MathUnitConversion {
    
    static Scanner sc = new Scanner(System.in);

    public static double conversionKmMiles(double kilometers) {

        kilometers = sc.nextDouble();

        double miles = kilometers / 1.6;

        return miles;
    }

    public static double calculAire(int radius) {

        return 4 * Math.PI * Math.pow(radius, 2);
    }

    public static double calculVolume(int radius) {

        return (4 * Math.PI * Math.pow(radius, 3)) / 3;
    }

    public static double calculSurface(int radius, int angle) {

        return (Math.PI * Math.pow(radius, 2) * angle) / 360;
    }
    public static void main(String[] args) {
        
        System.out.print("Entrez un nombre de kilomètres : ");
        double kilometers = 0;
        System.out.println(conversionKmMiles(kilometers) + " Miles");
    }
}
