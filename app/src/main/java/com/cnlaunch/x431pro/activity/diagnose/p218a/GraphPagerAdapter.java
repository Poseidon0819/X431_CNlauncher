package com.cnlaunch.x431pro.activity.diagnose.p218a;

import android.support.p012v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import com.cnlaunch.x431pro.activity.diagnose.p220c.GraphPage;
import java.util.Map;

/* renamed from: com.cnlaunch.x431pro.activity.diagnose.a.l */
/* loaded from: classes.dex */
public final class GraphPagerAdapter extends PagerAdapter {

    /* renamed from: a */
    ViewGroup.LayoutParams f11353a = new ViewGroup.LayoutParams(-1, -1);

    /* renamed from: b */
    private Map<Integer, ? extends GraphPage> f11354b;

    @Override // android.support.p012v4.view.PagerAdapter
    /* renamed from: a */
    public final boolean mo1770a(View view, Object obj) {
        return view == obj;
    }

    public GraphPagerAdapter(Map<Integer, ? extends GraphPage> map) {
        this.f11354b = map;
    }

    @Override // android.support.p012v4.view.PagerAdapter
    /* renamed from: a */
    public final int mo1771a() {
        return this.f11354b.size();
    }

    @Override // android.support.p012v4.view.PagerAdapter
    /* renamed from: a */
    public final void mo1768a(ViewGroup viewGroup, int i, Object obj) {
        if (this.f11354b.size() <= i || this.f11354b.get(Integer.valueOf(i)) == null) {
            return;
        }
        viewGroup.removeView(this.f11354b.get(Integer.valueOf(i)).mo7367c());
    }

    @Override // android.support.p012v4.view.PagerAdapter
    /* renamed from: a */
    public final /* synthetic */ Object mo1769a(ViewGroup viewGroup, int i) {
        View mo7367c = this.f11354b.get(Integer.valueOf(i)).mo7367c();
        viewGroup.addView(mo7367c, this.f11353a);
        return mo7367c;
    }
}
