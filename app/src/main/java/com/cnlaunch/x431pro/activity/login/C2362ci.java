package com.cnlaunch.x431pro.activity.login;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import com.cnlaunch.p120d.p130d.NToast;
import com.cnlaunch.x431pro.module.p272k.p274b.ZipcodeInfoResponse;
import com.cnlaunch.x431pro.utils.C2787z;
import com.ifoer.expedition.pro.R;
import org.codehaus.jackson.util.MinimalPrettyPrinter;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ZipcodeInputDialog.java */
/* renamed from: com.cnlaunch.x431pro.activity.login.ci */
/* loaded from: classes.dex */
public final class C2362ci implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ ZipcodeInputDialog f13480a;

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2362ci(ZipcodeInputDialog zipcodeInputDialog) {
        this.f13480a = zipcodeInputDialog;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
        ZipcodeInfoResponse zipcodeInfoResponse;
        EditText editText;
        EditText editText2;
        Button button;
        Button button2;
        Button button3;
        Button button4;
        Button button5;
        Button button6;
        Button button7;
        Button button8;
        Button button9;
        Button button10;
        Button button11;
        Button button12;
        Button button13;
        EditText editText3;
        zipcodeInfoResponse = this.f13480a.f13479i;
        String country = zipcodeInfoResponse.getData().getCountry();
        editText = this.f13480a.f13476c;
        String obj = editText.getText().toString();
        if (obj.length() >= 6 && !C2787z.m4807l(obj)) {
            String str = obj.substring(0, 3) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + obj.substring(3);
            if (C2787z.m4807l(str)) {
                editText3 = this.f13480a.f13476c;
                editText3.setText(str);
            }
        }
        editText2 = this.f13480a.f13476c;
        String obj2 = editText2.getText().toString();
        if (obj2.length() == 0) {
            NToast.m9444c(this.f13480a.f13475b, (int) R.string.register_input_zipcode);
            button13 = this.f13480a.f13478h;
            button13.setEnabled(false);
        } else if (!TextUtils.isEmpty(country)) {
            if (country.equalsIgnoreCase("137")) {
                if (obj2.length() < 6) {
                    button12 = this.f13480a.f13478h;
                    button12.setEnabled(false);
                } else if (C2787z.m4807l(obj2)) {
                    button11 = this.f13480a.f13478h;
                    button11.setEnabled(true);
                } else {
                    button10 = this.f13480a.f13478h;
                    button10.setEnabled(false);
                    NToast.m9444c(this.f13480a.f13475b, (int) R.string.register_fail_prompt_300011);
                }
            } else if (country.equalsIgnoreCase("235") || country.equalsIgnoreCase("325")) {
                if (obj2.length() < 5) {
                    button6 = this.f13480a.f13478h;
                    button6.setEnabled(false);
                } else if (C2787z.m4808k(obj2)) {
                    button5 = this.f13480a.f13478h;
                    button5.setEnabled(true);
                } else {
                    button4 = this.f13480a.f13478h;
                    button4.setEnabled(false);
                    NToast.m9444c(this.f13480a.f13475b, (int) R.string.register_fail_prompt_300011);
                }
            } else if (obj2.length() < 5) {
                button9 = this.f13480a.f13478h;
                button9.setEnabled(false);
            } else if (C2787z.m4808k(obj2) || C2787z.m4807l(obj2)) {
                button7 = this.f13480a.f13478h;
                button7.setEnabled(true);
            } else {
                button8 = this.f13480a.f13478h;
                button8.setEnabled(false);
                NToast.m9444c(this.f13480a.f13475b, (int) R.string.register_fail_prompt_300011);
            }
        } else if (obj2.length() < 5) {
            button3 = this.f13480a.f13478h;
            button3.setEnabled(false);
        } else if (C2787z.m4808k(obj2) || C2787z.m4807l(obj2)) {
            button = this.f13480a.f13478h;
            button.setEnabled(true);
        } else {
            button2 = this.f13480a.f13478h;
            button2.setEnabled(false);
            NToast.m9444c(this.f13480a.f13475b, (int) R.string.register_fail_prompt_300011);
        }
    }
}
