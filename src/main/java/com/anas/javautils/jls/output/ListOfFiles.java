package com.anas.javautils.jls.output;

import com.anas.javautils.jls.args.ArgumentProcessor;
import com.anas.javautils.jls.args.CLIOption;
import com.anas.javautils.jls.utils.LongLength;

import java.io.IOException;

public class ListOfFiles {
    public void printFiles(ArgumentProcessor argumentProcessor) throws IOException {
        FileInfo[] files = FilesHelper.getFiles(argumentProcessor.hasOption(CLIOption.ALL),
                argumentProcessor.getTargetPath());

        if (argumentProcessor.hasOption(CLIOption.LONG)) {
            printLongFormat(argumentProcessor, files);
        } else {
            printShortFormat(argumentProcessor, files);
        }
    }

    private void printShortFormat(ArgumentProcessor argumentProcessor, FileInfo[] files) {
        for (FileInfo file : files) {
            System.out.println(getShortFormat(argumentProcessor, file));
        }
    }

    private void printLongFormat(ArgumentProcessor argumentProcessor, FileInfo[] files) {
        LongLength length = new LongLength();

        for (FileInfo file : files) {
            length.setLongFileNameLength(
                    (byte) Math.max(length.getLongFileNameLength(), file.getName(false).length()));
            length.setLongDateLength(
                    (byte) Math.max(length.getLongDateLength(), file.getCreationTime(false).length()));
            length.setLongSizeLength(
                    (byte) Math.max(length.getLongSizeLength(),
                            file.getSize(argumentProcessor.hasOption(CLIOption.HUMAN_READABLE),
                                    false).length()));
            length.setLongOwnerLength(
                    (byte) Math.max(length.getLongOwnerLength(), file.getOwner(false).length()));
            length.setLongGroupLength(
                    (byte) Math.max(length.getLongGroupLength(), file.getGroup(false).length()));
        }

        for (FileInfo file : files) {
            System.out.println(getLongFormat(file, argumentProcessor, length));
        }
    }

    private String getLongFormat(FileInfo fileInfo, ArgumentProcessor argumentProcessor, LongLength length) {
        var withColors = !argumentProcessor.hasOption(CLIOption.NO_COLORS);
        return String.format("%10s\t" + "%" + length.getLongSizeLength() + "s\t" +
                "%" + (!argumentProcessor.hasOption(CLIOption.NO_OWNER) ? (length.getLongOwnerLength() + "s\t") : "s") +
                "%" + (argumentProcessor.hasOption(CLIOption.GROUP) ? (length.getLongGroupLength() + "s\t") : "s") +
                "%" + (!argumentProcessor.hasOption(CLIOption.NO_DATE) ? (length.getLongDateLength() + "s\t") : "s") +
                "%s",

                fileInfo.getPermissions(),
                fileInfo.getSize(argumentProcessor.hasOption(CLIOption.HUMAN_READABLE), withColors),
                (!argumentProcessor.hasOption(CLIOption.NO_OWNER) ? fileInfo.getOwner(withColors) : ""),
                (argumentProcessor.hasOption(CLIOption.GROUP) ? fileInfo.getGroup(withColors) : ""),
                (!argumentProcessor.hasOption(CLIOption.NO_DATE) ? fileInfo.getCreationTime(withColors) : ""),
                getShortFormat(argumentProcessor, fileInfo));

    }

    private String getShortFormat(ArgumentProcessor argumentProcessor, FileInfo fileInfo) {
        var withColors = !argumentProcessor.hasOption(CLIOption.NO_COLORS);
        return String.format((argumentProcessor.hasOption(CLIOption.NO_ICONS) ? "%s" : "%-2s ") + "%s",
                (argumentProcessor.hasOption(CLIOption.NO_ICONS)? "" : fileInfo.getIcon(withColors)),
                fileInfo.getName(withColors));

    }
}
