package org.digimad.migration.util;

import lombok.extern.slf4j.Slf4j;
import org.digimad.migration.constants.QueryConstants;
import org.digimad.migration.dto.Table;
import org.digimad.migration.dto.TableDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class QueryGenerator {

    public String generateInsertSql(TableDto tableDto, Table table, Long id) {
        String toTable = table.getName();
        String fromColumnStr = String.join(", ", tableDto.getColumns());
        String fromTable = table.getName().concat("_STG");
        String condition = getWhereCondition(tableDto.getConditions(), id);
        String sql = String.format(QueryConstants.INSERT, toTable, fromColumnStr, fromTable, condition);
        log.info("dynamic sql : {}", sql);
        return sql;
    }

    public String getWhereCondition(List<String> conditions, Long id) {
        StringBuilder builder = new StringBuilder();
        conditions.forEach(x -> {
            builder.append(x).append("=").append(id);
        });
        return builder.toString();
    }
}
