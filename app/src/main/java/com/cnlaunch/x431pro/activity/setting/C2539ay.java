package com.cnlaunch.x431pro.activity.setting;

import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import com.ifoer.expedition.pro.R;

/* compiled from: SendDiagnosticLogActivity1.java */
/* renamed from: com.cnlaunch.x431pro.activity.setting.ay */
/* loaded from: classes.dex */
final class C2539ay implements AdapterView.OnItemSelectedListener {

    /* renamed from: a */
    final /* synthetic */ SendDiagnosticLogActivity1 f14632a;

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public final void onNothingSelected(AdapterView<?> adapterView) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2539ay(SendDiagnosticLogActivity1 sendDiagnosticLogActivity1) {
        this.f14632a = sendDiagnosticLogActivity1;
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public final void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        EditText editText;
        EditText editText2;
        EditText editText3;
        EditText editText4;
        EditText editText5;
        EditText editText6;
        EditText editText7;
        EditText editText8;
        EditText editText9;
        EditText editText10;
        switch (i) {
            case 0:
                editText = this.f14632a.f14483Q;
                if (editText.getHint() != null) {
                    String string = this.f14632a.getString(R.string.print_phonenumber_txt);
                    editText4 = this.f14632a.f14483Q;
                    if (!string.equals(editText4.getHint().toString())) {
                        editText5 = this.f14632a.f14483Q;
                        editText5.setText("");
                    }
                }
                editText2 = this.f14632a.f14483Q;
                editText2.setHint(R.string.print_phonenumber_txt);
                editText3 = this.f14632a.f14483Q;
                editText3.setInputType(3);
                return;
            case 1:
                editText6 = this.f14632a.f14483Q;
                if (editText6.getHint() != null) {
                    String string2 = this.f14632a.getString(R.string.register_hint_email);
                    editText9 = this.f14632a.f14483Q;
                    if (!string2.equals(editText9.getHint().toString())) {
                        editText10 = this.f14632a.f14483Q;
                        editText10.setText("");
                    }
                }
                editText7 = this.f14632a.f14483Q;
                editText7.setHint(R.string.register_hint_email);
                editText8 = this.f14632a.f14483Q;
                editText8.setInputType(32);
                return;
            default:
                return;
        }
    }
}
