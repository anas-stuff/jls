package com.anas.javautils.jls.args;

import com.anas.javautils.jls.Main;
import org.apache.commons.cli.*;

import java.io.IOException;
import java.nio.file.Path;
import java.util.logging.Logger;

public class ArgumentProcessor {
    private final Options options;
    private CommandLine commandLine;
    private final Logger logger = Logger.getLogger(ArgumentProcessor.class.getName());
    private static ArgumentProcessor instance;

    private ArgumentProcessor() {
        options = new Options();
        setupOptions();
    }

    public static ArgumentProcessor getInstance() {
        if (instance == null)
            instance = new ArgumentProcessor();
        return instance;
    }

    private void setupOptions() {
        for (CLIOption cliOption : CLIOption.values()) {
            options.addOption(cliOption.getOption());
        }
    }

    public void process(String[] args) {
        try {
            commandLine = new DefaultParser(true).parse(options, args);
            if (commandLine.hasOption(CLIOption.HELP.getOption())) {
                printHelp();
                System.exit(0);
            } else if (commandLine.hasOption(CLIOption.VERSION.getOption())) {
                System.out.println(Main.version);
                System.exit(0);
            }
        } catch (ParseException e) {
            logger.severe("Error: " + e.getMessage());
            printHelp();
            System.exit(1);
        }
    }

    private void printHelp() {
        new HelpFormatter().printHelp("java -jar jls.jar", options);
    }

    public boolean hasOption(CLIOption option) {
        return commandLine.hasOption(option.getName());
    }

    public Path getTargetPath() {
        Path targetPath = null;
        if (commandLine.getArgs().length > 0) {
            try {
                targetPath = Path.of(commandLine.getArgs()[0]).toRealPath();
            } catch (IOException e) {
                logger.severe("Error: " + e.getMessage());
                System.exit(1);
            }
        } else {
            targetPath = Path.of(System.getProperty("user.dir"));
        }
        return targetPath;
    }
}
