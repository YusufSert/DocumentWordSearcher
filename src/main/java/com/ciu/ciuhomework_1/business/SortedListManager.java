package com.ciu.ciuhomework_1.business;

import com.ciu.ciuhomework_1.business.dto.Data;
import com.ciu.ciuhomework_1.repository.SortedListContainer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SortedListManager {
    private final SortedListContainer container;

    public Data getListData(String word) {
        var start = System.nanoTime();
        var v =  container.binarySearch(word);
        var end = System.nanoTime();
        System.out.println(end - start);
        return new Data(v, end- start);
    }



    public void init() throws Exception {
        container.init();
    }

}