package com.cnlaunch.x431pro.widget.cycleviewpager;

import android.app.Fragment;
import android.os.Bundle;
import android.support.p012v4.view.PagerAdapter;
import android.support.p012v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.mapapi.UIMsg;
import com.cnlaunch.x431pro.module.p252d.p254b.AdvertiseResponse;
import com.ifoer.expedition.pro.R;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class CycleViewPager extends Fragment implements ViewPager.InterfaceC0176e {

    /* renamed from: e */
    private ImageView[] f16555e;

    /* renamed from: f */
    private FrameLayout f16556f;

    /* renamed from: g */
    private LinearLayout f16557g;

    /* renamed from: h */
    private BaseViewPager f16558h;

    /* renamed from: i */
    private BaseViewPager f16559i;

    /* renamed from: j */
    private C2901b f16560j;

    /* renamed from: k */
    private CycleViewPagerHandler f16561k;

    /* renamed from: r */
    private InterfaceC2900a f16568r;

    /* renamed from: s */
    private AdvertiseResponse[] f16569s;

    /* renamed from: t */
    private LayoutInflater f16570t;

    /* renamed from: d */
    private List<ImageView> f16554d = new ArrayList();

    /* renamed from: a */
    public int f16551a = UIMsg.m_AppUI.MSG_APP_GPS;

    /* renamed from: l */
    private int f16562l = 0;

    /* renamed from: m */
    private boolean f16563m = false;

    /* renamed from: b */
    public boolean f16552b = false;

    /* renamed from: n */
    private boolean f16564n = false;

    /* renamed from: o */
    private long f16565o = 0;

    /* renamed from: p */
    private int f16566p = 100;

    /* renamed from: q */
    private int f16567q = 101;

    /* renamed from: c */
    final Runnable f16553c = new RunnableC2903b(this);

    /* renamed from: com.cnlaunch.x431pro.widget.cycleviewpager.CycleViewPager$a */
    /* loaded from: classes.dex */
    public interface InterfaceC2900a {
        /* renamed from: a */
        void mo4481a(AdvertiseResponse advertiseResponse);
    }

    @Override // android.support.p012v4.view.ViewPager.InterfaceC0176e
    /* renamed from: a */
    public final void mo1773a(int i, float f, int i2) {
    }

    @Override // android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.f16561k = new HandlerC2902a(this, getActivity());
    }

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f16570t = layoutInflater;
        View inflate = layoutInflater.inflate(R.layout.view_cycle_viewpager_contet, (ViewGroup) null);
        this.f16558h = (BaseViewPager) inflate.findViewById(R.id.viewPager);
        this.f16557g = (LinearLayout) inflate.findViewById(R.id.layout_viewpager_indicator);
        this.f16556f = (FrameLayout) inflate.findViewById(R.id.layout_viewager_content);
        return inflate;
    }

    /* renamed from: a */
    public final void m4496a(List<ImageView> list, AdvertiseResponse[] advertiseResponseArr, InterfaceC2900a interfaceC2900a) {
        m4495a(list, advertiseResponseArr, interfaceC2900a, 0);
    }

    /* renamed from: a */
    private void m4495a(List<ImageView> list, AdvertiseResponse[] advertiseResponseArr, InterfaceC2900a interfaceC2900a, int i) {
        this.f16568r = interfaceC2900a;
        this.f16569s = advertiseResponseArr;
        this.f16554d.clear();
        if (list.size() == 0) {
            this.f16556f.setVisibility(8);
            return;
        }
        for (ImageView imageView : list) {
            this.f16554d.add(imageView);
        }
        int size = list.size();
        this.f16555e = new ImageView[size];
        if (this.f16552b && size > 2) {
            this.f16555e = new ImageView[size - 2];
        }
        if (this.f16555e.length <= 1) {
            this.f16557g.setVisibility(8);
        } else {
            this.f16557g.setVisibility(0);
            this.f16557g.removeAllViews();
        }
        for (int i2 = 0; i2 < this.f16555e.length; i2++) {
            LayoutInflater layoutInflater = this.f16570t;
            if (layoutInflater != null) {
                View inflate = layoutInflater.inflate(R.layout.view_cycle_viewpager_indicator, (ViewGroup) null);
                this.f16555e[i2] = (ImageView) inflate.findViewById(R.id.image_indicator);
                this.f16557g.addView(inflate);
            }
        }
        this.f16560j = new C2901b(this, (byte) 0);
        m4492c(0);
        this.f16558h.setOffscreenPageLimit(3);
        this.f16558h.setOnPageChangeListener(this);
        this.f16558h.setAdapter(this.f16560j);
        if (list.size() <= 0) {
            i = 0;
        }
        if (this.f16552b) {
            i = 1;
        }
        this.f16558h.setCurrentItem(i);
    }

    /* renamed from: a */
    public final void m4494a(boolean z) {
        this.f16564n = z;
        this.f16552b = true;
        if (z) {
            this.f16561k.postDelayed(this.f16553c, this.f16551a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.cnlaunch.x431pro.widget.cycleviewpager.CycleViewPager$b */
    /* loaded from: classes.dex */
    public class C2901b extends PagerAdapter {
        @Override // android.support.p012v4.view.PagerAdapter
        /* renamed from: a */
        public final int mo4480a(Object obj) {
            return -2;
        }

        @Override // android.support.p012v4.view.PagerAdapter
        /* renamed from: a */
        public final boolean mo1770a(View view, Object obj) {
            return view == obj;
        }

        private C2901b() {
        }

        /* synthetic */ C2901b(CycleViewPager cycleViewPager, byte b) {
            this();
        }

        @Override // android.support.p012v4.view.PagerAdapter
        /* renamed from: a */
        public final int mo1771a() {
            return CycleViewPager.this.f16554d.size();
        }

        @Override // android.support.p012v4.view.PagerAdapter
        /* renamed from: a */
        public final void mo1768a(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView((View) obj);
        }

        @Override // android.support.p012v4.view.PagerAdapter
        /* renamed from: a */
        public final /* synthetic */ Object mo1769a(ViewGroup viewGroup, int i) {
            ImageView imageView = (ImageView) CycleViewPager.this.f16554d.get(i);
            if (CycleViewPager.this.f16568r != null) {
                imageView.setOnClickListener(new View$OnClickListenerC2904c(this));
            }
            viewGroup.addView(imageView);
            return imageView;
        }
    }

    @Override // android.support.p012v4.view.ViewPager.InterfaceC0176e
    /* renamed from: a_ */
    public final void mo1772a_(int i) {
        if (i == 1) {
            this.f16563m = true;
            return;
        }
        if (i == 0) {
            BaseViewPager baseViewPager = this.f16559i;
            if (baseViewPager != null) {
                baseViewPager.setScrollable(true);
            }
            this.f16565o = System.currentTimeMillis();
            this.f16558h.m14748a(this.f16562l, false);
        }
        this.f16563m = false;
    }

    @Override // android.support.p012v4.view.ViewPager.InterfaceC0176e
    /* renamed from: a */
    public final void mo1774a(int i) {
        int size = this.f16554d.size() - 1;
        this.f16562l = i;
        if (this.f16552b) {
            if (i == 0) {
                this.f16562l = size - 1;
            } else if (i == size) {
                this.f16562l = 1;
            }
            i = this.f16562l - 1;
        }
        m4492c(i);
    }

    /* renamed from: c */
    private void m4492c(int i) {
        ImageView[] imageViewArr;
        int i2 = 0;
        while (true) {
            imageViewArr = this.f16555e;
            if (i2 >= imageViewArr.length) {
                break;
            }
            imageViewArr[i2].setActivated(false);
            i2++;
        }
        if (imageViewArr.length > i) {
            imageViewArr[i].setActivated(true);
        }
    }
}
