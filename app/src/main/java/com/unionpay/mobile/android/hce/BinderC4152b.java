package com.unionpay.mobile.android.hce;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import com.baidu.mapapi.UIMsg;
import com.baidu.mapapi.synchronization.SynchronizationConstants;
import com.unionpay.mobile.android.hce.service.InterfaceC4166b;
import com.unionpay.tsmservice.data.Constant;

/* renamed from: com.unionpay.mobile.android.hce.b */
/* loaded from: classes2.dex */
public final class BinderC4152b extends InterfaceC4166b.AbstractBinderC4167a {

    /* renamed from: a */
    private int f22155a;

    /* renamed from: b */
    private String f22156b;

    /* renamed from: c */
    private Handler f22157c;

    public BinderC4152b(int i, String str, Handler handler) {
        this.f22155a = i;
        this.f22156b = str;
        this.f22157c = handler;
    }

    @Override // com.unionpay.mobile.android.hce.service.InterfaceC4166b
    /* renamed from: a */
    public final void mo1548a(String str) throws RemoteException {
        switch (this.f22155a) {
            case SynchronizationConstants.LBS_ERROR_QUERY_TRACK_ROUTE_FAILED /* 2003 */:
                Bundle bundle = new Bundle();
                bundle.putString("pkgName", this.f22156b);
                bundle.putBoolean(Constant.CASH_LOAD_SUCCESS, false);
                bundle.putString("errCode", str);
                Handler handler = this.f22157c;
                handler.sendMessage(Message.obtain(handler, SynchronizationConstants.LBS_ERROR_QUERY_TRACK_ROUTE_FAILED, bundle));
                return;
            case UIMsg.m_AppUI.MSG_APP_VERSION /* 2004 */:
                Bundle bundle2 = new Bundle();
                bundle2.putBoolean(Constant.CASH_LOAD_SUCCESS, false);
                bundle2.putString("errCode", str);
                Handler handler2 = this.f22157c;
                handler2.sendMessage(Message.obtain(handler2, UIMsg.m_AppUI.MSG_APP_VERSION, bundle2));
                return;
            default:
                return;
        }
    }

    @Override // com.unionpay.mobile.android.hce.service.InterfaceC4166b
    /* renamed from: a */
    public final void mo1547a(String str, String str2) throws RemoteException {
        switch (this.f22155a) {
            case SynchronizationConstants.LBS_ERROR_QUERY_TRACK_ROUTE_FAILED /* 2003 */:
                Bundle bundle = new Bundle();
                bundle.putString("pkgName", this.f22156b);
                bundle.putBoolean(Constant.CASH_LOAD_SUCCESS, true);
                bundle.putString("result", str);
                bundle.putString("reserved", str2);
                Handler handler = this.f22157c;
                handler.sendMessage(Message.obtain(handler, SynchronizationConstants.LBS_ERROR_QUERY_TRACK_ROUTE_FAILED, bundle));
                return;
            case UIMsg.m_AppUI.MSG_APP_VERSION /* 2004 */:
                Bundle bundle2 = new Bundle();
                bundle2.putBoolean(Constant.CASH_LOAD_SUCCESS, true);
                bundle2.putString("result", str);
                bundle2.putString("reserved", str2);
                Handler handler2 = this.f22157c;
                handler2.sendMessage(Message.obtain(handler2, UIMsg.m_AppUI.MSG_APP_VERSION, bundle2));
                return;
            default:
                return;
        }
    }
}
