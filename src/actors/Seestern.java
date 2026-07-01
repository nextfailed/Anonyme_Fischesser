package actors;

/**
 * Seesterne sind Meeresbewohner.
 * Seestern
 */
public class Seestern extends Meeresbewohner {

    /**
     * 
     * @param name
     * @param gramm
     * @param nahrungstyp
     * @param esstyp
     * @param maxMagenfuellmenge
     */
    public Seestern(String name, int gramm, Nahrungstyp nahrungstyp, Esstyp esstyp, int maxMagenfuellmenge) {
        super(name, gramm, nahrungstyp, esstyp, maxMagenfuellmenge);
    }


}
