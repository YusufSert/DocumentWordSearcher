package com.ciu.ciuhomework_1.api.controller;

import com.ciu.ciuhomework_1.business.ListManager;
import com.ciu.ciuhomework_1.business.dto.Data;
import com.ciu.ciuhomework_1.repository.ListContainer;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/data/list")
public class ListController {
    private final ListManager manager;

    @GetMapping
    public Data getListData(@RequestParam String word) throws Exception {
        return manager.getListData(word);
    }
    @PostConstruct
    public void init() throws Exception {
        manager.init();
    }
}