package com.anas.javautils.jls.utils;

import com.anas.javautils.jls.lanterna.TextColor;

import java.nio.charset.StandardCharsets;

public class ColoredString {
    private final byte[] bytes;
    private final TextColor foregroundColor;

    public ColoredString(final String str,
                         final TextColor foregroundColor) {
        this.bytes = str.getBytes();
        this.foregroundColor = foregroundColor;
    }


    public ColoredString(final String str) {
        this(str, null );
    }

    public TextColor getForegroundColor() {
        return foregroundColor;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (foregroundColor != null) {
            sb.append("\033[");
            sb.append(new String(foregroundColor.getForegroundSGRSequence(), StandardCharsets.UTF_8));
            sb.append("m");
        }
        sb.append(new String(bytes, StandardCharsets.UTF_8));

        if (foregroundColor != null) {
            sb.append("\033[m");
        }
        return sb.toString();
    }

    public String getNormalString() {
        return new String(bytes, StandardCharsets.UTF_8);
    }
}
