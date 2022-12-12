package de.thb.iceparticles.persistence;

import de.thb.iceparticles.persistence.domain.Station;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class InMemoryDb implements IRepository {

    private final Set<Station> stations = new LinkedHashSet<>();

    public InMemoryDb() { }

    @Override
    public List<Station> findAll() {
        return new ArrayList<>(stations);
    }

    @Override
    public Optional<Station> findById(String id) {
        return stations.stream().filter(s -> Objects.equals(s.getId(), id)).findFirst();
    }

    @Override
    public Station save(Station station) {
        stations.add(station);

        return station;
    }

}
