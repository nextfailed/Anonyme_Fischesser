package actors;

import java.util.ArrayList;
import java.util.List;

import exceptions.*;

/**
 * Meeresbewohner sind Akteure, die einen Magen besitzen und Leckerbissen verspeisen koennen.
 * Meeresbewohner
 */
public abstract class Meeresbewohner extends Akteur {
    public final int APPETIT_GRENZE; // In Gramm
    protected int momentanerAppetit; // In Gramm

    private final Esstyp esstyp;

    private final List<Leckerbissen> magen;

    /**
     * 
     * @param name Name des Meeresbewohners
     * @param gramm Gewicht
     * @param nahrungstyp Nahrungstyp
     * @param esstyp Gattung Esstyp
     * @param maxMagenfuellmenge Maximale Magenkapazitaet
     */
    public Meeresbewohner(String name, int gramm, Nahrungstyp nahrungstyp, Esstyp esstyp, int maxMagenfuellmenge) {
        super(name, gramm, nahrungstyp);
        this.APPETIT_GRENZE = maxMagenfuellmenge;
        this.esstyp = esstyp;
        this.magen = new ArrayList<>();
    }

    /**
     * Gibt den Namen und die jeweilige Statistik eines Meeresbewohners, sowie den Mageninhalt (Nur Namenauflistung) als String zurueck.
     * Ruft dabei Super.toString() auf und fuegt die Werte der Oberklasse.toString() dem String als Vorreiter hinzu.
     * @return String-Ausgabe mit Namen, Statistik und Mageninhalt
     */
    @Override
    public String toString(){
        StringBuilder output = new StringBuilder();
        String einruecken = "   ";

        output.append(super.toString()).append('\n');
        output.append(einruecken).append("Magen: ").append('\n');

        for(Leckerbissen currentLeckerbissen : magen){
            output.append(einruecken.repeat(2)).append('#').append(currentLeckerbissen.getName()).append('\n') ;
        }


        return output.toString();
    }

    /**
     * Gibt den festgelegten Esstypen zurueck.
     * @return festgelegter Esstyp
     */
    public Esstyp getEsstyp() {
        return esstyp;
    }

    /**
     * Berechnet die Differenz zwischen dem Maximalen Appetit-Level und dem momentanen Appetit-Level.
     * Bei einer Rueckgabe von < 0 ist der Appetit ueberschritten. 
     * @return wie viel Appetit der Meeresbewohner noch hat 
     */
    public int berechneAktuellerAppetite(){
        return APPETIT_GRENZE - momentanerAppetit;
    }

    /**
     * Der Meeresbewohner versucht den mitgegebenen Leckerbissen zu verspeisen.
     * Dabei wird ueber mehrere huerden geparsed, bis alle Auffaelligkeiten bereinigt sind und der Leckerbissen mit gefressen() gefressen 
     * und in den Magen-Array aufgenommen wird.
     * Nach dem Fressen lebt der Leckerbissen nicht mehr.
     * <p>
     *     Wirft logischerweise einen Fehler, falls der Fisch bereits gefressen wurde und daher nicht mehr am Leben ist.
     * </p>
     * @param leckerbissen Zu fressender Leckerbissen
     * @throws FressException verschiedene Fress-Exceptions, wie "nicht mehr am Leben" oder "passt nicht zum Fresstypen"
     * @throws BereitsTotException wird geworfen, falls der Meeresbewohner versucht etwas zu essen, jedoch bereits tot ist 
     * @throws NullPointerException falls der Leckerbissen Null ist
     */
    public void fressen(Leckerbissen leckerbissen) throws FressException, NullPointerException{
        int neuesGewicht; // Speichert das Gewicht des Leckerbissens ab, da es bei dem Aufruf von gefressen() automatisch auf 0 gesetzt wird.

        // Prueft, ob der Meeresbewohner definiert und noch am Leben ist.
        if(!this.istLebendig()){
            throw new BereitsTotException(this.NAME + " lebt nicht mehr und kann daher " + leckerbissen.getName() + " nicht verspeisen.");
        }

        if(this.equals(leckerbissen)){
            throw new FrisstSichSelbstException(this.NAME + " versucht sich selbst zu essen.");
        }

        // Prueft, ob das Leckerbissen-Objekt nicht leer ist.
        if(leckerbissen == null){
            throw new NullPointerException("Der Leckerbissen ist undefiniert.");
        }

        neuesGewicht = leckerbissen.getGramm();

        // Prueft, ob der Nahrungstyp dem Esstyp entspricht.
        if(!esstyp.akzeptiert(leckerbissen.getNahrungstyp())){
            throw new FrisstNichtException("Der Leckerbissen " + leckerbissen.getName() + " steht nicht auf der Speisekarte des Meeresbewohners " + this.getName() + ".");
        }

        // Prueft, ob, wenn der Leckerbissen dem Esstyp entspricht, der Leckerbissen gefressen werden konnte. (Beispiel: falls nicht, ist nicht mehr am Leben).
        if(!leckerbissen.gefressen()){
            StringBuilder grund = new StringBuilder(); 
            
            grund.append(leckerbissen.getName()).append(" konnte nicht gefressen werden."); 

            if(!leckerbissen.istLebendig()) grund.append(" (").append(leckerbissen.getName()).append(" lebt nicht mehr.)");
                
            throw new FressException(grund.toString());
        }

        // Prueft, ob der Meeresbewohner nicht bereits vollgefressen ist.
        if(berechneAktuellerAppetite() < 0){
            throw new VollerMagenException(this.NAME + " ist vollgefressen und kann daher " + leckerbissen.getName() + " nicht mehr aufnehmen.");
        }
        
        // Leckerbissen wird dem Magen hinzugefuegt, das abgespeicherte Gewicht wird auf das Gewicht und den Appetit uebertragen.
        magen.add(leckerbissen);
        this.momentanerAppetit += neuesGewicht;
        this.GRAMM += neuesGewicht;
    }

}
