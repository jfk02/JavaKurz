package sk.javakurz.zakladnepriklady.day6;

import static java.lang.System.out;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Priklad01 {

    public static void main(String[] args) {
        /*
         * Vypíšte do konzoly nasledujúci text:
         * 
         * Študent Jozef Mrkvička sa narodil 03.04.2000, z maturitnej skúšky má známku
         * 1.5 a od septembra 2022 nastúpi do nového zamestnania ako Java programátor. V
         * Bratislave dňa 18.06.2022 Poznámka: Dátum narodenia, známku a rok + aktuálny
         * dátum nastavte tak, aby sa dali meniť v zdrojovom kóde (t.j. cez premenné).
         */

        double studentGrade = 1.5;
        int year = 2022;

        Date datum = new Date();
        SimpleDateFormat dayFormatter = new SimpleDateFormat("dd.MM.yyyy");
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

        LocalDate birthDate = LocalDate.of(2023,05,10);

        String textToShow = "Študent Jozef Mrkvička sa narodil " + dateFormatter.format(birthDate)+ ", z maturitnej skúšky má známku "
                + studentGrade + " a od septembra " + year + " nastúpi do nového zamestnania ako Java programátor.\n"
                + "V Bratislave dňa " + dayFormatter.format(datum);

        out.println(textToShow);
    }
}
