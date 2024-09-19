package org.cruz.processor.service;

import org.cruz.processor.service.impl.Transform;

public class MakeNew implements Transform {
    @Override
    public String makeLowerText(String text) {
        return text.toLowerCase();
    }

    @Override
    public String makeUpperText(String text) {
        return text.toUpperCase();
    }
}