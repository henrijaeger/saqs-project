package de.thb.iceparticles.service.domain.exc;

public class StationNotFoundException extends Exception {

    public StationNotFoundException(String stationId) {
        super("Station '" + stationId + "' does not exist.");
    }

}
