package com.cnlaunch.x431pro.widget.p290a;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import com.cnlaunch.diagnosemodule.utils.DiagnoseConstants;
import com.cnlaunch.p120d.p130d.NLog;
import com.cnlaunch.x431pro.activity.diagnose.DiagnoseActivity;
import com.cnlaunch.x431pro.activity.upgrade.DownLoadMessageDialog;
import com.cnlaunch.x431pro.widget.button.IconButton;
import com.ifoer.expedition.pro.R;

/* compiled from: DivisionSoftDownloadDialog.java */
/* renamed from: com.cnlaunch.x431pro.widget.a.o */
/* loaded from: classes.dex */
final class DialogC2873o extends DownLoadMessageDialog {

    /* renamed from: a */
    final /* synthetic */ HandlerC2870l f16459a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DialogC2873o(HandlerC2870l handlerC2870l, Context context) {
        super(context);
        this.f16459a = handlerC2870l;
    }

    @Override // com.cnlaunch.x431pro.activity.upgrade.DownLoadMessageDialog
    /* renamed from: b */
    public final void mo4523b() {
        IconButton iconButton;
        Dialog dialog;
        IconButton iconButton2;
        Integer num;
        IconButton iconButton3;
        NLog.m9456a("yhx", "oneOnClickListener enter.");
        iconButton = this.f16459a.f16456a.f16442u;
        iconButton.setText(R.string.down_retry_txt);
        if (this.f16459a.f16456a.f16441t != null) {
            Drawable drawable = this.f16459a.f16456a.f16441t.getResources().getDrawable(R.drawable.select_btn_update_retry);
            drawable.setBounds(0, 0, 50, 50);
            iconButton2 = this.f16459a.f16456a.f16442u;
            iconButton2.setImage(drawable);
            num = this.f16459a.f16456a.f16416F;
            if (num.intValue() >= this.f16459a.f16456a.f16414D.size()) {
                iconButton3 = this.f16459a.f16456a.f16442u;
                iconButton3.setEnabled(false);
            }
        }
        ((DiagnoseActivity) this.f16459a.f16456a.f16441t).mo7089a(DiagnoseConstants.FEEDBACK_SPT_TRANS_DIAG_INFO_EX, new byte[]{0, 0, 1, 0});
        NLog.m9456a("yhx", "oneOnClickListener dismiss.");
        dialog = this.f16459a.f16456a.f16423M;
        dialog.dismiss();
    }

    @Override // com.cnlaunch.x431pro.activity.upgrade.DownLoadMessageDialog
    /* renamed from: c */
    public final void mo4522c() {
        dismiss();
    }
}
