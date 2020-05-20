package com.thoughtworks.xstream.core.util;

import com.thoughtworks.xstream.converters.reflection.ObjectAccessException;
import com.thoughtworks.xstream.core.util.Pool;
import java.beans.PropertyEditor;

/* loaded from: classes2.dex */
public class ThreadSafePropertyEditor {
    private final Class editorType;
    private final Pool pool;

    public ThreadSafePropertyEditor(Class cls, int i, int i2) {
        if (!PropertyEditor.class.isAssignableFrom(cls)) {
            throw new IllegalArgumentException(cls.getName() + " is not a " + PropertyEditor.class.getName());
        }
        this.editorType = cls;
        this.pool = new Pool(i, i2, new Pool.Factory() { // from class: com.thoughtworks.xstream.core.util.ThreadSafePropertyEditor.1
            @Override // com.thoughtworks.xstream.core.util.Pool.Factory
            public Object newInstance() {
                try {
                    return ThreadSafePropertyEditor.this.editorType.newInstance();
                } catch (IllegalAccessException e) {
                    throw new ObjectAccessException("Could not call default constructor of " + ThreadSafePropertyEditor.this.editorType.getName(), e);
                } catch (InstantiationException e2) {
                    throw new ObjectAccessException("Could not call default constructor of " + ThreadSafePropertyEditor.this.editorType.getName(), e2);
                }
            }
        });
    }

    public String getAsText(Object obj) {
        PropertyEditor fetchFromPool = fetchFromPool();
        try {
            fetchFromPool.setValue(obj);
            return fetchFromPool.getAsText();
        } finally {
            this.pool.putInPool(fetchFromPool);
        }
    }

    public Object setAsText(String str) {
        PropertyEditor fetchFromPool = fetchFromPool();
        try {
            fetchFromPool.setAsText(str);
            return fetchFromPool.getValue();
        } finally {
            this.pool.putInPool(fetchFromPool);
        }
    }

    private PropertyEditor fetchFromPool() {
        return (PropertyEditor) this.pool.fetchFromPool();
    }
}
