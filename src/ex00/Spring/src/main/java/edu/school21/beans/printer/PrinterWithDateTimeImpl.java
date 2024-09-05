package edu.school21.beans.printer;

import edu.school21.beans.render.Renderer;
import java.time.LocalDateTime;

public class PrinterWithDateTimeImpl implements Printer {
    private final Renderer renderer;

    public PrinterWithDateTimeImpl(Renderer renderer) {
        this.renderer = renderer;
    }

    @Override
    public void print(String s) {
        renderer.render(LocalDateTime.now()+ " " + s);
    }
}
