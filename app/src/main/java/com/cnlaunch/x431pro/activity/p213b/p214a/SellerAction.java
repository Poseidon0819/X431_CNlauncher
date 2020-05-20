package com.cnlaunch.x431pro.activity.p213b.p214a;

import android.content.Context;
import android.text.TextUtils;
import com.cnlaunch.p120d.p121a.KeyConstant;
import com.cnlaunch.p120d.p121a.p122a.JsonMananger;
import com.cnlaunch.p120d.p125c.p128c.C1425f;
import com.cnlaunch.p120d.p125c.p128c.C1426i;
import com.cnlaunch.x431pro.activity.p213b.p215b.CarSeriesResponse;
import com.cnlaunch.x431pro.activity.p213b.p215b.CheckMerchantResponse;
import com.cnlaunch.x431pro.activity.p213b.p215b.GetShopStatisticResponse;
import com.cnlaunch.x431pro.activity.p213b.p215b.LatestVersionInfo;
import com.cnlaunch.x431pro.module.p241a.BaseAction;
import com.cnlaunch.x431pro.module.p241a.CommonResponse;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;

/* renamed from: com.cnlaunch.x431pro.activity.b.a.a */
/* loaded from: classes.dex */
public class SellerAction extends BaseAction {

    /* renamed from: s */
    private static final String f10886s = "a";

    public SellerAction(Context context) {
        super(context);
    }

    /* renamed from: a */
    public final LatestVersionInfo m7809a(String str) throws C1425f {
        String b = m5451b(KeyConstant.f6776C);
        C1426i c1426i = new C1426i();
        c1426i.m9506a("vision_no", str);
        String m9477a = this.f15446f.m9477a(m5448c(b, c1426i), c1426i);
        if (TextUtils.isEmpty(m9477a)) {
            return null;
        }
        JsonMananger.m9626a();
        return (LatestVersionInfo) JsonMananger.m9622b(m9477a, LatestVersionInfo.class);
    }

    /* renamed from: a */
    public final CommonResponse m7807a(String str, String str2, String str3, String str4) throws C1425f {
        String b = m5451b("shop.bind_admin_public");
        C1426i c1426i = new C1426i();
        c1426i.m9506a("public_username", str);
        c1426i.m9506a("public_password", str2);
        c1426i.m9506a("pro_username", str3);
        c1426i.m9506a("pro_password", str4);
        return m5433e(m5446d(b, c1426i), c1426i);
    }

    /* renamed from: a */
    public final CommonResponse m7806a(Map<String, String> map) throws C1425f, FileNotFoundException {
        String b = m5451b("shop_service.register_information");
        C1426i c1426i = new C1426i();
        c1426i.m9506a("uid", map.get("uid"));
        c1426i.m9506a("public_type", map.get("public_type"));
        c1426i.m9506a("public_name", map.get("public_name"));
        c1426i.m9506a("company_name", map.get("company_name"));
        c1426i.m9506a("nation", map.get("nation"));
        c1426i.m9506a("address", map.get("address"));
        c1426i.m9506a("longitude", map.get("longitude"));
        c1426i.m9506a("latitude", map.get("latitude"));
        c1426i.m9506a("contact_person", map.get("contact_person"));
        c1426i.m9506a("contact_phone", map.get("contact_phone"));
        c1426i.m9506a("car_brand", map.get("car_brand"));
        c1426i.m9509a("company_face", new File(map.get("company_face")));
        c1426i.m9506a("company_intro", map.get("company_intro"));
        return m5433e(m5446d(b, c1426i), c1426i);
    }

    /* renamed from: a */
    public final CarSeriesResponse m7808a(String str, String str2) throws C1425f {
        String b = m5451b("mine_car.query_x431_car_series_world");
        C1426i c1426i = new C1426i();
        c1426i.m9506a("lan_id_or_name", str);
        c1426i.m9506a("is_abroad", str2);
        String m9477a = this.f15446f.m9477a(b, c1426i);
        if (TextUtils.isEmpty(m9477a)) {
            return null;
        }
        return (CarSeriesResponse) m5438a(m9477a, CarSeriesResponse.class);
    }

    /* renamed from: b */
    public final CheckMerchantResponse m7805b(String str, String str2, String str3, String str4) throws C1425f {
        String b = m5451b("shop_service.golo_login");
        C1426i c1426i = new C1426i();
        c1426i.m9506a("username", str);
        c1426i.m9506a("password", str2);
        c1426i.m9506a("d_model", str4);
        c1426i.m9506a("imei", str3);
        String m9475b = this.f15446f.m9475b(m5446d(b, c1426i), c1426i);
        if (TextUtils.isEmpty(m9475b)) {
            return null;
        }
        return (CheckMerchantResponse) m5438a(m9475b, CheckMerchantResponse.class);
    }

    /* renamed from: a */
    public final GetShopStatisticResponse m7810a() throws C1425f {
        String b = m5451b("shop_statistics.home");
        C1426i c1426i = new C1426i();
        c1426i.m9506a("is_count", "1");
        String m9477a = this.f15446f.m9477a(m5455a(b, c1426i), c1426i);
        if (TextUtils.isEmpty(m9477a)) {
            return null;
        }
        JsonMananger.m9626a();
        return (GetShopStatisticResponse) JsonMananger.m9622b(m9477a, GetShopStatisticResponse.class);
    }
}
