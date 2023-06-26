package day12.Auta;

public class Auto {
    private String znacka;
    private String farba;
    private String typ;

    public String getZnacka() {
        return znacka;
    }

    public void setZnacka(String znacka) {
        this.znacka = znacka;
    }

    public String getFarba() {
        return farba;
    }

    public void setFarba(String farba) {
        this.farba = farba;
    }

    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }

    public Auto(String znacka, String farba, String typ) {
        this.znacka = znacka;
        this.farba = farba;
        this.typ = typ;
    }

    public Auto(String znacka) {
        this.znacka = znacka;
        this.farba = "biela";
        this.typ = "";
    }
}
