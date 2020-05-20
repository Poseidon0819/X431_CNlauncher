package com.cnlaunch.x431pro.module.p263h.p265b;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Arrays;

/* renamed from: com.cnlaunch.x431pro.module.h.b.i */
/* loaded from: classes.dex */
public final class FormFile {

    /* renamed from: a */
    public byte[] f15553a;

    /* renamed from: b */
    public InputStream f15554b;

    /* renamed from: c */
    public String f15555c;

    /* renamed from: d */
    public String f15556d;

    /* renamed from: e */
    public String f15557e;

    /* renamed from: f */
    private File f15558f;

    public FormFile(String str, File file, String str2, String str3) {
        this.f15557e = "application/octet-stream";
        this.f15555c = str;
        this.f15556d = str2;
        this.f15558f = file;
        try {
            this.f15554b = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        this.f15557e = str3;
    }

    public final String toString() {
        return "FormFile [data=" + Arrays.toString(this.f15553a) + ", inStream=" + this.f15554b + ", file=" + this.f15558f + ", filname=" + this.f15555c + ", parameterName=" + this.f15556d + ", contentType=" + this.f15557e + "]";
    }
}
