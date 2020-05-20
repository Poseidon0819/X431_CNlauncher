package com.thoughtworks.xstream.converters.basic;

import com.itextpdf.text.pdf.PdfBoolean;

/* loaded from: classes2.dex */
public class BooleanConverter extends AbstractSingleValueConverter {
    private final boolean caseSensitive;
    private final String negative;
    private final String positive;
    public static final BooleanConverter TRUE_FALSE = new BooleanConverter(PdfBoolean.TRUE, PdfBoolean.FALSE, false);
    public static final BooleanConverter YES_NO = new BooleanConverter("yes", "no", false);
    public static final BooleanConverter BINARY = new BooleanConverter("1", "0", true);

    public boolean shouldConvert(Class cls, Object obj) {
        return true;
    }

    public BooleanConverter(String str, String str2, boolean z) {
        this.positive = str;
        this.negative = str2;
        this.caseSensitive = z;
    }

    public BooleanConverter() {
        this(PdfBoolean.TRUE, PdfBoolean.FALSE, false);
    }

    @Override // com.thoughtworks.xstream.converters.basic.AbstractSingleValueConverter, com.thoughtworks.xstream.converters.ConverterMatcher
    public boolean canConvert(Class cls) {
        return cls.equals(Boolean.TYPE) || cls.equals(Boolean.class);
    }

    @Override // com.thoughtworks.xstream.converters.basic.AbstractSingleValueConverter, com.thoughtworks.xstream.converters.SingleValueConverter
    public Object fromString(String str) {
        return this.caseSensitive ? this.positive.equals(str) ? Boolean.TRUE : Boolean.FALSE : this.positive.equalsIgnoreCase(str) ? Boolean.TRUE : Boolean.FALSE;
    }

    @Override // com.thoughtworks.xstream.converters.basic.AbstractSingleValueConverter, com.thoughtworks.xstream.converters.SingleValueConverter
    public String toString(Object obj) {
        Boolean bool = (Boolean) obj;
        if (obj == null) {
            return null;
        }
        return bool.booleanValue() ? this.positive : this.negative;
    }
}
