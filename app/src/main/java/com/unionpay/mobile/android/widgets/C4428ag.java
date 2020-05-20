package com.unionpay.mobile.android.widgets;

import android.text.Editable;
import android.text.TextWatcher;
import org.apache.http.conn.ssl.TokenParser;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.unionpay.mobile.android.widgets.ag */
/* loaded from: classes2.dex */
public final class C4428ag implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ C4426af f23337a;

    /* renamed from: c */
    private int f23339c;

    /* renamed from: b */
    private boolean f23338b = true;

    /* renamed from: d */
    private boolean f23340d = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C4428ag(C4426af c4426af) {
        this.f23337a = c4426af;
    }

    /* renamed from: a */
    private String m712a(CharSequence charSequence, int i) {
        int length = charSequence.length();
        StringBuffer stringBuffer = new StringBuffer();
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            char charAt = charSequence.charAt(i3);
            if (charAt != ' ') {
                i2++;
                if (i3 != 0 && (i2 & 3) == 1) {
                    stringBuffer.append(TokenParser.f24154SP);
                }
            }
            if (i3 == i) {
                this.f23339c = stringBuffer.length();
            }
            if (charAt != ' ') {
                stringBuffer.append(charAt);
            }
        }
        if (i == length) {
            this.f23339c = stringBuffer.length();
        }
        return stringBuffer.toString();
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (i2 == 1 && i3 == 0 && charSequence.charAt(i) == ' ') {
            this.f23340d = true;
        }
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (this.f23338b) {
            if (this.f23340d) {
                CharSequence subSequence = charSequence.subSequence(0, i - 1);
                if (i < charSequence.length()) {
                    charSequence = subSequence.toString() + ((Object) charSequence.subSequence(i, charSequence.length()));
                } else {
                    charSequence = subSequence;
                }
                i--;
                this.f23340d = false;
            }
            this.f23338b = false;
            this.f23337a.f23323b.m594c(m712a(charSequence, i + i3));
            View$OnClickListenerC4479u view$OnClickListenerC4479u = this.f23337a.f23323b;
            int i4 = this.f23339c;
            if (i4 > 23) {
                i4 = 23;
            }
            view$OnClickListenerC4479u.m599b(i4);
            this.f23338b = true;
        }
    }
}
