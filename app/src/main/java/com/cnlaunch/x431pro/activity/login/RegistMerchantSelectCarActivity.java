package com.cnlaunch.x431pro.activity.login;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.ExpandableListView;
import android.widget.TextView;
import com.cnlaunch.diagnosemodule.wiget.NToast;
import com.cnlaunch.p120d.p125c.p128c.C1425f;
import com.cnlaunch.x431pro.activity.ActivityC2004c;
import com.cnlaunch.x431pro.activity.p213b.p214a.SellerAction;
import com.cnlaunch.x431pro.activity.p213b.p215b.CarSeriesInfo;
import com.cnlaunch.x431pro.activity.p213b.p215b.CarSeriesResponse;
import com.cnlaunch.x431pro.utils.C2744aa;
import com.cnlaunch.x431pro.widget.p290a.LoadDialog;
import com.ifoer.expedition.pro.R;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* loaded from: classes.dex */
public class RegistMerchantSelectCarActivity extends ActivityC2004c {

    /* renamed from: C */
    private TextView f13317C;

    /* renamed from: D */
    private String f13318D = "1002";

    /* renamed from: E */
    private String f13319E = "1";

    /* renamed from: F */
    private List<CarSeriesInfo> f13320F;

    /* renamed from: G */
    private CarSeriesAdapter f13321G;

    /* renamed from: H */
    private ArrayList<String> f13322H;

    /* renamed from: n */
    private ExpandableListView f13323n;

    @Override // com.cnlaunch.x431pro.activity.ActivityC2004c, android.support.p012v4.app.FragmentActivity, android.support.p012v4.app.BaseFragmentActivityGingerbread, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_registmerchant_regist_selectcar);
        this.f13323n = (ExpandableListView) findViewById(R.id.listview_car);
        this.f13317C = (TextView) findViewById(R.id.text_confirm);
        this.f13317C.setOnClickListener(new View$OnClickListenerC2353by(this));
        LoadDialog.m4684a(this.f10981q, this.f10981q.getString(R.string.refresh_txt));
        m7743b();
        Intent intent = getIntent();
        if (intent != null) {
            this.f13322H = intent.getStringArrayListExtra("selectCarSeriesList");
        }
        this.f13318D = Locale.getDefault().getLanguage().toString().startsWith("zh") ? "cn" : "en";
        if (C2744aa.m5125r()) {
            this.f13319E = "0";
        } else {
            this.f13319E = "1";
        }
        m7739c(10086);
    }

    @Override // com.cnlaunch.x431pro.activity.ActivityC2004c, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public Object doInBackground(int i) throws C1425f {
        if (i == 10086) {
            return new SellerAction(this.f10981q).m7808a(this.f13318D, this.f13319E);
        }
        return super.doInBackground(i);
    }

    @Override // com.cnlaunch.x431pro.activity.ActivityC2004c, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public void onSuccess(int i, Object obj) {
        super.onSuccess(i, obj);
        if (i != 10086) {
            return;
        }
        LoadDialog.m4681b(this.f10981q);
        if (obj != null) {
            CarSeriesResponse carSeriesResponse = (CarSeriesResponse) obj;
            if (carSeriesResponse.getCode() == 0) {
                this.f13320F = carSeriesResponse.getData();
                this.f13321G = new CarSeriesAdapter(this.f10981q, this.f13320F);
                ArrayList<String> arrayList = this.f13322H;
                if (arrayList != null && arrayList.size() != 0) {
                    for (int i2 = 0; i2 < this.f13320F.size(); i2++) {
                        for (int i3 = 0; i3 < this.f13322H.size(); i3++) {
                            if (this.f13320F.get(i2).getCarSeriesName().equals(this.f13322H.get(i3))) {
                                CarSeriesAdapter.m6537a().put(Integer.valueOf(i2), Boolean.TRUE);
                            }
                        }
                    }
                    this.f13321G.notifyDataSetChanged();
                }
                this.f13323n.setAdapter(this.f13321G);
            } else if (carSeriesResponse.getMessage() != null && !"".equals(carSeriesResponse.getMessage())) {
                NToast.shortToast(this.f10981q, carSeriesResponse.getMessage());
            }
        }
    }

    @Override // com.cnlaunch.x431pro.activity.ActivityC2004c, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public void onFailure(int i, int i2, Object obj) {
        super.onFailure(i, i2, obj);
        if (i != 10086) {
            return;
        }
        LoadDialog.m4681b(this.f10981q);
    }

    @Override // com.cnlaunch.x431pro.activity.ActivityC2004c, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getAction() == 0) {
            finish();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.cnlaunch.x431pro.activity.ActivityC2004c, android.support.p012v4.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }
}
