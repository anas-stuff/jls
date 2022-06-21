package com.anas.javautils.jls.output;

import com.anas.javautils.jls.args.ArgumentProcessor;
import com.anas.javautils.jls.args.CLIOption;

import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;

public class FilesHelper {
    /**
     * It returns an array of FileInfo objects, which are basically just a wrapper around the Path class with some extra.
     *
     * @param includeHiddenFiles If true, hidden files will be included in the list.
     * @param targetPath The path to the directory you want to get the files from.
     * @return An array of FileInfo objects.
     */
    public static FileInfo[] getFiles(final boolean includeHiddenFiles, final Path targetPath) {
        ArrayList<FileInfo> files = new ArrayList<>();
        if (targetPath.toFile().isDirectory()) {
            var rowFiles = targetPath.toFile().listFiles();

            // It's checking if the array is not null and if it has at least one element.
            if (rowFiles != null && rowFiles.length > 0) {
                rowFiles = sort(rowFiles); // Sorting the files based on arguments, or by name if no arguments are specified.

                // It's iterating through the array of files.
                for (File file : rowFiles) {
                    /* It's checking if the file is hidden, and if it is, it's checking if the user wants to include hidden
                    files. */
                    if (!file.isHidden() || includeHiddenFiles) {
                        files.add(new FileInfo(file.toPath()));
                    }
                }
            }
        } else { // If the targetPath is not a directory, it's adding the targetPath as a single file.
            files.add(new FileInfo(targetPath));
        }
        return files.toArray(new FileInfo[0]);
    }

    /**
     * It sorts an array of files by name, size, or last modified date, based on arguments passed in.
     *
     * @param rowFiles The array of files to sort.
     * @return A sorted array of files.
     */
    private static File[] sort(final File[] rowFiles) {
        boolean SORT_BY_SIZE = ArgumentProcessor.getInstance().hasOption(CLIOption.SORT_BY_SIZE);
        boolean SORT_BY_LAST_MODIFIED = ArgumentProcessor.getInstance().hasOption(CLIOption.SORT_BY_LAST_MODIFIED);

        return Arrays.stream(rowFiles).sorted((o1, o2) -> {
            if (SORT_BY_SIZE) return compareSizes(o1, o2);

            else if (SORT_BY_LAST_MODIFIED) return compareLastModified(o1, o2);

            return o1.getName().compareTo(o2.getName());
        }).toArray(File[]::new);
    }

    /**
     * CompareSizes() compares the sizes of two files and returns the result as an integer.
     *
     * @param o1 The first file to compare.
     * @param o2 The second file to compare.
     * @return < 0 if o1 is smaller than o2, 0 if they are equal, > 0 if o1 is larger than o2.
     */
    private static int compareSizes(final File o1, final File o2) {
        return Long.compare(o1.length(), o2.length());
    }

    /**
     * It compares the last modified time of two files
     *
     * @param o1 The first file to compare.
     * @param o2 The second file to compare.
     * @return < 0 if the first file is older, 0 if they're equal, > 0 if the second file is older.
     */
    private static int compareLastModified(final File o1, final File o2) {
        return Long.compare(o1.lastModified(), o2.lastModified());
    }
}
