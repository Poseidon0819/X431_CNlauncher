package com.cnlaunch.x431pro.activity.diagnose;

import android.content.Context;
import android.os.Handler;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.x431pro.activity.diagnose.p218a.SelectCarVerAdapter;
import com.cnlaunch.x431pro.module.p252d.p254b.CarVersionInfo;
import com.cnlaunch.x431pro.utils.PathUtils;
import com.cnlaunch.x431pro.utils.p285e.FileUtils;
import com.cnlaunch.x431pro.utils.p286f.CarIconUtils;
import com.cnlaunch.x431pro.widget.p290a.SelectMessageDialog;
import java.util.ArrayList;

/* compiled from: SelectSoftVersionFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.diagnose.cd */
/* loaded from: classes.dex */
final class C2106cd extends SelectMessageDialog {

    /* renamed from: a */
    final /* synthetic */ int f11832a;

    /* renamed from: b */
    final /* synthetic */ SelectSoftVersionFragment f11833b;

    @Override // com.cnlaunch.x431pro.widget.p290a.SelectMessageDialog
    /* renamed from: b */
    public final void mo4608b() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2106cd(SelectSoftVersionFragment selectSoftVersionFragment, int i) {
        this.f11833b = selectSoftVersionFragment;
        this.f11832a = i;
    }

    @Override // com.cnlaunch.x431pro.widget.p290a.SelectMessageDialog
    /* renamed from: a */
    public final void mo4611a() {
        PathUtils pathUtils;
        String str;
        String str2;
        ArrayList arrayList;
        CarIconUtils carIconUtils;
        String str3;
        String str4;
        ArrayList arrayList2;
        ArrayList arrayList3;
        SelectCarVerAdapter selectCarVerAdapter;
        ArrayList<CarVersionInfo> arrayList4;
        SelectCarVerAdapter selectCarVerAdapter2;
        Handler handler;
        Context unused;
        pathUtils = this.f11833b.f11675C;
        unused = this.f11833b.mContext;
        str = this.f11833b.f11698w;
        str2 = this.f11833b.f11697v;
        arrayList = this.f11833b.f11693r;
        FileUtils.m4995g(pathUtils.m4859b(str, str2, ((CarVersionInfo) arrayList.get(this.f11832a)).getVersion()));
        carIconUtils = this.f11833b.f11676D;
        str3 = this.f11833b.f11698w;
        str4 = this.f11833b.f11697v;
        arrayList2 = this.f11833b.f11693r;
        carIconUtils.m4956c(str3, str4, ((CarVersionInfo) arrayList2.get(this.f11832a)).getVersion());
        arrayList3 = this.f11833b.f11693r;
        arrayList3.remove(this.f11832a);
        selectCarVerAdapter = this.f11833b.f11685j;
        arrayList4 = this.f11833b.f11693r;
        selectCarVerAdapter.m7483a(arrayList4);
        selectCarVerAdapter2 = this.f11833b.f11685j;
        selectCarVerAdapter2.m7484a(0);
        handler = this.f11833b.f11682K;
        handler.obtainMessage(1).sendToTarget();
        PreferencesManager.m9595a((Context) this.f11833b.getActivity()).m9587a("need_refresh", true);
    }
}
