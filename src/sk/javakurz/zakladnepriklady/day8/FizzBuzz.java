package sk.javakurz.zakladnepriklady.day8;

public class FizzBuzz {

    final static int najvyssieCislo = 100;

    public static String zistiFizzBuzz(int testovaneCislo) {

        String vystup = Integer.toString(testovaneCislo);

        if (testovaneCislo % 15 == 0) {
            vystup = "Fizz Buzz";
        } else {
            if (testovaneCislo % 3 == 0) {
                vystup = "Fizz";
            }
            if (testovaneCislo % 5 == 0) {
                vystup = "Buzz";
            }
        }
        return vystup;
    }

    public static void main(String[] args) {

        String vysledokFizzBuzz = "";

        for (int i = 1; i <= najvyssieCislo; i++) {
            vysledokFizzBuzz += zistiFizzBuzz(i) + ", ";
        }

        vysledokFizzBuzz = vysledokFizzBuzz.substring(0, vysledokFizzBuzz.length() - 2);

        System.out.println(vysledokFizzBuzz);
    }
}
