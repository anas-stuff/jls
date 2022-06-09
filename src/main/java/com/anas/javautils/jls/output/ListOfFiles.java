package com.anas.javautils.jls.output;

import com.anas.javautils.jls.args.ArgumentProcessor;
import com.anas.javautils.jls.args.CLIOption;
import com.anas.javautils.jls.utils.LongLength;

import java.io.IOException;

public class ListOfFiles {
    public void printFiles() throws IOException {
        var argumentProcessor = ArgumentProcessor.getInstance();
        FileInfo[] files = FilesHelper.getFiles(ArgumentProcessor.getInstance().hasOption(CLIOption.ALL),
                ArgumentProcessor.getInstance().getTargetPath());

        if (argumentProcessor.hasOption(CLIOption.LONG)) {
            printLongFormat(files, argumentProcessor);
        } else {
            printShortFormat(files, argumentProcessor);
        }
    }

    // TODO: 6/9/22 Complete this method :')
    private void printShortFormat(final FileInfo[] files, final ArgumentProcessor argumentProcessor) {
        // var terminalWidth = new TerminalScreen(new DefaultTerminalFactory().createTerminal())
        //       .getTerminalSize().getColumns();
        for (FileInfo file : files) {
            System.out.println(getShortFormat(file, argumentProcessor,argumentProcessor.hasOption(CLIOption.SIZE)) + "\t");
        }
    }

    private void printLongFormat(final FileInfo[] files, final ArgumentProcessor argumentProcessor) {
        LongLength length = new LongLength();

        for (FileInfo file : files) {
            length.setLongFileNameLength(
                    (byte) Math.max(length.getLongFileNameLength(), file.getName(
                            !ArgumentProcessor.getInstance().hasOption(CLIOption.NO_COLORS)).length()));
            length.setLongDateLength(
                    (byte) Math.max(length.getLongDateLength(), file.getCreationTime(
                            !ArgumentProcessor.getInstance().hasOption(CLIOption.NO_COLORS)).length()));
            length.setLongSizeLength(
                    (byte) Math.max(length.getLongSizeLength(),
                            file.getSize(argumentProcessor.hasOption(CLIOption.HUMAN_READABLE),
                                    !ArgumentProcessor.getInstance().hasOption(CLIOption.NO_COLORS)).length()));
            length.setLongOwnerLength(
                    (byte) Math.max(length.getLongOwnerLength(), file.getOwner(
                            !ArgumentProcessor.getInstance().hasOption(CLIOption.NO_COLORS)).length()));
            length.setLongGroupLength(
                    (byte) Math.max(length.getLongGroupLength(), file.getGroup(
                            !ArgumentProcessor.getInstance().hasOption(CLIOption.NO_COLORS)).length()));
        }

        for (FileInfo file : files) {
            System.out.println(getLongFormat(file, argumentProcessor, length));
        }
    }

    private String getLongFormat(final FileInfo fileInfo,
                                 final ArgumentProcessor argumentProcessor, final LongLength length) {
        var withColors = !argumentProcessor.hasOption(CLIOption.NO_COLORS);
        String format = "%10s  " + "%" + -length.getLongSizeLength() + "s" +
                ((fileInfo.isDirectory()? " " : "")  + " %" + (!argumentProcessor.hasOption(CLIOption.NO_OWNER) ?
                        (-length.getLongOwnerLength() + "s  ") : "s")) +
                "%" + (argumentProcessor.hasOption(CLIOption.GROUP) ? (-length.getLongGroupLength() + "s  ") : "s") +
                "%" + (!argumentProcessor.hasOption(CLIOption.NO_DATE) ? (-length.getLongDateLength() + "s  ") : "s") +
                "%s";
        return String.format(format,

                fileInfo.getPermissions(),
                fileInfo.getSize(argumentProcessor.hasOption(CLIOption.HUMAN_READABLE), withColors),
                (!argumentProcessor.hasOption(CLIOption.NO_OWNER) ? fileInfo.getOwner(withColors) : ""),
                (argumentProcessor.hasOption(CLIOption.GROUP) ? fileInfo.getGroup(withColors) : ""),
                (!argumentProcessor.hasOption(CLIOption.NO_DATE) ? fileInfo.getCreationTime(withColors) : ""),
                getShortFormat(fileInfo, argumentProcessor, false));

    }

    private String getShortFormat(final FileInfo fileInfo,
                                  final ArgumentProcessor argumentProcessor, final boolean withSize) {
        var withColors = !argumentProcessor.hasOption(CLIOption.NO_COLORS);
        return String.format((argumentProcessor.hasOption(CLIOption.NO_ICONS) ? "%s" : "%-2s ") + "%s"
                + (fileInfo.isSymlink() ? " -> %s" : "%s") + (withSize ? "  %s" : "%s"),
                (argumentProcessor.hasOption(CLIOption.NO_ICONS)? "" : fileInfo.getIcon(withColors)),
                fileInfo.getName(withColors),
                fileInfo.isSymlink() ? fileInfo.getSymlinkTarget(withColors) : "",
                (withSize ? fileInfo.getSize(argumentProcessor.hasOption(CLIOption.HUMAN_READABLE), withColors) : ""));

    }
}
