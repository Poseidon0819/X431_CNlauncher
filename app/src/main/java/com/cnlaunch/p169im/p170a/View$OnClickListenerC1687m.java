package com.cnlaunch.p169im.p170a;

import android.util.Log;
import android.view.View;
import com.baidu.mapapi.synchronization.histroytrace.HistoryTraceConstant;
import com.cnlaunch.p169im.p170a.FaceAdapter;
import com.cnlaunch.p169im.p173d.GoloHandler;
import java.util.ArrayList;
import java.util.Map;

/* compiled from: FaceAdapter.java */
/* renamed from: com.cnlaunch.im.a.m */
/* loaded from: classes.dex */
final class View$OnClickListenerC1687m implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ int f8986a;

    /* renamed from: b */
    final /* synthetic */ FaceAdapter f8987b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC1687m(FaceAdapter faceAdapter, int i) {
        this.f8987b = faceAdapter;
        this.f8986a = i;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i;
        String str;
        int i2;
        int i3;
        GoloHandler goloHandler;
        GoloHandler goloHandler2;
        ArrayList arrayList;
        GoloHandler goloHandler3;
        GoloHandler goloHandler4;
        if ("del".equals(view.getTag())) {
            goloHandler4 = this.f8987b.f8981c;
            goloHandler4.obtainMessage(100001, null).sendToTarget();
        } else if ("add".equals(view.getTag())) {
        } else {
            i = this.f8987b.f8982d;
            if (i == FaceAdapter.EnumC1686a.custom$1d664d25) {
                str = (String) view.getTag();
            } else {
                str = "[@" + ((String) view.getTag()) + "]";
            }
            i2 = this.f8987b.f8982d;
            if (i2 == FaceAdapter.EnumC1686a.yellow$1d664d25) {
                goloHandler3 = this.f8987b.f8981c;
                goloHandler3.obtainMessage(100000, str).sendToTarget();
                return;
            }
            i3 = this.f8987b.f8982d;
            if (i3 != FaceAdapter.EnumC1686a.custom$1d664d25) {
                goloHandler = this.f8987b.f8981c;
                goloHandler.obtainMessage(HistoryTraceConstant.LBS_HISTORY_TRACE_CODE_REQUEST_PARAMETER_ERROR, str).sendToTarget();
                return;
            }
            Log.e("Type.custom", "Type.custom");
            goloHandler2 = this.f8987b.f8981c;
            arrayList = this.f8987b.f8983e;
            goloHandler2.obtainMessage(HistoryTraceConstant.LBS_HISTORY_TRACE_CODE_CURRENT_ORDER_STATE_NOT_COMPLETE, ((Map) arrayList.get(this.f8986a)).get("value")).sendToTarget();
        }
    }
}
