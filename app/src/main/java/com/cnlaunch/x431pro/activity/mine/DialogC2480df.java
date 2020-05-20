package com.cnlaunch.x431pro.activity.mine;

import android.app.Activity;
import android.content.Context;
import com.cnlaunch.diagnosemodule.utils.CopyFile;
import com.cnlaunch.p120d.p130d.NToast;
import com.cnlaunch.x431pro.utils.PathUtils;
import com.cnlaunch.x431pro.widget.p290a.InputDialog;
import com.ifoer.expedition.pro.R;
import java.io.File;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: VehicleVoltageFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.mine.df */
/* loaded from: classes.dex */
public final class DialogC2480df extends InputDialog {

    /* renamed from: a */
    final /* synthetic */ VehicleVoltageFragment f14202a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DialogC2480df(VehicleVoltageFragment vehicleVoltageFragment, Context context, String str, String str2) {
        super(context, str, str2);
        this.f14202a = vehicleVoltageFragment;
    }

    @Override // com.cnlaunch.x431pro.widget.p290a.InputDialog
    /* renamed from: a */
    public final void mo4705a(String str) {
        String str2;
        String str3;
        if (!VehicleVoltageFragment.m6160a(str)) {
            str = this.f14202a.f14166G;
        }
        String str4 = str + ".x431";
        StringBuilder sb = new StringBuilder();
        sb.append(PathUtils.m4843m());
        str2 = this.f14202a.f14165F;
        sb.append(str2);
        int CopySdcardFile = CopyFile.CopySdcardFile(sb.toString(), PathUtils.m4855d() + str4);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(PathUtils.m4843m());
        str3 = this.f14202a.f14165F;
        sb2.append(str3);
        File file = new File(sb2.toString());
        if (file.exists()) {
            file.delete();
        }
        if (CopySdcardFile == 0) {
            NToast.m9443c(this.f14202a.getActivity(), this.f14202a.getString(R.string.datastream_record_rec_success) + "\n" + str4);
        } else {
            NToast.m9443c(this.f14202a.getActivity(), this.f14202a.getString(R.string.datastream_record_rec_fail_for_copy) + "\n" + str4);
        }
        VehicleVoltageFragment.m6136x(this.f14202a);
    }

    @Override // com.cnlaunch.x431pro.widget.p290a.InputDialog
    /* renamed from: e_ */
    public final void mo4701e_() {
        String str;
        String str2;
        StringBuilder sb = new StringBuilder();
        sb.append(PathUtils.m4843m());
        str = this.f14202a.f14165F;
        sb.append(str);
        File file = new File(sb.toString());
        if (file.exists()) {
            file.delete();
        }
        Activity activity = this.f14202a.getActivity();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f14202a.getString(R.string.datastream_record_rec_fail));
        sb2.append("\n");
        str2 = this.f14202a.f14165F;
        sb2.append(str2);
        NToast.m9443c(activity, sb2.toString());
        VehicleVoltageFragment.m6136x(this.f14202a);
    }
}
