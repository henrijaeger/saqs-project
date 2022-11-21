package de.thb.iceparticles.persistence;

import de.thb.iceparticles.persistence.domain.Station;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InMemoryDb implements IRepository {

    private final List<Station> stations = new ArrayList<>();

    public InMemoryDb() {
        stations.add(Station.builder().id("mock1").build());
        stations.add(Station.builder().id("mock2").build());
    }

    @Override
    public List<Station> findAll() {
        return stations;
    }

    @Override
    public Station save(Station station) {
        stations.add(station);

        return station;
    }

}
