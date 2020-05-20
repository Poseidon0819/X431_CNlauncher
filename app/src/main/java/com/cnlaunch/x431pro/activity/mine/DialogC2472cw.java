package com.cnlaunch.x431pro.activity.mine;

import android.content.Context;
import com.cnlaunch.golo3.p165g.C1621v;
import com.cnlaunch.p118c.p119a.MyTools;
import com.cnlaunch.p120d.p130d.NToast;
import com.cnlaunch.x431pro.activity.mine.p229a.MyReportAdapter;
import com.cnlaunch.x431pro.activity.mine.p229a.NewLocalReportAdapter;
import com.cnlaunch.x431pro.module.p252d.p254b.DiagReportOrHistoryInfo;
import com.cnlaunch.x431pro.module.p255e.p257b.ReportFileInfo;
import com.cnlaunch.x431pro.utils.PathUtils;
import com.cnlaunch.x431pro.utils.p282d.C2752f;
import com.cnlaunch.x431pro.utils.p285e.FileUtils;
import com.cnlaunch.x431pro.widget.p290a.InputDialog;
import com.ifoer.expedition.pro.R;
import java.io.File;
import java.util.List;

/* compiled from: ReportPagersFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.mine.cw */
/* loaded from: classes.dex */
final class DialogC2472cw extends InputDialog {

    /* renamed from: a */
    final /* synthetic */ ReportPagersFragment f14114a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DialogC2472cw(ReportPagersFragment reportPagersFragment, Context context, String str, String str2) {
        super(context, str, str2);
        this.f14114a = reportPagersFragment;
    }

    @Override // com.cnlaunch.x431pro.widget.p290a.InputDialog
    /* renamed from: a */
    public final void mo4705a(String str) {
        Context context;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        Context context2;
        int m6229a;
        MyReportAdapter myReportAdapter;
        List<ReportFileInfo> list;
        Context context3;
        List list2;
        Context context4;
        int i;
        String str7;
        String str8;
        String str9;
        String str10;
        NewLocalReportAdapter newLocalReportAdapter;
        List<DiagReportOrHistoryInfo> list3;
        Context context5;
        Context context6;
        if (C1621v.m9121a(str) || !MyTools.m9635b(str)) {
            context = this.f14114a.mContext;
            NToast.m9443c(context, this.f14114a.getString(R.string.invalid_rename));
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(PathUtils.m4855d());
        sb.append("/");
        sb.append(str);
        str2 = this.f14114a.f14069D;
        sb.append(str2);
        File file = new File(sb.toString());
        if (file.exists()) {
            context6 = this.f14114a.mContext;
            NToast.m9443c(context6, this.f14114a.getString(R.string.duplicate_rename));
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        str3 = this.f14114a.f14070E;
        sb2.append(str3);
        str4 = this.f14114a.f14068C;
        sb2.append(str4);
        str5 = this.f14114a.f14069D;
        sb2.append(str5);
        File file2 = new File(sb2.toString());
        StringBuilder sb3 = new StringBuilder();
        sb3.append(str);
        str6 = this.f14114a.f14069D;
        sb3.append(str6);
        if (FileUtils.m5019a(file2, sb3.toString())) {
            m6229a = this.f14114a.m6229a();
            if (m6229a == 0) {
                list2 = this.f14114a.f14081e;
                DiagReportOrHistoryInfo diagReportOrHistoryInfo = (DiagReportOrHistoryInfo) list2.get(0);
                diagReportOrHistoryInfo.setPdfFileName(file.getAbsolutePath());
                diagReportOrHistoryInfo.setCheck(false);
                if (diagReportOrHistoryInfo.getType() != 5) {
                    context5 = this.f14114a.mContext;
                    C2752f.m5070a(context5, diagReportOrHistoryInfo);
                }
                ReportPagersFragment reportPagersFragment = this.f14114a;
                context4 = reportPagersFragment.mContext;
                i = this.f14114a.f14071F;
                str7 = this.f14114a.f14072G;
                str8 = this.f14114a.f14073H;
                str9 = this.f14114a.f14074I;
                str10 = this.f14114a.f14075J;
                reportPagersFragment.f14077a = C2752f.m5072a(context4, i, str7, str8, str9, str10);
                newLocalReportAdapter = this.f14114a.f14096t;
                list3 = this.f14114a.f14077a;
                newLocalReportAdapter.m6504a(list3);
            } else {
                this.f14114a.f14079c = ReportPagersFragment.m6225a(PathUtils.m4855d(), 2);
                myReportAdapter = this.f14114a.f14097u;
                list = this.f14114a.f14079c;
                myReportAdapter.m6511a(list);
            }
            context3 = this.f14114a.mContext;
            NToast.m9446b(context3, this.f14114a.getResources().getString(R.string.rename_success));
        } else {
            context2 = this.f14114a.mContext;
            NToast.m9446b(context2, this.f14114a.getResources().getString(R.string.rename_fail));
        }
        dismiss();
    }

    @Override // com.cnlaunch.x431pro.widget.p290a.InputDialog
    /* renamed from: e_ */
    public final void mo4701e_() {
        dismiss();
    }
}
