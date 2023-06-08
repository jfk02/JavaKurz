package day3;

import static java.lang.System.out;
import java.util.Scanner;

public class prikladSwitch {

	public static void main(String[] args) {

		int plat;
		int platovaTrieda;

		Scanner inputScan = new Scanner(System.in);
		out.print("Aký máš plat? ");
		plat = inputScan.nextInt();
		inputScan.close();

		if (plat > 2000) {
			platovaTrieda = 1;
		} else if (plat < 2000 && plat > 1200) {
			platovaTrieda = 2;
		} else if (plat < 1200) {
			platovaTrieda = 3;
		} else {
			platovaTrieda = 999;
		}

		switch (platovaTrieda) {
		case 1:
			out.println("Máš nadpriemerný plat.");
			break;
		case 2:
			out.println("Máš priemerný plat.");
			break;
		case 3:
			out.println("Máš podpriemerný plat.");
			break;
		default:
			out.println("Plat je mimo posudzovaných podmienok.");
		}
	}
}
