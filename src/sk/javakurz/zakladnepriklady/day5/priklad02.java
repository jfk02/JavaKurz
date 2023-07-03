package sk.javakurz.zakladnepriklady.day5;

import static java.lang.System.out;

import java.util.Scanner;

public class priklad02 {

    static void vypocitajModulo(int c1, int c2) {

        if (c1 >= c2 && c2 > 0) {
            out.println(c1 + " % " + c2 + " = " + (c1 % c2));
        } else if (c2 >= c1 && c1 > 0) {
            out.println(c2 + " % " + c1 + " = " + (c2 % c1));
        } else {
            out.println("Nulou delit nemozem!");
        }
    }

    public static void main(String[] args) {

        int cislo1 = 0;
        int cislo2 = 0;

        try (Scanner inputScan = new Scanner(System.in)) {
            out.print("Zadaj 1. cislo: ");
            cislo1 = inputScan.nextInt();
            out.print("Zadaj 2. cislo: ");
            cislo2 = inputScan.nextInt();
        }

        vypocitajModulo(cislo1, cislo2);
    }
}
