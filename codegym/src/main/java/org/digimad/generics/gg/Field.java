package org.digimad.generics.gg;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Field {
    @JsonProperty("type")
    private String type;
    @JsonProperty("optional")
    private Boolean optional;
    @JsonProperty("field")
    private String field;
}
