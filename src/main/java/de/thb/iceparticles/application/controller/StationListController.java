package de.thb.iceparticles.application.controller;

import de.thb.iceparticles.application.controller.domain.Response;
import de.thb.iceparticles.crosscut.Util;
import de.thb.iceparticles.application.service.IStationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class StationListController {

    private final IStationService stationService;

    @Autowired
    public StationListController(IStationService stationService) {
        this.stationService = stationService;
    }

    @GetMapping(value = "/list", produces = "application/json")
    public String getStations() {
        log.debug("[Get] List of stations");

        return Util.toJson(Response.builder()
                .status(HttpStatus.OK)
                .value(stationService.getStations())
                .build());
    }

}
