package de.thb.iceparticles.controller;

import de.thb.iceparticles.controller.domain.ErrorObject;
import de.thb.iceparticles.controller.domain.Response;
import de.thb.iceparticles.misc.Util;
import de.thb.iceparticles.persistence.domain.Station;
import de.thb.iceparticles.service.IStationService;
import de.thb.iceparticles.service.domain.StationUpdateDto;
import de.thb.iceparticles.service.domain.exc.InvalidValueException;
import de.thb.iceparticles.service.domain.exc.StationNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Slf4j
@Controller
public class StationDetailController {

    private final IStationService stationService;

    @Autowired
    public StationDetailController(IStationService stationService) {
        this.stationService = stationService;
    }

    @MessageMapping("/detail/{id}")
    @SendTo("/ws/station-detail")
    public String updateDetails(@DestinationVariable String id, @Payload String data) {
        log.debug("[Update] {} : {}", id, data);

        return Util.fromJson(data, StationUpdateDto.class)
                .map(u -> {
                    try {
                        return Response.builder().status(HttpStatus.OK).value(stationService.patchStation(id, u)).build();
                    } catch (InvalidValueException e) {
                        return ErrorObject.builder().status(HttpStatus.BAD_REQUEST).message(e.getMessage()).build();
                    } catch (StationNotFoundException e) {
                        return ErrorObject.builder().status(HttpStatus.NOT_FOUND).message(e.getMessage()).build();
                    }
                })
                .map(Util::toJson)
                .orElse(Util.toJson(ErrorObject.builder().status(HttpStatus.BAD_REQUEST).message("Invalid request parameters.").build()));
    }


}
