package de.thb.iceparticles.presentation.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class StationDetailDto {

    private String id;
    private LocalDate date;
    private int target;
    private int value;

}
