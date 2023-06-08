package day2;
import static java.lang.System.out;

public class priklad10 {	


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int a = (int) (Math.random() * 10)+1;
		int b =  (int) (Math.random() * 10)+1;
			
		int m = Math.max(a, b);

		out.println("Nahodne cisla su: " + a + ", " + b + " a vacsie je " + m);
	}
}