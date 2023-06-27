package day13.databazaKnih;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DatabazaKnih {

    private ArrayList<Kniha> databazaKnih;

    /**
     * Nájde knihu podľa indexu.
     *
     * @param index Index knihy pre nájdenie.
     * @return Objekt Kniha alebo null ak index neexistuje.
     */
    public Kniha zobrazKnihu(int index) {
        Kniha konkretnaKniha;
        try {
            konkretnaKniha = this.databazaKnih.get(index);
        } catch (IndexOutOfBoundsException e) {
            konkretnaKniha = null;
        }
        return konkretnaKniha;
    }

    /**
     * Vymaže knihu podľa indexu.
     *
     * @param index Index knihy pre vymazanie.
     * @return TRUE ak kniha bola vymazana a FALSE ako index neexistuje.
     */
    public boolean vymazKnihu(int index) {
        boolean bolaVymazana;
        try {
            this.databazaKnih.remove(index);
            bolaVymazana = true;
        } catch (IndexOutOfBoundsException e) {
            bolaVymazana = false;
        }
        return bolaVymazana;
    }

    /**
     * Zistí počet kníh v knižnici.
     *
     * @return Počet kníh.
     */
    public int pocetKnih() {
        return databazaKnih.size();
    }

    /**
     * Vymaže všetky knihy v knižnici.
     */
    public void vymazVsetkyKnihy() {
        databazaKnih = new ArrayList<>();
    }

    /**
     * Pridá knihu do databázi.
     *
     * @param novaKniha Objekt Kniha pre pridanie do databázi.
     * @return TRUE ak kniha bola pridana a FALSE ak nebola.
     */
    public boolean pridajNovuKnihu(Kniha novaKniha) {
        boolean knihaPridana;
        if (novaKniha != null) {
            databazaKnih.add(novaKniha);
            knihaPridana = true;
        } else {
            knihaPridana = false;
        }
        return knihaPridana;
    }

    /**
     * Vyhľadá knihu v databázi podľa hladaného textu v názve alebo autorovi knihy.
     *
     * @param hladanyText Hľadaný text.
     * @return List nájdených kníh alebo null.
     */
    public List<Kniha> hladajKnihu(String hladanyText) {
        return databazaKnih
                .stream()
                .filter(kniha -> kniha.getNazov().contains(hladanyText)
                        || kniha.getAutor().contains(hladanyText))
                .collect(Collectors.toList());
    }

    public DatabazaKnih() {
        this.databazaKnih = new ArrayList<>();
    }
}