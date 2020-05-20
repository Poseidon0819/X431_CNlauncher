package com.cnlaunch.x431pro.activity.diagnose.p221d;

import android.app.Activity;
import android.content.Context;
import com.cnlaunch.golo3.p165g.C1621v;
import com.cnlaunch.p120d.p130d.NToast;
import com.cnlaunch.x431pro.utils.C2744aa;
import com.cnlaunch.x431pro.utils.PathUtils;
import com.cnlaunch.x431pro.widget.p290a.InputDialog;
import com.ifoer.expedition.pro.R;
import java.io.File;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DataStreamShowFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.diagnose.d.al */
/* loaded from: classes.dex */
public final class DialogC2124al extends InputDialog {

    /* renamed from: a */
    final /* synthetic */ DataStreamShowFragment f11979a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DialogC2124al(DataStreamShowFragment dataStreamShowFragment, Context context, String str, String str2) {
        super(context, str, str2);
        this.f11979a = dataStreamShowFragment;
    }

    @Override // com.cnlaunch.x431pro.widget.p290a.InputDialog
    /* renamed from: a */
    public final void mo4705a(String str) {
        Context context;
        String str2;
        Context context2;
        if (C1621v.m9121a(str) || !C2744aa.m5146g(str)) {
            context = this.f11979a.mContext;
            NToast.m9443c(context, this.f11979a.getString(R.string.invalid_rename));
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(PathUtils.m4855d());
        sb.append("/");
        sb.append(str);
        str2 = this.f11979a.f11921aJ;
        sb.append(str2);
        if (new File(sb.toString()).exists()) {
            context2 = this.f11979a.mContext;
            NToast.m9443c(context2, this.f11979a.getString(R.string.duplicate_rename));
            return;
        }
        DataStreamShowFragment.m7288a(this.f11979a, str);
        DataStreamShowFragment.m7296F(this.f11979a);
        dismiss();
    }

    @Override // com.cnlaunch.x431pro.widget.p290a.InputDialog
    /* renamed from: e_ */
    public final void mo4701e_() {
        String str;
        String str2;
        StringBuilder sb = new StringBuilder();
        sb.append(PathUtils.m4843m());
        str = this.f11979a.f11908W;
        sb.append(str);
        File file = new File(sb.toString());
        if (file.exists()) {
            file.delete();
        }
        Activity activity = this.f11979a.getActivity();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f11979a.getString(R.string.datastream_record_rec_fail));
        sb2.append("\n");
        str2 = this.f11979a.f11908W;
        sb2.append(str2);
        NToast.m9443c(activity, sb2.toString());
        DataStreamShowFragment.m7296F(this.f11979a);
        dismiss();
    }
}
