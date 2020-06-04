package controller.exceptions;

public class InvalidNumberException extends RuntimeException {
    public InvalidNumberException(String warning) {
        super(warning);
    }
}