package com.ciu.ciuhomework_1.repository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
@Component
public class ListContainer {
    File[] files = new File("training").listFiles();
    PorterStemmer stemmer = new PorterStemmer();
    ArrayList<KeyValuePair> container = new ArrayList<>();
    //25531
    public void init() throws IOException {
        for(File file : files) {
            Set<String> words = getAllWordsFromFile(file);
            words.stream().filter(this::isNotStopWord).forEach(w -> {addToList(w, file.getName());});
        }
    }

    private boolean isNotStopWord(String word) {
        return !StopWords.stopWordsList.contains(word);
    }

    public void addToList(String word, String fileName) {
        KeyValuePair kp = new KeyValuePair(word);
        if(container.contains(kp)) {
            container.get(container.indexOf(kp)).values.add(fileName);
        }else {
            kp.values.add(fileName);
            container.add(kp);
        }
    }

    public ArrayList<String> searchWord(String word) {
        for (KeyValuePair kp : container) {
            if(kp.key.equals(word)) {
                return kp.values;
            }
        }
        return null;
    }

    private Set<String> getAllWordsFromFile(File file) throws IOException {
        char[] buffer = new char[1024];

        int charCount = 0;
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        StringBuilder builder = new StringBuilder();

        while ((charCount = bufferedReader.read(buffer)) != -1) {
            builder.append(buffer, 0, charCount);
        }
        bufferedReader.close();
        String fileContent = builder.toString().replaceAll("\\s+", " ");
        //Stemmer increase execute time but there is lest word in the map
        return Arrays.stream(fileContent.split(" ")).map(stemmer::stemWord).collect(Collectors.toSet());
    }
}
