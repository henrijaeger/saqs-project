package de.thb.iceparticles.presentation.controller;

import de.thb.iceparticles.persistence.domain.Station;
import de.thb.iceparticles.presentation.model.ListStationDto;

import javax.swing.*;

public interface IViewController {

    void addStation(Station station);

    ListModel<ListStationDto> getStationModel();

}
