package de.thb.iceparticles.service;

import de.thb.iceparticles.domain.Station;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StationService implements IStationService {

    private final List<Station> mockStations = List.of(
            Station.builder().id("ID-1").build(),
            Station.builder().id("ID-2").build()
    );

    @Override
    public List<Station> getStations() {
        return mockStations;
    }
}
