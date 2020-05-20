package com.cnlaunch.x431pro.widget.p290a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.cnlaunch.diagnosemodule.bean.BasicButtonBean;
import com.cnlaunch.x431pro.activity.diagnose.p222e.IFragmentCallback;
import com.ifoer.expedition.pro.R;
import java.util.ArrayList;

/* renamed from: com.cnlaunch.x431pro.widget.a.c */
/* loaded from: classes.dex */
public final class CustomBtnDialog extends BaseDialog {

    /* renamed from: a */
    public IFragmentCallback f16347a;

    /* renamed from: b */
    private LinearLayout f16348b;

    @Override // com.cnlaunch.x431pro.widget.p290a.BaseDialog
    /* renamed from: a */
    public final View mo4517a() {
        return null;
    }

    public CustomBtnDialog(Context context, String str, String str2, ArrayList<BasicButtonBean> arrayList) {
        super(context);
        this.f16347a = null;
        m4716b(str);
        m4715c(str2);
        setCancelable(false);
        int size = arrayList.size();
        this.f16348b = (LinearLayout) findViewById(R.id.linearlayout_bottom_btn);
        for (int i = 0; i < size; i++) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.item_button_dialog_custom_btn, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(R.id.tv_title);
            textView.setId(i);
            textView.setSingleLine(true);
            textView.setText(arrayList.get(i).getTitle());
            textView.setOnClickListener(new View$OnClickListenerC2862d(this));
            this.f16348b.addView(inflate);
        }
    }
}
