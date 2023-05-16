package com.ciu.ciuhomework_1.api.controller;

import com.ciu.ciuhomework_1.business.DocumentManager;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;




@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/data/read")
public class DocumentController {
    private final DocumentManager manager;

    @GetMapping
    public String getListData(@RequestParam String fileName) throws Exception {
        return manager.getAllWordsFromFile(fileName);
    }
}