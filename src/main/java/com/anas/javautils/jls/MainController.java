package com.anas.javautils.jls;

import com.anas.javautils.jls.args.ArgumentProcessor;
import com.anas.javautils.jls.args.CLIOption;
import com.anas.javautils.jls.output.ListOfFiles;

import java.io.IOException;

public class MainController {
    private final ArgumentProcessor argumentProcessor;
    public static final String version = "1.0.0";
    public MainController(String[] args) {
        argumentProcessor = new ArgumentProcessor();
        argumentProcessor.process(args);
        try {
            new ListOfFiles().printFiles(argumentProcessor);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
