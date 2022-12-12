package de.thb.iceparticles.crosscut;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

@Slf4j
public class Util {

    private static final ObjectMapper mapper = new ObjectMapper().registerModule(new JavaTimeModule());

    public static <T> Optional<T> fromJson(String json, Class<? extends T> type) {
        try {
            return Optional.of(mapper.readValue(json, type));
        } catch (Exception e) {
            log.error("Failed to create '" + type + "' from JSON.", e);

            return Optional.empty();
        }
    }

    public static <T> String toJson(T object) {
        try {
            return mapper.writeValueAsString(object);
        } catch (Exception e) {
            log.error("Failed to create JSON from value: " + object, e);

            return "{}";
        }
    }

}
