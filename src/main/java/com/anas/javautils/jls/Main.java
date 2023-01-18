package com.anas.javautils.jls;

import com.anas.javautils.jls.args.ArgumentProcessor;
import com.anas.javautils.jls.output.ListOfFiles;

import java.io.IOException;

public class Main {
    public static final String version = "0.3.6";

    /**
     * The entry point :D
     * It creates an instance of the ArgumentProcessor class, which parses the command line arguments and stores them in a
     * map
     *
     * @param args The arguments passed to the program.
     */
    public static void main(final String[] args) {
        ArgumentProcessor.getInstance().process(args);
        try {
            new ListOfFiles().printFiles();
        } catch (IOException e) {
            e.printStackTrace(); // TODO: 6/21/22 Use a logger and the massage function.
        }
    }
}
