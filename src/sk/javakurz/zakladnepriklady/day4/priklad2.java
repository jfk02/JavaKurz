package sk.javakurz.zakladnepriklady.day4;

import static java.lang.System.out;

import java.util.Scanner;

public class priklad2 {

	public static void main(String[] args) {
		int a, b, c, d;
		int max;

		Scanner inputScan = new Scanner(System.in);
		out.print("Zadaj 1. číslo: ");
		a = inputScan.nextInt();
		out.print("Zadaj 2. číslo: ");
		b = inputScan.nextInt();
		out.print("Zadaj 3. číslo: ");
		c = inputScan.nextInt();
		out.print("Zadaj 4. číslo: ");
		d = inputScan.nextInt();
		inputScan.close();

		max = a;
		
		if (a > b) {
			max = a;
		} 

		if (c > max) {
			max = c;
		}

		if (d > max) {
			max = d;
		}

		out.println("Najvacsie je: " + max);
	}

}
