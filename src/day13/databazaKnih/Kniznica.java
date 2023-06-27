package day13.databazaKnih;

/**
 * Trieda pre správu databázy kníh.
 */
public class Kniznica extends JadroKniznice{

    public static void main(String[] args) {

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
                    if (mojaKniznica.pridajNovuKnihu(novaKniha())) {
                        System.out.println("Kniha bola pridaná do knižnice.");
                    } else {
                        System.out.println("Knihu nebolo možné pridať!");
                    }
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
        }

        System.out.println("KONIEC PROGRAMU!");
    }

    private static void naplnenieKniznice(DatabazaKnih databazaKnih) {
        Kniha kniha1 = new Kniha("J.R.R. Tolkien", "Pán prsteňov: Spoločenstvo prsteňa", 1954, "Fantasy", "Albatros");
        databazaKnih.pridajNovuKnihu(kniha1);

        Kniha kniha2 = new Kniha("George Orwell", "1984", 1949, "Fikcia", "Secker & Warburg");
        databazaKnih.pridajNovuKnihu(kniha2);

        Kniha kniha3 = new Kniha("Harper Lee", "Neznesiteľná ľahkosť bytia", 1960, "Román", "J.B. Lippincott & Co.");
        databazaKnih.pridajNovuKnihu(kniha3);

        Kniha kniha4 = new Kniha("F. Scott Fitzgerald", "Veľký Gatsby", 1925, "Román", "Charles Scribner's Sons");
        databazaKnih.pridajNovuKnihu(kniha4);

        Kniha kniha5 = new Kniha("Gabriel García Márquez", "Sto rokov samoty", 1967, "Magický realizmus", "Editorial Sudamericana");
        databazaKnih.pridajNovuKnihu(kniha5);

        Kniha kniha6 = new Kniha("Leo Tolstoy", "Vojna a mier", 1869, "Historický román", "The Russian Messenger");
        databazaKnih.pridajNovuKnihu(kniha6);

        Kniha kniha7 = new Kniha("Jane Austen", "Hrdinka románu", 1813, "Román", "Thomas Egerton");
        databazaKnih.pridajNovuKnihu(kniha7);

        Kniha kniha8 = new Kniha("Markus Zusak", "Zlodejka kníh", 2005, "Historický román", "Picador");
        databazaKnih.pridajNovuKnihu(kniha8);

        Kniha kniha9 = new Kniha("J.D. Salinger", "Kto chytá v žite", 1951, "Román", "Little, Brown and Company");
        databazaKnih.pridajNovuKnihu(kniha9);

        Kniha kniha10 = new Kniha("J.K. Rowling", "Harry Potter a Kameň mudrcov", 1997, "Fantasy", "Bloomsbury");
        databazaKnih.pridajNovuKnihu(kniha10);

        Kniha kniha11 = new Kniha("Ray Bradbury", "451 stupňov Fahrenheita", 1953, "Sci-fi", "Ballantine Books");
        databazaKnih.pridajNovuKnihu(kniha11);

        Kniha kniha12 = new Kniha("Ernest Hemingway", "Starí a more", 1952, "Román", "Charles Scribner's Sons");
        databazaKnih.pridajNovuKnihu(kniha12);

        Kniha kniha13 = new Kniha("Hermann Hesse", "Stepný vlk", 1927, "Román", "S. Fischer Verlag");
        databazaKnih.pridajNovuKnihu(kniha13);

        Kniha kniha14 = new Kniha("Emily Brontë", "Veterný vrch", 1847, "Román", "Thomas Cautley Newby");
        databazaKnih.pridajNovuKnihu(kniha14);

        Kniha kniha15 = new Kniha("Aldous Huxley", "Nová odveta", 1932, "Sci-fi", "Chatto & Windus");
        databazaKnih.pridajNovuKnihu(kniha15);

        Kniha kniha16 = new Kniha("Victor Hugo", "Biedny vrah", 1869, "Román", "A. Lacroix, Verboeckhoven & Cie.");
        databazaKnih.pridajNovuKnihu(kniha16);

        Kniha kniha17 = new Kniha("Lewis Carroll", "Alenka v kraji zázrakov", 1865, "Detská literatúra", "Macmillan");
        databazaKnih.pridajNovuKnihu(kniha17);

        Kniha kniha18 = new Kniha("Terry Pratchett", "Farma zvierat", 1984, "Fantasy", "Gollancz");
        databazaKnih.pridajNovuKnihu(kniha18);

        Kniha kniha19 = new Kniha("John Steinbeck", "Hrozny hnevu", 1939, "Román", "The Viking Press");
        databazaKnih.pridajNovuKnihu(kniha19);

        Kniha kniha20 = new Kniha("Charlotte Brontë", "Jana Eyrová", 1847, "Román", "Smith, Elder & Co.");
        databazaKnih.pridajNovuKnihu(kniha20);
    }
}