package com.cnlaunch.x431pro.activity.diagnose;

import android.os.Bundle;
import com.cnlaunch.diagnosemodule.utils.DiagnoseConstants;
import com.cnlaunch.x431pro.activity.diagnose.DiagnoseActivity;
import com.cnlaunch.x431pro.utils.PathUtils;
import java.util.ArrayList;
import org.jivesoftware.smackx.bytestreams.ibb.packet.DataPacketExtension;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DiagnoseActivity.java */
/* renamed from: com.cnlaunch.x431pro.activity.diagnose.bl */
/* loaded from: classes.dex */
public final class C2078bl implements DiagnoseActivity.InterfaceC2009a {

    /* renamed from: a */
    final /* synthetic */ ArrayList f11552a;

    /* renamed from: b */
    final /* synthetic */ String f11553b;

    /* renamed from: c */
    final /* synthetic */ DiagnoseActivity f11554c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2078bl(DiagnoseActivity diagnoseActivity, ArrayList arrayList, String str) {
        this.f11554c = diagnoseActivity;
        this.f11552a = arrayList;
        this.f11553b = str;
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.DiagnoseActivity.InterfaceC2009a
    /* renamed from: a */
    public final void mo7041a() {
        Bundle bundle = new Bundle();
        bundle.putInt("RequestCode", 600015);
        bundle.putSerializable(DataPacketExtension.ELEMENT_NAME, this.f11552a);
        bundle.putString("data_type", this.f11553b);
        this.f11554c.m7693a(bundle);
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.DiagnoseActivity.InterfaceC2009a
    /* renamed from: b */
    public final void mo7040b() {
        boolean m4865a = PathUtils.m4865a(DiagnoseConstants.DIAGNOSE_LIB_PATH, "RetErrCodeOLDTC");
        if (this.f11553b.equals(DiagnoseConstants.FEEDBACK_SPT_DOWNLOAD_FILE_EX) && m4865a) {
            this.f11554c.mo7089a(DiagnoseConstants.FEEDBACK_SPT_TRANS_DIAG_INFO_EX, new byte[]{0, 0, 3, -2, 0, 1});
        } else {
            DiagnoseActivity.m7636e(this.f11554c, this.f11553b, this.f11552a);
        }
    }
}
