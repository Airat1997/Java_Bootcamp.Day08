package edu.school21.beans.processor;

public class PreProcessorToLower implements PreProcessor {

    @Override
    public String processMessage(String s) {
        return s.toLowerCase();
    }
}
