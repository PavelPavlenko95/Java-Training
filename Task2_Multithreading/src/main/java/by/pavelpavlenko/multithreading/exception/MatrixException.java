package by.pavelpavlenko.multithreading.exception;

public class MatrixException extends Exception {

    public MatrixException() {
        super();
    }

    public MatrixException(final String message) {
        super(message);
    }

    public MatrixException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public MatrixException(final Throwable cause) {
        super(cause);
    }

}