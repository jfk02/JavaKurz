package day4;

import static java.lang.System.out;

import java.util.Scanner;

public class priklad9 {

	public static void main(String[] args) {

		int n = 1;

		try (Scanner inputScan = new Scanner(System.in)) {
			out.print("Zadaj pociatocny pocet: ");
			n = inputScan.nextInt();
		}

		for (int i = n; i >= 0; i--) {
			out.println("* ".repeat(i));
		}
	}

}
