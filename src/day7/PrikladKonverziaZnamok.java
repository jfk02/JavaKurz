package day7;

import java.util.Scanner;

public class PrikladKonverziaZnamok {
    //Úloha 1: Program na priradenie známky
//
//		Vytvorte prostredníctvom vstupu z konzoly rozhodovací test, ktorý vypíše známku A, B alebo C podľa týchto kritérií:
//		Ak je percento nad 90, tak vypíše známku A
//		Ak je percento nad 75, tak vypíše známku B
//		Ak je percento nad 65, tak vypíše známku C
//		Použite metódu pre rozhodovanie.


    public static char konvertujZnamku(double mark) {
        char znamkaPoKonverzii = 0;
        if (mark > 90) {
            znamkaPoKonverzii = 'A';
        } else if (mark > 75) {
            znamkaPoKonverzii = 'B';
        } else if (mark > 65) {
            znamkaPoKonverzii = 'C';
        }
        return znamkaPoKonverzii;
    }

    public static void main(String[] args) {

        try (Scanner vstupZKlavesnice = new Scanner(System.in)) {

            System.out.println("Program sa ukončí pri zadaní záporného čísla.");

            double sumaZnamok = 0;
            int pocitadloZnamok = 0;
            double percenta = 0;

            while (percenta >= 0) {
                System.out.print("Zadaj známku v percentách: ");
                percenta = vstupZKlavesnice.nextDouble();

                if (percenta > 0) {
                    sumaZnamok += percenta;
                    pocitadloZnamok++;

                    char znamkaPoKonverzii = konvertujZnamku(percenta);

                    if (znamkaPoKonverzii != 0) {
                        System.out.println(percenta + " == " + znamkaPoKonverzii);
                    } else {
                        System.out.println("Neuspel");
                    }
                }
            }

            if (pocitadloZnamok > 0) {
                double priemer = sumaZnamok / pocitadloZnamok;
                var znamkaPriemer = konvertujZnamku(priemer);

                if (znamkaPriemer == 0) {
                    znamkaPriemer = 'N';
                }
                System.out.printf("Priemer triedy je %.2f čo je známka %s.%n", priemer, znamkaPriemer);
            }
            System.out.println("Koniec programu.");
        }
    }
}
