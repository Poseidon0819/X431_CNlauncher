package com.cnlaunch.x431pro.activity.mine;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import com.cnlaunch.x431pro.utils.C2787z;

/* compiled from: ConnectorActivateFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.mine.v */
/* loaded from: classes.dex */
final class C2496v implements TextWatcher {

    /* renamed from: a */
    final /* synthetic */ ConnectorActivateFragment f14315a;

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2496v(ConnectorActivateFragment connectorActivateFragment) {
        this.f14315a = connectorActivateFragment;
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        Button button;
        button = this.f14315a.f14308v;
        button.setEnabled(this.f14315a.m6107a());
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
        EditText editText;
        String str;
        CheckBox checkBox;
        Button button;
        String str2;
        CheckBox checkBox2;
        CheckBox checkBox3;
        ConnectorActivateFragment connectorActivateFragment = this.f14315a;
        editText = connectorActivateFragment.f14307u;
        connectorActivateFragment.f14283A = editText.getText().toString();
        str = this.f14315a.f14283A;
        if (str.length() == 8) {
            str2 = this.f14315a.f14283A;
            if (C2787z.m4818b(str2)) {
                checkBox3 = this.f14315a.f14311y;
                ConnectorActivateFragment.m6105a(checkBox3, 0, true);
            } else {
                checkBox2 = this.f14315a.f14311y;
                ConnectorActivateFragment.m6105a(checkBox2, 0, false);
            }
        } else {
            checkBox = this.f14315a.f14311y;
            ConnectorActivateFragment.m6105a(checkBox, 4, true);
        }
        button = this.f14315a.f14308v;
        button.setEnabled(this.f14315a.m6107a());
    }
}
