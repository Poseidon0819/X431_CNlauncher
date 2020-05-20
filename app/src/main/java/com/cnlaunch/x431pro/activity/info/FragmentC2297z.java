package com.cnlaunch.x431pro.activity.info;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.mapapi.UIMsg;
import com.cnlaunch.diagnosemodule.wiget.LoadDialog;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.p120d.p125c.p128c.C1425f;
import com.cnlaunch.p120d.p130d.NToast;
import com.cnlaunch.x431pro.activity.BaseFragment;
import com.cnlaunch.x431pro.activity.info.CyUtil;
import com.cnlaunch.x431pro.activity.pay.PlaceOrderActivity;
import com.cnlaunch.x431pro.module.p258f.p259a.PayAction;
import com.cnlaunch.x431pro.module.p258f.p260b.CyOrderInfo;
import com.cnlaunch.x431pro.module.p258f.p260b.CyOrderListResponse;
import com.cnlaunch.x431pro.module.p258f.p260b.CyOrderListResult;
import com.cnlaunch.x431pro.module.p258f.p260b.CyResultBase;
import com.cnlaunch.x431pro.module.p258f.p260b.CyUserInfoResponse;
import com.cnlaunch.x431pro.module.p258f.p260b.CyUserInfoResult;
import com.cnlaunch.x431pro.utils.C2787z;
import com.ifoer.expedition.pro.R;
import java.util.List;

/* compiled from: RepairInfoActivityFragment.java */
/* renamed from: com.cnlaunch.x431pro.activity.info.z */
/* loaded from: classes.dex */
public class FragmentC2297z extends BaseFragment {

    /* renamed from: b */
    boolean f12959b;

    /* renamed from: j */
    private boolean f12967j;

    /* renamed from: k */
    private CyUserInfo f12968k;

    /* renamed from: c */
    private final int f12960c = UIMsg.f_FUN.FUN_ID_SCH_POI;

    /* renamed from: d */
    private final int f12961d = UIMsg.f_FUN.FUN_ID_SCH_NAV;

    /* renamed from: e */
    private final int f12962e = 0;

    /* renamed from: f */
    private final int f12963f = 1;

    /* renamed from: g */
    private final int f12964g = 2;

    /* renamed from: h */
    private final int f12965h = 3;

    /* renamed from: i */
    private final int f12966i = 4;

