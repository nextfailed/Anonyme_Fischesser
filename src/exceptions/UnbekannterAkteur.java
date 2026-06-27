package exceptions;

public class UnbekannterAkteur extends ClassNotFoundException{

    public UnbekannterAkteur(String message) {
        super(message);
    }
}
