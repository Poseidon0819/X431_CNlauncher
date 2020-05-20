package com.cnlaunch.x431pro.activity.CloudDiagnose;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.cnlaunch.diagnosemodule.utils.DiagnoseConstants;
import com.cnlaunch.p120d.p125c.p128c.C1425f;
import com.cnlaunch.p120d.p130d.NLog;
import com.cnlaunch.p120d.p130d.NToast;
import com.cnlaunch.x431pro.activity.BaseFragment;
import com.cnlaunch.x431pro.activity.golo.p225b.InfaceFragmentParent;
import com.cnlaunch.x431pro.activity.golo.p225b.OnActivityResultListenter;
import com.cnlaunch.x431pro.module.cloud.model.PlateResponse;
import com.cnlaunch.x431pro.module.cloud.p247a.CloudAction;
import com.cnlaunch.x431pro.p210a.FragmentKeyDownListener;
import com.cnlaunch.x431pro.utils.C2744aa;
import com.cnlaunch.x431pro.widget.p290a.LoadDialog;
import com.ifoer.expedition.pro.R;

/* renamed from: com.cnlaunch.x431pro.activity.CloudDiagnose.s */
/* loaded from: classes.dex */
public class VINPlateScanFragment extends BaseFragment implements FragmentKeyDownListener.InterfaceC1949a, OnActivityResultListenter {

    /* renamed from: a */
    public static int f10682a = 0;

    /* renamed from: b */
    public static int f10683b = 1;

    /* renamed from: c */
    private InfaceFragmentParent f10684c = null;

    /* renamed from: d */
    private final int f10685d = 769;

    /* renamed from: e */
    private final int f10686e = 770;

    /* renamed from: f */
    private final int f10687f = 771;

    /* renamed from: g */
    private String f10688g;

    /* renamed from: h */
    private String f10689h;

    /* renamed from: i */
    private String f10690i;

    /* renamed from: j */
    private String f10691j;

    /* renamed from: k */
    private String f10692k;

    @Override // com.cnlaunch.x431pro.activity.golo.p225b.OnActivityResultListenter
    /* renamed from: a */
    public final long mo5997a() {
        return 0L;
    }

    @Override // com.cnlaunch.x431pro.activity.golo.p225b.OnActivityResultListenter
    /* renamed from: a */
    public final boolean mo5995a(KeyEvent keyEvent) {
        return false;
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, com.cnlaunch.x431pro.activity.golo.p225b.OnGoloKeyDownListener
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return false;
    }

    /* renamed from: a */
    private void m7913a(int i, int i2) {
        int i3;
        String str = "com.cnlaunch.x431pro.scanner";
        String str2 = "com.cnlaunch.x431pro.scanner.activity.CaptureActivity";
        if (i2 == f10682a) {
            str = "com.cnlaunch.x431pro.scanner.vin";
            str2 = "com.cnlaunch.x431pro.scanner.vin.activity.CaptureActivity";
            i3 = R.string.vin_scanapk;
        } else {
            i3 = R.string.license_plate_scanapk;
        }
        if (!C2744aa.m5185a(this.mContext, str)) {
            C2744aa.m5165c(getActivity(), getActivity().getString(i3));
            CloudActivity.f10610n = true;
            return;
        }
        ComponentName componentName = new ComponentName(str, str2);
        try {
            Intent intent = new Intent();
            intent.setComponent(componentName);
            getActivity().startActivityForResult(intent, i);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        CloudActivity.f10610n = false;
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment
    public View onCreateFragmentView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_scan_vin_plate, viewGroup, false);
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        try {
            this.f10684c = (InfaceFragmentParent) getActivity();
            if (this.f10684c != null) {
                this.f10684c.mo6035a(this);
            }
        } catch (Exception e) {
            NLog.m9451c("XEE", "infaceFragmentParent Error:" + e.toString());
        }
        setTitle(R.string.text_cloud_diagnose);
        this.f10688g = "";
        this.f10689h = "";
        this.f10690i = "";
        this.f10691j = "";
        this.f10692k = "";
        DiagnoseConstants.LICENSEPLATE = "";
        Bundle bundle2 = getBundle();
        if (bundle2 != null) {
            int i = bundle2.getInt("scan_type");
            this.f10690i = bundle2.getString("brand");
            this.f10691j = bundle2.getString("year");
            this.f10688g = bundle2.getString("vin");
            this.f10692k = bundle2.getString("package_id");
            int i2 = f10683b;
            if (i == i2) {
                m7913a(770, i2);
                return;
            }
        }
        m7913a(769, f10682a);
    }

    @Override // com.cnlaunch.x431pro.activity.golo.p225b.OnActivityResultListenter
    /* renamed from: a */
    public final void mo5996a(int i, int i2, Intent intent) {
        switch (i) {
            case 769:
                if (i2 != -1) {
                    if (i2 == 0) {
                        CloudActivity.f10610n = true;
                        return;
                    }
                    return;
                }
                Bundle extras = intent.getExtras();
                if (extras != null) {
                    this.f10688g = extras.getString("result");
                    LoadDialog.m4680b(this.mContext, this.mContext.getString(R.string.get_plate_by_vin));
                    request(771);
                    return;
                }
                return;
            case 770:
                if (i2 != -1) {
                    if (i2 == 0) {
                        m7912b();
                        return;
                    }
                    return;
                }
                Bundle extras2 = intent.getExtras();
                if (extras2 != null) {
                    this.f10689h = extras2.getString("result");
                    DiagnoseConstants.LICENSEPLATE = this.f10689h;
                    m7912b();
                    return;
                }
                return;
            default:
                return;
        }
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public Object doInBackground(int i) throws C1425f {
        if (i == 771) {
            return new CloudAction(this.mContext).m5422a(this.f10688g);
        }
        return super.doInBackground(i);
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public void onSuccess(int i, Object obj) {
        if (i != 771) {
            return;
        }
        LoadDialog.m4681b(this.mContext);
        if (isAdded()) {
            PlateResponse plateResponse = (PlateResponse) obj;
            if (plateResponse != null && plateResponse.getData() != null) {
                this.f10689h = plateResponse.getData().getPlate_number();
                NLog.m9452b("XEE", "网络查询到的车牌:" + this.f10689h);
                this.f10691j = plateResponse.getData().getModel_years();
                this.f10690i = plateResponse.getData().getModels();
                DiagnoseConstants.LICENSEPLATE = this.f10689h;
            }
            if (TextUtils.isEmpty(this.f10689h)) {
                m7913a(770, f10683b);
            } else {
                m7912b();
            }
        }
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public void onFailure(int i, int i2, Object obj) {
        if (i == 771) {
            LoadDialog.m4681b(this.mContext);
            m7913a(770, f10683b);
            return;
        }
        super.onFailure(i, i2, obj);
        NToast.m9450a(this.mContext, (int) R.string.network_ineffective);
    }

    /* renamed from: b */
    private void m7912b() {
        Bundle bundle = new Bundle();
        bundle.putString("vin", this.f10688g);
        bundle.putString("plate", this.f10689h);
        bundle.putString("brand", this.f10690i);
        bundle.putString("year", this.f10691j);
        bundle.putString("package_id", this.f10692k);
        deleteAndAddFragment(CloudHistoryFragment.class.getName(), bundle);
    }
}
