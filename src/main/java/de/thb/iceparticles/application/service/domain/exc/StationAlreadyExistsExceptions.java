package de.thb.iceparticles.application.service.domain.exc;

public class StationAlreadyExistsExceptions extends Exception {

    public StationAlreadyExistsExceptions(String id) {
        super("A station with ID '" + id + "' already exists.");
    }

}
