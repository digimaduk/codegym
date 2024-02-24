package org.digimad.generics;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.digimad.generics.gg.CDCEvent;

public class GenericJsonParser<T> {
    private final ObjectMapper objectMapper = new ObjectMapper();

    public CDCEvent<T> parseJson(String jsonString) throws JsonProcessingException {
        return objectMapper.readValue(jsonString, new TypeReference<CDCEvent<T>>() {
        });
    }
}
