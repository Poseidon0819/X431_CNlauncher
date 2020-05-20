package com.cnlaunch.x431pro.activity.mine;

import android.content.Context;
import android.text.TextUtils;
import com.cnlaunch.p120d.p130d.NToast;
import com.cnlaunch.x431pro.widget.p290a.InputDialog;
import com.ifoer.expedition.pro.R;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PersonInformationFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.mine.bw */
/* loaded from: classes.dex */
public final class DialogC2448bw extends InputDialog {

    /* renamed from: a */
    final /* synthetic */ String f14008a;

    /* renamed from: b */
    final /* synthetic */ PersonInformationFragment f14009b;

    @Override // com.cnlaunch.x431pro.widget.p290a.InputDialog
    /* renamed from: e_ */
    public final void mo4701e_() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DialogC2448bw(PersonInformationFragment personInformationFragment, Context context, String str, String str2, String str3) {
        super(context, str, str2);
        this.f14009b = personInformationFragment;
        this.f14008a = str3;
    }

    @Override // com.cnlaunch.x431pro.widget.p290a.InputDialog
    /* renamed from: a */
    public final void mo4705a(String str) {
        Context context;
        if (TextUtils.isEmpty(str)) {
            context = this.f14009b.mContext;
            NToast.m9449a(context, String.format(this.f14009b.getString(R.string.not_empty), this.f14008a));
            return;
        }
        PersonInformationFragment.m6274a(this.f14009b, str);
        dismiss();
    }
}
