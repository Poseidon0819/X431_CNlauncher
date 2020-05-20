package com.unionpay.mobile.android.upwidget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Html;
import android.view.View;
import android.widget.LinearLayout;
import com.itextpdf.text.html.HtmlTags;
import com.unionpay.mobile.android.utils.C4387h;
import com.unionpay.mobile.android.utils.C4389j;
import org.json.JSONObject;

/* renamed from: com.unionpay.mobile.android.upwidget.w */
/* loaded from: classes2.dex */
public final class C4378w extends LinearLayout {

    /* renamed from: a */
    private String f23169a;

    /* renamed from: b */
    private C4379x f23170b;

    private C4378w(Context context, String str, String str2, Drawable drawable) {
        super(context);
        this.f23169a = null;
        this.f23170b = null;
        setOrientation(0);
        this.f23169a = str2;
        this.f23170b = C4379x.m908a(context, drawable);
        this.f23170b.m906a(Html.fromHtml(String.format("<u>%s</u>", str)));
        this.f23170b.m907a(C4387h.m856a(-13601621, -15909519));
        addView(this.f23170b);
    }

    /* renamed from: a */
    public static final C4378w m910a(Context context, JSONObject jSONObject, Drawable drawable) {
        if (jSONObject != null) {
            return new C4378w(context, C4389j.m846a(jSONObject, "label"), C4389j.m846a(jSONObject, HtmlTags.HREF), drawable);
        }
        return null;
    }

    /* renamed from: a */
    public final String m911a() {
        return this.f23169a;
    }

    /* renamed from: a */
    public final void m909a(View.OnClickListener onClickListener) {
        C4379x c4379x = this.f23170b;
        if (c4379x != null) {
            c4379x.setOnClickListener(onClickListener);
        }
    }
}
