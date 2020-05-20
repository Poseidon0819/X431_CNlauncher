package com.cnlaunch.x431pro.p210a;

import android.content.Context;
import android.text.TextUtils;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.p120d.p130d.NToast;
import com.cnlaunch.x431pro.module.rtu.ProductInformation;
import com.ifoer.expedition.pro.R;

/* renamed from: com.cnlaunch.x431pro.a.m */
/* loaded from: classes.dex */
public abstract class RTUHelper {

    /* renamed from: b */
    public Long f10586b;

    /* renamed from: c */
    public Long f10587c;

    /* renamed from: d */
    public Long f10588d;

    /* renamed from: e */
    public Context f10589e;

    /* renamed from: a */
    public abstract void mo7066a();

    public RTUHelper(Context context) {
        this.f10589e = context;
    }

    /* renamed from: b */
    public final void m7943b() {
        if (C1947h.f10551c) {
            return;
        }
        try {
            ProductInformation productInformation = new ProductInformation(this.f10589e, PreferencesManager.m9595a(this.f10589e).m9591a("serialNo"));
            PreferencesManager.m9595a(this.f10589e).m9587a("tryFlag", productInformation.f15696a);
            PreferencesManager.m9595a(this.f10589e).m9589a("tryFlagStartTime", productInformation.f15698c);
            PreferencesManager.m9595a(this.f10589e).m9589a("lastRemindTime", productInformation.f15699d);
            PreferencesManager.m9595a(this.f10589e).m9589a("totalDiagTime", productInformation.f15700e);
            PreferencesManager.m9595a(this.f10589e).m9588a("diagTime_date", productInformation.f15701f);
            String str = productInformation.f15702g;
            if (TextUtils.isEmpty(str) || str.equals(PreferencesManager.m9595a(this.f10589e).m9591a("serialNo"))) {
                return;
            }
            NToast.m9446b(this.f10589e, this.f10589e.getResources().getString(R.string.tryflag_illegal_operation));
            mo7066a();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: c */
    public final void m7942c() {
        Context context = this.f10589e;
        ProductInformation productInformation = new ProductInformation(context, PreferencesManager.m9595a(context).m9591a("serialNo"));
        productInformation.f15699d = PreferencesManager.m9595a(this.f10589e).m9586b("lastRemindTime");
        productInformation.m5197b(PreferencesManager.m9595a(this.f10589e).m9591a("serialNo"));
    }

    /* renamed from: d */
    public final void m7941d() {
        new C1950n(this).m4603a(this.f10589e);
    }
}
