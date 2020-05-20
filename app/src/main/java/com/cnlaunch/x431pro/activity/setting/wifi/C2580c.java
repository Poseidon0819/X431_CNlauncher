package com.cnlaunch.x431pro.activity.setting.wifi;

import android.content.Context;
import android.widget.CompoundButton;
import com.cnlaunch.p120d.p130d.NToast;
import com.cnlaunch.x431pro.activity.MainActivity;
import com.ifoer.expedition.pro.R;

/* compiled from: DPUWiFiLinkModeSettings.java */
/* renamed from: com.cnlaunch.x431pro.activity.setting.wifi.c */
/* loaded from: classes.dex */
final class C2580c implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a */
    final /* synthetic */ DPUWiFiLinkModeSettings f14876a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2580c(DPUWiFiLinkModeSettings dPUWiFiLinkModeSettings) {
        this.f14876a = dPUWiFiLinkModeSettings;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        Context context;
        if (MainActivity.m7907a()) {
            this.f14876a.m5887a();
            context = this.f14876a.mContext;
            NToast.m9444c(context, (int) R.string.terminate_diag);
            return;
        }
        DPUWiFiLinkModeSettings.m5882a(this.f14876a, compoundButton, z);
    }
}
