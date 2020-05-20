package com.unionpay.mobile.android.widgets;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.unionpay.mobile.android.global.C4149a;
import com.unionpay.mobile.android.global.C4150b;
import com.unionpay.mobile.android.resource.C4342c;
import com.unionpay.mobile.android.utils.C4386g;
import com.unionpay.mobile.android.utils.C4387h;
import java.lang.ref.WeakReference;

/* renamed from: com.unionpay.mobile.android.widgets.m */
/* loaded from: classes2.dex */
public final class C4471m {

    /* renamed from: k */
    private static final float f23463k = C4150b.f22148k;

    /* renamed from: l */
    private static final float f23464l = C4150b.f22148k;

    /* renamed from: m */
    private static final float f23465m = C4150b.f22147j;

    /* renamed from: a */
    private Context f23466a;

    /* renamed from: b */
    private TextView f23467b;

    /* renamed from: c */
    private WeakReference<View.OnClickListener> f23468c;

    /* renamed from: d */
    private TextView f23469d;

    /* renamed from: e */
    private WeakReference<View.OnClickListener> f23470e;

    /* renamed from: f */
    private int f23471f;

    /* renamed from: g */
    private C4342c f23472g;

    /* renamed from: h */
    private Dialog f23473h;

    /* renamed from: i */
    private Drawable f23474i;

    /* renamed from: j */
    private WeakReference<DialogInterface.OnDismissListener> f23475j;

    public C4471m(Context context) {
        this(context, (byte) 0);
    }

    private C4471m(Context context, byte b) {
        this.f23466a = null;
        this.f23467b = null;
        this.f23468c = null;
        this.f23469d = null;
        this.f23470e = null;
        this.f23471f = 0;
        this.f23472g = null;
        this.f23473h = null;
        this.f23474i = null;
        this.f23475j = null;
        this.f23466a = context;
        this.f23475j = new WeakReference<>(null);
        this.f23472g = C4342c.m1036a(context);
        this.f23471f = C4149a.f22105I - (C4149a.f22113b * 4);
        this.f23474i = this.f23472g.m1037a(1028, this.f23471f / 2, -1);
    }

