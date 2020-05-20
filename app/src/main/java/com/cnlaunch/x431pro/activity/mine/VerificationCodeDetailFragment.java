package com.cnlaunch.x431pro.activity.mine;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.cnlaunch.x431pro.activity.BaseFragment;
import com.ifoer.expedition.pro.R;

/* renamed from: com.cnlaunch.x431pro.activity.mine.dg */
/* loaded from: classes.dex */
public class VerificationCodeDetailFragment extends BaseFragment {
    @Override // com.cnlaunch.x431pro.activity.BaseFragment, android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        setTitle(R.string.get_identify_code_head);
        setLeftImage(this.mContext.getResources().getDrawable(R.drawable.select_btn_menu_two));
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment
    public View onCreateFragmentView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.mine_verification_code, viewGroup, false);
    }
}
