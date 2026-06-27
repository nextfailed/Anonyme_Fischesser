package exceptions;

public class UnbekannterAkteur extends ClassNotFoundException{
    public UnbekannterAkteur(){super();}

    public UnbekannterAkteur(String message) {
        super(message);
    }
}
