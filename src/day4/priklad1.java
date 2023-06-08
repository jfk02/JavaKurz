package day4;

import static java.lang.System.out;

public class priklad1 {

	public static void main(String[] args) {

		int a = (int) Math.floor(Math.random() * 51);
		int b = (int) Math.floor(Math.random() * 51);
		int max = 0;
		
		if (a > b) {
			max = a;
		} else {
			max = b;
		}

		out.println("Prve cislo je: " + a);
		out.println("Druhe cislo je: " + b);
		out.println("Vacsie je: " + max);
	}
}
