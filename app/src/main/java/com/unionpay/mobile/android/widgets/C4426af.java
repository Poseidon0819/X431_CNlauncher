package com.unionpay.mobile.android.widgets;

import android.content.Context;
import android.text.InputFilter;
import android.text.TextWatcher;
import com.itextpdf.text.pdf.PdfBoolean;
import com.unionpay.mobile.android.utils.C4389j;
import java.util.ArrayList;
import org.codehaus.jackson.util.MinimalPrettyPrinter;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.unionpay.mobile.android.widgets.af */
/* loaded from: classes2.dex */
public final class C4426af extends AbstractC4420aa {

    /* renamed from: c */
    private TextWatcher f23331c;

    /* renamed from: o */
    private ArrayList<C4427a> f23332o;

    /* renamed from: com.unionpay.mobile.android.widgets.af$a */
    /* loaded from: classes2.dex */
    class C4427a {

        /* renamed from: b */
        private String f23334b;

        /* renamed from: c */
        private String f23335c;

        /* renamed from: d */
        private String f23336d;

        public C4427a(JSONObject jSONObject) {
            this.f23334b = null;
            this.f23335c = null;
            this.f23336d = null;
            this.f23334b = C4389j.m846a(jSONObject, "pattern");
            this.f23335c = C4389j.m846a(jSONObject, "prefix");
            this.f23336d = C4389j.m846a(jSONObject, "isCheck");
        }

        /* renamed from: a */
        public final String m715a() {
            return this.f23334b;
        }

        /* renamed from: b */
        public final String m714b() {
            return this.f23335c;
        }

        /* renamed from: c */
        public final boolean m713c() {
            String str = this.f23336d;
            return str == null || !PdfBoolean.FALSE.equalsIgnoreCase(str);
        }
    }

    public C4426af(Context context, int i, JSONObject jSONObject, String str) {
        super(context, i, jSONObject, str, (byte) 0);
        this.f23331c = new C4428ag(this);
        this.f23332o = null;
        this.f23323b.m607a(this.f23331c);
        this.f23323b.m608a(new InputFilter.LengthFilter(23));
        this.f23323b.m610a(2);
        if (this.f23402i) {
            this.f23323b.setEnabled(false);
        }
        JSONArray m842d = C4389j.m842d(jSONObject, "regex");
        if (m842d != null) {
            if (this.f23332o == null) {
                this.f23332o = new ArrayList<>();
            }
            for (int i2 = 0; i2 < m842d.length(); i2++) {
                JSONObject jSONObject2 = (JSONObject) C4389j.m845b(m842d, i2);
                if (jSONObject2 != null) {
                    this.f23332o.add(new C4427a(jSONObject2));
                }
            }
        }
    }

    /* renamed from: b */
    private static boolean m716b(String str) {
        int length = str.length();
        int i = length - 2;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            if (i < 0) {
                break;
            }
            int charAt = str.charAt(i) - '0';
            if (i3 % 2 == 0) {
                int i4 = charAt * 2;
                charAt = (i4 % 10) + (i4 / 10);
            }
            i2 += charAt;
            i--;
            i3++;
        }
        int i5 = i2 % 10;
        return (i5 != 0 ? (char) ((10 - i5) + 48) : '0') == str.charAt(length - 1);
    }

    @Override // com.unionpay.mobile.android.widgets.AbstractC4420aa, com.unionpay.mobile.android.widgets.AbstractC4453ba.InterfaceC4454a
    /* renamed from: a */
    public final String mo585a() {
        return (this.f23402i ? mo579i() : this.f23323b.m600b()).replace(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR, "");
    }

    @Override // com.unionpay.mobile.android.widgets.AbstractC4453ba.InterfaceC4454a
    /* renamed from: b */
    public final boolean mo584b() {
        if (this.f23402i) {
            return true;
        }
        String mo585a = mo585a();
        ArrayList<C4427a> arrayList = this.f23332o;
        if (arrayList != null && arrayList.size() > 0) {
            boolean z = false;
            for (int i = 0; i < this.f23332o.size(); i++) {
                C4427a c4427a = this.f23332o.get(i);
                if (c4427a.m715a() != null) {
                    z = mo585a.matches(c4427a.m715a());
                }
                if (z) {
                    if (!c4427a.m713c()) {
                        return 13 <= mo585a.length() && 19 >= mo585a.length();
                    }
                    return m716b(c4427a.m714b() + mo585a);
                }
            }
        }
        return 13 <= mo585a.length() && 19 >= mo585a.length() && m716b(mo585a);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.unionpay.mobile.android.widgets.AbstractC4453ba
    /* renamed from: d */
    public final String mo613d() {
        return "_input_cardNO";
    }
}
