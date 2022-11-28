package de.thb.iceparticles.misc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class Util {

    private static final ObjectMapper mapper = new ObjectMapper().registerModule(new JavaTimeModule());

    public static <T> String toJson(T object) {
        try {
            return mapper.writeValueAsString(object);
        } catch (Exception e) {
            return "{}";
        }
    }

}
