package de.thb.iceparticles.application.controller.domain;

import lombok.Data;
import lombok.experimental.SuperBuilder;
import org.springframework.http.HttpStatus;

@Data
@SuperBuilder
public class Response<T> {

    HttpStatus status;
    T value;

}
