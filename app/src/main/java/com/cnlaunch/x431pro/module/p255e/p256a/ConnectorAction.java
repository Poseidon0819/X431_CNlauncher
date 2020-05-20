package com.cnlaunch.x431pro.module.p255e.p256a;

import android.content.Context;
import android.text.TextUtils;
import com.cnlaunch.p120d.p121a.KeyConstant;
import com.cnlaunch.p120d.p125c.p128c.C1425f;
import com.cnlaunch.p120d.p130d.NLog;
import com.cnlaunch.x431pro.module.golo.model.PidBytResponse;
import com.cnlaunch.x431pro.module.p241a.BaseAction;
import com.cnlaunch.x431pro.module.p241a.CommonResponse;
import com.cnlaunch.x431pro.module.p255e.p257b.ProductsRegDateResponse;
import com.cnlaunch.x431pro.module.p255e.p257b.RegisteredProductsResponse;
import com.cnlaunch.x431pro.p210a.CertificadoAceptar;
import java.util.List;
import org.p388a.p389a.SoapObject;

/* renamed from: com.cnlaunch.x431pro.module.e.a.a */
/* loaded from: classes.dex */
public final class ConnectorAction extends BaseAction {
    public ConnectorAction(Context context) {
        super(context);
    }

    /* renamed from: a */
    public final RegisteredProductsResponse m5361a(String str) throws C1425f {
        String b = m5451b(KeyConstant.f6839am);
        this.f15442d = m5447d("getRegisteredProductsForPad");
        this.f15442d.mo169a("productType", str);
        this.f15442d.mo169a("requestType", (Object) 1);
        try {
            new CertificadoAceptar();
            CertificadoAceptar.m7971a();
            this.f15447g = m5436f(b);
            this.f15448h = m5437a(m5453a((SoapObject) this.f15442d), this.f15442d);
            this.f15447g.m141a("", this.f15448h);
            if (this.f15448h != null) {
                return (RegisteredProductsResponse) m5441a(RegisteredProductsResponse.class, "productDTOs");
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    public final CommonResponse m5360a(String str, String str2, String str3) throws C1425f {
        String b = m5451b(KeyConstant.f6839am);
        this.f15442d = m5447d("registerProductForPad");
        this.f15442d.mo169a("serialNo", str);
        this.f15442d.mo169a("venderCode", str2);
        this.f15442d.mo169a("password", str3);
        return m5434a(b, this.f15442d, m5453a((SoapObject) this.f15442d));
    }

    /* renamed from: a */
    public final ProductsRegDateResponse m5359a(List<String> list) throws C1425f {
        String b = m5451b(KeyConstant.f6839am);
        StringBuilder sb = new StringBuilder();
        for (String str : list) {
            sb.append(str);
            sb.append(",");
        }
        String str2 = sb.substring(0, sb.length() - 1).toString();
        this.f15442d = m5447d("getProductRegisterTime");
        this.f15442d.mo169a("serialNoList", str2);
        try {
            this.f15447g = m5436f(b);
            this.f15448h = m5437a(m5453a((SoapObject) this.f15442d), this.f15442d);
            this.f15447g.m141a("", this.f15448h);
            if (this.f15448h != null) {
                return (ProductsRegDateResponse) m5441a(ProductsRegDateResponse.class, "productsRegDateDTOs");
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: g */
    public final PidBytResponse m5358g(String str) throws C1425f {
        String b = m5451b(KeyConstant.f6785L);
        this.f15440b = m5452b();
        this.f15440b.m9506a("tech_id", str);
        String m9475b = this.f15446f.m9475b(m5455a(b, this.f15440b), this.f15440b);
        PidBytResponse pidBytResponse = !TextUtils.isEmpty(m9475b) ? (PidBytResponse) m5438a(m9475b, PidBytResponse.class) : null;
        NLog.m9452b("Sanda", "获取技师的pub_id:Json=".concat(String.valueOf(m9475b)));
        return pidBytResponse;
    }
}
