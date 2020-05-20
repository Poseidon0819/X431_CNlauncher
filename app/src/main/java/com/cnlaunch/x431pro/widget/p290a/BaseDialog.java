package com.cnlaunch.x431pro.widget.p290a;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.ifoer.expedition.pro.R;

/* renamed from: com.cnlaunch.x431pro.widget.a.a */
/* loaded from: classes.dex */
public abstract class BaseDialog extends Dialog implements View.OnClickListener {

    /* renamed from: a */
    private TextView f16124a;

    /* renamed from: b */
    private FrameLayout f16125b;

    /* renamed from: c */
    private View f16126c;

    /* renamed from: d */
    TextView f16127d;

    /* renamed from: e */
    Button f16128e;

    /* renamed from: f */
    Button f16129f;

    /* renamed from: g */
    private Button f16130g;

    /* renamed from: h */
    private View.OnClickListener f16131h;

    /* renamed from: i */
    private View.OnClickListener f16132i;

    /* renamed from: j */
    private View.OnClickListener f16133j;

    /* renamed from: k */
    private boolean f16134k;

    /* renamed from: l */
    private boolean f16135l;

    /* renamed from: m */
    private boolean f16136m;

    /* renamed from: a */
    public abstract View mo4517a();

    public BaseDialog(Context context) {
        super(context);
        this.f16134k = true;
        this.f16135l = true;
        this.f16136m = true;
        getContext().setTheme(16974129);
        super.setContentView(R.layout.layout_dialog_base);
        this.f16124a = (TextView) findViewById(R.id.tv_title);
        this.f16125b = (FrameLayout) findViewById(R.id.fl_content);
        this.f16127d = (TextView) findViewById(R.id.dialog_message);
        this.f16126c = findViewById(R.id.linear_contentPanel);
        this.f16128e = (Button) findViewById(R.id.button1);
        this.f16129f = (Button) findViewById(R.id.button2);
        this.f16130g = (Button) findViewById(R.id.button3);
        this.f16128e.setOnClickListener(this);
        this.f16129f.setOnClickListener(this);
        this.f16130g.setOnClickListener(this);
        getWindow().getDecorView().getBackground().setAlpha(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        View mo4517a = mo4517a();
        if (mo4517a != null) {
            this.f16126c.setVisibility(8);
            setContentView(mo4517a);
            return;
        }
        this.f16125b.setVisibility(8);
    }

    /* renamed from: b */
    public final void m4716b(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f16124a.setText(str);
    }

    @Override // android.app.Dialog
    public void setTitle(int i) {
        m4716b(getContext().getResources().getString(i));
    }

    @Override // android.app.Dialog
    public void setContentView(View view) {
        view.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.f16125b.addView(view);
    }

    /* renamed from: g */
    public final void m4712g() {
        findViewById(R.id.linearlayout_bottom_btn).setVisibility(8);
    }

    /* renamed from: h */
    public final void m4711h() {
        findViewById(R.id.linearlayout_bottom_btn).setVisibility(0);
    }

    /* renamed from: e */
    public final void m4714e(int i) {
        this.f16127d.setText(i);
    }

    /* renamed from: c */
    public final void m4715c(String str) {
        this.f16127d.setText(str);
    }

    /* renamed from: i */
    public final void m4710i() {
        ImageView imageView = (ImageView) findViewById(R.id.linear_contentIconIndicator);
        if (imageView != null) {
            imageView.setVisibility(0);
            imageView.setImageResource(R.drawable.warning);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) imageView.getLayoutParams();
            layoutParams.gravity = 17;
            imageView.setLayoutParams(layoutParams);
            ScrollView scrollView = (ScrollView) findViewById(R.id.dialog_message).getParent();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) scrollView.getLayoutParams();
            layoutParams2.gravity = 17;
            scrollView.setLayoutParams(layoutParams2);
        }
    }

    /* renamed from: a */
    public final void m4718a(String str, View.OnClickListener onClickListener) {
        this.f16128e.setText(str);
        this.f16128e.setVisibility(0);
        this.f16134k = true;
        this.f16131h = onClickListener;
    }

    /* renamed from: a */
    public final void m4719a(int i, boolean z, View.OnClickListener onClickListener) {
        this.f16128e.setText(i);
        this.f16128e.setVisibility(0);
        this.f16134k = z;
        this.f16131h = onClickListener;
    }

    /* renamed from: b */
    public final void m4717b(int i, boolean z, View.OnClickListener onClickListener) {
        this.f16129f.setText(i);
        this.f16135l = z;
        this.f16129f.setVisibility(0);
        this.f16132i = onClickListener;
    }

    /* renamed from: a */
    public final void m4720a(int i, View.OnClickListener onClickListener) {
        this.f16130g.setText(i);
        this.f16136m = true;
        this.f16130g.setVisibility(0);
        this.f16133j = onClickListener;
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button1 /* 2131296605 */:
                mo4579a(view, 1);
                return;
            case R.id.button2 /* 2131296606 */:
                mo4577b(view, 2);
                return;
            case R.id.button3 /* 2131296607 */:
                mo4576c(view, 3);
                return;
            default:
                return;
        }
    }

    /* renamed from: a */
    public void mo4579a(View view, int i) {
        View.OnClickListener onClickListener = this.f16131h;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
        if (this.f16134k) {
            dismiss();
        }
    }

    /* renamed from: b */
    public void mo4577b(View view, int i) {
        View.OnClickListener onClickListener = this.f16132i;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
        if (this.f16135l) {
            dismiss();
        }
    }

    /* renamed from: c */
    public void mo4576c(View view, int i) {
        View.OnClickListener onClickListener = this.f16133j;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
        if (this.f16136m) {
            dismiss();
        }
    }

    /* renamed from: j */
    public final void m4709j() {
        this.f16124a.setGravity(17);
    }

    /* renamed from: f */
    public final void m4713f(int i) {
        if (i == 1) {
            this.f16128e.setBackgroundResource(R.drawable.select_btn_dialog_grey);
        } else if (i == 2) {
            this.f16129f.setBackgroundResource(R.drawable.select_btn_dialog_grey);
        } else if (i == 3) {
            this.f16130g.setBackgroundResource(R.drawable.select_btn_dialog_grey);
        }
    }

    /* renamed from: k */
    public void mo4545k() {
        super.dismiss();
    }
}
