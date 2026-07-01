package actors;

/**
 * Schildkroeten sind Meeresbewohner, besitzen daher einen Magen. 
 * Sie sind von Grund auf als Esstyp als "Fleisch" definiert.
 * Schildkroete
 */
public class Schildkroete extends Meeresbewohner {
    public static final Nahrungstyp DEFAULT_NAHRUNGSTYP = Nahrungstyp.FLEISCH;

    /**
     * @param name Name der Schildkröte
     * @param gramm Gewicht der Schildkröte
     * @param nahrungstyp Nahrungstyp der Schildkröte
     * @param esstyp Esstyp der Schildkröte
     * @param maxMagenfuellmenge Maximale Magenfüllmenge
     */
    public Schildkroete(String name, int gramm, Nahrungstyp nahrungstyp, Esstyp esstyp, int maxMagenfuellmenge) {
        super(name, gramm, nahrungstyp, esstyp, maxMagenfuellmenge);
    }

    /**
     * Ruft den normalen Konstruktor auf, gibt jedoch den Default-Nahrungstypen automatisch dazu.  
     * @param name Name der Schildkröte
     * @param gramm Gewicht der Schildkröte
     * @param esstyp Esstyp der Schildkröte
     * @param maxMagenfuellmenge Maximale Magenfüllmenge
     */
    public Schildkroete(String name, int gramm, Esstyp esstyp, int maxMagenfuellmenge) {
        this(name, gramm, DEFAULT_NAHRUNGSTYP, esstyp, maxMagenfuellmenge);
    }

}
