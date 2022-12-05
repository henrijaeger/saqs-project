package de.thb.iceparticles.service.domain.exc;

public class InvalidValueException extends Exception {

    public InvalidValueException(String value, String reason, Object actual) {
        super("'" + value + "' cannot accept {" + actual + "}: " + reason);
    }

}
