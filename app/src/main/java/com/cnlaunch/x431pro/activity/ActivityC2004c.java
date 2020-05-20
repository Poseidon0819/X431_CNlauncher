package com.cnlaunch.x431pro.activity;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.p012v4.app.FragmentActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.ViewFlipper;
import com.cnlaunch.golo3.p165g.UserFaceUtils;
import com.cnlaunch.p120d.p121a.ActivityPageManager;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.p120d.p125c.p126a.AsyncTaskManager;
import com.cnlaunch.p120d.p125c.p126a.OnDataListener;
import com.cnlaunch.p120d.p125c.p128c.C1425f;
import com.cnlaunch.p120d.p130d.NToast;
import com.cnlaunch.p120d.p130d.p131a.LangManager;
import com.cnlaunch.x431pro.p210a.ApplicationTheme;
import com.cnlaunch.x431pro.p210a.C1947h;
import com.cnlaunch.x431pro.utils.C2744aa;
import com.cnlaunch.x431pro.widget.slidingmenu.SlidingMenu;
import com.ifoer.expedition.pro.R;
import com.p297e.p298a.p306b.DisplayImageOptions;
import com.p297e.p298a.p306b.ImageLoader;
import com.p297e.p298a.p306b.p310c.RoundedBitmapDisplayer;
import java.util.ArrayList;
import java.util.List;

/* compiled from: BaseActivity.java */
/* renamed from: com.cnlaunch.x431pro.activity.c */
/* loaded from: classes.dex */
public class ActivityC2004c extends FragmentActivity implements OnDataListener {

    /* renamed from: A */
    protected FragmentManager f10969A;

    /* renamed from: C */
    private ViewFlipper f10971C;

    /* renamed from: D */
    private List<RadioButton> f10972D;

    /* renamed from: E */
    private int[] f10973E;

    /* renamed from: F */
    private TextView f10974F;

    /* renamed from: H */
    private PreferencesManager f10976H;

    /* renamed from: I */
    private ImageView f10977I;

    /* renamed from: n */
    private AsyncTaskManager f10978n;

    /* renamed from: p */
    protected SlidingMenu f10980p;

    /* renamed from: q */
    public Context f10981q;

    /* renamed from: r */
    protected View f10982r;

    /* renamed from: s */
    protected LinearLayout f10983s;

    /* renamed from: t */
    protected TextView f10984t;

    /* renamed from: u */
    protected TextView f10985u;

    /* renamed from: v */
    protected TextView f10986v;

    /* renamed from: w */
    protected TextView f10987w;

    /* renamed from: z */
    protected RelativeLayout f10990z;

    /* renamed from: o */
    public final String f10979o = ActivityC2004c.class.getSimpleName();

    /* renamed from: x */
    public boolean f10988x = true;

    /* renamed from: G */
    private boolean f10975G = false;

    /* renamed from: y */
    BroadcastReceiver f10989y = new C2220f(this);

    /* renamed from: B */
    DisplayImageOptions f10970B = null;

    public Object doInBackground(int i) throws C1425f {
        return null;
    }

    public void onSuccess(int i, Object obj) {
    }

