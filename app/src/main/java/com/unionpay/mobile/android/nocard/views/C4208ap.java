package com.unionpay.mobile.android.nocard.views;

import android.os.Handler;
import android.os.Message;
import android.widget.LinearLayout;
import com.unionpay.mobile.android.languages.C4171c;
import com.unionpay.mobile.android.model.C4173b;
import com.unionpay.mobile.android.model.InterfaceC4175d;
import com.unionpay.mobile.android.utils.C4390k;
import com.unionpay.mobile.android.views.order.C4417o;
import com.unionpay.mobile.android.views.order.InterfaceC4414l;
import java.util.HashMap;
import java.util.Map;
import org.codehaus.jackson.util.MinimalPrettyPrinter;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.unionpay.mobile.android.nocard.views.ap */
/* loaded from: classes2.dex */
public final class C4208ap implements Handler.Callback {

    /* renamed from: a */
    final /* synthetic */ C4206ao f22561a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C4208ap(C4206ao c4206ao) {
        this.f22561a = c4206ao;
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message2) {
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        Map<String, Object> m1462b;
        C4390k.m836c("uppay", "mHceHandler. handleMessage");
        this.f22561a.m1450v();
        C4173b.f22371bl = true;
        if (this.f22561a.f22590a.f22415aP == InterfaceC4414l.f23277e.intValue()) {
            this.f22561a.f22551r.clear();
            this.f22561a.f22551r.remove(new HashMap());
            if (C4173b.f22370bb == null || C4173b.f22370bb.size() <= 0) {
                this.f22561a.m1405m();
                this.f22561a.f22590a.f22415aP = InterfaceC4414l.f23273a.intValue();
                this.f22561a.m1419a(C4171c.f22227bD.f22327bq, this.f22561a.f22590a.f22458bh, this.f22561a.f22590a.f22404aE, true);
            } else {
                int size = C4173b.f22370bb.size();
                for (int i = 0; i < size; i++) {
                    InterfaceC4175d interfaceC4175d = C4173b.f22370bb.get(i);
                    m1462b = C4206ao.m1462b(interfaceC4175d);
                    this.f22561a.f22551r.add(m1462b);
                    if (i == 0) {
                        C4417o c4417o = this.f22561a.f22556w;
                        c4417o.m747b(interfaceC4175d.mo1537b() + interfaceC4175d.mo1536c() + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + m1462b.get("text2"));
                    }
                }
                this.f22561a.f22556w.setVisibility(0);
                linearLayout = this.f22561a.f22557x;
                if (linearLayout != null) {
                    linearLayout2 = this.f22561a.f22557x;
                    linearLayout2.setVisibility(8);
                }
            }
        }
        return true;
    }
}
