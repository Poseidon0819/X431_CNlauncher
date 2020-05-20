package com.cnlaunch.x431pro.activity.mine;

import android.content.Context;
import android.view.View;
import com.cnlaunch.p120d.p130d.NToast;
import com.cnlaunch.x431pro.utils.C2787z;
import com.cnlaunch.x431pro.widget.ClearEditText;
import com.cnlaunch.x431pro.widget.p290a.LoadDialog;

/* renamed from: com.cnlaunch.x431pro.activity.mine.aa */
/* loaded from: classes.dex */
final class CreditCardFragment implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ FragmentC2499z f13615a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CreditCardFragment(FragmentC2499z fragmentC2499z) {
        this.f13615a = fragmentC2499z;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        ClearEditText clearEditText;
        ClearEditText clearEditText2;
        ClearEditText clearEditText3;
        ClearEditText clearEditText4;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        Context context;
        FragmentC2499z fragmentC2499z = this.f13615a;
        clearEditText = fragmentC2499z.f14340f;
        fragmentC2499z.f14336b = clearEditText.getEditableText().toString();
        FragmentC2499z fragmentC2499z2 = this.f13615a;
        clearEditText2 = fragmentC2499z2.f14341g;
        fragmentC2499z2.f14337c = clearEditText2.getEditableText().toString();
        FragmentC2499z fragmentC2499z3 = this.f13615a;
        clearEditText3 = fragmentC2499z3.f14342h;
        fragmentC2499z3.f14338d = clearEditText3.getEditableText().toString();
        FragmentC2499z fragmentC2499z4 = this.f13615a;
        clearEditText4 = fragmentC2499z4.f14343i;
        fragmentC2499z4.f14339e = clearEditText4.getEditableText().toString();
        str = this.f13615a.f14336b;
        if (!C2787z.m4821a(str)) {
            str2 = this.f13615a.f14337c;
            if (!C2787z.m4821a(str2)) {
                str3 = this.f13615a.f14338d;
                if (!C2787z.m4821a(str3)) {
                    str4 = this.f13615a.f14339e;
                    if (!C2787z.m4821a(str4)) {
                        str5 = this.f13615a.f14336b;
                        if (C2787z.m4806m(str5)) {
                            str6 = this.f13615a.f14337c;
                            if (C2787z.m4806m(str6)) {
                                str7 = this.f13615a.f14338d;
                                if (C2787z.m4806m(str7)) {
                                    str8 = this.f13615a.f14339e;
                                    if (C2787z.m4806m(str8)) {
                                        context = this.f13615a.mContext;
                                        LoadDialog.m4686a(context);
                                        this.f13615a.request(2001);
                                        return;
                                    }
                                }
                            }
                        }
                        NToast.m9446b(this.f13615a.getActivity(), "Sorry ,you cant't input a non-digit ");
                        return;
                    }
                }
            }
        }
        NToast.m9446b(this.f13615a.getActivity(), "Please input your card information!");
    }
}
