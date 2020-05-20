package com.baidu.platform.core.p097e;

import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.inner.Point;
import com.baidu.mapapi.search.share.LocationShareURLOption;
import com.baidu.platform.base.AbstractC1323c;
import com.baidu.platform.domain.InterfaceC1382c;
import com.baidu.platform.util.C1384a;

/* renamed from: com.baidu.platform.core.e.b */
/* loaded from: classes.dex */
public class C1369b extends AbstractC1323c {
    public C1369b(LocationShareURLOption locationShareURLOption) {
        m9807a(locationShareURLOption);
    }

    /* renamed from: a */
    private void m9807a(LocationShareURLOption locationShareURLOption) {
        this.f6490a.m9767a("qt", "cs");
        Point ll2point = CoordUtil.ll2point(locationShareURLOption.mLocation);
        C1384a c1384a = this.f6490a;
        c1384a.m9767a("geo", ll2point.f5413x + "|" + ll2point.f5414y);
        this.f6490a.m9767a("t", locationShareURLOption.mName);
        this.f6490a.m9767a("cnt", locationShareURLOption.mSnippet);
        m9935b(false);
        m9936a(false);
    }

    @Override // com.baidu.platform.base.AbstractC1323c
    /* renamed from: a */
    public String mo9788a(InterfaceC1382c interfaceC1382c) {
        return interfaceC1382c.mo9771q();
    }
}
