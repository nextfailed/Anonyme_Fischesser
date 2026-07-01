package exceptions;

public class UnbekannterAkteurException extends ClassNotFoundException{
    public UnbekannterAkteurException(){super();}

    public UnbekannterAkteurException(String message) {
        super(message);
    }
}