    /* renamed from: a */
    private RelativeLayout m637a(Context context) {
        m630c();
        this.f23473h = new DialogC4472n(this, context);
        WeakReference<DialogInterface.OnDismissListener> weakReference = this.f23475j;
        if (weakReference != null && weakReference.get() != null) {
            this.f23473h.setOnDismissListener(this.f23475j.get());
        }
        this.f23473h.setCanceledOnTouchOutside(false);
        this.f23473h.setOwnerActivity((Activity) context);
        this.f23473h.requestWindowFeature(1);
        this.f23473h.getWindow().setBackgroundDrawable(this.f23472g.m1037a(4004, -1, -1));
        RelativeLayout relativeLayout = new RelativeLayout(this.f23466a);
        this.f23473h.getWindow().setBackgroundDrawable(this.f23472g.m1037a(4004, -1, -1));
        this.f23473h.setContentView(relativeLayout, new RelativeLayout.LayoutParams(this.f23471f, -2));
        RelativeLayout relativeLayout2 = new RelativeLayout(this.f23466a);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13, -1);
        relativeLayout.addView(relativeLayout2, layoutParams);
        return relativeLayout;
    }

    /* renamed from: d */
    private boolean m629d() {
        return ((Activity) this.f23466a).isFinishing();
    }

    /* renamed from: a */
    public final void m636a(View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        this.f23468c = new WeakReference<>(onClickListener);
        this.f23470e = new WeakReference<>(onClickListener2);
    }

    /* renamed from: a */
    public final void m635a(String str) {
        int m858a = C4386g.m858a(this.f23466a, 12.0f);
        C4386g.m858a(this.f23466a, 20.0f);
        RelativeLayout m637a = m637a(this.f23466a);
        m637a.setBackgroundColor(C4149a.f22109M);
        Dialog dialog = this.f23473h;
        if (dialog != null) {
            WindowManager.LayoutParams attributes = dialog.getWindow().getAttributes();
            attributes.alpha = 0.7f;
            this.f23473h.getWindow().setAttributes(attributes);
        }
        LinearLayout linearLayout = new LinearLayout(this.f23466a);
        linearLayout.setOrientation(1);
        linearLayout.setGravity(17);
        int i = this.f23471f - (C4149a.f22121j << 1);
        ImageView imageView = new ImageView(this.f23466a);
        imageView.setImageDrawable(this.f23474i);
        linearLayout.addView(imageView, new LinearLayout.LayoutParams(i, -2));
        TextView textView = new TextView(this.f23466a);
        textView.setTextSize(f23464l);
        textView.setTextColor(-1);
        textView.setText(str);
        textView.setGravity(16);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.topMargin = m858a;
        linearLayout.addView(textView, layoutParams);
        LinearLayout linearLayout2 = new LinearLayout(this.f23466a);
        linearLayout2.setOrientation(0);
        linearLayout2.setGravity(17);
        int i2 = C4149a.f22127p;
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(i2, i2);
        layoutParams2.topMargin = m858a;
        linearLayout.addView(new ProgressBar(this.f23466a), layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams3.addRule(10, -1);
        layoutParams3.addRule(14, -1);
        int m858a2 = C4386g.m858a(this.f23466a, 20.0f);
        m637a.setPadding(m858a2, m858a2, m858a2, m858a2);
        m637a.addView(linearLayout, layoutParams3);
        Dialog dialog2 = this.f23473h;
        if (dialog2 == null || dialog2.isShowing() || m629d()) {
            return;
        }
        this.f23473h.show();
    }

    /* renamed from: a */
    public final void m634a(String str, String str2, String str3) {
        RelativeLayout m637a = m637a(this.f23466a);
        int i = C4149a.f22113b;
        LinearLayout linearLayout = new LinearLayout(this.f23466a);
        linearLayout.setOrientation(1);
        linearLayout.setGravity(1);
        m637a.addView(linearLayout, new LinearLayout.LayoutParams(-1, -2));
        if (str != null && str.length() != 0) {
            TextView textView = new TextView(this.f23466a);
            textView.getPaint().setFakeBoldText(true);
            textView.setTextSize(f23463k);
            textView.setTextColor(-13421773);
            textView.setText(str);
            textView.setGravity(17);
            textView.setPadding(i, i << 1, i, i);
            linearLayout.addView(textView, new LinearLayout.LayoutParams(-1, -2));
        }
        TextView textView2 = new TextView(this.f23466a);
        textView2.setTextSize(f23464l);
        textView2.setTextColor(-13421773);
        textView2.setText(str2);
        textView2.setPadding(i, i, i, 0);
        textView2.setGravity(17);
        linearLayout.addView(textView2, new LinearLayout.LayoutParams(-1, -2));
        FrameLayout frameLayout = new FrameLayout(this.f23466a);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = C4149a.f22113b << 1;
        linearLayout.addView(frameLayout, layoutParams);
        LinearLayout linearLayout2 = new LinearLayout(this.f23466a);
        linearLayout2.setOrientation(1);
        frameLayout.addView(linearLayout2, new LinearLayout.LayoutParams(-1, -2));
        LinearLayout linearLayout3 = new LinearLayout(this.f23466a);
        linearLayout3.setOrientation(0);
        linearLayout3.setBackgroundColor(-7829368);
        new LinearLayout.LayoutParams(-1, -2);
        linearLayout2.addView(linearLayout3);
        LinearLayout linearLayout4 = new LinearLayout(this.f23466a);
        linearLayout2.addView(linearLayout4, new LinearLayout.LayoutParams(-1, -2));
        linearLayout4.setOrientation(0);
        linearLayout4.setGravity(17);
        this.f23467b = new TextView(this.f23466a);
        this.f23467b.setPadding(5, 5, 5, 5);
        this.f23467b.getPaint().setFakeBoldText(true);
        this.f23467b.setText(str3);
        this.f23467b.setTextSize(f23465m);
        this.f23467b.setTextColor(C4387h.m856a(-15364869, -5846275));
        this.f23467b.setGravity(17);
        int i2 = C4149a.f22126o;
        WeakReference<View.OnClickListener> weakReference = this.f23468c;
        if (weakReference != null && weakReference.get() != null) {
            this.f23467b.setOnClickListener(this.f23468c.get());
        }
        linearLayout4.addView(this.f23467b, new LinearLayout.LayoutParams(-1, i2));
        frameLayout.addView(new C4473o(this.f23466a), new FrameLayout.LayoutParams(-1, C4149a.f22104H));
        Dialog dialog = this.f23473h;
        if (dialog == null || dialog.isShowing() || m629d()) {
            return;
        }
        this.f23473h.show();
    }

    /* renamed from: a */
    public final void m633a(String str, String str2, String str3, String str4) {
        m632a(str, str2, str3, str4, true);
    }

    /* renamed from: a */
    public final void m632a(String str, String str2, String str3, String str4, boolean z) {
        RelativeLayout m637a = m637a(this.f23466a);
        int i = C4149a.f22113b;
        LinearLayout linearLayout = new LinearLayout(this.f23466a);
        linearLayout.setOrientation(1);
        linearLayout.setGravity(1);
        m637a.addView(linearLayout, new LinearLayout.LayoutParams(-1, -2));
        if (str != null && str.length() != 0) {
            TextView textView = new TextView(this.f23466a);
            textView.getPaint().setFakeBoldText(true);
            textView.setTextSize(f23463k);
            textView.setTextColor(-13421773);
            textView.setText(str);
            textView.setGravity(17);
            textView.setPadding(i, i << 1, i, i);
            linearLayout.addView(textView, new LinearLayout.LayoutParams(-1, -2));
        }
        TextView textView2 = new TextView(this.f23466a);
        textView2.setTextSize(f23464l);
        textView2.setTextColor(-13421773);
        textView2.setText(str2);
        textView2.setPadding(i, i, i, 0);
        textView2.setGravity(17);
        linearLayout.addView(textView2, new LinearLayout.LayoutParams(-1, -2));
        int m858a = C4386g.m858a(this.f23466a, 1.0f);
        LinearLayout linearLayout2 = new LinearLayout(this.f23466a);
        linearLayout2.setOrientation(0);
        linearLayout2.setBackgroundColor(-7829368);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, m858a);
        layoutParams.topMargin = C4149a.f22113b << 1;
        linearLayout.addView(linearLayout2, layoutParams);
        LinearLayout linearLayout3 = new LinearLayout(this.f23466a);
        linearLayout3.setBackgroundColor(-1);
        linearLayout.addView(linearLayout3, new LinearLayout.LayoutParams(-1, -2));
        linearLayout3.setOrientation(0);
        linearLayout3.setGravity(17);
        int i2 = (this.f23471f - C4149a.f22104H) >> 1;
        this.f23467b = new TextView(this.f23466a);
        if (!z) {
            this.f23467b.getPaint().setFakeBoldText(true);
        }
        this.f23467b.setText(str3);
        this.f23467b.setTextSize(f23465m);
        this.f23467b.setTextColor(C4387h.m856a(-15364869, -5846275));
        this.f23467b.setGravity(17);
        int i3 = C4149a.f22126o;
        WeakReference<View.OnClickListener> weakReference = this.f23468c;
        if (weakReference != null && weakReference.get() != null) {
            this.f23467b.setOnClickListener(this.f23468c.get());
        }
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(i2, i3);
        layoutParams2.leftMargin = 5;
        layoutParams2.bottomMargin = 5;
        linearLayout3.addView(this.f23467b, layoutParams2);
        LinearLayout linearLayout4 = new LinearLayout(this.f23466a);
        linearLayout4.setOrientation(1);
        linearLayout4.setBackgroundColor(-7829368);
        linearLayout3.addView(linearLayout4, new LinearLayout.LayoutParams(m858a, -1));
        this.f23469d = new TextView(this.f23466a);
        if (z) {
            this.f23469d.getPaint().setFakeBoldText(true);
        }
        this.f23469d.setText(str4);
        this.f23469d.setTextSize(f23465m);
        this.f23469d.setTextColor(C4387h.m856a(-15364869, -5846275));
        this.f23469d.setGravity(17);
        WeakReference<View.OnClickListener> weakReference2 = this.f23470e;
        if (weakReference2 != null && weakReference2.get() != null) {
            this.f23469d.setOnClickListener(this.f23470e.get());
        }
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(i2, i3);
        layoutParams3.leftMargin = 5;
        layoutParams3.bottomMargin = 5;
        linearLayout3.addView(this.f23469d, layoutParams3);
        Dialog dialog = this.f23473h;
        if (dialog == null || dialog.isShowing() || m629d()) {
            return;
        }
        this.f23473h.show();
    }

    /* renamed from: a */
    public final boolean m638a() {
        Dialog dialog = this.f23473h;
        return dialog != null && dialog.isShowing();
    }

    /* renamed from: b */
    public final void m631b() {
        Dialog dialog = this.f23473h;
        if (dialog != null) {
            dialog.hide();
            this.f23473h.show();
        }
    }

    /* renamed from: c */
    public final void m630c() {
        Dialog dialog = this.f23473h;
        if (dialog == null || !dialog.isShowing()) {
            return;
        }
        this.f23473h.dismiss();
        this.f23473h = null;
    }
}
