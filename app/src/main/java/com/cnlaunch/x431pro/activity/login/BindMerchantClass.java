package com.cnlaunch.x431pro.activity.login;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.cnlaunch.diagnosemodule.wiget.NToast;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.p120d.p125c.p128c.C1425f;
import com.cnlaunch.x431pro.activity.p213b.p214a.SellerAction;
import com.cnlaunch.x431pro.module.p241a.CommonResponse;
import com.ifoer.expedition.pro.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.cnlaunch.x431pro.activity.login.f */
/* loaded from: classes.dex */
public final class BindMerchantClass extends NetworkBase {

    /* renamed from: h */
    private static List<Object> f13483h = new ArrayList();

    /* renamed from: a */
    Handler f13484a;

    /* renamed from: b */
    private SellerAction f13485b;

    /* renamed from: c */
    private String f13486c;

    /* renamed from: e */
    private String f13487e;

    /* renamed from: f */
    private String f13488f;

    /* renamed from: g */
    private String f13489g;

    public BindMerchantClass(Context context) {
        super(context);
        this.f13485b = new SellerAction(this.f13412d);
    }

    /* renamed from: a */
    public final void m6538a(String str, String str2) {
        this.f13486c = str;
        this.f13487e = str2;
        this.f13488f = PreferencesManager.m9595a(this.f13412d).m9591a("login_username");
        this.f13489g = PreferencesManager.m9595a(this.f13412d).m9591a("login_password");
        m6553a(201);
    }

    @Override // com.cnlaunch.x431pro.activity.login.NetworkBase, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public final Object doInBackground(int i) throws C1425f {
        if (i == 201) {
            return this.f13485b.m7807a(this.f13486c, this.f13487e, this.f13488f, this.f13489g);
        }
        return super.doInBackground(i);
    }

    @Override // com.cnlaunch.x431pro.activity.login.NetworkBase, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public final void onSuccess(int i, Object obj) {
        if (i == 201 && obj != null) {
            CommonResponse commonResponse = (CommonResponse) obj;
            if (commonResponse.getCode() == 0) {
                this.f13484a.sendEmptyMessage(0);
                NToast.shortToast(this.f13412d, (int) R.string.regist_merchant_bind_succese);
            } else {
                Message message2 = new Message();
                message2.what = -1;
                message2.arg1 = commonResponse.getCode();
                this.f13484a.sendMessage(message2);
                int code = commonResponse.getCode();
                if (code == -1) {
                    NToast.shortToast(this.f13412d, (int) R.string.regist_merchant_bind_failed);
                } else {
                    switch (code) {
                        case -1003:
                            NToast.shortToast(this.f13412d, (int) R.string.regist_merchant_bind_failed);
                            break;
                        case -1002:
                            NToast.shortToast(this.f13412d, (int) R.string.regist_merchant_bind_PRO_EXIST);
                            break;
                        case -1001:
                            NToast.shortToast(this.f13412d, (int) R.string.regist_merchant_bind_PRO_UID_INVALID);
                            break;
                        default:
                            switch (code) {
                                case 2:
                                    NToast.shortToast(this.f13412d, (int) R.string.regist_merchant_bind_PRO_NOT_BIND_SN);
                                    break;
                                case 3:
                                    NToast.shortToast(this.f13412d, (int) R.string.regist_merchant_bind_PRO_NOT_TECH);
                                    break;
                                case 4:
                                    NToast.shortToast(this.f13412d, (int) R.string.regist_merchant_bind_PRO_USERNAME_INVALID);
                                    break;
                                case 5:
                                    NToast.shortToast(this.f13412d, (int) R.string.regist_merchant_bind_PRO_USERPASSWORD_INCORRECT);
                                    break;
                                case 6:
                                    NToast.shortToast(this.f13412d, (int) R.string.regist_merchant_bind_PRO_HAD_BOUND);
                                    break;
                                default:
                                    switch (code) {
                                        case 100002:
                                            NToast.shortToast(this.f13412d, (int) R.string.regist_merchant_bind_merchant_not_exist);
                                            break;
                                        case 100003:
                                            NToast.shortToast(this.f13412d, (int) R.string.regist_merchant_bind_merchant_password_incorrect);
                                            break;
                                        default:
                                            NToast.shortToast(this.f13412d, this.f13412d.getString(R.string.default_error, String.valueOf(code)));
                                            break;
                                    }
                            }
                    }
                }
            }
        }
        super.onSuccess(i, obj);
    }

    @Override // com.cnlaunch.x431pro.activity.login.NetworkBase, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public final void onFailure(int i, int i2, Object obj) {
        if (i == 201) {
            Iterator<Object> it = f13483h.iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
        super.onFailure(i, i2, obj);
    }
}
