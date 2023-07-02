package sk.javakurz.databazaknih.dao;

import sk.javakurz.databazaknih.base.Dvojica;
import sk.javakurz.databazaknih.models.DatabazaKnihModel;
import sk.javakurz.databazaknih.models.KnihaModel;

import java.util.*;
import java.util.stream.Collectors;

public class DatabazaKnihDaoImpl implements DatabazaKnihDao {

    private DatabazaKnihModel databazaKnihModel;

    public void setDatabazaKnihModel(DatabazaKnihModel databazaKnihModel) {
        this.databazaKnihModel = databazaKnihModel;
    }

    public DatabazaKnihModel getDatabazaKnihModel() {
        return databazaKnihModel;
    }

    /**
     * Generuje ďalší kľúč do databázy kníh.
     * Ak zistí, že v databáze je voľný kľúč, vráti prvý voľný kľúč v poradí.
     * Ak v databáze nie je voľný kľúč, vygeneruje ďalší nový kľúč v poradí.
     *
     * @return Kľúč do databázy kníh ako Integer.
     */
    private Integer generujDalsiKluc() {
        Integer novyKluc = 0;
        if (databazaKnihModel.getVolneIndexy().isEmpty()) {
            novyKluc = databazaKnihModel.getDatabazaKnih().size() + 1;
        } else {
            novyKluc = databazaKnihModel.getVolneIndexy().pollFirst();
        }
        return novyKluc;
    }

    @Override
    public KnihaModel getKniha(int index) {
        return this.databazaKnihModel.getDatabazaKnih().get(index);
    }

    @Override
    public boolean vymazKnihu(int index) {
        var jeVymazana = this.databazaKnihModel.getDatabazaKnih().remove(index) != null;
        if (jeVymazana) {
            databazaKnihModel.getVolneIndexy().add(index);
        }
        return jeVymazana;
    }

    @Override
    public int pocetKnih() {

        return databazaKnihModel.getDatabazaKnih().size();
    }

    @Override
    public void vymazKniznicu() {

        databazaKnihModel.getDatabazaKnih().clear();
    }

    @Override
    public void pridajKnihu(String nazov, String autor, int rokVydania) {
        var novaKniha = new KnihaModel(nazov, autor, rokVydania);
        databazaKnihModel.getDatabazaKnih().put(generujDalsiKluc(), novaKniha);
    }

    @Override
    public List<Dvojica<Integer, KnihaModel>> hladajKnihu(String hladanyText) {
        return databazaKnihModel.getDatabazaKnih()
                .keySet()
                .stream()
                .map(index -> new Dvojica<Integer, KnihaModel>(index, databazaKnihModel.getDatabazaKnih().get(index)))
                .filter(dvojica -> dvojica.getDruhy().getNazov().contains(hladanyText)
                        || dvojica.getDruhy().getAutor().contains(hladanyText))
                .collect(Collectors.toList());
    }

    @Override
    public Collection<KnihaModel> getVsetkyKnihyBezIndexu() {
        return databazaKnihModel.getDatabazaKnih().values();
    }

    @Override
    public Set<Integer> getIndexyVDatabazi() {
        return databazaKnihModel.getDatabazaKnih().keySet();
    }

    public DatabazaKnihDaoImpl() {
        this.databazaKnihModel = new DatabazaKnihModel();
    }
}
