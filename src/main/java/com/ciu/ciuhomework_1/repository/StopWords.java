package com.ciu.ciuhomework_1.repository;

import lombok.Getter;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StopWords {
    public static List<String> stopWordsList = new ArrayList<>();

    static {
        try {
            getStopWords();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static void getStopWords() throws IOException {
        File file = new File("stopwords");
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String word;
        while ((word = reader.readLine()) != null) {
            stopWordsList.add(word);
        }
    }

}
