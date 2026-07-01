package actors;

/**
 * Akteure sind interaktive Lebewesen im Meeresboden und ebenfalls Leckerbissen.
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

    /**
     * Gibt den Namen und das Gewicht des Akteurs aus, sowie der Nahrungstyp und ob das Lebewesen noch am Leben ist.
     * @return Name und Statistik des Akteurs.
     */
    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.NAME);
        stringBuilder.append(": ").append((istLebendig()?"lebendig":"tot"));
        stringBuilder.append(" | (").append(this.GRAMM).append(" g)");
        stringBuilder.append(" | Nahrungstyp: ").append(nahrungstyp);
        return stringBuilder.toString();
    }

    /**
     * @return Name des Akteurs
     */
    public String getName() {
        return NAME;
    }

    /**
     * @return Gewicht des Akteurs
     */
    @Override
    public int getGramm() {
        return GRAMM;
    }

    /**
     * Gibt zurueck, ob der Akteur gefressen werden kann.
     * Wenn er noch lebendig ist, wird er gefressen, sein gewicht wird auf 0 gesetzt und es wird true zurueckgegeben.
     *
     * @return ob der Akteur gefressen werden kann
     */
    @Override
    public boolean gefressen() {
        if(istLebendig()) {
            this.GRAMM = 0;

            return true;
        }

        return false;
    }

    /**
     * Gibt true zurueck, wenn das Gewicht mindestens groesser als 0 ist.
     * Falls der Akteur gefressen wird, wird das Gewicht auf 0 gesetzt und die Methode gibt ab sofort false zurueck.
     * @return ist noch am Leben
     */
    @Override
    public boolean istLebendig() {
        return this.GRAMM > 0;
    }

    /**
     * @return Nahrungstyp des Akteurs.
     */
    @Override
    public Nahrungstyp getNahrungstyp() {
        return nahrungstyp;
    }


    
}
