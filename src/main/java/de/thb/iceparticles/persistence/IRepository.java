package de.thb.iceparticles.persistence;

import de.thb.iceparticles.persistence.domain.Station;

import java.util.List;
import java.util.Optional;

public interface IRepository {

    List<Station> findAll();

    Optional<Station> findById(String id);

    Station save(Station station);

}
