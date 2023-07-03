package sk.javakurz.zakladnepriklady.day4;

import static java.lang.System.out;

import java.util.Scanner;

public class priklad8 {

	public static void main(String[] args) {

		int n = 1;
		int sucet = 0;

		try (Scanner inputScan = new Scanner(System.in)) {
			out.print("Zadaj pocet cisiel: ");
			n = inputScan.nextInt();
		}

		for (int i = 1; i <= n; i++) {
			out.println(i);
			sucet += i;
		}

		out.println("Sucet je: " + sucet);
	}

}
