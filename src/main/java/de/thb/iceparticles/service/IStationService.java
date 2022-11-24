package de.thb.iceparticles.service;

import de.thb.iceparticles.persistence.domain.Station;
import de.thb.iceparticles.service.domain.StationCreateDto;
import de.thb.iceparticles.service.domain.StationUpdateDto;

import java.util.List;

public interface IStationService {

    List<Station> getStations();

    Station createStation(StationCreateDto dto);

    Station patchStation(String id, StationUpdateDto dto);

}
