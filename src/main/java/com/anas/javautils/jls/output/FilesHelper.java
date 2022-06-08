package com.anas.javautils.jls.output;

import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;

public class FilesHelper {
    public static FileInfo[] getFiles(boolean includeHiddenFiles, Path targetPath) {
        ArrayList<FileInfo> files = new ArrayList<>();
        if (targetPath.toFile().isDirectory()) {
            for (File file : targetPath.toFile().listFiles()) {
                if (file.isHidden() && !includeHiddenFiles) {
                    continue;
                }
                files.add(new FileInfo(file.toPath()));
            }
        } else {
            files.add(new FileInfo(targetPath));
        }
        return files.toArray(new FileInfo[0]);
    }
}
