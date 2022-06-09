package com.anas.javautils.jls.utils;

import com.anas.javautils.jls.output.FileInfo;

import java.util.ArrayList;

public class Table {
    private final ArrayList<Row> rows;

    public Table() {
        rows = new ArrayList<>();

    }

    public void addRow(Row row) {
        rows.add(row);
    }

    public Row getRow(int rowIndex) {
        return rows.get(rowIndex);
    }

    public int getRowCount() {
        return rows.size();
    }

    public void createRows(FileInfo[] files, int terminalWidth) {

    }
}
