package sk.javakurz.zakladnepriklady.day3;

import static java.lang.System.out;

public class prikladFor2 {

	public static void main(String[] args) {

		String t = "*";

		for (int i = 0; i < 3; i++) {
			out.println(t);
			t = t + " *";
		}

	}

}
