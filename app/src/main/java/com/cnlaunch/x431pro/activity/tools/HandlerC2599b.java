package com.cnlaunch.x431pro.activity.tools;

import android.os.Handler;
import android.os.Message;
import com.cnlaunch.x431pro.activity.tools.p237a.ToolsAdapter;
import com.cnlaunch.x431pro.module.p267i.ToolDataInfoList;

/* compiled from: ToolsFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.tools.b */
/* loaded from: classes.dex */
final class HandlerC2599b extends Handler {

    /* renamed from: a */
    final /* synthetic */ ToolsFragment f14975a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public HandlerC2599b(ToolsFragment toolsFragment) {
        this.f14975a = toolsFragment;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message2) {
        ToolDataInfoList toolDataInfoList;
        ToolsAdapter toolsAdapter;
        ToolDataInfoList toolDataInfoList2;
        ToolsAdapter toolsAdapter2;
        if (message2.what != 0) {
            return;
        }
        toolDataInfoList = this.f14975a.f14962c;
        toolDataInfoList.refreshData(this.f14975a.getActivity().getBaseContext());
        toolsAdapter = this.f14975a.f14961b;
        toolDataInfoList2 = this.f14975a.f14962c;
        toolsAdapter.f14968a = toolDataInfoList2.getList();
        toolsAdapter2 = this.f14975a.f14961b;
        toolsAdapter2.notifyDataSetChanged();
    }
}
