package sk.javakurz.zakladnepriklady.day2;
import static java.lang.System.out;

public class priklad8 {

	public static void main(String[] args) {

		int number = 235588;

		for (int i = 10; i < 100000; i *= 10) {
			out.println(i + " : Podiel je " + (number / i) + " a modulo je " + (number % i));
		}
	}
}
