package day3;

import static java.lang.System.out;

import java.util.Scanner;

public class priklad2 {

	public static void main(String[] args) {
		int a, b;
		int max = -1;

		Scanner inputObject = new Scanner(System.in);
		out.print("Zadaj prvé číslo: ");
		a = inputObject.nextInt();
		out.print("Zadaj druhé číslo: ");
		b = inputObject.nextInt();
		inputObject.close();

		//Doplnenie testu na rovnosť čísiel
		if (a != b) {
			if (a > b) {
				max = a;
			} else {
				max = b;
			}
			out.println("Maximum je: " + max);
		} else {
			out.println("Čísla sú rovnaké!");
		}

	}
}
