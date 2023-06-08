package day4;

import static java.lang.System.out;

public class priklad6 {

    public static void main(String[] args) {

	int mesiac = 5;
	int pocetDniMesiaca = 30;

	String mesiaceString = "januar februar marec april maj jun jul august september oktober december";

	String nazovMesiaca = "";

	switch (mesiac) {
	case 1:
	    nazovMesiaca = "januar";
	    pocetDniMesiaca = 31;
	    break;
	case 2:
	    nazovMesiaca = "februar";
	    pocetDniMesiaca = 28;
	    break;
	case 3:
	    nazovMesiaca = "marec";
	    pocetDniMesiaca = 30;
	    break;
	case 4:
	    nazovMesiaca = "april";
	    pocetDniMesiaca = 30;
	    break;
	case 5:
	    nazovMesiaca = "maj";
	    pocetDniMesiaca = 31;
	    break;
	case 6:
	    nazovMesiaca = "jun";
	    pocetDniMesiaca = 30;
	    break;
	case 7:
	    nazovMesiaca = "jul";
	    pocetDniMesiaca = 31;
	    break;
	case 8:
	    nazovMesiaca = "august";
	    pocetDniMesiaca = 31;
	    break;
	case 9:
	    nazovMesiaca = "september";
	    pocetDniMesiaca = 30;
	    break;
	case 10:
	    nazovMesiaca = "oktober";
	    pocetDniMesiaca = 31;
	    break;
	case 11:
	    nazovMesiaca = "november";
	    pocetDniMesiaca = 30;
	    break;
	case 12:
	    nazovMesiaca = "december";
	    pocetDniMesiaca = 31;
	    break;
	default:
	    break;
	}

	out.println(mesiac + ". mesiac " + nazovMesiaca + " ma " + pocetDniMesiaca + " dni.");
    }
}
