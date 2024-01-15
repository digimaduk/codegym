package org.digimad.generics.gg;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
//@JsonIgnoreProperties({"optional", "table", "payload"})
public class Schema{
    @JsonProperty("type")
    private String type;
    private List<Field> fields;
    @JsonProperty("optional")
    private Boolean optional;
    @JsonProperty("name")
    private String name;
}
