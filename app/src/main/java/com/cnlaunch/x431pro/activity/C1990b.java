package com.cnlaunch.x431pro.activity;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.cnlaunch.x431pro.module.p252d.p254b.AdvertiseResponse;
import com.cnlaunch.x431pro.widget.cycleviewpager.CycleViewPager;

/* compiled from: AdvertiseShowActivity.java */
/* renamed from: com.cnlaunch.x431pro.activity.b */
/* loaded from: classes.dex */
final class C1990b implements CycleViewPager.InterfaceC2900a {

    /* renamed from: a */
    final /* synthetic */ AdvertiseShowActivity f10885a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1990b(AdvertiseShowActivity advertiseShowActivity) {
        this.f10885a = advertiseShowActivity;
    }

    @Override // com.cnlaunch.x431pro.widget.cycleviewpager.CycleViewPager.InterfaceC2900a
    /* renamed from: a */
    public final void mo4481a(AdvertiseResponse advertiseResponse) {
        if (advertiseResponse == null || TextUtils.isEmpty(advertiseResponse.getLinkUrl())) {
            return;
        }
        this.f10885a.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(advertiseResponse.getLinkUrl())));
    }
}
