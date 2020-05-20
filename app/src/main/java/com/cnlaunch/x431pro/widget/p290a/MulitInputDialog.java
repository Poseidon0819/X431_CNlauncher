package com.cnlaunch.x431pro.widget.p290a;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.cnlaunch.diagnosemodule.bean.BasicInputBean;
import com.ifoer.expedition.pro.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.cnlaunch.x431pro.widget.a.be */
/* loaded from: classes.dex */
public abstract class MulitInputDialog extends BaseDialog {

    /* renamed from: a */
    private View f16275a;

    /* renamed from: b */
    private Context f16276b;

    /* renamed from: c */
    private ArrayList<BasicInputBean> f16277c;

    /* renamed from: g */
    private Map<TextView, SpinnerPopupWindow> f16278g;

    /* renamed from: h */
    private LinearLayout f16279h;

    /* renamed from: i */
    private ArrayList<TextView> f16280i;

    /* renamed from: j */
    private ArrayList<String> f16281j;

    /* renamed from: a */
    public abstract void mo4665a(ArrayList<String> arrayList);

    /* renamed from: h_ */
    public abstract void mo4660h_();

    public MulitInputDialog(Context context, String str, ArrayList<BasicInputBean> arrayList) {
        super(context);
        this.f16275a = null;
        this.f16278g = new HashMap();
        this.f16280i = new ArrayList<>();
        this.f16281j = new ArrayList<>();
        setCancelable(false);
        this.f16277c = arrayList;
        m4716b(str);
        this.f16276b = context;
        this.f16275a = LayoutInflater.from(context).inflate(R.layout.layout_mulit_input_dialog, (ViewGroup) null);
        this.f16279h = (LinearLayout) this.f16275a.findViewById(R.id.group_input);
        m4664b();
    }

    /* renamed from: b */
    private void m4664b() {
        this.f16280i.clear();
        this.f16279h.removeAllViews();
        this.f16278g.clear();
        for (int i = 0; i < this.f16277c.size(); i++) {
            View inflate = LayoutInflater.from(this.f16276b).inflate(R.layout.item_edit_text_mulit_input, (ViewGroup) null);
            EditText editText = (EditText) inflate.findViewById(R.id.edit_mulit);
            TextView textView = (TextView) inflate.findViewById(R.id.edit_mulit_spinner);
            ((TextView) inflate.findViewById(R.id.tv_show)).setText(this.f16277c.get(i).getTitle());
            if (this.f16277c.get(i).getInputType().equals("0")) {
                editText.setVisibility(0);
                editText.setHint(this.f16277c.get(i).getPrefix());
                if (!this.f16277c.get(i).getCanEdit()) {
                    editText.setKeyListener(null);
                }
                textView.setVisibility(8);
                this.f16280i.add(editText);
            } else {
                editText.setVisibility(8);
                textView.setVisibility(0);
                textView.setText(this.f16277c.get(i).getPrefix());
                if (this.f16277c.get(i).getCanEdit()) {
                    textView.setOnClickListener(new View$OnClickListenerC2824bf(this, textView, this.f16277c.get(i).getChoiceData()));
                }
                this.f16280i.add(textView);
            }
            this.f16279h.addView(inflate);
        }
    }

    @Override // com.cnlaunch.x431pro.widget.p290a.BaseDialog
    /* renamed from: a */
    public final View mo4517a() {
        return this.f16275a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public static /* synthetic */ void m4662c(MulitInputDialog mulitInputDialog) {
        mulitInputDialog.f16281j.clear();
        for (int i = 0; i < mulitInputDialog.f16280i.size(); i++) {
            TextView textView = mulitInputDialog.f16280i.get(i);
            String charSequence = textView.getText().toString();
            if (TextUtils.isEmpty(charSequence)) {
                charSequence = (String) textView.getHint();
            }
            mulitInputDialog.f16281j.add(charSequence);
        }
    }
}
