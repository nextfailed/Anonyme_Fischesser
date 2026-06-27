package actors;

public abstract class SimplerLeckerbissen implements Leckerbissen {
    protected final String NAME;
    protected final int GRAMM;
    protected final Nahrungstyp nahrungstyp;

    public SimplerLeckerbissen(String name, int gramm, Nahrungstyp nahrungstyp) {
        super();
        this.NAME = name;
        this.GRAMM = gramm;
        this.nahrungstyp = nahrungstyp;
    }

    public String getName() {
        return NAME;
    }

    @Override
    public int getGramm() {
        return GRAMM;
    }

    @Override
    public boolean gefressen() {
        return false;
    }

    @Override
    public boolean istLebendig() {
        return false;
    }

    @Override
    public Nahrungstyp getNahrungstyp() {
        return nahrungstyp;
    }
}
