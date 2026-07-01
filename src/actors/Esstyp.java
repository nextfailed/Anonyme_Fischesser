package actors;

import java.util.ArrayList;

/**
 * Eine Enum-Klasse, die angibt, welche Art von Leckerbissen ein Meeresbewohner verspeist. 
 * Esstyp
 */
public enum Esstyp {
    VEGANER("Veganer", Nahrungstyp.PFLANZE),
    VEGETARIER("Vegetarier", Nahrungstyp.PFLANZE),
    
    FISCHESSER("Fischesser", Nahrungstyp.FISCH),
    FLEXITARIER("Flexitarier", Nahrungstyp.FLEISCH, Nahrungstyp.FISCH),
    FLEISCHESSER("Fleischesser", Nahrungstyp.FLEISCH),

    ALLES_ESSER("Allesesser", Nahrungstyp.values());




    final String typname;
    final Nahrungstyp[] isstDies;

    /**
     * @param typname Der Name des Types (z.B. 'Veganer')
     * @param isstDies Was der Nahrungstyp verspeisen darf
     */
    Esstyp(String typname, Nahrungstyp... isstDies) {
        this.typname = typname;
        this.isstDies = isstDies;
    }

    /**
     * Gibt zurueck, ob ein gewisser Nahrungstyp mit dem Essverhalten des Esstyps uebereinstimmt.
     * @param mitgegebenerTyp (Bsp: Fisch)
     * @return ob fuer den Esser der richtige Typ gefunden wurde. 
     */
    public boolean akzeptiert(Nahrungstyp mitgegebenerTyp){
        for(Nahrungstyp aktuellerTyp : isstDies){
            if(aktuellerTyp.equals(mitgegebenerTyp)) return true;
        }

        return false;
    }

    /**
     * Ist statisch aufrufbar.
     * Gibt eine ArrayListe mit für den Esstyp erlaubte Typen aus.
     * z.B.: Eingabe von Fleisch → Flexitarier, Fleischesser, alles Esser
     * 
     * @return gefundene Esstypen als Array
     */
    public static ArrayList<Nahrungstyp> sucheAkzeptiert(Nahrungstyp mitgegebenerTyp){
        ArrayList<Nahrungstyp> gefundeneErlaubteTypen = new ArrayList<>();

        for(Esstyp aktuellerTyp : Esstyp.values()){
            if(aktuellerTyp.akzeptiert(mitgegebenerTyp)) gefundeneErlaubteTypen.add(mitgegebenerTyp);
        }

        return gefundeneErlaubteTypen;
    }
}
