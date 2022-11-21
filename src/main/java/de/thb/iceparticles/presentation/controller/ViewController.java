package de.thb.iceparticles.presentation.controller;

import de.thb.iceparticles.persistence.domain.Station;
import de.thb.iceparticles.presentation.model.ListStationDto;
import de.thb.iceparticles.service.observer.IStationObserver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.swing.*;

@Slf4j
@Component
public class ViewController implements IViewController, IStationObserver {

    private final DefaultListModel<ListStationDto> stations;

    public ViewController() {
        this.stations = new DefaultListModel<>();
    }

    @Override
    public void addStation(Station station) {
        stations.addElement(ListStationDto.builder().id(station.getId()).selected(false).build());
    }

    @Override
    public void onNewStation(Station station) {
        addStation(station);

        log.debug("A new station has just been added: {}", station);
    }

    public ListModel<ListStationDto> getStationModel() {
        return stations;
    }

}
