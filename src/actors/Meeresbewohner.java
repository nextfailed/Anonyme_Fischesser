package actors;

import java.util.List;

import exceptions.FressException;
import exceptions.FrisstNichtException;
import exceptions.VollerMagenException;

/**
 * Meeresbewohner sind Akteure, die einen Magen besitzen und 
 * Leckerbissen verspeisen koennen.
 */
public abstract class Meeresbewohner extends Akteur {
    final int APPETIT_GRENZE; // In Gramm
    protected int momentanerAppetit;

    private final Esstyp esstyp;

    private List<Leckerbissen> magen;

    public Meeresbewohner(String name, int gramm, Nahrungstyp nahrungstyp, Esstyp esstyp, int maxMagenfuellmenge) {
        super(name, gramm, nahrungstyp);
        this.APPETIT_GRENZE = maxMagenfuellmenge;
        this.esstyp = esstyp;
    }


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
     * @param leckerbissen 
     * @throws FressException verschiedene Gruende, wie nichtmehr am Leben oder passt nicht zum 
     * @throws NullPointerException falls der Leckerbissen Null ist
     */
    public void fressen(Leckerbissen leckerbissen) throws FressException, NullPointerException{
        int neuesGewicht; // Speichert das Gewicht des Leckerbissens ab, da es bei dem Aufruf von gefressen() automatisch auf 0 gesetzt wird.

        // Prueft, ob das Leckerbissen-Objekt nicht leer ist
        if(leckerbissen == null){
            throw new NullPointerException("Der Leckerbissen wurde nicht definiert.");
        }

        neuesGewicht = leckerbissen.getGramm();

        // Prueft, ob der Nahrungstyp dem Esstyp entspricht
        if(!esstyp.akzeptiert(leckerbissen.getNahrungstyp())){
            throw new FrisstNichtException("");
        }

        // Prueft, ob wenn der Leckerbissen dem Esstyp entspricht ob der Leckerbissen gefressen werden konnte. (Beispiel falls nicht: ist nichtmehr am leben)
        if(!leckerbissen.gefressen()){
            StringBuilder grund = new StringBuilder(); 
            
            grund.append(leckerbissen.getName()).append(" konnte nicht gefressen werden."); 

            if(!leckerbissen.istLebendig()) grund.append(" (lebt nichtmehr)");
                
            throw new FressException(grund.toString());
        };

        // Prueft, ob der Magen des Fisches noch nicht voll ist
        if(berechneAktuellerAppetite() < 0){
            throw new VollerMagenException(this.NAME + " hat einen vollen Magen und kann ");
        }
        
        magen.add(leckerbissen);
        this.momentanerAppetit += neuesGewicht;
        this.GRAMM += neuesGewicht;
    }

}
