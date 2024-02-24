package org.digimad.migration.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TableDto {
    private String name;
    private List<String> columns;
    private String pk;
    private List<String> fkList;
    private String opType;
    private String toTable;
    private String fromTable;
    private List<String> conditions;
}
