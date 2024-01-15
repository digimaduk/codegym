package org.digimad.generics.gg;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Metadata {
    @JsonProperty("table")
    private String table;
    @JsonProperty("op_type")
    private String opType;
    @JsonProperty("op_ts")
    private String opTs;
    @JsonProperty("current_ts")
    private String currentTs;
    @JsonProperty("pos")
    private String pos;
}
