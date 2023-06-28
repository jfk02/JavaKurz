package day13.databazaKnih;

import java.util.Scanner;

/**
 * Trieda pre správu databázy kníh.
 */
public class Kniznica extends JadroKniznice{

    public static void main(String[] args) {

        Scanner vstupZKonzoly = new Scanner(System.in);
        DatabazaKnih mojaKniznica = new DatabazaKnih();
        String volba;

        naplnenieKniznice(mojaKniznica);

        hlavneMenu:
        for (; ; ) {
            System.out.println("""
                                        
                    MENU KNIŽNICE:
                    1. Zadaj novú knihu
                    2. Zobraz všetky knihy
                    3. Zobraz konkrétnu knihu (podľa indexu)
                    4. Vymaž konkrétnu knihu (podľa indexu)
                    5. Zobraz počet všetkých kníh
                    6. Hľadaj knihu podľa autora alebo názvu
                    9. Vymaž všetky knihy
                    Koniec = skončí zadávanie novej knihy
                    """);

            volba = vstup("Tvoja voľba: ");

            switch (volba) {
                case "1":
                    novaKniha(mojaKniznica);
                    break;
                case "2":
                    zobrazVsetkyKnihy(mojaKniznica);
                    break;
                case "3":
                    zobrazKnihu(mojaKniznica);
                    break;
                case "4":
                    vymazKnihu(mojaKniznica);
                    break;
                case "5":
                    System.out.println("Počet kníh v knižnici je: " + mojaKniznica.pocetKnih());
                    break;
                case "6":
                    hladajKnihu(mojaKniznica);
                    break;
                case "9":
                    vymazKniznicu(mojaKniznica);
                    break;
                case "Koniec":
                    break hlavneMenu;
                default:
                    System.out.println("Zadaj voľbu z menu.");
            }
            System.out.println("\nPre pokračovanie stlač ENTER.");
            vstupZKonzoly.nextLine();
        }
        System.out.println("KONIEC PROGRAMU!");
    }

    private static void naplnenieKniznice(DatabazaKnih databazaKnih) {
        databazaKnih.pridajNovuKnihu ("J.R.R. Tolkien", "Pán prsteňov: Spoločenstvo prsteňa", 1954);
        databazaKnih.pridajNovuKnihu ("George Orwell", "1984", 1949);
        databazaKnih.pridajNovuKnihu ("Harper Lee", "Neznesiteľná ľahkosť bytia", 1960);
        databazaKnih.pridajNovuKnihu ("F. Scott Fitzgerald", "Veľký Gatsby", 1925);
        databazaKnih.pridajNovuKnihu ("Gabriel García Márquez", "Sto rokov samoty", 1967);
        databazaKnih.pridajNovuKnihu ("Leo Tolstoy", "Vojna a mier", 1869);
        databazaKnih.pridajNovuKnihu ("Jane Austen", "Hrdinka románu", 1813);
        databazaKnih.pridajNovuKnihu ("Markus Zusak", "Zlodejka kníh", 2005);
        databazaKnih.pridajNovuKnihu ("J.D. Salinger", "Kto chytá v žite", 1951);
        databazaKnih.pridajNovuKnihu ("J.K. Rowling", "Harry Potter a Kameň mudrcov", 1997);
        databazaKnih.pridajNovuKnihu ("Ray Bradbury", "451 stupňov Fahrenheita", 1953);
        databazaKnih.pridajNovuKnihu ("Ernest Hemingway", "Starí a more", 1952);
        databazaKnih.pridajNovuKnihu ("Hermann Hesse", "Stepný vlk", 1927);
        databazaKnih.pridajNovuKnihu ("Emily Brontë", "Veterný vrch", 1847);
        databazaKnih.pridajNovuKnihu ("Aldous Huxley", "Nová odveta", 1932);
        databazaKnih.pridajNovuKnihu ("Victor Hugo", "Biedny vrah", 1869);
        databazaKnih.pridajNovuKnihu ("Lewis Carroll", "Alenka v kraji zázrakov", 1865);
        databazaKnih.pridajNovuKnihu ("Terry Pratchett", "Farma zvierat", 1984);
        databazaKnih.pridajNovuKnihu ("John Steinbeck", "Hrozny hnevu", 1939);
        databazaKnih.pridajNovuKnihu ("Charlotte Brontë", "Jana Eyrová", 1847);
    }
}