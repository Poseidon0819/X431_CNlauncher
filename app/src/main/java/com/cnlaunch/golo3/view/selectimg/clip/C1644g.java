package com.cnlaunch.golo3.view.selectimg.clip;

import java.io.Closeable;
import java.io.IOException;

/* compiled from: IOUtils.java */
/* renamed from: com.cnlaunch.golo3.view.selectimg.clip.g */
/* loaded from: classes.dex */
public final class C1644g {
    /* renamed from: a */
    public static void m9030a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
