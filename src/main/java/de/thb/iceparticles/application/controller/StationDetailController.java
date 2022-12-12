package de.thb.iceparticles.application.controller;

import de.thb.iceparticles.application.controller.domain.ErrorObject;
import de.thb.iceparticles.application.controller.domain.Response;
import de.thb.iceparticles.persistence.domain.Station;
import de.thb.iceparticles.application.service.IStationService;
import de.thb.iceparticles.application.service.domain.StationUpdateDto;
import de.thb.iceparticles.application.service.domain.exc.InvalidValueException;
import de.thb.iceparticles.application.service.domain.exc.StationNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class StationDetailController {

    private static final String CHANNEL = "/ws/station-update";

    private final IStationService stationService;
    private final IMessageBroker messageBroker;

    @Autowired
    public StationDetailController(IStationService stationService, IMessageBroker messageBroker) {
        this.stationService = stationService;
        this.messageBroker = messageBroker;
    }

    @PatchMapping("/detail/{id}")
    public ResponseEntity<Response<Station>> updateDetails(@PathVariable String id, @RequestBody StationUpdateDto update) {
        Response<Station> response;

        log.debug("[Update] {} : {}", id, update);

        try {
            Station updated = stationService.patchStation(id, update);
            response = Response.<Station>builder().status(HttpStatus.OK).value(updated).build();

            messageBroker.broadcast(CHANNEL, updated);
        } catch (InvalidValueException e) {
            log.error("error: {}: {}", id, e.getMessage());

            response = ErrorObject.<Station>builder().status(HttpStatus.BAD_REQUEST).message(e.getMessage()).build();
        } catch (StationNotFoundException e) {
            log.error("error: {}: {}", id, e.getMessage());

            response = ErrorObject.<Station>builder().status(HttpStatus.NOT_FOUND).message(e.getMessage()).build();
        }

        return ResponseEntity.status(response.getStatus()).body(response);
    }

}
