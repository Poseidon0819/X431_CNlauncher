package com.cnlaunch.x431pro.activity.diagnose.p221d;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.cnlaunch.diagnosemodule.bean.BasicDataStreamBean;
import com.cnlaunch.x431pro.activity.diagnose.p218a.ActiveTestShowListAdapter;
import com.cnlaunch.x431pro.activity.diagnose.p220c.IDataStreamSelectionRecorder;
import com.cnlaunch.x431pro.activity.diagnose.p220c.IDataStreamSelector;
import com.cnlaunch.x431pro.module.p252d.p254b.SerializableMap;
import com.cnlaunch.x431pro.utils.C2744aa;
import com.cnlaunch.x431pro.utils.p280b.MeasureConversion;
import com.ifoer.expedition.pro.R;
import java.util.ArrayList;
import java.util.List;

@SuppressLint({"ValidFragment"})
/* renamed from: com.cnlaunch.x431pro.activity.diagnose.d.k */
/* loaded from: classes.dex */
public class ActiveTextListFragment extends BaseDataStreamShowingFragment implements AdapterView.OnItemClickListener, IDataStreamSelector {

    /* renamed from: e */
    private IDataStreamSelectionRecorder f12341e;

    /* renamed from: g */
    private ArrayList<BasicDataStreamBean> f12343g;

    /* renamed from: h */
    private ActiveTestShowListAdapter f12344h;

    /* renamed from: f */
    private ListView f12342f = null;

    /* renamed from: i */
    private String f12345i = "";

    /* renamed from: j */
    private int f12346j = -1;

    @Override // com.cnlaunch.x431pro.activity.diagnose.p221d.BaseDataStreamShowingFragment, android.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.f12345i = arguments.getString("ActiveTestType");
            this.f12343g = (ArrayList) arguments.getSerializable("ActiveValueList");
            this.f12344h = new ActiveTestShowListAdapter(this.f12345i, this.f12343g, getActivity());
        }
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p221d.BaseDataStreamShowingFragment, com.cnlaunch.x431pro.activity.BaseFragment, android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.f12342f = (ListView) getActivity().findViewById(R.id.listview_activetest);
        m7131a();
    }

    /* renamed from: a */
    private void m7131a() {
        ListView listView = this.f12342f;
        if (listView != null) {
            listView.setAdapter((ListAdapter) this.f12344h);
            this.f12342f.setOnItemClickListener(this);
        }
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        ActiveTestShowListAdapter activeTestShowListAdapter = this.f12344h;
        if (!activeTestShowListAdapter.f11239a.get(i).equals("")) {
            activeTestShowListAdapter.f11241c = i;
            activeTestShowListAdapter.notifyDataSetChanged();
        }
        this.f12346j = i;
        ActiveTestShowListAdapter activeTestShowListAdapter2 = this.f12344h;
        activeTestShowListAdapter2.f11241c = i;
        activeTestShowListAdapter2.notifyDataSetChanged();
        IDataStreamSelectionRecorder iDataStreamSelectionRecorder = this.f12341e;
        if (iDataStreamSelectionRecorder != null) {
            iDataStreamSelectionRecorder.mo6399a(this.f12344h.m7525a());
            this.f12341e.mo6396b(i);
        }
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        IDataStreamSelectionRecorder iDataStreamSelectionRecorder = this.f12341e;
        if (iDataStreamSelectionRecorder != null) {
            iDataStreamSelectionRecorder.mo6404a((IDataStreamSelector) null);
        }
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p220c.DataStreamObserver
    /* renamed from: a */
    public final void mo6296a(long j, List<ArrayList<BasicDataStreamBean>> list, List<BasicDataStreamBean> list2, SerializableMap serializableMap) {
        ActiveTestShowListAdapter activeTestShowListAdapter = this.f12344h;
        activeTestShowListAdapter.f11242d = serializableMap;
        activeTestShowListAdapter.f11239a = MeasureConversion.m5099a(C2744aa.m5158d(activeTestShowListAdapter.f11240b), list2);
        activeTestShowListAdapter.notifyDataSetChanged();
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p220c.IDataStreamSelector
    /* renamed from: a */
    public final void mo6310a(IDataStreamSelectionRecorder iDataStreamSelectionRecorder) {
        this.f12341e = iDataStreamSelectionRecorder;
        IDataStreamSelectionRecorder iDataStreamSelectionRecorder2 = this.f12341e;
        if (iDataStreamSelectionRecorder2 != null) {
            iDataStreamSelectionRecorder2.mo6404a(this);
        }
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p220c.IDataStreamSelector
    /* renamed from: a */
    public final void mo6308a(boolean z) {
        ActiveTestShowListAdapter activeTestShowListAdapter = this.f12344h;
        if (activeTestShowListAdapter.f11244f != null && activeTestShowListAdapter.f11244f.size() > 0) {
            for (int i = 0; i < activeTestShowListAdapter.f11244f.size(); i++) {
                activeTestShowListAdapter.f11244f.set(i, Boolean.valueOf(z));
            }
            activeTestShowListAdapter.notifyDataSetChanged();
        }
        IDataStreamSelectionRecorder iDataStreamSelectionRecorder = this.f12341e;
        if (iDataStreamSelectionRecorder != null) {
            iDataStreamSelectionRecorder.mo6399a(this.f12344h.m7525a());
        }
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment
    public View onCreateFragmentView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_active_text_list, viewGroup, false);
    }

    @Override // android.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        m7131a();
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        this.f12342f.requestFocus();
        int i = this.f12346j;
        if (i >= 0) {
            this.f12342f.setSelection(i);
        }
        ActiveTestShowListAdapter activeTestShowListAdapter = this.f12344h;
        if (activeTestShowListAdapter != null) {
            try {
                activeTestShowListAdapter.f11239a = MeasureConversion.m5099a(C2744aa.m5158d(activeTestShowListAdapter.f11240b), activeTestShowListAdapter.f11239a);
                activeTestShowListAdapter.notifyDataSetChanged();
            } catch (Exception e) {
                e.printStackTrace();
                Log.e("Sanda", "reUpdateList:" + e.getMessage());
            }
        }
    }
}
