package org.cruz.processor.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service
public class RedoText {

    public String processFile(MultipartFile file) throws IOException {
        String content = readFileContent(file);
        String mostUsedWord = findMostUsedWord(content);
        return surroundMostUsedWord(content, mostUsedWord);
    }

    private String readFileContent(MultipartFile file) throws IOException {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        }
        return content.toString();
    }

    private String findMostUsedWord(String content) {
        if (content == null || content.isEmpty()) {
            return content;
        }
        String[] words = content.split("\\W+");
        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            word = word.toLowerCase();
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
        return wordCount.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .get()
                .getKey();
    }

    private String surroundMostUsedWord(String content, String word) {
        return content.replaceAll("(?i)\\b" + word + "\\b", "foo" + word + "bar");
    }

//    public String processFile(MultipartFile file) throws IOException {
//        String content = new String(file.getBytes(), StandardCharsets.UTF_8);
//        Map<String, Long> wordCount = Arrays.stream(content.split("\\s+"))
//                .collect(Collectors.groupingBy(String::toLowerCase, Collectors.counting()));
//
//        String mostUsedWord = Collections.max(wordCount.entrySet(), Map.Entry.comparingByValue()).getKey();
//
//        return content.replaceAll("(?i)\\b" + Pattern.quote(mostUsedWord) + "\\b", "foo" + mostUsedWord + "bar");
//    }
}