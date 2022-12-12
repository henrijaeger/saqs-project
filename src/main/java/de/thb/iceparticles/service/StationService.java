package de.thb.iceparticles.service;

import de.thb.iceparticles.persistence.IRepository;
import de.thb.iceparticles.persistence.domain.Station;
import de.thb.iceparticles.service.domain.StationCreateDto;
import de.thb.iceparticles.service.domain.StationUpdateDto;
import de.thb.iceparticles.service.domain.exc.InvalidValueException;
import de.thb.iceparticles.service.domain.exc.StationAlreadyExistsExceptions;
import de.thb.iceparticles.service.domain.exc.StationNotFoundException;
import de.thb.iceparticles.service.observer.IStationObserver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;

@Slf4j
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
    public Station createStation(StationCreateDto dto) throws InvalidValueException, StationAlreadyExistsExceptions {
        if (!StringUtils.hasText(dto.getId())) {
            throw new InvalidValueException("id", "may not be empty", dto.getId());
        }

        if (dto.getValue() < 0 || dto.getValue() > 100) {
            throw new InvalidValueException("value", "may not exceed [0, 100]", dto.getValue());
        }

        if (db.findById(dto.getId()).isPresent()) {
            throw new StationAlreadyExistsExceptions(dto.getId());
        }

        Station station = db.save(Station.builder().id(dto.getId()).date(dto.getLocalDate()).target(dto.getTarget()).value(dto.getValue()).build());

        observers.forEach(o -> o.onNewStation(station));

        return station;
    }

    @Override
    public Station patchStation(String id, StationUpdateDto dto) throws InvalidValueException, StationNotFoundException {
        Optional<Station> os = db.findById(id);

        if (os.isPresent()) {
            Station station = os.get();

            if (dto.getValue() != null) {
                if (dto.getValue() < 0 || dto.getValue() > 100) {
                    throw new InvalidValueException("value", "may not exceed [0, 100]", dto.getValue());
                }

                station.setValue(dto.getValue());
            }

            if (dto.getDate() != null) {
                station.setDate(dto.getDate());
            }

            return db.save(station);
        } else {
            throw new StationNotFoundException(id);
        }
    }

}
