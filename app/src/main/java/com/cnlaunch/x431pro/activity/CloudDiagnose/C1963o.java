package com.cnlaunch.x431pro.activity.CloudDiagnose;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.TextView;
import com.cnlaunch.diagnosemodule.utils.DiagnoseConstants;
import com.cnlaunch.x431pro.module.p241a.PresenterCallback;

/* compiled from: CloudHistoryFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.CloudDiagnose.o */
/* loaded from: classes.dex */
final class C1963o implements PresenterCallback {

    /* renamed from: a */
    final /* synthetic */ CloudHistoryFragment f10676a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1963o(CloudHistoryFragment cloudHistoryFragment) {
        this.f10676a = cloudHistoryFragment;
    }

    @Override // com.cnlaunch.x431pro.module.p241a.PresenterCallback
    /* renamed from: a */
    public final void mo5115a(Bundle bundle) {
        String str;
        TextView textView;
        TextView textView2;
        this.f10676a.f10670x = bundle.getString("autoCode");
        StringBuilder sb = new StringBuilder("autoCode:");
        str = this.f10676a.f10670x;
        sb.append(str);
        Log.i("XEE", sb.toString());
        if (!TextUtils.isEmpty(DiagnoseConstants.MARKET_CAR_MODEL)) {
            textView2 = this.f10676a.f10663q;
            textView2.setText(DiagnoseConstants.MARKET_CAR_MODEL);
            this.f10676a.f10656j = DiagnoseConstants.MARKET_CAR_MODEL;
        }
        if (TextUtils.isEmpty(DiagnoseConstants.RECORD_YEAR)) {
            return;
        }
        textView = this.f10676a.f10664r;
        textView.setText(DiagnoseConstants.RECORD_YEAR);
        this.f10676a.f10657k = DiagnoseConstants.RECORD_YEAR;
    }

    @Override // com.cnlaunch.x431pro.module.p241a.PresenterCallback
    /* renamed from: a */
    public final void mo5116a(int i) {
        Log.e("XEE", "autoCode err:".concat(String.valueOf(i)));
    }
}
