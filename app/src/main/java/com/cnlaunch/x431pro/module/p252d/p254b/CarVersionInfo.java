package com.cnlaunch.x431pro.module.p252d.p254b;

import com.cnlaunch.x431pro.module.p241a.AbstractC2709c;

/* renamed from: com.cnlaunch.x431pro.module.d.b.b */
/* loaded from: classes.dex */
public final class CarVersionInfo extends AbstractC2709c {
    private static final long serialVersionUID = 5702154238146048032L;
    private String iniText = "";
    private String version = "";
    private String lan = "";
    private String iniTitle = "";
    private String language = "";

    public final String getVersion() {
        return this.version;
    }

    public final void setVersion(String str) {
        this.version = str;
    }

    public final String getIniText() {
        return this.iniText;
    }

    public final void setIniText(String str) {
        this.iniText = str;
    }

    public final String getLan() {
        return this.lan;
    }

    public final void setLan(String str) {
        this.lan = str;
    }

    public final String getIniTitle() {
        return this.iniTitle;
    }

    public final void setIniTitle(String str) {
        this.iniTitle = str;
    }

    public final String toString() {
        return "CarVersionInfo [iniText=" + this.iniText + ", version=" + this.version + ", lan=" + this.lan + ", iniTitle=" + this.iniTitle + "]";
    }

    public final String getLanguage() {
        return this.language;
    }

    public final void setLanguage(String str) {
        this.language = str;
    }
}
