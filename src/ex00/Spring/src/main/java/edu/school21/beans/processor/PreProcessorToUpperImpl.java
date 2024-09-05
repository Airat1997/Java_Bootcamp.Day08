package edu.school21.beans.processor;

public class PreProcessorToUpperImpl implements PreProcessor {

    @Override
    public String processMessage(String s) {
        return s.toUpperCase();
    }
}
