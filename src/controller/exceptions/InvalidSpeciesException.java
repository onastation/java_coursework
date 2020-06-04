package controller.exceptions;

public class InvalidSpeciesException extends RuntimeException {
    public InvalidSpeciesException(String warning) {
        super(warning);
    }
}
