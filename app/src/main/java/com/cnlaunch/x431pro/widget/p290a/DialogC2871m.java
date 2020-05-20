package com.cnlaunch.x431pro.widget.p290a;

import android.content.Context;
import com.cnlaunch.diagnosemodule.utils.DiagnoseConstants;
import com.cnlaunch.x431pro.activity.diagnose.DiagnoseActivity;
import com.cnlaunch.x431pro.module.p269j.p271b.DownloadSoftDto;
import java.util.Iterator;

/* compiled from: DivisionSoftDownloadDialog.java */
/* renamed from: com.cnlaunch.x431pro.widget.a.m */
/* loaded from: classes.dex */
final class DialogC2871m extends MessageDialog {

    /* renamed from: a */
    final /* synthetic */ HandlerC2870l f16457a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DialogC2871m(HandlerC2870l handlerC2870l, Context context) {
        super(context);
        this.f16457a = handlerC2870l;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        boolean z;
        super.dismiss();
        r0.f16419I.sendMessage(this.f16457a.f16456a.f16419I.obtainMessage(1, 0, 0));
        Iterator it = this.f16457a.f16456a.f16414D.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = true;
                break;
            }
            DownloadSoftDto downloadSoftDto = (DownloadSoftDto) it.next();
            if (downloadSoftDto.f15588n && downloadSoftDto.f15579e.intValue() != 4) {
                z = false;
                break;
            }
        }
        if (z) {
            ((DiagnoseActivity) this.f16457a.f16456a.f16441t).mo7089a(DiagnoseConstants.FEEDBACK_SPT_TRANS_DIAG_INFO_EX, new byte[]{0, 0, 1, 0});
        } else {
            ((DiagnoseActivity) this.f16457a.f16456a.f16441t).mo7089a(DiagnoseConstants.FEEDBACK_SPT_TRANS_DIAG_INFO_EX, new byte[]{0, 0, 1, 1});
        }
    }
}
