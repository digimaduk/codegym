package org.digimad.generics.gg;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CDCEvent<T> {
    @JsonProperty("schema")
    private Schema schema;
    @JsonProperty("payload")
    private T payload;
}
