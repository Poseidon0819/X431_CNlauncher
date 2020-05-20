package com.cnlaunch.x431pro.activity;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.p012v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.x431pro.activity.diagnose.p218a.ImagePageAdapter;
import com.cnlaunch.x431pro.activity.diagnose.p218a.ViewPagerAdapter;
import com.cnlaunch.x431pro.widget.NoScrollGridView;
import com.ifoer.expedition.pro.R;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class GuideActivity extends ActivityC2004c implements ViewPager.InterfaceC0176e {

    /* renamed from: C */
    private ViewPagerAdapter f10698C;

    /* renamed from: D */
    private ArrayList<View> f10699D;

    /* renamed from: G */
    private RelativeLayout f10702G;

    /* renamed from: H */
    private int f10703H;

    /* renamed from: n */
    private ViewPager f10705n;

    /* renamed from: E */
    private NoScrollGridView f10700E = null;

    /* renamed from: F */
    private ImagePageAdapter f10701F = null;

    /* renamed from: I */
    private int f10704I = 0;

    @Override // android.support.p012v4.view.ViewPager.InterfaceC0176e
    /* renamed from: a */
    public final void mo1773a(int i, float f, int i2) {
    }

    @Override // android.support.p012v4.view.ViewPager.InterfaceC0176e
    /* renamed from: a_ */
    public final void mo1772a_(int i) {
    }

    @Override // com.cnlaunch.x431pro.activity.ActivityC2004c, android.support.p012v4.app.FragmentActivity, android.support.p012v4.app.BaseFragmentActivityGingerbread, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_guide);
        this.f10703H = PreferencesManager.m9595a(this.f10981q).m9585b("guide_pages", 1);
        Context context = this.f10981q;
        PreferencesManager.m9595a(context).m9587a("isSend_Downloadbin", true);
        PreferencesManager.m9595a(context).m9587a("isSend_Boot", true);
        PreferencesManager.m9595a(context).m9587a("isSend_Apk", true);
        m7743b();
        LayoutInflater layoutInflater = getLayoutInflater();
        this.f10699D = new ArrayList<>();
        if (this.f10703H > 0) {
            this.f10699D.add(layoutInflater.inflate(R.layout.layout_guide_item1, (ViewGroup) null));
        }
        if (this.f10703H >= 2) {
            this.f10699D.add(layoutInflater.inflate(R.layout.layout_guide_item2, (ViewGroup) null));
        }
        if (this.f10703H >= 3) {
            this.f10699D.add(layoutInflater.inflate(R.layout.layout_guide_item3, (ViewGroup) null));
        }
        if (this.f10703H >= 4) {
            this.f10699D.add(layoutInflater.inflate(R.layout.layout_guide_item4, (ViewGroup) null));
        }
        if (this.f10703H >= 5) {
            this.f10699D.add(layoutInflater.inflate(R.layout.layout_guide_item5, (ViewGroup) null));
        }
        this.f10698C = new ViewPagerAdapter(this.f10699D);
        this.f10705n = (ViewPager) findViewById(R.id.guidePages);
        this.f10702G = (RelativeLayout) findViewById(R.id.button_jump);
        this.f10702G.setOnClickListener(new View$OnClickListenerC2501o(this));
        int size = this.f10699D.size();
        this.f10700E = (NoScrollGridView) findViewById(R.id.horizontal_gridview);
        this.f10701F = new ImagePageAdapter(this, size);
        this.f10700E.setAdapter((ListAdapter) this.f10701F);
        this.f10700E.setNumColumns(size);
        int integer = getResources().getInteger(R.integer.datastream_imagepage_button_widthsize);
        this.f10700E.setLayoutParams(new LinearLayout.LayoutParams(size * integer, -1));
        this.f10700E.setColumnWidth(integer);
        this.f10700E.setStretchMode(0);
        this.f10705n.setAdapter(this.f10698C);
        this.f10705n.setOnPageChangeListener(this);
    }

    @Override // com.cnlaunch.x431pro.activity.ActivityC2004c, android.support.p012v4.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        LayoutInflater layoutInflater = getLayoutInflater();
        this.f10699D.clear();
        if (this.f10703H > 0) {
            this.f10699D.add(layoutInflater.inflate(R.layout.layout_guide_item1, (ViewGroup) null));
        }
        if (this.f10703H >= 2) {
            this.f10699D.add(layoutInflater.inflate(R.layout.layout_guide_item2, (ViewGroup) null));
        }
        if (this.f10703H >= 3) {
            this.f10699D.add(layoutInflater.inflate(R.layout.layout_guide_item3, (ViewGroup) null));
        }
        if (this.f10703H >= 4) {
            this.f10699D.add(layoutInflater.inflate(R.layout.layout_guide_item4, (ViewGroup) null));
        }
        if (this.f10703H >= 5) {
            this.f10699D.add(layoutInflater.inflate(R.layout.layout_guide_item5, (ViewGroup) null));
        }
        ViewPagerAdapter viewPagerAdapter = this.f10698C;
        viewPagerAdapter.f11254a = this.f10699D;
        viewPagerAdapter.mo6192b();
        this.f10705n.setAdapter(this.f10698C);
        this.f10705n.setOnPageChangeListener(this);
        this.f10705n.setCurrentItem(this.f10704I);
    }

    @Override // android.support.p012v4.view.ViewPager.InterfaceC0176e
    /* renamed from: a */
    public final void mo1774a(int i) {
        this.f10701F.m7489a(i);
        this.f10704I = i;
        if (i == this.f10703H - 1) {
            this.f10702G.setVisibility(0);
        }
    }
}
