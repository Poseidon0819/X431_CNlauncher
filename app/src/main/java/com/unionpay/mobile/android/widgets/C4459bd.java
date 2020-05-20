package com.unionpay.mobile.android.widgets;

import android.content.Context;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Selection;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.DigitsKeyListener;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;
import com.baidu.mapapi.UIMsg;
import com.unionpay.mobile.android.languages.C4171c;
import com.unionpay.mobile.android.utils.C4389j;
import com.unionpay.mobile.android.widgets.View$OnClickListenerC4479u;
import java.math.BigDecimal;
import org.json.JSONObject;

/* renamed from: com.unionpay.mobile.android.widgets.bd */
/* loaded from: classes2.dex */
public class C4459bd extends AbstractC4420aa implements View$OnClickListenerC4479u.InterfaceC4480a {

    /* renamed from: c */
    private static final String f23426c = "bd";

    /* renamed from: o */
    private String f23427o;

    /* renamed from: p */
    private String f23428p;

    /* renamed from: q */
    private String f23429q;

    /* renamed from: r */
    private String f23430r;

    /* renamed from: s */
    private String f23431s;

    /* renamed from: com.unionpay.mobile.android.widgets.bd$a */
    /* loaded from: classes2.dex */
    public class C4460a implements InputFilter {

        /* renamed from: b */
        private View$OnClickListenerC4479u f23433b;

        /* renamed from: c */
        private BigDecimal f23434c;

        /* renamed from: d */
        private BigDecimal f23435d;

        public C4460a(View$OnClickListenerC4479u view$OnClickListenerC4479u, BigDecimal bigDecimal, BigDecimal bigDecimal2) {
            this.f23433b = null;
            this.f23434c = null;
            this.f23435d = null;
            this.f23433b = view$OnClickListenerC4479u;
            this.f23434c = bigDecimal;
            this.f23435d = bigDecimal2;
            if (this.f23434c.compareTo(BigDecimal.ZERO) == 1) {
                m651c(this.f23434c.toString());
            }
        }

        /* renamed from: a */
        private static int m654a(String str) {
            if (str == null || !m652b(str)) {
                return 0;
            }
            return (str.length() - str.indexOf(".")) - 1;
        }

        /* renamed from: a */
        private CharSequence m653a(String str, boolean z, boolean z2) {
            String bigDecimal = this.f23435d.toString();
            String bigDecimal2 = this.f23434c.toString();
            try {
                BigDecimal bigDecimal3 = new BigDecimal(str);
                bigDecimal3.setScale(2, 6);
                if (z && z2 && bigDecimal3.compareTo(this.f23434c) == -1) {
                    m651c(bigDecimal2);
                }
                if (bigDecimal3.compareTo(this.f23435d) == 1) {
                    m651c(bigDecimal);
                    return null;
                }
                return null;
            } catch (Exception unused) {
                return "";
            }
        }

        /* renamed from: b */
        private static boolean m652b(String str) {
            return str != null && str.contains(".");
        }

        /* renamed from: c */
        private void m651c(String str) {
            this.f23433b.m594c(str);
            Selection.setSelection(this.f23433b.m596c(), this.f23433b.m600b().length());
        }

