package com.cnlaunch.x431pro.utils;

import java.io.File;

/* renamed from: com.cnlaunch.x431pro.utils.o */
/* loaded from: classes.dex */
public final class DataCleanManager {
    /* renamed from: a */
    public static void m4884a(File file) {
        if (file != null && file.exists() && file.isDirectory()) {
            for (File file2 : file.listFiles()) {
                file2.delete();
            }
        }
    }
}
