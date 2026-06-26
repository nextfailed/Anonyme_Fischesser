public class Taucher implements Leckerbissen {
    private final String NAME;
    private final int GRAMM;
    private final Nahrungstyp nahrungstyp = Nahrungstyp.FLEISCH;

    public Taucher(String name, int gramm) {
        super();
        this.NAME = name;
        this.GRAMM = gramm;
    }

    @Override
    public int getGramm() {
        return 0;
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
        return null;
    }
}
