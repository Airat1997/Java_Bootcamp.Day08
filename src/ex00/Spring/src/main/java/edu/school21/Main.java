package edu.school21;

import edu.school21.beans.printer.Printer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *         PreProcessor preProcessor = new PreProcessorToUpperImpl();
 *         Renderer renderer = new RendererErrImpl(preProcessor);
 *         PrinterWithPrefixImpl printer = new PrinterWithPrefixImpl(renderer);
 *         printer.setPrefix("Standard");
 *         printer.print("Standard");
 */

public class Main
{
    public static void main( String[] args )
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        Printer printer = context.getBean("printerWithErrLowerDate", Printer.class);
        printer.print("Hello!");

    }
}
