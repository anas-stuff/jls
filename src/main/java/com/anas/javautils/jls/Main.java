package com.anas.javautils.jls;

import com.anas.javautils.jls.args.ArgumentProcessor;
import com.anas.javautils.jls.output.ListOfFiles;

import java.io.IOException;

public class Main {
    public static final String version = "0.3.2";

    public static void main(final String[] args) {
        ArgumentProcessor.getInstance().process(args);
        try {
            new ListOfFiles().printFiles();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
