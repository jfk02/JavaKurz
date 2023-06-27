package day13.databazaKnih;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class JadroKniznice {

    /**
     * Pretypuje číslo v stringu na int s kontrolou na výnimku.
     *
     * @param cislo Pretypované číslo.
     * @return Číslo ako int ak je úspešný, inak -1.
     */
    private static int mojStringNaInt(String cislo) {
        int pretypovaneCislo;
        try {
            pretypovaneCislo = Integer.parseInt(cislo);
        } catch (NumberFormatException e) {
            pretypovaneCislo = -1;
        }
        return pretypovaneCislo;
    }

    /**
     * Formatovaný výpis knižnice.
     * @param index
     * @param nazov
     * @param autor
     * @param rok
     */
    private static void formatovanyVypis(String index, String nazov, String autor, String rok) {
        System.out.printf("%6s | %-40s | %-30s | %-4s\n",
                index, nazov, autor, rok);
    }

    /**
     * Formatovaný výpis knižnice.
     * @param nazov
     * @param autor
     * @param rok
     */
    private static void formatovanyVypis(String nazov, String autor, String rok) {
        System.out.printf("%-40s | %-30s | %-4s\n",
                nazov, autor, rok);
    }

    /**
     * Vstup užívateľa z konzoly.
     *
     * @param vyzva Výzva - prompt pre užívateľa.
     * @return Vstup užívateľa ako String.
     */
    protected static String vstup(String vyzva) {
        boolean chybaVstupu;
        String vstupUzivatela = "";

        do {
            Scanner citajVstup = new Scanner(System.in);
            chybaVstupu = false;

            System.out.print(vyzva);
            try {
                vstupUzivatela = citajVstup.nextLine().trim();
            } catch (NoSuchElementException e) {
                System.out.print("\n\n Nastala chyba pri vstupe!\n\n");
                chybaVstupu = true;
            }
        } while (chybaVstupu);

        return vstupUzivatela;
    }

    /**
     * Vytvorí novú knihu zo vstupu užívateľa.
     *
     * @return Nová Kniha.
     */
    protected static Kniha novaKniha() {
        String vlastnostiKnihy;

        vlastnostiKnihy = vstup("\tNázov: ");
        var novaKniha = new Kniha(vlastnostiKnihy);

        vlastnostiKnihy = vstup("\tAutor: ");
        novaKniha.setAutor(vlastnostiKnihy);

        vlastnostiKnihy = vstup("\tRok vydania: ");
        int rok = mojStringNaInt(vlastnostiKnihy);
        novaKniha.setRokVydania(rok);

        return novaKniha;
    }

    /**
     * Vypíše všetky knihy v databáze na konzolu.
     *
     * @param databazaKnih Používaná databáza kníh.
     */
    protected static void zobrazVsetkyKnihy(DatabazaKnih databazaKnih) {
        if (databazaKnih.pocetKnih() > 0) {
            System.out.println();
            formatovanyVypis("INDEX", "NÁZOV", "AUTOR", "ROK");
            for (int i = 0; i < databazaKnih.pocetKnih(); i++) {
                var kniha = databazaKnih.zobrazKnihu(i);
                formatovanyVypis(Integer.toString(i),
                        kniha.getNazov(),
                        kniha.getAutor(),
                        Integer.toString(kniha.getRokVydania()));
            }
        } else {
            System.out.println("Knižnica je prázdna!");
        }
    }

    /**
     * Zobrazí jednu knihu na konzole.
     *
     * @param databazaKnih Používaná databáza kníh.
     */
    protected static void zobrazKnihu(DatabazaKnih databazaKnih) {
        String vstupIndex = vstup("\tIndex knihy pre zobrazenie: ");
        int index;

        index = mojStringNaInt(vstupIndex);

        var kniha = databazaKnih.zobrazKnihu(index);
        if (kniha != null) {
            System.out.println();
            formatovanyVypis("INDEX", "NÁZOV", "AUTOR", "ROK");
            formatovanyVypis(Integer.toString(index),
                    kniha.getNazov(),
                    kniha.getAutor(),
                    Integer.toString(kniha.getRokVydania()));
        } else {
            System.out.println("Kniha s indexom " + index + " neexistuje!");
        }
    }

    /**
     * Vymaže konkrétnu knihu.
     *
     * @param databazaKnih Používaná databáza kníh.
     */
    protected static void vymazKnihu(DatabazaKnih databazaKnih) {
        String vstupIndex = vstup("\tIndex knihy pre vymazanie: ");
        int index;

        index = mojStringNaInt(vstupIndex);

        var vymazana = databazaKnih.vymazKnihu(index);
        if (vymazana) {
            System.out.println("Kniha s indexom " + index + " bola vymazaná.");
        } else {
            System.out.println("Kniha s indexom " + index + " neexistuje!");
        }
        System.out.println();
    }

    /**
     * Vymaže celú knižnicu po odpovedi na otázku "Skutočne vymazať celú knižnicu?(Nie/ÁNO): "
     *
     * @param databazaKnih Používaná databáza kníh.
     */
    protected static void vymazKniznicu(DatabazaKnih databazaKnih) {
        String skutocneVymazat = vstup("\tSkutočne vymazať celú knižnicu?(Nie/ÁNO): ");
        if (skutocneVymazat.equals("ÁNO")) {
            databazaKnih.vymazVsetkyKnihy();
            System.out.println("KNIŽNICA BOLA VYMAZANÁ!");
        }
    }

    /**
     * Vyhľadá knihu v databáze na základe zadaného textu.
     *
     * @param databazaKnih Používaná databáza kníh.
     */
    protected static void hladajKnihu(DatabazaKnih databazaKnih) {
        String hladanyText = vstup("\tZadaj názov alebo autora: ");
        var najdeneKnihy = databazaKnih.hladajKnihu(hladanyText);

        if ((najdeneKnihy != null) && !najdeneKnihy.isEmpty()) {
            System.out.println("\nV knižnici boli nájdené tieto knihy:");
            formatovanyVypis("NÁZOV", "AUTOR", "ROK");

            najdeneKnihy.forEach(kniha ->
                    formatovanyVypis(kniha.getNazov(),
                            kniha.getAutor(),
                            Integer.toString(kniha.getRokVydania())));
        } else {
            System.out.println("Neboli nájdené žiadne knihy!");
        }
    }
}
