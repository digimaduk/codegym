package org.digimad.migration.service;

import lombok.RequiredArgsConstructor;
import org.digimad.migration.dto.Table;
import org.digimad.migration.dto.TableDto;
import org.digimad.migration.util.DatabaseUtil;
import org.digimad.migration.util.QueryGenerator;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DatabaseService {
    private final JdbcTemplate jdbcTemplate;
    private final QueryGenerator queryGenerator;

    public void insertAndUpdate(TableDto tableDto, Long id) {
        String tableName = tableDto.getName();
        Table table = DatabaseUtil.resolveTable(jdbcTemplate, tableName.toUpperCase());
        if ("I".equalsIgnoreCase(tableDto.getOpType())) {
            //stg to main
            jdbcTemplate.update(queryGenerator.generateInsertSql(tableDto, table, id));
        } else if ("U".equalsIgnoreCase(tableDto.getOpType())) {

        }
    }
}
