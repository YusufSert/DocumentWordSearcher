package com.ciu.ciuhomework_1.business;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
@Service
public class DocumentManager {
     public String getAllWordsFromFile(String fileName) throws IOException {
        char[] buffer = new char[1024];

        File file = new File("training/" + fileName);
        int charCount = 0;
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        StringBuilder builder = new StringBuilder();

        while ((charCount = bufferedReader.read(buffer)) != -1) {
            builder.append(buffer, 0, charCount);
        }
        bufferedReader.close();
        return builder.toString();
    }
}
