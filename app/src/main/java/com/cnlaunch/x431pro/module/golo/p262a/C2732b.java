package com.cnlaunch.x431pro.module.golo.p262a;

import com.cnlaunch.golo3.p164f.HttpResponseEntityCallBack;
import com.cnlaunch.golo3.p164f.JSONMsg;
import com.cnlaunch.x431pro.module.golo.model.FriendInfo;
import com.p099c.p100a.p103c.ResponseInfo;
import com.p099c.p100a.p103c.p104a.RequestCallBack;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FriendAction.java */
/* renamed from: com.cnlaunch.x431pro.module.golo.a.b */
/* loaded from: classes.dex */
public final class C2732b extends RequestCallBack<String> {

    /* renamed from: a */
    final /* synthetic */ HttpResponseEntityCallBack f15539a;

    /* renamed from: b */
    final /* synthetic */ FriendAction f15540b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2732b(FriendAction friendAction, HttpResponseEntityCallBack httpResponseEntityCallBack) {
        this.f15540b = friendAction;
        this.f15539a = httpResponseEntityCallBack;
    }

    @Override // com.p099c.p100a.p103c.p104a.RequestCallBack
    /* renamed from: a */
    public final void mo250a(ResponseInfo<String> responseInfo) {
        String m5323b;
        String m5323b2;
        String m5323b3;
        String m5323b4;
        String m5323b5;
        String m5323b6;
        JSONMsg jSONMsg = new JSONMsg();
        try {
            jSONMsg.m9156a(new JSONObject(responseInfo.f6665a));
            r1 = jSONMsg.f8441a == 0 ? 4 : 5;
            FriendInfo friendInfo = new FriendInfo();
            m5323b = FriendAction.m5323b(jSONMsg.f8443c, "user_id");
            friendInfo.setUser_id(m5323b);
            m5323b2 = FriendAction.m5323b(jSONMsg.f8443c, "nick_name");
            friendInfo.setNick_name(m5323b2);
            m5323b3 = FriendAction.m5323b(jSONMsg.f8443c, "user_name");
            friendInfo.setUser_name(m5323b3);
            m5323b4 = FriendAction.m5323b(jSONMsg.f8443c, "face_thumb");
            friendInfo.setFace_thumb(m5323b4);
            m5323b5 = FriendAction.m5323b(jSONMsg.f8443c, "user_name");
            friendInfo.setUser_name(m5323b5);
            m5323b6 = FriendAction.m5323b(jSONMsg.f8443c, "sex");
            friendInfo.setSex(Integer.valueOf(Integer.parseInt(m5323b6)));
            this.f15539a.mo8705a(r1, friendInfo);
        } catch (Exception e) {
            e.printStackTrace();
            this.f15539a.mo8705a(r1, null);
        }
    }

    @Override // com.p099c.p100a.p103c.p104a.RequestCallBack
    /* renamed from: a */
    public final void mo249a(String str) {
        this.f15539a.mo8705a(3, null);
    }
}
