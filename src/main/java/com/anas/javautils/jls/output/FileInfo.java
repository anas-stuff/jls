package com.anas.javautils.jls.output;

import com.anas.javautils.jls.utils.ColoredString;
import com.googlecode.lanterna.TextColor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.PosixFileAttributeView;
import java.nio.file.attribute.PosixFileAttributes;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class FileInfo {
    private final Path filePath;
    private PosixFileAttributes fileAttributes;

    public FileInfo(Path filePath) {
        this.filePath = filePath;
        try {
            this.fileAttributes = Files.getFileAttributeView(filePath, PosixFileAttributeView.class).readAttributes();
        } catch (IOException e) {
            this.fileAttributes = null;
        }
    }

    public String getPermissions(final boolean withColors) {
        // TODO: dynamically get the colors;
        var RColor = new TextColor.RGB(253, 188, 75);
        var WColor = new TextColor.RGB(192, 57, 43);
        var XColor = new TextColor.RGB(147, 154, 89);
        var color = new TextColor.RGB(61, 174, 233);
        var hithonColor = new TextColor.RGB(124, 124, 124);
        var sb = new StringBuilder();

        sb.append(new ColoredString(isDirectory() ? "d" : isSymlink() ? "l" : ".", color));

        var hithon = new ColoredString("-", hithonColor);

        ArrayList<String> permissions = new ArrayList<>();
        if (fileAttributes != null) {
            fileAttributes.permissions().forEach(permission -> {
                permissions.add(permission.name());
            });
        }

        var R = withColors ? new ColoredString("r", RColor) : "r";
        var W = withColors ? new ColoredString("w", WColor) : "w";
        var X = withColors ? new ColoredString("x", XColor) : "x";

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

    public String getSize(final boolean humanReadable,
                          final boolean withColor) {
        var strColor = new TextColor.RGB(124, 124, 124);
        var str = new ColoredString("-", strColor);

        if (!Files.isDirectory(filePath)) {
            var size = (float) (fileAttributes != null ? fileAttributes.size() : 0);
            var unit = "B";

            var color = new TextColor.RGB(28, 108, 117);

            if (humanReadable) {
                var calculation = calculateUnitNSize(size);
                unit = (String) calculation[0];
                size = (float) calculation[1];

                str = new ColoredString(String.format("%.2f %s", size, unit), color);
            } else {
                str = new ColoredString(String.format("%d %s", (int) size, unit), color);
            }
        }

        return withColor ? str.toString() : str.getNormalString();
    }

    public String getName() {
        return getName(false);
    }

    public String getName(final boolean withColor) {
        var strName = filePath.getFileName().toString();

        // TODO: dynamically get the colors;
        var color = new TextColor.RGB(150, 153, 91);

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

        return withColor ? str.toString() : str.getNormalString();
    }

    public Icon getIcon(final boolean withColor) {
        Icon icon = Icon.getCorrectIcon(getName());

        if (icon != null) return icon;

        return isDirectory() ? Icon.DIR : Icon.FILE;
    }

    public String getOwner(final boolean withColor) {
        // TODO: dynamically get the colors;
        var color = new TextColor.RGB(240, 179, 73);
        var str = new ColoredString(
                fileAttributes != null ? fileAttributes.owner().getName() : "----", color
        );

        return withColor ? str.toString() : str.getNormalString();
    }

    public String getGroup(final boolean withColor) {
        // TODO: dynamically get the colors;
        var color = new TextColor.RGB(240, 179, 73);
        var str = new ColoredString(
                fileAttributes != null ? fileAttributes.group().getName() : "------", color
        );

        return withColor ? str.toString() : str.getNormalString();
    }

    public PosixFileAttributes getFileAttributes() {
        return fileAttributes;
    }

    public boolean isDirectory() {
        return fileAttributes != null && fileAttributes.isDirectory();
    }

    public boolean isSymlink() {
        return Files.isSymbolicLink(filePath);
    }

    public String getSymlinkTarget() {
        return getSymlinkTarget(false);
    }

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
}
