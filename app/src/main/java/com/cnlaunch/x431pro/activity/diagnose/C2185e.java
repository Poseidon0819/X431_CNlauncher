package com.cnlaunch.x431pro.activity.diagnose;

import android.content.Context;
import com.cnlaunch.x431pro.utils.PathUtils;
import com.cnlaunch.x431pro.utils.p283db.CarIcon;
import com.cnlaunch.x431pro.utils.p285e.FileUtils;
import com.cnlaunch.x431pro.utils.p286f.CarIconUtils;
import com.cnlaunch.x431pro.widget.p290a.SelectMessageDialog;

/* compiled from: CarIconFragmentForAll.java */
/* renamed from: com.cnlaunch.x431pro.activity.diagnose.e */
/* loaded from: classes.dex */
final class C2185e extends SelectMessageDialog {

    /* renamed from: a */
    final /* synthetic */ CarIcon f12427a;

    /* renamed from: b */
    final /* synthetic */ CarIconFragmentForAll f12428b;

    @Override // com.cnlaunch.x431pro.widget.p290a.SelectMessageDialog
    /* renamed from: b */
    public final void mo4608b() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2185e(CarIconFragmentForAll carIconFragmentForAll, CarIcon carIcon) {
        this.f12428b = carIconFragmentForAll;
        this.f12427a = carIcon;
    }

    @Override // com.cnlaunch.x431pro.widget.p290a.SelectMessageDialog
    /* renamed from: a */
    public final void mo4611a() {
        Context context;
        FileUtils.m4995g(PathUtils.m4858c() + this.f12427a.f15789m);
        context = this.f12428b.mContext;
        new CarIconUtils(context).m4949f(this.f12427a.f15790n, this.f12427a.f15778b);
        this.f12428b.m7552e();
        this.f12428b.m7548g();
    }
}
