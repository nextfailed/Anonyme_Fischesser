package actors;

/**
 * Gibt ein, von welcher Lebensmittel-Gattung das jeweilige Element ist. 
 * Nahrungstyp
 */
public enum Nahrungstyp {
    PFLANZE("Pflanze"),
    FISCH("Fisch"),
    FLEISCH("Fleisch"),
    NICHT_ESSBAR("nicht essbar");

    final String TYPNAME;

    /**
     * 
     * @param typname Gattungsname
     */
    Nahrungstyp(String typname) {
        this.TYPNAME = typname;
    }
}
