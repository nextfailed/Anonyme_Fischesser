package actors;

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
     * Der Default-Wert wird mitgegbeen, falls nichts mitgegeben wurde.
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
    protected Nahrungstyp setNahrungstyp(){
        return ALLGEMEINER_NAHRUNGSTYP;
    };

    @Override
    public String getDefaultName() {
        return DEFAULT_NAME;
    }
}
