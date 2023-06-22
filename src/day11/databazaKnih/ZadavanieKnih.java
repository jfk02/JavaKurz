package day11.databazaKnih;

import day11.databazaKnih.Kniha;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Trieda pre správu databázy kníh.
 */
public class ZadavanieKnih {

    /**
     * Vstup užívateľa z konzoly.
     * @param vyzva
     * @return Vstup užívateľa ako String.
     */
    private static String vstup(String vyzva) {
        boolean chybaVstupu;
        String vlozenaKniha = "";

        do {
            Scanner riadkovyVstup = new Scanner(System.in);
            chybaVstupu = false;

            System.out.print(vyzva);
            try {
                vlozenaKniha = riadkovyVstup.nextLine();
            } catch (NoSuchElementException e) {
                System.out.print("\n\n Nastala chyba pri vstupe!\n\n");
                chybaVstupu = true;
            }
        } while (chybaVstupu);

        return vlozenaKniha;
    }

    /**
     * Vypíše všetky knihy v databáze na konzolu.
     * @param zoznamKnihPreVypis
     */
    private static void vypisKnihy(ArrayList<Kniha> zoznamKnihPreVypis) {
        for (int i = 0; i < zoznamKnihPreVypis.size(); i++) {
            System.out.println(i + " : " + zoznamKnihPreVypis.get(i).getNazov());
        }
    }

    public static void main(String[] args) {

        ArrayList<Kniha> knihy = new ArrayList<>();
        String vstupUzivatela = "";

        System.out.println("Pre naplnenie zoznamu kníh zadávaj ich názvy.");
        System.out.println("Zadávanie ukončíš slovom \"koniec\".");
        System.out.println();

        for (; ; ) {
            vstupUzivatela = vstup("Zadať ďalšiu knihu? ");
            if (vstupUzivatela.toLowerCase().trim().equals("koniec")) break;

            vstupUzivatela = vstup("Zadaj názov knihy: ");
            var novaKniha = new Kniha (vstupUzivatela);

            System.out.println();
            knihy.add(novaKniha);
        }

        if (knihy.size() > 0) {
            vypisKnihy(knihy);
        }
    }
}
