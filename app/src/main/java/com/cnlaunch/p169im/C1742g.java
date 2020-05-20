package com.cnlaunch.p169im;

import android.util.Log;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.p120d.p125c.p126a.OnDataListener;
import com.cnlaunch.p120d.p125c.p128c.C1425f;
import com.cnlaunch.p169im.p174db.GoloDBManager;
import com.cnlaunch.p169im.p179i.UserInfoCache;
import com.cnlaunch.x431pro.activity.golo.others.AsyLock;
import com.cnlaunch.x431pro.activity.golo.others.GoloTools;
import com.cnlaunch.x431pro.module.golo.model.FriendInfo;
import com.cnlaunch.x431pro.module.golo.model.FriendListResponse;
import com.cnlaunch.x431pro.module.golo.model.GoloRemoteOrderInfo;
import com.cnlaunch.x431pro.module.golo.model.GoloRemoteOrderResponse;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NetWorkDataModel.java */
/* renamed from: com.cnlaunch.im.g */
/* loaded from: classes.dex */
public final class C1742g implements OnDataListener {

    /* renamed from: a */
    final /* synthetic */ NetWorkDataModel f9268a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1742g(NetWorkDataModel netWorkDataModel) {
        this.f9268a = netWorkDataModel;
    }

    @Override // com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public final void onSuccess(int i, Object obj) {
        AsyLock.m6966c(i);
        if (this.f9268a.f9238b != null) {
            this.f9268a.f9238b.mo8737b(i);
        }
    }

    @Override // com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public final void onFailure(int i, int i2, Object obj) {
        AsyLock.m6966c(i);
        if (this.f9268a.f9238b != null) {
            this.f9268a.f9238b.mo8735c(i);
        }
    }

    @Override // com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public final Object doInBackground(int i) throws C1425f {
        GoloRemoteOrderResponse m5312h;
        AsyLock.m6967b(i);
        Log.i("Sanda", "******RequestCode".concat(String.valueOf(i)));
        if (i == 40021) {
            FriendListResponse m5328a = this.f9268a.f9239c.m5328a();
            if (m5328a != null) {
                List<FriendInfo> data = m5328a.getData();
                if (data == null) {
                    data = new ArrayList<>();
                }
                GoloTools.m6961a(data);
                GoloDBManager m8756a = GoloDBManager.m8756a(this.f9268a.f9237a);
                m8756a.f9220b.f9226c.deleteAll();
                m8756a.f9220b.f9226c.insertInTx(data);
                UserInfoCache.m8711a(this.f9268a.f9237a, false).m8712a(8);
            }
        } else if (i == 40025 && (m5312h = this.f9268a.f9240d.m5312h(PreferencesManager.m9595a(this.f9268a.f9237a).m9591a("user_id"))) != null && m5312h.getCode() == 0) {
            if (m5312h.getMsg().equalsIgnoreCase("no data")) {
                GoloDBManager.m8756a(this.f9268a.f9237a).m8754a(new ArrayList());
                return null;
            }
            List<GoloRemoteOrderInfo> data2 = m5312h.getData();
            GoloTools.m6959a(data2, "tech");
            GoloTools.m6960a(data2, this.f9268a.f9237a);
            GoloDBManager.m8756a(this.f9268a.f9237a).m8754a(data2);
        }
        return null;
    }
}
