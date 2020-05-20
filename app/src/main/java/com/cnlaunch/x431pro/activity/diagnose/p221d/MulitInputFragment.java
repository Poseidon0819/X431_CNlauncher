package com.cnlaunch.x431pro.activity.diagnose.p221d;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.cnlaunch.diagnosemodule.bean.BasicButtonBean;
import com.cnlaunch.diagnosemodule.bean.BasicInputBean;
import com.cnlaunch.diagnosemodule.utils.DiagnoseConstants;
import com.cnlaunch.x431pro.utils.p280b.LanChaset;
import com.cnlaunch.x431pro.widget.p290a.SpinnerPopupWindow;
import com.ifoer.expedition.pro.R;
import com.mopub.mobileads.VastExtensionXmlManager;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* renamed from: com.cnlaunch.x431pro.activity.diagnose.d.bb */
/* loaded from: classes.dex */
public final class MulitInputFragment extends BaseDiagnoseFragment {

    /* renamed from: r */
    private static int f12071r = 0;

    /* renamed from: s */
    private static int f12072s = 1;

    /* renamed from: a */
    private String f12073a;

    /* renamed from: b */
    private Context f12074b;

    /* renamed from: j */
    private ArrayList<BasicInputBean> f12075j;

    /* renamed from: l */
    private LinearLayout f12077l;

    /* renamed from: o */
    private String f12080o;

    /* renamed from: p */
    private ArrayList<BasicButtonBean> f12081p;

    /* renamed from: q */
    private SpinnerPopupWindow f12082q;

    /* renamed from: k */
    private Map<TextView, SpinnerPopupWindow> f12076k = new HashMap();

    /* renamed from: m */
    private ArrayList<TextView> f12078m = new ArrayList<>();

    /* renamed from: n */
    private ArrayList<String> f12079n = new ArrayList<>();

