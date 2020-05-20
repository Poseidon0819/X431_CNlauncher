package com.unionpay.mobile.android.hce;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import com.baidu.mapapi.UIMsg;
import com.baidu.mapapi.synchronization.SynchronizationConstants;
import com.unionpay.mobile.android.hce.service.InterfaceC4163a;
import com.unionpay.mobile.android.utils.C4390k;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.unionpay.mobile.android.hce.i */
/* loaded from: classes2.dex */
public final class ServiceConnectionC4159i implements ServiceConnection {

    /* renamed from: a */
    final /* synthetic */ String f22209a;

    /* renamed from: b */
    final /* synthetic */ String f22210b;

    /* renamed from: c */
    final /* synthetic */ C4156f f22211c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ServiceConnectionC4159i(C4156f c4156f, String str, String str2) {
        this.f22211c = c4156f;
        this.f22209a = str;
        this.f22210b = str2;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        Handler handler;
        InterfaceC4163a interfaceC4163a;
        ConcurrentHashMap concurrentHashMap;
        ConcurrentHashMap concurrentHashMap2;
        Handler handler2;
        Handler handler3;
        String str;
        String str2;
        Handler handler4;
        Handler handler5;
        Handler handler6;
        int i;
        handler = this.f22211c.f22204y;
        handler.removeMessages(UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND, this.f22209a);
        String str3 = null;
        try {
            interfaceC4163a = InterfaceC4163a.AbstractBinderC4164a.m1552a(iBinder);
        } catch (Exception e) {
            e.printStackTrace();
            interfaceC4163a = null;
        }
        if (interfaceC4163a != null) {
            try {
                str = this.f22211c.f22184d;
                str2 = this.f22211c.f22185e;
                String str4 = this.f22209a;
                handler4 = this.f22211c.f22204y;
                str3 = interfaceC4163a.mo1551a(str, str2, new BinderC4152b(SynchronizationConstants.LBS_ERROR_QUERY_TRACK_ROUTE_FAILED, str4, handler4));
                handler5 = this.f22211c.f22204y;
                Message obtainMessage = handler5.obtainMessage(UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND, this.f22209a);
                handler6 = this.f22211c.f22204y;
                i = this.f22211c.f22189i;
                handler6.sendMessageDelayed(obtainMessage, i);
            } catch (RemoteException e2) {
                e2.printStackTrace();
            } catch (Exception unused) {
            }
            if (str3 != null) {
                C4390k.m838a("uppay-hce", "session Key: ".concat(String.valueOf(str3)));
                C4390k.m838a("uppay-hce", "3des key: " + this.f22210b);
                String m1607a = C4151a.m1607a(str3, this.f22210b);
                C4390k.m838a("uppay-hce", this.f22209a + " sessionkey after: " + m1607a);
                concurrentHashMap = this.f22211c.f22202v;
                C4162l c4162l = (C4162l) concurrentHashMap.get(this.f22209a);
                if (c4162l == null) {
                    c4162l = new C4162l(this.f22209a);
                }
                c4162l.m1557a(m1607a);
                c4162l.m1558a(interfaceC4163a);
                c4162l.m1554d();
                concurrentHashMap2 = this.f22211c.f22202v;
                concurrentHashMap2.put(this.f22209a, c4162l);
                handler2 = this.f22211c.f22204y;
                Message obtainMessage2 = handler2.obtainMessage(2002, this.f22209a);
                handler3 = this.f22211c.f22204y;
                handler3.sendMessage(obtainMessage2);
            }
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        Handler handler;
        Handler handler2;
        Handler handler3;
        handler = this.f22211c.f22204y;
        handler.removeMessages(UIMsg.m_AppUI.MSG_APP_VERSION_COMMEND, this.f22209a);
        handler2 = this.f22211c.f22204y;
        Message obtainMessage = handler2.obtainMessage(UIMsg.m_AppUI.MSG_APP_VERSION_FORCE, this.f22209a);
        handler3 = this.f22211c.f22204y;
        handler3.sendMessage(obtainMessage);
    }
}
