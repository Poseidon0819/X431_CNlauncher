package com.cnlaunch.p169im.p170a;

import android.support.p012v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

/* renamed from: com.cnlaunch.im.a.j */
/* loaded from: classes.dex */
public final class ChatPagerAdapter extends PagerAdapter {

    /* renamed from: a */
    public ArrayList<View> f8978a;

    public ChatPagerAdapter(ArrayList<View> arrayList) {
        this.f8978a = arrayList;
    }

    @Override // android.support.p012v4.view.PagerAdapter
    /* renamed from: a */
    public final int mo1771a() {
        return this.f8978a.size();
    }

    @Override // android.support.p012v4.view.PagerAdapter
    /* renamed from: a */
    public final boolean mo1770a(View view, Object obj) {
        return view.equals(obj);
    }

    @Override // android.support.p012v4.view.PagerAdapter
    /* renamed from: a */
    public final Object mo1769a(ViewGroup viewGroup, int i) {
        viewGroup.addView(this.f8978a.get(i));
        return this.f8978a.get(i);
    }

    @Override // android.support.p012v4.view.PagerAdapter
    /* renamed from: a */
    public final void mo1768a(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView((View) obj);
    }
}
