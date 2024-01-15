package org.digimad.generics.gg.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.digimad.generics.gg.Metadata;

@Getter
@Setter
public class Auditable extends Metadata {
    @JsonProperty("ACTIVE_FLAG")
    private String activeFlag;
}
