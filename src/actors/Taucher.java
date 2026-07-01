package actors;

/**
 * Erweiterung des Akteurs, agiert im Meer, kann jedoch nichts verspeisen.
 * Taucher
 */
public class Taucher extends Akteur {

    /**
     * 
     * @param name Name des Tauchers
     * @param gramm Gewicht
     */
    public Taucher(String name, int gramm) {
        super(name, gramm, Nahrungstyp.FLEISCH);
    }

}
