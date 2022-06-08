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

    private void printShortFormat(final FileInfo[] files, final ArgumentProcessor argumentProcessor) {
        for (FileInfo file : files) {
            System.out.print(getShortFormat(file, argumentProcessor) + "\t\t");
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
        String format = "%10s\t" + "%" + -length.getLongSizeLength() + "s\t\t" +
                "%" + (!argumentProcessor.hasOption(CLIOption.NO_OWNER) ? (length.getLongOwnerLength() + "s\t") : "s") +
                "%" + (argumentProcessor.hasOption(CLIOption.GROUP) ? (length.getLongGroupLength() + "s\t") : "s") +
                "%" + (!argumentProcessor.hasOption(CLIOption.NO_DATE) ? (length.getLongDateLength() + "s\t") : "s") +
                "%s";
        return String.format(format,

                fileInfo.getPermissions(),
                fileInfo.getSize(argumentProcessor.hasOption(CLIOption.HUMAN_READABLE), withColors),
                (!argumentProcessor.hasOption(CLIOption.NO_OWNER) ? fileInfo.getOwner(withColors) : ""),
                (argumentProcessor.hasOption(CLIOption.GROUP) ? fileInfo.getGroup(withColors) : ""),
                (!argumentProcessor.hasOption(CLIOption.NO_DATE) ? fileInfo.getCreationTime(withColors) : ""),
                getShortFormat(fileInfo, argumentProcessor));

    }

    private String getShortFormat(final FileInfo fileInfo, ArgumentProcessor argumentProcessor) {
        var withColors = !argumentProcessor.hasOption(CLIOption.NO_COLORS);
        return String.format((argumentProcessor.hasOption(CLIOption.NO_ICONS) ? "%s" : "%-2s ") + "%s",
                (argumentProcessor.hasOption(CLIOption.NO_ICONS)? "" : fileInfo.getIcon(withColors)),
                fileInfo.getName(withColors));

    }
}
