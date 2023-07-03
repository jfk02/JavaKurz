package sk.javakurz.zakladnepriklady.tmconsulting;

import sk.javakurz.zakladnepriklady.tmconsulting.anglicky.Hello;
import sk.javakurz.zakladnepriklady.tmconsulting.madarsky.Szia;
import sk.javakurz.zakladnepriklady.tmconsulting.nemecky.Hallo;
import sk.javakurz.zakladnepriklady.tmconsulting.slovensky.Ahoj;

public class VsetkyPozdravy {
    public static void main(String[] args) {
        Ahoj.pozdravujem();
        Szia.pozdravujem();
        Hallo.pozdravujem();
        Hello.pozdravujem();
    }
}
