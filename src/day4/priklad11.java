package day4;

import static java.lang.System.out;

import java.util.Scanner;

public class priklad11 {

	public static void main(String[] args) {

        int tipUzivatela = 0;
        int pocetPokusov = 0;
        int nahodneCislo = (int) Math.floor((Math.random() * 100) + 1);

        try (Scanner inputScan = new Scanner(System.in)) {
            do {
                out.print("Tvoj tip: ");
                tipUzivatela = inputScan.nextInt();

                if (tipUzivatela < nahodneCislo) {
                    out.println("pridaj");
                } else if (tipUzivatela > nahodneCislo) {
                    out.println("uber");
                }

                pocetPokusov++;

            } while (tipUzivatela != nahodneCislo);

            out.println("Gratulujem uhadol cislo na " + pocetPokusov + " pokusov.");
        }
		
		
		
	}

}
