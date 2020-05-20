package com.cnlaunch.x431pro.activity.diagnose.p221d;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.cnlaunch.x431pro.activity.diagnose.p222e.OnDiagnoseDataUpdateListenter;
import com.ifoer.expedition.pro.R;

/* renamed from: com.cnlaunch.x431pro.activity.diagnose.d.l */
/* loaded from: classes.dex */
public final class AgingWindowFragment extends BaseDiagnoseFragment implements OnDiagnoseDataUpdateListenter {

    /* renamed from: a */
    private String f12347a = "";

    /* renamed from: b */
    private TextView f12348b;

    @Override // com.cnlaunch.x431pro.activity.diagnose.p221d.BaseDiagnoseFragment, android.app.Fragment
    public final void onAttach(Activity activity) {
        super.onAttach(activity);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.f12347a = arguments.getString("ArgingContent");
        }
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p221d.BaseDiagnoseFragment, com.cnlaunch.x431pro.activity.BaseFragment, android.app.Fragment
    public final void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.f12348b = (TextView) getActivity().findViewById(R.id.tv_datashow);
        this.f12348b.setText(this.f12347a);
        this.f12357d.mo7097a((OnDiagnoseDataUpdateListenter) this);
        this.f12357d.mo7083i().setSubTitle(getString(R.string.fragment_title_agingwindow));
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment
    public final View onCreateFragmentView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_argingwindow, viewGroup, false);
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p221d.BaseDiagnoseFragment, com.cnlaunch.x431pro.activity.diagnose.p222e.OnDiagnoseDataUpdateListenter
    /* renamed from: a_ */
    public final void mo7074a_(String str) {
        this.f12348b.setText(str);
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p221d.BaseDiagnoseFragment
    /* renamed from: b */
    public final String mo7102b() {
        return getString(R.string.fragment_title_agingwindow);
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p221d.BaseDiagnoseFragment
    /* renamed from: c */
    public final String mo7100c() {
        if (TextUtils.isEmpty(this.f12347a)) {
            return super.mo7100c();
        }
        return this.f12347a;
    }
}
