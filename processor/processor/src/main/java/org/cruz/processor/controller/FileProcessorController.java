package org.cruz.processor.controller;

import lombok.AllArgsConstructor;
import org.cruz.processor.service.TextProcessingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@RequestMapping("/api/files")
@AllArgsConstructor
public class FileProcessorController {
    private final TextProcessingService fileProcessorService;
    @PostMapping("/upload")
    public ResponseEntity<String> processFile(@RequestParam("file") MultipartFile file) throws IOException {
        if (file.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("File is empty");
        }
        String processedText = fileProcessorService.processFile(file);

        return ResponseEntity.ok().body(processedText);

    }
}
