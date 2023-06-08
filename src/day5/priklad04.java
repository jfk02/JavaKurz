package day5;

import static java.lang.System.out;

import java.util.Scanner;

public class priklad04 {

    static double priemer(int c1, int c2, int c3) {
        return (c1 + c2 + c3) / 3;
    }

    public static void main(String[] args) {

        int cislo1 = 0;
        int cislo2 = 0;
        int cislo3 = 0;

        try (Scanner inputScan = new Scanner(System.in)) {
            out.print("Zadaj 1. cislo: ");
            cislo1 = inputScan.nextInt();
            out.print("Zadaj 2. cislo: ");
            cislo2 = inputScan.nextInt();
            out.print("Zadaj 3. cislo: ");
            cislo3 = inputScan.nextInt();
        }

        out.println("Priemer zadanych cisiel je: " + priemer(cislo1, cislo2, cislo3));
    }
}
