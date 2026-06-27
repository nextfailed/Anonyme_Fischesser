package actors;

public class Seetang extends SimplerLeckerbissen{
    private static final Nahrungstyp ALLGEMEINER_NAHRUNGSTYP = Nahrungstyp.PFLANZE;

    public Seetang(String name, int gramm) {
        super(name, gramm, ALLGEMEINER_NAHRUNGSTYP);
    }
    
}
