package sk.javakurz.zakladnepriklady.day2;
import static java.lang.System.out;
import java.util.Scanner;

public class HW01 {

	public static void main(String[] args) {

		double myPi = 3.1415926;
		Scanner inputObject = new Scanner(System.in);
		out.print("Zadaj polomer kruhu: ");
		int r = inputObject.nextInt();
		inputObject.close();	
		
		double area = myPi*r*r;
		out.println("Obsah kruhu je: " + area);
		
		double circumference = 2*myPi*r;
		out.println("Obvod kruhu je: " + circumference);
	}

}
