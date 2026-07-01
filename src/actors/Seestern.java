package actors;

/**
 * Seesterne sind Meeresbewohner.
 * Seestern
 */
public class Seestern extends Meeresbewohner {

    /**
     * @param name Name des Seesterns
     * @param gramm Gewicht des Seesterns
     * @param nahrungstyp Nahrungstyp des Seesterns
     * @param esstyp Esstyp des Seesterns
     * @param maxMagenfuellmenge Maximale Magenfüllmenge des Seesterns
     */
    public Seestern(String name, int gramm, Nahrungstyp nahrungstyp, Esstyp esstyp, int maxMagenfuellmenge) {
        super(name, gramm, nahrungstyp, esstyp, maxMagenfuellmenge);
    }


}
