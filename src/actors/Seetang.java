package actors;

public class Seetang implements Leckerbissen {
    private final String NAME;
    private final int GRAMM;
    private final Nahrungstyp nahrungstyp = Nahrungstyp.PFLANZE;

    public Seetang(String name, int gramm) {
        super();
        this.NAME = name;
        this.GRAMM = gramm;
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
