package com.unionpay.mobile.android.widgets;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import com.unionpay.mobile.android.global.C4149a;
import com.unionpay.mobile.android.languages.C4171c;
import com.unionpay.mobile.android.resource.C4342c;
import com.unionpay.mobile.android.utils.C4389j;
import org.codehaus.jackson.util.MinimalPrettyPrinter;
import org.json.JSONObject;

/* renamed from: com.unionpay.mobile.android.widgets.aa */
/* loaded from: classes2.dex */
public abstract class AbstractC4420aa extends AbstractC4486z {

    /* renamed from: a */
    protected int f23322a;

    /* renamed from: b */
    protected View$OnClickListenerC4479u f23323b;

    /* renamed from: c */
    private InterfaceC4421a f23324c;

    /* renamed from: com.unionpay.mobile.android.widgets.aa$a */
    /* loaded from: classes2.dex */
    public interface InterfaceC4421a {
        /* renamed from: a */
        void mo719a(View$OnClickListenerC4479u view$OnClickListenerC4479u, String str);
    }

    public AbstractC4420aa(Context context, int i, JSONObject jSONObject, String str) {
        this(context, i, jSONObject, str, (byte) 0);
    }

    public AbstractC4420aa(Context context, int i, JSONObject jSONObject, String str, byte b) {
        super(context, jSONObject, str);
        View$OnClickListenerC4479u view$OnClickListenerC4479u;
        String str2;
        View$OnClickListenerC4479u view$OnClickListenerC4479u2;
        C4342c m1036a;
        int i2;
        this.f23323b = null;
        this.f23324c = null;
        this.f23322a = i;
        C4342c.m1036a(this.f23397d);
        this.f23323b = new View$OnClickListenerC4479u(getContext());
        if (this.f23402i) {
            this.f23323b.m611a();
            this.f23323b.m593d();
        }
        this.f23323b.m594c(mo579i());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, C4149a.f22125n);
        layoutParams.addRule(15, -1);
        this.f23406m.addView(this.f23323b, layoutParams);
        this.f23323b.m597b(C4389j.m846a(jSONObject, "placeholder"));
        this.f23323b.setFocusable(true);
        this.f23323b.m605a(new C4422ab(this));
        this.f23323b.m607a(new C4423ac(this));
        this.f23323b.m609a(C4342c.m1036a(this.f23397d).m1037a(2000, -1, C4149a.f22133v));
        if (!(this instanceof C4426af)) {
            if (this instanceof C4439ap) {
                view$OnClickListenerC4479u = this.f23323b;
                str2 = C4171c.f22227bD.f22272aR;
            } else if (this instanceof C4429ah) {
                view$OnClickListenerC4479u = this.f23323b;
                str2 = C4171c.f22227bD.f22274aT;
            } else if (this instanceof UPWidget) {
                view$OnClickListenerC4479u = this.f23323b;
                str2 = C4171c.f22227bD.f22273aS;
            } else if (this instanceof C4445au) {
                view$OnClickListenerC4479u = this.f23323b;
                str2 = C4171c.f22227bD.f22275aU;
            } else if (this instanceof C4438ao) {
                view$OnClickListenerC4479u = this.f23323b;
                str2 = C4171c.f22227bD.f22276aV;
            } else if (this instanceof C4463e) {
                view$OnClickListenerC4479u = this.f23323b;
                str2 = C4171c.f22227bD.f22277aW;
            } else if (this instanceof C4425ae) {
                view$OnClickListenerC4479u = this.f23323b;
                str2 = C4171c.f22227bD.f22278aX;
            } else if (this instanceof C4459bd) {
                view$OnClickListenerC4479u = this.f23323b;
                str2 = C4171c.f22227bD.f22279aY;
            } else if (this instanceof C4444at) {
                view$OnClickListenerC4479u = this.f23323b;
                str2 = C4171c.f22227bD.f22280aZ;
            } else if (this instanceof C4446av) {
                view$OnClickListenerC4479u = this.f23323b;
                str2 = C4171c.f22227bD.f22311ba;
            } else if (this instanceof C4464f) {
                view$OnClickListenerC4479u = this.f23323b;
                str2 = C4171c.f22227bD.f22312bb;
            }
            view$OnClickListenerC4479u.m601a(str2);
        } else if (this.f23402i) {
            View$OnClickListenerC4479u view$OnClickListenerC4479u3 = this.f23323b;
            view$OnClickListenerC4479u3.m594c(this.f23401h + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + this.f23400g);
        } else {
            view$OnClickListenerC4479u = this.f23323b;
            str2 = C4171c.f22227bD.f22271aQ;
            view$OnClickListenerC4479u.m601a(str2);
        }
        if (this instanceof C4469k) {
            view$OnClickListenerC4479u2 = this.f23323b;
            m1036a = C4342c.m1036a(this.f23397d);
            i2 = 1011;
        } else {
            view$OnClickListenerC4479u2 = this.f23323b;
            m1036a = C4342c.m1036a(this.f23397d);
            i2 = 1013;
        }
        view$OnClickListenerC4479u2.setBackgroundDrawable(m1036a.m1037a(i2, -1, -1));
    }

    /* renamed from: a */
    public String mo585a() {
        return this.f23323b.m600b();
    }

    /* renamed from: a */
    public void mo656a(Editable editable) {
    }

    /* renamed from: a */
    public final void m723a(InterfaceC4421a interfaceC4421a) {
        this.f23324c = interfaceC4421a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public final boolean m724a(View view) {
        if (view != null) {
            Rect rect = new Rect();
            view.getGlobalVisibleRect(rect);
            Log.e("uppay", "v getGlobalVisibleRect():" + rect.toString());
            Rect rect2 = new Rect();
            ((Activity) this.f23397d).getWindow().getDecorView().findViewById(16908290).getGlobalVisibleRect(rect2);
            int[] iArr = new int[2];
            view.getLocationInWindow(iArr);
            Log.e("uppay", " locationW = [" + iArr[0] + "," + iArr[1] + "]");
            int[] iArr2 = new int[2];
            view.getLocationOnScreen(iArr2);
            Log.e("uppay", " locationS = [" + iArr2[0] + "," + iArr2[1] + "]");
            boolean z = (iArr[1] + view.getHeight()) + 10 > rect2.bottom;
            View findViewById = ((Activity) this.f23397d).getWindow().getDecorView().findViewById(16908290);
            Rect rect3 = new Rect();
            findViewById.getLocalVisibleRect(rect3);
            Log.e("uppay", " getLocalVisibleRect = " + rect3.toString());
            Rect rect4 = new Rect();
            findViewById.getGlobalVisibleRect(rect4);
            Log.e("uppay", " getGlobalVisibleRect = " + rect4.toString());
            return z;
        }
        throw new NullPointerException();
    }

    /* renamed from: a */
    public final boolean m721a(View$OnClickListenerC4479u view$OnClickListenerC4479u) {
        return view$OnClickListenerC4479u != null && this.f23323b == view$OnClickListenerC4479u;
    }

    /* renamed from: c */
    public boolean mo583c() {
        return (mo585a() == null || mo585a().length() == 0) ? false : true;
    }

    /* renamed from: g */
    public final void m720g() {
        if (this.f23323b == null || this.f23402i) {
            return;
        }
        this.f23323b.m591e();
    }
}
