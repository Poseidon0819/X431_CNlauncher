package com.cnlaunch.x431pro.activity.diagnose;

import android.os.Bundle;
import com.cnlaunch.diagnosemodule.utils.DiagnoseConstants;
import com.cnlaunch.x431pro.activity.diagnose.DiagnoseActivity;
import com.cnlaunch.x431pro.utils.PathUtils;
import java.util.ArrayList;
import org.jivesoftware.smackx.bytestreams.ibb.packet.DataPacketExtension;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DiagnoseActivity.java */
/* renamed from: com.cnlaunch.x431pro.activity.diagnose.bi */
/* loaded from: classes.dex */
public final class C2075bi implements DiagnoseActivity.InterfaceC2009a {

    /* renamed from: a */
    final /* synthetic */ ArrayList f11543a;

    /* renamed from: b */
    final /* synthetic */ String f11544b;

    /* renamed from: c */
    final /* synthetic */ String f11545c;

    /* renamed from: d */
    final /* synthetic */ DiagnoseActivity f11546d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2075bi(DiagnoseActivity diagnoseActivity, ArrayList arrayList, String str, String str2) {
        this.f11546d = diagnoseActivity;
        this.f11543a = arrayList;
        this.f11544b = str;
        this.f11545c = str2;
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.DiagnoseActivity.InterfaceC2009a
    /* renamed from: a */
    public final void mo7041a() {
        Bundle bundle = new Bundle();
        bundle.putInt("RequestCode", 600015);
        bundle.putSerializable(DataPacketExtension.ELEMENT_NAME, this.f11543a);
        bundle.putString("data_type", this.f11544b);
        this.f11546d.m7693a(bundle);
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.DiagnoseActivity.InterfaceC2009a
    /* renamed from: b */
    public final void mo7040b() {
        boolean m4865a = PathUtils.m4865a(DiagnoseConstants.DIAGNOSE_LIB_PATH, "RetErrCodeOLDTC");
        if (this.f11544b.startsWith(DiagnoseConstants.EXT1_DUAL_HIGH_SPEED_NETWORK_LAYOUT) && m4865a) {
            this.f11546d.mo7089a(DiagnoseConstants.FEEDBACK_SPT_TRANS_DIAG_INFO_EX, new byte[]{0, 0, 3, -2, 0, 1});
        } else {
            DiagnoseActivity.m7673a(this.f11546d, this.f11543a, this.f11545c);
        }
    }
}
