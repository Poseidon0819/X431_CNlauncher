package com.unionpay.mobile.android.hce;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.baidu.mapapi.UIMsg;
import com.baidu.mapapi.synchronization.SynchronizationConstants;
import com.unionpay.mobile.android.utils.C4390k;
import com.unionpay.tsmservice.data.Constant;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.unionpay.mobile.android.hce.g */
/* loaded from: classes2.dex */
public final class C4157g implements Handler.Callback {

    /* renamed from: a */
    final /* synthetic */ C4156f f22205a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C4157g(C4156f c4156f) {
        this.f22205a = c4156f;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message2) {
        String str;
        ConcurrentHashMap concurrentHashMap;
        ConcurrentHashMap concurrentHashMap2;
        ConcurrentHashMap concurrentHashMap3;
        ConcurrentHashMap concurrentHashMap4;
        ConcurrentHashMap concurrentHashMap5;
        ConcurrentHashMap concurrentHashMap6;
        switch (message2.what) {
            case 2001:
                C4156f.m1588a(this.f22205a);
                this.f22205a.m1583b();
                return false;
            case 2002:
                str = (String) message2.obj;
                break;
            case SynchronizationConstants.LBS_ERROR_QUERY_TRACK_ROUTE_FAILED /* 2003 */:
                Bundle bundle = (Bundle) message2.obj;
                if (bundle != null) {
                    String string = bundle.getString("pkgName");
                    boolean z = bundle.getBoolean(Constant.CASH_LOAD_SUCCESS);
                    String string2 = bundle.getString("result");
                    String string3 = bundle.getString("reserved");
                    C4390k.m836c("yitong", "result: ".concat(String.valueOf(string2)));
                    concurrentHashMap = this.f22205a.f22201u;
                    C4154d c4154d = (C4154d) concurrentHashMap.get(string);
                    if (c4154d == null) {
                        c4154d = new C4154d(string);
                    }
                    if (z) {
                        c4154d.m1599a(string2);
                        c4154d.m1597b(string3);
                    }
                    c4154d.m1594e();
                    concurrentHashMap2 = this.f22205a.f22201u;
                    concurrentHashMap2.put(string, c4154d);
                    C4156f.m1587a(this.f22205a, string);
                    return false;
                }
                return false;
            case UIMsg.m_AppUI.MSG_APP_VERSION /* 2004 */:
            default:
                return false;
            case UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND /* 2006 */:
                Object obj = message2.obj;
            case UIMsg.m_AppUI.MSG_APP_VERSION_FORCE /* 2005 */:
                str = (String) message2.obj;
                concurrentHashMap3 = this.f22205a.f22201u;
                C4154d c4154d2 = (C4154d) concurrentHashMap3.get(str);
                concurrentHashMap4 = this.f22205a.f22202v;
                C4162l c4162l = (C4162l) concurrentHashMap4.get(str);
                c4154d2.m1593f();
                concurrentHashMap5 = this.f22205a.f22201u;
                concurrentHashMap5.put(str, c4154d2);
                c4162l.m1553e();
                concurrentHashMap6 = this.f22205a.f22202v;
                concurrentHashMap6.put(str, c4162l);
                break;
        }
        C4156f.m1587a(this.f22205a, str);
        return false;
    }
}
