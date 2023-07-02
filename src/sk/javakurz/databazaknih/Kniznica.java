package sk.javakurz.databazaknih;

import sk.javakurz.databazaknih.base.FarebnaKonzola;
import sk.javakurz.databazaknih.dao.DatabazaKnihDao;
import sk.javakurz.databazaknih.dao.DatabazaKnihDaoImpl;
import sk.javakurz.databazaknih.services.MenuService;
import sk.javakurz.databazaknih.services.MenuServiceImpl;
import sk.javakurz.databazaknih.services.SuboryServiceImpl;

/**
 * Trieda pre správu databázy kníh.
 */
public class Kniznica {

    public static void main(String[] args) {
        //Inicializácia knižnice
        DatabazaKnihDao mojaKniznica = new DatabazaKnihDaoImpl();
        MenuService menuService = new MenuServiceImpl(mojaKniznica);
        SuboryServiceImpl suboryServiceImpl = new SuboryServiceImpl(mojaKniznica);

        String volba;

        //Naplnenie knižnice pre testovanie.
        naplnenieKniznice(mojaKniznica);

        hlavneMenu:
        for (; ; ) {
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
                | 9. Ulož zoznam kníh ako PDF                |
                | X9. Vymaž všetky knihy                     |
                | Koniec = skončí zadávanie novej knihy      |
                +--------------------------------------------+
                """);

            volba = menuService.vstup(FarebnaKonzola.RESET + "Tvoja voľba: ");

            switch (volba) {
                case "1":
                    menuService.novaKniha();
                    break;
                case "2":
                    menuService.zobrazVsetkyKnihy();
                    break;
                case "3":
                    menuService.zobrazKnihu();
                    break;
                case "4":
                    menuService.vymazKnihu();
                    break;
                case "5":
                    menuService.vypisPocetKnih();
                    break;
                case "6":
                    menuService.hladajKnihu();
                    break;
                case "9":
                    suboryServiceImpl.ulozDoPDF();
                    break;
                case "X9":
                    menuService.vymazKniznicu();
                    break;
                case "Koniec":
                    break hlavneMenu;
                default:
                    System.out.println("Zadaj voľbu z menu.");
            }
            menuService.vstup("\nPre pokračovanie stlač ENTER.");
        }
        System.out.println("PROGRAM KNIŽNICA BOL UKONČENÝ!");
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