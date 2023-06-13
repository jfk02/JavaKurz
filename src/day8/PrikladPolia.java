package day8;

import java.util.Arrays;

public class PrikladPolia {
    public static void main(String[] args) {
        String[] cars = {"Peugeot", "Volvo", "Citroen", "Mazda"};

/*        for (String car : cars) {
            System.out.println(car);
        }*/

        Arrays.stream(cars).forEach(System.out::println);
    }
}
