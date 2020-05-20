package com.unionpay.mobile.android.nocard.views;

import android.view.View;
import android.widget.AdapterView;
import android.widget.PopupWindow;
import com.unionpay.mobile.android.nocard.views.C4245o;
import com.unionpay.mobile.android.upwidget.C4356c;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.unionpay.mobile.android.nocard.views.ad */
/* loaded from: classes2.dex */
public final class C4195ad implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    final /* synthetic */ C4245o.C4247b f22528a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C4195ad(C4245o.C4247b c4247b) {
        this.f22528a = c4247b;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        PopupWindow popupWindow;
        List list;
        C4245o.InterfaceC4246a interfaceC4246a;
        C4245o.InterfaceC4246a interfaceC4246a2;
        C4356c c4356c;
        C4356c c4356c2;
        List list2;
        C4356c c4356c3;
        int i2;
        popupWindow = this.f22528a.f22698b;
        popupWindow.dismiss();
        list = this.f22528a.f22706j;
        if (list != null) {
            c4356c2 = this.f22528a.f22699c;
            int m972c = i - c4356c2.m972c();
            list2 = this.f22528a.f22706j;
            if (m972c < list2.size()) {
                this.f22528a.f22703g = i;
                c4356c3 = this.f22528a.f22699c;
                i2 = this.f22528a.f22703g;
                c4356c3.m979a(i2);
            }
        }
        interfaceC4246a = this.f22528a.f22707k;
        if (interfaceC4246a != null) {
            interfaceC4246a2 = this.f22528a.f22707k;
            c4356c = this.f22528a.f22699c;
            interfaceC4246a2.mo1337a(i - c4356c.m972c());
        }
    }
}
