package com.cnlaunch.x431pro.activity.diagnose.p221d;

import android.content.Context;
import android.view.View;
import com.cnlaunch.x431pro.utils.C2744aa;
import com.cnlaunch.x431pro.utils.C2778n;
import com.cnlaunch.x431pro.utils.p281c.DateStyle;
import com.cnlaunch.x431pro.utils.p281c.DateUtils;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SpeciaFunctionFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.diagnose.d.ca */
/* loaded from: classes.dex */
public final class View$OnClickListenerC2159ca implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ SpeciaFunctionFragment f12233a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC2159ca(SpeciaFunctionFragment speciaFunctionFragment) {
        this.f12233a = speciaFunctionFragment;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Context context;
        if (C2778n.m4905b()) {
            return;
        }
        String m5094a = DateUtils.m5094a(DateStyle.f15729g);
        context = this.f12233a.mContext;
        if (!C2744aa.m5128p(context)) {
            this.f12233a.f12196J = m5094a;
        } else {
            this.f12233a.f12196J = DateUtils.m5092a(m5094a, DateStyle.f15731i);
        }
        SpeciaFunctionFragment speciaFunctionFragment = this.f12233a;
        speciaFunctionFragment.f12360g = speciaFunctionFragment.m7124a(1, m5094a);
        SpeciaFunctionFragment.m7162i(this.f12233a);
    }
}
