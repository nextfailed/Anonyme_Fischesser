package actors;

public enum Esstyp {
    VEGANER("Veganer"),
    VEGETARIER("Vegetarier"),
    FISCHESSER("Fischesser"),
    FLEXITARIER("Flexitarier"),
    FLEISCHESSER("Fleischesser");

    final String typname;

    Esstyp(String typname) {
        this.typname = typname;
    }
}
