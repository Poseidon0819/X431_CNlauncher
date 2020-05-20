package com.baidu.platform.core.p093a;

import com.baidu.platform.base.AbstractC1323c;
import com.baidu.platform.domain.InterfaceC1382c;
import com.cnlaunch.diagnosemodule.utils.DiagnoseConstants;
import com.cnlaunch.physics.PAD3DHCPForDoIP;

/* renamed from: com.baidu.platform.core.a.c */
/* loaded from: classes.dex */
public class C1331c extends AbstractC1323c {
    public C1331c(String str) {
        m9915a(str);
    }

    /* renamed from: a */
    private void m9915a(String str) {
        this.f6490a.m9767a("qt", "ext");
        this.f6490a.m9767a("num", DiagnoseConstants.UI_TYPE_NO_UI_CMD);
        this.f6490a.m9767a(PAD3DHCPForDoIP.f10141a, DiagnoseConstants.DATA_TYPE_FROM_APK_TO_SO_SET_MENUPATH);
        this.f6490a.m9767a("ie", "utf-8");
        this.f6490a.m9767a("oue", "1");
        this.f6490a.m9767a("res", "api");
        this.f6490a.m9767a("fromproduct", "android_map_sdk");
        this.f6490a.m9767a("uid", str);
    }

    @Override // com.baidu.platform.base.AbstractC1323c
    /* renamed from: a */
    public String mo9788a(InterfaceC1382c interfaceC1382c) {
        return interfaceC1382c.mo9773o();
    }
}
