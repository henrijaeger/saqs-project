package de.thb.iceparticles.presentation.controller;

import de.thb.iceparticles.persistence.domain.Station;
import de.thb.iceparticles.presentation.model.StationDetailDto;
import de.thb.iceparticles.presentation.view.component.FormComponent;
import de.thb.iceparticles.service.IStationService;
import de.thb.iceparticles.service.domain.StationUpdateDto;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FormPresenter extends Presenter<StationDetailDto, FormComponent> {

    private final IStationService stationService;

    public FormPresenter(IStationService stationService, FormComponent view) {
        super(StationDetailDto.builder().build(), view);

        this.stationService = stationService;
    }

    public void loadStation(int index) {
        if (index >= 0 && index < stationService.getStations().size()) {
            Station s = stationService.getStations().get(index);
            StationDetailDto dto = StationDetailDto.builder()
                    .id(s.getId())
                    .date(s.getDate())
                    .target(s.getTarget())
                    .value(s.getValue())
                    .build();

            this.model = dto;
            this.view.display(dto);
        }
    }

    @Override
    public void handle() {
        StationDetailDto dto = view.collect();
        Station station = stationService.patchStation(model.getId(), StationUpdateDto.builder().target(dto.getTarget()).build());

        model.setTarget(station.getTarget());
        view.display(model);
    }
}
