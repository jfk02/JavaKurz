package day12.Auta;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Trieda pre správu databázy automobilov.
 */
public class SpravaAutomobilov {

    /**
     * Vstup užívateľa z konzoly.
     *
     * @param vyzva Vyzva, ktorá sa zobrazí pred vstupom.
     * @return Vstup užívateľa ako String.
     */
    private static String vstup(String vyzva) {
        boolean chybaVstupu;
        String vstupUzivatela = "";

        do {
            Scanner riadkovyVstup = new Scanner(System.in);
            chybaVstupu = false;

            System.out.print(vyzva);
            try {
                vstupUzivatela = riadkovyVstup.nextLine().trim();
            } catch (NoSuchElementException e) {
                System.out.print("\n\n Nastala chyba pri vstupe!\n\n");
                chybaVstupu = true;
            }
        } while (chybaVstupu);

        return vstupUzivatela;
    }

    /**
     * Vypíše všetky vozidlá v databáze na konzolu.
     *
     * @param zoznamAutomobilovPreVypis Zoznam automobilov pre vypis.
     */
    private static void vypisAutomobilov(ArrayList<Auto> zoznamAutomobilovPreVypis) {
        zoznamAutomobilovPreVypis.forEach(auto -> System.out.println(auto.getZnacka() + ", "
                + auto.getTyp() + ", "
                + auto.getFarba()));
    }

    public static void main(String[] args) {

        ArrayList<Auto> auta = new ArrayList<>();
        String vstupUzivatela;

        System.out.println("""
                Pre naplnenie zoznamu áut vyplň formulár.
                Zadávanie ukončíš slovom "koniec".
                """);

        for (; ; ) {
            vstupUzivatela = vstup("Zadať ďalšie vozidlo? ");
            if (vstupUzivatela.equalsIgnoreCase("koniec")) break;

            vstupUzivatela = vstup("\tZnačka: ");
            var noveAuto = new Auto(vstupUzivatela);

            vstupUzivatela = vstup("\tTyp: ");
            noveAuto.setTyp(vstupUzivatela);

            vstupUzivatela = vstup("\tFarba: ");
            if (!vstupUzivatela.isEmpty()) noveAuto.setFarba(vstupUzivatela);

            System.out.println();
            auta.add(noveAuto);
        }

        System.out.println();

        if (!auta.isEmpty()) {
            vypisAutomobilov(auta);
        } else {
            System.out.println("Zoznam áut je prázdny!");
        }

    }
}
