package com.cnlaunch.x431pro.widget;

import android.view.View;
import com.cnlaunch.x431pro.widget.TesterInfoDropdownEditText;

/* compiled from: TesterInfoDropdownEditText.java */
/* renamed from: com.cnlaunch.x431pro.widget.t */
/* loaded from: classes.dex */
final class View$OnClickListenerC2981t implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ TesterInfoDropdownEditText.C2801a.C2802a f16959a;

    /* renamed from: b */
    final /* synthetic */ TesterInfoDropdownEditText.C2801a f16960b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC2981t(TesterInfoDropdownEditText.C2801a c2801a, TesterInfoDropdownEditText.C2801a.C2802a c2802a) {
        this.f16960b = c2801a;
        this.f16959a = c2802a;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x005e  */
    @Override // android.view.View.OnClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onClick(android.view.View r6) {
        /*
            r5 = this;
            com.cnlaunch.x431pro.widget.TesterInfoDropdownEditText$a$a r6 = r5.f16959a
            android.widget.TextView r6 = r6.f16099a
            java.lang.CharSequence r6 = r6.getText()
            java.lang.String r6 = r6.toString()
            com.cnlaunch.x431pro.widget.TesterInfoDropdownEditText$a r0 = r5.f16960b
            java.util.ArrayList<java.lang.String> r0 = r0.f16097a
            r0.remove(r6)
            com.cnlaunch.x431pro.widget.TesterInfoDropdownEditText$a r0 = r5.f16960b
            com.cnlaunch.x431pro.widget.TesterInfoDropdownEditText r0 = com.cnlaunch.x431pro.widget.TesterInfoDropdownEditText.this
            com.cnlaunch.x431pro.widget.TesterInfoDropdownEditText$a r0 = r0.f16091e
            com.cnlaunch.x431pro.widget.TesterInfoDropdownEditText$a r1 = r5.f16960b
            java.util.ArrayList<java.lang.String> r1 = r1.f16097a
            r0.f16097a = r1
            r0.notifyDataSetChanged()
            com.cnlaunch.x431pro.widget.TesterInfoDropdownEditText$a r0 = r5.f16960b
            com.cnlaunch.x431pro.widget.TesterInfoDropdownEditText r0 = com.cnlaunch.x431pro.widget.TesterInfoDropdownEditText.this
            com.cnlaunch.d.a.j r0 = r0.f16092f
            java.lang.String r1 = "testers"
            java.lang.String r0 = r0.m9591a(r1)
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.List r0 = com.cnlaunch.x431pro.utils.C2787z.m4802q(r0)     // Catch: java.io.IOException -> L3a java.lang.ClassNotFoundException -> L3f java.io.StreamCorruptedException -> L44
            java.util.ArrayList r0 = (java.util.ArrayList) r0     // Catch: java.io.IOException -> L3a java.lang.ClassNotFoundException -> L3f java.io.StreamCorruptedException -> L44
            goto L49
        L3a:
            r0 = move-exception
            r0.printStackTrace()
            goto L48
        L3f:
            r0 = move-exception
            r0.printStackTrace()
            goto L48
        L44:
            r0 = move-exception
            r0.printStackTrace()
        L48:
            r0 = r1
        L49:
            r0.remove(r6)
            com.cnlaunch.x431pro.widget.TesterInfoDropdownEditText$a r1 = r5.f16960b
            com.cnlaunch.x431pro.widget.TesterInfoDropdownEditText r1 = com.cnlaunch.x431pro.widget.TesterInfoDropdownEditText.this
            android.text.Editable r1 = r1.getText()
            java.lang.String r1 = r1.toString()
            boolean r6 = r1.equals(r6)
            if (r6 == 0) goto Lb9
            com.cnlaunch.x431pro.widget.TesterInfoDropdownEditText$a r6 = r5.f16960b
            java.util.ArrayList<java.lang.String> r6 = r6.f16097a
            int r6 = r6.size()
            r1 = 1
            if (r6 <= 0) goto L9a
            com.cnlaunch.x431pro.widget.TesterInfoDropdownEditText$a r6 = r5.f16960b
            java.util.ArrayList<java.lang.String> r6 = r6.f16097a
            r2 = 0
            java.lang.Object r6 = r6.get(r2)
            java.lang.String r6 = (java.lang.String) r6
            com.cnlaunch.x431pro.widget.TesterInfoDropdownEditText$a r3 = r5.f16960b
            com.cnlaunch.x431pro.widget.TesterInfoDropdownEditText r3 = com.cnlaunch.x431pro.widget.TesterInfoDropdownEditText.this
            com.cnlaunch.x431pro.widget.TesterInfoDropdownEditText$a r4 = r5.f16960b
            java.util.ArrayList<java.lang.String> r4 = r4.f16097a
            java.lang.Object r2 = r4.get(r2)
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r3.setText(r2)
            com.cnlaunch.x431pro.widget.TesterInfoDropdownEditText$a r2 = r5.f16960b
            com.cnlaunch.x431pro.widget.TesterInfoDropdownEditText r2 = com.cnlaunch.x431pro.widget.TesterInfoDropdownEditText.this
            com.cnlaunch.d.a.j r2 = r2.f16092f
            java.lang.String r3 = "last_tester"
            r2.m9588a(r3, r6)
            com.cnlaunch.x431pro.widget.TesterInfoDropdownEditText$a r6 = r5.f16960b
            com.cnlaunch.x431pro.widget.TesterInfoDropdownEditText r6 = com.cnlaunch.x431pro.widget.TesterInfoDropdownEditText.this
            android.os.Handler r6 = r6.f16094h
            r6.sendEmptyMessage(r1)
            goto Lb9
        L9a:
            com.cnlaunch.x431pro.widget.TesterInfoDropdownEditText$a r6 = r5.f16960b
            com.cnlaunch.x431pro.widget.TesterInfoDropdownEditText r6 = com.cnlaunch.x431pro.widget.TesterInfoDropdownEditText.this
            java.lang.String r2 = ""
            r6.setText(r2)
            com.cnlaunch.x431pro.widget.TesterInfoDropdownEditText$a r6 = r5.f16960b
            com.cnlaunch.x431pro.widget.TesterInfoDropdownEditText r6 = com.cnlaunch.x431pro.widget.TesterInfoDropdownEditText.this
            android.os.Handler r6 = r6.f16094h
            r6.sendEmptyMessage(r1)
            com.cnlaunch.x431pro.widget.TesterInfoDropdownEditText$a r6 = r5.f16960b
            com.cnlaunch.x431pro.widget.TesterInfoDropdownEditText r6 = com.cnlaunch.x431pro.widget.TesterInfoDropdownEditText.this
            com.cnlaunch.d.a.j r6 = r6.f16092f
            java.lang.String r1 = "last_tester"
            java.lang.String r2 = ""
            r6.m9588a(r1, r2)
        Lb9:
            com.cnlaunch.x431pro.widget.TesterInfoDropdownEditText$a r6 = r5.f16960b     // Catch: java.io.IOException -> Lc9
            com.cnlaunch.x431pro.widget.TesterInfoDropdownEditText r6 = com.cnlaunch.x431pro.widget.TesterInfoDropdownEditText.this     // Catch: java.io.IOException -> Lc9
            com.cnlaunch.d.a.j r6 = r6.f16092f     // Catch: java.io.IOException -> Lc9
            java.lang.String r1 = "testers"
            java.lang.String r0 = com.cnlaunch.x431pro.utils.C2787z.m4817b(r0)     // Catch: java.io.IOException -> Lc9
            r6.m9588a(r1, r0)     // Catch: java.io.IOException -> Lc9
            return
        Lc9:
            r6 = move-exception
            r6.printStackTrace()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cnlaunch.x431pro.widget.View$OnClickListenerC2981t.onClick(android.view.View):void");
    }
}
