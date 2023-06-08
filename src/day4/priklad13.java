package day4;

import static java.lang.System.out;

import java.util.Scanner;

public class priklad13 {

    public static void main(String[] args) {

        int[] poleCisiel = { 0, 20, 58, 59, 45, 40, 12, 10, 40, -50, -6, 50 };
        int n = 0;
        int pocetVyskytov = 0;

        try (Scanner inputScan = new Scanner(System.in)) {

            out.print("Zadaj cislo: ");
            n = inputScan.nextInt();

            for (int i = 0; i < poleCisiel.length; i++) {

                if (n == poleCisiel[i]) {
                    pocetVyskytov++;
                }
            }

            if (pocetVyskytov > 0) {
                out.println("Cislo " + n + " sa vyskytuje v poli " + pocetVyskytov + " krat.");
            } else {
                out.println("Cislo " + n + " sa vyskytuje v poli nevyskytuje.");
            }

        }

    }

}
