package com.anas.javautils.jls.output;

import com.anas.javautils.jls.args.ArgumentProcessor;
import com.anas.javautils.jls.args.CLIOption;

public class ListOfFiles {
    public void printFiles(ArgumentProcessor argumentProcessor) {
        FileInfo[] files = FilesHelper.getFiles(argumentProcessor.hasOption(CLIOption.ALL),
                argumentProcessor.getTargetPath());

        for (FileInfo file : files) {
            System.out.println(file.getLongFormat(true, false, true));
        }


    }
}
