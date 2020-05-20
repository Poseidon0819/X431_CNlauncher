package com.launch.p353a.p359f;

import android.os.Handler;
import android.widget.TextView;
import com.itextpdf.text.html.HtmlTags;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ClickManager.java */
/* renamed from: com.launch.a.f.c */
/* loaded from: classes.dex */
public final class RunnableC3658c implements Runnable {

    /* renamed from: a */
    final /* synthetic */ ClickManager f19946a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC3658c(ClickManager clickManager) {
        this.f19946a = clickManager;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i;
        Handler handler;
        TextView textView;
        int i2;
        Handler handler2;
        i = this.f19946a.f19942k;
        if (i >= 0) {
            textView = this.f19946a.f19941j;
            StringBuilder sb = new StringBuilder();
            i2 = this.f19946a.f19942k;
            sb.append(i2);
            sb.append(HtmlTags.f19633S);
            textView.setText(sb.toString());
            ClickManager.m2661k(this.f19946a);
            handler2 = this.f19946a.f19944m;
            handler2.postDelayed(this, 1000L);
            return;
        }
        handler = this.f19946a.f19944m;
        handler.sendEmptyMessage(0);
    }
}
