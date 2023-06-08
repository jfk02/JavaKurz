package day4;

import static java.lang.System.out;

import java.util.Scanner;

public class priklad10 {

    public static void main(String[] args) {

        int teplota = 0;
        int sucetTeplot = 0;
        double priemer = 0;
        int maxOdchylka = 0;

        int[] teploty = new int[5];

        try (Scanner inputScan = new Scanner(System.in)) {
            for (int i = 0; i <= 5; i++) {
                out.print("Zadaj " + i + ". den: ");
                teplota = inputScan.nextInt();
                teploty[i] = teplota;
                sucetTeplot += teplota;
            }
        }

        
        priemer = sucetTeplot / 5;

        out.println("Priemerna teplota v tyydni bola: " + priemer);
        out.println();

    }

}
