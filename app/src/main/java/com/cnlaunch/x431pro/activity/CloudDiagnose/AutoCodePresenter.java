package com.cnlaunch.x431pro.activity.CloudDiagnose;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.cnlaunch.diagnosemodule.utils.DiagnoseConstants;
import com.cnlaunch.p120d.p125c.p128c.C1425f;
import com.cnlaunch.x431pro.module.cloud.model.AutoCode;
import com.cnlaunch.x431pro.module.cloud.p247a.CTSerialAction;
import com.cnlaunch.x431pro.module.p241a.BasePresenter;
import com.cnlaunch.x431pro.module.p241a.PresenterCallback;

/* renamed from: com.cnlaunch.x431pro.activity.CloudDiagnose.a */
/* loaded from: classes.dex */
public final class AutoCodePresenter extends BasePresenter {

    /* renamed from: d */
    private CTSerialAction f10607d;

    /* renamed from: e */
    private String f10608e;

    /* renamed from: f */
    private String f10609f;

    public AutoCodePresenter(Context context) {
        super(context);
    }

    /* renamed from: a */
    public final void m7933a(String str, String str2, PresenterCallback presenterCallback) {
        this.f10608e = str;
        this.f10609f = str2;
        this.f15453c = presenterCallback;
        DiagnoseConstants.RECORD_MODEL = "";
        DiagnoseConstants.RECORD_YEAR = "";
        DiagnoseConstants.RECORD_DISPLACEMENT = "";
        DiagnoseConstants.RECORD_TRANS = "";
        DiagnoseConstants.MARKET_CAR_MODEL = "";
        m5435a();
    }

    /* renamed from: a */
    private void m7934a(int i) {
        if (this.f15453c != null) {
            if (i == -999 || i == -400 || i == -200) {
                this.f15453c.mo5116a(1);
            } else {
                this.f15453c.mo5116a(i);
            }
        }
    }

    @Override // com.cnlaunch.x431pro.module.p241a.BasePresenter, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public final Object doInBackground(int i) throws C1425f {
        if (i != 100) {
            return null;
        }
        if (this.f10607d == null) {
            this.f10607d = new CTSerialAction(this.f15451a);
        }
        return this.f10607d.m5424a(this.f10608e);
    }

    @Override // com.cnlaunch.x431pro.module.p241a.BasePresenter, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public final void onSuccess(int i, Object obj) {
        if (i != 100) {
            return;
        }
        if (obj == null) {
            m7934a(408);
            return;
        }
        AutoCode autoCode = (AutoCode) obj;
        if (autoCode.getCode() == 0) {
            DiagnoseConstants.RECORD_MODEL = autoCode.getDiagCarModel() == null ? "" : autoCode.getDiagCarModel();
            DiagnoseConstants.RECORD_YEAR = autoCode.getYear() == null ? "" : autoCode.getYear();
            DiagnoseConstants.RECORD_DISPLACEMENT = autoCode.getDisplacement() == null ? "" : autoCode.getDisplacement();
            DiagnoseConstants.RECORD_TRANS = autoCode.getGearBox() == null ? "" : autoCode.getGearBox();
            DiagnoseConstants.MARKET_CAR_MODEL = autoCode.getCarModel() == null ? "" : autoCode.getCarModel();
            if (this.f15453c != null) {
                Bundle bundle = new Bundle();
                bundle.putString("autoCode", autoCode.getAutoCode());
                this.f15453c.mo5115a(bundle);
            }
            Log.e("XEE", "AutoCodePresenter 市场车型:" + DiagnoseConstants.MARKET_CAR_MODEL + " 诊断车型:" + DiagnoseConstants.RECORD_MODEL + "  年款:" + DiagnoseConstants.RECORD_YEAR + "  DISPLACEMENT" + DiagnoseConstants.RECORD_DISPLACEMENT + "  RECORD_TRANS" + DiagnoseConstants.RECORD_TRANS);
            return;
        }
        int code = autoCode.getCode();
        autoCode.getError();
        m7934a(code);
    }

    @Override // com.cnlaunch.x431pro.module.p241a.BasePresenter, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public final void onFailure(int i, int i2, Object obj) {
        if (i != 100) {
            return;
        }
        m7934a(i2);
    }
}