    @Override // com.cnlaunch.x431pro.activity.diagnose.p221d.BaseDiagnoseFragment, android.app.Fragment
    public final void onAttach(Activity activity) {
        super.onAttach(activity);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.f12075j = (ArrayList) arguments.getSerializable("InputData");
            this.f12073a = arguments.getString("Title");
            this.f12080o = arguments.getString(VastExtensionXmlManager.TYPE, "");
            if (this.f12080o.equals(DiagnoseConstants.UI_Type_MULIT_INPUT_COMBOBOX_WINDON_WITH_BTN_RESPONSECOMBOEVENT)) {
                this.f12081p = (ArrayList) arguments.getSerializable("BtnData");
            }
        }
    }

    @Override // android.app.Fragment
    public final void onPause() {
        super.onPause();
        SpinnerPopupWindow spinnerPopupWindow = this.f12082q;
        if (spinnerPopupWindow != null) {
            spinnerPopupWindow.m4583a();
        }
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p221d.BaseDiagnoseFragment, com.cnlaunch.x431pro.activity.BaseFragment, android.app.Fragment
    public final void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.f12074b = getActivity();
        m7202d();
        setTitle(this.f12073a);
    }

    /* renamed from: c */
    private void m7203c(ArrayList<BasicButtonBean> arrayList) {
        if ((arrayList == null ? 0 : arrayList.size()) == 0) {
            this.mContentView.findViewById(R.id.group_btn_mulit).setVisibility(8);
            return;
        }
        this.mContentView.findViewById(R.id.group_btn_mulit).setVisibility(0);
        LinearLayout linearLayout = (LinearLayout) this.mContentView.findViewById(R.id.group_btn_mulit);
        LinearLayout linearLayout2 = (LinearLayout) this.mContentView.findViewById(R.id.group_btn2_mulit);
        int i = getResources().getDisplayMetrics().widthPixels;
        int i2 = 0;
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            TextView textView = (TextView) LayoutInflater.from(this.f12074b).inflate(R.layout.item_button_activetest, (ViewGroup) null).findViewById(R.id.tv_title);
            textView.setText(arrayList.get(i3).getTitle());
            TextPaint paint = textView.getPaint();
            i2 = (int) (i2 + paint.measureText(arrayList.get(i3).getTitle()) + 28.0f);
        }
        if (i > i2) {
            linearLayout.setVisibility(0);
            linearLayout2.setVisibility(8);
            linearLayout.removeAllViews();
            SpinnerPopupWindow spinnerPopupWindow = this.f12082q;
            if (spinnerPopupWindow != null) {
                spinnerPopupWindow.m4583a();
            }
            int i4 = i - i2;
            int size = i4 / (arrayList.size() - 0);
            int size2 = i4 % (arrayList.size() - 0);
            for (int i5 = 0; i5 < arrayList.size(); i5++) {
                View inflate = LayoutInflater.from(this.f12074b).inflate(R.layout.item_button_activetest, (ViewGroup) null);
                TextView textView2 = (TextView) inflate.findViewById(R.id.tv_title);
                textView2.setId(i5);
                textView2.setSingleLine(true);
                textView2.setText(arrayList.get(i5).getTitle());
                textView2.setOnClickListener(new View$OnClickListenerC2138bc(this, i5));
                TextPaint paint2 = textView2.getPaint();
                float measureText = paint2.measureText(arrayList.get(i5).getTitle());
                if (i5 == arrayList.size() - 1) {
                    textView2.setWidth(((int) measureText) + 28 + size + size2);
                } else {
                    textView2.setWidth(((int) measureText) + 28 + size);
                }
                linearLayout.addView(inflate);
            }
            return;
        }
        linearLayout.setVisibility(8);
        linearLayout2.setVisibility(0);
        TextView textView3 = (TextView) getActivity().findViewById(R.id.active_spinner);
        textView3.setVisibility(0);
        textView3.setText(arrayList.get(0).getTitle());
        textView3.setOnClickListener(new View$OnClickListenerC2139bd(this, arrayList, textView3));
        Button button = (Button) getActivity().findViewById(R.id.active_ok);
        button.setVisibility(0);
        button.setEnabled(this.f12356c);
        button.setOnClickListener(new View$OnClickListenerC2141bf(this, arrayList, textView3, button));
    }

    /* renamed from: d */
    private void m7202d() {
        this.f12077l = (LinearLayout) getActivity().findViewById(R.id.group_input);
        m7198h();
        Button button = (Button) getActivity().findViewById(R.id.button1);
        Button button2 = (Button) getActivity().findViewById(R.id.button2);
        if (this.f12080o.equals(DiagnoseConstants.UI_Type_MULIT_INPUT_COMBOBOX_WINDON_WITH_BTN_RESPONSECOMBOEVENT)) {
            button.setVisibility(8);
            button2.setVisibility(8);
            m7203c(this.f12081p);
            return;
        }
        button.setOnClickListener(new View$OnClickListenerC2142bg(this));
        button2.setOnClickListener(new View$OnClickListenerC2143bh(this));
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment
    public final View onCreateFragmentView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_mulit_input, viewGroup, false);
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p221d.BaseDiagnoseFragment, com.cnlaunch.x431pro.activity.BaseFragment, com.cnlaunch.x431pro.activity.golo.p225b.OnGoloKeyDownListener
    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.f12080o.equals(DiagnoseConstants.UI_Type_MULIT_INPUT_COMBOBOX_WINDON_WITH_BTN_RESPONSECOMBOEVENT)) {
                this.f12357d.mo7089a(DiagnoseConstants.FEEDBACK_SPT_STD_EXT1, new byte[]{-1});
                return true;
            }
            this.f12357d.mo7089a(DiagnoseConstants.FEEDBACK_SPT_MULTI_INPUT_COMB_WINDOW, new byte[]{0});
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* renamed from: a */
    private void m7211a(int i, int i2, ArrayList<String> arrayList) {
        int i3;
        int size = arrayList.size();
        String m5100a = LanChaset.m5100a(Locale.getDefault().getCountry());
        int i4 = 0;
        for (int i5 = 0; i5 < size; i5++) {
            try {
                i4 += arrayList.get(i5).getBytes(m5100a).length + 1;
            } catch (Exception e) {
                e.printStackTrace();
                i4++;
            }
        }
        byte[] bArr = new byte[i4 + 6];
        bArr[0] = 0;
        bArr[1] = (byte) (i2 == f12071r ? 0 : 1);
        bArr[2] = (byte) i;
        bArr[3] = (byte) (size & 255);
        bArr[4] = (byte) ((i4 >> 8) & 255);
        bArr[5] = (byte) (i4 & 255);
        int i6 = 6;
        for (int i7 = 0; i7 < size; i7++) {
            if (arrayList.get(i7) != null) {
                try {
                    byte[] bytes = arrayList.get(i7).getBytes(m5100a);
                    i3 = bytes.length;
                    System.arraycopy(bytes, 0, bArr, i6, i3);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    i3 = 0;
                }
            } else {
                i3 = 0;
            }
            bArr[i6 + i3] = 0;
            i6 += i3 + 1;
        }
        this.f12357d.mo7089a(DiagnoseConstants.FEEDBACK_SPT_STD_EXT1, bArr);
    }

    /* renamed from: h */
    private void m7198h() {
        this.f12078m.clear();
        this.f12077l.removeAllViews();
        if (this.f12076k.size() != 0) {
            for (TextView textView : this.f12076k.keySet()) {
                this.f12076k.get(textView).m4583a();
            }
        }
        this.f12076k.clear();
        int i = 0;
        for (int i2 = 0; i2 < this.f12075j.size(); i2++) {
            View inflate = LayoutInflater.from(this.f12074b).inflate(R.layout.item_edit_text_mulit_input, (ViewGroup) null);
            EditText editText = (EditText) inflate.findViewById(R.id.edit_mulit);
            TextView textView2 = (TextView) inflate.findViewById(R.id.edit_mulit_spinner);
            ((TextView) inflate.findViewById(R.id.tv_show)).setText(this.f12075j.get(i2).getTitle());
            if (this.f12075j.get(i2).getInputType().equals("0")) {
                editText.setVisibility(0);
                if (this.f12080o.equals(DiagnoseConstants.UI_Type_MULIT_INPUT_COMBOBOX_WINDON_WITH_BTN_RESPONSECOMBOEVENT)) {
                    editText.setText(this.f12075j.get(i2).getPrefix());
                } else {
                    editText.setHint(this.f12075j.get(i2).getPrefix());
                }
                if (!this.f12075j.get(i2).getCanEdit()) {
                    editText.setKeyListener(null);
                }
                textView2.setVisibility(8);
                this.f12078m.add(editText);
            } else {
                editText.setVisibility(8);
                textView2.setVisibility(0);
                textView2.setText(this.f12075j.get(i2).getPrefix());
                if (this.f12075j.get(i2).getCanEdit()) {
                    textView2.setOnClickListener(new View$OnClickListenerC2144bi(this, textView2, this.f12075j.get(i2).getChoiceData(), i));
                }
                this.f12078m.add(textView2);
                i++;
            }
            this.f12077l.addView(inflate);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public void m7197i() {
        this.f12079n.clear();
        for (int i = 0; i < this.f12078m.size(); i++) {
            TextView textView = this.f12078m.get(i);
            String charSequence = textView.getText().toString();
            if (TextUtils.isEmpty(charSequence)) {
                charSequence = textView.getHint() != null ? (String) textView.getHint() : "";
            }
            this.f12079n.add(charSequence);
        }
    }

    @Override // android.app.Fragment, android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.f12076k.size() != 0) {
            for (TextView textView : this.f12076k.keySet()) {
                this.f12076k.get(textView).m4583a();
            }
        }
        m7202d();
        SpinnerPopupWindow spinnerPopupWindow = this.f12082q;
        if (spinnerPopupWindow != null) {
            spinnerPopupWindow.m4583a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static /* synthetic */ void m7209a(MulitInputFragment mulitInputFragment, int i) {
        mulitInputFragment.m7197i();
        mulitInputFragment.m7211a(i, f12071r, mulitInputFragment.f12079n);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static /* synthetic */ void m7207a(MulitInputFragment mulitInputFragment, ArrayList arrayList) {
        int i;
        int size = arrayList.size();
        String m5100a = LanChaset.m5100a(Locale.getDefault().getCountry());
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            try {
                i2 += ((String) arrayList.get(i3)).getBytes(m5100a).length + 1;
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
                i2++;
            }
        }
        byte[] bArr = new byte[i2 + 4];
        bArr[0] = 1;
        bArr[1] = (byte) (size & 255);
        bArr[2] = (byte) ((i2 / 255) & 255);
        bArr[3] = (byte) (i2 % 255);
        int i4 = 4;
        for (int i5 = 0; i5 < size; i5++) {
            if (arrayList.get(i5) != null) {
                try {
                    byte[] bytes = ((String) arrayList.get(i5)).getBytes(m5100a);
                    i = bytes.length;
                    System.arraycopy(bytes, 0, bArr, i4, i);
                } catch (UnsupportedEncodingException e2) {
                    e2.printStackTrace();
                    i = 0;
                }
            } else {
                i = 0;
            }
            bArr[i4 + i] = 0;
            i4 += i + 1;
        }
        mulitInputFragment.f12357d.mo7089a(DiagnoseConstants.FEEDBACK_SPT_MULTI_INPUT_COMB_WINDOW, bArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public static /* synthetic */ void m7205b(MulitInputFragment mulitInputFragment, int i) {
        mulitInputFragment.m7197i();
        mulitInputFragment.m7211a(i, f12072s, mulitInputFragment.f12079n);
    }
}
