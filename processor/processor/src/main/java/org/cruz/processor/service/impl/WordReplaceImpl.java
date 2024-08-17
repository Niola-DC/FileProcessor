package org.cruz.processor.service.impl;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Component
public class WordReplaceImpl implements TextProcessor {

    @Override
    public String processText(String content) {
        Map<String, Long> wordCount = Arrays.stream(content.split("\\s+"))
                .collect(Collectors.groupingBy(String::toLowerCase, Collectors.counting()));
        String mostUsedWord = Collections.max(wordCount.entrySet(), Map.Entry.comparingByValue()).getKey();

        return content.replaceAll("(?i)\\b" + Pattern.quote(mostUsedWord) + "\\b", "foo" + mostUsedWord + "bar");
    }
}
