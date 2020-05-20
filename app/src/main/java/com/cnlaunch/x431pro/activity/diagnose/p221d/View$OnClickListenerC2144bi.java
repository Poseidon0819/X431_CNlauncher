package com.cnlaunch.x431pro.activity.diagnose.p221d;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.cnlaunch.x431pro.widget.p290a.SpinnerPopupWindow;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MulitInputFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.diagnose.d.bi */
/* loaded from: classes.dex */
public final class View$OnClickListenerC2144bi implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ TextView f12096a;

    /* renamed from: b */
    final /* synthetic */ List f12097b;

    /* renamed from: c */
    final /* synthetic */ int f12098c;

    /* renamed from: d */
    final /* synthetic */ MulitInputFragment f12099d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC2144bi(MulitInputFragment mulitInputFragment, TextView textView, List list, int i) {
        this.f12099d = mulitInputFragment;
        this.f12096a = textView;
        this.f12097b = list;
        this.f12098c = i;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Map map;
        Map map2;
        Context context;
        Map map3;
        Map map4;
        Map map5;
        map = this.f12099d.f12076k;
        for (TextView textView : map.keySet()) {
            map5 = this.f12099d.f12076k;
            ((SpinnerPopupWindow) map5.get(textView)).m4583a();
        }
        map2 = this.f12099d.f12076k;
        if (map2.containsKey(this.f12096a)) {
            map4 = this.f12099d.f12076k;
            map4.remove(this.f12096a);
        }
        context = this.f12099d.f12074b;
        SpinnerPopupWindow spinnerPopupWindow = new SpinnerPopupWindow(context);
        map3 = this.f12099d.f12076k;
        map3.put(this.f12096a, spinnerPopupWindow);
        spinnerPopupWindow.f16384c = this.f12096a.getWidth();
        spinnerPopupWindow.f16383b = new C2145bj(this);
        spinnerPopupWindow.m4581b(this.f12096a, this.f12097b);
    }
}
