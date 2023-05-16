package com.ciu.ciuhomework_1.repository;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
@Getter
public class KeyValuePair implements Comparable<KeyValuePair>{
    String key;
    ArrayList<String> values = new ArrayList<String>();

    KeyValuePair(String key) {
        this.key = key;
    }

    @Override
    public int hashCode() {
        return key.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        KeyValuePair kVp = (KeyValuePair) obj;
        return key.equals(kVp.getKey());
    }

    @Override
    public int compareTo(KeyValuePair o) {
        return getKey().compareTo(o.getKey());
    }
}
