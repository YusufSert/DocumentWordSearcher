package com.ciu.ciuhomework_1.business;

import com.ciu.ciuhomework_1.business.dto.Data;
import com.ciu.ciuhomework_1.repository.ListContainer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ListManager {
    private final ListContainer container;

    public Data getListData(String word) {
        var start = System.nanoTime();
        var v =  container.searchWord(word);
        var end = System.nanoTime();
        System.out.println(end - start);
        return new Data(v, end- start);
    }

    public void init() throws Exception {
        container.init();
    }

}

