package actors;

/**
 * Akteure sind Interaktive Lebewesen im Meeresboden und ebenfalls Leckerbissen.
 * Sie besitzen vorerst keinen Magen, anders als ihre Kindklasse "Meeresbewohner", die aktiv Dinge fressen koennen.
 */
public abstract class Akteur implements Leckerbissen {
    protected final String NAME;
    protected int GRAMM;

    protected final Nahrungstyp nahrungstyp;

    /**
     * 
     * @param name Name des Akteurs
     * @param gramm Gewicht des Akteurs
     * @param nahrungstyp Nahrungstyp des Akteurs
     */
    protected Akteur(String name, int gramm, Nahrungstyp nahrungstyp) {
        this.NAME = name;
        this.GRAMM = gramm;

        this.nahrungstyp = nahrungstyp;
    }


    @Override 
    /**
     * Gibt den Namen und das Gewicht des Akteurs aus, sowie der Nahrungstyp und ob das Lebewesen noch am Leben ist.
     * @return Name und Statistik des Akteurs.
     */
    public String toString(){
        return (this.NAME + " (" + this.GRAMM + "g)" + " | Typ: " + nahrungstyp + " | " + (istLebendig()?"am leben":"tot"));
    }

    /**
     * @return Name der Instanz
     */
    public String getName() {
        return NAME;
    }

    @Override
    /**
     * @return Gewicht
     */
    public int getGramm() {
        return GRAMM;
    }

    @Override
    /**
     * Gibt zurueck, ob der Akteur gefressen werden kann.
     * Wenn er er noch lebendig ist, wird er gefressen, sein gewicht wird auf 0 gesetzt und es wird true zurueckgegeben.
     *  
     * @return ob der Akteur gefressen werden kann
     */ 
    public boolean gefressen() {
        if(istLebendig()) {
            this.GRAMM = 0;

            return true;
        }

        return false;
    }

    @Override
    /**
     * Gibt true zurueck, wenn das Gewicht mindestens groesser als 0 ist.
     * Falls der Akteur gefressen wird, wird das Gewicht auf 0 gesetzt und die Methode gibt ab sofort false zurueck.
     * @return ist noch am Leben
     */
    public boolean istLebendig() {
        return this.GRAMM > 0;
    }

    @Override
    /**
     * @return Nahrungstyp des Akteurs.
     */
    public Nahrungstyp getNahrungstyp() {
        return nahrungstyp;
    }


    
}
