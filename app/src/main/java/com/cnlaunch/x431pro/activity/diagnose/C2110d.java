package com.cnlaunch.x431pro.activity.diagnose;

import android.content.Context;
import com.cnlaunch.x431pro.utils.PathUtils;
import com.cnlaunch.x431pro.utils.p283db.CarIcon;
import com.cnlaunch.x431pro.utils.p285e.FileUtils;
import com.cnlaunch.x431pro.utils.p286f.CarIconUtils;
import com.cnlaunch.x431pro.widget.p290a.SelectMessageDialog;
import java.util.List;

/* compiled from: CarIconFragmentForAll.java */
/* renamed from: com.cnlaunch.x431pro.activity.diagnose.d */
/* loaded from: classes.dex */
final class C2110d extends SelectMessageDialog {

    /* renamed from: a */
    final /* synthetic */ List f11846a;

    /* renamed from: b */
    final /* synthetic */ CarIcon f11847b;

    /* renamed from: c */
    final /* synthetic */ CarIconFragmentForAll f11848c;

    @Override // com.cnlaunch.x431pro.widget.p290a.SelectMessageDialog
    /* renamed from: b */
    public final void mo4608b() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2110d(CarIconFragmentForAll carIconFragmentForAll, List list, CarIcon carIcon) {
        this.f11848c = carIconFragmentForAll;
        this.f11846a = list;
        this.f11847b = carIcon;
    }

    @Override // com.cnlaunch.x431pro.widget.p290a.SelectMessageDialog
    /* renamed from: a */
    public final void mo4611a() {
        Context context;
        context = this.f11848c.mContext;
        CarIconUtils carIconUtils = new CarIconUtils(context);
        for (String str : this.f11846a) {
            carIconUtils.m4949f(this.f11847b.f15790n, str);
        }
        FileUtils.m4995g(PathUtils.m4858c() + this.f11847b.f15789m);
        carIconUtils.m4949f(this.f11847b.f15790n, this.f11847b.f15778b);
        this.f11848c.m7552e();
        this.f11848c.m7548g();
    }
}
