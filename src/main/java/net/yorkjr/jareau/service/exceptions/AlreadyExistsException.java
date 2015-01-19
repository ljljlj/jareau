package net.yorkjr.jareau.service.exceptions;

/**
 * Created by lijunbo on 15/1/19.
 */
public class AlreadyExistsException extends ServiceException {
    public AlreadyExistsException(String message) {
        super(message);
    }

    public AlreadyExistsException(Throwable throwable) {
        super(throwable);
    }

    public AlreadyExistsException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
