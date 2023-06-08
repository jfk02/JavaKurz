package day5;

import static java.lang.System.out;

import java.util.Scanner;

public class priklad05 {

    static String doplnPozdrav(String meno) {
        return "Ahoj, " + meno + " !";
    }

    public static void main(String[] args) {

        String meno = "";

        try (Scanner inputScan = new Scanner(System.in)) {
            out.print("Zadaj meno: ");
            meno = inputScan.nextLine();
        }

        out.println(doplnPozdrav(meno.trim()));
    }
}
