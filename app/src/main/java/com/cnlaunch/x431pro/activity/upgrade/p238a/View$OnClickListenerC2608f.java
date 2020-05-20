package com.cnlaunch.x431pro.activity.upgrade.p238a;

import android.content.Context;
import android.view.View;
import com.cnlaunch.x431pro.module.p269j.p271b.DownloadSoftDto;
import com.cnlaunch.x431pro.utils.C2778n;
import com.cnlaunch.x431pro.utils.PathUtils;

/* compiled from: DownloadAdapter.java */
/* renamed from: com.cnlaunch.x431pro.activity.upgrade.a.f */
/* loaded from: classes.dex */
final class View$OnClickListenerC2608f implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ DownloadSoftDto f15015a;

    /* renamed from: b */
    final /* synthetic */ DownloadAdapter f15016b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC2608f(DownloadAdapter downloadAdapter, DownloadSoftDto downloadSoftDto) {
        this.f15016b = downloadAdapter;
        this.f15015a = downloadSoftDto;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Context context;
        if (1 == this.f15015a.f15577c) {
            context = this.f15016b.f15006b;
            C2778n.m4903b(context, PathUtils.m4852e() + "/" + this.f15015a.f15580f);
        }
    }
}
