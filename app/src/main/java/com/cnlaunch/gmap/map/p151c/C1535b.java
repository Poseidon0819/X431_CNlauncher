package com.cnlaunch.gmap.map.p151c;

import android.content.Context;
import android.content.Intent;
import com.cnlaunch.gmap.map.p152d.NormalDialog;
import org.apache.mina.proxy.handlers.http.ntlm.NTLMConstants;

/* compiled from: GpsConnectUtil.java */
/* renamed from: com.cnlaunch.gmap.map.c.b */
/* loaded from: classes.dex */
public final class C1535b implements NormalDialog.InterfaceC1540a {

    /* renamed from: a */
    final /* synthetic */ Context f7596a;

    /* renamed from: b */
    final /* synthetic */ NormalDialog f7597b;

    public C1535b(Context context, NormalDialog normalDialog) {
        this.f7596a = context;
        this.f7597b = normalDialog;
    }

    @Override // com.cnlaunch.gmap.map.p152d.NormalDialog.InterfaceC1540a
    /* renamed from: a */
    public final void mo9275a() {
        Context context = this.f7596a;
        Intent intent = new Intent();
        try {
            try {
                intent.setAction("android.settings.LOCATION_SOURCE_SETTINGS");
                intent.setFlags(NTLMConstants.FLAG_UNIDENTIFIED_11);
            } catch (Exception e) {
                e.printStackTrace();
                intent.setAction("android.settings.SETTINGS");
            }
            this.f7597b.dismiss();
        } finally {
            context.startActivity(intent);
        }
    }

    @Override // com.cnlaunch.gmap.map.p152d.NormalDialog.InterfaceC1540a
    /* renamed from: b */
    public final void mo9274b() {
        this.f7597b.dismiss();
    }
}
