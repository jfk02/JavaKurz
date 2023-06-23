package day11;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Riešenie príkladu Úloha č.1 z 22.06.2023 "Sčítanie vstupných hodnôt cez ArrayList". Trieda používa pre
 * ukladanie desatinných čísiel typ Long pre riešenie problému presnosti matematiky čísiel typu double.
 * Desatinné čísla sa ukladajú v dynamickom poli ako celé po zaokrúhlení na {@value DESATINNE_MIESTA} desatinné miesta
 * a vynásobení 10^{@value DESATINNE_MIESTA}.
 */
public class ArrayListSucetPriklad {

    final private static int DESATINNE_MIESTA = 3;
    final private static int NASOBOK = (int) Math.pow(10, DESATINNE_MIESTA);

    /**
     * Vstup čísla z konzoly. Pri výnimke sa opakuje vstup s výzvou na zadanie správnej hodnoty.
     *
     * @param vyzva
     * @return Desatinné číslo zaokrúhlené na {@value DESATINNE_MIESTA} desatinné miesta ako celé číslo vynásobené 10^{@value DESATINNE_MIESTA}.
     */
    private static long vstupCisla(String vyzva) {
        boolean chybaVstupu;
        double vstup = 0;
        do {
            Scanner inputScan = new Scanner(System.in);
            chybaVstupu = false;
            System.out.print(vyzva);
            try {
                vstup = inputScan.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("\nAko vstup je možné použiť len desatinné čísla!\n");
                chybaVstupu = true;
            }
        } while (chybaVstupu);
        return Math.round(vstup * NASOBOK);
    }


    /**
     * Vypíše celé čísla uložené v dynamickom poli ako destinné čísla zaokrúhlené na {@value DESATINNE_MIESTA} desatinné miesta.
     *
     * @param cislaPreVypis
     */
    private static void vypisCisiel(ArrayList<Long> cislaPreVypis) {
        for (int i = 0; i < cislaPreVypis.size(); i++) {
            double cisloPreVypis = (double) cislaPreVypis.get(i) / NASOBOK;
            System.out.printf("%d : %." + DESATINNE_MIESTA + "f\n", i, cisloPreVypis);
        }
    }

    /**
     * Vypočíta súčet poľa.
     *
     * @param cislaPreSucet
     * @return Súčet ako double na {@value DESATINNE_MIESTA} desatinné miesta.
     */
    private static double sucetCisiel(ArrayList<Long> cislaPreSucet) {
        long sucet = 0;
        for (int i = 0; i < cislaPreSucet.size(); i++) {
            sucet += cislaPreSucet.get(i);
        }
        return (double) sucet / NASOBOK;
    }

    public static void main(String[] args) {
        ArrayList<Long> ciselnePole = new ArrayList<>();
        long novyVstup = 0;
        String vyzvaPreZadanieVstupu = "Zadaj číslo: ";

        System.out.println("Vstup hodnôt pre súčet je možný po výzve \"" + vyzvaPreZadanieVstupu + "\"\n"
                + "Zadané hodnoty budú zaokrúhlené na " + DESATINNE_MIESTA + " desatinné miesta!\n"
                + "Program sa skončí po zadaní záporného čísla.\n");

        //Cyklus pre vytvorenie poľa hodnôt zo vstupu zadaného používateľom.
        for (; ; ) {
            novyVstup = vstupCisla(vyzvaPreZadanieVstupu);
            if (novyVstup < 0) break;
            ciselnePole.add(novyVstup);
        }

        System.out.println();

        //Ošetrenie situácie, keď používateľ ukončil program zadaním záporného čísla ako prvej hodnoty.
        if (ciselnePole.size() > 0) {
            System.out.println("Boli zadané nasledujúce čísla:");
            vypisCisiel(ciselnePole);
            System.out.printf("\nSúčet zadaného poľa je: %." + DESATINNE_MIESTA + "f\n", sucetCisiel(ciselnePole));
        } else {
            System.out.println("Neboli zadané žiadne hodnoty!");
        }

    }
}