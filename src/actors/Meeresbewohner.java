package actors;

import java.util.List;

public abstract class Meeresbewohner extends Akteur {
    final int MAX_MAGENFUELLMENGE;
    private final Esstyp esstyp;

    private List<Leckerbissen> magen;

    public Meeresbewohner(String name, int gramm, Nahrungstyp nahrungstyp, Esstyp esstyp, int maxMagenfuellmenge, boolean istLebendig) {
        super(name, gramm, nahrungstyp, istLebendig);
        this.MAX_MAGENFUELLMENGE = maxMagenfuellmenge;
        this.esstyp = esstyp;
    }

    public Meeresbewohner(String name, int gramm, Nahrungstyp nahrungstyp, Esstyp esstyp, int maxMagenfuellmenge) {
        this(name, gramm, nahrungstyp, esstyp, maxMagenfuellmenge, true);
    }

    public Esstyp getEsstyp() {
        return esstyp;
    }

    public void fressen() {

    }
}
