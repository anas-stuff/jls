package com.anas.javautils.jls.utils;

import java.util.Arrays;

public class Row {
    private String[] columns;
    private int currentColumnIndex;
    private int mColumnLength;
    public Row() {
        columns = new String[0];
        currentColumnIndex = 0;
        mColumnLength = 0;
    }

    public void addColumn(String content) {
        columns = Arrays.copyOf(columns, columns.length + 1);
        columns[currentColumnIndex] = content;
        updateMaxColumnLength(content);
        currentColumnIndex++;
    }

    private void updateMaxColumnLength(String content) {
        if (content.length() > mColumnLength) {
            mColumnLength = content.length();
        }
    }

    public String getColumn(int columnIndex) {
        return columns[columnIndex];
    }

    public int getColumnCount() {
        return columns.length;
    }
}
