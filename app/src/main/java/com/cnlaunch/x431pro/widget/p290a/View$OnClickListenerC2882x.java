package com.cnlaunch.x431pro.widget.p290a;

import android.app.Dialog;
import android.view.View;
import com.cnlaunch.diagnosemodule.utils.DiagnoseConstants;
import com.cnlaunch.x431pro.activity.diagnose.DiagnoseActivity;
import com.cnlaunch.x431pro.module.p269j.p271b.DownloadSoftDto;
import java.util.Iterator;
import java.util.concurrent.ThreadPoolExecutor;

/* compiled from: DivisionSoftDownloadDialog.java */
/* renamed from: com.cnlaunch.x431pro.widget.a.x */
/* loaded from: classes.dex */
final class View$OnClickListenerC2882x implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ DivisionSoftDownloadDialog f16468a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC2882x(DivisionSoftDownloadDialog divisionSoftDownloadDialog) {
        this.f16468a = divisionSoftDownloadDialog;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        ThreadPoolExecutor threadPoolExecutor;
        boolean z;
        Dialog dialog;
        this.f16468a.f16412B.f7053a = null;
        this.f16468a.f16412B.m9549c();
        threadPoolExecutor = this.f16468a.f16413C;
        threadPoolExecutor.shutdownNow();
        Iterator it = this.f16468a.f16414D.iterator();
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
            ((DiagnoseActivity) this.f16468a.f16441t).mo7089a(DiagnoseConstants.FEEDBACK_SPT_TRANS_DIAG_INFO_EX, new byte[]{0, 0, 1, 0});
        } else {
            ((DiagnoseActivity) this.f16468a.f16441t).mo7089a(DiagnoseConstants.FEEDBACK_SPT_TRANS_DIAG_INFO_EX, new byte[]{0, 0, 1, 1});
        }
        dialog = this.f16468a.f16423M;
        dialog.dismiss();
    }
}
