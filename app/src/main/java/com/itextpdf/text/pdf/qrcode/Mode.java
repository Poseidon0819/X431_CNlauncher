package com.itextpdf.text.pdf.qrcode;

/* loaded from: classes.dex */
public final class Mode {
    private final int bits;
    private final int[] characterCountBitsForVersions;
    private final String name;
    public static final Mode TERMINATOR = new Mode(new int[]{0, 0, 0}, 0, "TERMINATOR");
    public static final Mode NUMERIC = new Mode(new int[]{10, 12, 14}, 1, "NUMERIC");
    public static final Mode ALPHANUMERIC = new Mode(new int[]{9, 11, 13}, 2, "ALPHANUMERIC");
    public static final Mode STRUCTURED_APPEND = new Mode(new int[]{0, 0, 0}, 3, "STRUCTURED_APPEND");
    public static final Mode BYTE = new Mode(new int[]{8, 16, 16}, 4, "BYTE");
    public static final Mode ECI = new Mode(null, 7, "ECI");
    public static final Mode KANJI = new Mode(new int[]{8, 10, 12}, 8, "KANJI");
    public static final Mode FNC1_FIRST_POSITION = new Mode(null, 5, "FNC1_FIRST_POSITION");
    public static final Mode FNC1_SECOND_POSITION = new Mode(null, 9, "FNC1_SECOND_POSITION");

    private Mode(int[] iArr, int i, String str) {
        this.characterCountBitsForVersions = iArr;
        this.bits = i;
        this.name = str;
    }

    public static Mode forBits(int i) {
        switch (i) {
            case 0:
                return TERMINATOR;
            case 1:
                return NUMERIC;
            case 2:
                return ALPHANUMERIC;
            case 3:
                return STRUCTURED_APPEND;
            case 4:
                return BYTE;
            case 5:
                return FNC1_FIRST_POSITION;
            case 6:
            default:
                throw new IllegalArgumentException();
            case 7:
                return ECI;
            case 8:
                return KANJI;
            case 9:
                return FNC1_SECOND_POSITION;
        }
    }

    public final int getCharacterCountBits(Version version) {
        if (this.characterCountBitsForVersions == null) {
            throw new IllegalArgumentException("Character count doesn't apply to this mode");
        }
        int versionNumber = version.getVersionNumber();
        return this.characterCountBitsForVersions[versionNumber <= 9 ? (char) 0 : versionNumber <= 26 ? (char) 1 : (char) 2];
    }

    public final int getBits() {
        return this.bits;
    }

    public final String getName() {
        return this.name;
    }

    public final String toString() {
        return this.name;
    }
}
