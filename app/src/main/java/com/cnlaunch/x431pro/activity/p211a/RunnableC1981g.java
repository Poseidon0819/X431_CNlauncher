package com.cnlaunch.x431pro.activity.p211a;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.widget.TextView;
import com.ifoer.expedition.pro.R;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: HistoryFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.a.g */
/* loaded from: classes.dex */
public final class RunnableC1981g implements Runnable {

    /* renamed from: a */
    final /* synthetic */ HistoryFragment f10876a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC1981g(HistoryFragment historyFragment) {
        this.f10876a = historyFragment;
    }

    @Override // java.lang.Runnable
    public final void run() {
        TextView textView;
        List list;
        SpannableStringBuilder m7834b;
        TextView textView2;
        String str;
        List list2;
        TextView textView3;
        TextView textView4;
        Context context;
        TextView textView5;
        TextView textView6;
        textView = this.f10876a.f10857l;
        HistoryFragment historyFragment = this.f10876a;
        list = historyFragment.f10849J;
        m7834b = historyFragment.m7834b(String.valueOf(list.size()));
        textView.setText(m7834b);
        textView2 = this.f10876a.f10858m;
        str = this.f10876a.f10845F;
        textView2.setText(str);
        list2 = this.f10876a.f10849J;
        if (list2.size() > 1) {
            context = this.f10876a.mContext;
            Drawable drawable = context.getResources().getDrawable(R.drawable.down_red_arrow);
            drawable.setBounds(0, 0, 19, 11);
            textView5 = this.f10876a.f10858m;
            textView5.setCompoundDrawables(null, null, drawable, null);
            textView6 = this.f10876a.f10858m;
            textView6.setOnClickListener(this.f10876a);
            return;
        }
        textView3 = this.f10876a.f10858m;
        textView3.setCompoundDrawables(null, null, null, null);
        textView4 = this.f10876a.f10858m;
        textView4.setOnClickListener(null);
    }
}
