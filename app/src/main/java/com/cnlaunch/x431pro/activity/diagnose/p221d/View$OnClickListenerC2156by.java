package com.cnlaunch.x431pro.activity.diagnose.p221d;

import android.view.View;
import android.widget.ProgressBar;
import com.cnlaunch.x431pro.activity.diagnose.p218a.SpeciaFunctionListViewAdapter;
import com.cnlaunch.x431pro.module.p252d.p254b.SerializableMap;
import com.cnlaunch.x431pro.widget.button.IconRadioButton;
import com.cnlaunch.x431pro.widget.p290a.WaitDialog;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SpeciaFunctionFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.diagnose.d.by */
/* loaded from: classes.dex */
public final class View$OnClickListenerC2156by implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ SpeciaFunctionFragment f12230a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC2156by(SpeciaFunctionFragment speciaFunctionFragment) {
        this.f12230a = speciaFunctionFragment;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        IconRadioButton iconRadioButton;
        SerializableMap serializableMap;
        SpeciaFunctionListViewAdapter speciaFunctionListViewAdapter;
        SerializableMap serializableMap2;
        SpeciaFunctionListViewAdapter speciaFunctionListViewAdapter2;
        IconRadioButton iconRadioButton2;
        ProgressBar progressBar;
        WaitDialog waitDialog;
        IconRadioButton iconRadioButton3;
        SpeciaFunctionListViewAdapter speciaFunctionListViewAdapter3;
        SpeciaFunctionListViewAdapter speciaFunctionListViewAdapter4;
        IconRadioButton iconRadioButton4;
        iconRadioButton = this.f12230a.f12217u;
        if (!iconRadioButton.isChecked()) {
            speciaFunctionListViewAdapter3 = this.f12230a.f12210n;
            speciaFunctionListViewAdapter3.f11429c = null;
            speciaFunctionListViewAdapter4 = this.f12230a.f12210n;
            speciaFunctionListViewAdapter4.notifyDataSetChanged();
            iconRadioButton4 = this.f12230a.f12217u;
            iconRadioButton4.setEnabled(true);
            return;
        }
        serializableMap = this.f12230a.f12187A;
        if (serializableMap == null) {
            this.f12230a.f12201O = false;
            progressBar = this.f12230a.f12221y;
            progressBar.setProgress(0);
            waitDialog = this.f12230a.f12220x;
            waitDialog.show();
            this.f12230a.request(10086);
            iconRadioButton3 = this.f12230a.f12217u;
            iconRadioButton3.setEnabled(false);
            return;
        }
        speciaFunctionListViewAdapter = this.f12230a.f12210n;
        serializableMap2 = this.f12230a.f12187A;
        speciaFunctionListViewAdapter.f11429c = serializableMap2;
        speciaFunctionListViewAdapter2 = this.f12230a.f12210n;
        speciaFunctionListViewAdapter2.notifyDataSetChanged();
        iconRadioButton2 = this.f12230a.f12217u;
        iconRadioButton2.setEnabled(true);
    }
}
