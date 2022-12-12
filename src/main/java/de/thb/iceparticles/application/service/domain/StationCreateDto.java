package de.thb.iceparticles.application.service.domain;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class StationCreateDto {

    private String id;
    private LocalDate localDate;
    private int target;
    private int value;

}
