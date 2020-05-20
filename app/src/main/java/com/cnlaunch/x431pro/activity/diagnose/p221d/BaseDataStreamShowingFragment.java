package com.cnlaunch.x431pro.activity.diagnose.p221d;

import android.app.Activity;
import android.os.Bundle;
import com.cnlaunch.diagnosemodule.bean.BasicDataStreamBean;
import com.cnlaunch.diagnosemodule.utils.DiagnoseConstants;
import com.cnlaunch.x431pro.activity.BaseFragment;
import com.cnlaunch.x431pro.activity.diagnose.p220c.DataStreamManager;
import com.cnlaunch.x431pro.activity.diagnose.p220c.DataStreamObserver;
import com.cnlaunch.x431pro.activity.diagnose.p220c.DataStreamPageObserver;
import com.cnlaunch.x431pro.activity.diagnose.p222e.IFragmentCallback;
import java.util.List;

/* renamed from: com.cnlaunch.x431pro.activity.diagnose.d.m */
/* loaded from: classes.dex */
public abstract class BaseDataStreamShowingFragment extends BaseFragment implements DataStreamObserver {

    /* renamed from: a */
    public static int f12349a = 0;

    /* renamed from: b */
    public static int f12350b = 1;

    /* renamed from: e */
    private static Boolean f12351e = Boolean.FALSE;

    /* renamed from: c */
    protected DataStreamPageObserver f12352c;

    /* renamed from: d */
    protected IFragmentCallback f12353d = null;

    /* renamed from: a */
    public void mo6301a(List<BasicDataStreamBean> list) {
    }

    /* renamed from: b */
    public static void m7127b(boolean z) {
        synchronized (f12351e) {
            f12351e = Boolean.valueOf(z);
        }
    }

    /* renamed from: b */
    public static boolean m7128b() {
        boolean booleanValue;
        synchronized (f12351e) {
            booleanValue = f12351e.booleanValue();
        }
        return booleanValue;
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (DataStreamManager.f11739b != null) {
            DataStreamManager.f11739b.m7389a(this);
            this.f12352c = DataStreamManager.f11739b;
        }
    }

    @Override // android.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            this.f12353d = (IFragmentCallback) activity;
        } catch (ClassCastException unused) {
            this.f12353d = null;
        }
    }

    @Override // android.app.Fragment
    public void onDestroyView() {
        this.f12352c = null;
        DataStreamManager.f11739b.m7384b(this);
        super.onDestroyView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public final void m7130a(int i, int i2) {
        DataStreamPageObserver dataStreamPageObserver = this.f12352c;
        if (dataStreamPageObserver != null) {
            dataStreamPageObserver.mo7357a(i, i2 + i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: c */
    public final void m7126c(int i) {
        DataStreamPageObserver dataStreamPageObserver = this.f12352c;
        if (dataStreamPageObserver != null) {
            dataStreamPageObserver.mo7358a(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public final void m7129a(String str, String str2) {
        IFragmentCallback iFragmentCallback = this.f12353d;
        if (iFragmentCallback != null) {
            iFragmentCallback.mo7091a(DiagnoseConstants.UI_TYPE_DIALOG, "90", str, str2);
        }
    }
}
