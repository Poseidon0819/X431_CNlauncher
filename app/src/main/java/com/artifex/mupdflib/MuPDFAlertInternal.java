package com.artifex.mupdflib;

import com.artifex.mupdflib.MuPDFAlert;

/* loaded from: classes.dex */
public class MuPDFAlertInternal {
    public final int buttonGroupType;
    public int buttonPressed;
    public final int iconType;

    /* renamed from: message  reason: collision with root package name */
    public final String f24478message;
    public final String title;

    MuPDFAlertInternal(String str, int i, int i2, String str2, int i3) {
        this.f24478message = str;
        this.iconType = i;
        this.buttonGroupType = i2;
        this.title = str2;
        this.buttonPressed = i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MuPDFAlertInternal(MuPDFAlert muPDFAlert) {
        this.f24478message = muPDFAlert.f24477message;
        this.iconType = muPDFAlert.iconType.ordinal();
        this.buttonGroupType = muPDFAlert.buttonGroupType.ordinal();
        this.title = muPDFAlert.f24477message;
        this.buttonPressed = muPDFAlert.buttonPressed.ordinal();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MuPDFAlert toAlert() {
        return new MuPDFAlert(this.f24478message, MuPDFAlert.IconType.values()[this.iconType], MuPDFAlert.ButtonGroupType.values()[this.buttonGroupType], this.title, MuPDFAlert.ButtonPressed.values()[this.buttonPressed]);
    }
}