    @Override // android.support.p012v4.app.FragmentActivity, android.support.p012v4.app.BaseFragmentActivityGingerbread, android.app.Activity
    public void onCreate(Bundle bundle) {
        ApplicationTheme.m7974b(this);
        super.onCreate(bundle);
        if (PreferencesManager.m9595a((Context) this).m9583b("is_screen_switch", false) && PreferencesManager.m9595a((Context) this).m9585b("Orientation", 2) != 0) {
            if (PreferencesManager.m9595a((Context) this).m9585b("Orientation", 2) == 1) {
                setRequestedOrientation(1);
            } else {
                setRequestedOrientation(4);
            }
        } else {
            setRequestedOrientation(0);
        }
        this.f10981q = this;
        this.f10975G = true;
        ActivityPageManager.m9634a();
        ActivityPageManager.m9633a((Activity) this);
        super.setContentView(R.layout.layout_base_all);
        this.f10976H = PreferencesManager.m9595a(this.f10981q);
        this.f10971C = (ViewFlipper) super.findViewById(R.id.layout_container);
        this.f10983s = (LinearLayout) super.findViewById(R.id.layout_head);
        this.f10984t = (TextView) super.findViewById(R.id.btn_left);
        this.f10984t.setOnClickListener(new View$OnClickListenerC2008d(this));
        if (LangManager.m9466b().equalsIgnoreCase("CN")) {
            this.f10984t.setText(R.string.menu);
            this.f10984t.setBackgroundDrawable(null);
            this.f10984t.getPaint().setFlags(8);
        } else {
            this.f10984t.setBackgroundResource(R.drawable.select_btn_menu);
            this.f10984t.setText("");
        }
        this.f10985u = (TextView) super.findViewById(R.id.btn_right);
        this.f10985u.setOnClickListener(new View$OnClickListenerC2219e(this));
        this.f10986v = (TextView) super.findViewById(R.id.tv_title);
        this.f10987w = (TextView) super.findViewById(R.id.btn_factory_pattern);
        if (C2744aa.m5148g()) {
            this.f10973E = new int[]{R.id.btn_all};
        } else {
            C2744aa.m5135m();
            if (C2744aa.m5166c() && !C2744aa.m5145h()) {
                this.f10973E = new int[]{R.id.btn_all, R.id.btn_america, R.id.btn_europe, R.id.btn_asia, R.id.btn_reset, R.id.btn_heavyduty, R.id.btn_History};
            } else if (C2744aa.m5155e()) {
                this.f10973E = new int[]{R.id.btn_america, R.id.btn_europe, R.id.btn_asia, R.id.btn_reset, R.id.btn_heavyduty, R.id.btn_favorites, R.id.btn_History};
            } else {
                this.f10973E = new int[]{R.id.btn_america, R.id.btn_europe, R.id.btn_asia, R.id.btn_china, R.id.btn_reset, R.id.btn_heavyduty, R.id.btn_History};
            }
        }
        this.f10972D = new ArrayList();
        for (int i : this.f10973E) {
            this.f10972D.add((RadioButton) this.f10983s.findViewById(R.id.radioGroup_head).findViewById(i));
        }
        m7731h();
        this.f10978n = AsyncTaskManager.m9574a(this.f10981q);
        IntentFilter intentFilter = new IntentFilter("login");
        intentFilter.addAction("logout");
        intentFilter.addAction("changeFace");
        intentFilter.addAction("unupgradeSoftNumChanged");
        registerReceiver(this.f10989y, intentFilter);
        this.f10977I = (ImageView) super.findViewById(R.id.img_right);
        this.f10974F = (TextView) findViewById(R.id.menu_update_tip);
        if (PreferencesManager.m9595a(this.f10981q).m9585b("unupdateSoftwareNum", 0) + PreferencesManager.m9595a(this.f10981q).m9585b("unupdateSoftwareNumForHeavyduty", 0) > 0) {
            m7735e(0);
        } else {
            m7735e(8);
        }
    }

    /* renamed from: f */
    private void m7733f(int i) {
        if (!this.f10975G) {
            this.f10975G = false;
        }
        for (RadioButton radioButton : this.f10972D) {
            RadioGroup.LayoutParams layoutParams = (RadioGroup.LayoutParams) radioButton.getLayoutParams();
            layoutParams.weight = i;
            radioButton.setLayoutParams(layoutParams);
        }
    }

