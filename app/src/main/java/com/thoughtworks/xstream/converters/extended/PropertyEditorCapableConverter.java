package com.thoughtworks.xstream.converters.extended;

import com.thoughtworks.xstream.converters.SingleValueConverter;
import com.thoughtworks.xstream.core.util.ThreadSafePropertyEditor;

/* loaded from: classes2.dex */
public class PropertyEditorCapableConverter implements SingleValueConverter {
    private final ThreadSafePropertyEditor editor;
    private final Class type;

    public PropertyEditorCapableConverter(Class cls, Class cls2) {
        this.type = cls2;
        this.editor = new ThreadSafePropertyEditor(cls, 2, 5);
    }

    @Override // com.thoughtworks.xstream.converters.ConverterMatcher
    public boolean canConvert(Class cls) {
        return this.type == cls;
    }

    @Override // com.thoughtworks.xstream.converters.SingleValueConverter
    public Object fromString(String str) {
        return this.editor.setAsText(str);
    }

    @Override // com.thoughtworks.xstream.converters.SingleValueConverter
    public String toString(Object obj) {
        return this.editor.getAsText(obj);
    }
}
