package com.cnlaunch.x431pro.activity.info;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.cnlaunch.x431pro.activity.BaseFragment;
import com.ifoer.expedition.pro.R;

/* renamed from: com.cnlaunch.x431pro.activity.info.w */
/* loaded from: classes.dex */
public class RepairInfoActivityEuroFragment extends BaseFragment {

    /* renamed from: a */
    private ImageView f12954a;

    /* renamed from: b */
    private ImageView f12955b;

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        setTitle(R.string.tab_menu_info);
        this.f12955b = (ImageView) getActivity().findViewById(R.id.euro_db);
        this.f12955b.setOnClickListener(new View$OnClickListenerC2295x(this));
        this.f12954a = (ImageView) getActivity().findViewById(R.id.repair_help);
        this.f12954a.setOnClickListener(new View$OnClickListenerC2296y(this));
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment
    public View onCreateFragmentView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_repair_info_euro, viewGroup, false);
    }
}
