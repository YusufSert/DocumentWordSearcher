package com.ciu.ciuhomework_1.business;


import com.ciu.ciuhomework_1.business.dto.Data;
import com.ciu.ciuhomework_1.repository.MapContainer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MapManager {
    private final MapContainer container;
    public Data getMapData(String word) throws Exception {
        var start = System.nanoTime();
        var v = container.wordMap.get(word);
        var end = System.nanoTime();
        return new Data(v, end - start);
    }

    public void init() throws Exception {
        container.storeIntoMap();
    }
}

