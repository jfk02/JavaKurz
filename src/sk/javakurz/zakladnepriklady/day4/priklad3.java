package sk.javakurz.zakladnepriklady.day4;

import static java.lang.System.out;

import java.util.Scanner;

public class priklad3 {

	public static void main(String[] args) {
		
		int a;
		
		Scanner inputScan = new Scanner(System.in);
		out.print("Zadaj 1. číslo: ");
		a = inputScan.nextInt();
		
		if(a<0) {
			out.println("Cislo je zaporne.");
		} else {
			out.println("Cislo je kladne.");
		}
	}
}
