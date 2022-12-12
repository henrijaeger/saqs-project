package de.thb.iceparticles.application.service;

import de.thb.iceparticles.application.service.domain.StationCreateDto;
import de.thb.iceparticles.application.service.domain.StationUpdateDto;
import de.thb.iceparticles.application.service.domain.exc.InvalidValueException;
import de.thb.iceparticles.application.service.domain.exc.StationAlreadyExistsExceptions;
import de.thb.iceparticles.application.service.domain.exc.StationNotFoundException;
import de.thb.iceparticles.persistence.domain.Station;

import java.util.List;

public interface IStationService {

    List<Station> getStations();

    Station createStation(StationCreateDto dto) throws InvalidValueException, StationAlreadyExistsExceptions;

    Station patchStation(String id, StationUpdateDto dto) throws InvalidValueException, StationNotFoundException;

}
