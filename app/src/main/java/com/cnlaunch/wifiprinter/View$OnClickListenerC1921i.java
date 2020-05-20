package com.cnlaunch.wifiprinter;

import android.view.View;
import com.cnlaunch.wifiprinter.C1900at;
import com.cnlaunch.wifiprinter.MainActivity;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MainActivity.java */
/* renamed from: com.cnlaunch.wifiprinter.i */
/* loaded from: classes.dex */
public final class View$OnClickListenerC1921i implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ MainActivity f10455a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC1921i(MainActivity mainActivity) {
        this.f10455a = mainActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.f10455a.f10442t.clear();
        if (this.f10455a.f10433k != null) {
            this.f10455a.f10433k.notifyDataSetChanged();
        }
        MainActivity.f10425g.setVisibility(0);
        this.f10455a.f10435m.setEnabled(false);
        this.f10455a.f10435m.setTextColor(this.f10455a.f10432j.getResources().getColor(C1900at.C1902b.hui1));
        MainActivity mainActivity = this.f10455a;
        new MainActivity.C1915b(mainActivity.f10432j).start();
    }
}
