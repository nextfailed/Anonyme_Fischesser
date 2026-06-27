package actors;

/**
 * Simple Leckerbissen sind Leckerbissen, wie Seetang und Muell. Sie sind keine Akteure, da sie nicht aktiv am geschehen beteiligt sind.
 * Sie besitzen lediglich ihren Grammwert und keinen direkten Namen, sondern lediglich ihren Hauptueberbegriffsnamen, wie zum Beispiel "Seetang".
 * Ihr Nahrungstyp sollte von der Oberklasse definiert werden, damit Beispielsweise nicht der Nahrungstyp sich unterscheiden kann.
 */
public abstract class SimplerLeckerbissen implements Leckerbissen {
    protected int gramm;
    protected final Nahrungstyp nahrungstyp;

    /*
     * protected boolean istLebendig; 
     * => vorheriger Ansatz: unnoetig, da das gewicht jedes Objektes beim gefressen werden auf 0 gesetzt wird. Nachteil: Kein Objekt kann mit 0 Gramm leben.
    */

    public SimplerLeckerbissen(int gramm) {
        this.gramm = gramm;
        this.nahrungstyp = setNahrungstyp();
    }

    /**
     * Oberklassen muessen diese Methode protected implementieren.
     * Diese Methode existiert, damit der Nahrungstyp sich nicht jedes Objekt der oberen Klasse sich vom Typen unterscheiden kann.
     * @return den Gesetzten Nahrungstyp (Bsp: Muell -> Nicht Essbar)
     */
    protected abstract Nahrungstyp setNahrungstyp();

    @Override
    public String toString(){
        return this.getName() + " " + (istLebendig()?"(lebendig)":"(tot)");
    }

    public abstract String getDefaultName();

    public String getName() {
        return getDefaultName();
    }

    @Override
    public int getGramm() {
        return gramm;
    }

    /**
     * 
     */
    @Override
    public boolean gefressen() {
        if(istLebendig()) {
            this.gramm = 0;

            return true;
        }

        return false;
    }


    @Override
    public boolean istLebendig() {
        return gramm == 0;
    }

    @Override
    public Nahrungstyp getNahrungstyp() {
        return nahrungstyp;
    }
}
