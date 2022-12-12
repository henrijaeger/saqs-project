package de.thb.iceparticles.application.controller.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class ErrorObject<T> extends Response<T> {

    String message;

}
