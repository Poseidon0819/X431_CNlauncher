package com.cnlaunch.p188n;

import android.os.Handler;
import android.os.Message;
import com.baidu.mapapi.UIMsg;
import com.cnlaunch.p188n.p191c.MLog;
import com.cnlaunch.p188n.p191c.RemoteConstants;
import com.itextpdf.text.pdf.PdfAction;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: RemoteSocketControler.java */
/* renamed from: com.cnlaunch.n.c */
/* loaded from: classes.dex */
public final class HandlerC1804c extends Handler {

    /* renamed from: a */
    final /* synthetic */ RemoteSocketControler f9635a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public HandlerC1804c(RemoteSocketControler remoteSocketControler) {
        this.f9635a = remoteSocketControler;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message2) {
        switch (message2.what) {
            case UIMsg.k_event.V_WM_ROTATE /* 8193 */:
                return;
            case UIMsg.k_event.V_WM_GETLASTCLRSATETIME /* 8194 */:
                this.f9635a.f9678n.m8524a();
                return;
            case UIMsg.k_event.V_WM_DBCLICK /* 8195 */:
                this.f9635a.m8504b(12296);
                return;
            case PdfAction.SUBMIT_EMBED_FORM /* 8196 */:
                MLog.m8520c(this.f9635a.f9669e, "配对失败");
                this.f9635a.m8504b(12297);
                return;
            case 8197:
                RemoteConstants.f9649a = 1;
                RemoteConstants.f9650b = false;
                this.f9635a.m8504b(12299);
                return;
            default:
                return;
        }
    }
}
