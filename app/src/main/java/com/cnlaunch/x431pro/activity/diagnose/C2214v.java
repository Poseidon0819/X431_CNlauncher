package com.cnlaunch.x431pro.activity.diagnose;

import android.os.Bundle;
import com.cnlaunch.diagnosemodule.bean.BasicOnlineArithBean;
import com.cnlaunch.diagnosemodule.utils.DiagnoseConstants;
import com.cnlaunch.x431pro.activity.diagnose.DiagnoseActivity;
import org.jivesoftware.smackx.bytestreams.ibb.packet.DataPacketExtension;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DiagnoseActivity.java */
/* renamed from: com.cnlaunch.x431pro.activity.diagnose.v */
/* loaded from: classes.dex */
public final class C2214v implements DiagnoseActivity.InterfaceC2009a {

    /* renamed from: a */
    final /* synthetic */ BasicOnlineArithBean f12489a;

    /* renamed from: b */
    final /* synthetic */ DiagnoseActivity f12490b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2214v(DiagnoseActivity diagnoseActivity, BasicOnlineArithBean basicOnlineArithBean) {
        this.f12490b = diagnoseActivity;
        this.f12489a = basicOnlineArithBean;
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.DiagnoseActivity.InterfaceC2009a
    /* renamed from: a */
    public final void mo7041a() {
        Bundle bundle = new Bundle();
        bundle.putInt("RequestCode", 600016);
        bundle.putSerializable(DataPacketExtension.ELEMENT_NAME, this.f12489a);
        this.f12490b.m7693a(bundle);
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.DiagnoseActivity.InterfaceC2009a
    /* renamed from: b */
    public final void mo7040b() {
        this.f12490b.mo7089a(DiagnoseConstants.FEEDBACK_SPT_TRANS_DIAG_INFO_EX, new byte[]{0, 0, 1, -16});
    }
}
