package com.unionpay.mobile.android.upwidget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Html;
import android.text.Spanned;
import android.text.TextUtils;
import android.view.View;
import android.widget.BaseAdapter;
import com.unionpay.mobile.android.resource.C4342c;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.codehaus.jackson.util.MinimalPrettyPrinter;

/* renamed from: com.unionpay.mobile.android.upwidget.c */
/* loaded from: classes2.dex */
public final class C4356c extends BaseAdapter {

    /* renamed from: a */
    private Drawable f23071a;

    /* renamed from: b */
    private Drawable f23072b;

    /* renamed from: c */
    private Drawable f23073c;

    /* renamed from: d */
    private Context f23074d;

    /* renamed from: e */
    private String f23075e;

    /* renamed from: f */
    private String f23076f;

    /* renamed from: g */
    private String f23077g;

    /* renamed from: i */
    private int f23079i;

    /* renamed from: j */
    private int f23080j;

    /* renamed from: k */
    private List<Map<String, Object>> f23081k;

    /* renamed from: h */
    private boolean f23078h = false;

    /* renamed from: l */
    private ArrayList<View.OnClickListener> f23082l = new ArrayList<>();

    /* renamed from: m */
    private View.OnClickListener f23083m = new View$OnClickListenerC4357d(this);

    public C4356c(Context context, List<Map<String, Object>> list, String str, String str2, String str3, int i, int i2) {
        this.f23075e = null;
        this.f23076f = null;
        this.f23077g = null;
        this.f23079i = 1;
        this.f23080j = 0;
        this.f23074d = context;
        this.f23081k = list;
        this.f23075e = str;
        this.f23076f = str2;
        this.f23077g = str3;
        this.f23079i = i;
        this.f23080j = i2;
        this.f23071a = C4342c.m1036a(this.f23074d).m1037a(1015, -1, -1);
        this.f23072b = C4342c.m1036a(this.f23074d).m1037a(1016, -1, -1);
        this.f23073c = C4342c.m1036a(this.f23074d).m1037a(1002, -1, -1);
    }

    /* renamed from: d */
    private boolean m970d() {
        String str = this.f23075e;
        return (str == null || TextUtils.isEmpty(str)) ? false : true;
    }

    /* renamed from: d */
    private boolean m969d(int i) {
        Object obj;
        int m972c = i - m972c();
        return m972c == this.f23081k.size() || (obj = this.f23081k.get(m972c).get("available")) == null || Boolean.FALSE != ((Boolean) obj);
    }

    /* renamed from: e */
    private boolean m968e() {
        String str = this.f23076f;
        return (str == null || TextUtils.isEmpty(str)) ? false : true;
    }

    /* renamed from: a */
    public final void m980a() {
        this.f23078h = !this.f23078h;
    }

    /* renamed from: a */
    public final void m979a(int i) {
        this.f23079i = i;
    }

    /* renamed from: a */
    public final void m978a(View.OnClickListener onClickListener) {
        this.f23082l.add(onClickListener);
    }

    /* renamed from: a */
    public final void m976a(String str) {
        this.f23075e = str;
    }

    /* renamed from: b */
    public final Spanned m974b(int i) {
        int m972c = i - m972c();
        if (m972c == this.f23081k.size()) {
            return null;
        }
        Map<String, Object> map = this.f23081k.get(m972c);
        return Html.fromHtml(((String) map.get("text1")) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + ((String) map.get("text2")));
    }

    /* renamed from: b */
    public final void m973b(String str) {
        this.f23077g = str;
    }

    /* renamed from: b */
    public final boolean m975b() {
        return this.f23078h;
    }

    /* renamed from: c */
    public final int m972c() {
        return m970d() ? 1 : 0;
    }

    /* renamed from: c */
    public final boolean m971c(int i) {
        Object obj;
        int m972c = i - m972c();
        return m972c == this.f23081k.size() || (obj = this.f23081k.get(m972c).get("editable")) == null || Boolean.FALSE != ((Boolean) obj);
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        List<Map<String, Object>> list = this.f23081k;
        if (list == null) {
            return 0;
        }
        return list.size() + m972c() + (m968e() ? 1 : 0);
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i) {
        List<Map<String, Object>> list;
        if (i == 0 || (list = this.f23081k) == null || i >= list.size()) {
            return null;
        }
        return this.f23081k.get(i - m972c());
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        return i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x0167, code lost:
        if (r3 != null) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x01ef, code lost:
        if (r9 != false) goto L14;
     */
    @Override // android.widget.Adapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.view.View getView(int r17, android.view.View r18, android.view.ViewGroup r19) {
        /*
            Method dump skipped, instructions count: 501
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unionpay.mobile.android.upwidget.C4356c.getView(int, android.view.View, android.view.ViewGroup):android.view.View");
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public final boolean isEnabled(int i) {
        if (!(m970d() && i == 0) && m969d(i)) {
            return super.isEnabled(i);
        }
        return false;
    }
}
