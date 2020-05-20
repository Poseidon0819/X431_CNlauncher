package com.cnlaunch.x431pro.activity.diagnose.p221d;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.cnlaunch.p120d.p130d.NToast;
import com.cnlaunch.x431pro.module.p252d.p254b.DiagReportOrHistoryInfo;
import com.cnlaunch.x431pro.utils.p282d.C2752f;
import com.cnlaunch.x431pro.widget.p290a.LoadDialog;
import com.ifoer.expedition.pro.R;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DataStreamShowFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.diagnose.d.ab */
/* loaded from: classes.dex */
public final class C2114ab extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ DataStreamShowFragment f11966a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2114ab(DataStreamShowFragment dataStreamShowFragment) {
        this.f11966a = dataStreamShowFragment;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        Context context2;
        Context context3;
        Context context4;
        Context context5;
        DiagReportOrHistoryInfo diagReportOrHistoryInfo;
        if (intent.getAction().equals("android.bluetooth.device.action.ACL_DISCONNECTED") && this.f11966a.f12357d.mo7083i().isDatastreamRecord()) {
            this.f11966a.m7274k();
        }
        if (intent.getAction().equalsIgnoreCase("com.cnlaunch.report.action_result")) {
            context2 = this.f11966a.mContext;
            LoadDialog.m4681b(context2);
            boolean booleanExtra = intent.getBooleanExtra("save_result", false);
            this.f11966a.f12358e.setEnabled(true);
            if (booleanExtra) {
                if (TextUtils.isEmpty(this.f11966a.f12360g)) {
                    context4 = this.f11966a.mContext;
                    NToast.m9444c(context4, (int) R.string.diagnose_report_saved_success);
                } else {
                    Activity activity = this.f11966a.getActivity();
                    NToast.m9443c(activity, this.f11966a.getString(R.string.diagnose_report_saved_success) + "\n" + this.f11966a.f12360g);
                }
                context5 = this.f11966a.mContext;
                diagReportOrHistoryInfo = this.f11966a.f11913aB;
                C2752f.m5070a(context5, diagReportOrHistoryInfo);
            } else if (TextUtils.isEmpty(this.f11966a.f12360g)) {
                context3 = this.f11966a.mContext;
                NToast.m9444c(context3, (int) R.string.diagnose_report_create_pdf_file_err);
            } else {
                Activity activity2 = this.f11966a.getActivity();
                NToast.m9443c(activity2, this.f11966a.getString(R.string.diagnose_report_create_pdf_file_err) + "\n" + this.f11966a.f12360g);
            }
        }
    }
}
