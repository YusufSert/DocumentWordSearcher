package com.ciu.ciuhomework_1.repository;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

@Component
public class MapContainer {
    PorterStemmer stemmer = new PorterStemmer();
    public Map<String, ArrayList<String>> wordMap = new HashMap<>();
     File[] files = new File("training").listFiles();
    public Map<String, ArrayList<String>> storeIntoMap() throws Exception {
        for(File file : files) {
            Set<String> words = getAllWordsFromFile(file);
            words.stream().filter(this::isNotStopWord).forEach(w -> addToMap(w, file.getName()));
            //words.forEach(w -> addToMap(w, file.getName()));
        }
        return wordMap;
    }

    private boolean isNotStopWord(String word) {
        return !StopWords.stopWordsList.contains(word);
    }
    private void addToMap(String word, String fileName) {
        if(wordMap.containsKey(word)) {
            wordMap.get(word).add(fileName);
        } else {
            ArrayList<String> fileList = new ArrayList<>();
            fileList.add(fileName);
            wordMap.put(word, fileList);
        }
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

    /*
    public void testList(String word) {
        for(int i = 0; i <= 33; i++) {
            wordList.add(new TreeSet<String>());
        }
        if (word.startsWith("a")) {
            wordList.get(0).add(word);
        }
        if (word.startsWith("b")) {
            wordList.get(1).add(word);
        }
        if (word.startsWith("c")) {
            wordList.get(2).add(word);
        }
        if (word.startsWith("d")) {
            wordList.get(3).add(word);
        }
        if (word.startsWith("e")) {
            wordList.get(4).add(word);
        }
        if (word.startsWith("f")) {
            wordList.get(5).add(word);
        }
        if (word.startsWith("g")) {
            wordList.get(6).add(word);
        }
        if (word.startsWith("h")) {
            wordList.get(7).add(word);
        }
        if (word.startsWith("ı")) {
            wordList.get(8).add(word);
        }
        if (word.startsWith("j")) {
            wordList.get(9).add(word);
        }
        if (word.startsWith("k")) {
            wordList.get(10).add(word);
        }
        if (word.startsWith("l")) {
            wordList.get(11).add(word);
        }
        if (word.startsWith("m")) {
            wordList.get(12).add(word);
        }
        if (word.startsWith("n")) {
            wordList.get(13).add(word);
        }
        if (word.startsWith("o")) {
            wordList.get(14).add(word);
        }
        if (word.startsWith("p")) {
            wordList.get(15).add(word);
        }
        if (word.startsWith("q")) {
            wordList.get(16).add(word);
        }
        if (word.startsWith("r")) {
            wordList.get(17).add(word);
        }
        if (word.startsWith("s")) {
            wordList.get(18).add(word);
        }
        if (word.startsWith("t")) {
            wordList.get(19).add(word);
        }
        if (word.startsWith("u")) {
            wordList.get(20).add(word);
        }
        if (word.startsWith("v")) {
            wordList.get(21).add(word);
        }
        if (word.startsWith("w")) {
            wordList.get(22).add(word);
        }
        if (word.startsWith("y")) {
            wordList.get(23).add(word);
        }
        if (word.startsWith("z")) {
            wordList.get(24).add(word);
        }
        if (word.startsWith("0")) {
            wordList.get(25).add(word);
        }
        if (word.startsWith("1")) {
            wordList.get(26).add(word);
        }
        if (word.startsWith("2")) {
            wordList.get(27).add(word);
        }
        if (word.startsWith("3")) {
            wordList.get(28).add(word);
        }
        if (word.startsWith("4")) {
            wordList.get(29).add(word);
        }
        if (word.startsWith("5")) {
            wordList.get(30).add(word);
        }
        if (word.startsWith("6")) {
            wordList.get(31).add(word);
        }
        if (word.startsWith("8")) {
            wordList.get(32).add(word);
        }
        if (word.startsWith("9")) {
            wordList.get(33).add(word);
        }
    }

     */

}
