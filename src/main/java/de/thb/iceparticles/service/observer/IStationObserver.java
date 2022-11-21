package de.thb.iceparticles.service.observer;

import de.thb.iceparticles.persistence.domain.Station;

public interface IStationObserver {

    void onNewStation(Station station);

}
