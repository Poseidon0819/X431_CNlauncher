package com.cnlaunch.x431pro.widget.p290a;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import com.cnlaunch.p120d.p130d.NToast;
import com.cnlaunch.x431pro.activity.diagnose.p221d.GraphGridFragment;
import com.ifoer.expedition.pro.R;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SetMaxMinValue.java */
/* renamed from: com.cnlaunch.x431pro.widget.a.cr */
/* loaded from: classes.dex */
public final class C2858cr implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ SetMaxMinValue f16379a;

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2858cr(SetMaxMinValue setMaxMinValue) {
        this.f16379a = setMaxMinValue;
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
        Button button;
        EditText editText;
        boolean z;
        double d;
        double d2;
        Button button2;
        Context context;
        GraphGridFragment graphGridFragment;
        Button button3;
        try {
            SetMaxMinValue setMaxMinValue = this.f16379a;
            editText = this.f16379a.f16373m;
            setMaxMinValue.f16368h = Double.parseDouble(editText.getText().toString());
            this.f16379a.f16370j = true;
            z = this.f16379a.f16369i;
            if (z) {
                d = this.f16379a.f16367g;
                d2 = this.f16379a.f16368h;
                if (d < d2) {
                    context = this.f16379a.f16371k;
                    graphGridFragment = this.f16379a.f16364a;
                    NToast.m9449a(context, graphGridFragment.getResources().getString(R.string.settingMax_need_above_min_));
                    button3 = this.f16379a.f16366c;
                    button3.setEnabled(false);
                    return;
                }
                button2 = this.f16379a.f16366c;
                button2.setEnabled(true);
            }
        } catch (NumberFormatException unused) {
            this.f16379a.f16370j = false;
            button = this.f16379a.f16366c;
            button.setEnabled(false);
        }
    }
}
