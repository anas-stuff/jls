package com.anas.javautils.jls.args;

import com.anas.javautils.jls.Main;
import org.apache.commons.cli.*;

import java.io.IOException;
import java.nio.file.Path;
import java.util.logging.Logger;

/**
 * It processes the command line arguments and provides a convenient
 * way to access them
 */
public class ArgumentProcessor {
    // Singleton
    private static ArgumentProcessor instance;
    private final Options options;
    private final Logger logger = Logger.getLogger(ArgumentProcessor.class.getName());
    private CommandLine commandLine;

    // A private constructor.
    private ArgumentProcessor() {
        options = new Options();
        setupOptions();
    }

    /**
     * If the instance is null, create a new instance and return it. Otherwise, return the existing instance.
     *
     * @return The instance of the class.
     */
    public static ArgumentProcessor getInstance() {
        if (instance == null)
            instance = new ArgumentProcessor();
        return instance;
    }

    /**
     * It adds all the options defined in the enum to the options object
     */
    private void setupOptions() {
        for (CLIOption cliOption : CLIOption.values()) {
            options.addOption(cliOption.getOption());
        }
    }

    /**
     * If the user has specified the help or version option, print the help or version and exit. Otherwise, parse the
     * command line arguments
     *
     * @param args The command line arguments
     */
    public void process(final String[] args) {
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

    /**
     * Print the help message to the console.
     */
    private void printHelp() {
        new HelpFormatter().printHelp("java -jar jls.jar", options);
    }

    /**
     * Returns true if the command line has the option specified by the given CLIOption object.
     *
     * @param option The option to check for.
     * @return A boolean value.
     */
    public boolean hasOption(CLIOption option) {
        return commandLine.hasOption(option.getName());
    }

    /**
     * If the user didn't specify a target path, use the current working directory. Otherwise, use the path specified by
     * the user
     *
     * @return The target path.
     */
    // TODO: 6/21/22 Support multiple target paths.
    public Path getTargetPath() {
        Path targetPath = null;

        if (commandLine.getArgs().length == 0) {
            return Path.of(System.getProperty("user.dir"));
        }

        try {
            targetPath = Path.of(commandLine.getArgs()[0]).toRealPath();
        } catch (IOException e) {
            logger.severe("Error: " + e.getMessage());
            System.exit(1);
        }

        return targetPath;
    }
}
