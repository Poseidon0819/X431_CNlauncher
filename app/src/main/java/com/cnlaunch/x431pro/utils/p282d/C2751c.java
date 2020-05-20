package com.cnlaunch.x431pro.utils.p282d;

import java.io.File;
import java.util.Comparator;

/* compiled from: DiagnoseLogInfoSearchUtil.java */
/* renamed from: com.cnlaunch.x431pro.utils.d.c */
/* loaded from: classes.dex */
public final class C2751c implements Comparator<File> {
    @Override // java.util.Comparator
    public final /* synthetic */ int compare(File file, File file2) {
        File file3 = file;
        File file4 = file2;
        if (file3.lastModified() > file4.lastModified()) {
            return -1;
        }
        return file3.lastModified() == file4.lastModified() ? 0 : 1;
    }
}
