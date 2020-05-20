package com.cnlaunch.p169im.p172c;

import android.content.Context;
import android.content.res.Resources;
import com.cnlaunch.p169im.p174db.GoloDBManager;
import com.cnlaunch.x431pro.activity.golo.p224a.VerificationListAdapter;
import com.cnlaunch.x431pro.module.golo.model.VerificationInfo;
import com.ifoer.expedition.pro.R;

/* compiled from: VerificationFragment.java */
/* renamed from: com.cnlaunch.im.c.af */
/* loaded from: classes.dex */
final class C1704af implements VerificationListAdapter.InterfaceC2232a {

    /* renamed from: a */
    final /* synthetic */ VerificationFragment f9080a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1704af(VerificationFragment verificationFragment) {
        this.f9080a = verificationFragment;
    }

    @Override // com.cnlaunch.x431pro.activity.golo.p224a.VerificationListAdapter.InterfaceC2232a
    /* renamed from: a */
    public final void mo7023a(VerificationInfo verificationInfo) {
        Context context;
        String str;
        VerificationFragment verificationFragment = this.f9080a;
        String str2 = verificationInfo.f15545b;
        String str3 = verificationInfo.f15546c;
        context = this.f9080a.mContext;
        Resources resources = context.getResources();
        str = this.f9080a.f9074d;
        verificationFragment.m8865a(str2, str3, resources.getString(R.string.refuse_you_friend_request, str), false);
        verificationInfo.f15549f = 4;
        GoloDBManager.m8756a(this.f9080a.getActivity()).f9220b.f9227d.update(verificationInfo);
        this.f9080a.request(40026);
    }

    @Override // com.cnlaunch.x431pro.activity.golo.p224a.VerificationListAdapter.InterfaceC2232a
    /* renamed from: b */
    public final void mo7022b(VerificationInfo verificationInfo) {
        this.f9080a.f9076f = verificationInfo;
        this.f9080a.request(40027);
    }
}
