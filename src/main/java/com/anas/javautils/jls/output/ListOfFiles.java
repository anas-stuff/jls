package com.anas.javautils.jls.output;

import com.anas.javautils.jls.args.ArgumentProcessor;
import com.anas.javautils.jls.args.CLIOption;
import com.anas.javautils.jls.utils.LongLength;

import java.io.IOException;

public class ListOfFiles {
    public void printFiles() throws IOException {
        var argumentProcessor = ArgumentProcessor.getInstance();

        FileInfo[] files = FilesHelper.getFiles(
                ArgumentProcessor.getInstance().hasOption(CLIOption.ALL),
                ArgumentProcessor.getInstance().getTargetPath()
        );

        if (argumentProcessor.hasOption(CLIOption.LONG)) {
            printLongFormat(files, argumentProcessor);
        } else {
            printShortFormat(files, argumentProcessor);
        }
    }

    // TODO: 6/9/22 Complete this method :')
    private void printShortFormat(final FileInfo[] files,
                                  final ArgumentProcessor argumentProcessor) {
        // var terminalWidth = new TerminalScreen(new DefaultTerminalFactory().createTerminal())
        //       .getTerminalSize().getColumns();
        for (FileInfo file : files) {
            System.out.println(getShortFormat(file, argumentProcessor, argumentProcessor.hasOption(CLIOption.SIZE)) + "\t");
        }
    }

    private void printLongFormat(final FileInfo[] files,
                                 final ArgumentProcessor argumentProcessor) {
        LongLength length = new LongLength();

        boolean IS_NO_COLORS = ArgumentProcessor.getInstance().hasOption(CLIOption.NO_COLORS);
        boolean IS_HUMAN_READABLE = argumentProcessor.hasOption(CLIOption.HUMAN_READABLE);

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

    private String getLongFormat(
            final FileInfo fileInfo,
            final ArgumentProcessor argumentProcessor,
            final LongLength length
    ) {
        var IS_WITH_NO_COLORS = !argumentProcessor.hasOption(CLIOption.NO_COLORS);
        var IS_NO_OWNER = argumentProcessor.hasOption(CLIOption.NO_OWNER);
        var IS_PRINT_GROUP = argumentProcessor.hasOption(CLIOption.GROUP);
        var IS_NO_DATE = argumentProcessor.hasOption(CLIOption.NO_DATE);
        var IS_HUMAN_READABLE = argumentProcessor.hasOption(CLIOption.HUMAN_READABLE);

        String format = "%10s  " + "%" + -length.getLongSizeLength() + "s" +
                ((fileInfo.isDirectory() ? " " : "") + " %" +
                        (!IS_NO_OWNER ? (-length.getLongOwnerLength() + "s  ") : "s")) + "%" +
                (IS_PRINT_GROUP ? (-length.getLongGroupLength() + "s  ") : "s") + "%" +
                (!IS_NO_DATE ? (-length.getLongDateLength() + "s  ") : "s") + "%s";

        return String.format(format,
                fileInfo.getPermissions(IS_WITH_NO_COLORS),
                fileInfo.getSize(IS_HUMAN_READABLE, IS_WITH_NO_COLORS),
                !IS_NO_OWNER ? fileInfo.getOwner(IS_WITH_NO_COLORS) : "",
                IS_PRINT_GROUP ? fileInfo.getGroup(IS_WITH_NO_COLORS) : "",
                !IS_NO_DATE ? fileInfo.getCreationTime(IS_WITH_NO_COLORS) : "",
                getShortFormat(fileInfo, argumentProcessor, false)
        );

    }

    private String getShortFormat(
            final FileInfo fileInfo,
            final ArgumentProcessor argumentProcessor,
            final boolean withSize
    ) {
        var IS_WITH_NO_COLORS = !argumentProcessor.hasOption(CLIOption.NO_COLORS);
        var IS_HUMAN_READABLE = argumentProcessor.hasOption(CLIOption.HUMAN_READABLE);
        var IS_NO_ICONS = argumentProcessor.hasOption(CLIOption.NO_ICONS);

        String format =
                (IS_NO_ICONS ? "%s" : "%-2s ") + "%s" +
                        (fileInfo.isSymlink() ? " -> %s" : "%s") +
                        (withSize ? "  %s" : "%s");

        return String.format(format,
                IS_NO_ICONS ? "" : fileInfo.getIcon(IS_WITH_NO_COLORS),
                fileInfo.getName(IS_WITH_NO_COLORS),
                fileInfo.isSymlink() ? fileInfo.getSymlinkTarget(IS_WITH_NO_COLORS) : "",
                withSize ? fileInfo.getSize(IS_HUMAN_READABLE, IS_WITH_NO_COLORS) : ""
        );

    }
}
