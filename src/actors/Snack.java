package actors;

/**
 * Snacks sind Simple Leckerbissen, wie Seetang und Muell. Sie sind keine Akteure, da sie nicht aktiv am geschehen im Meer beteiligt sind und existieren lediglich, koennen jedoch gefressen werden.
 * Sie besitzen lediglich ihren Grammwert und einen oberbegrifflichen Namen, wie zum Beispiel "Seetang", sowie eine dazugehoerige ID als "Identifier".
 * 
 * Ihr Nahrungstyp sollte von den Kingerklassen einzeln definiert werden, damit sich Beispielsweise der  Nahrungstyp sich in der eignenen Klasse unterscheiden kann.
 * Er ist daher fest in der Klasse selbst definitiert.
 */
public abstract class Snack implements Leckerbissen {
    protected int gramm;
    protected final Nahrungstyp nahrungstyp;

    protected int ID;
    
    /*
     * protected boolean istLebendig; 
     * => vorheriger Ansatz: unnoetig, da das gewicht jedes Objektes beim gefressen werden auf 0 gesetzt wird. Nachteil: Kein Objekt kann mit 0 Gramm leben.
    */

    /**
     * Der Nahrungstyp wird durch die abstrakte setNahrungstyp()-Methode innerhalb des Konstruktors definiert
     * @param gramm Gewicht
     */
    public Snack(int gramm) {
        this.ID = getCurrentID();

        this.gramm = gramm;
        this.nahrungstyp = setNahrungstyp();
    }

    /**
     * Da jeder Snack den selben Namen hat, kann dieser ueber die ID identifiziert werden.
     * @return ID des Snacks
     */
    public int getID(){
        return this.ID;
    }

    /**
     * Unterklassen muessen diese Methode protected implementieren.
     * Diese Methode existiert, damit der Nahrungstyp sich nicht jedes Objekt der oberen Klasse sich vom Typen unterscheiden kann.
     * @return den Gesetzten Nahrungstyp (Bsp: Muell -> Nicht Essbar)
     */
    protected abstract Nahrungstyp setNahrungstyp();

    /**
     * Muss in den Unterklassen initialisiert werden.
     * Gibt die momentanige ID zurueck und erhoeht diese um 1.
     * Da die ID ueber die Unterklassen einzeln initialisiert werden, werden diese unabhaengig von den anderen Klassen erstellt.
     * @return momentane ID, wird an getName() angehaengt
     */
    protected abstract int getCurrentID();

    @Override
    /**
     * Gibt den ueberbegrifflichen Namen zurueck, sowie ob das simple Lebewesen noch lebt oder nicht.
     * @return Ausgabe des Einfachen Leckerbissens
     */
    public String toString(){
        return this.getName() + " " + (istLebendig()?"(lebendig)":"(tot)");
    }

    /** 
     * Gibt den ueberbegrifflichen Default-Namen wie "Seetang" zurueck.
     * Ist abstrakt und muss in Kind-Klassen definiert werden.
    */
    public abstract String getDefaultName();

    /**
     * Muss durch das Leckerbissen-Interface initialisiert werden.
     * Ruft automatisch die getDefaultName() auf und fuegt die ID des Snacks hinzu.
     * @return Ueberbegriffs-Name
     */
    public String getName() {
        return getDefaultName() + " #" + this.ID;
    }

    /**
     * Gibt das Gewicht des Leckerbissens zurueck. Wird auf 0 gesetzt, wenn der Snack gefressen wurde.
     * @return Gewicht des Leckerbissens
     */
    @Override
    public int getGramm() {
        return gramm;
    }

    @Override
    /**
     * Gibt zurueck, ob das Objekt gefressen wurde. Wenn es nichtmehr lebt, kann es nicht gefressen werden.
     * Die Gramm-Anzahl wird auf 0 gesetzt, wenn es gefressen wurde.
     */
    public boolean gefressen() {
        if(istLebendig()) {
            this.gramm = 0;

            return true;
        }

        return false;
    }


    @Override
    /**
     * Gibt zurueck, ob das Lebewesen noch am Leben ist. Da jedes tote Lebewesen ueber Gramm = 0 gesteuert wird,
     * wird zurueckgegeben, ob der Leckerbissen ein Gewicht von 0 hat.
     * 
     * Nachteil: Es koennen keine lebendigen Lebewesen mit einem Gewicht von 0 erzeugt werden, sie waehren also direkt tot.
     * @return ob es noch am Leben ist
     */
    public boolean istLebendig() {
        return gramm > 0;
    }

    @Override
    /**
     * Gibt den Nahrungstyp des jeweiligen Objektes aus.
     * @return nahrungstyp
     */
    public Nahrungstyp getNahrungstyp() {
        return nahrungstyp;
    }
}
