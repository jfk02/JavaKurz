package day11.databazaKnih;

/**
 * Model Knihy
 */
public class Kniha {
    private String autor;
    private String nazov;
    private String rokVydania;
    private String zaner;

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor.trim();
    }

    public String getNazov() {
        return nazov;
    }

    public void setNazov(String nazov) {
        this.nazov = nazov.trim();
    }

    public String getRokVydania() {
        return rokVydania;
    }

    public void setRokVydania(String rokVydania) {
        this.rokVydania = rokVydania.trim();
    }

    public String getZaner() {
        return zaner;
    }

    public void setZaner(String zaner) {
        this.zaner = zaner.trim();
    }

    public String getVydavatelstvo() {
        return vydavatelstvo;
    }

    public void setVydavatelstvo(String vydavatelstvo) {
        this.vydavatelstvo = vydavatelstvo.trim();
    }

    private String vydavatelstvo;

    public Kniha(String autor, String nazov, String rokVydania, String zaner, String vydavatelstvo) {
        this.autor = autor;
        this.nazov = nazov;
        this.rokVydania = rokVydania;
        this.zaner = zaner;
        this.vydavatelstvo = vydavatelstvo;
    }

    public Kniha(String nazov) {
        this.nazov = nazov.trim();
    }
}
