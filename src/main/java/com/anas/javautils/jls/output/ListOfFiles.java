package com.anas.javautils.jls.output;

import com.anas.javautils.jls.args.ArgumentProcessor;
import com.anas.javautils.jls.args.CLIOption;
import com.anas.javautils.jls.utils.LongLength;

import java.io.IOException;

/**
 * "Prints the files in the target directory in either short or long format, depending on the command line arguments."
 */
public class ListOfFiles {
    /**
     * "Prints the files in the target directory in either short or long format, depending on the command line arguments."
     *
     * The first thing we do is get the instance of the `ArgumentProcessor` class. This class is a singleton that holds the
     * command line arguments
     * @throws IOException If there is an error reading the files.
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
     * @param files             The list of files to be printed
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
     * @param files             The array of files to be printed.
     * @param argumentProcessor The argument processor.
     */
    private void printLongFormat(final FileInfo[] files,
                                 final ArgumentProcessor argumentProcessor) {
        final var length = new LongLength();

        final var IS_NO_COLORS = argumentProcessor.hasOption(CLIOption.NO_COLORS);
        final var IS_HUMAN_READABLE = argumentProcessor.hasOption(CLIOption.HUMAN_READABLE);
        final var WITH_TYPE = !argumentProcessor.hasOption(CLIOption.NO_TYPE);

        for (FileInfo file : files) {
            length.setLongFileNameLength(
                    (byte) Math.max(
                            length.getLongFileNameLength(), file.getName(!IS_NO_COLORS, WITH_TYPE).length()
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
     * @param fileInfo          FileInfo object
     * @param argumentProcessor The ArgumentProcessor object that contains all the arguments passed to the program.
     * @param length            the length of the longest file name, owner name, group name, and date.
     * @return The long format of the file info.
     */
    private String getLongFormat(
            final FileInfo fileInfo,
            final ArgumentProcessor argumentProcessor,
            final LongLength length
    ) {
        final var IS_WITH_NO_COLORS = !argumentProcessor.hasOption(CLIOption.NO_COLORS);
        final var WITH_OWNER = !argumentProcessor.hasOption(CLIOption.NO_OWNER);
        final var WITH_GROUP = !argumentProcessor.hasOption(CLIOption.GROUP);
        final var WITH_DATE = !argumentProcessor.hasOption(CLIOption.NO_DATE);
        final var WITH_PERMISSIONS = !argumentProcessor.hasOption(CLIOption.NO_PERMISSIONS);
        final var WITH_SIZE = !argumentProcessor.hasOption(CLIOption.NO_SIZE);

        final var HUMAN_READABLE = argumentProcessor.hasOption(CLIOption.HUMAN_READABLE);

        String format = ("%" + (WITH_PERMISSIONS ? "10s " : "s") + (fileInfo.isDirectory() ? " " : "")) +
                ("%" +  (WITH_SIZE ? -length.getLongSizeLength() + "s " : "s")) +
                ("%" + (WITH_OWNER ? (-length.getLongOwnerLength() + "s  ") : "s")) +
                ("%" + (WITH_GROUP ? (-length.getLongGroupLength() + "s  ") : "s")) +
                ("%" + (WITH_DATE ? (-length.getLongDateLength() + "s  ") : "s") + "%s");

        return String.format(format,
                WITH_PERMISSIONS ? fileInfo.getPermissions(IS_WITH_NO_COLORS) : "",
                WITH_SIZE ? fileInfo.getSize(HUMAN_READABLE, IS_WITH_NO_COLORS) : "",
                WITH_OWNER ? fileInfo.getOwner(IS_WITH_NO_COLORS) : "",
                WITH_GROUP ? fileInfo.getGroup(IS_WITH_NO_COLORS) : "",
                WITH_DATE ? fileInfo.getCreationTime(IS_WITH_NO_COLORS) : "",
                getShortFormat(fileInfo, argumentProcessor, false)
        );

    }

    /**
     * It returns a string representation of a file info object
     *
     * @param fileInfo          the file info object
     * @param argumentProcessor The ArgumentProcessor object that contains all the arguments passed to the program.
     * @param withSize          if true, the size of the file will be displayed
     * @return A string that contains the file name, the file size, and the file type.
     */
    private String getShortFormat(
            final FileInfo fileInfo,
            final ArgumentProcessor argumentProcessor,
            final boolean withSize
    ) {
        final var WITH_COLORS = !argumentProcessor.hasOption(CLIOption.NO_COLORS);
        final var HUMAN_READABLE = argumentProcessor.hasOption(CLIOption.HUMAN_READABLE);
        final var WITH_ICONS = !argumentProcessor.hasOption(CLIOption.NO_ICONS);
        final var WITH_TYPE = !argumentProcessor.hasOption(CLIOption.NO_TYPE);
        final var WITH_CONTENTS_COUNT = argumentProcessor.hasOption(CLIOption.CONTENTS_COUNT) &&
                fileInfo.isDirectory();

        String format = (WITH_ICONS ? "%-2s " : "%s") +
                        "%s" +
                        (fileInfo.isSymlink() ? " -> %s" : "%s") +
                        (withSize ? "  %s" : "%s") +
                        (WITH_CONTENTS_COUNT ? "  [%s]" : "%s");

        return String.format(format,
                WITH_ICONS ? fileInfo.getIcon(WITH_COLORS) : "",
                fileInfo.getName(WITH_COLORS, WITH_TYPE),
                fileInfo.isSymlink() ? fileInfo.getSymlinkTarget(WITH_COLORS) : "",
                withSize ? fileInfo.getSize(HUMAN_READABLE, WITH_COLORS) : "",
                WITH_CONTENTS_COUNT ? fileInfo.getContentsCount(WITH_COLORS) : ""
        );

    }
}
