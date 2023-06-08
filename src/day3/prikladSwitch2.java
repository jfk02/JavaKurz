package day3;

import static java.lang.System.out;
import java.util.Scanner;

public class prikladSwitch2 {

	public static void main(String[] args) {

		int day;

		Scanner inputScan = new Scanner(System.in);
		out.print("Zadaj deň: ");
		day = inputScan.nextInt();
		inputScan.close();

		switch (day) {
		case 1:
			out.println("Pondelok");
			break;
		case 2:
			out.println("Utorok");
			break;
		case 3:
			out.println("Streda");
			break;
		case 4:
			out.println("Štvrtok");
			break;
		case 5:
			out.println("Piatok");
			break;
		case 6:
			out.println("Sobota");
			break;
		case 7:
			out.println("Nedeľa");
			break;
		default:
			out.println("Taký deň nie je!");
		}
	}
}
