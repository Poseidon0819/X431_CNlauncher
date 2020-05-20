package com.cnlaunch.golo3.widget;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.cnlaunch.p132e.p133a.C1464a;

/* renamed from: com.cnlaunch.golo3.widget.d */
/* loaded from: classes.dex */
public final class KJListViewHeader extends LinearLayout {

    /* renamed from: a */
    public EnumC1667a f8840a;

    /* renamed from: b */
    RelativeLayout f8841b;

    /* renamed from: c */
    TextView f8842c;

    /* renamed from: d */
    private String f8843d;

    /* renamed from: e */
    private String f8844e;

    /* renamed from: f */
    private String f8845f;

    /* renamed from: g */
    private TextView f8846g;

    /* compiled from: KJListViewHeader.java */
    /* renamed from: com.cnlaunch.golo3.widget.d$a */
    /* loaded from: classes.dex */
    public enum EnumC1667a {
        STATE_NORMAL,
        STATE_READY,
        STATE_REFRESHING
    }

    public KJListViewHeader(Context context) {
        super(context);
        this.f8840a = EnumC1667a.STATE_NORMAL;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, 0);
        this.f8841b = new RelativeLayout(context);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13);
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setGravity(17);
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(layoutParams2);
        this.f8846g = new TextView(context);
        this.f8846g.setGravity(17);
        this.f8843d = context.getResources().getString(C1464a.C1470f.KJ_listview_refresh_normal);
        this.f8844e = context.getResources().getString(C1464a.C1470f.KJ_listview_refresh_ready);
        this.f8845f = context.getResources().getString(C1464a.C1470f.KJ_listview_refresh_refreshing);
        this.f8846g.setText(this.f8843d);
        this.f8842c = new TextView(context);
        this.f8842c.setGravity(17);
        linearLayout.addView(this.f8846g);
        linearLayout.addView(this.f8842c);
        this.f8841b.addView(linearLayout);
        addView(this.f8841b, layoutParams);
        setGravity(80);
    }

    public final void setState(EnumC1667a enumC1667a) {
        if (enumC1667a == this.f8840a) {
            return;
        }
        switch (enumC1667a) {
            case STATE_NORMAL:
                this.f8846g.setText(this.f8843d);
                break;
            case STATE_READY:
                if (this.f8840a != EnumC1667a.STATE_READY) {
                    this.f8846g.setText(this.f8844e);
                    break;
                }
                break;
            case STATE_REFRESHING:
                this.f8846g.setText(this.f8845f);
                break;
        }
        this.f8840a = enumC1667a;
    }

    public final void setVisibleHeight(int i) {
        if (i < 0) {
            i = 0;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f8841b.getLayoutParams();
        layoutParams.height = i;
        this.f8841b.setLayoutParams(layoutParams);
    }

    public final int getVisibleHeight() {
        return this.f8841b.getHeight();
    }

    public final void setNormal(String str) {
        this.f8843d = str;
    }

    public final void setReady(String str) {
        this.f8844e = str;
    }

    public final void setRefreshing(String str) {
        this.f8845f = str;
    }
}
