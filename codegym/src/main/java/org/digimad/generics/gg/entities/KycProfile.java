package org.digimad.generics.gg.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.digimad.generics.gg.Metadata;

import java.io.Serializable;

@Getter
@Setter
public class KycProfile extends Auditable implements Serializable {
    @JsonProperty("KYC_PROFILE_ID")
    private Long kycProfileId;
    @JsonProperty("KYC_PROFILE_ID_isMissing")
    private Boolean kycProfileIdIsMissing;
}
