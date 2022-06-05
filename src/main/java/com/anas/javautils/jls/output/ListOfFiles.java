package com.anas.javautils.jls.output;

import com.anas.javautils.jls.args.ArgumentProcessor;
import com.anas.javautils.jls.args.CLIOption;


import java.io.File;

public class ListOfFiles {
    public void printFiles(ArgumentProcessor argumentProcessor) {
        File[] files = new File(argumentProcessor.getTargetPath().toUri()).listFiles();
        for (File file : files) {
            FileInfo fileInfo = new FileInfo(file);
            if (argumentProcessor.hasOption(CLIOption.LONG)) {

            }
        }

    }
}
