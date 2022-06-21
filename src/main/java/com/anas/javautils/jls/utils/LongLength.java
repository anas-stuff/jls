package com.anas.javautils.jls.utils;

/**
 * This class is used to store the length of the long file name, long date, long size, long owner, and long group
 */
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

    /**
     * Returns the length of the long file name.
     *
     * @return The length of the long file name.
     */
    public byte getLongFileNameLength() {
        return longFileNameLength;
    }

    /**
     * This function sets the longFileNameLength variable to the value of the longFileNameLength parameter.
     *
     * @param longFileNameLength The length of the long file name.
     */
    public void setLongFileNameLength(final byte longFileNameLength) {
        this.longFileNameLength = longFileNameLength;
    }

    /**
     * Returns the length of the long date format.
     *
     * @return The length of the long date.
     */
    public byte getLongDateLength() {
        return longDateLength;
    }

    /**
     * This function sets the length of the long date.
     *
     * @param longDateLength The length of the long date string.
     */
    public void setLongDateLength(final byte longDateLength) {
        this.longDateLength = longDateLength;
    }

    /**
     * > Returns the length of the size field in the long form of a variable length integer
     *
     * @return The length of the longSizeLength variable.
     */
    public byte getLongSizeLength() {
        return longSizeLength;
    }

    /**
     * Sets the length of the size field for long values.
     *
     * @param longSizeLength The number of bytes used to represent the length of the long value.
     */
    public void setLongSizeLength(final byte longSizeLength) {
        this.longSizeLength = longSizeLength;
    }

    /**
     * Returns the length of the long owner name.
     *
     * @return The length of the long owner name.
     */
    public byte getLongOwnerLength() {
        return longOwnerLength;
    }

    /**
     * This function sets the longOwnerLength variable to the value of the longOwnerLength parameter.
     *
     * @param longOwnerLength The length of the long owner name.
     */
    public void setLongOwnerLength(final byte longOwnerLength) {
        this.longOwnerLength = longOwnerLength;
    }

    /**
     * Returns the length of the long group.
     *
     * @return The value of the longGroupLength variable.
     */
    public byte getLongGroupLength() {
        return longGroupLength;
    }

    /**
     * This function sets the longGroupLength variable to the value of the longGroupLength parameter.
     *
     * @param longGroupLength The number of bytes in the long group.
     */
    public void setLongGroupLength(byte longGroupLength) {
        this.longGroupLength = longGroupLength;
    }
}
