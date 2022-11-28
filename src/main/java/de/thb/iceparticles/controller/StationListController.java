package de.thb.iceparticles.controller;

import de.thb.iceparticles.misc.Util;
import de.thb.iceparticles.service.IStationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Slf4j
@Controller
public class StationListController {

    private final IStationService stationService;

    @Autowired
    public StationListController(IStationService stationService) {
        this.stationService = stationService;
    }

    @MessageMapping("/list")
    @SendTo("/ws/station-list")
    public String getStations() {
        try {
            Thread.sleep(2000);
        } catch (Exception e) {}

        return Util.toJson(stationService.getStations());
    }

}
