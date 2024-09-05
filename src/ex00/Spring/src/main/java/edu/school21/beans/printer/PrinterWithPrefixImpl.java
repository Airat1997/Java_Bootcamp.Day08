package edu.school21.beans.printer;

import edu.school21.beans.render.Renderer;

public class PrinterWithPrefixImpl implements Printer {

    private final Renderer renderer;
    private String prefix;

    public PrinterWithPrefixImpl(Renderer renderer) {
        this.renderer = renderer;
    }


    @Override
    public void print(String s) {
        renderer.render(prefix + " " + s);
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }
}
