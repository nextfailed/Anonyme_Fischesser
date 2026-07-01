package actors;

/**
 * Schablone fuer jeden Leckerbissen.
 * Lebewesen koennen ebenfalls Leckerbissen sein.
 * Leckerbissen
 */
public interface Leckerbissen {
    /**
     * Gibt den Namen des Leckerbissens zurueck.
     * @return Name des Leckerbissens
     */
    String getName();

    /**
     * Gibt das Gewicht des Leckerbissens zurueck.
     * @return Gewicht
     */
    int getGramm();

    /**
     * Gibt zurueck, ob der Leckerbissen gefressen wurde oder nicht.
     * Gibt immer false zurueck, falls der Leckerbissen nicht mehr lebt.
     * @return Wahr oder falsch
     */
    boolean gefressen();

    /**
     * Gibt zurueck, ob der Leckerbissen noch lebendig ist.
     * Wird nach der Zunahme auf false gesetzt.
     * @return Wahr oder falsch
     */
    boolean istLebendig();

    /**
     * Gibt zurueck, von welchem Nahrungstypen der Leckerbissen ist.
     * @return Nahrungstyp
     */
    Nahrungstyp getNahrungstyp();
}
