package com.cnlaunch.x431pro.activity.diagnose;

import android.os.Bundle;
import com.cnlaunch.diagnosemodule.utils.DiagnoseConstants;
import com.cnlaunch.x431pro.activity.diagnose.DiagnoseActivity;
import java.util.ArrayList;
import org.jivesoftware.smackx.bytestreams.ibb.packet.DataPacketExtension;

/* compiled from: DiagnoseActivity.java */
/* renamed from: com.cnlaunch.x431pro.activity.diagnose.bf */
/* loaded from: classes.dex */
final class C2072bf implements DiagnoseActivity.InterfaceC2009a {

    /* renamed from: a */
    final /* synthetic */ ArrayList f11539a;

    /* renamed from: b */
    final /* synthetic */ C2071be f11540b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2072bf(C2071be c2071be, ArrayList arrayList) {
        this.f11540b = c2071be;
        this.f11539a = arrayList;
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.DiagnoseActivity.InterfaceC2009a
    /* renamed from: a */
    public final void mo7041a() {
        Bundle bundle = new Bundle();
        bundle.putSerializable(DataPacketExtension.ELEMENT_NAME, this.f11539a);
        bundle.putInt("RequestCode", 60009);
        this.f11540b.f11538d.m7693a(bundle);
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.DiagnoseActivity.InterfaceC2009a
    /* renamed from: b */
    public final void mo7040b() {
        this.f11540b.f11538d.mo7089a(DiagnoseConstants.FEEDBACK_SPT_STD_EXT1, new byte[]{-1});
    }
}
