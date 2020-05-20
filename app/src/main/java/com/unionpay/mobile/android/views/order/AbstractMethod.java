package com.unionpay.mobile.android.views.order;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.unionpay.mobile.android.global.C4149a;
import com.unionpay.mobile.android.global.C4150b;
import com.unionpay.mobile.android.upviews.C4343a;
import com.unionpay.mobile.android.utils.C4386g;
import com.unionpay.mobile.android.utils.C4387h;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public abstract class AbstractMethod extends LinearLayout implements C4343a.InterfaceC4345b {

    /* renamed from: a */
    protected static final int f23212a = C4150b.f22138a;

    /* renamed from: b */
    protected Context f23213b;

    /* renamed from: c */
    protected String f23214c;

    /* renamed from: d */
    protected String f23215d;

    /* renamed from: e */
    protected InterfaceC4399b f23216e;

    /* renamed from: f */
    protected InterfaceC4398a f23217f;

    /* renamed from: g */
    private Button f23218g;

    /* renamed from: h */
    private RelativeLayout f23219h;

    /* renamed from: com.unionpay.mobile.android.views.order.AbstractMethod$a */
    /* loaded from: classes2.dex */
    public interface InterfaceC4398a {
        /* renamed from: a */
        void mo818a(int i, boolean z, int i2, C4343a.C4344a c4344a);
    }

    /* renamed from: com.unionpay.mobile.android.views.order.AbstractMethod$b */
    /* loaded from: classes2.dex */
    public interface InterfaceC4399b {
        /* renamed from: a */
        void mo817a(String str, String str2);
    }

    public AbstractMethod(Context context) {
        this(context, null);
    }

    public AbstractMethod(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AbstractMethod(Context context, AttributeSet attributeSet, int i) {
        super(context);
        this.f23213b = context;
        setOrientation(1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public static String m823a(JSONObject jSONObject, String str) {
        if (jSONObject != null) {
            try {
                return jSONObject.getString(str);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public static void m828a(TextView textView) {
        if (textView == null) {
            return;
        }
        textView.setTextSize(C4150b.f22148k);
        textView.setTextColor(C4387h.m854a(-10705958, -5846275, -5846275, -6710887));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public static boolean m824a(String str) {
        return str == null || str.length() == 0;
    }

    /* renamed from: a */
    public final void m830a() {
        this.f23219h = new RelativeLayout(this.f23213b);
        addView(this.f23219h, new LinearLayout.LayoutParams(-1, -2));
        mo782a(this.f23219h);
        RelativeLayout relativeLayout = new RelativeLayout(this.f23213b);
        addView(relativeLayout, new LinearLayout.LayoutParams(-1, -2));
        mo778b(relativeLayout);
        RelativeLayout relativeLayout2 = new RelativeLayout(this.f23213b);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = C4149a.f22117f;
        addView(relativeLayout2, layoutParams);
        this.f23218g = new Button(this.f23213b);
        this.f23218g.setText(mo771e());
        Button button = this.f23218g;
        int i = C4150b.f22139b;
        int i2 = C4150b.f22140c;
        button.setTextColor(C4387h.m854a(i, i2, i2, C4150b.f22141d));
        this.f23218g.setTextSize(C4150b.f22146i);
        this.f23218g.setOnClickListener(new View$OnClickListenerC4401a(this));
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, C4150b.f22151n);
        layoutParams2.addRule(15, -1);
        layoutParams2.topMargin = C4149a.f22117f;
        int m858a = C4386g.m858a(this.f23213b, 10.0f);
        layoutParams2.rightMargin = m858a;
        layoutParams2.leftMargin = m858a;
        relativeLayout2.addView(this.f23218g, layoutParams2);
        RelativeLayout relativeLayout3 = new RelativeLayout(this.f23213b);
        addView(relativeLayout3, layoutParams);
        mo773c(relativeLayout3);
        this.f23218g.setEnabled(mo769f());
    }

    /* renamed from: a */
    public final void m829a(Drawable drawable) {
        Button button = this.f23218g;
        if (button == null || drawable == null) {
            return;
        }
        button.setBackgroundDrawable(drawable);
    }

    /* renamed from: a */
    public abstract void mo782a(RelativeLayout relativeLayout);

    @Override // com.unionpay.mobile.android.upviews.C4343a.InterfaceC4345b
    /* renamed from: a */
    public final void mo827a(C4343a.C4344a c4344a) {
    }

    /* renamed from: a */
    public final void m826a(InterfaceC4398a interfaceC4398a) {
        this.f23217f = interfaceC4398a;
    }

    /* renamed from: a */
    public final void m825a(InterfaceC4399b interfaceC4399b) {
        this.f23216e = interfaceC4399b;
    }

    @Override // com.unionpay.mobile.android.upviews.C4343a.InterfaceC4345b
    /* renamed from: a */
    public final void mo822a(boolean z) {
        this.f23218g.setEnabled(!z);
    }

    /* renamed from: b */
    public abstract int mo779b();

    /* renamed from: b */
    public abstract void mo778b(RelativeLayout relativeLayout);

    /* renamed from: c */
    public abstract C4343a.C4344a mo774c();

    /* renamed from: c */
    public abstract void mo773c(RelativeLayout relativeLayout);

    @Override // com.unionpay.mobile.android.upviews.C4343a.InterfaceC4345b
    /* renamed from: c */
    public final void mo821c(String str) {
    }

    @Override // com.unionpay.mobile.android.upviews.C4343a.InterfaceC4345b
    /* renamed from: c */
    public final void mo820c(String str, String str2) {
    }

    /* renamed from: d */
    public int mo791d() {
        return 0;
    }

    /* renamed from: e */
    public abstract String mo771e();

    /* renamed from: f */
    public abstract boolean mo769f();

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: g */
    public final void m819g() {
        this.f23219h.setVisibility(8);
    }
}
