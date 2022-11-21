package de.thb.iceparticles.persistence.domain;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDate;

@Data
@Builder
@ToString
public class Station {

    private String id;
    private LocalDate date;
    private int target;
    private int value;

}
