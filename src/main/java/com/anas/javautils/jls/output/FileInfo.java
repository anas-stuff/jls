package com.anas.javautils.jls.output;

import com.anas.jcolorfulconsole.ColoredString;
import com.anas.jcolorfulconsole.lanterna.TextColor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.PosixFileAttributeView;
import java.nio.file.attribute.PosixFileAttributes;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * it represents a file info.
 *
 * The class has a constructor that takes a `Path` object and tries to get the file attributes. If it fails, it sets the
 * `fileAttributes` variable to `null`, but some functions will still work.
 */
public class FileInfo {
    private final Path filePath;
    private PosixFileAttributes fileAttributes;

    /**
     * A constructor that takes a `Path` object and tries to get the file attributes. If it fails, it sets the
     * @param filePath The path to the file
     */
    public FileInfo(Path filePath) {
        this.filePath = filePath;
        try {
            this.fileAttributes = Files.getFileAttributeView(filePath, PosixFileAttributeView.class).readAttributes();
        } catch (IOException e) {
            this.fileAttributes = null;
        }
    }

    /**
     * It returns a string containing the permissions of the file, with colors if the `withColors` parameter is true
     *
     * @param withColors if true, the output will be colored.
     * @return A string that represents the permissions of the file.
     */
    public String getPermissions(final boolean withColors) {
        // TODO: dynamically get the colors;
        var RColor = withColors ?  new TextColor.RGB(253, 188, 75) : null;
        var WColor = withColors ? new TextColor.RGB(192, 57, 43) : null;
        var XColor = withColors ? new TextColor.RGB(147, 154, 89) : null;
        var color = withColors ? new TextColor.RGB(61, 174, 233) : null;
        var hithonColor = withColors ? new TextColor.RGB(124, 124, 124) : null;
        var sb = new StringBuilder();

        sb.append(new ColoredString(isDirectory() ? "d" : isSymlink() ? "l" : ".", color));

        var hithon = new ColoredString("-", hithonColor);

        ArrayList<String> permissions = new ArrayList<>();
        if (fileAttributes != null) {
            fileAttributes.permissions().forEach(permission -> {
                permissions.add(permission.name());
            });
        }

        var R = new ColoredString("r", RColor);
        var W = new ColoredString("w", WColor);
        var X = new ColoredString("x", XColor);

        sb.append(permissions.contains("OWNER_READ") ? R : hithon)
                .append(permissions.contains("OWNER_WRITE") ? W : hithon)
                .append(permissions.contains("OWNER_EXECUTE") ? X : hithon)
                // Group permissions
                .append(permissions.contains("GROUP_READ") ? R : hithon)
                .append(permissions.contains("GROUP_WRITE") ? W : hithon)
                .append(permissions.contains("GROUP_EXECUTE") ? X : hithon)
                // Others permissions
                .append(permissions.contains("OTHERS_READ") ? R : hithon)
                .append(permissions.contains("OTHERS_WRITE") ? W : hithon)
                .append(permissions.contains("OTHERS_EXECUTE") ? X : hithon);
        return sb.toString();
    }

    /**
     * > It converts the given size to the appropriate unit and returns the unit and the size in that unit
     *
     * @param size The size of the file in bytes.
     * @return An array of objects.
     */
    private Object[] calculateUnitNSize(float size) {
        var unit = "B";
        if (size >= 1024) {
            size = size / 1024; // Convert to KB
            unit = "KB";

            if (size >= 1024) {
                size = size / 1024; // Convert to MB
                unit = "MB";

                if (size >= 1024) {
                    size = size / 1024; // Convert to GB
                    unit = "GB";

                    if (size >= 1024) {
                        size = size / 1024; // Convert to TB
                        unit = "TB";
                    }
                }
            }
        }

        return new Object[]{unit, size};
    }

    /**
     * It returns the size of the file as a string, with colors if the `withColors` parameter is true
     *
     * @param humanReadable If true, the size will be displayed in a human readable format.
     * @param withColor If true, the string will be colored.
     * @return The size of the file as a string. If the `humanReadable` parameter is true, the size will be displayed in a human readable format.
     */
    public String getSize(final boolean humanReadable,
                          final boolean withColor) {
        final var strColor = new TextColor.RGB(124, 124, 124);
        var str = new ColoredString("-", strColor);

        if (!Files.isDirectory(filePath)) {
            var size = (float) (fileAttributes != null ? fileAttributes.size() : 0);
            var unit = "B";
            final var color = new TextColor.RGB(28, 108, 117);

            if (humanReadable) {
                final var calculation = calculateUnitNSize(size);
                unit = (String) calculation[0];
                size = (float) calculation[1];

                str = new ColoredString(String.format("%.2f %s", size, unit), color);
            } else {
                str = new ColoredString(String.format("%d %s", (int) size, unit), color);
            }
        }
        return withColor ? str.toString() : str.toNormalStringString();
    }

