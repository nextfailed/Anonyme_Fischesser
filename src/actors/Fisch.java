package actors;

public class Fisch extends Meeresbewohner {

    public Fisch(String name, int gramm, Nahrungstyp nahrungstyp, Esstyp esstyp, int maxMagenfuellmenge, boolean istLebendig) {
        super(name, gramm, nahrungstyp, esstyp, maxMagenfuellmenge, istLebendig);
    }

    public Fisch(String name, int gramm, Nahrungstyp nahrungstyp, Esstyp esstyp, int maxMagenfuellmenge) {
        super(name, gramm, nahrungstyp, esstyp, maxMagenfuellmenge);
    }

}
