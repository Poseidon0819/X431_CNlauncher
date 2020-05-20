package com.cnlaunch.x431pro.activity.upgrade;

import android.content.Context;
import android.view.View;
import android.widget.CheckBox;
import com.cnlaunch.x431pro.module.p269j.p271b.X431PadDtoSoft;
import com.cnlaunch.x431pro.widget.p290a.LoadDialog;
import com.ifoer.expedition.pro.R;
import java.util.Iterator;
import java.util.List;

/* compiled from: UpgradeFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.upgrade.as */
/* loaded from: classes.dex */
final class C2639as implements AdapterClickListenter {

    /* renamed from: a */
    final /* synthetic */ UpgradeFragment f15137a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2639as(UpgradeFragment upgradeFragment) {
        this.f15137a = upgradeFragment;
    }

    @Override // com.cnlaunch.x431pro.activity.upgrade.AdapterClickListenter
    /* renamed from: a */
    public final void mo4707a(View view, String str, int i) {
        Context context;
        Context context2;
        this.f15137a.f15080N = str;
        this.f15137a.f15073G = view;
        this.f15137a.f15081O = i;
        this.f15137a.f15091Y = true;
        context = this.f15137a.mContext;
        context2 = this.f15137a.mContext;
        LoadDialog.m4684a(context, context2.getString(R.string.refresh_txt));
        this.f15137a.request(2103);
    }

    @Override // com.cnlaunch.x431pro.activity.upgrade.AdapterClickListenter
    /* renamed from: a */
    public final void mo4708a() {
        List list;
        boolean z;
        List list2;
        CheckBox checkBox;
        CheckBox checkBox2;
        CheckBox checkBox3;
        CheckBox checkBox4;
        CheckBox checkBox5;
        CheckBox checkBox6;
        CheckBox checkBox7;
        CheckBox checkBox8;
        CheckBox checkBox9;
        CheckBox checkBox10;
        list = this.f15137a.f15082P;
        Iterator it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            } else if (((X431PadDtoSoft) it.next()).isChecked()) {
                checkBox10 = this.f15137a.f15067A;
                checkBox10.setChecked(true);
                z = true;
                break;
            }
        }
        if (z) {
            checkBox7 = this.f15137a.f15067A;
            checkBox7.setEnabled(true);
            checkBox8 = this.f15137a.f15067A;
            checkBox8.setChecked(true);
            checkBox9 = this.f15137a.f15067A;
            checkBox9.setText(R.string.common_unselect);
            return;
        }
        list2 = this.f15137a.f15082P;
        if (list2.size() > 0) {
            checkBox4 = this.f15137a.f15067A;
            checkBox4.setEnabled(true);
            checkBox5 = this.f15137a.f15067A;
            checkBox5.setChecked(false);
            checkBox6 = this.f15137a.f15067A;
            checkBox6.setText(R.string.common_select);
            return;
        }
        checkBox = this.f15137a.f15067A;
        checkBox.setChecked(false);
        checkBox2 = this.f15137a.f15067A;
        checkBox2.setText(R.string.common_select);
        checkBox3 = this.f15137a.f15067A;
        checkBox3.setEnabled(false);
    }
}
