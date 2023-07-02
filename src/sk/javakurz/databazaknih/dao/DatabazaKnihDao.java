package sk.javakurz.databazaknih.dao;

import sk.javakurz.databazaknih.base.Pair;
import sk.javakurz.databazaknih.models.DatabazaKnihModel;
import sk.javakurz.databazaknih.models.KnihaModel;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public interface DatabazaKnihDao {
    DatabazaKnihModel getDatabazaKnihModel();

    /**
     * Nájde knihu podľa indexu.
     *
     * @param index Index knihy pre nájdenie.
     * @return Objekt Kniha alebo null ak index neexistuje.
     */
    KnihaModel getKniha(int index);

    /**
     * Vymaže knihu podľa indexu.
     *
     * @param index Index knihy pre vymazanie.
     * @return TRUE ak kniha bola vymazana a FALSE ako index neexistuje.
     */
    boolean vymazKnihu(int index);

    /**
     * Zistí počet kníh v knižnici.
     *
     * @return Počet kníh.
     */
    int pocetKnih();

    /**
     * Vymaže všetky knihy v knižnici.
     */
    void vymazKniznicu();

    /**
     * Pridá knihu do databáze.
     * @param nazov Názov knihy.
     * @param autor Autor knihy.
     * @param rokVydania Rok vydania knihy.
     */
    void pridajKnihu(String nazov, String autor, int rokVydania);

    /**
     * Vyhľadá knihu v databáze podľa hladaného textu v názve alebo autorovi knihy.
     *
     * @param hladanyText Hľadaný text.
     * @return List nájdených kníh alebo null.
     */
    List<Pair<Integer, KnihaModel>> hladajKnihu(String hladanyText);
}
