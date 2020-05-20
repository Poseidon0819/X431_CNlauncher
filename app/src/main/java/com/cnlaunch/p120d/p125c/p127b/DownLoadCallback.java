package com.cnlaunch.p120d.p125c.p127b;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import org.apache.http.Header;

/* renamed from: com.cnlaunch.d.c.b.a */
/* loaded from: classes.dex */
public class DownLoadCallback extends Handler {
    /* renamed from: a */
    public void mo4521a(int i, int i2, String str, String str2) {
    }

    /* renamed from: a */
    public void mo4520a(String str, int i, int i2) {
    }

    /* renamed from: a */
    public void mo4519a(String str, String str2) {
    }

    /* renamed from: b */
    public void mo4518b(String str, String str2) {
    }

    public DownLoadCallback() {
    }

    public DownLoadCallback(Looper looper) {
        super(looper);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message2) {
        switch (message2.what) {
            case 0:
                return;
            case 1:
                Object obj = message2.obj;
                return;
            case 2:
                Object[] objArr = (Object[]) message2.obj;
                mo4520a((String) objArr[0], ((Integer) objArr[1]).intValue(), ((Integer) objArr[2]).intValue());
                return;
            case 3:
                Object[] objArr2 = (Object[]) message2.obj;
                mo4519a((String) objArr2[0], (String) objArr2[1]);
                return;
            case 4:
                Object[] objArr3 = (Object[]) message2.obj;
                mo4518b((String) objArr3[0], (String) objArr3[1]);
                return;
            case 5:
                Object obj2 = message2.obj;
                return;
            case 6:
                return;
            case 7:
                Object[] objArr4 = (Object[]) message2.obj;
                mo4521a(((Integer) objArr4[0]).intValue(), ((Integer) objArr4[1]).intValue(), (String) objArr4[2], (String) objArr4[3]);
                return;
            case 8:
                Object obj3 = message2.obj;
                return;
            case 9:
                Object obj4 = message2.obj;
                return;
            case 10:
                Object obj5 = message2.obj;
                return;
            case 11:
                Object obj6 = message2.obj;
                return;
            case 12:
                Object obj7 = message2.obj;
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: c */
    public final void m9567c(String str, String str2) {
        sendMessage(obtainMessage(3, new Object[]{str, str2}));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: b */
    public final void m9568b(String str, int i, int i2) {
        sendMessage(obtainMessage(2, new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2)}));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: d */
    public final void m9566d(String str, String str2) {
        sendMessage(obtainMessage(4, new Object[]{str, str2}));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public final void m9571a(String str, String str2, Header[] headerArr) {
        sendMessage(obtainMessage(11, new Object[]{str, str2, headerArr}));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public final void m9573a() {
        sendMessage(obtainMessage(0, null));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: b */
    public final void m9570b() {
        sendMessage(obtainMessage(6, null));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public final void m9572a(String str) {
        sendMessage(obtainMessage(5, new Object[]{str}));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: b */
    public final void m9569b(int i, int i2, String str, String str2) {
        sendMessage(obtainMessage(7, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str, str2}));
    }
}
