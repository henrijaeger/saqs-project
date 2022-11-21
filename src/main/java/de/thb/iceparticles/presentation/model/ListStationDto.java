package de.thb.iceparticles.presentation.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ListStationDto {

    private String id;
    private boolean selected;

}
