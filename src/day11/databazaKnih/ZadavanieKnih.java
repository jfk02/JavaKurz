package day11.databazaKnih;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Trieda pre správu databázy kníh.
 */
public class ZadavanieKnih {

    /**
     * Vstup užívateľa z konzoly.
     *
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
                vlozenaKniha = riadkovyVstup.nextLine().trim();
            } catch (NoSuchElementException e) {
                System.out.print("\n\n Nastala chyba pri vstupe!\n\n");
                chybaVstupu = true;
            }
        } while (chybaVstupu);

        return vlozenaKniha;
    }

    /**
     * Vypíše všetky knihy v databáze na konzolu.
     *
     * @param zoznamKnihPreVypis
     */
    private static void vypisKnihy(ArrayList<Kniha> zoznamKnihPreVypis) {
        zoznamKnihPreVypis.forEach(kniha -> {
            System.out.println(kniha.getNazov() + ", "
                    + kniha.getAutor() + ", "
                    + kniha.getRokVydania());
        });

    }

    public static void main(String[] args) {

        ArrayList<Kniha> knihy = new ArrayList<>();
        String vstupUzivatela = "";

        System.out.println("Pre naplnenie zoznamu kníh zadávaj ich názvy.\n"
                + "Zadávanie ukončíš slovom \"koniec\".\n");

        for (; ; ) {
            vstupUzivatela = vstup("Zadať ďalšiu knihu? ");
            if (vstupUzivatela.equalsIgnoreCase("koniec")) break;

            vstupUzivatela = vstup("\tNázov: ");
            var novaKniha = new Kniha(vstupUzivatela);

            vstupUzivatela = vstup("\tAutor: ");
            novaKniha.setAutor(vstupUzivatela);

            vstupUzivatela = vstup("\tRok vydania: ");
            int rok = Integer.parseInt(vstupUzivatela);
            novaKniha.setRokVydania(rok);

            System.out.println();
            knihy.add(novaKniha);
        }

        System.out.println();

        if (knihy.size() > 0) {
            vypisKnihy(knihy);
        }
    }
}
