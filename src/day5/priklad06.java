package day5;

import static java.lang.System.out;

import java.util.Scanner;

public class priklad06 {

    static String doplnPozdrav(String meno) {
        return "Ahoj, " + meno + " !";
    }

    static double calculate(int prveCislo, int druheCislo, String operacia) {

        switch (operacia) {
        case "+":
            return (double) (prveCislo + druheCislo);
        case "-":
            return (double) (prveCislo - druheCislo);
        case "*":
            return (double) (prveCislo * druheCislo);
        case "/":
            return (double) (prveCislo / druheCislo);
        default:
            out.println("Taku operaciu neviem vykonat!");
            return (double) 0;
        }
    }

    public static void main(String[] args) {

        String operacia = "";
        int operand1 = 0;
        int operand2 = 0;

        try (Scanner inputScan = new Scanner(System.in)) {
            out.print("Zadaj 1. cislo: ");
            operand1 = inputScan.nextInt();
            out.print("Zadaj 2. cislo: ");
            operand2 = inputScan.nextInt();
            out.print("Zadaj znak operacie (+, -, *, /): ");
            operacia = inputScan.next();
        }

        out.println(operand1 + " " + operacia + " " + operand2 + " = " + calculate(operand1, operand2, operacia.trim()));

    }
}
