package com.cnlaunch.x431pro.activity.login;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import com.cnlaunch.p120d.p130d.NToast;
import com.cnlaunch.x431pro.module.p272k.p274b.UserBaseInfo;
import com.ifoer.expedition.pro.R;
import java.util.ArrayList;

/* compiled from: FindPasswordActivity.java */
/* renamed from: com.cnlaunch.x431pro.activity.login.s */
/* loaded from: classes.dex */
final class C2376s implements AdapterView.OnItemSelectedListener {

    /* renamed from: a */
    final /* synthetic */ FindPasswordActivity f13532a;

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public final void onNothingSelected(AdapterView<?> adapterView) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2376s(FindPasswordActivity findPasswordActivity) {
        this.f13532a = findPasswordActivity;
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public final void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        ArrayAdapter arrayAdapter;
        ArrayList arrayList;
        Button button;
        UserBaseInfo userBaseInfo;
        int i2;
        EditText editText;
        EditText editText2;
        int i3;
        boolean z;
        Context context;
        EditText editText3;
        UserBaseInfo userBaseInfo2;
        boolean z2;
        Context context2;
        EditText editText4;
        EditText editText5;
        UserBaseInfo userBaseInfo3;
        Button button2;
        arrayAdapter = this.f13532a.f13081al;
        Object item = arrayAdapter.getItem(i);
        arrayList = this.f13532a.f13080ak;
        if (item == arrayList.get(0)) {
            this.f13532a.f13078ai = 0;
            button2 = this.f13532a.f13071ab;
            button2.setText(R.string.retrieve_password_get_code_phone);
        } else {
            this.f13532a.f13078ai = 1;
            button = this.f13532a.f13071ab;
            button.setText(R.string.retrieve_password_get_code_email);
        }
        userBaseInfo = this.f13532a.f13079aj;
        if (userBaseInfo != null) {
            i3 = this.f13532a.f13078ai;
            if (i3 == 0) {
                z2 = this.f13532a.f13083an;
                if (z2) {
                    editText5 = this.f13532a.f13067X;
                    userBaseInfo3 = this.f13532a.f13079aj;
                    editText5.setText(userBaseInfo3.getMobile());
                    return;
                }
                context2 = this.f13532a.f10981q;
                NToast.m9450a(context2, (int) R.string.retrieve_password_phone_null);
                editText4 = this.f13532a.f13067X;
                editText4.setText(R.string.retrieve_password_phone);
                return;
            }
            z = this.f13532a.f13082am;
            if (z) {
                editText3 = this.f13532a.f13067X;
                userBaseInfo2 = this.f13532a.f13079aj;
                editText3.setText(userBaseInfo2.getEmail());
                return;
            }
            context = this.f13532a.f10981q;
            NToast.m9450a(context, (int) R.string.retrieve_password_email_null);
        } else {
            i2 = this.f13532a.f13078ai;
            if (i2 == 0) {
                editText = this.f13532a.f13067X;
                editText.setText(R.string.retrieve_password_phone);
                return;
            }
        }
        editText2 = this.f13532a.f13067X;
        editText2.setText(R.string.retrieve_password_email);
    }
}
