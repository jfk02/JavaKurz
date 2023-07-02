package sk.javakurz.databazaknih.models;

import day11.databazaKnih.Kniha;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.LinkedList;

public class DatabazaKnihModel implements Serializable {

    public LinkedHashMap<Integer, KnihaModel> getDatabazaKnih() {
        return databazaKnih;
    }

    public void setDatabazaKnih(LinkedHashMap<Integer, KnihaModel> databazaKnih) {
        this.databazaKnih = databazaKnih;
    }

    public LinkedList<Integer> getVolneIndexy() {
        return volneIndexy;
    }

    public void setVolneIndexy(LinkedList<Integer> volneIndexy) {
        this.volneIndexy = volneIndexy;
    }

    /**
     * Úložisko pre databázu kníh.
     */
    private LinkedHashMap<Integer, KnihaModel> databazaKnih;

    /**
     * Tu sa ukladajú voľné indexy v databáze po vymazaní.
     */
    private LinkedList<Integer> volneIndexy;

    public DatabazaKnihModel() {
        this.databazaKnih = new LinkedHashMap<Integer, KnihaModel>();
        this.volneIndexy = new LinkedList<Integer>();
    }
}
