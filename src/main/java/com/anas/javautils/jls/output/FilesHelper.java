package com.anas.javautils.jls.output;

import com.anas.javautils.jls.args.ArgumentProcessor;
import com.anas.javautils.jls.args.CLIOption;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class FilesHelper {
    public static FileInfo[] getFiles(boolean includeHiddenFiles, Path targetPath) throws IOException {
        ArrayList<FileInfo> files = new ArrayList<>();
        if (targetPath.toFile().isDirectory()) {
            var rowFiles = targetPath.toFile().listFiles();
            if (rowFiles != null && rowFiles.length > 0) {
                rowFiles = sort(rowFiles);
                for (File file : rowFiles) {
                    if (file.isHidden() && !includeHiddenFiles) {
                        continue;
                    }
                    files.add(new FileInfo(file.toPath()));
                }
            }
        } else {
            files.add(new FileInfo(targetPath));
        }
        return files.toArray(new FileInfo[0]);
    }

    private static File[] sort(File[] rowFiles) {
        return Arrays.stream(rowFiles).sorted((o1, o2) -> {
            if (ArgumentProcessor.getInstance().hasOption(CLIOption.SORT_BY_SIZE)) {
                return Long.compare(o1.length(), o2.length());
            } else if (ArgumentProcessor.getInstance().hasOption(CLIOption.SORT_BY_LAST_MODIFIED)) {
                return Long.compare(o1.lastModified(), o2.lastModified());
            }
            return o1.getName().compareTo(o2.getName());
        }).toArray(File[]::new);
    }
}
