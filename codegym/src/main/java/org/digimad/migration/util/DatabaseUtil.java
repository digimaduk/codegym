package org.digimad.migration.util;

import lombok.extern.slf4j.Slf4j;
import org.digimad.migration.dto.Table;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

@Slf4j
public class DatabaseUtil {

    private static final String H2_DB = "select ordinal_position,column_name,data_type,character_maximum_length,is_nullable from INFORMATION_SCHEMA.COLUMNS where table_name ='%s' order by ordinal_position";
    private static final String ORACLE_DB = "select column_id,column_name,data_type,data_length,nullable from all_tab_cols where table_name = '%s' and column_id is not null order by column_id";

    public static Table resolveTable(final JdbcTemplate jdbcTemplate, final String tableName) {
        final SqlRowSet rowSet = jdbcTemplate.queryForRowSet(String.format(
            H2_DB,
            tableName
        ));
        final Table table = new Table(tableName);
        while (rowSet.next()) {
            table.addField(
                rowSet.getInt(1),
                rowSet.getString(2),
//                DataType.of(rowSet.getString(3)),
                null,
                rowSet.getInt(4),
                "YES".equals(rowSet.getString(5)) //Y in Oracle DB
            );
        }
        log.info("Got metadata for {} :: {} fields", tableName, table.numberOfFields());
        return table;
    }
}
