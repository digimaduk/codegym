package org.digimad.migration.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class Field {
    final int columnId;
    final String columnName;
    final DataType dataType;
    final int dataLength;
    final boolean nullable;
}
