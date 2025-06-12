package Exercices;

import java.util.*;

public class CityList {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<String> cityList = new ArrayList<>();
        cityList.add("Paris");
        cityList.add("Londres");
        cityList.add("Madrid");
        cityList.add("Berlin");
        cityList.add("Lisbonne");

        System.out.println("Ajoutez-moi une ville :");
        String city = sc.nextLine();
        cityList.add(city);
        cityList.sort(null);

        for (int i = 0; i < cityList.size(); i++) {

            System.out.println("-" + cityList.get(i));
        }

        sc.close();
    }
}