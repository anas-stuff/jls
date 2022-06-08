package com.anas.javautils.jls.output;

import com.anas.javautils.jls.utils.ColoredString;
import com.googlecode.lanterna.TextColor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.AttributeView;
import java.nio.file.attribute.PosixFileAttributeView;
import java.nio.file.attribute.PosixFileAttributes;
import java.util.ArrayList;

public class FileInfo {
    private final Path filePath;
    private final PosixFileAttributes fileAttributes;

    public FileInfo(Path filePath) throws IOException {
        this.filePath = filePath;
        this.fileAttributes = Files.getFileAttributeView(filePath, PosixFileAttributeView.class).readAttributes();
    }

    public String getPermissions() {
        var sb = new StringBuilder();
        sb.append(new ColoredString(Files.isDirectory(filePath) ? "d" : Files.isSymbolicLink(filePath) ? "l" : ".",
                new TextColor.RGB(61, 174, 233)));
        var hithon = new ColoredString("-", new TextColor.RGB(124, 124, 124));
        ArrayList<String> permissions = new ArrayList<>();
        fileAttributes.permissions().forEach(permission -> {
            permissions.add(permission.name());
        });

        var R = new ColoredString("r", new TextColor.RGB(253, 188, 75));
        var W = new ColoredString("w", new TextColor.RGB(192, 57, 43));
        var X = new ColoredString("x", new TextColor.RGB(163, 53, 42));

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

    public String getSize(boolean humanReadable, boolean withColor) {
        var str = new ColoredString("-", new TextColor.RGB(124, 124, 124));
        if (!Files.isDirectory(filePath)) {
            var size = (float) fileAttributes.size();
            var unit = "B";
            if (humanReadable) {
                size = size / 1024; // Convert to KB
                unit = "KB";
                if (size > 1024) {
                    size = size / 1024; // Convert to MB
                    unit = "MB";
                    if (size > 1024) {
                        size = size / 1024; // Convert to GB
                        unit = "GB";
                        if (size > 1024) {
                            size = size / 1024; // Convert to TB
                            unit = "TB";
                        }
                    }
                }
                str = new ColoredString(String.format("%.2f %s", size, unit),
                        new TextColor.RGB(150, 153, 91));
            } else {
                str = new ColoredString(String.format("%d %s", (int)size, unit),
                        new TextColor.RGB(150, 153, 91));
            }
        }
        if (withColor) {
            return str.toString();
        } else {
            return str.getNormalString();
        }
    }

    public String getName(boolean withColor) {
        var strName = filePath.getFileName().toString();
        if (withColor) {
            return new ColoredString(strName, new TextColor.RGB(150, 153, 91)).toString();
        } else {
            return strName;
        }
    }

    public String getCreationTime(boolean withColor) {
        var str = new ColoredString(
                new java.text.SimpleDateFormat("MMM d HH:mm")
                        .format(fileAttributes.creationTime().toMillis()),
                new TextColor.RGB(29, 153, 243));
        if (withColor) {
            return str.toString();
        } else {
            return str.getNormalString();
        }
    }

    public Icon getIcon(boolean withColor) {
        Icon icon = Icon.getCorrectIcon(getName(false));
        if (icon == null) {
            if (fileAttributes.isDirectory()) {
                icon = Icon.DIR;
            } else {
                icon = Icon.FILE;
            }
        }
        return icon;
    }

    public String getOwner(boolean withColor) {
        var str = new ColoredString(fileAttributes.owner().getName(),
                new TextColor.RGB(240, 179, 73));
        if (withColor) {
            return str.toString();
        } else {
            return str.getNormalString();
        }
    }

    public String getGroup(boolean withColor) {
        var str = new ColoredString(fileAttributes.group().getName(),
                new TextColor.RGB(240, 179, 73));
        if (withColor) {
            return str.toString();
        } else {
            return str.getNormalString();
        }
    }

    public PosixFileAttributes getFileAttributes() {
        return fileAttributes;
    }
}
