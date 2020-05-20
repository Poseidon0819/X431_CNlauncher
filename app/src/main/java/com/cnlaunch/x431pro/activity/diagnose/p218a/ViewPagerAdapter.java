package com.cnlaunch.x431pro.activity.diagnose.p218a;

import android.support.p012v4.view.PagerAdapter;
import android.support.p012v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

/* renamed from: com.cnlaunch.x431pro.activity.diagnose.a.aa */
/* loaded from: classes.dex */
public class ViewPagerAdapter extends PagerAdapter {

    /* renamed from: b */
    private static final String f11253b = "aa";

    /* renamed from: a */
    public ArrayList<View> f11254a;

    @Override // android.support.p012v4.view.PagerAdapter
    /* renamed from: a */
    public final boolean mo1770a(View view, Object obj) {
        return view == obj;
    }

    public ViewPagerAdapter(ArrayList<View> arrayList) {
        this.f11254a = arrayList;
    }

    @Override // android.support.p012v4.view.PagerAdapter
    /* renamed from: a */
    public final int mo1771a() {
        ArrayList<View> arrayList = this.f11254a;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    @Override // android.support.p012v4.view.PagerAdapter
    /* renamed from: a */
    public int mo4480a(Object obj) {
        return super.mo4480a(obj);
    }

    @Override // android.support.p012v4.view.PagerAdapter
    /* renamed from: a */
    public final void mo7523a(View view, int i, Object obj) {
        ((ViewPager) view).removeView((View) obj);
    }

    @Override // android.support.p012v4.view.PagerAdapter
    /* renamed from: a */
    public final Object mo7524a(View view, int i) {
        View view2 = this.f11254a.get(i);
        ViewGroup viewGroup = (ViewGroup) view2.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(view2);
        }
        ((ViewPager) view).addView(this.f11254a.get(i), 0);
        return this.f11254a.get(i);
    }
}
