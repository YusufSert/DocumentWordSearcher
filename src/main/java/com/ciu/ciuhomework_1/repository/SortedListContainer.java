package com.ciu.ciuhomework_1.repository;


import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
@Component
public class SortedListContainer {
    ListContainer listContainer = new ListContainer();
    ArrayList<KeyValuePair> sortedList = listContainer.container;

    public void init() throws IOException {
        listContainer.init();
        Collections.sort(listContainer.container);
    }

    public ArrayList<String> binarySearch(String word) {
        int low = 0;
        int high = sortedList.size() - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            String guess = sortedList.get(mid).key;
            if (guess.equals(word)) {
                return sortedList.get(mid).values;
            }
            if (guess.compareTo(word) > 0) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return null;
    }

    public static void main(String[] args) throws IOException {
        SortedListContainer container = new SortedListContainer();
        container.init();
        var start = System.nanoTime();
        var t = container.binarySearch("yusuf");
        var end = System.nanoTime();
        System.out.println(end - start);
        System.out.println(t);
    }
}
