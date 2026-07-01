package actors;

/**
 * Seetang ist ein simpler Leckerbissen, jede Instanz wird also automatisch als 'Pflanze' deklariert, hat lediglich 'Seetang' als Name und ohne Grammzugabe eine Gramm-Anzahl von 2 Gramm.
 * Seetang
 */
public class Seetang extends Snack{
    public static final String DEFAULT_NAME = "Seetang";
    public static final Nahrungstyp ALLGEMEINER_NAHRUNGSTYP = Nahrungstyp.PFLANZE;
    public static final int DEFAULT_GRAMM = 2;

    protected static int ID_Counter = 0;

    /**
     * Das Gewicht ist das einzige, was sich zwischen den Seetang-Instanzen unterscheiden kann.
     * @param gramm Gewicht
     */
    public Seetang(int gramm){
        super(gramm);
    }

    /**
     * Ohne Eingabe wird der Konstruktor mit dem Default-Wert fuer das Gewicht aufgerufen.
     */
    public Seetang(){
        this(DEFAULT_GRAMM);
    }


    /**
     * Gibt den Default-Namen als Namen zurueck, hier den Namen "Seetang"
     * @return Default-Name
     */
    @Override
    public String getDefaultName() {
        return DEFAULT_NAME;
    }

    /**
     * Gibt den allgemeinen, festgelegten Nahrungstypen zurueck, damit dieser im Super-Konstruktor fuer jedes
     * Element festgelegt werden kann 
     * @return Nahrungstyp
     */
    @Override
    protected Nahrungstyp setNahrungstyp() {
        return ALLGEMEINER_NAHRUNGSTYP;
    }

    /**
     * Gibt jeder Seetang-Instanz ihre eigene ID zum Identifizieren.
     * @return ID des erstellten Snacks
     */
    @Override
    protected int getCurrentID() {
        return ID_Counter++;
    }
}
