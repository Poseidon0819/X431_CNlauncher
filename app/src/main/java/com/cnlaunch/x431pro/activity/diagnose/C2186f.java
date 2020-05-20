package com.cnlaunch.x431pro.activity.diagnose;

import android.content.Context;
import com.cnlaunch.x431pro.p210a.RTUHelper;

/* compiled from: CarIconFragmentForAll.java */
/* renamed from: com.cnlaunch.x431pro.activity.diagnose.f */
/* loaded from: classes.dex */
final class C2186f extends RTUHelper {

    /* renamed from: a */
    final /* synthetic */ CarIconFragmentForAll f12436a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2186f(CarIconFragmentForAll carIconFragmentForAll, Context context) {
        super(context);
        this.f12436a = carIconFragmentForAll;
    }

    @Override // com.cnlaunch.x431pro.p210a.RTUHelper
    /* renamed from: a */
    public final void mo7066a() {
        this.f12436a.getActivity().finish();
    }
}
