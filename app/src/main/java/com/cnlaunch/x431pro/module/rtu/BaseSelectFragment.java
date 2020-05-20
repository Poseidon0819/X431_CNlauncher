package com.cnlaunch.x431pro.module.rtu;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.ifoer.expedition.pro.R;

/* renamed from: com.cnlaunch.x431pro.module.rtu.a */
/* loaded from: classes.dex */
public abstract class BaseSelectFragment extends Fragment implements View.OnClickListener {

    /* renamed from: a */
    protected InterfaceC2737a f15675a;

    /* renamed from: b */
    Button f15676b;

    /* renamed from: c */
    Button f15677c;

    /* renamed from: d */
    View.OnClickListener f15678d;

    /* renamed from: e */
    View.OnClickListener f15679e;

    /* renamed from: f */
    protected Context f15680f;

    /* renamed from: g */
    private TextView f15681g;

    /* renamed from: h */
    private ImageView f15682h;

    /* renamed from: i */
    private FrameLayout f15683i;

    /* renamed from: j */
    private TextView f15684j;

    /* renamed from: k */
    private View f15685k;

    /* renamed from: l */
    private View f15686l;

    /* renamed from: m */
    private Button f15687m;

    /* renamed from: n */
    private View.OnClickListener f15688n;

    /* renamed from: o */
    private long f15689o;

    /* renamed from: p */
    private int f15690p;

    /* compiled from: BaseSelectFragment.java */
    /* renamed from: com.cnlaunch.x431pro.module.rtu.a$a */
    /* loaded from: classes.dex */
    public interface InterfaceC2737a {
        /* renamed from: a */
        void mo5199a(int i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public static /* synthetic */ int m5203b(BaseSelectFragment baseSelectFragment) {
        int i = baseSelectFragment.f15690p;
        baseSelectFragment.f15690p = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public static /* synthetic */ int m5201c(BaseSelectFragment baseSelectFragment) {
        baseSelectFragment.f15690p = 0;
        return 0;
    }

    @Override // android.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f15689o = 0L;
        this.f15690p = 0;
    }

    @Override // android.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            this.f15680f = activity;
            this.f15675a = (InterfaceC2737a) activity;
        } catch (ClassCastException unused) {
            throw new ClassCastException(activity.toString() + " must implement OnInternetAccessSelectedListener");
        }
    }

    @Override // android.app.Fragment
    public void onDetach() {
        super.onDetach();
        this.f15675a = null;
    }

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.layout_rtu_base_select_fragment, viewGroup, false);
        this.f15681g = (TextView) inflate.findViewById(R.id.tv_title);
        this.f15682h = (ImageView) inflate.findViewById(R.id.linear_contentIconIndicator);
        this.f15682h.setVisibility(0);
        this.f15682h.setOnClickListener(new View$OnClickListenerC2738b(this));
        this.f15683i = (FrameLayout) inflate.findViewById(R.id.fl_content);
        this.f15684j = (TextView) inflate.findViewById(R.id.dialog_message);
        this.f15685k = inflate.findViewById(R.id.linear_contentPanel);
        this.f15687m = (Button) inflate.findViewById(R.id.button1);
        this.f15676b = (Button) inflate.findViewById(R.id.button2);
        this.f15677c = (Button) inflate.findViewById(R.id.button3);
        this.f15687m.setOnClickListener(this);
        this.f15676b.setOnClickListener(this);
        this.f15677c.setOnClickListener(this);
        this.f15686l = inflate.findViewById(R.id.linearlayout_bottom_btn);
        m5209a(R.string.user_guide);
        m5202c(2);
        m5202c(3);
        this.f15683i.setVisibility(8);
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public final void m5209a(int i) {
        String string = getResources().getString(i);
        if (TextUtils.isEmpty(string)) {
            return;
        }
        this.f15681g.setText(string);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: b */
    public final void m5204b(int i) {
        this.f15684j.setText(i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public final void m5205a(String str) {
        this.f15684j.setText(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public final void m5208a(int i, View.OnClickListener onClickListener) {
        this.f15687m.setText(i);
        this.f15687m.setVisibility(0);
        this.f15688n = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button1 /* 2131296605 */:
                View.OnClickListener onClickListener = this.f15688n;
                if (onClickListener != null) {
                    onClickListener.onClick(view);
                    return;
                }
                return;
            case R.id.button2 /* 2131296606 */:
                View.OnClickListener onClickListener2 = this.f15678d;
                if (onClickListener2 != null) {
                    onClickListener2.onClick(view);
                    return;
                }
                return;
            case R.id.button3 /* 2131296607 */:
                View.OnClickListener onClickListener3 = this.f15679e;
                if (onClickListener3 != null) {
                    onClickListener3.onClick(view);
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* renamed from: c */
    private void m5202c(int i) {
        if (i == 1) {
            this.f15687m.setBackgroundResource(R.drawable.select_btn_dialog_grey);
        } else if (i == 2) {
            this.f15676b.setBackgroundResource(R.drawable.select_btn_dialog_grey);
        } else if (i == 3) {
            this.f15677c.setBackgroundResource(R.drawable.select_btn_dialog_grey);
        }
    }
}
