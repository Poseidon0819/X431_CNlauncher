package com.cnlaunch.x431pro.activity.diagnose.p222e;

import android.app.Fragment;
import com.cnlaunch.p181j.RemotePerformClick;
import com.cnlaunch.x431pro.module.p252d.p254b.DiagnoseRunningInfo;
import com.cnlaunch.x431pro.module.p252d.p254b.RemoteDiagRunningInfo;
import java.util.ArrayList;

/* renamed from: com.cnlaunch.x431pro.activity.diagnose.e.a */
/* loaded from: classes.dex */
public interface IFragmentCallback {
    /* renamed from: a */
    void mo7099a(int i, byte[] bArr);

    /* renamed from: a */
    void mo7098a(Fragment fragment, String str, boolean z);

    /* renamed from: a */
    void mo7097a(OnDiagnoseDataUpdateListenter onDiagnoseDataUpdateListenter);

    /* renamed from: a */
    void mo7096a(OnKeyDownListenter onKeyDownListenter);

    /* renamed from: a */
    void mo7095a(DiagnoseRunningInfo diagnoseRunningInfo);

    /* renamed from: a */
    void mo7094a(String str, String str2);

    /* renamed from: a */
    void mo7093a(String str, String str2, int i);

    /* renamed from: a */
    void mo7092a(String str, String str2, int i, int i2);

    /* renamed from: a */
    void mo7091a(String str, String str2, String str3, String str4);

    /* renamed from: a */
    void mo7090a(String str, ArrayList<String> arrayList);

    /* renamed from: a */
    void mo7089a(String str, byte[] bArr);

    /* renamed from: b */
    void mo7088b(String str, String str2);

    /* renamed from: b */
    void mo7087b(boolean z);

    /* renamed from: c */
    int mo7086c(String str);

    /* renamed from: f */
    void mo7085f(int i);

    /* renamed from: h */
    void mo7084h();

    /* renamed from: i */
    DiagnoseRunningInfo mo7083i();

    /* renamed from: j */
    void mo7082j();

    /* renamed from: k */
    RemoteDiagRunningInfo mo7081k();

    /* renamed from: l */
    RemotePerformClick mo7080l();
}
