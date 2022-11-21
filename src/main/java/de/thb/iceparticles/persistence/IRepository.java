package de.thb.iceparticles.persistence;

import de.thb.iceparticles.persistence.domain.Station;

import java.util.List;

public interface IRepository {

    List<Station> findAll();

    Station save(Station station);

}
