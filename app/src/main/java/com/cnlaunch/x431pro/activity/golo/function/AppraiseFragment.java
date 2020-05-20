package com.cnlaunch.x431pro.activity.golo.function;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import com.cnlaunch.p120d.p125c.p128c.C1425f;
import com.cnlaunch.p120d.p130d.NToast;
import com.cnlaunch.x431pro.activity.BaseFragment;
import com.cnlaunch.x431pro.module.golo.model.GoloAppraiseAllData;
import com.cnlaunch.x431pro.module.golo.model.GoloAppraiseInfo;
import com.cnlaunch.x431pro.module.golo.p262a.GoloAction;
import com.cnlaunch.x431pro.widget.p290a.LoadDialog;
import com.ifoer.expedition.pro.R;
import com.p297e.p298a.p306b.DisplayImageOptions;
import com.p297e.p298a.p306b.p310c.RoundedBitmapDisplayer;
import java.util.ArrayList;
import java.util.List;

@SuppressLint({"HandlerLeak"})
/* renamed from: com.cnlaunch.x431pro.activity.golo.function.a */
/* loaded from: classes.dex */
public final class AppraiseFragment extends BaseFragment implements View.OnTouchListener {

    /* renamed from: b */
    private String f12587b;

    /* renamed from: c */
    private RatingBar f12588c;

    /* renamed from: d */
    private ImageView f12589d;

    /* renamed from: e */
    private ImageView f12590e;

    /* renamed from: f */
    private ImageView f12591f;

    /* renamed from: g */
    private TextView f12592g;

    /* renamed from: h */
    private TextView f12593h;

    /* renamed from: i */
    private TextView f12594i;

    /* renamed from: j */
    private TextView f12595j;

    /* renamed from: k */
    private TextView f12596k;

    /* renamed from: l */
    private TextView f12597l;

    /* renamed from: m */
    private TextView f12598m;

    /* renamed from: n */
    private TextView f12599n;

    /* renamed from: o */
    private TextView f12600o;

    /* renamed from: p */
    private TextView f12601p;

    /* renamed from: q */
    private TextView f12602q;

    /* renamed from: u */
    private String[] f12606u;

    /* renamed from: v */
    private String[] f12607v;

    /* renamed from: w */
    private String[] f12608w;

    /* renamed from: a */
    private GoloAction f12586a = null;

    /* renamed from: r */
    private List<GoloAppraiseInfo> f12603r = null;

    /* renamed from: s */
    private GoloAppraiseInfo f12604s = null;

    /* renamed from: t */
    private DisplayImageOptions f12605t = null;

    /* renamed from: x */
    private String f12609x = "";

    /* renamed from: y */
    private GoloAppraiseAllData f12610y = null;

    /* renamed from: z */
    private Handler f12611z = new HandlerC2237b(this);

