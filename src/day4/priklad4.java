package day4;

import static java.lang.System.out;

import java.util.Scanner;

public class priklad4 {

	public static void main(String[] args) {

		int a = 0;
		boolean test = false;

		Scanner inputScan = new Scanner(System.in);
		out.print("Zadaj číslo: ");
		a = inputScan.nextInt();
		inputScan.close();

		if (a >= 40 && a <= 80) {
			test = true;
		}

		out.println("Mozeme pokracovat: " + test);
	}

}
