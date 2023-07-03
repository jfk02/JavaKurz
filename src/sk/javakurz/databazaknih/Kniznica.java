package sk.javakurz.databazaknih;

import sk.javakurz.databazaknih.base.FarebnaKonzola;
import sk.javakurz.databazaknih.dao.DatabazaKnihDao;
import sk.javakurz.databazaknih.dao.DatabazaKnihDaoImpl;
import sk.javakurz.databazaknih.services.MenuService;
import sk.javakurz.databazaknih.services.MenuServiceImpl;
import sk.javakurz.databazaknih.services.SuboryService;
import sk.javakurz.databazaknih.services.SuboryServiceImpl;

import java.util.HashMap;


/**
 * Hlavná trieda programu obsahujúca main metódu.
 */
public class Kniznica {
    private static DatabazaKnihDao mojaKniznica;
    private static MenuService menuService;
    private static SuboryService suboryService;

    //Slovník akcií vyvolávaných z menu.
    private static final HashMap<String, Runnable> MENU_AKCIE = new HashMap<>() {{
        put("1", () -> menuService.novaKniha());
        put("2", () -> menuService.zobrazVsetkyKnihy());
        put("3", () -> menuService.zobrazKnihu());
        put("4", () -> menuService.vymazKnihu());
        put("5", () -> menuService.vypisPocetKnih());
        put("6", () -> menuService.hladajKnihu());
        put("7", () -> {
            if (suboryService.nacitajDatabazu()) {
                System.out.println("Knižnica bola úspešne načítaná z disku.");
            }
        });
        put("8", () -> {
            if (suboryService.ulozDatabazu()) {
                System.out.println("Knižnica bola uložená do disku.");
            }
        });
        put("9", () -> {
            if (suboryService.ulozDoPDF()) {
                System.out.println("Knižnica bola uložená do PDF.");
            }
        });
        put("X", () -> menuService.vymazKniznicu());
        put("Q", () -> {
        });
    }};

    /**
     * Inicializuje aplikáciu vytvorením databázy a všetkých služieb s použitím Dependency Injection.
     */
    private static void inicializaciaAplikacie() {
        //Inicializácia knižnice - Dependency
        mojaKniznica = new DatabazaKnihDaoImpl();
        //Inicializácia služieb - Dependency Injection
        menuService = new MenuServiceImpl(mojaKniznica);
        suboryService = new SuboryServiceImpl(mojaKniznica);
    }

    /**
     * Hlavné menu programu Kniznica.
     */
    private static void hlavneMenu() {

        var volba = "";

        do {
            System.out.println(FarebnaKonzola.CYAN_BOLD_BRIGHT);
            System.out.println("""
                    +--------------------------------------------+
                    |               MENU KNIŽNICE                |
                    +--------------------------------------------+
                    | 1. Zadaj novú knihu                        |
                    | 2. Zobraz všetky knihy                     |
                    | 3. Zobraz konkrétnu knihu (podľa indexu)   |
                    | 4. Vymaž konkrétnu knihu (podľa indexu)    |
                    | 5. Zobraz počet všetkých kníh              |
                    | 6. Hľadaj knihu podľa autora alebo názvu   |
                    | 7. Načítaj knižnicu z disku                |
                    | 8. Ulož knižnicu na disk                   |
                    | 9. Ulož zoznam kníh ako PDF                |
                    | X. Vymaž všetky knihy                      |
                    | Q. Skončí program                          |
                    +--------------------------------------------+
                    """);

            volba = menuService.vstup(FarebnaKonzola.RESET + "Tvoja voľba: ");

            if (MENU_AKCIE.containsKey(volba)) {
                MENU_AKCIE.get(volba).run();
                menuService.vstup("\nPre pokračovanie stlač ENTER.");
            } else {
                System.out.println("Zadaj voľbu z menu.");
            }
        } while (!volba.equals("Q"));
    }

    public static void main(String[] args) {

        inicializaciaAplikacie();

        //Naplnenie knižnice pre testovanie.
        naplnenieKniznice(mojaKniznica);

        hlavneMenu();

        System.out.println(FarebnaKonzola.CYAN_BOLD_BRIGHT + "PROGRAM KNIŽNICA BOL UKONČENÝ!");
    }

    /**
     * Naplnenie knižnice pre testovanie.
     *
     * @param databazaKnihDao
     */
    private static void naplnenieKniznice(DatabazaKnihDao databazaKnihDao) {
        databazaKnihDao.pridajKnihu("J.R.R. Tolkien", "Pán prsteňov: Spoločenstvo prsteňa", 1954);
        databazaKnihDao.pridajKnihu("George Orwell", "1984", 1949);
        databazaKnihDao.pridajKnihu("Harper Lee", "Neznesiteľná ľahkosť bytia", 1960);
        databazaKnihDao.pridajKnihu("F. Scott Fitzgerald", "Veľký Gatsby", 1925);
        databazaKnihDao.pridajKnihu("Gabriel García Márquez", "Sto rokov samoty", 1967);
        databazaKnihDao.pridajKnihu("Leo Tolstoy", "Vojna a mier", 1869);
        databazaKnihDao.pridajKnihu("Jane Austen", "Hrdinka románu", 1813);
        databazaKnihDao.pridajKnihu("Markus Zusak", "Zlodejka kníh", 2005);
        databazaKnihDao.pridajKnihu("J.D. Salinger", "Kto chytá v žite", 1951);
        databazaKnihDao.pridajKnihu("J.K. Rowling", "Harry Potter a Kameň mudrcov", 1997);
        databazaKnihDao.pridajKnihu("Ray Bradbury", "451 stupňov Fahrenheita", 1953);
        databazaKnihDao.pridajKnihu("Ernest Hemingway", "Starí a more", 1952);
        databazaKnihDao.pridajKnihu("Hermann Hesse", "Stepný vlk", 1927);
        databazaKnihDao.pridajKnihu("Emily Brontë", "Veterný vrch", 1847);
        databazaKnihDao.pridajKnihu("Aldous Huxley", "Nová odveta", 1932);
        databazaKnihDao.pridajKnihu("Victor Hugo", "Biedny vrah", 1869);
        databazaKnihDao.pridajKnihu("Lewis Carroll", "Alenka v kraji zázrakov", 1865);
        databazaKnihDao.pridajKnihu("Terry Pratchett", "Farma zvierat", 1984);
        databazaKnihDao.pridajKnihu("John Steinbeck", "Hrozny hnevu", 1939);
        databazaKnihDao.pridajKnihu("Charlotte Brontë", "Jana Eyrová", 1847);
    }
}