package com.cnlaunch.x431pro.activity.mine;

import android.text.TextWatcher;
import android.widget.Button;

/* compiled from: ConnectorActivateFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.mine.u */
/* loaded from: classes.dex */
final class C2495u implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ ConnectorActivateFragment f14314a;

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2495u(ConnectorActivateFragment connectorActivateFragment) {
        this.f14314a = connectorActivateFragment;
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        Button button;
        button = this.f14314a.f14308v;
        button.setEnabled(this.f14314a.m6107a());
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0061, code lost:
        if (com.cnlaunch.x431pro.utils.C2744aa.m5161c(r4, r2) != false) goto L11;
     */
    @Override // android.text.TextWatcher
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void afterTextChanged(android.text.Editable r4) {
        /*
            r3 = this;
            com.cnlaunch.x431pro.activity.mine.s r4 = r3.f14314a
            android.widget.EditText r0 = com.cnlaunch.x431pro.activity.mine.ConnectorActivateFragment.m6098c(r4)
            android.text.Editable r0 = r0.getText()
            java.lang.String r0 = r0.toString()
            com.cnlaunch.x431pro.activity.mine.ConnectorActivateFragment.m6103a(r4, r0)
            com.cnlaunch.x431pro.activity.mine.s r4 = r3.f14314a
            java.lang.String r4 = com.cnlaunch.x431pro.activity.mine.ConnectorActivateFragment.m6097d(r4)
            int r4 = r4.length()
            r0 = 1
            r1 = 12
            if (r4 != r1) goto L77
            com.cnlaunch.x431pro.activity.mine.s r4 = r3.f14314a
            java.lang.String r4 = com.cnlaunch.x431pro.activity.mine.ConnectorActivateFragment.m6097d(r4)
            boolean r4 = com.cnlaunch.x431pro.utils.C2787z.m4818b(r4)
            r1 = 0
            if (r4 == 0) goto L6d
            com.cnlaunch.x431pro.activity.mine.s r4 = r3.f14314a
            java.lang.String r4 = com.cnlaunch.x431pro.activity.mine.ConnectorActivateFragment.m6097d(r4)
            com.cnlaunch.x431pro.activity.mine.s r2 = r3.f14314a
            android.content.Context r2 = com.cnlaunch.x431pro.activity.mine.ConnectorActivateFragment.m6096e(r2)
            boolean r4 = com.cnlaunch.x431pro.utils.C2744aa.m5168b(r4, r2)
            if (r4 != 0) goto L63
            com.cnlaunch.x431pro.activity.mine.s r4 = r3.f14314a
            java.lang.String r4 = com.cnlaunch.x431pro.activity.mine.ConnectorActivateFragment.m6097d(r4)
            com.cnlaunch.x431pro.activity.mine.s r2 = r3.f14314a
            android.content.Context r2 = com.cnlaunch.x431pro.activity.mine.ConnectorActivateFragment.m6095f(r2)
            boolean r4 = com.cnlaunch.x431pro.utils.C2744aa.m5177a(r4, r2)
            if (r4 != 0) goto L63
            com.cnlaunch.x431pro.activity.mine.s r4 = r3.f14314a
            java.lang.String r4 = com.cnlaunch.x431pro.activity.mine.ConnectorActivateFragment.m6097d(r4)
            com.cnlaunch.x431pro.activity.mine.s r2 = r3.f14314a
            android.content.Context r2 = com.cnlaunch.x431pro.activity.mine.ConnectorActivateFragment.m6094g(r2)
            boolean r4 = com.cnlaunch.x431pro.utils.C2744aa.m5161c(r4, r2)
            if (r4 == 0) goto L6d
        L63:
            com.cnlaunch.x431pro.activity.mine.s r4 = r3.f14314a
            android.widget.CheckBox r4 = com.cnlaunch.x431pro.activity.mine.ConnectorActivateFragment.m6093h(r4)
            com.cnlaunch.x431pro.activity.mine.ConnectorActivateFragment.m6105a(r4, r1, r0)
            goto L81
        L6d:
            com.cnlaunch.x431pro.activity.mine.s r4 = r3.f14314a
            android.widget.CheckBox r4 = com.cnlaunch.x431pro.activity.mine.ConnectorActivateFragment.m6093h(r4)
            com.cnlaunch.x431pro.activity.mine.ConnectorActivateFragment.m6105a(r4, r1, r1)
            goto L81
        L77:
            com.cnlaunch.x431pro.activity.mine.s r4 = r3.f14314a
            android.widget.CheckBox r4 = com.cnlaunch.x431pro.activity.mine.ConnectorActivateFragment.m6093h(r4)
            r1 = 4
            com.cnlaunch.x431pro.activity.mine.ConnectorActivateFragment.m6105a(r4, r1, r0)
        L81:
            com.cnlaunch.x431pro.activity.mine.s r4 = r3.f14314a
            android.widget.Button r4 = com.cnlaunch.x431pro.activity.mine.ConnectorActivateFragment.m6101b(r4)
            com.cnlaunch.x431pro.activity.mine.s r0 = r3.f14314a
            boolean r0 = r0.m6107a()
            r4.setEnabled(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cnlaunch.x431pro.activity.mine.C2495u.afterTextChanged(android.text.Editable):void");
    }
}
