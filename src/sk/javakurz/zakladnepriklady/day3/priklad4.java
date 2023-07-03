package sk.javakurz.zakladnepriklady.day3;

import static java.lang.System.out;

import java.util.Scanner;

public class priklad4 {

	public static void main(String[] args) {
		int a, b, c;
		int max = -1;

		Scanner inputScan = new Scanner(System.in);
		out.print("Zadaj prvé číslo: ");
		a = inputScan.nextInt();
		out.print("Zadaj druhé číslo: ");
		b = inputScan.nextInt();
		out.print("Zadaj tretie číslo: ");
		c = inputScan.nextInt();
		inputScan.close();

		if (a > b) {
			max = a;
		} else {
			max = b;
		}

		if (c > max) {
			max = c;
		}

		out.println("Maximum je: " + max);
		out.println();

		if (a > b) {
			if (a > c) {
				out.println("Maximum je: " + a);
			} else {
				out.println("Maximum je: " + c);
			}

		} else {
			if (b > c) {
				out.println("Maximum je: " + b);
			} else {
				out.println("Maximum je: " + c);
			}
		}
	}
}
