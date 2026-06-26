public enum Nahrungstyp {
    PFLANZE("Pflanze"),
    FISCH("Fisch"),
    NICHT_ESSBAR("nicht essbar"),
    FLEISCH("Fleisch");

    final String TYPNAME;

    Nahrungstyp(String typname) {
        this.TYPNAME = typname;
    }
}
