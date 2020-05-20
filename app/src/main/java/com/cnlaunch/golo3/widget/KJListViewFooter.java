package com.cnlaunch.golo3.widget;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.cnlaunch.p132e.p133a.C1464a;

/* renamed from: com.cnlaunch.golo3.widget.c */
/* loaded from: classes.dex */
public final class KJListViewFooter extends LinearLayout {

    /* renamed from: a */
    public EnumC1666a f8833a;

    /* renamed from: b */
    RelativeLayout f8834b;

    /* renamed from: c */
    private String f8835c;

    /* renamed from: d */
    private String f8836d;

    /* renamed from: e */
    private View f8837e;

    /* renamed from: f */
    private TextView f8838f;

    /* compiled from: KJListViewFooter.java */
    /* renamed from: com.cnlaunch.golo3.widget.c$a */
    /* loaded from: classes.dex */
    public enum EnumC1666a {
        STATE_NORMAL,
        STATE_READY,
        STATE_LOADING
    }

    public KJListViewFooter(Context context) {
        super(context);
        this.f8833a = EnumC1666a.STATE_NORMAL;
        this.f8834b = new RelativeLayout(context);
        this.f8834b.setPadding(10, 10, 10, 10);
        this.f8834b.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(13);
        this.f8837e = new ProgressBar(context);
        this.f8837e.setLayoutParams(layoutParams);
        this.f8838f = new TextView(context);
        this.f8838f.setLayoutParams(layoutParams);
        if (this.f8835c == null) {
            this.f8835c = context.getResources().getString(C1464a.C1470f.KJ_listview_load_more_refreshing);
        }
        this.f8836d = context.getResources().getString(C1464a.C1470f.KJ_listview_load_more_unclasp);
        this.f8838f.setText(this.f8835c);
        this.f8838f.setGravity(17);
        this.f8834b.addView(this.f8837e);
        this.f8834b.addView(this.f8838f);
        addView(this.f8834b);
    }

    public final void setLoadMoreText(String str) {
        this.f8838f.setText(str);
    }

    public final void setState(EnumC1666a enumC1666a) {
        this.f8838f.setVisibility(4);
        this.f8837e.setVisibility(4);
        if (enumC1666a == EnumC1666a.STATE_READY) {
            this.f8833a = EnumC1666a.STATE_READY;
            this.f8838f.setVisibility(0);
            this.f8838f.setText(this.f8836d);
        } else if (enumC1666a == EnumC1666a.STATE_LOADING) {
            this.f8833a = EnumC1666a.STATE_LOADING;
            this.f8837e.setVisibility(0);
        } else {
            this.f8833a = EnumC1666a.STATE_NORMAL;
            this.f8838f.setVisibility(0);
            this.f8838f.setText(this.f8835c);
        }
    }

    public final void setBottomMargin(int i) {
        if (i < 0) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f8834b.getLayoutParams();
        layoutParams.bottomMargin = i;
        this.f8834b.setLayoutParams(layoutParams);
    }

    public final int getBottomMargin() {
        return ((LinearLayout.LayoutParams) this.f8834b.getLayoutParams()).bottomMargin;
    }

    public final void setRefreshing(String str) {
        this.f8835c = str;
    }
}
