package com.ciu.ciuhomework_1.api.controller;

import com.ciu.ciuhomework_1.business.MapManager;
import com.ciu.ciuhomework_1.business.dto.Data;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/data/map")
public class MapController {
    private final MapManager manager;
    @GetMapping
    public Data getMapData(@RequestParam String word) throws Exception {
        return manager.getMapData(word);
    }

    @PostConstruct
    public void init() throws Exception {
        manager.init();
    }
}