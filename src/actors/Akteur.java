package actors;

public abstract class Akteur implements Leckerbissen {
    private final String NAME;
    private final int GRAMM;
    private final Nahrungstyp nahrungstyp;
    private boolean istLebendig;

    protected Akteur(String name, int gramm, Nahrungstyp nahrungstyp, boolean istLebendig) {
        super();
        this.NAME = name;
        this.GRAMM = gramm;
        this.istLebendig = istLebendig;
        this.nahrungstyp = nahrungstyp;
    }

    public Akteur(String name, int gramm, Nahrungstyp nahrungstyp) {
        this(name, gramm, nahrungstyp, true);
    }

    public String getName() {
        return NAME;
    }

    @Override
    public int getGramm() {
        return GRAMM;
    }

    @Override
    public boolean gefressen() { //TODO
        return false;
    }

    @Override
    public boolean istLebendig() {
        return istLebendig;
    }

    @Override
    public Nahrungstyp getNahrungstyp() {
        return nahrungstyp;
    }
}
