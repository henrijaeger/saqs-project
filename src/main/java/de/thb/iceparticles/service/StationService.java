package de.thb.iceparticles.service;

import de.thb.iceparticles.persistence.IRepository;
import de.thb.iceparticles.persistence.domain.Station;
import de.thb.iceparticles.service.domain.StationCreateDto;
import de.thb.iceparticles.service.observer.IStationObserver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StationService implements IStationService {

    private final IRepository db;
    private final List<IStationObserver> observers;

    @Autowired
    public StationService(IRepository db, List<IStationObserver> observers) {
        this.db = db;
        this.observers = observers;
    }

    @Override
    public List<Station> getStations() {
        return db.findAll();
    }

    @Override
    public void createStation(StationCreateDto dto) {
        Station station = db.save(Station.builder().id(dto.getId()).date(dto.getLocalDate()).target(dto.getTarget()).value(dto.getValue()).build());

        observers.forEach(o -> o.onNewStation(station));
    }
}
