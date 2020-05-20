package com.cnlaunch.x431pro.activity.login;

import android.widget.CompoundButton;
import java.util.HashMap;

/* compiled from: CarSeriesAdapter.java */
/* renamed from: com.cnlaunch.x431pro.activity.login.h */
/* loaded from: classes.dex */
final class C2366h implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a */
    final /* synthetic */ int f13496a;

    /* renamed from: b */
    final /* synthetic */ CarSeriesAdapter f13497b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2366h(CarSeriesAdapter carSeriesAdapter, int i) {
        this.f13497b = carSeriesAdapter;
        this.f13496a = i;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        HashMap hashMap;
        HashMap hashMap2;
        if (z) {
            hashMap2 = CarSeriesAdapter.f13490c;
            hashMap2.put(Integer.valueOf(this.f13496a), Boolean.TRUE);
            return;
        }
        hashMap = CarSeriesAdapter.f13490c;
        hashMap.put(Integer.valueOf(this.f13496a), Boolean.FALSE);
    }
}
