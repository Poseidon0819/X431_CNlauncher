package com.baidu.platform.core.p097e;

import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.inner.Point;
import com.baidu.mapapi.search.share.RouteShareURLOption;
import com.baidu.mapsdkplatform.comjni.util.AppMD5;
import com.baidu.platform.base.AbstractC1323c;
import com.baidu.platform.domain.InterfaceC1382c;
import com.baidu.platform.util.C1384a;
import com.itextpdf.text.Annotation;
import org.jivesoftware.smack.packet.PrivacyItem;

/* renamed from: com.baidu.platform.core.e.e */
/* loaded from: classes.dex */
public class C1372e extends AbstractC1323c {
    public C1372e(RouteShareURLOption routeShareURLOption) {
        m9805a(routeShareURLOption);
    }

    /* renamed from: a */
    private int m9804a(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            return 0;
        }
    }

    /* renamed from: a */
    private void m9805a(RouteShareURLOption routeShareURLOption) {
        String str;
        String str2;
        String str3;
        StringBuilder sb;
        C1384a c1384a = new C1384a();
        Point ll2point = CoordUtil.ll2point(routeShareURLOption.mFrom.getLocation());
        Point ll2point2 = CoordUtil.ll2point(routeShareURLOption.mTo.getLocation());
        if (ll2point != null) {
            str = "1$$$$" + ll2point.f5413x + "," + ll2point.f5414y + "$$";
        } else {
            str = "2$$$$$$";
        }
        String name = routeShareURLOption.mFrom.getName();
        name = (name == null || name.equals("")) ? "起点" : "起点";
        String str4 = str + name + "$$0$$$$";
        if (ll2point2 != null) {
            str2 = "1$$$$" + ll2point2.f5413x + "," + ll2point2.f5414y + "$$";
        } else {
            str2 = "2$$$$$$";
        }
        String name2 = routeShareURLOption.mTo.getName();
        name2 = (name2 == null || name2.equals("")) ? "终点" : "终点";
        String str5 = str2 + name2 + "$$0$$$$";
        String str6 = "";
        String str7 = "";
        switch (routeShareURLOption.mMode.ordinal()) {
            case 0:
                str7 = "&sharecallbackflag=carRoute";
                str6 = "nav";
                StringBuilder sb2 = new StringBuilder();
                sb2.append(m9804a(routeShareURLOption.mFrom.getCity()));
                c1384a.m9767a("sc", sb2.toString());
                str3 = "ec";
                sb = new StringBuilder();
                sb.append(m9804a(routeShareURLOption.mTo.getCity()));
                c1384a.m9767a(str3, sb.toString());
                break;
            case 1:
                str7 = "&sharecallbackflag=footRoute";
                str6 = "walk";
                StringBuilder sb3 = new StringBuilder();
                sb3.append(m9804a(routeShareURLOption.mFrom.getCity()));
                c1384a.m9767a("sc", sb3.toString());
                str3 = "ec";
                sb = new StringBuilder();
                sb.append(m9804a(routeShareURLOption.mTo.getCity()));
                c1384a.m9767a(str3, sb.toString());
                break;
            case 2:
                str7 = "&sharecallbackflag=cycleRoute";
                str6 = "cycle";
                StringBuilder sb4 = new StringBuilder();
                sb4.append(m9804a(routeShareURLOption.mFrom.getCity()));
                c1384a.m9767a("sc", sb4.toString());
                str3 = "ec";
                sb = new StringBuilder();
                sb.append(m9804a(routeShareURLOption.mTo.getCity()));
                c1384a.m9767a(str3, sb.toString());
                break;
            case 3:
                str7 = "&i=" + routeShareURLOption.mPn + ",1,1&sharecallbackflag=busRoute";
                StringBuilder sb5 = new StringBuilder();
                sb5.append(routeShareURLOption.mCityCode);
                c1384a.m9767a("c", sb5.toString());
                str6 = "bt";
                break;
        }
        c1384a.m9767a("sn", str4);
        c1384a.m9767a("en", str5);
        String str8 = "&" + c1384a.m9768a() + ("&start=" + name + "&end=" + name2);
        this.f6490a.m9767a(Annotation.URL, "http://map.baidu.com/?newmap=1&s=" + str6 + (AppMD5.encodeUrlParamsValue(str8) + str7));
        this.f6490a.m9767a(PrivacyItem.PrivacyRule.SUBSCRIPTION_FROM, "android_map_sdk");
    }

    @Override // com.baidu.platform.base.AbstractC1323c
    /* renamed from: a */
    public String mo9788a(InterfaceC1382c interfaceC1382c) {
        return interfaceC1382c.mo9770r();
    }
}
