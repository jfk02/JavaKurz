package day4;

import static java.lang.System.out;

import java.util.Scanner;

public class priklad12 {

    public static void main(String[] args) {

        int prveCislo = 0;
        int druheCislo = 0;
        String operacia = "+";

        try (Scanner inputScan = new Scanner(System.in)) {

            while (true) {
                out.print("Zadaj 1. cislo: ");
                prveCislo = inputScan.nextInt();

                out.print("Zadaj 2. cislo: ");
                druheCislo = inputScan.nextInt();

                out.print("Aku operaciu si prajes vykonat (+,-,*,/): ");
                operacia = inputScan.next();

                if (operacia.equals(".")) {
                    break;
                }

                switch (operacia) {
                case "+":
                    out.println(prveCislo + " + " + druheCislo + " = " + (prveCislo + druheCislo));
                    break;
                case "-":
                    out.println(prveCislo + " - " + druheCislo + " = " + (prveCislo - druheCislo));
                    break;
                case "*":
                    out.println(prveCislo + " * " + druheCislo + " = " + (prveCislo * druheCislo));
                    break;
                case "/":
                    out.println(prveCislo + " : " + druheCislo + " = " + (prveCislo / druheCislo));
                    break;
                default:
                }

            }

        }

    }

}
