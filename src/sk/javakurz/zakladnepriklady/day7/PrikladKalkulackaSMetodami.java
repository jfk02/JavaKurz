package sk.javakurz.zakladnepriklady.day7;

import static java.lang.System.out;

import java.util.Locale;
import java.util.Scanner;

public class PrikladKalkulackaSMetodami {

    static double scitanie(double prveCislo, double druheCislo) {
        return prveCislo + druheCislo;
    }

    static double odcitanie(double prveCislo, double druheCislo) {
        return prveCislo - druheCislo;
    }

    static double nasobenie(double prveCislo, double druheCislo) {
        return prveCislo * druheCislo;
    }

    static double delenie(double prveCislo, double druheCislo) {
        double vysledok = 0;
        if (druheCislo != 0) {
            vysledok = prveCislo / druheCislo;
        } else {
            out.println("Nulou nie je možné deliť!");
        }
        return vysledok;
    }

    static double modulo(double prveCislo, double druheCislo) {
        double vysledok = 0;
        if (druheCislo != 0) {
            vysledok = prveCislo % druheCislo;
        } else {
            out.println("Nulou nie je možné deliť!");
        }
        return vysledok;
    }

    static double kalkulacka(double prveCislo, double druheCislo, String operacia) {
        double vysledok = 0;

        switch (operacia) {
            case "+":
                vysledok = scitanie(prveCislo, druheCislo);
                break;
            case "-":
                vysledok = odcitanie(prveCislo, druheCislo);
                break;
            case "*":
                vysledok = nasobenie(prveCislo, druheCislo);
                break;
            case "/":
                vysledok = delenie(prveCislo, druheCislo);
                break;
            case "%":
                vysledok = modulo(prveCislo, druheCislo);
                break;
            default:
                out.println("Takú operáciu nepoznám!");
        }
        return vysledok;
    }

    public static void main(String[] args) {

        String operacia = "";
        double operand1 = 0;
        double operand2 = 0;
        double vysledok = 0;

        try (Scanner inputScan = new Scanner(System.in)) {
            inputScan.useLocale(Locale.forLanguageTag("sk-SK"));
            out.print("Zadaj 1. cislo: ");
            operand1 = inputScan.nextDouble();
            out.print("Zadaj 2. cislo: ");
            operand2 = inputScan.nextDouble();
            out.print("Akú operáciu mám vykonať (+, -, *, /, %)? ");
            operacia = inputScan.next();
        }

        operacia = operacia.trim();
        vysledok = kalkulacka(operand1, operand2, operacia);

        out.printf("%.2f %s %.2f = %.2f%n", operand1, operacia, operand2, vysledok);
    }
}
