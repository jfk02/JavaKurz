package sk.javakurz.databazaknih.models;

import java.io.Serializable;

public class Autor implements Serializable {
    private final Integer id;

    public Integer getId() {
        return id;
    }

    private String meno;

    public String getMeno() {
        return meno;
    }

    public void setMeno(String meno) {
        this.meno = meno;
    }

    public Autor(String meno, int id) {
        this.id = id;
        this.meno = meno;
    }
}
