package com.artifex.mupdflib;

/* loaded from: classes.dex */
public class MuPDFAlert {
    public final ButtonGroupType buttonGroupType;
    public ButtonPressed buttonPressed;
    public final IconType iconType;

    /* renamed from: message  reason: collision with root package name */
    public final String f24477message;
    public final String title;

    /* loaded from: classes.dex */
    public enum ButtonGroupType {
        Ok,
        OkCancel,
        YesNo,
        YesNoCancel
    }

    /* loaded from: classes.dex */
    public enum ButtonPressed {
        None,
        Ok,
        Cancel,
        No,
        Yes
    }

    /* loaded from: classes.dex */
    public enum IconType {
        Error,
        Warning,
        Question,
        Status
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MuPDFAlert(String str, IconType iconType, ButtonGroupType buttonGroupType, String str2, ButtonPressed buttonPressed) {
        this.f24477message = str;
        this.iconType = iconType;
        this.buttonGroupType = buttonGroupType;
        this.title = str2;
        this.buttonPressed = buttonPressed;
    }
}
