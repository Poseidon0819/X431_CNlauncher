package com.cnlaunch.p169im.p180j;

import com.cnlaunch.golo3.p160b.ApplicationConfig;
import com.cnlaunch.golo3.p164f.HttpResponseEntityCallBack;
import com.cnlaunch.p169im.IMPresenter;
import com.cnlaunch.p169im.p174db.GoloDBManager;
import com.cnlaunch.x431pro.activity.golo.others.GoloTools;
import com.cnlaunch.x431pro.module.golo.model.FriendInfo;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ReceiveMessageTask.java */
/* renamed from: com.cnlaunch.im.j.e */
/* loaded from: classes.dex */
public final class C1749e implements HttpResponseEntityCallBack<FriendInfo> {

    /* renamed from: a */
    final /* synthetic */ ReceiveMessageTask f9297a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1749e(ReceiveMessageTask receiveMessageTask) {
        this.f9297a = receiveMessageTask;
    }

    @Override // com.cnlaunch.golo3.p164f.HttpResponseEntityCallBack
    /* renamed from: a */
    public final /* synthetic */ void mo8705a(int i, FriendInfo friendInfo) {
        FriendInfo friendInfo2 = friendInfo;
        if (i == 4 && GoloDBManager.m8756a(ApplicationConfig.f7802a).m8755a(this.f9297a.f24000b.f24060e) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(friendInfo2);
            GoloTools.m6961a(arrayList);
            GoloDBManager.m8756a(ApplicationConfig.f7802a).f9220b.f9226c.insert(friendInfo2);
            IMPresenter.m8804a(ApplicationConfig.f7802a).f9184f = GoloDBManager.m8756a(ApplicationConfig.f7802a).m8757a();
            IMPresenter.m8804a(ApplicationConfig.f7802a).m8792d(40021);
        }
    }
}
