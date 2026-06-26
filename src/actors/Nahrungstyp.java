package actors;

public enum Nahrungstyp {
    PFLANZE("Pflanze"),
    FISCH("actors.Fisch"),
    NICHT_ESSBAR("nicht essbar"),
    FLEISCH("Fleisch");

    final String TYPNAME;

    Nahrungstyp(String typname) {
        this.TYPNAME = typname;
    }
}
