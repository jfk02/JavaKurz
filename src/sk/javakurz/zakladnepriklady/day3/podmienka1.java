package sk.javakurz.zakladnepriklady.day3;

import static java.lang.System.out;
import java.util.Scanner;

public class podmienka1 {

	public static void main(String[] args) {

		Scanner inputObject = new Scanner(System.in);
		out.print("Zadaj číslo: ");
		int a = inputObject.nextInt();
		inputObject.close();

		if (a < 0) {
			a = -a;
		}

		out.println("Absolútna hodnota zadaného čísla je: " + a);
	}
}
