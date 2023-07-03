package sk.javakurz.zakladnepriklady.day4;

import static java.lang.System.out;

public class priklad14 {


    public static void main(String[] args) {

        /*
        int n = 0;
        try (Scanner inputScan = new Scanner(System.in)) {

            out.print("Zadaj cislo: ");
            n = inputScan.nextInt();

        }
*/
        dojazd(50, 5.5);
    }
    
    
    static void calculator(int prveCislo, int druheCislo, String operacia) {

        switch (operacia) {
        case "+":
            out.println(prveCislo + " + " + druheCislo + " = " + (prveCislo + druheCislo));
            break;
        case "-":
            out.println(prveCislo + " - " + druheCislo + " = " + (prveCislo - druheCislo));
            break;
        case "*":
            out.println(prveCislo + " * " + druheCislo + " = " + (prveCislo * druheCislo));
            break;
        case "/":
            out.println(prveCislo + " : " + druheCislo + " = " + (prveCislo / druheCislo));
            break;
        default:
            out.println("Taku operaciu nemozem vykonat!");
        }
    }
    
    static void vypocetDPH(double cena) {
        out.println("Cena s DPH je "+(cena*1.2));
    }
    
    static void dojazd(double fuelAmmount, double consumption) {
        out.println("Dojazd automobilu je "+((fuelAmmount/consumption)*100)+" km.");
    }

}
