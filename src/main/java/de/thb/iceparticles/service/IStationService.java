package de.thb.iceparticles.service;

import de.thb.iceparticles.persistence.domain.Station;
import de.thb.iceparticles.service.domain.StationCreateDto;
import de.thb.iceparticles.service.domain.StationUpdateDto;
import de.thb.iceparticles.service.domain.exc.InvalidValueException;
import de.thb.iceparticles.service.domain.exc.StationAlreadyExistsExceptions;
import de.thb.iceparticles.service.domain.exc.StationNotFoundException;

import java.util.List;

public interface IStationService {

    List<Station> getStations();

    Station createStation(StationCreateDto dto) throws InvalidValueException, StationAlreadyExistsExceptions;

    Station patchStation(String id, StationUpdateDto dto) throws InvalidValueException, StationNotFoundException;

}
