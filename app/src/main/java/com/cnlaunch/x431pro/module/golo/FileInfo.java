package com.cnlaunch.x431pro.module.golo;

import com.cnlaunch.x431pro.module.p241a.AbstractC2709c;

/* renamed from: com.cnlaunch.x431pro.module.golo.a */
/* loaded from: classes.dex */
public final class FileInfo extends AbstractC2709c {
    private static final long serialVersionUID = -3619383795947998447L;
    private long created;
    private String name;
    private String path;

    public FileInfo(String str, String str2, long j) {
        this.created = j;
        this.name = str;
        this.path = str2;
    }

    public final long getCreated() {
        return this.created;
    }

    public final void setCreated(long j) {
        this.created = j;
    }

    public final String getName() {
        return this.name;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public final String getPath() {
        return this.path;
    }

    public final void setPath(String str) {
        this.path = str;
    }
}
