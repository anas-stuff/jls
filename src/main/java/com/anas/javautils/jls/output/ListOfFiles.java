package com.anas.javautils.jls.output;

import com.anas.javautils.jls.args.ArgumentProcessor;
import com.anas.javautils.jls.args.CLIOption;
import com.anas.javautils.jls.utils.LongLength;

import java.io.IOException;

/**
 * "Prints the files in the target directory in either short or long format, depending on the command line arguments."
 *
 * The first thing we do is get the instance of the `ArgumentProcessor` class. This class is a singleton that holds the
 * command line arguments
 */
public class ListOfFiles {
    /**
     * "Prints the files in the target directory in either short or long format, depending on the command line arguments."
     *
     * The first thing we do is get the instance of the `ArgumentProcessor` class. This class is a singleton that holds the
     * command line arguments
     */
    public void printFiles() throws IOException {
        final var argumentProcessor = ArgumentProcessor.getInstance();

        FileInfo[] files = FilesHelper.getFiles(
                argumentProcessor.hasOption(CLIOption.ALL),
                argumentProcessor.getTargetPath()
        );

        if (argumentProcessor.hasOption(CLIOption.LONG)) {
            printLongFormat(files, argumentProcessor);
        } else {
            printShortFormat(files, argumentProcessor);
        }
    }

    // TODO: 6/9/22 Complete this method :')
    /**
     * It prints the short format of the files
     *
     * @param files The list of files to be printed
     * @param argumentProcessor The argument processor that contains the command line arguments.
     */
    private void printShortFormat(final FileInfo[] files,
                                  final ArgumentProcessor argumentProcessor) {
        // var terminalWidth = new TerminalScreen(new DefaultTerminalFactory().createTerminal())
        //       .getTerminalSize().getColumns();
        for (FileInfo file : files) {
            System.out.println(getShortFormat(file, argumentProcessor,
                    argumentProcessor.hasOption(CLIOption.SIZE)) + "\t");
        }
    }

    /**
     * It prints the files in a long format
     *
     * @param files The array of files to be printed.
     * @param argumentProcessor The argument processor.
     */
    private void printLongFormat(final FileInfo[] files,
                                 final ArgumentProcessor argumentProcessor) {
        final var length = new LongLength();

        final var IS_NO_COLORS = ArgumentProcessor.getInstance().hasOption(CLIOption.NO_COLORS);
        final var IS_HUMAN_READABLE = argumentProcessor.hasOption(CLIOption.HUMAN_READABLE);

        for (FileInfo file : files) {
            length.setLongFileNameLength(
                    (byte) Math.max(
                            length.getLongFileNameLength(), file.getName(!IS_NO_COLORS).length()
                    )
            );

            length.setLongDateLength(
                    (byte) Math.max(
                            length.getLongDateLength(), file.getCreationTime(!IS_NO_COLORS).length()
                    )
            );

            length.setLongSizeLength(
                    (byte) Math.max(
                            length.getLongSizeLength(), file.getSize(IS_HUMAN_READABLE, !IS_NO_COLORS).length()
                    )
            );

            length.setLongOwnerLength(
                    (byte) Math.max(
                            length.getLongOwnerLength(), file.getOwner(!IS_NO_COLORS).length()
                    )
            );

            length.setLongGroupLength(
                    (byte) Math.max(
                            length.getLongGroupLength(), file.getGroup(!IS_NO_COLORS).length()
                    )
            );
        }

        for (FileInfo file : files) {
            System.out.println(getLongFormat(file, argumentProcessor, length));
        }
    }

    /**
     * It returns a string that contains the file's information in the long format
     *
     * @param fileInfo FileInfo object
     * @param argumentProcessor The ArgumentProcessor object that contains all the arguments passed to the program.
     * @param length the length of the longest file name, owner name, group name, and date.
     * @return The long format of the file info.
     */
    private String getLongFormat(
            final FileInfo fileInfo,
            final ArgumentProcessor argumentProcessor,
            final LongLength length
    ) {
        final var IS_WITH_NO_COLORS = !argumentProcessor.hasOption(CLIOption.NO_COLORS);
        final var IS_NO_OWNER = argumentProcessor.hasOption(CLIOption.NO_OWNER);
        final var IS_PRINT_GROUP = argumentProcessor.hasOption(CLIOption.GROUP);
        final var IS_NO_DATE = argumentProcessor.hasOption(CLIOption.NO_DATE);
        final var IS_HUMAN_READABLE = argumentProcessor.hasOption(CLIOption.HUMAN_READABLE);
        final var IS_NO_PERMISSIONS = argumentProcessor.hasOption(CLIOption.NO_PERMISSIONS);

        String format = "%" + (!IS_NO_PERMISSIONS ? "10s " : "s") +
                "%" + -length.getLongSizeLength() + "s" +
                ((fileInfo.isDirectory() ? " " : "") + " %" +
                        (!IS_NO_OWNER ? (-length.getLongOwnerLength() + "s  ") : "s")) + "%" +
                (IS_PRINT_GROUP ? (-length.getLongGroupLength() + "s  ") : "s") + "%" +
                (!IS_NO_DATE ? (-length.getLongDateLength() + "s  ") : "s") + "%s";

        return String.format(format,
                !IS_NO_PERMISSIONS ? fileInfo.getPermissions(IS_WITH_NO_COLORS) : "",
                fileInfo.getSize(IS_HUMAN_READABLE, IS_WITH_NO_COLORS),
                !IS_NO_OWNER ? fileInfo.getOwner(IS_WITH_NO_COLORS) : "",
                IS_PRINT_GROUP ? fileInfo.getGroup(IS_WITH_NO_COLORS) : "",
                !IS_NO_DATE ? fileInfo.getCreationTime(IS_WITH_NO_COLORS) : "",
                getShortFormat(fileInfo, argumentProcessor, false)
        );

    }

    /**
     * It returns a string representation of a file info object
     *
     * @param fileInfo the file info object
     * @param argumentProcessor The ArgumentProcessor object that contains all the arguments passed to the program.
     * @param withSize if true, the size of the file will be displayed
     * @return A string that contains the file name, the file size, and the file type.
     */
    private String getShortFormat(
            final FileInfo fileInfo,
            final ArgumentProcessor argumentProcessor,
            final boolean withSize
    ) {
        final var IS_WITH_NO_COLORS = !argumentProcessor.hasOption(CLIOption.NO_COLORS);
        final var IS_HUMAN_READABLE = argumentProcessor.hasOption(CLIOption.HUMAN_READABLE);
        final var IS_NO_ICONS = argumentProcessor.hasOption(CLIOption.NO_ICONS);

        String format =
                (IS_NO_ICONS ? "%s" : "%-2s ") + "%s" +
                        (fileInfo.isSymlink() ? " -> %s" : "%s") +
                        (withSize ? "  %s" : "%s");

        return String.format(format,
                IS_NO_ICONS ? "" : (IS_WITH_NO_COLORS ?
                        fileInfo.getIcon().toString() : fileInfo.getIcon().getNoColoredIcon()),
                fileInfo.getName(IS_WITH_NO_COLORS),
                fileInfo.isSymlink() ? fileInfo.getSymlinkTarget(IS_WITH_NO_COLORS) : "",
                withSize ? fileInfo.getSize(IS_HUMAN_READABLE, IS_WITH_NO_COLORS) : ""
        );

    }
}
