package com.cnlaunch.x431pro.activity.mine;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.cnlaunch.p120d.p125c.p128c.C1425f;
import com.cnlaunch.p120d.p130d.NToast;
import com.cnlaunch.x431pro.activity.BaseFragment;
import com.cnlaunch.x431pro.module.p255e.p256a.PincardAction;
import com.cnlaunch.x431pro.module.p255e.p257b.SysCardInfoResult;
import com.cnlaunch.x431pro.p210a.LoginTools;
import com.cnlaunch.x431pro.widget.ClearEditText;
import com.cnlaunch.x431pro.widget.p290a.LoadDialog;
import com.ifoer.expedition.pro.R;
import java.util.regex.Pattern;

/* renamed from: com.cnlaunch.x431pro.activity.mine.b */
/* loaded from: classes.dex */
public class CardStatusFragment extends BaseFragment {

    /* renamed from: a */
    private ClearEditText f13719a;

    /* renamed from: b */
    private Button f13720b;

    /* renamed from: c */
    private TextView f13721c;

    /* renamed from: d */
    private TextView f13722d;

    /* renamed from: e */
    private TextView f13723e;

    /* renamed from: f */
    private TextView f13724f;

    /* renamed from: g */
    private TextView f13725g;

    /* renamed from: h */
    private Handler f13726h = null;

    @Override // com.cnlaunch.x431pro.activity.BaseFragment
    public View onCreateFragmentView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_card_status, viewGroup, false);
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.f13726h = new HandlerC2484e(this);
        setTitle(R.string.mine_card_status);
        this.f13719a = (ClearEditText) getActivity().findViewById(R.id.card_code);
        this.f13721c = (TextView) getActivity().findViewById(R.id.card_no);
        this.f13722d = (TextView) getActivity().findViewById(R.id.product_config);
        this.f13723e = (TextView) getActivity().findViewById(R.id.renewal_years);
        this.f13724f = (TextView) getActivity().findViewById(R.id.status);
        this.f13725g = (TextView) getActivity().findViewById(R.id.activate_date);
        this.f13720b = (Button) getActivity().findViewById(R.id.check);
        this.f13720b.setOnClickListener(new View$OnClickListenerC2451c(this));
        this.f13719a.setOnEditorActionListener(new C2474d(this));
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public Object doInBackground(int i) throws C1425f {
        if (1001 == i) {
            return new PincardAction(this.mContext).m5357a(this.f13719a.getText().toString());
        }
        return super.doInBackground(i);
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public void onSuccess(int i, Object obj) {
        if (1001 == i && obj != null && (obj instanceof SysCardInfoResult)) {
            SysCardInfoResult sysCardInfoResult = (SysCardInfoResult) obj;
            if (sysCardInfoResult.getCode() == 0) {
                this.f13726h.sendMessage(this.f13726h.obtainMessage(100, 0, 0, sysCardInfoResult));
            } else {
                this.f13726h.sendMessage(this.f13726h.obtainMessage(101, sysCardInfoResult.getCode(), 0, sysCardInfoResult.getMessage()));
            }
        }
        LoadDialog.m4681b(this.mContext);
        super.onSuccess(i, obj);
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public void onFailure(int i, int i2, Object obj) {
        LoadDialog.m4681b(this.mContext);
        this.f13726h.sendMessage(this.f13726h.obtainMessage(101, 0, 0));
        super.onFailure(i, i2, obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static /* synthetic */ void m6420a(CardStatusFragment cardStatusFragment) {
        cardStatusFragment.f13721c.setText("");
        cardStatusFragment.f13722d.setText("");
        cardStatusFragment.f13723e.setText("");
        cardStatusFragment.f13724f.setText("");
        cardStatusFragment.f13725g.setText("");
        if (LoginTools.m7945a(cardStatusFragment.mContext, 2)) {
            if (Pattern.compile("^\\d{12}$").matcher(cardStatusFragment.f13719a.getText().toString()).matches()) {
                LoadDialog.m4680b(cardStatusFragment.mContext, cardStatusFragment.getString(R.string.refresh_txt));
                cardStatusFragment.request(1001);
                return;
            }
            NToast.m9450a(cardStatusFragment.mContext, (int) R.string.mine_hint_card_no);
        }
    }
}
