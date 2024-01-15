package org.digimad.generics.gg.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.digimad.generics.gg.Metadata;

import java.io.Serializable;

@Getter
@Setter
public class KpBusAddr extends Auditable implements Serializable {
    @JsonProperty("K_P_BUS_ADDR_ID")
    private Long kpBusAddrId;
    @JsonProperty("K_P_BUS_ADDR_ID_isMissing")
    private Boolean kpBusAddrIdIsMissing;
    @JsonProperty("KYC_PROFILE_ID")
    private Long kycProfileId;
    @JsonProperty("KYC_PROFILE_ID_isMissing")
    private Boolean kycProfileIdIsMissing;
    @JsonProperty("ADDRESS_TYPES_ID")
    private Long addressTypesId;
    @JsonProperty("ADDRESS_TYPES_ID_isMissing")
    private Boolean addressTypesIdIsMissing;
}
