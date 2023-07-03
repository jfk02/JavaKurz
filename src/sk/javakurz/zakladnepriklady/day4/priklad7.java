package sk.javakurz.zakladnepriklady.day4;

import static java.lang.System.out;

import java.util.Scanner;

public class priklad7 {

	public static void main(String[] args) {

		String meno = "";

		try (Scanner inputScan = new Scanner(System.in)) {
			out.print("Zadaj meno: ");
			meno = inputScan.nextLine();
		}
		
		out.println("Ahoj " + meno);
	}

}
