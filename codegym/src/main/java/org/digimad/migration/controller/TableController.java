package org.digimad.migration.controller;

import lombok.RequiredArgsConstructor;
import org.digimad.migration.dto.TableDto;
import org.digimad.migration.service.DatabaseService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class TableController {
    private final DatabaseService databaseService;

    @PostMapping("/migrate/{id}")
    void migrate(@RequestBody TableDto tableDto, @PathVariable Long id) {
        databaseService.insertAndUpdate(tableDto, id);
    }
}
