package com.cnlaunch.x431pro.module.p241a;

import android.text.TextUtils;
import com.cnlaunch.p120d.p130d.NLog;
import org.p388a.p389a.SoapObject;

/* renamed from: com.cnlaunch.x431pro.module.a.i */
/* loaded from: classes.dex */
public class SoapObjectParams extends SoapObject {

    /* renamed from: e */
    private final String f15462e;

    public SoapObjectParams() {
        this.f15462e = SoapObjectParams.class.getSimpleName();
    }

    public SoapObjectParams(String str, String str2) {
        super(str, str2);
        this.f15462e = SoapObjectParams.class.getSimpleName();
    }

    @Override // org.p388a.p389a.SoapObject
    /* renamed from: a */
    public final SoapObject mo169a(String str, Object obj) {
        if (obj == null || TextUtils.isEmpty(String.valueOf(obj))) {
            String str2 = this.f15462e;
            NLog.m9452b(str2, "addProperty name is " + str + " and value is " + obj);
            return this;
        }
        return super.mo169a(str, obj);
    }
}
