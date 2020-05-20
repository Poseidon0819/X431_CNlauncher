package com.cnlaunch.p120d.p130d;

import android.content.Context;
import com.launch.p365b.C3671a;

/* compiled from: NetPOSPrinterUtil.java */
/* renamed from: com.cnlaunch.d.d.f */
/* loaded from: classes.dex */
final class RunnableC1435f implements Runnable {

    /* renamed from: a */
    final /* synthetic */ int f7248a;

    /* renamed from: b */
    final /* synthetic */ Context f7249b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC1435f(int i, Context context) {
        this.f7248a = i;
        this.f7249b = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.f7248a;
        if (i == 8) {
            NToast.m9447b(this.f7249b, C3671a.C3674c.print_actuator_fault);
        } else if (i == 128) {
            NToast.m9447b(this.f7249b, C3671a.C3674c.print_head_overheating);
        } else if (i != 4095) {
            switch (i) {
                case 0:
                    NToast.m9447b(this.f7249b, C3671a.C3674c.print_success);
                    return;
                case 1:
                    NToast.m9447b(this.f7249b, C3671a.C3674c.print_jam);
                    return;
                case 2:
                    NToast.m9447b(this.f7249b, C3671a.C3674c.print_will_nopaper);
                    return;
                case 3:
                    NToast.m9447b(this.f7249b, C3671a.C3674c.print_not_support_oldpdf_file);
                    return;
                case 4:
                    NToast.m9447b(this.f7249b, C3671a.C3674c.print_no_paper);
                    return;
                default:
                    return;
            }
        }
    }
}
