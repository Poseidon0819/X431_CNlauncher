package com.cnlaunch.x431pro.activity.diagnose;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.cnlaunch.p120d.p130d.NToast;
import com.cnlaunch.x431pro.module.p252d.p254b.DiagReportOrHistoryInfo;
import com.cnlaunch.x431pro.utils.p282d.C2752f;
import com.cnlaunch.x431pro.widget.button.IconButton;
import com.cnlaunch.x431pro.widget.p290a.LoadDialog;
import com.ifoer.expedition.pro.R;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ReportShowFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.diagnose.bw */
/* loaded from: classes.dex */
public final class C2085bw extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ ReportShowFragment f11669a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2085bw(ReportShowFragment reportShowFragment) {
        this.f11669a = reportShowFragment;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        Context context2;
        Context context3;
        IconButton iconButton;
        Context context4;
        Context context5;
        DiagReportOrHistoryInfo diagReportOrHistoryInfo;
        if (intent != null && intent.getAction().equalsIgnoreCase("com.cnlaunch.report.action_result")) {
            context2 = this.f11669a.mContext;
            LoadDialog.m4681b(context2);
            boolean booleanExtra = intent.getBooleanExtra("save_result", false);
            this.f11669a.f12358e.setEnabled(true);
            this.f11669a.f12359f.setEnabled(true);
            if (booleanExtra) {
                iconButton = this.f11669a.f11628ae;
                iconButton.setEnabled(true);
                context4 = this.f11669a.mContext;
                NToast.m9450a(context4, (int) R.string.diagnose_report_saved_success);
                context5 = this.f11669a.mContext;
                diagReportOrHistoryInfo = this.f11669a.f11646aw;
                C2752f.m5070a(context5, diagReportOrHistoryInfo);
                return;
            }
            context3 = this.f11669a.mContext;
            NToast.m9450a(context3, (int) R.string.diagnose_report_create_pdf_file_err);
        }
    }
}
