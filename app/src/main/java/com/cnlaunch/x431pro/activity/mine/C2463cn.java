package com.cnlaunch.x431pro.activity.mine;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import com.cnlaunch.p120d.p130d.NToast;
import com.cnlaunch.x431pro.module.p252d.p254b.DiagReportOrHistoryInfo;
import com.ifoer.expedition.pro.R;
import java.io.File;
import java.util.List;

/* compiled from: ReportPagersFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.mine.cn */
/* loaded from: classes.dex */
final class C2463cn implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    final /* synthetic */ ReportPagersFragment f14106a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2463cn(ReportPagersFragment reportPagersFragment) {
        this.f14106a = reportPagersFragment;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        List list;
        Context context;
        list = this.f14106a.f14077a;
        String pdfFileName = ((DiagReportOrHistoryInfo) list.get(i - 1)).getPdfFileName();
        if (!new File(pdfFileName).exists()) {
            context = this.f14106a.mContext;
            NToast.m9450a(context, (int) R.string.report_file_unexists);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("report_name", pdfFileName);
        bundle.putString("title", this.f14106a.getString(R.string.mine_tv_diagnosis_report));
        bundle.putBoolean("needLeftPadding", true);
        if (pdfFileName.endsWith(".pdf")) {
            this.f14106a.replaceFragment(PDFReportFragment.class.getName(), bundle);
        } else {
            this.f14106a.replaceFragment(ReadReportFragment.class.getName(), bundle);
        }
    }
}
