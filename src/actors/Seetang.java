package actors;

public class Seetang extends Snack {
    public static final String DEFAULT_NAME = "Seetang";
    public static final Nahrungstyp ALLGEMEINER_NAHRUNGSTYP = Nahrungstyp.PFLANZE;
    public static final int DEFAULT_GRAMM = 2;

    public Seetang(int gramm){
        super(gramm);
    }

    public Seetang(){
        this(DEFAULT_GRAMM);
    }


    @Override
    public String getDefaultName() {
        return DEFAULT_NAME;
    }

    @Override
    protected Nahrungstyp setNahrungstyp() {
        return ALLGEMEINER_NAHRUNGSTYP;
    }
}
