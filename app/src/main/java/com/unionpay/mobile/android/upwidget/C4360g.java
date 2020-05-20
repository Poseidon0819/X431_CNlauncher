package com.unionpay.mobile.android.upwidget;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import com.cnlaunch.p112a.p115c.DefaultRenderer;
import com.unionpay.mobile.android.global.C4150b;
import com.unionpay.mobile.android.utils.C4386g;
import java.util.ArrayList;

/* renamed from: com.unionpay.mobile.android.upwidget.g */
/* loaded from: classes2.dex */
public final class C4360g extends LinearLayout {

    /* renamed from: a */
    private Context f23094a;

    /* renamed from: b */
    private C4356c f23095b;

    /* renamed from: c */
    private ArrayList<AdapterView.OnItemClickListener> f23096c;

    /* renamed from: d */
    private ArrayList<View.OnClickListener> f23097d;

    /* renamed from: e */
    private AdapterView.OnItemClickListener f23098e;

    /* renamed from: f */
    private View.OnClickListener f23099f;

    public C4360g(Context context, C4356c c4356c) {
        super(context);
        this.f23096c = new ArrayList<>();
        this.f23097d = new ArrayList<>();
        this.f23098e = new C4361h(this);
        this.f23099f = new View$OnClickListenerC4362i(this);
        this.f23094a = context;
        this.f23095b = c4356c;
        RelativeLayout relativeLayout = new RelativeLayout(this.f23094a);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12, -1);
        LinearLayout linearLayout = new LinearLayout(this.f23094a);
        linearLayout.setOrientation(1);
        linearLayout.setBackgroundColor(-1);
        linearLayout.setId(linearLayout.hashCode());
        relativeLayout.addView(linearLayout, layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
        LinearLayout linearLayout2 = new LinearLayout(this.f23094a);
        layoutParams2.addRule(10, -1);
        layoutParams2.addRule(2, linearLayout.getId());
        relativeLayout.addView(linearLayout2, layoutParams2);
        linearLayout2.setOnClickListener(this.f23099f);
        int m858a = C4386g.m858a(this.f23094a, 1.0f);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
        int i = C4150b.f22138a;
        layoutParams3.bottomMargin = i;
        layoutParams3.topMargin = i;
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, m858a);
        LinearLayout linearLayout3 = new LinearLayout(this.f23094a);
        linearLayout3.setBackgroundColor(DefaultRenderer.TEXT_COLOR);
        linearLayout.addView(linearLayout3, layoutParams4);
        new LinearLayout.LayoutParams(-1, -2);
        ListView listView = new ListView(this.f23094a);
        listView.setDivider(null);
        m960a(listView, this.f23095b);
        listView.setAdapter(this.f23095b);
        listView.setCacheColorHint(-1);
        listView.setOnItemClickListener(this.f23098e);
        new LinearLayout.LayoutParams(-1, -2);
        linearLayout.addView(listView);
        addView(relativeLayout);
    }

    /* renamed from: a */
    private void m960a(ListView listView, ListAdapter listAdapter) {
        ViewGroup.LayoutParams layoutParams;
        if (listAdapter == null || (layoutParams = listView.getLayoutParams()) == null) {
            return;
        }
        Rect rect = new Rect();
        ((Activity) this.f23094a).getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        int height = rect.height();
        int i = 0;
        for (int i2 = 0; i2 < listAdapter.getCount(); i2++) {
            View view = listAdapter.getView(i2, null, listView);
            view.measure(0, 0);
            i += view.getMeasuredHeight();
            if (i > height) {
                break;
            }
        }
        layoutParams.height = Math.min(i, height);
        listView.setLayoutParams(layoutParams);
    }

    /* renamed from: a */
    public final void m962a(View.OnClickListener onClickListener) {
        this.f23097d.add(onClickListener);
    }

    /* renamed from: a */
    public final void m961a(AdapterView.OnItemClickListener onItemClickListener) {
        this.f23096c.add(onItemClickListener);
    }
}
