package com.cnlaunch.wifiprinter;

import com.cnlaunch.wifiprinter.WifiConnect;
import com.itextpdf.text.pdf.codec.TIFFConstants;

/* compiled from: MainActivity.java */
/* renamed from: com.cnlaunch.wifiprinter.f */
/* loaded from: classes.dex */
final class C1918f implements WifiConnect.InterfaceC1911c {

    /* renamed from: a */
    final /* synthetic */ MainActivity f10452a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1918f(MainActivity mainActivity) {
        this.f10452a = mainActivity;
    }

    @Override // com.cnlaunch.wifiprinter.WifiConnect.InterfaceC1911c
    /* renamed from: a */
    public final void mo8005a() {
        this.f10452a.f10436n.sendEmptyMessage(TIFFConstants.TIFFTAG_SOFTWARE);
    }
}
