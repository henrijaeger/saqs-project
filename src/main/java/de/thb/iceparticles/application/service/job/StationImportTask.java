package de.thb.iceparticles.application.service.job;

import de.thb.iceparticles.application.service.IStationService;
import de.thb.iceparticles.application.service.domain.StationCreateDto;
import de.thb.iceparticles.application.service.domain.exc.InvalidValueException;
import de.thb.iceparticles.application.service.domain.exc.StationAlreadyExistsExceptions;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Random;

@Slf4j
@Component
public class StationImportTask {

    private final Random random;
    private final IStationService stationService;

    @Autowired
    public StationImportTask(IStationService stationService) {
        this.random = new Random();
        this.stationService = stationService;
    }

    // Alle 2min eine neue Station
    @Scheduled(cron = "*/10 * * * * *")
    //@Scheduled(cron = "-")
    public void addRandom() {
        if (stationService.getStations().size() < 100) {
            try {
                stationService.createStation(StationCreateDto.builder()
                        .id(genUnusedId())
                        .localDate(LocalDate.of(2000 + random.nextInt(22), 1 + random.nextInt(11), 1 + random.nextInt(27)))
                        .target(random.nextInt(100))
                        .value(random.nextInt(100))
                        .build());
            } catch (RuntimeException | InvalidValueException | StationAlreadyExistsExceptions e) {
                log.error("Could not add another station.", e);
            }
        }
    }

    private String genUnusedId() {
        int attempts = 10;

        do {
           String id = genId();

           if (stationService.getStations().stream().noneMatch(x -> x.getId().equals(id)))
               return id;
        } while (attempts-- > 0);

        throw new RuntimeException("Could not generate an unused ID within 10 tries.");
    }

    private String genId() {
        final String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        final StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 6; i++) {
            sb.append(chars.charAt(random.nextInt(chars.length())));
        }

        return sb.toString();
    }

}
