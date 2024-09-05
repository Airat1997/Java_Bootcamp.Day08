package edu.school21.beans.render;

import edu.school21.beans.processor.PreProcessor;

public class RendererErrImpl implements Renderer {
    private final PreProcessor processor;

    public RendererErrImpl(PreProcessor processor) {
        this.processor = processor;
    }

    @Override
    public void render(String message) {
        System.err.println(processor.processMessage(message));
    }
}
