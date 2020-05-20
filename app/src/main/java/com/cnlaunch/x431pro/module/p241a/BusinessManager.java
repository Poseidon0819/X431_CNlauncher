package com.cnlaunch.x431pro.module.p241a;

import android.content.Context;
import android.text.TextUtils;
import com.cnlaunch.p120d.p125c.p128c.C1425f;
import com.cnlaunch.p120d.p125c.p128c.C1426i;
import org.p388a.p389a.SoapObject;
import org.p393b.p395b.C4920a;

/* renamed from: com.cnlaunch.x431pro.module.a.f */
/* loaded from: classes.dex */
public class BusinessManager extends BaseManager {

    /* renamed from: k */
    protected final int f15454k;

    /* renamed from: l */
    protected final int f15455l;

    /* renamed from: m */
    protected final int f15456m;

    /* renamed from: n */
    protected final int f15457n;

    /* renamed from: o */
    protected final int f15458o;

    /* renamed from: p */
    protected final int f15459p;

    /* renamed from: q */
    protected final int f15460q;

    /* renamed from: r */
    protected final int f15461r;

    public BusinessManager(Context context) {
        super(context);
        this.f15454k = 1800;
        this.f15455l = 3600;
        this.f15456m = 10800;
        this.f15457n = 86400;
        this.f15458o = 259200;
        this.f15459p = 432000;
        this.f15460q = 604800;
        this.f15461r = 2592000;
    }

    /* renamed from: e */
    public final CommonResponse m5433e(String str, C1426i c1426i) throws C1425f {
        String m9475b = this.f15446f.m9475b(str, c1426i);
        if (TextUtils.isEmpty(m9475b)) {
            return null;
        }
        return (CommonResponse) m5438a(m9475b, CommonResponse.class);
    }

    /* renamed from: a */
    public final CommonResponse m5434a(String str, SoapObject soapObject, C4920a[] c4920aArr) throws C1425f {
        try {
            this.f15447g = m5436f(str);
            this.f15448h = m5437a(c4920aArr, soapObject);
            this.f15447g.m141a("", this.f15448h);
            if (this.f15448h != null) {
                return (CommonResponse) m5444a((Class<Object>) CommonResponse.class);
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
