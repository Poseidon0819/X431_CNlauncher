package com.baidu.platform.base;

import android.util.Log;
import com.baidu.mapapi.http.HttpClient;
import com.baidu.mapapi.model.CoordUtil;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.inner.Point;
import com.baidu.mapapi.search.route.PlanNode;
import com.baidu.mapsdkplatform.comapi.util.PermissionCheck;
import com.baidu.mapsdkplatform.comjni.util.AppMD5;
import com.baidu.platform.domain.C1383d;
import com.baidu.platform.domain.InterfaceC1382c;
import com.baidu.platform.util.C1384a;

/* renamed from: com.baidu.platform.base.c */
/* loaded from: classes.dex */
public abstract class AbstractC1323c {

    /* renamed from: b */
    private boolean f6491b = true;

    /* renamed from: c */
    private boolean f6492c = true;

    /* renamed from: a */
    protected C1384a f6490a = new C1384a();

    /* renamed from: a */
    public String m9938a() {
        String mo9788a = mo9788a(C1383d.m9769a());
        String authToken = HttpClient.getAuthToken();
        if (authToken == null) {
            Log.e("SearchRequest", "toUrlString get authtoken failed");
            int permissionCheck = PermissionCheck.permissionCheck();
            if (permissionCheck != 0) {
                Log.e("SearchRequest", "try permissionCheck result is: ".concat(String.valueOf(permissionCheck)));
                return null;
            }
            authToken = HttpClient.getAuthToken();
        }
        if (this.f6491b) {
            this.f6490a.m9767a("token", authToken);
        }
        String str = this.f6490a.m9768a() + HttpClient.getPhoneInfo();
        if (this.f6492c) {
            str = str + "&sign=" + AppMD5.getSignMD5String(str);
        }
        return mo9788a + "?" + str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public final String m9937a(PlanNode planNode) {
        StringBuilder sb;
        if (planNode == null) {
            return null;
        }
        String str = new String("{");
        LatLng location = planNode.getLocation();
        if (location != null) {
            String str2 = str + "\"type\":1,";
            Point ll2point = CoordUtil.ll2point(location);
            sb = new StringBuilder();
            sb.append(str2);
            sb.append("\"xy\":\"");
            sb.append(ll2point.f5413x);
            sb.append(",");
            sb.append(ll2point.f5414y);
        } else if (planNode.getName() == null) {
            return str;
        } else {
            sb = new StringBuilder();
            sb.append(str + "\"type\":2,");
            sb.append("\"keyword\":\"");
            sb.append(planNode.getName());
        }
        sb.append("\"}");
        return sb.toString();
    }

    /* renamed from: a */
    public abstract String mo9788a(InterfaceC1382c interfaceC1382c);

    /* renamed from: a */
    public void m9936a(boolean z) {
        this.f6492c = z;
    }

    /* renamed from: b */
    public void m9935b(boolean z) {
        this.f6491b = z;
    }
}
