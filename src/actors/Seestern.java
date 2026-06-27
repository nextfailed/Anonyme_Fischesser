package actors;

public class Seestern extends Meeresbewohner {

    public Seestern(String name, int gramm, Nahrungstyp nahrungstyp, Esstyp esstyp, int maxMagenfuellmenge, boolean istLebendig) {
        super(name, gramm, nahrungstyp, esstyp, maxMagenfuellmenge, istLebendig);
    }

    public Seestern(String name, int gramm, Nahrungstyp nahrungstyp, Esstyp esstyp, int maxMagenfuellmenge) {
        super(name, gramm, nahrungstyp, esstyp, maxMagenfuellmenge);
    }

}
