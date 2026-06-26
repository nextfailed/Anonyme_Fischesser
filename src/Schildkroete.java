public class Schildkroete extends Meeresbewohner {

    public Schildkroete(String name, int gramm, Nahrungstyp nahrungstyp, Esstyp esstyp, int maxMagenfuellmenge, boolean istLebendig) {
        super(name, gramm, nahrungstyp, esstyp, maxMagenfuellmenge, istLebendig);
    }

    public Schildkroete(String name, int gramm, Nahrungstyp nahrungstyp, Esstyp esstyp, int maxMagenfuellmenge) {
        super(name, gramm, nahrungstyp, esstyp, maxMagenfuellmenge);
    }

}
