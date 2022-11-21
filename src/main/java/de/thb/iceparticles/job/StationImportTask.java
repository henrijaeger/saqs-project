package de.thb.iceparticles.job;

import de.thb.iceparticles.service.IStationService;
import de.thb.iceparticles.service.domain.StationCreateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Random;

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
    @Scheduled(cron = "*/2 * * * * *")
    public void addRandom() {
        if (stationService.getStations().size() < 50) {
            stationService.createStation(StationCreateDto.builder().id(genUnusedId()).build());
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
        final String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYK0123456789";
        final StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 6; i++) {
            sb.append(chars.charAt(random.nextInt(chars.length())));
        }

        return sb.toString();
    }

}
