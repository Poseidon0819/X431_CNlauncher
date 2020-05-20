package com.cnlaunch.x431pro.widget.p290a;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MulitInputDialog.java */
/* renamed from: com.cnlaunch.x431pro.widget.a.bf */
/* loaded from: classes.dex */
public final class View$OnClickListenerC2824bf implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ TextView f16282a;

    /* renamed from: b */
    final /* synthetic */ List f16283b;

    /* renamed from: c */
    final /* synthetic */ MulitInputDialog f16284c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC2824bf(MulitInputDialog mulitInputDialog, TextView textView, List list) {
        this.f16284c = mulitInputDialog;
        this.f16282a = textView;
        this.f16283b = list;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Map map;
        Map map2;
        Context context;
        Map map3;
        Map map4;
        Map map5;
        map = this.f16284c.f16278g;
        for (TextView textView : map.keySet()) {
            map5 = this.f16284c.f16278g;
            ((SpinnerPopupWindow) map5.get(textView)).m4583a();
        }
        map2 = this.f16284c.f16278g;
        if (map2.containsKey(this.f16282a)) {
            map4 = this.f16284c.f16278g;
            map4.remove(this.f16282a);
        }
        context = this.f16284c.f16276b;
        SpinnerPopupWindow spinnerPopupWindow = new SpinnerPopupWindow(context);
        map3 = this.f16284c.f16278g;
        map3.put(this.f16282a, spinnerPopupWindow);
        spinnerPopupWindow.f16384c = this.f16282a.getWidth();
        spinnerPopupWindow.f16383b = new C2825bg(this);
        spinnerPopupWindow.m4582a(this.f16282a, this.f16283b);
    }
}
