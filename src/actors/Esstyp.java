package actors;

import java.util.ArrayList;


public enum Esstyp {
    VEGANER("Veganer", Nahrungstyp.PFLANZE),
    VEGETARIER("Vegetarier", Nahrungstyp.PFLANZE),
    
    FISCHESSER("Fischesser", Nahrungstyp.FISCH),
    FLEXITARIER("Flexitarier", Nahrungstyp.FLEISCH, Nahrungstyp.FISCH),
    FLEISCHESSER("Fleischesser", Nahrungstyp.FLEISCH),

    ALLES_ESSER("Allesessen", Nahrungstyp.values());




    final String typname;
    final Nahrungstyp[] isstDies;

    Esstyp(String typname, Nahrungstyp... isstDies) {
        this.typname = typname;
        this.isstDies = isstDies;
    }

    public boolean akzeptiert(Nahrungstyp mitgegebenerTyp){
        for(Nahrungstyp aktuellerTyp : isstDies){
            if(aktuellerTyp.equals(mitgegebenerTyp)) return true;
        }

        return false;
    }

    public static ArrayList<Nahrungstyp> sucheAkzeptiert(Nahrungstyp mitgegebenerTyp){
        ArrayList<Nahrungstyp> gefundeneErlaubteTypen = new ArrayList<>();

        for(Esstyp aktuellerTyp : Esstyp.values()){
            if(aktuellerTyp.akzeptiert(mitgegebenerTyp)) gefundeneErlaubteTypen.add(mitgegebenerTyp);
        }

        return gefundeneErlaubteTypen;
    }
}
