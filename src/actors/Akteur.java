package actors;

/**
 * Akteure sind Interaktive Lebewesen im Meeresboden Leckerbissen.
 * 
 * 
 */
public abstract class Akteur implements Leckerbissen {
    protected final String NAME;
    protected int GRAMM;

    protected final Nahrungstyp nahrungstyp;

    protected Akteur(String name, int gramm, Nahrungstyp nahrungstyp) {
        this.NAME = name;
        this.GRAMM = gramm;

        this.nahrungstyp = nahrungstyp;
    }


    @Override 
    public String toString(){
        return (this.NAME + " (" + this.GRAMM + "g)" + " | Typ: " + nahrungstyp + " | " + (istLebendig()?"am leben":"tot"));
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
        if(istLebendig()) {
            this.GRAMM = 0;

            return true;
        }

        return false;
    }

    @Override
    public boolean istLebendig() {
        return this.GRAMM == 0;
    }

    @Override
    public Nahrungstyp getNahrungstyp() {
        return nahrungstyp;
    }


    
}
