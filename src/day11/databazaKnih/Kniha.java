package day11.databazaKnih;

/**
 * Model Knihy
 */
public class Kniha {
    private String autor;
    private String nazov;
    private int rokVydania;
    private String zaner;

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getNazov() {
        return nazov;
    }

    public void setNazov(String nazov) {
        this.nazov = nazov;
    }

    public int getRokVydania() {
        return rokVydania;
    }

    public void setRokVydania(int rokVydania) {
        this.rokVydania = rokVydania;
    }

    public String getZaner() {
        return zaner;
    }

    public void setZaner(String zaner) {
        this.zaner = zaner;
    }

    public String getVydavatelstvo() {
        return vydavatelstvo;
    }

    public void setVydavatelstvo(String vydavatelstvo) {
        this.vydavatelstvo = vydavatelstvo;
    }

    private String vydavatelstvo;

    public Kniha(String autor, String nazov, int rokVydania, String zaner, String vydavatelstvo) {
        this.autor = autor;
        this.nazov = nazov;
        this.rokVydania = rokVydania;
        this.zaner = zaner;
        this.vydavatelstvo = vydavatelstvo;
    }

    public Kniha(String nazov) {
        this.nazov = nazov;
    }
}
