package org.cruz.processor.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TextChange{
    private MakeNew make;

    public String makeTextChangeLower(String text) {
        String transformed = make.makeLowerText(text);
        return transformed;
    }
    public String makeTextChangeUpper(String text) {
        String transformed = make.makeUpperText(text);
        return transformed;
    }

}
