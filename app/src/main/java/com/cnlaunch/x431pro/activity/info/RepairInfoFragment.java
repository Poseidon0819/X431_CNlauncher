package com.cnlaunch.x431pro.activity.info;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import com.cnlaunch.x431pro.activity.BaseFragment;
import com.cnlaunch.x431pro.utils.C2744aa;
import com.ifoer.expedition.pro.R;

/* renamed from: com.cnlaunch.x431pro.activity.info.af */
/* loaded from: classes.dex */
public class RepairInfoFragment extends BaseFragment {

    /* renamed from: a */
    private GridView f12880a;

    /* renamed from: b */
    private String[] f12881b = {"http://www.identifix.com", "https://workshop.autodata-group.com/login?destination=node", "http://www.iatn.net", "https://my.alldata.com/#/home", "http://www.launchtechusa.com", "http://www.prodemand.com", "http://www.shopkeypro.com", "http://www.google.com"};

    /* renamed from: c */
    private String[] f12882c = {"http://www.identifix.com", "https://workshop.autodata-group.com/login?destination=node", "http://www.iatn.net", "https://my.alldata.com/#/home", "http://www.ondemand5.com", "http://www.shopkey5.com", "http://www.google.com"};

    @Override // com.cnlaunch.x431pro.activity.BaseFragment
    public View onCreateFragmentView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.layout_repair_info, viewGroup, false);
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        setTitle(R.string.repair_info_tittle);
        this.f12880a = (GridView) getActivity().findViewById(R.id.repairinfo_gridview);
        if (getResources().getConfiguration().orientation == 2) {
            this.f12880a.setNumColumns(3);
        } else {
            this.f12880a.setNumColumns(2);
        }
        this.f12880a.setAdapter((ListAdapter) new C2274a());
    }

    @Override // android.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (configuration.orientation == 2) {
            this.f12880a.setNumColumns(3);
        } else {
            this.f12880a.setNumColumns(2);
        }
        this.f12880a.setAdapter((ListAdapter) new C2274a());
    }

    /* compiled from: RepairInfoFragment.java */
    /* renamed from: com.cnlaunch.x431pro.activity.info.af$a */
    /* loaded from: classes.dex */
    public class C2274a extends BaseAdapter {

        /* renamed from: b */
        private int[] f12884b = {R.drawable.web_0, R.drawable.web_1, R.drawable.web_2, R.drawable.web_3, R.drawable.web_4, R.drawable.web_5, R.drawable.web_6, R.drawable.web_7};

        /* renamed from: c */
        private int[] f12885c = {R.drawable.web_0, R.drawable.web_1, R.drawable.web_2, R.drawable.web_3, R.drawable.web_5, R.drawable.web_6, R.drawable.web_7};

        @Override // android.widget.Adapter
        public final long getItemId(int i) {
            return 0L;
        }

        public C2274a() {
        }

        @Override // android.widget.Adapter
        public final int getCount() {
            if (C2744aa.m5151f()) {
                return this.f12885c.length;
            }
            return this.f12884b.length;
        }

        @Override // android.widget.Adapter
        public final Object getItem(int i) {
            if (C2744aa.m5151f()) {
                return Integer.valueOf(this.f12885c[i]);
            }
            return Integer.valueOf(this.f12884b[i]);
        }

        @Override // android.widget.Adapter
        public final View getView(int i, View view, ViewGroup viewGroup) {
            View inflate = LayoutInflater.from(RepairInfoFragment.this.mContext).inflate(R.layout.item_grid_repair_info, (ViewGroup) null);
            ImageView imageView = (ImageView) inflate.findViewById(R.id.repair_info_grid_img);
            imageView.setImageResource(C2744aa.m5151f() ? this.f12885c[i] : this.f12884b[i]);
            imageView.setOnClickListener(new View$OnClickListenerC2275ag(this, i));
            return inflate;
        }
    }
}
