package actors;

/**
 * Muell ist vom Typ 'Snack', ungeniessbar und kann nicht von Fischen verdaut werden.
 * Muell ist automatisch nicht lebendig und gibt bei dem Aufruf der istLebendig() immer false zurueck.
 * Muell
 */
public class Muell extends Snack {
    public static final String DEFAULT_NAME = "Muell";
    public static final Nahrungstyp ALLGEMEINER_NAHRUNGSTYP = Nahrungstyp.NICHT_ESSBAR;
    public static final int DEFAULT_GRAMM = 8;

    /* 
    public Muell(String name, int gramm){
        super(gramm, ALLGEMEINER_NAHRUNGSTYP);
        this.istLebendig = false;
    }
    */

    /**
     * Der Name jedes Muells ist bereits vordefiniert.
     * @param gramm Gewicht in Gramm
     */
    public Muell(int gramm){
        super(gramm);
    }

    /**
     * Der Default-Wert wird mitgegeben, falls nichts mitgegeben wurde.
     */
    public Muell() {
        this(DEFAULT_GRAMM);
    }

    /**
     * Wird ueberschrieben, da Muell nicht lebendig sein kann, aber eine Gramm-Anzahl besitzt.
     * @return immer false.
     */
    @Override
    public boolean istLebendig(){
        return false;
    }

    @Override
    /**
     * Gibt den allgemeinen Nahrungstypen zurueck, damit dieser im Super-Konstruktor fuer jede Instanz gesetzt wurde.
     * @return Default-Nahrungstyp
     */
    protected Nahrungstyp setNahrungstyp(){
        return ALLGEMEINER_NAHRUNGSTYP;
    };

    @Override
    /**
     * Gibt den Default-Namen jeder Muell-Instanz zurueck.
     * @return Default-Namen 'Muell'
     */
    public String getDefaultName() {
        return DEFAULT_NAME;
    }
}
