package com.artifex.mupdflib;

import android.net.Uri;

/* loaded from: classes.dex */
public abstract class FilePicker {
    private final FilePickerSupport support;

    /* loaded from: classes.dex */
    public interface FilePickerSupport {
        void performPickFor(FilePicker filePicker);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void onPick(Uri uri);

    /* JADX INFO: Access modifiers changed from: package-private */
    public FilePicker(FilePickerSupport filePickerSupport) {
        this.support = filePickerSupport;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void pick() {
        this.support.performPickFor(this);
    }
}
