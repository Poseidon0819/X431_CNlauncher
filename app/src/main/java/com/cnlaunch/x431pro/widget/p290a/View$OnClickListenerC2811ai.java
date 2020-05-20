package com.cnlaunch.x431pro.widget.p290a;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.view.View;
import org.apache.mina.proxy.handlers.http.ntlm.NTLMConstants;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: GPSOpenDialog.java */
/* renamed from: com.cnlaunch.x431pro.widget.a.ai */
/* loaded from: classes.dex */
public final class View$OnClickListenerC2811ai implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ GPSOpenDialog f16144a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC2811ai(GPSOpenDialog gPSOpenDialog) {
        this.f16144a = gPSOpenDialog;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Intent intent = new Intent();
        intent.setAction("android.settings.LOCATION_SOURCE_SETTINGS");
        intent.setFlags(NTLMConstants.FLAG_UNIDENTIFIED_11);
        try {
            this.f16144a.getContext().startActivity(intent);
        } catch (ActivityNotFoundException unused) {
            intent.setAction("android.settings.SETTINGS");
            try {
                this.f16144a.getContext().startActivity(intent);
            } catch (Exception unused2) {
            }
        }
    }
}
