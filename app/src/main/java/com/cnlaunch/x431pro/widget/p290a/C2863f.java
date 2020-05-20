package com.cnlaunch.x431pro.widget.p290a;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CustomInputDialog.java */
/* renamed from: com.cnlaunch.x431pro.widget.a.f */
/* loaded from: classes.dex */
public final class C2863f implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ CustomInputDialog f16407a;

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2863f(CustomInputDialog customInputDialog) {
        this.f16407a = customInputDialog;
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        EditText editText;
        int i4;
        int i5;
        EditText editText2;
        EditText editText3;
        EditText editText4;
        editText = this.f16407a.f16398a;
        String obj = editText.getText().toString();
        i4 = this.f16407a.f16402h;
        if (i4 != 1) {
            i5 = this.f16407a.f16402h;
            if (i5 == 2) {
                obj = obj.toLowerCase();
            }
        } else {
            obj = obj.toUpperCase();
        }
        editText2 = this.f16407a.f16398a;
        if (obj.equals(editText2.getText().toString())) {
            return;
        }
        editText3 = this.f16407a.f16398a;
        editText3.setText(obj);
        editText4 = this.f16407a.f16398a;
        editText4.setSelection(obj.length());
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
        EditText editText;
        int i;
        int i2;
        EditText editText2;
        int i3;
        int i4;
        int i5;
        String str;
        int i6;
        int i7;
        int i8;
        int i9;
        Button button;
        Button button2;
        editText = this.f16407a.f16398a;
        String obj = editText.getText().toString();
        i = this.f16407a.f16401g;
        if (i != 0) {
            i9 = this.f16407a.f16401g;
            if (i9 == obj.length()) {
                button2 = this.f16407a.f16405k;
                button2.setEnabled(true);
            } else {
                button = this.f16407a.f16405k;
                button.setEnabled(false);
            }
        }
        i2 = this.f16407a.f16403i;
        if (i2 > 0) {
            int length = obj.length();
            i3 = this.f16407a.f16403i;
            if (length > i3) {
                StringBuilder sb = new StringBuilder();
                i4 = this.f16407a.f16403i;
                sb.append(obj.substring(0, i4));
                int length2 = obj.length();
                i5 = this.f16407a.f16403i;
                while (i5 < length2) {
                    str = this.f16407a.f16404j;
                    sb.append(str);
                    i6 = this.f16407a.f16403i;
                    if (i6 + i5 < length2 + 1) {
                        i8 = this.f16407a.f16403i;
                        sb.append(obj.substring(i5, i8 + i5));
                    } else {
                        sb.append(obj.substring(i5, length2));
                    }
                    i7 = this.f16407a.f16403i;
                    i5 += i7;
                }
                obj = sb.toString();
            }
        }
        editText2 = this.f16407a.f16400c;
        editText2.setText(obj);
    }
}
