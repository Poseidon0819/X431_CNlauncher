package com.cnlaunch.p169im.p176f;

import android.media.AudioRecord;
import android.media.MediaRecorder;
import java.io.File;
import message.p384g.LogUtilMsg;

/* renamed from: com.cnlaunch.im.f.d */
/* loaded from: classes.dex */
public final class RecorderHelper {

    /* renamed from: a */
    public int f9256a = 0;

    /* renamed from: h */
    private boolean f9263h = false;

    /* renamed from: i */
    private int f9264i = 8000;

    /* renamed from: j */
    private int f9265j = 12;

    /* renamed from: k */
    private int f9266k = 2;

    /* renamed from: l */
    private int f9267l = 1024;

    /* renamed from: b */
    public InterfaceC1741a f9257b = null;

    /* renamed from: c */
    public long f9258c = 0;

    /* renamed from: d */
    int f9259d = 0;

    /* renamed from: e */
    public File f9260e = null;

    /* renamed from: f */
    public MediaRecorder f9261f = null;

    /* renamed from: g */
    AudioRecord f9262g = null;

    /* compiled from: RecorderHelper.java */
    /* renamed from: com.cnlaunch.im.f.d$a */
    /* loaded from: classes.dex */
    public interface InterfaceC1741a {
        /* renamed from: a */
        void mo8723a(int i);
    }

    /* renamed from: a */
    public final File m8727a() {
        MediaRecorder mediaRecorder = this.f9261f;
        if (mediaRecorder == null) {
            return null;
        }
        try {
            try {
                mediaRecorder.stop();
            } catch (RuntimeException unused) {
                if (this.f9260e != null) {
                    this.f9260e.delete();
                }
                this.f9260e = null;
                this.f9259d = 0;
                m8724b(0);
            }
            this.f9259d = (int) ((System.currentTimeMillis() - this.f9258c) / 1000);
            LogUtilMsg.m227a("hsy", "RecorderHelper  录制时间 = " + this.f9259d + "\n");
            m8726a(0);
            return this.f9260e;
        } finally {
            this.f9261f.release();
            this.f9261f = null;
        }
    }

    /* renamed from: a */
    public final void m8726a(int i) {
        if (i == this.f9256a) {
            return;
        }
        this.f9256a = i;
        m8724b(this.f9256a);
    }

    /* renamed from: b */
    private void m8724b(int i) {
        InterfaceC1741a interfaceC1741a = this.f9257b;
        if (interfaceC1741a != null) {
            interfaceC1741a.mo8723a(i);
        }
    }
}
