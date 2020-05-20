package com.cnlaunch.x431pro.activity.mine.p230b;

import android.app.Activity;
import android.os.Bundle;
import com.cnlaunch.diagnosemodule.bean.BasicDataStreamBean;
import com.cnlaunch.diagnosemodule.utils.DiagnoseConstants;
import com.cnlaunch.x431pro.activity.BaseFragment;
import com.cnlaunch.x431pro.activity.diagnose.p220c.DataStreamObserver;
import com.cnlaunch.x431pro.activity.diagnose.p220c.DataStreamPageObserver;
import com.cnlaunch.x431pro.activity.diagnose.p220c.ReplayDataStreamManager;
import com.cnlaunch.x431pro.activity.diagnose.p222e.IFragmentCallback;
import java.util.List;

/* renamed from: com.cnlaunch.x431pro.activity.mine.b.a */
/* loaded from: classes.dex */
public abstract class BaseDataStreamReplayFragment extends BaseFragment implements DataStreamObserver {

    /* renamed from: a */
    protected DataStreamPageObserver f13727a;

    /* renamed from: b */
    protected IFragmentCallback f13728b = null;

    @Override // com.cnlaunch.x431pro.activity.diagnose.p220c.DataStreamObserver
    /* renamed from: a */
    public void mo6301a(List<BasicDataStreamBean> list) {
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        ReplayDataStreamManager.f11779b.m7356a(this);
        this.f13727a = ReplayDataStreamManager.f11779b;
    }

    @Override // android.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            this.f13728b = (IFragmentCallback) activity;
        } catch (ClassCastException unused) {
            this.f13728b = null;
        }
    }

    @Override // android.app.Fragment
    public void onDestroyView() {
        this.f13727a = null;
        ReplayDataStreamManager.f11779b.m7351b(this);
        super.onDestroyView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: c */
    public final void m6408c(int i) {
        DataStreamPageObserver dataStreamPageObserver = this.f13727a;
        if (dataStreamPageObserver != null) {
            dataStreamPageObserver.mo7358a(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public final void m6409a(String str, String str2) {
        IFragmentCallback iFragmentCallback = this.f13728b;
        if (iFragmentCallback != null) {
            iFragmentCallback.mo7091a(DiagnoseConstants.UI_TYPE_DIALOG, "90", str, str2);
        }
    }
}
