package actors;

import java.util.List;

import exceptions.FressException;
import exceptions.FrisstNichtException;
import exceptions.VollerMagenException;

/**
 * Meeresbewohner sind Akteure, die einen Magen besitzen und Leckerbissen verspeisen koennen.
 * Meeresbewohner
 */
public abstract class Meeresbewohner extends Akteur {
    final int APPETIT_GRENZE; // In Gramm
    protected int momentanerAppetit;

    private final Esstyp esstyp;

    private List<Leckerbissen> magen;

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
    }

    @Override
    /**
     * Gibt den Namen und die jeweilige Statistik eines Meeresbewohners, sowie den Mageninhalt (Nur Namenauflistung) als String zurueck.
     * Ruft dabei Super.toString() auf und fuegt die Werte der Oberklasse.toString() dem String als Vorreiter hinzu.
     */
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
     * Berechnet die Differenz zwischen dem Maximalen Appetit und dem momentanen Appetit.
     * Bei einer Rueckgabe von < 0 ist noch moegliche Appetit ueberschritten. 
     * @return wie viel Appetit noch vorhanden ist
     */
    public int berechneAktuellerAppetite(){
        return APPETIT_GRENZE - momentanerAppetit;
    }

    /**
     * Der Meeresbewohner versucht den mitgegebenen Leckerbissen zu verspeisen.
     * Dabei wird ueber mehrere huerden geparsed, bis alle Auffaelligkeiten bereinigt sind und der Leckerbissen mit gefressen() gefressen 
     * und in den Magen-Array aufgenommen wird.
     * Nach dem fressen lebt der Leckerbissen nichtmehr.
     * @param leckerbissen Zu fressender Leckerbissen
     * @throws FressException verschiedene Gruende, wie nichtmehr am Leben oder passt nicht zum Fresstypen
     * @throws NullPointerException falls der Leckerbissen Null ist
     */
    public void fressen(Leckerbissen leckerbissen) throws FressException, NullPointerException{
        int neuesGewicht; // Speichert das Gewicht des Leckerbissens ab, da es bei dem Aufruf von gefressen() automatisch auf 0 gesetzt wird.

        // Prueft, ob das Leckerbissen-Objekt nicht leer ist.
        if(leckerbissen == null){
            throw new NullPointerException("Der Leckerbissen ist undefiniert.");
        }

        neuesGewicht = leckerbissen.getGramm();

        // Prueft, ob der Nahrungstyp dem Esstyp entspricht.
        if(!esstyp.akzeptiert(leckerbissen.getNahrungstyp())){
            throw new FrisstNichtException("Der Leckerbissen " + leckerbissen.getName() + "steht nicht auf der Speisekarte des Meeresbewohners" + this.getName());
        }

        // Prueft, ob, wenn der Leckerbissen dem Esstyp entspricht, der Leckerbissen gefressen werden konnte. (Beispiel falls nicht: ist nichtmehr am leben).
        if(!leckerbissen.gefressen()){
            StringBuilder grund = new StringBuilder(); 
            
            grund.append(leckerbissen.getName()).append(" konnte nicht gefressen werden."); 

            if(!leckerbissen.istLebendig()) grund.append(" (lebt nichtmehr)");
                
            throw new FressException(grund.toString());
        };

        // Prueft, ob der Meeresbewohner nicht bereits vollgefressen ist.
        if(berechneAktuellerAppetite() < 0){
            throw new VollerMagenException(this.NAME + " ist vollgefressen und kann daher " + leckerbissen.getName() + " nichtmher aufnehmen.");
        }
        
        // Leckerbissen wird dem Magen hinzugefuegt, das Gewicht des Leckerbissens wird auf 0 gesetzt und der Appetit wird um das Gewicht erhoeht.
        magen.add(leckerbissen);
        this.momentanerAppetit += neuesGewicht;
        this.GRAMM += neuesGewicht;
    }

}
