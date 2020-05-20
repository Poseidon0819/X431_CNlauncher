package com.cnlaunch.x431pro.activity.mine.p230b;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.cnlaunch.diagnosemodule.bean.BasicDataStreamBean;
import com.cnlaunch.p120d.p130d.NLog;
import com.cnlaunch.x431pro.activity.ActivityC2004c;
import com.cnlaunch.x431pro.activity.mine.p231c.VoltageDataStreamGraph;
import com.cnlaunch.x431pro.module.p252d.p254b.SerializableMap;
import com.cnlaunch.x431pro.utils.C2744aa;
import com.cnlaunch.x431pro.utils.p280b.MeasureConversion;
import com.ifoer.expedition.pro.R;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.cnlaunch.x431pro.activity.mine.b.v */
/* loaded from: classes.dex */
public class ReplayVoltageFragment extends BaseDataStreamReplayFragment {

    /* renamed from: c */
    private static final String f13905c = "com.cnlaunch.x431pro.activity.mine.b.v";

    /* renamed from: d */
    private RelativeLayout f13906d;

    /* renamed from: e */
    private VoltageDataStreamGraph f13907e;

    /* renamed from: f */
    private TextView f13908f;

    @Override // com.cnlaunch.x431pro.activity.mine.p230b.BaseDataStreamReplayFragment, com.cnlaunch.x431pro.activity.BaseFragment, android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        this.mContext = getActivity();
        this.f13906d = (RelativeLayout) getActivity().findViewById(R.id.rl_large_graph);
        this.f13907e = new VoltageDataStreamGraph(this.mContext, this.f13906d);
        this.f13908f = (TextView) getActivity().findViewById(R.id.tv_vehicle_voltage_value);
        super.onActivityCreated(bundle);
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment
    public View onCreateFragmentView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_replay_voltage, viewGroup, false);
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p220c.DataStreamObserver
    /* renamed from: a */
    public final void mo6296a(long j, List<ArrayList<BasicDataStreamBean>> list, List<BasicDataStreamBean> list2, SerializableMap serializableMap) {
        if (list == null || list.size() <= 0 || list2 == null || list2.size() <= 0) {
            NLog.m9452b(f13905c, "null");
            return;
        }
        MeasureConversion.m5099a(C2744aa.m5158d(this.mContext), list.get(0));
        String str = f13905c;
        NLog.m9452b(str, "times: " + j + "  stream  " + list.get(0).size() + "  " + list.get(0).get(0).getDbValue());
        this.f13907e.m6256a(j, list.get(0));
        TextView textView = this.f13908f;
        StringBuilder sb = new StringBuilder();
        sb.append(list.get(0).get(list.get(0).size() - 1).getValue());
        sb.append("V");
        textView.setText(sb.toString());
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        ((ActivityC2004c) getActivity()).m7732g().setTouchModeAbove(2);
    }

    @Override // com.cnlaunch.x431pro.activity.mine.p230b.BaseDataStreamReplayFragment, android.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
    }
}
