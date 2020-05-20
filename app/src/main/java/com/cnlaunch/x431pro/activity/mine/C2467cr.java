package com.cnlaunch.x431pro.activity.mine;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import com.cnlaunch.x431pro.activity.mine.p230b.DiagnosisPlaybackFragment;
import com.cnlaunch.x431pro.module.p255e.p257b.ReportFileInfo;
import com.cnlaunch.x431pro.utils.PathUtils;
import java.util.List;

/* compiled from: ReportPagersFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.mine.cr */
/* loaded from: classes.dex */
final class C2467cr implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    final /* synthetic */ ReportPagersFragment f14110a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2467cr(ReportPagersFragment reportPagersFragment) {
        this.f14110a = reportPagersFragment;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        Bundle bundle;
        List list;
        Bundle bundle2;
        bundle = this.f14110a.bundle;
        StringBuilder sb = new StringBuilder();
        sb.append(PathUtils.m4855d());
        sb.append("/");
        list = this.f14110a.f14079c;
        sb.append(((ReportFileInfo) list.get(i - 1)).getReportName());
        bundle.putString("report_name", sb.toString());
        ReportPagersFragment reportPagersFragment = this.f14110a;
        String name = DiagnosisPlaybackFragment.class.getName();
        bundle2 = this.f14110a.bundle;
        reportPagersFragment.replaceFragment(name, bundle2);
    }
}
