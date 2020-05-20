package okio;

/* loaded from: classes2.dex */
public final class Utf8 {
    private Utf8() {
    }

    public static long size(String str) {
        return size(str, 0, str.length());
    }

    public static long size(String str, int i, int i2) {
        if (str != null) {
            if (i >= 0) {
                if (i2 < i) {
                    throw new IllegalArgumentException("endIndex < beginIndex: " + i2 + " < " + i);
                } else if (i2 > str.length()) {
                    throw new IllegalArgumentException("endIndex > string.length: " + i2 + " > " + str.length());
                } else {
                    long j = 0;
                    while (i < i2) {
                        char charAt = str.charAt(i);
                        if (charAt < 128) {
                            j++;
                            i++;
                        } else if (charAt < 2048) {
                            j += 2;
                            i++;
                        } else if (charAt < 55296 || charAt > 57343) {
                            j += 3;
                            i++;
                        } else {
                            int i3 = i + 1;
                            char charAt2 = i3 < i2 ? str.charAt(i3) : (char) 0;
                            if (charAt > 56319 || charAt2 < 56320 || charAt2 > 57343) {
                                j++;
                                i = i3;
                            } else {
                                j += 4;
                                i += 2;
                            }
                        }
                    }
                    return j;
                }
            }
            throw new IllegalArgumentException("beginIndex < 0: ".concat(String.valueOf(i)));
        }
        throw new IllegalArgumentException("string == null");
    }
}
