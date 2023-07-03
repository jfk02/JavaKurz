package sk.javakurz.databazaknih.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class DatabazaKnih implements Serializable {

    private final ArrayList<Kniha> databazaKnih;

    private final ArrayList<Autor> databazaAutorov;

    public ArrayList<Kniha> getDatabazaKnih() {
        return databazaKnih;
    }

    public ArrayList<Autor> getDatabazaAutorov() {
        return databazaAutorov;
    }

    public DatabazaKnih() {
        this.databazaKnih = new ArrayList<>();
        this.databazaAutorov = new ArrayList<>();
    }
}
