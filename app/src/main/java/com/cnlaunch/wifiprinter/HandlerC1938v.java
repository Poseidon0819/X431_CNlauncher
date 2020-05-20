package com.cnlaunch.wifiprinter;

import android.os.Handler;
import android.os.Message;
import android.widget.TextView;
import com.cnlaunch.wifiprinter.C1900at;
import com.itextpdf.text.pdf.codec.TIFFConstants;
import java.util.Timer;
import org.codehaus.jackson.util.MinimalPrettyPrinter;

/* compiled from: PrintTestTwo.java */
/* renamed from: com.cnlaunch.wifiprinter.v */
/* loaded from: classes.dex */
final class HandlerC1938v extends Handler {

    /* renamed from: a */
    final /* synthetic */ FragmentC1934u f10537a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public HandlerC1938v(FragmentC1934u fragmentC1934u) {
        this.f10537a = fragmentC1934u;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message2) {
        switch (message2.what) {
            case TIFFConstants.TIFFTAG_RESOLUTIONUNIT /* 296 */:
                this.f10537a.f10514g.setTextColor(this.f10537a.f10519m.getResources().getColor(C1900at.C1902b.black));
                TextView textView = this.f10537a.f10514g;
                textView.setText(this.f10537a.f10519m.getResources().getString(C1900at.C1907g.connettolan) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + this.f10537a.f10525s + " ...\n" + this.f10537a.f10519m.getResources().getString(C1900at.C1907g.connetok));
                new Timer().schedule(new C1939w(this), 1000L);
                return;
            case TIFFConstants.TIFFTAG_PAGENUMBER /* 297 */:
                this.f10537a.f10514g.setTextColor(this.f10537a.f10519m.getResources().getColor(C1900at.C1902b.red));
                TextView textView2 = this.f10537a.f10514g;
                textView2.setText("\n" + this.f10537a.f10519m.getResources().getString(C1900at.C1907g.Reason3));
                this.f10537a.f10510c.setEnabled(true);
                this.f10537a.f10510c.setTextColor(this.f10537a.f10519m.getResources().getColor(C1900at.C1902b.white));
                this.f10537a.f10508a.setEnabled(true);
                return;
            default:
                return;
        }
    }
}
