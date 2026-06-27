package exceptions;

public class FressException extends RuntimeException {

    public FressException(){
        super();
    }

    public FressException(String message) {
        super(message);
    }
}
