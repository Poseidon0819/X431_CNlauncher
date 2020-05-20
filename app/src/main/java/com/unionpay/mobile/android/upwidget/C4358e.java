package com.unionpay.mobile.android.upwidget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.itextpdf.text.html.HtmlTags;
import com.unionpay.mobile.android.global.C4150b;
import com.unionpay.mobile.android.resource.C4342c;
import com.unionpay.mobile.android.utils.C4386g;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* renamed from: com.unionpay.mobile.android.upwidget.e */
/* loaded from: classes2.dex */
public final class C4358e extends BaseAdapter {

    /* renamed from: a */
    private Drawable f23085a;

    /* renamed from: b */
    private Context f23086b;

    /* renamed from: c */
    private String f23087c;

    /* renamed from: e */
    private int f23089e;

    /* renamed from: f */
    private List<Map<String, Object>> f23090f;

    /* renamed from: d */
    private String f23088d = null;

    /* renamed from: g */
    private ArrayList<View.OnClickListener> f23091g = new ArrayList<>();

    /* renamed from: h */
    private View.OnClickListener f23092h = new View$OnClickListenerC4359f(this);

    public C4358e(Context context, List<Map<String, Object>> list, String str) {
        this.f23087c = null;
        this.f23089e = 1;
        this.f23086b = context;
        this.f23090f = list;
        this.f23087c = str;
        this.f23089e = 0;
        this.f23085a = C4342c.m1036a(this.f23086b).m1037a(1015, -1, -1);
    }

    /* renamed from: b */
    private boolean m964b() {
        String str = this.f23087c;
        return (str == null || TextUtils.isEmpty(str)) ? false : true;
    }

    /* renamed from: b */
    private boolean m963b(int i) {
        Object obj;
        int m967a = i - m967a();
        List<Map<String, Object>> list = this.f23090f;
        return list == null || m967a == list.size() || (obj = this.f23090f.get(m967a).get("available")) == null || Boolean.FALSE != ((Boolean) obj);
    }

    /* renamed from: a */
    public final int m967a() {
        return m964b() ? 1 : 0;
    }

    /* renamed from: a */
    public final void m966a(int i) {
        this.f23089e = i;
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        List<Map<String, Object>> list = this.f23090f;
        int i = 0;
        if (list == null) {
            return 0;
        }
        int size = list.size() + m967a();
        String str = this.f23088d;
        if (str != null && !TextUtils.isEmpty(str)) {
            i = 1;
        }
        return size + i;
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i) {
        List<Map<String, Object>> list;
        if (i == 0 || (list = this.f23090f) == null || i >= list.size()) {
            return null;
        }
        return this.f23090f.get(i - m967a());
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        getItem(i);
        Map<String, Object> map = this.f23090f.get(i - m967a());
        List list = (List) map.get("keys");
        List list2 = (List) map.get("values");
        LinearLayout linearLayout = new LinearLayout(this.f23086b);
        linearLayout.setOrientation(1);
        RelativeLayout relativeLayout = new RelativeLayout(this.f23086b);
        int i2 = C4150b.f22144g;
        relativeLayout.setPadding(i2, i2, i2, i2);
        linearLayout.addView(relativeLayout);
        LinearLayout linearLayout2 = new LinearLayout(this.f23086b);
        linearLayout2.setBackgroundColor(-3419943);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 1);
        ImageView imageView = new ImageView(this.f23086b);
        imageView.setVisibility(4);
        imageView.setId(imageView.hashCode());
        TextView textView = new TextView(this.f23086b);
        textView.setSingleLine(true);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setText((String) map.get(HtmlTags.STYLE));
        textView.setTextSize(C4150b.f22146i);
        textView.setTextColor(-10066330);
        int m858a = C4386g.m858a(this.f23086b, 20.0f);
        int i3 = this.f23089e == i ? 1008 : 1007;
        int m858a2 = C4386g.m858a(this.f23086b, 20.0f);
        Drawable m1037a = C4342c.m1036a(this.f23086b).m1037a(i3, m858a, m858a);
        if (m963b(i)) {
            imageView.setVisibility(0);
        }
        imageView.setBackgroundDrawable(m1037a);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(m858a2, m858a2);
        layoutParams2.addRule(15, -1);
        layoutParams2.addRule(9, -1);
        relativeLayout.addView(imageView, layoutParams2);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.addRule(15, -1);
        int hashCode = imageView.hashCode();
        boolean z = true;
        layoutParams3.addRule(1, hashCode);
        layoutParams3.leftMargin = C4150b.f22144g;
        relativeLayout.addView(textView, layoutParams3);
        LinearLayout linearLayout3 = new LinearLayout(this.f23086b);
        linearLayout3.setOrientation(1);
        int i4 = 5;
        linearLayout3.setGravity(5);
        linearLayout3.setId(linearLayout3.hashCode());
        LinearLayout linearLayout4 = new LinearLayout(this.f23086b);
        linearLayout4.setOrientation(1);
        linearLayout4.setGravity(5);
        linearLayout4.setId(linearLayout4.hashCode());
        int i5 = 0;
        while (i5 < list.size()) {
            TextView textView2 = new TextView(this.f23086b);
            textView2.setSingleLine(z);
            textView2.setEllipsize(TextUtils.TruncateAt.END);
            textView2.setText((CharSequence) list.get(i5));
            textView2.setTextSize(C4150b.f22148k);
            textView2.setTextColor(-6710887);
            LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams4.gravity = i4;
            linearLayout3.addView(textView2, layoutParams4);
            TextView textView3 = new TextView(this.f23086b);
            textView3.setSingleLine(true);
            textView3.setEllipsize(TextUtils.TruncateAt.END);
            textView3.setText((CharSequence) list2.get(i5));
            textView3.setTextSize(C4150b.f22148k);
            textView3.setTextColor(-6710887);
            linearLayout4.addView(textView3, layoutParams4);
            i5++;
            i4 = 5;
            z = true;
        }
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(C4386g.m858a(this.f23086b, 120.0f), -2);
        layoutParams5.addRule(11, -1);
        relativeLayout.addView(linearLayout4, layoutParams5);
        RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(C4386g.m858a(this.f23086b, 100.0f), -2);
        layoutParams6.addRule(0, linearLayout4.getId());
        relativeLayout.addView(linearLayout3, layoutParams6);
        layoutParams.rightMargin = i2;
        layoutParams.leftMargin = i2;
        linearLayout.addView(linearLayout2, layoutParams);
        return linearLayout;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public final boolean isEnabled(int i) {
        if (!(m964b() && i == 0) && m963b(i)) {
            return super.isEnabled(i);
        }
        return false;
    }
}
