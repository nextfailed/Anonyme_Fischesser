public class Taucher extends Akteur {

    public Taucher(String name, int gramm, boolean istLebendig) {
        super(name, gramm, Nahrungstyp.FLEISCH, istLebendig);
    }

    public Taucher(String name, int gramm) {
        super(name, gramm, Nahrungstyp.FLEISCH, true);
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
