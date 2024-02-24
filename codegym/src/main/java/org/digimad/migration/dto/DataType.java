package org.digimad.migration.dto;

import lombok.Getter;

import java.sql.Types;
import java.util.Arrays;

public enum DataType {

    CHAR("CHAR", Types.CHAR),
    DECFLOAT("DECFLOAT", Types.FLOAT),
    CHARACTERVARYING("CHARACTERVARYING", Types.VARCHAR),
    TIMESTAMP("TIMESTAMP", Types.TIMESTAMP);

    @Getter
    private final String text;
    @Getter
    private final int argType;

    DataType(final String text, final int argType) {
        this.text = text;
        this.argType = argType;
    }

    public static DataType of(final String dataTypeName) {
        return Arrays.stream(values()).filter(value -> value.text.equals(dataTypeName))
            .findFirst()
            .orElseThrow(() -> new IllegalStateException("Unknown data-type: " + dataTypeName));
    }
}
