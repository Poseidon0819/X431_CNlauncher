package com.cnlaunch.x431pro.activity.golo.others;

import android.content.Context;
import android.os.AsyncTask;
import com.cnlaunch.p120d.p125c.p128c.C1425f;
import com.cnlaunch.p120d.p130d.NToast;
import com.cnlaunch.x431pro.module.golo.p262a.FriendAction;
import com.cnlaunch.x431pro.module.p241a.BaseResponse;
import com.cnlaunch.x431pro.widget.p290a.LoadDialog;
import com.ifoer.expedition.pro.R;

/* renamed from: com.cnlaunch.x431pro.activity.golo.others.g */
/* loaded from: classes.dex */
public final class OrderAsyncTask extends AsyncTask<String, Integer, Object> {

    /* renamed from: a */
    private Context f12681a;

    public OrderAsyncTask(Context context) {
        this.f12681a = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // android.os.AsyncTask
    /* renamed from: a */
    public Object doInBackground(String... strArr) {
        if (strArr != null && strArr.length > 0) {
            try {
                return new FriendAction(this.f12681a).m5325a(strArr[0], strArr.length > 1 ? strArr[1] : null);
            } catch (C1425f e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override // android.os.AsyncTask
    protected final void onPostExecute(Object obj) {
        super.onPostExecute(obj);
        LoadDialog.m4681b(this.f12681a);
        if (obj == null) {
            NToast.m9447b(this.f12681a, (int) R.string.order_tip_fail);
            return;
        }
        BaseResponse baseResponse = (BaseResponse) obj;
        if (baseResponse.getCode() == 0) {
            NToast.m9447b(this.f12681a, (int) R.string.order_tip_success);
        } else if (baseResponse.getCode() == -1) {
            NToast.m9447b(this.f12681a, (int) R.string.order_tip_repeat);
        } else if (baseResponse.getCode() == -20) {
            NToast.m9447b(this.f12681a, (int) R.string.order_tip_wait);
        } else {
            NToast.m9447b(this.f12681a, (int) R.string.order_tip_fail);
        }
    }
}
