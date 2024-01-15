package org.digimad.generics;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.digimad.generics.gg.CDCEvent;
import org.digimad.generics.gg.entities.KpBusAddr;
import org.digimad.generics.gg.entities.KycProfile;

import java.util.Map;

public class GenericsMain {
    public static void main(String[] args) throws JsonProcessingException {

        String jsonProfileString = "{\n" +
            "  \"schema\": {\n" +
            "    \"type\": \"struct\",\n" +
            "    \"fields\": [\n" +
            "      {\n" +
            "        \"type\": \"string\",\n" +
            "        \"optional\": true,\n" +
            "        \"field\": \"table\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"type\": \"string\",\n" +
            "        \"optional\": true,\n" +
            "        \"field\": \"op_type\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"type\": \"string\",\n" +
            "        \"optional\": true,\n" +
            "        \"field\": \"op_ts\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"type\": \"string\",\n" +
            "        \"optional\": true,\n" +
            "        \"field\": \"current_ts\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"type\": \"string\",\n" +
            "        \"optional\": true,\n" +
            "        \"field\": \"pos\"\n" +
            "      }\n" +
            "    ],\n" +
            "    \"optional\": false,\n" +
            "    \"name\": \"ORIEKYC.CDC_ORI_POC\"\n" +
            "  },\n" +
            "  \"payload\": {\n" +
            "    \"table\": \"ORIEKYC.CDC_ORI_POC\",\n" +
            "    \"op_type\": \"I\",\n" +
            "    \"op_ts\": \"2024-01-11 03:40:56.000000\",\n" +
            "    \"current_ts\": \"2024-01-11 05:08:24.554001\",\n" +
            "    \"pos\": \"00000000070224943729\",\n" +
            "    \"K_P_BUS_ADDR_ID\": 475743.0,\n" +
            "    \"K_P_BUS_ADDR_ID_isMissing\": false,\n" +
            "    \"KYC_PROFILE_ID\": 475743.0,\n" +
            "    \"KYC_PROFILE_ID_isMissing\": false,\n" +
            "    \"ADDRESS_TYPES_ID\": 39826.0,\n" +
            "    \"ADDRESS_TYPES_ID_isMissing\": false,\n" +
            "    \"ACTIVE_FLAG\": \"Y\"\n" +
            "  }\n" +
            "}";

        ObjectMapper mapper = new ObjectMapper();

        CDCEvent<KpBusAddr> schema = mapper.readValue(jsonProfileString, new TypeReference<CDCEvent<KpBusAddr>>() {
        });

        System.out.println("Name: " + schema.getSchema().getName());
        System.out.println("Profile Id: " + schema.getPayload().getKycProfileId());

    }

    private static KycProfile getKycProfile(String jsonProfileString, ObjectMapper mapper) throws JsonProcessingException {
        //Parse JSON into a Map for flexible access.
        Map<String, Object> jsonMap = mapper.readValue(jsonProfileString, Map.class);
        //Use nested get calls for nested structures.
        CDCEvent cdcEvent = mapper.convertValue(jsonMap.get("schema"), CDCEvent.class);
        KycProfile kycProfile = mapper.convertValue(cdcEvent.getPayload(), KycProfile.class);
        return kycProfile;
    }
}
