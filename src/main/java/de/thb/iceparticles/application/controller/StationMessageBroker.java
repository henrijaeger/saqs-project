package de.thb.iceparticles.application.controller;

import de.thb.iceparticles.persistence.domain.Station;
import de.thb.iceparticles.application.service.observer.IStationObserver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StationMessageBroker implements IStationObserver {

    private static final String CHANNEL = "/ws/new-station";

    private final IMessageBroker messageBroker;

    @Autowired
    public StationMessageBroker(IMessageBroker messageBroker) {
        this.messageBroker = messageBroker;
    }

    @Override
    public void onNewStation(Station station) {
        messageBroker.broadcast(CHANNEL, station);
    }

}
