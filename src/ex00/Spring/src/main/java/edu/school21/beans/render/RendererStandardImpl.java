package edu.school21.beans.render;

import edu.school21.beans.processor.PreProcessor;

public class RendererStandardImpl implements Renderer {

    private final PreProcessor processor;

    public RendererStandardImpl(PreProcessor processor) {
        this.processor = processor;
    }

    @Override
    public void render(String message) {
        System.out.println(processor.processMessage(message));
    }
}
