package com.cnlaunch.x431pro.activity.login;

import android.content.Context;
import com.cnlaunch.diagnosemodule.wiget.NToast;
import com.cnlaunch.p120d.p125c.p128c.C1425f;
import com.cnlaunch.x431pro.activity.p213b.p214a.SellerAction;
import com.cnlaunch.x431pro.module.p241a.CommonResponse;
import com.ifoer.expedition.pro.R;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* renamed from: com.cnlaunch.x431pro.activity.login.bu */
/* loaded from: classes.dex */
public final class RegistMerchantClass extends NetworkBase {

    /* renamed from: c */
    private static List<InterfaceC2349a> f13456c = new ArrayList();

    /* renamed from: a */
    HashMap<String, String> f13457a;

    /* renamed from: b */
    private SellerAction f13458b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: RegistMerchantClass.java */
    /* renamed from: com.cnlaunch.x431pro.activity.login.bu$a */
    /* loaded from: classes.dex */
    public interface InterfaceC2349a {
        /* renamed from: a */
        void mo6547a();
    }

    public RegistMerchantClass(Context context) {
        super(context);
        this.f13458b = new SellerAction(this.f13412d);
    }

    @Override // com.cnlaunch.x431pro.activity.login.NetworkBase, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public final Object doInBackground(int i) throws C1425f {
        if (i == 2110) {
            try {
                return this.f13458b.m7806a((Map<String, String>) this.f13457a);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        return super.doInBackground(i);
    }

    @Override // com.cnlaunch.x431pro.activity.login.NetworkBase, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public final void onSuccess(int i, Object obj) {
        if (i == 2110 && obj != null) {
            CommonResponse commonResponse = (CommonResponse) obj;
            if (commonResponse.getCode() != 0) {
                m6550a();
                NToast.shortToast(this.f13412d, this.f13412d.getString(R.string.regist_merchant_complete_failed, String.valueOf(commonResponse.getCode())));
                NToast.shortToast(this.f13412d, this.f13412d.getString(R.string.default_error, String.valueOf(commonResponse.getCode())));
            } else {
                for (InterfaceC2349a interfaceC2349a : f13456c) {
                    interfaceC2349a.mo6547a();
                }
                NToast.shortToast(this.f13412d, (int) R.string.regist_merchant_complete_success);
            }
        }
        super.onSuccess(i, obj);
    }

    @Override // com.cnlaunch.x431pro.activity.login.NetworkBase, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public final void onFailure(int i, int i2, Object obj) {
        super.onFailure(i, i2, obj);
        if (i != 2110) {
            return;
        }
        m6550a();
    }

    /* renamed from: a */
    public static synchronized void m6549a(InterfaceC2349a interfaceC2349a) {
        synchronized (RegistMerchantClass.class) {
            f13456c.add(interfaceC2349a);
        }
    }

    /* renamed from: b */
    public static synchronized void m6548b(InterfaceC2349a interfaceC2349a) {
        synchronized (RegistMerchantClass.class) {
            f13456c.remove(interfaceC2349a);
        }
    }

    /* renamed from: a */
    private static void m6550a() {
        Iterator<InterfaceC2349a> it = f13456c.iterator();
        while (it.hasNext()) {
            it.next();
        }
    }
}
