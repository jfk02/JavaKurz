package sk.javakurz.zakladnepriklady.day5;

import static java.lang.System.out;

import java.util.Scanner;

public class priklad03 {

    static void nakresliObdlznik(int sirka, String znak) {

        out.println(znak.repeat(sirka));
        out.println(znak + " ".repeat(sirka - 2) + znak);
        out.println(znak.repeat(sirka));
    }

    static void nakresliObdlznik2(int sirka, char znak) {

        String riadokZnakov = "";
        String riadokMedzier = "";
        for (int i = 0; i < sirka; i++) {
            riadokZnakov += znak;
            if (i < sirka - 2) {
                riadokMedzier += " ";
            }
        }

        out.println(riadokZnakov);
        out.println(znak + riadokMedzier + znak);
        out.println(riadokZnakov);
    }

    public static void main(String[] args) {

        int sirka = 0;
        String znak = "";

        try (Scanner inputScan = new Scanner(System.in)) {
            out.print("Zadaj znak: ");
            znak = inputScan.next();
            out.print("Zadaj sirku: ");
            sirka = inputScan.nextInt();
        }

        nakresliObdlznik2(sirka, znak.charAt(0));
    }
}
