package com.thoughtworks.xstream.converters.extended;

import com.thoughtworks.xstream.converters.basic.AbstractSingleValueConverter;
import java.util.Locale;

/* loaded from: classes2.dex */
public class LocaleConverter extends AbstractSingleValueConverter {
    @Override // com.thoughtworks.xstream.converters.basic.AbstractSingleValueConverter, com.thoughtworks.xstream.converters.ConverterMatcher
    public boolean canConvert(Class cls) {
        return cls.equals(Locale.class);
    }

    @Override // com.thoughtworks.xstream.converters.basic.AbstractSingleValueConverter, com.thoughtworks.xstream.converters.SingleValueConverter
    public Object fromString(String str) {
        String substring;
        String str2;
        String str3;
        int[] underscorePositions = underscorePositions(str);
        if (underscorePositions[0] == -1) {
            str2 = "";
            str3 = "";
            substring = str;
        } else if (underscorePositions[1] == -1) {
            substring = str.substring(0, underscorePositions[0]);
            str2 = str.substring(underscorePositions[0] + 1);
            str3 = "";
        } else {
            substring = str.substring(0, underscorePositions[0]);
            String substring2 = str.substring(underscorePositions[0] + 1, underscorePositions[1]);
            String substring3 = str.substring(underscorePositions[1] + 1);
            str2 = substring2;
            str3 = substring3;
        }
        return new Locale(substring, str2, str3);
    }

    private int[] underscorePositions(String str) {
        int[] iArr = new int[2];
        int i = 0;
        while (i < 2) {
            iArr[i] = str.indexOf(95, (i == 0 ? 0 : iArr[0]) + 1);
            i++;
        }
        return iArr;
    }
}
