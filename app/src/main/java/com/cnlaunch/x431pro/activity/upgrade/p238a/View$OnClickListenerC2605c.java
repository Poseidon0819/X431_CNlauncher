package com.cnlaunch.x431pro.activity.upgrade.p238a;

import android.content.Context;
import android.view.View;
import com.cnlaunch.x431pro.module.p269j.p271b.DivisionSoftDto;
import com.cnlaunch.x431pro.widget.p290a.MessageDialog;
import com.ifoer.expedition.pro.R;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DivisionSoftAdapter.java */
/* renamed from: com.cnlaunch.x431pro.activity.upgrade.a.c */
/* loaded from: classes.dex */
public final class View$OnClickListenerC2605c implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ DivisionSoftDto f15001a;

    /* renamed from: b */
    final /* synthetic */ DivisionSoftAdapter f15002b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC2605c(DivisionSoftAdapter divisionSoftAdapter, DivisionSoftDto divisionSoftDto) {
        this.f15002b = divisionSoftAdapter;
        this.f15001a = divisionSoftDto;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Context context;
        Context context2;
        context = this.f15002b.f14990a;
        context2 = this.f15002b.f14990a;
        MessageDialog messageDialog = new MessageDialog(context, context2.getString(R.string.text_softwareintroduction), this.f15001a.getSpfDesc(), true, (byte) 0);
        messageDialog.m4719a(R.string.confirm, true, new View$OnClickListenerC2606d(this));
        messageDialog.show();
    }
}
