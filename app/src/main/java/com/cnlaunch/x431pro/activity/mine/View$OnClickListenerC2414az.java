package com.cnlaunch.x431pro.activity.mine;

import android.view.View;
import android.widget.LinearLayout;
import com.cnlaunch.x431pro.module.p258f.p260b.UserOrderDTO;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MyOrderFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.mine.az */
/* loaded from: classes.dex */
public final class View$OnClickListenerC2414az implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ UserOrderDTO f13715a;

    /* renamed from: b */
    final /* synthetic */ LinearLayout f13716b;

    /* renamed from: c */
    final /* synthetic */ View f13717c;

    /* renamed from: d */
    final /* synthetic */ MyOrderFragment f13718d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnClickListenerC2414az(MyOrderFragment myOrderFragment, UserOrderDTO userOrderDTO, LinearLayout linearLayout, View view) {
        this.f13718d = myOrderFragment;
        this.f13715a = userOrderDTO;
        this.f13716b = linearLayout;
        this.f13717c = view;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        List list;
        new C2431ba(this).start();
        this.f13716b.removeView(this.f13717c);
        list = this.f13718d.f13699f;
        list.remove(this.f13715a);
    }
}