    /**
     * Returns the name of the current file.
     *
     * @return The name of the current file.
     */
    public String getName() {
        return getName(false, true);
    }


    /**
     * > This function returns the name of the file, with or without the file extension, and with or without color
     *
     * @param withColor whether or not to color the name
     * @param WITH_TYPE if true, the file name will be returned with the file extension.
     * @return A string representing the name of the file.
     */
    public String getName(final boolean withColor, boolean WITH_TYPE) {
        var strName = filePath.getFileName().toString();

        if (!WITH_TYPE) {
            strName = strName.substring(0, strName.lastIndexOf(".") == -1 ?
                    strName.length() : strName.lastIndexOf("."));
        }

        // TODO: dynamically get the colors;
        final var color = new TextColor.RGB(150, 153, 91);

        return withColor ? new ColoredString(strName, color).toString() : strName;
    }

    public String getCreationTime(final boolean withColor) {
        // TODO: dynamically get the colors;
        var color = new TextColor.RGB(29, 153, 243);

        // TODO: Simplify
        String date = new SimpleDateFormat("MMM d HH:mm")
                .format(
                        fileAttributes != null ? fileAttributes.creationTime().toMillis() : System.currentTimeMillis()
                );

        var str = new ColoredString(date, color);

        return withColor ? str.toString() : str.toNormalStringString();
    }

    /**
     * "If the file has an icon, return it, otherwise return the default icon for the file type."
     *
     * The first line of the function calls the static method `Icon.getCorrectIcon(String)` to get the icon for the file.
     * If the file has an icon, the method returns it. If the file doesn't have an icon, the method returns `null`
     *
     * @return The icon for the file.
     */
    public Icon getIcon() {
        Icon icon = Icon.getCorrectIcon(getName());

        if (icon != null) return icon;

        return isDirectory() ? Icon.DIR : Icon.FILE;
    }

    /**
     * It returns the owner of the file, with or without color
     *
     * @param withColor whether to return the string with color or not.
     * @return The owner of the file.
     */
    public String getOwner(final boolean withColor) {
        // TODO: dynamically get the colors;
        var color = new TextColor.RGB(240, 179, 73);
        var str = new ColoredString(
                fileAttributes != null ? fileAttributes.owner().getName() : "----", color
        );

        return withColor ? str.toString() : str.toNormalStringString();
    }

    /**
     * It returns the group of the file, with or without color
     *
     * @param withColor whether to return the string with color.
     * @return The group name of the file.
     */
    public String getGroup(final boolean withColor) {
        // TODO: dynamically get the colors;
        var color = new TextColor.RGB(240, 179, 73);
        var str = new ColoredString(
                fileAttributes != null ? fileAttributes.group().getName() : "------", color
        );

        return withColor ? str.toString() : str.toNormalStringString();
    }

    /**
     * This function returns the posix permissions of the file.
     *
     * @return The file attributes of the file.
     */
    public PosixFileAttributes getFileAttributes() {
        return fileAttributes;
    }

    /**
     * If the fileAttributes object is not null and the fileAttributes object is a directory, then return true.
     *
     * @return A boolean value, true if the file is a directory.
     */
    public boolean isDirectory() {
        return fileAttributes != null && fileAttributes.isDirectory();
    }

    /**
     * Returns true if the file is a symbolic link.
     *
     * @return A boolean value indicating whether the file is a symbolic link.
     */
    public boolean isSymlink() {
        return Files.isSymbolicLink(filePath);
    }

    /**
     * "If the file is a symlink, return the target of the symlink. Otherwise, return the empty string."
     *
     * The function is a bit more complicated than that, but that's the gist of it
     *
     * @return The target of the symbolic link, without color.
     */
    public String getSymlinkTarget() {
        return getSymlinkTarget(false);
    }

    /**
     * It returns the target of a symlink
     *
     * @param withColors If true, the target will be colored.
     * @return The target of the symlink.
     */
    public String getSymlinkTarget(final boolean withColors) {

        if (!isSymlink()) return "";

        try {
            var target = Files.readSymbolicLink(filePath);

            // TODO: dynamically get the colors;
            var color = new TextColor.RGB(240, 179, 73);

            return withColors ? new ColoredString(target.toFile().getName(), color).toString() : target.toFile().getName();

        } catch (IOException e) {
            // TODO: Log the error;
            return "";
        }
    }

    public String getIcon(boolean withColors) {
        final var icon = getIcon();
        return withColors ? icon.toString() : icon.getNoColoredIcon();
    }
}
