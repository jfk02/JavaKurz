package sk.javakurz.zakladnepriklady.day4;

import static java.lang.System.out;

public class priklad5 {

	public static void main(String[] args) {

		int znamka = 3;

		char slovnaZnamka = 'A';

		switch (znamka) {
		case 1: {
			slovnaZnamka = 'A';
			break;
		}
		case 2: {
			slovnaZnamka = 'B';
			break;
		}
		case 3: {
			slovnaZnamka = 'C';
			break;
		}
		case 4: {
			slovnaZnamka = 'D';
			break;
		}
		case 5: {
			slovnaZnamka = 'F';
			break;
		}
		default:
			out.println("Taka znamka nie je!");
		}

		out.println("Tvoj brat ma: " + slovnaZnamka);

	}

}