    /* renamed from: a */
    public String f12958a = "";

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        setTitle(R.string.tab_menu_info);
        getActivity().findViewById(R.id.repair_help).setOnClickListener(new RepairInfoActivityFragment(this));
        getActivity().findViewById(R.id.ll_repair_info).setVisibility(CyUtil.m6851a() ? 0 : 8);
        if (CyUtil.m6851a()) {
            getActivity().findViewById(R.id.cy_info).setOnClickListener(new View$OnClickListenerC2270ab(this));
            getActivity().findViewById(R.id.query_renew).setOnClickListener(new View$OnClickListenerC2271ac(this));
        }
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment
    public View onCreateFragmentView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_repair_info, viewGroup, false);
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public Object doInBackground(int i) throws C1425f {
        try {
            switch (i) {
                case UIMsg.f_FUN.FUN_ID_SCH_POI /* 1101 */:
                    this.f12967j = false;
                    this.f12968k = null;
                    return new PayAction(this.mContext).m5341h(CyUtil.C2276a.m6849a());
                case UIMsg.f_FUN.FUN_ID_SCH_NAV /* 1102 */:
                    return new PayAction(this.mContext).m5340i(CyUtil.C2276a.m6849a());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return super.doInBackground(i);
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public void onSuccess(int i, Object obj) {
        switch (i) {
            case UIMsg.f_FUN.FUN_ID_SCH_POI /* 1101 */:
                LoadDialog.dismiss(this.mContext);
                if (obj != null) {
                    CyUserInfoResponse cyUserInfoResponse = (CyUserInfoResponse) obj;
                    CyResultBase cyresult = cyUserInfoResponse.getCyresult();
                    if (cyresult != null && cyresult.getCode() == -1) {
                        m6823a(this.mContext, -1);
                        return;
                    }
                    CyUserInfoResult getCyUserResult = cyUserInfoResponse.getGetCyUserResult();
                    if (getCyUserResult != null) {
                        if (getCyUserResult.getCode() == 0) {
                            String m6849a = CyUtil.C2276a.m6849a();
                            String validSerialNo = getCyUserResult.getValidSerialNo();
                            if (!TextUtils.isEmpty(validSerialNo) && !validSerialNo.equals(m6849a)) {
                                CyUtil.C2276a.m6848a(m6849a, validSerialNo);
                                m6815a(this.f12959b);
                                return;
                            }
                            int intValue = getCyUserResult.getUserType().intValue();
                            if (this.f12959b) {
                                if (intValue == 3) {
                                    this.f12967j = true;
                                    this.f12968k = new CyUserInfo(CyUtil.C2276a.m6849a(), getCyUserResult.getPassword(), getCyUserResult.getBeginTime(), getCyUserResult.getEndTime());
                                    request(UIMsg.f_FUN.FUN_ID_SCH_NAV, true);
                                    return;
                                }
                                m6816a(getString(R.string.dialog_title_default), getCyUserResult.getToken(), CyUtil.C2276a.m6849a(), getString(R.string.cy_query_and_renew_tip_cant_enter), true);
                                return;
                            }
                            switch (intValue) {
                                case 0:
                                    m6816a(getString(R.string.cy_trial_new), getCyUserResult.getToken(), CyUtil.C2276a.m6849a(), getString(R.string.cy_trial_tips), false);
                                    break;
                                case 1:
                                    m6817a(getCyUserResult.getToken(), CyUtil.C2276a.m6849a());
                                    break;
                                case 2:
                                    m6816a(getString(R.string.cy_usetime_end), getCyUserResult.getToken(), CyUtil.C2276a.m6849a(), getString(R.string.cy_trial_end_tips), true);
                                    break;
                                case 3:
                                    m6817a(getCyUserResult.getToken(), CyUtil.C2276a.m6849a());
                                    break;
                                case 4:
                                    m6816a(getString(R.string.cy_usetime_end), getCyUserResult.getToken(), CyUtil.C2276a.m6849a(), getString(R.string.cy_usetime_end_tips), true);
                                    break;
                            }
                            PreferencesManager.m9595a(this.mContext).m9588a("launchToken", getCyUserResult.getToken());
                            return;
                        }
                        m6823a(this.mContext, getCyUserResult.getCode());
                        return;
                    }
                    return;
                }
                return;
            case UIMsg.f_FUN.FUN_ID_SCH_NAV /* 1102 */:
                LoadDialog.dismiss(this.mContext);
                if (obj != null) {
                    CyOrderListResult cyOrderInfoListResult = ((CyOrderListResponse) obj).getCyOrderInfoListResult();
                    if (cyOrderInfoListResult.getCode() == 0) {
                        List<CyOrderInfo> cyOrderInfoList = cyOrderInfoListResult.getCyOrderInfoList();
                        if (cyOrderInfoList == null || cyOrderInfoList.size() == 0) {
                            return;
                        }
                        boolean z = false;
                        for (int i2 = 0; i2 < cyOrderInfoList.size(); i2++) {
                            if (cyOrderInfoList.get(i2).getOrderState() == 0) {
                                m6818a(cyOrderInfoList.get(i2).getLaunchOrderNo());
                                z = true;
                            }
                        }
                        if (z) {
                            return;
                        }
                        m6818a((String) null);
                        return;
                    } else if (cyOrderInfoListResult.getCode() == 405) {
                        m6818a((String) null);
                        return;
                    } else {
                        return;
                    }
                }
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m6817a(String str, String str2) {
        CyUtil.m6850a(getActivity(), str2, str);
    }

    /* renamed from: a */
    private void m6818a(String str) {
        CyUserInfo cyUserInfo;
        Intent intent = new Intent();
        if (!TextUtils.isEmpty(str)) {
            intent.putExtra("LaunchOrderNO", str);
        }
        boolean z = this.f12967j;
        if (z) {
            intent.putExtra("isOfficialUser", z);
        }
        if (this.f12959b && (cyUserInfo = this.f12968k) != null) {
            intent.putExtra("cyUserInfo", cyUserInfo);
        }
        intent.setClass(this.mContext, PlaceOrderActivity.class);
        startActivity(intent);
    }

    /* renamed from: a */
    public static void m6823a(Context context, int i) {
        if (i == -1) {
            NToast.m9447b(context, (int) R.string.cy_error_code_tips_token_invalid);
        } else if (i == 405) {
            NToast.m9447b(context, (int) R.string.cy_error_code_tips_405);
        } else if (i == 500) {
            NToast.m9447b(context, (int) R.string.cy_error_code_tips_500);
        } else if (i == 658) {
            NToast.m9447b(context, (int) R.string.cy_error_code_tips_658);
        } else if (i == 662) {
            NToast.m9447b(context, (int) R.string.cy_error_code_tips_662);
        } else if (i == 752) {
            NToast.m9447b(context, (int) R.string.cy_error_code_tips_752);
        } else if (i == 755) {
            NToast.m9447b(context, (int) R.string.cy_error_code_tips_755);
        } else if (i != 789) {
            switch (i) {
                case 401:
                    NToast.m9447b(context, (int) R.string.cy_error_code_tips_401);
                    return;
                case 402:
                    NToast.m9447b(context, (int) R.string.cy_error_code_tips_402);
                    return;
                default:
                    switch (i) {
                        case 832:
                            NToast.m9447b(context, (int) R.string.cy_error_code_tips_832);
                            return;
                        case 833:
                            NToast.m9447b(context, (int) R.string.cy_error_code_tips_833);
                            return;
                        case 834:
                            NToast.m9447b(context, (int) R.string.cy_error_code_tips_834);
                            return;
                        default:
                            return;
                    }
            }
        } else {
            NToast.m9447b(context, (int) R.string.cy_error_code_tips_789);
        }
    }

    /* renamed from: a */
    private void m6816a(String str, String str2, String str3, String str4, boolean z) {
        new DialogC2273ae(this, this.mContext, str, str2, str3).m6058a(str4, z);
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public void onFailure(int i, int i2, Object obj) {
        super.onFailure(i, i2, obj);
        switch (i) {
            case UIMsg.f_FUN.FUN_ID_SCH_POI /* 1101 */:
                LoadDialog.dismiss(this.mContext);
                if (obj != null) {
                    m6823a(this.mContext, ((CyUserInfoResponse) obj).getGetCyUserResult().getCode());
                    return;
                }
                return;
            case UIMsg.f_FUN.FUN_ID_SCH_NAV /* 1102 */:
                LoadDialog.dismiss(this.mContext);
                if (obj != null) {
                    m6823a(this.mContext, ((CyOrderListResponse) obj).getCyOrderInfoListResult().getCode());
                    return;
                }
                return;
            default:
                super.onFailure(i, i2, obj);
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m6815a(boolean z) {
        this.f12959b = z;
        if (C2787z.m4821a(CyUtil.C2276a.m6849a())) {
            NToast.m9447b(this.mContext, (int) R.string.txt_no_connector);
            return;
        }
        LoadDialog.show(this.mContext, getString(R.string.pull_to_refresh_refreshing_label));
        request(UIMsg.f_FUN.FUN_ID_SCH_POI, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static /* synthetic */ void m6821a(FragmentC2297z fragmentC2297z, Context context) {
        DialogC2272ad dialogC2272ad = new DialogC2272ad(fragmentC2297z, context, context);
        dialogC2272ad.m4719a(R.string.btn_confirm, true, null);
        dialogC2272ad.m4578b();
        dialogC2272ad.show();
    }
}
