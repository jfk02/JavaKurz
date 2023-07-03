package sk.javakurz.zakladnepriklady.day5;

import static java.lang.System.out;

import java.util.Scanner;

public class priklad01 {

    static void kontrolaVeku(String meno, int vek) {
        out.print("Osoba " + meno);

        if (vek >= 18) {
            out.println(" je dospela.");
        } else {
            out.println(" je nedospela.");
        }
    }    

    public static void main(String[] args) {

        String meno = "";
        int vek = 0;

        try (Scanner inputScan = new Scanner(System.in)) {
            out.print("Zadaj meno: ");
            meno = inputScan.nextLine();
            out.print("Zadaj vek osoby: ");
            vek = inputScan.nextInt();
        }

        kontrolaVeku(meno, vek);
    }
}
