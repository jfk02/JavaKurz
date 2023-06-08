package day5;

import static java.lang.System.out;

import java.util.Scanner;

public class priklad07 {

    static String makeStarTriangle(int n) {

        String starTriangle = "";
        
        for (int i = n; i > 0; i--) {
            starTriangle += "*".repeat(i) + "\n";
        }

        return starTriangle;
    }

    public static void main(String[] args) {

        int number = 0;

        try (Scanner inputScan = new Scanner(System.in)) {
            out.print("Zadaj cislo: ");
            number = inputScan.nextInt();
        }

        out.println(makeStarTriangle(number));
    }
}
