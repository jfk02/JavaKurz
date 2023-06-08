package day3;

import static java.lang.System.out;

public class prikladPyramidka {

	public static void main(String[] args) {

		String t = "*";
		String s = " ";
		String o = "";

		for (int i = 0; i < 3; i++) {
			o = s.repeat(2 - i).concat(t);
			out.println(o);
			t += "**";
		}

	}

}
