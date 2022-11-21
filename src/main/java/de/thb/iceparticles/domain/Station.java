package de.thb.iceparticles.domain;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class Station {

    private String id;
    private LocalDate date;
    private int target;
    private int value;

}