        @Override // android.text.InputFilter
        public final CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
            if (charSequence != null && charSequence.equals("")) {
                return m653a(spanned.subSequence(0, i3).toString() + charSequence.subSequence(i, i2).toString() + ((Object) spanned.subSequence(i4, spanned.length())), true, i4 - i3 != 1);
            }
            int i5 = i2 - i;
            boolean m652b = m652b(spanned.toString());
            if (1 != i5) {
                boolean m652b2 = m652b(charSequence.toString());
                if (m652b2 && m652b) {
                    return "";
                }
                if (m652b2 && (m654a(charSequence.toString()) > 2 || spanned.toString().length() != i4)) {
                    return "";
                }
            } else if (!m652b && spanned.length() == 1 && spanned.charAt(0) == '0') {
                return ".";
            } else {
                if ('0' == charSequence.charAt(0) && i3 == 0 && i4 == 0 && spanned.length() != 0) {
                    return "";
                }
                if ('.' == charSequence.charAt(0)) {
                    if (spanned.length() == 0) {
                        return "";
                    }
                    if (spanned.length() != 0 && spanned.length() - i3 > 2) {
                        return "";
                    }
                }
                if (m652b && i3 > spanned.toString().indexOf(".") && m654a(spanned.toString()) > 2 - i5) {
                    return "";
                }
            }
            String str = spanned.subSequence(0, i3).toString() + charSequence.subSequence(i, i2).toString() + ((Object) spanned.subSequence(i4, spanned.length()));
            return m653a(str, false, m654a(str) == 2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v13, types: [int] */
    /* JADX WARN: Type inference failed for: r5v15, types: [java.math.BigDecimal] */
    /* JADX WARN: Type inference failed for: r5v17 */
    /* JADX WARN: Type inference failed for: r5v18 */
    public C4459bd(Context context, int i, JSONObject jSONObject, String str) {
        super(context, i, jSONObject, str);
        BigDecimal bigDecimal;
        BigDecimal bigDecimal2;
        this.f23427o = null;
        this.f23428p = null;
        this.f23429q = null;
        this.f23430r = null;
        this.f23431s = null;
        this.f23430r = C4389j.m846a(jSONObject, "point");
        this.f23429q = C4389j.m846a(jSONObject, "max_use_point");
        this.f23428p = C4389j.m846a(jSONObject, "min_use_point");
        this.f23431s = C4389j.m846a(jSONObject, "ratio");
        this.f23427o = C4389j.m846a(jSONObject, "ordr_amnt");
        this.f23323b.m610a(UIMsg.k_event.V_WM_GETLASTCLRSATETIME);
        this.f23323b.m608a(DigitsKeyListener.getInstance("0123456789."));
        int i2 = 6;
        i2 = 6;
        i2 = 6;
        try {
            try {
                bigDecimal = new BigDecimal(this.f23428p);
            } catch (Exception unused) {
                bigDecimal = BigDecimal.ZERO;
            }
            try {
                BigDecimal scale = bigDecimal.setScale(2, 6);
                try {
                    bigDecimal2 = new BigDecimal(this.f23429q);
                } catch (Exception unused2) {
                    bigDecimal2 = new BigDecimal(3.4028234663852886E38d);
                }
                i2 = bigDecimal2.setScale(2, 6);
                this.f23323b.m608a(new C4460a(this.f23323b, scale, i2));
                m655a((String) null, (String) null);
                if (m671q() == null || m671q().length() == 0) {
                    m667u();
                    m676c(String.format(C4171c.f22227bD.f22305ay, this.f23430r, this.f23431s));
                }
                this.f23323b.m604a(this);
            } finally {
            }
        } finally {
        }
    }

    /* renamed from: a */
    private void m655a(String str, String str2) {
        SpannableString spannableString;
        if (m672p() == null || m672p().length() == 0) {
            m668t();
            if (str == null) {
                String format = String.format(C4171c.f22227bD.f22303aw, this.f23429q);
                spannableString = new SpannableString(format);
                spannableString.setSpan(new ForegroundColorSpan(-15958150), 0, format.length(), 0);
            } else {
                String format2 = String.format(C4171c.f22227bD.f22303aw + str, this.f23429q, str2);
                SpannableString spannableString2 = new SpannableString(format2);
                ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(-15958150);
                int length = format2.length();
                spannableString2.setSpan(foregroundColorSpan, 0, length - (str2 + "元").length(), 0);
                ForegroundColorSpan foregroundColorSpan2 = new ForegroundColorSpan(-44462);
                int length2 = format2.length();
                spannableString2.setSpan(foregroundColorSpan2, length2 - (str2 + "元").length(), format2.length(), 0);
                spannableString = spannableString2;
            }
            m666v();
            m677a(spannableString, TextView.BufferType.SPANNABLE);
        }
    }

    @Override // com.unionpay.mobile.android.widgets.AbstractC4420aa, com.unionpay.mobile.android.widgets.AbstractC4453ba.InterfaceC4454a
    /* renamed from: a */
    public final String mo585a() {
        String mo585a = super.mo585a();
        if (mo585a != null && mo585a.length() != 0) {
            try {
                BigDecimal bigDecimal = new BigDecimal(mo585a);
                bigDecimal.setScale(2, 6);
                if (bigDecimal.compareTo(BigDecimal.ZERO) == 1) {
                    return bigDecimal.toString();
                }
            } catch (Exception unused) {
            }
        }
        return null;
    }

    @Override // com.unionpay.mobile.android.widgets.AbstractC4420aa
    /* renamed from: a */
    public final void mo656a(Editable editable) {
        super.mo656a(editable);
        if (m672p() == null || m672p().length() == 0) {
            try {
                m655a(C4171c.f22227bD.f22304ax, new BigDecimal(this.f23427o).setScale(2, 6).subtract(new BigDecimal(mo585a()).setScale(2, 6).multiply(new BigDecimal(this.f23431s).setScale(2, 6)).setScale(2, 6)).toString());
            } catch (Exception unused) {
                m655a((String) null, (String) null);
            }
        }
    }

    @Override // com.unionpay.mobile.android.widgets.View$OnClickListenerC4479u.InterfaceC4480a
    /* renamed from: a */
    public final void mo588a(boolean z) {
        if (z) {
            m724a(this.f23405l);
        }
    }

    @Override // com.unionpay.mobile.android.widgets.AbstractC4453ba.InterfaceC4454a
    /* renamed from: b */
    public final boolean mo584b() {
        return true;
    }

    @Override // com.unionpay.mobile.android.widgets.AbstractC4420aa, com.unionpay.mobile.android.widgets.AbstractC4453ba.InterfaceC4454a
    /* renamed from: c */
    public final boolean mo583c() {
        return true;
    }

    @Override // com.unionpay.mobile.android.widgets.AbstractC4486z
    /* renamed from: h */
    public final String mo580h() {
        String mo585a = mo585a();
        if (mo585a == null || mo585a.length() == 0) {
            return null;
        }
        return super.mo580h();
    }
}
