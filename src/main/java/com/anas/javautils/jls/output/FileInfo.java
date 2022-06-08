package com.anas.javautils.jls.output;

import com.anas.javautils.jls.utils.ColoredString;
import com.googlecode.lanterna.TextColor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.PosixFileAttributeView;
import java.util.ArrayList;

public class FileInfo {
    private final Path filePath;

    public FileInfo(Path filePath) {
        this.filePath = filePath;
    }

    public String getPermissions() {
        var sb = new StringBuilder();
        sb.append(new ColoredString(Files.isDirectory(filePath) ? "d" : Files.isSymbolicLink(filePath) ? "l" : ".",
                new TextColor.RGB(61, 174, 233)));
        var hithon = new ColoredString("-", new TextColor.RGB(45, 49, 50));
        try {
            ArrayList<String> permissions = new ArrayList<>();
            Files.getPosixFilePermissions(filePath).forEach(permission -> {
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
        } catch (IOException e) {
            sb.append(" ");
        }
        return sb.toString();
    }

    public String getSize() {
        try {
            if (Files.isDirectory(filePath)) {
                return "-";
            }
            return Files.size(filePath) + "";
        } catch (IOException e) {
            return "-";
        }
    }

    public String getName() {
        return filePath.getFileName().toString();
    }

    public String getCreationTime() {
        try {
            return new ColoredString(
                    new java.text.SimpleDateFormat("M dd HH:mm")
                            .format(Files.getLastModifiedTime(filePath).toMillis()),
                    new TextColor.RGB(29, 153, 243)).toString();
        } catch (IOException e) {
            return "";
        }
    }

    public Icon getIcon() {
        Icon icon = Icon.getCorrectIcon(getName());
        if (icon == null) {
            if (Files.isDirectory(filePath)) {
                icon = Icon.DIR;
            } else {
                icon = Icon.FILE;
            }
        }
        return icon;
    }

    public String getOwner() {
        try {
            return new ColoredString(Files.getOwner(filePath).getName(),
                    new TextColor.RGB(240, 179, 73)).toString();
        } catch (IOException e) {
            return "";
        }
    }

    public String getGroup() {
        try {
            return Files.getFileAttributeView(filePath, PosixFileAttributeView.class).readAttributes().group().toString();
        } catch (IOException e) {
            return "";
        }
    }

    public String getLongFormat(boolean withOwner, boolean withGroup, boolean withIcon) {
        return String.format("%10s\t" + (withOwner ? "%s\t" : "%s")  + (withGroup ? getGroup() + "%s\t" : "%s") + "%-6s\t%s\t%s",
                getPermissions(), (withOwner ? getOwner() : ""), (withGroup ? getGroup() : ""),
                getSize(), getCreationTime(), getShortFormat(withIcon, false));
    }

    public String getShortFormat(boolean withIcon, boolean witSize) {
        return (withIcon ? getIcon().toString() + " " : "") + getName() + (witSize ? " " + getSize() : "");
    }
}
