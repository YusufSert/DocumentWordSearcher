package com.ciu.ciuhomework_1;

import com.ciu.ciuhomework_1.repository.PorterStemmer;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class WordBuilder {
    public static void main(String[] args) throws Exception {
        Map<String, LinkedList<String>> wordMap = new HashMap<>();
        File[] files = new File("training").listFiles();
        PorterStemmer stemmer = new PorterStemmer();
        char[] buffer = new char[1024];


        for(File f : files) {

            int charCount = 0;
            BufferedReader bufferedReader = new BufferedReader(new FileReader(f));
            StringBuilder builder = new StringBuilder();

            while ((charCount = bufferedReader.read(buffer)) != -1) {
                builder.append(buffer, 0, charCount);
            }



            String fileContent = builder.toString().replaceAll("\\s+", " ");
            //Stemmer increase execute time but there is lest word in the map
            Set<String> words = Arrays.stream(fileContent.split(" ")).map(stemmer::stemWord).collect(Collectors.toSet());

            for(String word : words) {
                if(wordMap.containsKey(word)) {
                    wordMap.get(word).add(f.getName());
                } else {
                    LinkedList<String> fileList = new LinkedList<>();
                    fileList.add(f.getName());
                    wordMap.put(word, fileList);
                }
            }
            bufferedReader.close();
        }
    }
}
