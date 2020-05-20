package com.cnlaunch.x431pro.activity.login;

import android.content.Intent;
import android.view.View;
import com.cnlaunch.gmap.map.LocationSearchActivity;
import com.mopub.mobileads.VastExtensionXmlManager;

/* compiled from: RegistMerchantActivity.java */
/* renamed from: com.cnlaunch.x431pro.activity.login.bt */
/* loaded from: classes.dex */
final class View$OnClickListenerC2348bt implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ RegistMerchantActivity f13455a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC2348bt(RegistMerchantActivity registMerchantActivity) {
        this.f13455a = registMerchantActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Intent intent = new Intent(this.f13455a, LocationSearchActivity.class);
        intent.putExtra(VastExtensionXmlManager.TYPE, "3");
        this.f13455a.startActivityForResult(intent, 16);
    }
}
