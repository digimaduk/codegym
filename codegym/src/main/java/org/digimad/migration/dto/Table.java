package org.digimad.migration.dto;

import lombok.Getter;
import lombok.ToString;

import java.util.LinkedHashMap;
import java.util.Map;

@ToString
public class Table {
    @Getter
    private final String name;
    private final Map<String, Field> fieldsByName = new LinkedHashMap<>();

    public Table(String name) {
        this.name = name;
    }

    public int numberOfFields() {
        return fieldsByName.size();
    }

    public Field getField(final String fieldName) {
        return fieldsByName.get(fieldName.toUpperCase());
    }

    public Map<String, Field> getFieldsByName() {
        return fieldsByName;
    }

    public void addField(final int columnId, final String columnName, final DataType dataType, final int dataLength, final boolean nullable) {
        fieldsByName.put(columnName, new Field(columnId, columnName, dataType, dataLength, nullable));
    }
}
