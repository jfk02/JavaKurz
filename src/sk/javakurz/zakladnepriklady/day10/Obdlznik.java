package sk.javakurz.zakladnepriklady.day10;

//import test.Test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.InputMismatchException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

//import static org.junit.jupiter.api.Assertions.assertEquals;
/*
ZADANIE:
Vytvorte triedu Obdlznik, v ktorej budú 2 statické metódy. Prvá na výpočet obvodu obdĺžnika (vypocitajObvod), druhá na výpočet jeho obsahu (vypocitajObsah).

Dodatočná úloha vylepšenej verzie: Program bude zároveň od používateľa vyžadovať zadanie príkazu na prácu s programom. Ak zadá príkaz s, tak program vyžiada od používateľa zadanie strán a, b. Ak zadá q, tak program sa ukončí.

*/

public class Obdlznik {

    public static double vypocitajObvod(double stranaA, double stranaB) {
        return 2 * (stranaA + stranaB);
    }

    public static double vypocitajObsah(double stranaA, double stranaB) {
        return stranaA * stranaB;
    }

    public static void main(String[] args) {
        //double a = 2.5; // Strana a
        //double b = 3.5; // Strana b
        double a = 0;
        double b = 0;
        Scanner scn = new Scanner(System.in); // Inicializacia konzoly (System.in) cez triedu Scanner
        try {
            System.out.println("Zadaj stranu a");
            a = scn.nextDouble();
            System.out.println("Zadaj stranu b");
            b = scn.nextDouble();
            System.out.println("Obvod obdĺžnika je: " + Obdlznik.vypocitajObvod(a, b));
            System.out.println("Obsah obdĺžnika je: " + Obdlznik.vypocitajObsah(a, b));
        } catch (InputMismatchException e) {
            // Tu dopisem vlastny kod, ktory naraba s chybou
            System.out.println("Chyba vo vstupných hodnotách!");
        }
    }


    @Test
    @DisplayName("Testy na vypocet obvodu")
    public void testVypocitajObvod() {
        assertEquals(10, Obdlznik.vypocitajObvod(2, 3));
        assertEquals(13, Obdlznik.vypocitajObvod(2.5, 4));
    }

}