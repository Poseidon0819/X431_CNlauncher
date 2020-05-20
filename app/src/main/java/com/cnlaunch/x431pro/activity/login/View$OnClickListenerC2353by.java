package com.cnlaunch.x431pro.activity.login;

import android.content.Intent;
import android.view.View;
import com.cnlaunch.x431pro.activity.p213b.p215b.CarSeriesInfo;
import java.util.ArrayList;
import java.util.List;

/* compiled from: RegistMerchantSelectCarActivity.java */
/* renamed from: com.cnlaunch.x431pro.activity.login.by */
/* loaded from: classes.dex */
final class View$OnClickListenerC2353by implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ RegistMerchantSelectCarActivity f13462a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC2353by(RegistMerchantSelectCarActivity registMerchantSelectCarActivity) {
        this.f13462a = registMerchantSelectCarActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        ArrayList<String> arrayList;
        ArrayList arrayList2;
        List list;
        this.f13462a.f13322H = new ArrayList();
        for (int i = 0; i < CarSeriesAdapter.m6537a().size(); i++) {
            if (CarSeriesAdapter.m6537a().get(Integer.valueOf(i)).booleanValue()) {
                arrayList2 = this.f13462a.f13322H;
                list = this.f13462a.f13320F;
                arrayList2.add(((CarSeriesInfo) list.get(i)).getCarSeriesName());
            }
        }
        Intent intent = new Intent();
        arrayList = this.f13462a.f13322H;
        intent.putStringArrayListExtra("selectCarSeriesList", arrayList);
        this.f13462a.setResult(-1, intent);
        this.f13462a.finish();
    }
}
