package com.cnlaunch.x431pro.module.config.p250b;

import com.cnlaunch.x431pro.module.p241a.AbstractC2709c;
import java.util.List;

/* renamed from: com.cnlaunch.x431pro.module.config.b.a */
/* loaded from: classes.dex */
public final class ConfigData extends AbstractC2709c {
    private static final long serialVersionUID = 8484011277225440517L;
    private String area;
    private List<ConfigUrl> urls;
    private String version;

    public final String getVersion() {
        return this.version;
    }

    public final void setVersion(String str) {
        this.version = str;
    }

    public final String getArea() {
        return this.area;
    }

    public final void setArea(String str) {
        this.area = str;
    }

    public final List<ConfigUrl> getUrls() {
        return this.urls;
    }

    public final void setUrls(List<ConfigUrl> list) {
        this.urls = list;
    }

    public final String toString() {
        return "ConfigData [version=" + this.version + ", area=" + this.area + ", urls=" + this.urls + "]";
    }
}
