package com.cnlaunch.x431pro.activity.mine;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import com.cnlaunch.x431pro.module.report.p277b.DownLoadReportInfo;
import java.util.ArrayList;

/* compiled from: ReportPagersFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.mine.cp */
/* loaded from: classes.dex */
final class C2465cp implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    final /* synthetic */ ReportPagersFragment f14108a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2465cp(ReportPagersFragment reportPagersFragment) {
        this.f14108a = reportPagersFragment;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        Bundle bundle;
        ArrayList arrayList;
        Bundle bundle2;
        bundle = this.f14108a.bundle;
        arrayList = this.f14108a.f14078b;
        bundle.putString("urlkey", ((DownLoadReportInfo) arrayList.get(i - 1)).getUrl());
        ReportPagersFragment reportPagersFragment = this.f14108a;
        String name = WebRemoteDiagReportFragment.class.getName();
        bundle2 = this.f14108a.bundle;
        reportPagersFragment.replaceFragment(name, bundle2);
    }
}
