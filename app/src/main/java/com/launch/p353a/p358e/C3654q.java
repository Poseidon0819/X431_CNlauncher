package com.launch.p353a.p358e;

import android.support.p012v4.view.ViewPager;
import com.launch.p353a.p358e.StepDialog;
import org.json.JSONArray;
import org.json.JSONException;

/* compiled from: StepDialog.java */
/* renamed from: com.launch.a.e.q */
/* loaded from: classes.dex */
final class C3654q implements ViewPager.InterfaceC0176e {

    /* renamed from: a */
    final /* synthetic */ StepDialog f19925a;

    @Override // android.support.p012v4.view.ViewPager.InterfaceC0176e
    /* renamed from: a */
    public final void mo1773a(int i, float f, int i2) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C3654q(StepDialog stepDialog) {
        this.f19925a = stepDialog;
    }

    @Override // android.support.p012v4.view.ViewPager.InterfaceC0176e
    /* renamed from: a */
    public final void mo1774a(int i) {
        JSONArray jSONArray;
        JSONArray jSONArray2;
        int i2;
        this.f19925a.f19911h = i;
        try {
            jSONArray = this.f19925a.f19908e;
            if (jSONArray != null) {
                jSONArray2 = this.f19925a.f19908e;
                i2 = this.f19925a.f19911h;
                jSONArray2.getJSONObject(i2).getString("viewId");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override // android.support.p012v4.view.ViewPager.InterfaceC0176e
    /* renamed from: a_ */
    public final void mo1772a_(int i) {
        StepDialog.InterfaceC3649a interfaceC3649a;
        int i2;
        boolean z;
        StepDialog.InterfaceC3649a unused;
        int unused2;
        switch (i) {
            case 0:
                interfaceC3649a = this.f19925a.f19907d;
                if (interfaceC3649a != null) {
                    unused = this.f19925a.f19907d;
                    unused2 = this.f19925a.f19911h;
                }
                i2 = this.f19925a.f19911h;
                if (i2 == this.f19925a.f19910g.size() - 1) {
                    z = this.f19925a.f19912i;
                    if (z) {
                        this.f19925a.getDialog().dismiss();
                        return;
                    }
                    return;
                }
                return;
            case 1:
                this.f19925a.f19912i = true;
                return;
            case 2:
                this.f19925a.f19912i = false;
                return;
            default:
                return;
        }
    }
}
