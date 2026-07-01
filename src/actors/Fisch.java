package actors;

/**
 * Fische sind Kind-Klassen von Meeresbewohner.
 * Sie unterscheiden sich genzlig nicht von Meeresbewohner, der Nahrungstyp wird jedoch automatisch auf Fisch gesetzt.
 * Fisch
 */
public class Fisch extends Meeresbewohner {
    public static final Nahrungstyp DEFAULT_NAHRUNGSTYP = Nahrungstyp.FISCH;

    /**
     * Der Nahrungstyp wird automatisch als "Fisch" deklariert und dem Super-Konstruktor uebergeben.
     * @param name Name des Fisches
     * @param gramm Gewicht des Fisches
     * @param esstyp
     * @param maxMagenfuellmenge
     */
    public Fisch(String name, int gramm, Esstyp esstyp, int maxMagenfuellmenge) {
        super(name, gramm, DEFAULT_NAHRUNGSTYP, esstyp, maxMagenfuellmenge);
    }

}
