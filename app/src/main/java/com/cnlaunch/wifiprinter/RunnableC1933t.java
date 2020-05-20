package com.cnlaunch.wifiprinter;

import com.cnlaunch.wifiprinter.C1900at;

/* compiled from: PrintTest.java */
/* renamed from: com.cnlaunch.wifiprinter.t */
/* loaded from: classes.dex */
final class RunnableC1933t implements Runnable {

    /* renamed from: a */
    final /* synthetic */ int f10503a;

    /* renamed from: b */
    final /* synthetic */ PrintTest f10504b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC1933t(PrintTest printTest, int i) {
        this.f10504b = printTest;
        this.f10503a = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.f10503a;
        if (i == 4) {
            Constant.m8033a(this.f10504b.f10481q, this.f10504b.f10481q.getResources().getString(C1900at.C1907g.print_no_paper));
        } else if (i == 8) {
            Constant.m8033a(this.f10504b.f10481q, this.f10504b.f10481q.getResources().getString(C1900at.C1907g.print_Actuator_fault));
        } else if (i != 128) {
            switch (i) {
                case 0:
                    Constant.m8033a(this.f10504b.f10481q, this.f10504b.f10481q.getResources().getString(C1900at.C1907g.print_success));
                    return;
                case 1:
                    Constant.m8033a(this.f10504b.f10481q, this.f10504b.f10481q.getResources().getString(C1900at.C1907g.print_jam));
                    return;
                case 2:
                    Constant.m8033a(this.f10504b.f10481q, this.f10504b.f10481q.getResources().getString(C1900at.C1907g.print_will_nopaper));
                    return;
                default:
                    switch (i) {
                        case 4094:
                            Constant.m8033a(this.f10504b.f10481q, this.f10504b.f10481q.getResources().getString(C1900at.C1907g.Communiterror));
                            return;
                        case 4095:
                            Constant.m8033a(this.f10504b.f10481q, this.f10504b.f10481q.getResources().getString(C1900at.C1907g.print_connect_printer));
                            return;
                        default:
                            return;
                    }
            }
        } else {
            Constant.m8033a(this.f10504b.f10481q, this.f10504b.f10481q.getResources().getString(C1900at.C1907g.print_head_overheating));
        }
    }
}
