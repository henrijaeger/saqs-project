package de.thb.iceparticles.service;

import de.thb.iceparticles.persistence.domain.Station;
import de.thb.iceparticles.service.domain.StationCreateDto;

import java.util.List;

public interface IStationService {

    List<Station> getStations();

    void createStation(StationCreateDto dto);

}
