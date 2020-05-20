package com.cnlaunch.x431pro.module.config.p250b;

import com.cnlaunch.x431pro.module.p241a.AbstractC2709c;

/* renamed from: com.cnlaunch.x431pro.module.config.b.c */
/* loaded from: classes.dex */
public final class ConfigUrl extends AbstractC2709c {
    private static final long serialVersionUID = 7163129377620862929L;
    private String key;
    private String value;

    public final String getKey() {
        return this.key;
    }

    public final void setKey(String str) {
        this.key = str;
    }

    public final String getValue() {
        return this.value;
    }

    public final void setValue(String str) {
        this.value = str;
    }

    public final String toString() {
        return "ConfigUrl [key=" + this.key + ", value=" + this.value + "]";
    }
}
