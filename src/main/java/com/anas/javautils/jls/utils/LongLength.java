package com.anas.javautils.jls.utils;

public class LongLength {
    private byte longFileNameLength;
    private byte longDateLength;
    private byte longSizeLength;
    private byte longOwnerLength;
    private byte longGroupLength;

    public LongLength() {
        longFileNameLength = 0;
        longDateLength = 0;
        longSizeLength = 0;
        longOwnerLength = 0;
        longGroupLength = 0;
    }

    public byte getLongFileNameLength() {
        return longFileNameLength;
    }

    public void setLongFileNameLength(byte longFileNameLength) {
        this.longFileNameLength = longFileNameLength;
    }

    public byte getLongDateLength() {
        return longDateLength;
    }

    public void setLongDateLength(byte longDateLength) {
        this.longDateLength = longDateLength;
    }

    public byte getLongSizeLength() {
        return longSizeLength;
    }

    public void setLongSizeLength(byte longSizeLength) {
        this.longSizeLength = longSizeLength;
    }

    public byte getLongOwnerLength() {
        return longOwnerLength;
    }

    public void setLongOwnerLength(byte longOwnerLength) {
        this.longOwnerLength = longOwnerLength;
    }

    public byte getLongGroupLength() {
        return longGroupLength;
    }

    public void setLongGroupLength(byte longGroupLength) {
        this.longGroupLength = longGroupLength;
    }
}
