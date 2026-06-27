package actors;

public class Muell extends SimplerLeckerbissen {
    private static final Nahrungstyp ALLGEMEINER_NAHRUNGSTYP = Nahrungstyp.NICHT_ESSBAR;

    public Muell(String name, int gramm) {
        super(name, gramm, ALLGEMEINER_NAHRUNGSTYP);
    }

}
