package org.cruz.processor.service;

import lombok.AllArgsConstructor;
import org.cruz.processor.service.impl.TextProcessor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Service
@AllArgsConstructor
public class TextProcessingService {

    private final TextProcessor textProcessor;

    public String processFile(MultipartFile file) throws IOException {
        String content = new String(file.getBytes(), StandardCharsets.UTF_8);
        return textProcessor.processText(content);
    }
}