    @Override // com.cnlaunch.x431pro.activity.BaseFragment
    public final View onCreateFragmentView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.golo_appraise_fragment, viewGroup, false);
    }

    @Override // android.app.Fragment
    public final void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f12587b = getBundle().getString("id");
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, android.app.Fragment
    public final void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        m7013a();
        DisplayImageOptions.C3010a c3010a = new DisplayImageOptions.C3010a();
        c3010a.f17117a = R.drawable.ic_golo_logo_default;
        c3010a.f17118b = R.drawable.ic_golo_logo_default;
        c3010a.f17119c = R.drawable.ic_golo_logo_default;
        c3010a.f17124h = true;
        c3010a.f17125i = true;
        c3010a.f17129m = true;
        c3010a.f17133q = new RoundedBitmapDisplayer(0);
        this.f12605t = c3010a.m4193a();
        this.f12586a = new GoloAction(getActivity());
        LoadDialog.m4686a(this.mContext);
        request(40014);
    }

    /* renamed from: a */
    private void m7013a() {
        setTitle(R.string.title_appraise);
        this.f12588c = (RatingBar) getActivity().findViewById(R.id.ratingBar_gobal);
        this.f12588c.setProgress(0);
        this.f12588c.setMax(5);
        this.f12589d = (ImageView) getActivity().findViewById(R.id.icon_face);
        this.f12592g = (TextView) getActivity().findViewById(R.id.tv_name);
        this.f12590e = (ImageView) getActivity().findViewById(R.id.img_sex);
        this.f12591f = (ImageView) getActivity().findViewById(R.id.car_icon);
        this.f12593h = (TextView) getActivity().findViewById(R.id.tv_signature);
        this.f12594i = (TextView) getActivity().findViewById(R.id.tv_carnum);
        this.f12596k = (TextView) getActivity().findViewById(R.id.tv_carname);
        this.f12595j = (TextView) getActivity().findViewById(R.id.tv_carstyle);
        this.f12597l = (TextView) getActivity().findViewById(R.id.tv_date);
        this.f12598m = (TextView) getActivity().findViewById(R.id.tv_appraise_content);
        this.f12599n = (TextView) getActivity().findViewById(R.id.tv_attitude);
        this.f12600o = (TextView) getActivity().findViewById(R.id.tv_serve);
        this.f12601p = (TextView) getActivity().findViewById(R.id.tv_skill);
        this.f12602q = (TextView) getActivity().findViewById(R.id.appraise_show);
        this.f12599n.setOnTouchListener(this);
        this.f12600o.setOnTouchListener(this);
        this.f12601p.setOnTouchListener(this);
        this.f12606u = this.mContext.getResources().getStringArray(R.array.appraise_attitude_array);
        this.f12607v = this.mContext.getResources().getStringArray(R.array.appraise_serve_array);
        this.f12608w = this.mContext.getResources().getStringArray(R.array.appraise_skill_array);
        this.f12598m.setMovementMethod(ScrollingMovementMethod.getInstance());
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public final Object doInBackground(int i) throws C1425f {
        if (i != 40014) {
            return null;
        }
        this.f12610y = this.f12586a.m5313g(this.f12587b);
        GoloAppraiseAllData goloAppraiseAllData = this.f12610y;
        if (goloAppraiseAllData == null) {
            NToast.m9450a(getActivity(), (int) R.string.tip_fail_to_getappraise);
            return null;
        }
        this.f12603r = (ArrayList) goloAppraiseAllData.getResponse().getData();
        List<GoloAppraiseInfo> list = this.f12603r;
        if (list != null && list.size() > 0) {
            this.f12604s = this.f12603r.get(0);
        } else {
            NToast.m9450a(getActivity(), (int) R.string.tip_fail_to_getappraise);
        }
        return null;
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public final void onSuccess(int i, Object obj) {
        if (i == 40014) {
            LoadDialog.m4681b(getActivity());
            this.f12611z.obtainMessage(0).sendToTarget();
            return;
        }
        super.onSuccess(i, obj);
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public final void onFailure(int i, int i2, Object obj) {
        if (i == 40014) {
            LoadDialog.m4681b(getActivity());
            NToast.m9450a(getActivity(), (int) R.string.tip_fail_to_getappraise);
            return;
        }
        super.onFailure(i, i2, obj);
    }

    @Override // android.app.Fragment, android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        m7013a();
        if (this.f12604s != null) {
            this.f12611z.obtainMessage(0).sendToTarget();
        }
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        CharSequence text;
        if (motionEvent.getAction() == 1) {
            this.f12602q.setVisibility(4);
        } else {
            int id = view.getId();
            if (id == R.id.tv_attitude) {
                text = this.f12599n.getText();
            } else if (id == R.id.tv_serve) {
                text = this.f12600o.getText();
            } else if (id != R.id.tv_skill) {
                return false;
            } else {
                text = this.f12601p.getText();
            }
            this.f12602q.setText(text);
            this.f12602q.setVisibility(0);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static /* synthetic */ String m7011a(AppraiseFragment appraiseFragment, int i, String str) {
        String[] strArr;
        switch (i) {
            case 1:
                strArr = appraiseFragment.f12606u;
                break;
            case 2:
                strArr = appraiseFragment.f12607v;
                break;
            case 3:
                strArr = appraiseFragment.f12608w;
                break;
            default:
                strArr = appraiseFragment.f12606u;
                break;
        }
        if (str.equals("1")) {
            return strArr[0];
        }
        if (str.equals("2")) {
            return strArr[1];
        }
        str.equals("3");
        return strArr[2];
    }
}
