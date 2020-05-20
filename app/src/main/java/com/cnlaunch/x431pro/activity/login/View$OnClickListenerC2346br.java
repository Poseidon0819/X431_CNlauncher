package com.cnlaunch.x431pro.activity.login;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import java.util.ArrayList;

/* compiled from: RegistMerchantActivity.java */
/* renamed from: com.cnlaunch.x431pro.activity.login.br */
/* loaded from: classes.dex */
final class View$OnClickListenerC2346br implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ RegistMerchantActivity f13453a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC2346br(RegistMerchantActivity registMerchantActivity) {
        this.f13453a = registMerchantActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Context context;
        ArrayList arrayList;
        ArrayList<String> arrayList2;
        context = this.f13453a.f10981q;
        Intent intent = new Intent(context, RegistMerchantSelectCarActivity.class);
        arrayList = this.f13453a.f13308ah;
        if (arrayList != null) {
            arrayList2 = this.f13453a.f13308ah;
            intent.putStringArrayListExtra("selectCarSeriesList", arrayList2);
        }
        this.f13453a.startActivityForResult(intent, 18);
    }
}
