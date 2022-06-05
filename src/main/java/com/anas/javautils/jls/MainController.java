package com.anas.javautils.jls;

import com.anas.javautils.jls.args.ArgumentProcessor;
import com.anas.javautils.jls.args.CLIOption;
import com.anas.javautils.jls.output.ListOfFiles;

public class MainController {
    private final ArgumentProcessor argumentProcessor;
    public static final String version = "1.0.0";
    public MainController(String[] args) {
        argumentProcessor = new ArgumentProcessor();
        argumentProcessor.process(args);
        new ListOfFiles().printFiles(argumentProcessor);
    }
}
