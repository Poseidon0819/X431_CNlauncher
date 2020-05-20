package com.cnlaunch.x431pro.activity.setting.wifi;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.ifoer.expedition.pro.R;

/* renamed from: com.cnlaunch.x431pro.activity.setting.wifi.a */
/* loaded from: classes.dex */
public class BaseGuideView extends LinearLayout implements View.OnClickListener {

    /* renamed from: a */
    protected InterfaceC2578a f14848a;

    /* renamed from: b */
    protected Context f14849b;

    /* renamed from: c */
    protected LayoutInflater f14850c;

    /* renamed from: d */
    private TextView f14851d;

    /* renamed from: e */
    private TextView f14852e;

    /* renamed from: f */
    private LinearLayout f14853f;

    /* renamed from: g */
    private Button f14854g;

    /* renamed from: h */
    private Button f14855h;

    /* renamed from: i */
    private Button f14856i;

    /* renamed from: j */
    private View.OnClickListener f14857j;

    /* renamed from: k */
    private View.OnClickListener f14858k;

    /* renamed from: l */
    private View.OnClickListener f14859l;

    /* compiled from: BaseGuideView.java */
    /* renamed from: com.cnlaunch.x431pro.activity.setting.wifi.a$a */
    /* loaded from: classes.dex */
    public interface InterfaceC2578a {
    }

    protected void setButtonBackground(int i) {
    }

    public BaseGuideView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, (byte) 0);
    }

    public BaseGuideView(Context context, AttributeSet attributeSet, byte b) {
        super(context, attributeSet, 0);
        this.f14850c = LayoutInflater.from(context);
        this.f14849b = context;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f14851d = (TextView) findViewById(R.id.guide_title);
        this.f14852e = (TextView) findViewById(R.id.guide_message);
        this.f14853f = (LinearLayout) findViewById(R.id.bottom_button_group);
        this.f14854g = (Button) findViewById(R.id.guide_button1);
        this.f14855h = (Button) findViewById(R.id.guide_button2);
        this.f14856i = (Button) findViewById(R.id.guide_button3);
        this.f14854g.setOnClickListener(this);
        this.f14855h.setOnClickListener(this);
        this.f14856i.setOnClickListener(this);
    }

    protected void setTitle(int i) {
        setTitle(getResources().getString(i));
    }

    protected void setTitle(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f14851d.setText(str);
    }

    public void setMessage(int i) {
        this.f14852e.setText(i);
    }

    public void setMessage(String str) {
        this.f14852e.setText(str);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View.OnClickListener onClickListener;
        int id = view.getId();
        if (id == R.id.guide_button1) {
            View.OnClickListener onClickListener2 = this.f14857j;
            if (onClickListener2 != null) {
                onClickListener2.onClick(view);
            }
        } else if (id == R.id.guide_button2) {
            View.OnClickListener onClickListener3 = this.f14858k;
            if (onClickListener3 != null) {
                onClickListener3.onClick(view);
            }
        } else if (id != R.id.guide_button3 || (onClickListener = this.f14859l) == null) {
        } else {
            onClickListener.onClick(view);
        }
    }

    public void setOnBaseGuideFragmentInteractionListener(InterfaceC2578a interfaceC2578a) {
        this.f14848a = interfaceC2578a;
    }

    public void setAlphaEnable(boolean z) {
        this.f14854g.setEnabled(z);
    }

    public void setBetaEnable(boolean z) {
        this.f14855h.setEnabled(z);
    }

    public void setGammaEnable(boolean z) {
        this.f14856i.setEnabled(z);
    }
}
