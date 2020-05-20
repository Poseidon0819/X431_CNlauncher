package com.itextpdf.text.pdf.qrcode;

import java.util.HashMap;

/* loaded from: classes.dex */
public final class CharacterSetECI {
    private static HashMap<String, CharacterSetECI> NAME_TO_ECI;
    private final String encodingName;
    private final int value;

    private static void initialize() {
        HashMap<String, CharacterSetECI> hashMap = new HashMap<>(29);
        addCharacterSet(0, "Cp437", hashMap);
        addCharacterSet(1, new String[]{"ISO8859_1", "ISO-8859-1"}, hashMap);
        addCharacterSet(2, "Cp437", hashMap);
        addCharacterSet(3, new String[]{"ISO8859_1", "ISO-8859-1"}, hashMap);
        addCharacterSet(4, new String[]{"ISO8859_2", "ISO-8859-2"}, hashMap);
        addCharacterSet(5, new String[]{"ISO8859_3", "ISO-8859-3"}, hashMap);
        addCharacterSet(6, new String[]{"ISO8859_4", "ISO-8859-4"}, hashMap);
        addCharacterSet(7, new String[]{"ISO8859_5", "ISO-8859-5"}, hashMap);
        addCharacterSet(8, new String[]{"ISO8859_6", "ISO-8859-6"}, hashMap);
        addCharacterSet(9, new String[]{"ISO8859_7", "ISO-8859-7"}, hashMap);
        addCharacterSet(10, new String[]{"ISO8859_8", "ISO-8859-8"}, hashMap);
        addCharacterSet(11, new String[]{"ISO8859_9", "ISO-8859-9"}, hashMap);
        addCharacterSet(12, new String[]{"ISO8859_10", "ISO-8859-10"}, hashMap);
        addCharacterSet(13, new String[]{"ISO8859_11", "ISO-8859-11"}, hashMap);
        addCharacterSet(15, new String[]{"ISO8859_13", "ISO-8859-13"}, hashMap);
        addCharacterSet(16, new String[]{"ISO8859_14", "ISO-8859-14"}, hashMap);
        addCharacterSet(17, new String[]{"ISO8859_15", "ISO-8859-15"}, hashMap);
        addCharacterSet(18, new String[]{"ISO8859_16", "ISO-8859-16"}, hashMap);
        addCharacterSet(20, new String[]{"SJIS", "Shift_JIS"}, hashMap);
        NAME_TO_ECI = hashMap;
    }

    private CharacterSetECI(int i, String str) {
        this.encodingName = str;
        this.value = i;
    }

    public final String getEncodingName() {
        return this.encodingName;
    }

    public final int getValue() {
        return this.value;
    }

    private static void addCharacterSet(int i, String str, HashMap<String, CharacterSetECI> hashMap) {
        hashMap.put(str, new CharacterSetECI(i, str));
    }

    private static void addCharacterSet(int i, String[] strArr, HashMap<String, CharacterSetECI> hashMap) {
        CharacterSetECI characterSetECI = new CharacterSetECI(i, strArr[0]);
        for (String str : strArr) {
            hashMap.put(str, characterSetECI);
        }
    }

    public static CharacterSetECI getCharacterSetECIByName(String str) {
        if (NAME_TO_ECI == null) {
            initialize();
        }
        return NAME_TO_ECI.get(str);
    }
}
