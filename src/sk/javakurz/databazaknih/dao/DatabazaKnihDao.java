package sk.javakurz.databazaknih.dao;

import sk.javakurz.databazaknih.base.Dvojica;
import sk.javakurz.databazaknih.models.DatabazaKnihModel;
import sk.javakurz.databazaknih.models.KnihaModel;

import java.util.*;

public interface DatabazaKnihDao {

    DatabazaKnihModel getDatabazaKnihModel();

    void setDatabazaKnihModel(DatabazaKnihModel databazaKnihModel);

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
    List<Dvojica<Integer, KnihaModel>> hladajKnihu(String hladanyText);

    /**
     * Vráti všetky knihy bez indexu zotriedené podľa poradia pridania, najnovšie ako posledné.
     * @return Collection nájdených kníh KnihaModel bez indexu.
     */
    Collection<KnihaModel> getVsetkyKnihyBezIndexu();

    /**
     * Vráti všetky indexy použité v databázi kníh.
     * @return Set všetkých indexov použitých v databázi.
     */
    Set<Integer> getIndexyVDatabazi();
}
