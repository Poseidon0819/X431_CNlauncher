package com.cnlaunch.wifiprinter;

import android.view.View;
import com.cnlaunch.wifiprinter.C1900at;
import com.cnlaunch.wifiprinter.PrinterLinkLocalNet;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PrinterLinkLocalNet.java */
/* renamed from: com.cnlaunch.wifiprinter.ao */
/* loaded from: classes.dex */
public final class View$OnClickListenerC1896ao implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ PrinterLinkLocalNet f10400a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC1896ao(PrinterLinkLocalNet printerLinkLocalNet) {
        this.f10400a = printerLinkLocalNet;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.f10400a.f10381v.clear();
        if (this.f10400a.f10371l != null) {
            this.f10400a.f10371l.notifyDataSetChanged();
        }
        PrinterLinkLocalNet.f10359i.setVisibility(0);
        this.f10400a.f10373n.setEnabled(false);
        this.f10400a.f10373n.setTextColor(this.f10400a.f10370k.getResources().getColor(C1900at.C1902b.hui1));
        PrinterLinkLocalNet printerLinkLocalNet = this.f10400a;
        new PrinterLinkLocalNet.C1887c(printerLinkLocalNet.f10370k).start();
    }
}
