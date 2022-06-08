package com.anas.javautils.jls.utils;

import com.googlecode.lanterna.TextColor;

import java.nio.charset.StandardCharsets;

public class ColoredString {
    private byte[] bytes;
    private TextColor.RGB foregroundColor;
    private TextColor.RGB backgroundColor;

    public ColoredString(String str, TextColor.RGB foregroundColor, TextColor.RGB backgroundColor) {
        this.bytes = str.getBytes();
        this.foregroundColor = foregroundColor;
        this.backgroundColor = backgroundColor;
    }

    public ColoredString(String str, TextColor.RGB foregroundColor) {
        this(str, foregroundColor, null);
    }

    public ColoredString(String str) {
        this(str, null, null);
    }

    public TextColor.RGB getForegroundColor() {
        return foregroundColor;
    }

    public TextColor.RGB getBackgroundColor() {
        return backgroundColor;
    }

    public void setForegroundColor(TextColor.RGB foregroundColor) {
        this.foregroundColor = foregroundColor;
    }

    public void setBackgroundColor(TextColor.RGB backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (foregroundColor != null) {
            sb.append("\033[");
            sb.append(new String(foregroundColor.getForegroundSGRSequence(), StandardCharsets.UTF_8));
            sb.append("m");
        }
        if (backgroundColor != null) {
            sb.append("\033[");
            sb.append(new String(backgroundColor.getBackgroundSGRSequence(), StandardCharsets.UTF_8));
            sb.append("m");
        }
        sb.append(new String(bytes, StandardCharsets.UTF_8));

        if (foregroundColor != null) {
            sb.append("\033[m");
        }

        if (backgroundColor != null) {
            sb.append("\033[m");
        }

        return sb.toString();
    }

    public String getNormalString() {
        return new String(bytes, StandardCharsets.UTF_8);
    }
}
