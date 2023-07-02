package sk.javakurz.databazaknih.services;

import sk.javakurz.databazaknih.dao.DatabazaKnihDao;

public interface MenuService {
    /**
     * Vstup užívateľa z konzoly.
     *
     * @param vyzva Výzva - prompt pre užívateľa.
     * @return Vstup užívateľa ako String.
     */
    String vstup(String vyzva);

    /**
     * Vytvorí novú knihu zo vstupu užívateľa.
     *
     * @return Nová Kniha.
     */
    void novaKniha();

    /**
     * Vypíše všetky knihy v databáze na konzolu.
     *
     * @param databazaKnihDao Používaná databáza kníh.
     */
    void zobrazVsetkyKnihy();

    /**
     * Zobrazí jednu knihu na konzole.
     *
     * @param databazaKnihDao Používaná databáza kníh.
     */
    void zobrazKnihu();

    /**
     * Vymaže konkrétnu knihu.
     *
     * @param databazaKnihDao Používaná databáza kníh.
     */
    void vymazKnihu();

    /**
     * Vymaže celú knižnicu po odpovedi na otázku "Skutočne vymazať celú knižnicu?(Nie/ÁNO): "
     *
     * @param databazaKnihDao Používaná databáza kníh.
     */
    void vymazKniznicu();

    /**
     * Vyhľadá knihu v databáze na základe zadaného textu.
     *
     * @param databazaKnihDao Používaná databáza kníh.
     */
    void hladajKnihu();

    /**
     * Vypíše počet kníh v databáze na konzolu.
     *
     * @param databazaKnihDao
     */
    void vypisPocetKnih();
}