    @Override // android.support.p012v4.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        Log.e("CM", "base activity screen change");
        m7731h();
    }

    /* renamed from: h */
    private void m7731h() {
        if (getResources().getConfiguration().orientation == 2) {
            m7733f(0);
            this.f10985u.setMaxEms(10);
            return;
        }
        m7733f(1);
        this.f10985u.setMaxEms(3);
    }

    @Override // android.support.p012v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        m7731h();
        String m9584b = this.f10976H.m9584b("login_state", "0");
        if (m9584b != null && m9584b.equals("1")) {
            this.f10985u.setVisibility(8);
            this.f10977I.setVisibility(0);
            ImageLoader.m4191a().m4188a(UserFaceUtils.m9114a(PreferencesManager.m9595a(this.f10981q).m9591a("user_id"), null, PreferencesManager.m9595a(this.f10981q).m9591a("current_country").equalsIgnoreCase("CN") ? "1" : "2"), this.f10977I, m7730i());
        } else {
            if (C1947h.f10551c) {
                this.f10985u.setVisibility(8);
            } else {
                this.f10985u.setVisibility(0);
            }
            this.f10977I.setVisibility(8);
            this.f10985u.setText(R.string.login_right);
            this.f10985u.setClickable(true);
        }
        for (RadioButton radioButton : this.f10972D) {
            switch (radioButton.getId()) {
                case R.id.btn_History /* 2131296396 */:
                    radioButton.setText(R.string.History_title_txt);
                    break;
                case R.id.btn_all /* 2131296402 */:
                    radioButton.setText(R.string.diagnose_all_title);
                    break;
                case R.id.btn_america /* 2131296403 */:
                    radioButton.setText(R.string.diagnose_america_title);
                    break;
                case R.id.btn_asia /* 2131296405 */:
                    radioButton.setText(R.string.diagnose_asia_title);
                    break;
                case R.id.btn_china /* 2131296419 */:
                    radioButton.setText(R.string.diagnose_china_title);
                    break;
                case R.id.btn_europe /* 2131296442 */:
                    radioButton.setText(R.string.diagnose_europe_title);
                    break;
                case R.id.btn_favorites /* 2131296448 */:
                    radioButton.setText(R.string.diagnose_favorites_title);
                    break;
                case R.id.btn_heavyduty /* 2131296472 */:
                    radioButton.setText(R.string.diagnose_heavyduty_title);
                    break;
                case R.id.btn_reset /* 2131296538 */:
                    radioButton.setText(R.string.diagnose_reset_title);
                    break;
            }
        }
    }

    @Override // android.app.Activity
    public void setContentView(View view) {
        if (this.f10971C.getChildCount() > 1) {
            this.f10971C.removeViewAt(1);
        }
        this.f10971C.addView(view, new LinearLayout.LayoutParams(-1, -1, 1.0f));
        this.f10982r = view;
    }

    @Override // android.app.Activity
    public void setContentView(int i) {
        setContentView(LayoutInflater.from(this).inflate(i, (ViewGroup) null));
    }

    @Override // android.support.p012v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        ActivityPageManager.m9631a(this.f10982r);
        ActivityPageManager.m9634a();
        ActivityPageManager.m9628b(this);
        this.f10982r = null;
        this.f10981q = null;
        unregisterReceiver(this.f10989y);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getAction() == 0) {
            if (getFragmentManager().getBackStackEntryCount() > 0) {
                getFragmentManager().popBackStack();
                return true;
            }
            new C2221g(this).m4607b(this.f10981q, R.string.common_exit_dialog_title, R.string.common_exit_dialog_content, true);
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* renamed from: c */
    public final void m7739c(int i) {
        this.f10978n.m9575a(i, true, this);
    }

    @Override // com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public void onFailure(int i, int i2, Object obj) {
        if (i2 != -999) {
            if (i2 == -400) {
                Context context = this.f10981q;
                if (context != null) {
                    NToast.m9450a(context, (int) R.string.common_network_unavailable);
                    return;
                }
                return;
            } else if (i2 != -200) {
                return;
            }
        }
        Context context2 = this.f10981q;
        if (context2 != null) {
            NToast.m9447b(context2, (int) R.string.common_network_error);
        }
    }

    /* renamed from: b */
    public final void m7743b() {
        this.f10983s.setVisibility(8);
    }

    /* renamed from: d */
    public final void m7737d(int i) {
        this.f10984t.setVisibility(i);
    }

    /* renamed from: c */
    public final void m7740c() {
        this.f10985u.setVisibility(8);
    }

    @Override // android.app.Activity
    public void setTitle(int i) {
        this.f10986v.setText(getString(i));
    }

    /* renamed from: d */
    public final void m7738d() {
        this.f10990z = (RelativeLayout) findViewById(R.id.search_view);
        this.f10990z.setVisibility(0);
    }

    /* renamed from: e */
    public final void m7736e() {
        this.f10990z = (RelativeLayout) findViewById(R.id.search_view);
        this.f10990z.setVisibility(8);
    }

    /* renamed from: f */
    public final RelativeLayout m7734f() {
        return this.f10990z;
    }

    /* renamed from: a */
    public final void m7744a(String str) {
        this.f10986v.setText(str);
    }

    /* renamed from: g */
    public final SlidingMenu m7732g() {
        if (getParent() != null) {
            this.f10980p = ((MainActivity) getParent()).f10737b;
        }
        return this.f10980p;
    }

    /* renamed from: b */
    public void mo5888b(String str, Bundle bundle) {
        getFragmentManager().beginTransaction().add(R.id.layout_fragment_contanier, Fragment.instantiate(this.f10981q, str, bundle), str).commit();
    }

    /* renamed from: b */
    public final void m7741b(String str) {
        Fragment instantiate;
        Fragment findFragmentByTag = this.f10969A.findFragmentByTag(str);
        if (findFragmentByTag == null) {
            instantiate = Fragment.instantiate(this.f10981q, str);
        } else {
            getFragmentManager().beginTransaction().detach(findFragmentByTag).commitAllowingStateLoss();
            instantiate = Fragment.instantiate(this.f10981q, str);
        }
        FragmentTransaction beginTransaction = this.f10969A.beginTransaction();
        beginTransaction.replace(R.id.layout_fragment_contanier, instantiate, str);
        beginTransaction.commitAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public synchronized DisplayImageOptions m7730i() {
        if (this.f10970B == null) {
            DisplayImageOptions.C3010a c3010a = new DisplayImageOptions.C3010a();
            c3010a.f17117a = R.drawable.login_default;
            c3010a.f17118b = R.drawable.login_default;
            c3010a.f17119c = R.drawable.login_default;
            c3010a.f17129m = true;
            c3010a.f17133q = new RoundedBitmapDisplayer(90);
            this.f10970B = c3010a.m4193a();
        }
        return this.f10970B;
    }

    /* renamed from: e */
    public final void m7735e(int i) {
        if (i != 0 || this.f10988x) {
            this.f10974F.setVisibility(i);
        }
    }
}
