package exceptions;

public class UnbekannterLeckerbissenException extends RuntimeException {
    public UnbekannterLeckerbissenException(String message) {
        super(message);
    }
}
