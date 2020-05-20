package com.cnlaunch.x431pro.activity.diagnose;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.support.p012v4.view.ViewPager;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import com.cnlaunch.diagnosemodule.utils.DiagnoseConstants;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.p120d.p125c.p128c.C1425f;
import com.cnlaunch.p120d.p130d.NLog;
import com.cnlaunch.p120d.p130d.NToast;
import com.cnlaunch.p120d.p130d.p131a.LangManager;
import com.cnlaunch.x431pro.activity.BaseFragment;
import com.cnlaunch.x431pro.activity.MainActivity;
import com.cnlaunch.x431pro.activity.diagnose.p218a.CarIconAdapter;
import com.cnlaunch.x431pro.activity.diagnose.p218a.ViewPagerAdapter;
import com.cnlaunch.x431pro.activity.diagnose.p222e.OnKeyDownListenter;
import com.cnlaunch.x431pro.activity.golo.others.GoloTextWatcher;
import com.cnlaunch.x431pro.activity.p211a.HistoryFragment;
import com.cnlaunch.x431pro.activity.p213b.p214a.SellerAction;
import com.cnlaunch.x431pro.activity.p213b.p215b.GetShopStatisticResponse;
import com.cnlaunch.x431pro.activity.upgrade.p240c.ApkUpgradeAndDownloadLogic;
import com.cnlaunch.x431pro.module.p269j.p270a.UpgradeAction;
import com.cnlaunch.x431pro.module.p269j.p271b.LatestDiagSoftsResponse;
import com.cnlaunch.x431pro.module.p269j.p271b.LatestPublicSoftsResponse;
import com.cnlaunch.x431pro.module.p269j.p271b.PublicSoftLatestVersionDetail;
import com.cnlaunch.x431pro.module.p269j.p271b.PublicSoftLatestVersionResult;
import com.cnlaunch.x431pro.module.p269j.p271b.X431PadDtoSoft;
import com.cnlaunch.x431pro.p210a.C1947h;
import com.cnlaunch.x431pro.p210a.C1951o;
import com.cnlaunch.x431pro.p210a.RTUHelper;
import com.cnlaunch.x431pro.utils.ApkUpgradeUtils;
import com.cnlaunch.x431pro.utils.AppUsageNumRecord;
import com.cnlaunch.x431pro.utils.C2744aa;
import com.cnlaunch.x431pro.utils.C2778n;
import com.cnlaunch.x431pro.utils.C2787z;
import com.cnlaunch.x431pro.utils.FirstLetterUtils;
import com.cnlaunch.x431pro.utils.PathUtils;
import com.cnlaunch.x431pro.utils.p282d.DiagnoseUtils;
import com.cnlaunch.x431pro.utils.p283db.CarIcon;
import com.cnlaunch.x431pro.utils.p283db.CarIconDao;
import com.cnlaunch.x431pro.utils.p283db.FavoritesCarIconDao;
import com.cnlaunch.x431pro.utils.p283db.p284a.DBManager;
import com.cnlaunch.x431pro.utils.p283db.p284a.FavoritesDBManager;
import com.cnlaunch.x431pro.utils.p285e.FileUtils;
import com.cnlaunch.x431pro.utils.p286f.CarIconUtils;
import com.cnlaunch.x431pro.widget.DragGridView;
import com.cnlaunch.x431pro.widget.MyViewPager;
import com.cnlaunch.x431pro.widget.p290a.BaseDialog;
import com.cnlaunch.x431pro.widget.p290a.LoadDialog;
import com.cnlaunch.x431pro.widget.p290a.MessageDialog;
import com.cnlaunch.x431pro.widget.p290a.SelectMessageDialog;
import com.cnlaunch.x431pro.widget.sortlistview.CharacterParser;
import com.ifoer.expedition.pro.R;
import de.greenrobot.dao.query.QueryBuilder;
import de.greenrobot.dao.query.WhereCondition;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* renamed from: com.cnlaunch.x431pro.activity.diagnose.a */
/* loaded from: classes.dex */
public class CarIconFragmentForAll extends BaseFragment implements ViewPager.InterfaceC0176e, View.OnClickListener, View.OnFocusChangeListener, AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener, RadioGroup.OnCheckedChangeListener, OnKeyDownListenter {

    /* renamed from: al */
    private static int f11143al = 0;

    /* renamed from: b */
    private static final String f11144b = "a";

    /* renamed from: A */
    private GridView f11145A;

    /* renamed from: B */
    private GridView f11146B;

    /* renamed from: C */
    private GridView f11147C;

    /* renamed from: D */
    private GridView f11148D;

    /* renamed from: E */
    private GridView f11149E;

    /* renamed from: F */
    private GridView f11150F;

    /* renamed from: G */
    private View f11151G;

    /* renamed from: H */
    private View f11152H;

    /* renamed from: I */
    private View f11153I;

    /* renamed from: J */
    private View f11154J;

    /* renamed from: K */
    private View f11155K;

    /* renamed from: L */
    private View f11156L;

    /* renamed from: M */
    private View f11157M;

    /* renamed from: N */
    private View f11158N;

    /* renamed from: O */
    private View f11159O;

    /* renamed from: P */
    private List<CarIcon> f11160P;

    /* renamed from: Q */
    private List<CarIcon> f11161Q;

    /* renamed from: R */
    private List<CarIcon> f11162R;

    /* renamed from: S */
    private List<CarIcon> f11163S;

    /* renamed from: T */
    private List<CarIcon> f11164T;

    /* renamed from: U */
    private List<CarIcon> f11165U;

    /* renamed from: V */
    private List<CarIcon> f11166V;

    /* renamed from: W */
    private List<CarIcon> f11167W;

    /* renamed from: X */
    private String f11168X;

    /* renamed from: Z */
    private String f11170Z;

    /* renamed from: aA */
    private DragGridView f11172aA;

    /* renamed from: aB */
    private DragGridView f11173aB;

    /* renamed from: aC */
    private DragGridView f11174aC;

    /* renamed from: aE */
    private PopupWindow f11176aE;

    /* renamed from: aH */
    private boolean f11179aH;

    /* renamed from: aJ */
    private String f11181aJ;

    /* renamed from: aK */
    private GoloTextWatcher f11182aK;

    /* renamed from: aN */
    private SelectMessageDialog f11185aN;

    /* renamed from: aa */
    private String f11190aa;

    /* renamed from: ab */
    private RadioButton f11191ab;

    /* renamed from: ac */
    private RadioButton f11192ac;

    /* renamed from: ad */
    private RadioButton f11193ad;

    /* renamed from: ae */
    private RadioButton f11194ae;

    /* renamed from: af */
    private RadioButton f11195af;

    /* renamed from: ag */
    private RadioButton f11196ag;

    /* renamed from: ah */
    private RadioButton f11197ah;

    /* renamed from: ai */
    private RadioButton f11198ai;

    /* renamed from: aj */
    private RadioButton f11199aj;

    /* renamed from: am */
    private boolean f11201am;

    /* renamed from: an */
    private boolean f11202an;

    /* renamed from: ao */
    private MessageDialog f11203ao;

    /* renamed from: ap */
    private String f11204ap;

    /* renamed from: aq */
    private String f11205aq;

    /* renamed from: ar */
    private String f11206ar;

    /* renamed from: at */
    private boolean f11208at;

    /* renamed from: au */
    private int f11209au;

    /* renamed from: av */
    private int f11210av;

    /* renamed from: ax */
    private DragGridView f11212ax;

    /* renamed from: ay */
    private DragGridView f11213ay;

    /* renamed from: az */
    private DragGridView f11214az;

    /* renamed from: l */
    private MyViewPager f11224l;

    /* renamed from: m */
    private ViewPagerAdapter f11225m;

    /* renamed from: n */
    private ArrayList<View> f11226n;

    /* renamed from: o */
    private CarIconAdapter f11227o;

    /* renamed from: p */
    private CarIconAdapter f11228p;

    /* renamed from: q */
    private CarIconAdapter f11229q;

    /* renamed from: r */
    private CarIconAdapter f11230r;

    /* renamed from: s */
    private CarIconAdapter f11231s;

    /* renamed from: t */
    private CarIconAdapter f11232t;

    /* renamed from: u */
    private CarIconAdapter f11233u;

    /* renamed from: v */
    private CarIconAdapter f11234v;

    /* renamed from: w */
    private CarIconAdapter f11235w;

    /* renamed from: x */
    private GridView f11236x;

    /* renamed from: y */
    private GridView f11237y;

    /* renamed from: z */
    private GridView f11238z;

    /* renamed from: c */
    private final int f11215c = 10010;

    /* renamed from: d */
    private final int f11216d = 10011;

    /* renamed from: e */
    private final int f11217e = 2101;

    /* renamed from: f */
    private final int f11218f = 2102;

    /* renamed from: g */
    private final int f11219g = 2105;

    /* renamed from: h */
    private final int f11220h = 2106;

    /* renamed from: i */
    private final int f11221i = 2107;

    /* renamed from: j */
    private final int f11222j = 2108;

    /* renamed from: k */
    private final int f11223k = 2200;

    /* renamed from: Y */
    private RTUHelper f11169Y = null;

    /* renamed from: ak */
    private BaseDialog f11200ak = null;

    /* renamed from: a */
    boolean f11171a = false;

    /* renamed from: as */
    private List<X431PadDtoSoft> f11207as = new ArrayList();

    /* renamed from: aw */
    private boolean f11211aw = false;

    /* renamed from: aD */
    private int f11175aD = 0;

    /* renamed from: aF */
    private boolean f11177aF = false;

    /* renamed from: aG */
    private Handler f11178aG = new Handler();

    /* renamed from: aI */
    private boolean f11180aI = false;

    /* renamed from: aL */
    private String f11183aL = "";

    /* renamed from: aM */
    private boolean f11184aM = false;

    /* renamed from: aO */
    private final BroadcastReceiver f11186aO = new C2204l(this);

    /* renamed from: aP */
    private Handler f11187aP = new HandlerC2206n(this);

    /* renamed from: aQ */
    private Runnable f11188aQ = new RunnableC2209q(this);

    /* renamed from: aR */
    private Runnable f11189aR = new RunnableC2203k(this);

    @Override // android.support.p012v4.view.ViewPager.InterfaceC0176e
    /* renamed from: a */
    public final void mo1773a(int i, float f, int i2) {
    }

    @Override // android.support.p012v4.view.ViewPager.InterfaceC0176e
    /* renamed from: a_ */
    public final void mo1772a_(int i) {
    }

    @Override // com.cnlaunch.x431pro.activity.diagnose.p222e.OnKeyDownListenter
    /* renamed from: i_ */
    public final void mo6838i_() {
    }

    @Override // android.widget.RadioGroup.OnCheckedChangeListener
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public static /* synthetic */ int m7561c() {
        f11143al = 0;
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: n */
    public static /* synthetic */ MessageDialog m7538n(CarIconFragmentForAll carIconFragmentForAll) {
        carIconFragmentForAll.f11203ao = null;
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: r */
    public static /* synthetic */ int m7534r(CarIconFragmentForAll carIconFragmentForAll) {
        int i = carIconFragmentForAll.f11175aD;
        carIconFragmentForAll.f11175aD = i + 1;
        return i;
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        String m9591a = PreferencesManager.m9595a(this.mContext).m9591a("currentLanguage");
        String m5131o = C2744aa.m5131o();
        if (TextUtils.isEmpty(m9591a)) {
            PreferencesManager.m9595a(this.mContext).m9588a("currentLanguage", m5131o);
        } else if (!m9591a.equals(m5131o)) {
            m7544i();
            PreferencesManager.m9595a(this.mContext).m9588a("currentLanguage", m5131o);
        }
        if (C2744aa.m5166c()) {
            this.f11169Y = new C2186f(this, this.mContext);
            this.f11169Y.m7943b();
            RTUHelper rTUHelper = this.f11169Y;
            if (PreferencesManager.m9595a(rTUHelper.f10589e).m9583b("tryFlag", false) && !C1947h.f10551c) {
                rTUHelper.f10588d = Long.valueOf(PreferencesManager.m9595a(rTUHelper.f10589e).m9586b("lastRemindTime"));
                rTUHelper.f10586b = Long.valueOf(PreferencesManager.m9595a(rTUHelper.f10589e).m9586b("tryFlagStartTime"));
                rTUHelper.f10587c = Long.valueOf(System.currentTimeMillis());
                if (rTUHelper.f10586b.longValue() > rTUHelper.f10587c.longValue()) {
                    NToast.m9446b(rTUHelper.f10589e, rTUHelper.f10589e.getResources().getString(R.string.tryflag_illegal_operation));
                    rTUHelper.mo7066a();
                } else if (rTUHelper.f10586b.longValue() < rTUHelper.f10587c.longValue() && rTUHelper.f10587c.longValue() <= rTUHelper.f10586b.longValue() + 1814400000) {
                    if (rTUHelper.f10586b.longValue() < rTUHelper.f10587c.longValue() && rTUHelper.f10587c.longValue() <= rTUHelper.f10586b.longValue() + 604800000) {
                        if (rTUHelper.f10588d.longValue() == 0) {
                            PreferencesManager.m9595a(rTUHelper.f10589e).m9589a("lastRemindTime", rTUHelper.f10587c.longValue());
                            rTUHelper.m7942c();
                            rTUHelper.m7941d();
                        } else if (rTUHelper.f10588d.longValue() > rTUHelper.f10587c.longValue()) {
                            NToast.m9446b(rTUHelper.f10589e, rTUHelper.f10589e.getResources().getString(R.string.tryflag_illegal_operation));
                            rTUHelper.mo7066a();
                        } else if (rTUHelper.f10586b.longValue() <= rTUHelper.f10588d.longValue()) {
                            rTUHelper.f10588d.longValue();
                            rTUHelper.f10586b.longValue();
                        }
                    }
                    if (rTUHelper.f10586b.longValue() + 604800000 < rTUHelper.f10587c.longValue() && rTUHelper.f10587c.longValue() <= rTUHelper.f10586b.longValue() + 1209600000) {
                        if (rTUHelper.f10588d.longValue() == 0) {
                            PreferencesManager.m9595a(rTUHelper.f10589e).m9589a("lastRemindTime", rTUHelper.f10587c.longValue());
                            rTUHelper.m7942c();
                            rTUHelper.m7941d();
                        } else if (rTUHelper.f10588d.longValue() > rTUHelper.f10587c.longValue()) {
                            NToast.m9446b(rTUHelper.f10589e, rTUHelper.f10589e.getResources().getString(R.string.tryflag_illegal_operation));
                            rTUHelper.mo7066a();
                        } else if (rTUHelper.f10586b.longValue() <= rTUHelper.f10588d.longValue() && rTUHelper.f10588d.longValue() <= rTUHelper.f10586b.longValue() + 604800000) {
                            PreferencesManager.m9595a(rTUHelper.f10589e).m9589a("lastRemindTime", rTUHelper.f10587c.longValue());
                            rTUHelper.m7942c();
                            rTUHelper.m7941d();
                        } else if (rTUHelper.f10586b.longValue() + 604800000 < rTUHelper.f10588d.longValue()) {
                            rTUHelper.f10588d.longValue();
                            rTUHelper.f10586b.longValue();
                        }
                    }
                    if (rTUHelper.f10586b.longValue() + 1209600000 < rTUHelper.f10587c.longValue() && rTUHelper.f10587c.longValue() <= rTUHelper.f10586b.longValue() + 1814400000) {
                        if (rTUHelper.f10588d.longValue() == 0) {
                            PreferencesManager.m9595a(rTUHelper.f10589e).m9589a("lastRemindTime", rTUHelper.f10587c.longValue());
                            rTUHelper.m7942c();
                            rTUHelper.m7941d();
                        } else if (rTUHelper.f10588d.longValue() > rTUHelper.f10587c.longValue()) {
                            NToast.m9446b(rTUHelper.f10589e, rTUHelper.f10589e.getResources().getString(R.string.tryflag_illegal_operation));
                            rTUHelper.mo7066a();
                        } else if (rTUHelper.f10586b.longValue() <= rTUHelper.f10588d.longValue() && rTUHelper.f10588d.longValue() <= rTUHelper.f10586b.longValue() + 1209600000) {
                            PreferencesManager.m9595a(rTUHelper.f10589e).m9589a("lastRemindTime", rTUHelper.f10587c.longValue());
                            rTUHelper.m7942c();
                            rTUHelper.m7941d();
                        } else if (rTUHelper.f10586b.longValue() + 1209600000 < rTUHelper.f10588d.longValue()) {
                            int i = (rTUHelper.f10588d.longValue() > (rTUHelper.f10586b.longValue() + 1814400000) ? 1 : (rTUHelper.f10588d.longValue() == (rTUHelper.f10586b.longValue() + 1814400000) ? 0 : -1));
                        }
                    }
                } else if (rTUHelper.f10586b.longValue() + 1814400000 < rTUHelper.f10587c.longValue() && rTUHelper.f10587c.longValue() <= rTUHelper.f10586b.longValue() + 2419200000L) {
                    if (rTUHelper.f10586b.longValue() + 1814400000 < rTUHelper.f10587c.longValue() && rTUHelper.f10587c.longValue() <= rTUHelper.f10586b.longValue() + 1814400000 + 86400000) {
                        if (rTUHelper.f10588d.longValue() == 0) {
                            PreferencesManager.m9595a(rTUHelper.f10589e).m9589a("lastRemindTime", rTUHelper.f10587c.longValue());
                            rTUHelper.m7942c();
                            rTUHelper.m7941d();
                        } else if (rTUHelper.f10588d.longValue() > rTUHelper.f10587c.longValue()) {
                            NToast.m9446b(rTUHelper.f10589e, rTUHelper.f10589e.getResources().getString(R.string.tryflag_illegal_operation));
                            rTUHelper.mo7066a();
                        } else if (rTUHelper.f10586b.longValue() <= rTUHelper.f10588d.longValue() && rTUHelper.f10588d.longValue() <= rTUHelper.f10586b.longValue() + 1814400000) {
                            PreferencesManager.m9595a(rTUHelper.f10589e).m9589a("lastRemindTime", rTUHelper.f10587c.longValue());
                            rTUHelper.m7942c();
                            rTUHelper.m7941d();
                        } else if (rTUHelper.f10586b.longValue() + 1814400000 < rTUHelper.f10588d.longValue()) {
                            rTUHelper.f10588d.longValue();
                            rTUHelper.f10586b.longValue();
                        }
                    }
                    if (rTUHelper.f10586b.longValue() + 1814400000 + 86400000 < rTUHelper.f10587c.longValue() && rTUHelper.f10587c.longValue() <= rTUHelper.f10586b.longValue() + 1814400000 + 172800000) {
                        if (rTUHelper.f10588d.longValue() == 0) {
                            PreferencesManager.m9595a(rTUHelper.f10589e).m9589a("lastRemindTime", rTUHelper.f10587c.longValue());
                            rTUHelper.m7942c();
                            rTUHelper.m7941d();
                        } else if (rTUHelper.f10588d.longValue() > rTUHelper.f10587c.longValue()) {
                            NToast.m9446b(rTUHelper.f10589e, rTUHelper.f10589e.getResources().getString(R.string.tryflag_illegal_operation));
                            rTUHelper.mo7066a();
                        } else if (rTUHelper.f10586b.longValue() <= rTUHelper.f10588d.longValue() && rTUHelper.f10588d.longValue() <= rTUHelper.f10586b.longValue() + 1814400000 + 86400000) {
                            PreferencesManager.m9595a(rTUHelper.f10589e).m9589a("lastRemindTime", rTUHelper.f10587c.longValue());
                            rTUHelper.m7942c();
                            rTUHelper.m7941d();
                        } else if (rTUHelper.f10586b.longValue() + 1814400000 + 86400000 < rTUHelper.f10588d.longValue()) {
                            rTUHelper.f10588d.longValue();
                            rTUHelper.f10586b.longValue();
                        }
                    }
                    if (rTUHelper.f10586b.longValue() + 1814400000 + 172800000 < rTUHelper.f10587c.longValue() && rTUHelper.f10587c.longValue() <= rTUHelper.f10586b.longValue() + 1814400000 + 259200000) {
                        if (rTUHelper.f10588d.longValue() == 0) {
                            PreferencesManager.m9595a(rTUHelper.f10589e).m9589a("lastRemindTime", rTUHelper.f10587c.longValue());
                            rTUHelper.m7942c();
                            rTUHelper.m7941d();
                        } else if (rTUHelper.f10588d.longValue() > rTUHelper.f10587c.longValue()) {
                            NToast.m9446b(rTUHelper.f10589e, rTUHelper.f10589e.getResources().getString(R.string.tryflag_illegal_operation));
                            rTUHelper.mo7066a();
                        } else if (rTUHelper.f10586b.longValue() <= rTUHelper.f10588d.longValue() && rTUHelper.f10588d.longValue() <= rTUHelper.f10586b.longValue() + 1814400000 + 172800000) {
                            PreferencesManager.m9595a(rTUHelper.f10589e).m9589a("lastRemindTime", rTUHelper.f10587c.longValue());
                            rTUHelper.m7942c();
                            rTUHelper.m7941d();
                        } else if (rTUHelper.f10586b.longValue() + 1814400000 + 172800000 < rTUHelper.f10588d.longValue()) {
                            rTUHelper.f10588d.longValue();
                            rTUHelper.f10586b.longValue();
                        }
                    }
                    if (rTUHelper.f10586b.longValue() + 1814400000 + 259200000 < rTUHelper.f10587c.longValue() && rTUHelper.f10587c.longValue() <= rTUHelper.f10586b.longValue() + 1814400000 + 345600000) {
                        if (rTUHelper.f10588d.longValue() == 0) {
                            PreferencesManager.m9595a(rTUHelper.f10589e).m9589a("lastRemindTime", rTUHelper.f10587c.longValue());
                            rTUHelper.m7942c();
                            rTUHelper.m7941d();
                        } else if (rTUHelper.f10588d.longValue() > rTUHelper.f10587c.longValue()) {
                            NToast.m9446b(rTUHelper.f10589e, rTUHelper.f10589e.getResources().getString(R.string.tryflag_illegal_operation));
                            rTUHelper.mo7066a();
                        } else if (rTUHelper.f10586b.longValue() <= rTUHelper.f10588d.longValue() && rTUHelper.f10588d.longValue() <= rTUHelper.f10586b.longValue() + 1814400000 + 259200000) {
                            PreferencesManager.m9595a(rTUHelper.f10589e).m9589a("lastRemindTime", rTUHelper.f10587c.longValue());
                            rTUHelper.m7942c();
                            rTUHelper.m7941d();
                        } else if (rTUHelper.f10586b.longValue() + 1814400000 + 259200000 < rTUHelper.f10588d.longValue()) {
                            rTUHelper.f10588d.longValue();
                            rTUHelper.f10586b.longValue();
                        }
                    }
                    if (rTUHelper.f10586b.longValue() + 1814400000 + 345600000 < rTUHelper.f10587c.longValue() && rTUHelper.f10587c.longValue() <= rTUHelper.f10586b.longValue() + 1814400000 + 432000000) {
                        if (rTUHelper.f10588d.longValue() == 0) {
                            PreferencesManager.m9595a(rTUHelper.f10589e).m9589a("lastRemindTime", rTUHelper.f10587c.longValue());
                            rTUHelper.m7942c();
                            rTUHelper.m7941d();
                        } else if (rTUHelper.f10588d.longValue() > rTUHelper.f10587c.longValue()) {
                            NToast.m9446b(rTUHelper.f10589e, rTUHelper.f10589e.getResources().getString(R.string.tryflag_illegal_operation));
                            rTUHelper.mo7066a();
                        } else if (rTUHelper.f10586b.longValue() <= rTUHelper.f10588d.longValue() && rTUHelper.f10588d.longValue() <= rTUHelper.f10586b.longValue() + 1814400000 + 345600000) {
                            PreferencesManager.m9595a(rTUHelper.f10589e).m9589a("lastRemindTime", rTUHelper.f10587c.longValue());
                            rTUHelper.m7942c();
                            rTUHelper.m7941d();
                        } else if (rTUHelper.f10586b.longValue() + 1814400000 + 345600000 < rTUHelper.f10588d.longValue()) {
                            rTUHelper.f10588d.longValue();
                            rTUHelper.f10586b.longValue();
                        }
                    }
                    if (rTUHelper.f10586b.longValue() + 1814400000 + 432000000 < rTUHelper.f10587c.longValue() && rTUHelper.f10587c.longValue() <= rTUHelper.f10586b.longValue() + 1814400000 + 518400000) {
                        if (rTUHelper.f10588d.longValue() == 0) {
                            PreferencesManager.m9595a(rTUHelper.f10589e).m9589a("lastRemindTime", rTUHelper.f10587c.longValue());
                            rTUHelper.m7942c();
                            rTUHelper.m7941d();
                        } else if (rTUHelper.f10588d.longValue() > rTUHelper.f10587c.longValue()) {
                            NToast.m9446b(rTUHelper.f10589e, rTUHelper.f10589e.getResources().getString(R.string.tryflag_illegal_operation));
                            rTUHelper.mo7066a();
                        } else if (rTUHelper.f10586b.longValue() <= rTUHelper.f10588d.longValue() && rTUHelper.f10588d.longValue() <= rTUHelper.f10586b.longValue() + 1814400000 + 432000000) {
                            PreferencesManager.m9595a(rTUHelper.f10589e).m9589a("lastRemindTime", rTUHelper.f10587c.longValue());
                            rTUHelper.m7942c();
                            rTUHelper.m7941d();
                        } else if (rTUHelper.f10586b.longValue() + 1814400000 + 432000000 < rTUHelper.f10588d.longValue()) {
                            rTUHelper.f10588d.longValue();
                            rTUHelper.f10586b.longValue();
                        }
                    }
                    if (rTUHelper.f10586b.longValue() + 1814400000 + 518400000 < rTUHelper.f10587c.longValue() && rTUHelper.f10587c.longValue() <= rTUHelper.f10586b.longValue() + 1814400000 + 604800000) {
                        if (rTUHelper.f10588d.longValue() == 0) {
                            PreferencesManager.m9595a(rTUHelper.f10589e).m9589a("lastRemindTime", rTUHelper.f10587c.longValue());
                            rTUHelper.m7942c();
                            rTUHelper.m7941d();
                        } else if (rTUHelper.f10588d.longValue() > rTUHelper.f10587c.longValue()) {
                            NToast.m9446b(rTUHelper.f10589e, rTUHelper.f10589e.getResources().getString(R.string.tryflag_illegal_operation));
                            rTUHelper.mo7066a();
                        } else if (rTUHelper.f10586b.longValue() <= rTUHelper.f10588d.longValue() && rTUHelper.f10588d.longValue() <= rTUHelper.f10586b.longValue() + 1814400000 + 518400000) {
                            PreferencesManager.m9595a(rTUHelper.f10589e).m9589a("lastRemindTime", rTUHelper.f10587c.longValue());
                            rTUHelper.m7942c();
                            rTUHelper.m7941d();
                        } else if (rTUHelper.f10586b.longValue() + 1814400000 + 518400000 < rTUHelper.f10588d.longValue()) {
                            int i2 = (rTUHelper.f10588d.longValue() > (rTUHelper.f10586b.longValue() + 1814400000 + 604800000) ? 1 : (rTUHelper.f10588d.longValue() == (rTUHelper.f10586b.longValue() + 1814400000 + 604800000) ? 0 : -1));
                        }
                    }
                } else if (rTUHelper.f10586b.longValue() + 2419200000L < rTUHelper.f10587c.longValue() && rTUHelper.f10586b.longValue() != 0) {
                    PreferencesManager.m9595a(rTUHelper.f10589e).m9589a("lastRemindTime", rTUHelper.f10587c.longValue());
                    rTUHelper.m7942c();
                    new C1951o(rTUHelper).m4603a(rTUHelper.f10589e);
                }
            }
        }
        this.f11168X = PreferencesManager.m9595a(this.mContext).m9591a("serialNo");
        this.f11190aa = PreferencesManager.m9595a(this.mContext).m9591a("carSerialNo");
        this.f11170Z = PreferencesManager.m9595a(this.mContext).m9591a("heavydutySerialNo");
        String str = f11144b;
        NLog.m9456a(str, "carSerialNo=" + this.f11190aa + ",heavydutySerialNo=" + this.f11170Z + ",currentSerial=" + this.f11168X);
        this.f11202an = PreferencesManager.m9595a(this.mContext).m9583b("enable_history_diagnose", false);
        this.f11201am = PreferencesManager.m9595a(this.mContext).m9583b("enable_vinscan", false);
        try {
            m7556d();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("softs_updated");
            intentFilter.addAction("refresh_softs");
            intentFilter.addAction("login");
            intentFilter.addAction("LoginActivityKeyBack");
            intentFilter.addAction("login_change_serialno");
            intentFilter.addAction("addedFavorites");
            intentFilter.addAction("deletedFavorites");
            intentFilter.addAction("stopDrag");
            this.mContext.registerReceiver(this.f11186aO, intentFilter);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        view.setOnTouchListener(new View$OnTouchListenerC2066b(this));
        super.onViewCreated(view, bundle);
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment
    public View onCreateFragmentView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.diagnose_fragment, viewGroup, false);
        this.f11224l = (MyViewPager) inflate.findViewById(R.id.viewPager);
        return inflate;
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        MainActivity.m7871h();
        if (MainActivity.m7871h() != R.id.btn_diagnose) {
            return;
        }
        MyViewPager myViewPager = this.f11224l;
        if (myViewPager != null) {
            if (myViewPager.getCurrentItem() == 0) {
                ((DiagnoseActivity) this.mContext).m7732g().setTouchModeAbove(1);
            } else {
                ((DiagnoseActivity) this.mContext).m7732g().setTouchModeAbove(2);
            }
        }
        this.f11168X = PreferencesManager.m9595a(this.mContext).m9591a("serialNo");
        this.f11190aa = PreferencesManager.m9595a(this.mContext).m9591a("carSerialNo");
        this.f11170Z = PreferencesManager.m9595a(this.mContext).m9591a("heavydutySerialNo");
        boolean m9583b = PreferencesManager.m9595a(this.mContext).m9583b("need_refresh", true);
        String str = f11144b;
        NLog.m9456a(str, "onResume carSerialNo=" + this.f11190aa + ",heavydutySerialNo=" + this.f11170Z + ",currentSerial=" + this.f11168X + ",isNeedRefresh=" + m9583b);
        if (m9583b) {
            PreferencesManager.m9595a(this.mContext).m9587a("need_refresh", false);
            m7544i();
            request(10011, false);
            LoadDialog.m4684a(this.mContext, getString(R.string.caricon_loading));
        } else {
            m7552e();
            m7548g();
            this.f11178aG.postDelayed(new RunnableC2205m(this), 5000L);
        }
        if (C2744aa.m5166c()) {
            this.f11169Y.m7943b();
        }
        this.f11178aG.postDelayed(this.f11189aR, 500L);
        if (C2778n.m4917a(this.mContext) && C2778n.m4895e(this.mContext)) {
            request(2200);
        } else {
            PreferencesManager.m9595a(this.mContext).m9590a("shopStatistics", 0);
            this.mContext.sendBroadcast(new Intent("notifyShopStatisticsChanged"));
        }
        if (this.searchInputCars != null && !TextUtils.isEmpty(this.searchInputCars.getText().toString())) {
            m7557c(this.searchInputCars.getText().toString());
        }
        MessageDialog messageDialog = this.f11203ao;
        if (messageDialog == null || !messageDialog.isShowing()) {
            SelectMessageDialog selectMessageDialog = this.f11185aN;
            if (selectMessageDialog == null || !selectMessageDialog.m4605c()) {
                NLog.m9456a("yhx", "onStartLogic.isProgressDialogShowing=" + ApkUpgradeAndDownloadLogic.m5636a(this.mContext).m5637a() + "isInstall=" + ApkUpgradeAndDownloadLogic.m5636a(this.mContext).f15258b);
                if (ApkUpgradeAndDownloadLogic.m5636a(this.mContext).m5637a() || MainActivity.m7907a() || ApkUpgradeAndDownloadLogic.m5636a(this.mContext).f15258b) {
                    return;
                }
                ApkUpgradeUtils m5111a = ApkUpgradeUtils.m5111a(this.mContext);
                boolean m9583b2 = PreferencesManager.m9595a(m5111a.f15717b).m9583b("has_new_apk_version", false);
                NLog.m9456a("yhx", "checkRemindUpdateApk enter.isHasNewVersion=".concat(String.valueOf(m9583b2)));
                if (C2778n.m4917a(m5111a.f15717b) && m9583b2) {
                    m5111a.m5108a(false);
                }
                ApkUpgradeUtils.m5111a(this.mContext).f15718c = this.f11187aP;
            }
        }
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.mContext.unregisterReceiver(this.f11186aO);
    }

    /* renamed from: d */
    private void m7556d() {
        setLeftImage(this.mContext.getResources().getDrawable(R.drawable.select_btn_menu));
        this.f11191ab = (RadioButton) getActivity().findViewById(R.id.btn_all);
        this.f11194ae = (RadioButton) getActivity().findViewById(R.id.btn_america);
        this.f11193ad = (RadioButton) getActivity().findViewById(R.id.btn_europe);
        this.f11192ac = (RadioButton) getActivity().findViewById(R.id.btn_asia);
        this.f11195af = (RadioButton) getActivity().findViewById(R.id.btn_reset);
        this.f11196ag = (RadioButton) getActivity().findViewById(R.id.btn_heavyduty);
        this.f11197ah = (RadioButton) getActivity().findViewById(R.id.btn_History);
        this.f11198ai = (RadioButton) getActivity().findViewById(R.id.btn_favorites);
        this.f11199aj = (RadioButton) getActivity().findViewById(R.id.btn_china);
        this.textVinScan.setOnClickListener(this);
        this.f11191ab.setOnFocusChangeListener(this);
        this.f11194ae.setOnFocusChangeListener(this);
        this.f11193ad.setOnFocusChangeListener(this);
        this.f11192ac.setOnFocusChangeListener(this);
        this.f11195af.setOnFocusChangeListener(this);
        this.f11196ag.setOnFocusChangeListener(this);
        this.f11197ah.setOnFocusChangeListener(this);
        this.f11198ai.setOnFocusChangeListener(this);
        this.f11199aj.setOnFocusChangeListener(this);
        this.f11191ab.setOnClickListener(this);
        this.f11194ae.setOnClickListener(this);
        this.f11193ad.setOnClickListener(this);
        this.f11192ac.setOnClickListener(this);
        this.f11195af.setOnClickListener(this);
        this.f11196ag.setOnClickListener(this);
        this.f11197ah.setOnClickListener(this);
        this.f11198ai.setOnClickListener(this);
        this.f11199aj.setOnClickListener(this);
        this.tv_title.setVisibility(8);
        this.radioGroup_head.setVisibility(0);
        if (this.f11201am) {
            this.textVinScan.setVisibility(0);
        } else {
            this.textVinScan.setVisibility(8);
        }
        this.radioGroup_head.setOnCheckedChangeListener(this);
        LayoutInflater layoutInflater = getActivity().getLayoutInflater();
        this.f11226n = new ArrayList<>();
        this.f11154J = layoutInflater.inflate(R.layout.item_grid_diagnose_viewpage, (ViewGroup) null);
        this.f11153I = layoutInflater.inflate(R.layout.item_grid_diagnose_viewpage, (ViewGroup) null);
        this.f11152H = layoutInflater.inflate(R.layout.item_grid_diagnose_viewpage, (ViewGroup) null);
        this.f11151G = layoutInflater.inflate(R.layout.item_grid_diagnose_viewpage, (ViewGroup) null);
        this.f11155K = layoutInflater.inflate(R.layout.item_grid_diagnose_viewpage, (ViewGroup) null);
        this.f11156L = layoutInflater.inflate(R.layout.item_grid_diagnose_viewpage, (ViewGroup) null);
        this.f11157M = layoutInflater.inflate(R.layout.item_grid_diagnose_viewpage, (ViewGroup) null);
        this.f11158N = layoutInflater.inflate(R.layout.item_grid_diagnose_viewpage, (ViewGroup) null);
        this.f11159O = layoutInflater.inflate(R.layout.item_grid_diagnose_viewpage, (ViewGroup) null);
        if (this.f11179aH) {
            this.f11212ax = (DragGridView) this.f11154J.findViewById(R.id.gridview);
            this.f11212ax.setAdapter((ListAdapter) new CarIconAdapter(this.mContext, this));
            this.f11212ax.setAddDestination(this.radioGroup_head);
            this.f11214az = (DragGridView) this.f11151G.findViewById(R.id.gridview);
            this.f11214az.setAdapter((ListAdapter) new CarIconAdapter(this.mContext, this));
            this.f11214az.setAddDestination(this.radioGroup_head);
            this.f11172aA = (DragGridView) this.f11152H.findViewById(R.id.gridview);
            this.f11172aA.setAdapter((ListAdapter) new CarIconAdapter(this.mContext, this));
            this.f11172aA.setAddDestination(this.radioGroup_head);
            this.f11173aB = (DragGridView) this.f11153I.findViewById(R.id.gridview);
            this.f11173aB.setAdapter((ListAdapter) new CarIconAdapter(this.mContext, this));
            this.f11173aB.setAddDestination(this.radioGroup_head);
            this.f11174aC = (DragGridView) this.f11159O.findViewById(R.id.gridview);
            this.f11174aC.setAdapter((ListAdapter) new CarIconAdapter(this.mContext, this));
            this.f11174aC.setAddDestination(this.radioGroup_head);
            this.f11213ay = (DragGridView) this.f11158N.findViewById(R.id.gridview);
            this.f11213ay.setAdapter((ListAdapter) new CarIconAdapter(this.mContext, this));
            this.f11213ay.setDeleteDestination(this.radioGroup_head);
        }
        this.f11225m = new ViewPagerAdapter(this.f11226n);
        this.f11224l.setAdapter(this.f11225m);
        this.f11224l.setOnPageChangeListener(this);
        this.f11235w = new CarIconAdapter(this.mContext, this);
        this.f11150F = (GridView) this.f11159O;
        this.f11150F.setAdapter((ListAdapter) this.f11235w);
        this.f11150F.setOnItemClickListener(this);
        this.f11150F.setOnItemLongClickListener(this);
        this.f11234v = new CarIconAdapter(this.mContext, this);
        this.f11149E = (GridView) this.f11158N;
        this.f11149E.setAdapter((ListAdapter) this.f11234v);
        this.f11149E.setOnItemClickListener(this);
        this.f11149E.setOnItemLongClickListener(this);
        this.f11233u = new CarIconAdapter(this.mContext, this);
        this.f11148D = (GridView) this.f11157M;
        this.f11148D.setAdapter((ListAdapter) this.f11233u);
        this.f11148D.setOnItemClickListener(this);
        this.f11148D.setOnItemLongClickListener(this);
        this.f11231s = new CarIconAdapter(this.mContext, this);
        this.f11146B = (GridView) this.f11155K;
        this.f11146B.setAdapter((ListAdapter) this.f11231s);
        this.f11146B.setOnItemClickListener(this);
        this.f11146B.setOnItemLongClickListener(this);
        this.f11232t = new CarIconAdapter(this.mContext, this);
        this.f11147C = (GridView) this.f11156L;
        this.f11147C.setAdapter((ListAdapter) this.f11232t);
        this.f11147C.setOnItemClickListener(this);
        this.f11147C.setOnItemLongClickListener(this);
        this.f11228p = new CarIconAdapter(this.mContext, this);
        this.f11237y = (GridView) this.f11153I;
        this.f11237y.setAdapter((ListAdapter) this.f11228p);
        this.f11237y.setOnItemClickListener(this);
        this.f11237y.setOnItemLongClickListener(this);
        this.f11229q = new CarIconAdapter(this.mContext, this);
        this.f11238z = (GridView) this.f11152H;
        this.f11238z.setAdapter((ListAdapter) this.f11229q);
        this.f11238z.setOnItemClickListener(this);
        this.f11238z.setOnItemLongClickListener(this);
        this.f11230r = new CarIconAdapter(this.mContext, this);
        this.f11145A = (GridView) this.f11151G;
        this.f11145A.setAdapter((ListAdapter) this.f11230r);
        this.f11145A.setOnItemClickListener(this);
        this.f11145A.setOnItemLongClickListener(this);
        this.f11227o = new CarIconAdapter(this.mContext, this);
        this.f11236x = (GridView) this.f11154J;
        this.f11236x.setAdapter((ListAdapter) this.f11227o);
        this.f11236x.setOnItemClickListener(this);
        this.f11236x.setOnItemLongClickListener(this);
        if (PreferencesManager.m9595a(this.mContext).m9583b("need_refresh", true)) {
            PreferencesManager.m9595a(this.mContext).m9587a("need_refresh", false);
            request(10011, false);
            LoadDialog.m4684a(this.mContext, getString(R.string.caricon_loading));
            m7544i();
        } else {
            m7552e();
            m7548g();
            m7546h();
        }
        this.searchInputCars.setVisibility(0);
        if (C2744aa.m5148g()) {
            this.searchInputCars.setVisibility(8);
        }
        this.f11182aK = new C2207o(this);
        this.searchInputCars.addTextChangedListener(this.f11182aK);
        this.searchInputCars.setOnFocusChangeListener(new View$OnFocusChangeListenerC2208p(this));
    }

    /* renamed from: a */
    private void m7568a(String str) {
        BaseDialog baseDialog = this.f11200ak;
        if (baseDialog == null || !baseDialog.isShowing()) {
            this.f11200ak = new DialogC2210r(this, this.mContext);
            this.f11200ak.setTitle(R.string.remind_update_title);
            this.f11200ak.m4715c(str);
            this.f11200ak.m4719a(R.string.remind_update_button_later, true, null);
            this.f11200ak.m4717b(R.string.remind_update_button_now, true, null);
            this.f11200ak.setOnCancelListener(new DialogInterface$OnCancelListenerC2211s(this));
            this.f11200ak.show();
        }
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public Object doInBackground(int i) throws C1425f {
        UpgradeAction upgradeAction = new UpgradeAction(this.mContext);
        switch (i) {
            case 2101:
                return upgradeAction.m5282a(this.f11190aa, this.f11204ap, this.f11205aq);
            case 2102:
                return upgradeAction.m5281a(this.f11206ar, this.f11190aa, this.f11204ap, this.f11205aq);
            case 2105:
                return upgradeAction.m5283a(Integer.valueOf(Integer.parseInt(this.f11205aq)), "Universal Tool", "DiagBaseService_App", this.f11190aa);
            case 2106:
                return upgradeAction.m5282a(this.f11170Z, this.f11204ap, this.f11205aq);
            case 2107:
                return upgradeAction.m5281a(this.f11206ar, this.f11170Z, this.f11204ap, this.f11205aq);
            case 2108:
                return upgradeAction.m5283a(Integer.valueOf(Integer.parseInt(this.f11205aq)), "Universal Tool", "DiagBaseService_App", this.f11170Z);
            case 2200:
                return new SellerAction(this.mContext).m7810a();
            case 10010:
                try {
                    m7552e();
                    return Boolean.TRUE;
                } catch (Exception e) {
                    e.printStackTrace();
                    return Boolean.FALSE;
                }
            case 10011:
                try {
                    CarIconUtils carIconUtils = new CarIconUtils(this.mContext);
                    if (carIconUtils.m4978a()) {
                        carIconUtils.m4967b();
                    }
                    this.f11190aa = PreferencesManager.m9595a(this.mContext).m9591a("carSerialNo");
                    this.f11170Z = PreferencesManager.m9595a(this.mContext).m9591a("heavydutySerialNo");
                    this.f11181aJ = PreferencesManager.m9595a(this.mContext).m9591a("carAndHeavydutySerialNo");
                    String str = f11144b;
                    NLog.m9456a(str, "carSerialNo=" + this.f11190aa + ",heavydutySerialNo=" + this.f11170Z + ",carAndHeavySerialNo=" + this.f11181aJ);
                    this.f11171a = PreferencesManager.m9595a(this.mContext).m9583b("is_select_heavyduty_area", false);
                    StringBuilder sb = new StringBuilder("CarIconFragment.mReceiver heavydutySerialNo = ");
                    sb.append(this.f11170Z);
                    NLog.m9456a("wzx", sb.toString());
                    if (this.f11171a) {
                        PreferencesManager.m9595a(this.mContext).m9588a("serialNo", this.f11170Z);
                    }
                    carIconUtils.m4972a(this.f11190aa, this.f11170Z);
                    this.f11160P = carIconUtils.m4965b(this.f11190aa);
                    this.f11161Q = carIconUtils.m4957c(CarIconUtils.f15862b, this.f11190aa);
                    this.f11162R = carIconUtils.m4957c(CarIconUtils.f15864d, this.f11190aa);
                    this.f11163S = carIconUtils.m4957c(CarIconUtils.f15865e, this.f11190aa);
                    this.f11165U = carIconUtils.m4957c(CarIconUtils.f15868h, this.f11170Z);
                    this.f11167W = carIconUtils.m4957c(CarIconUtils.f15863c, this.f11190aa);
                    if (C2744aa.m5154e(this.mContext)) {
                        this.f11164T = carIconUtils.m4957c(CarIconUtils.f15866f, this.f11190aa);
                    }
                    return Boolean.TRUE;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return Boolean.FALSE;
                }
            default:
                return super.doInBackground(i);
        }
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public void onSuccess(int i, Object obj) {
        LatestPublicSoftsResponse latestPublicSoftsResponse;
        List<X431PadDtoSoft> x431PadSoftList;
        LatestDiagSoftsResponse latestDiagSoftsResponse;
        List<X431PadDtoSoft> x431PadSoftList2;
        PublicSoftLatestVersionResult publicSoftLatestVersionResult;
        PublicSoftLatestVersionDetail publicSoftLatestVersionDetail;
        LatestPublicSoftsResponse latestPublicSoftsResponse2;
        List<X431PadDtoSoft> x431PadSoftList3;
        LatestDiagSoftsResponse latestDiagSoftsResponse2;
        List<X431PadDtoSoft> x431PadSoftList4;
        PublicSoftLatestVersionResult publicSoftLatestVersionResult2;
        PublicSoftLatestVersionDetail publicSoftLatestVersionDetail2;
        int i2 = 0;
        switch (i) {
            case 2101:
                this.f11207as = new ArrayList();
                if (obj != null && (latestPublicSoftsResponse = (LatestPublicSoftsResponse) obj) != null && isSuccess(latestPublicSoftsResponse.getCode()) && (x431PadSoftList = latestPublicSoftsResponse.getX431PadSoftList()) != null) {
                    for (X431PadDtoSoft x431PadDtoSoft : x431PadSoftList) {
                        if (C2787z.m4820a(x431PadDtoSoft.getVersionNo(), C2778n.m4910a(x431PadDtoSoft.getSoftPackageID(), this.f11190aa, this.mContext))) {
                            x431PadDtoSoft.setChecked(true);
                        } else {
                            x431PadDtoSoft.setChecked(false);
                        }
                        if (!this.f11207as.contains(x431PadDtoSoft)) {
                            this.f11207as.add(x431PadDtoSoft);
                        }
                    }
                }
                request(2105);
                return;
            case 2102:
                if (obj != null && (latestDiagSoftsResponse = (LatestDiagSoftsResponse) obj) != null && isSuccess(latestDiagSoftsResponse.getCode()) && (x431PadSoftList2 = latestDiagSoftsResponse.getX431PadSoftList()) != null) {
                    for (X431PadDtoSoft x431PadDtoSoft2 : C2778n.m4906a(x431PadSoftList2, this.mContext)) {
                        if (C2787z.m4820a(x431PadDtoSoft2.getVersionNo(), C2778n.m4909a(x431PadDtoSoft2.getSoftPackageID(), x431PadDtoSoft2.getLanId(), this.mContext, this.f11190aa))) {
                            x431PadDtoSoft2.setChecked(true);
                        } else {
                            x431PadDtoSoft2.setChecked(false);
                        }
                        if (!this.f11207as.contains(x431PadDtoSoft2)) {
                            this.f11207as.add(x431PadDtoSoft2);
                        }
                    }
                }
                this.f11207as = C2778n.m4907a(this.f11207as);
                String m9591a = PreferencesManager.m9595a(this.mContext).m9591a("upgrade_center_version");
                for (X431PadDtoSoft x431PadDtoSoft3 : this.f11207as) {
                    if (x431PadDtoSoft3.isChecked() && !x431PadDtoSoft3.getMaxOldVersion().isEmpty() && (!m9591a.equalsIgnoreCase("V2.0") || !x431PadDtoSoft3.getMaxOldVersion().isEmpty())) {
                        i2++;
                    }
                }
                PreferencesManager.m9595a(this.mContext).m9590a("unupdateSoftwareNum", i2);
                if (i2 == 0 && PreferencesManager.m9595a(this.mContext).m9586b("update_time") == 0) {
                    PreferencesManager.m9595a(this.mContext).m9589a("update_time", System.currentTimeMillis());
                }
                if (!TextUtils.isEmpty(this.f11170Z) && !C2744aa.m5161c(this.f11170Z, this.mContext)) {
                    request(2106);
                    return;
                }
                PreferencesManager.m9595a(this.mContext).m9587a("isRequestUpdateDataOK", true);
                this.mContext.sendBroadcast(new Intent("unupgradeSoftNumChanged"));
                return;
            case 2105:
                if (obj != null && (publicSoftLatestVersionResult = (PublicSoftLatestVersionResult) obj) != null && isSuccess(publicSoftLatestVersionResult.getCode()) && (publicSoftLatestVersionDetail = publicSoftLatestVersionResult.getPublicSoftLatestVersionDetail()) != null) {
                    X431PadDtoSoft x431PadDtoSoft4 = new X431PadDtoSoft();
                    StringBuilder sb = new StringBuilder();
                    sb.append(publicSoftLatestVersionDetail.getPubVersionDetailId());
                    x431PadDtoSoft4.setVersionDetailId(sb.toString());
                    x431PadDtoSoft4.setSoftName(publicSoftLatestVersionDetail.getSoftName());
                    x431PadDtoSoft4.setSoftPackageID(publicSoftLatestVersionDetail.getSoftPackageID());
                    x431PadDtoSoft4.setVersionNo("V" + publicSoftLatestVersionDetail.getVersionNo());
                    x431PadDtoSoft4.setLanId(publicSoftLatestVersionDetail.getLanId());
                    x431PadDtoSoft4.setType(1);
                    if (C2787z.m4820a(x431PadDtoSoft4.getVersionNo(), C2778n.m4910a(x431PadDtoSoft4.getSoftPackageID(), this.f11190aa, this.mContext))) {
                        x431PadDtoSoft4.setChecked(true);
                    } else {
                        x431PadDtoSoft4.setChecked(false);
                    }
                    this.f11207as.add(x431PadDtoSoft4);
                }
                request(2102);
                return;
            case 2106:
                this.f11207as = new ArrayList();
                if (obj != null && (latestPublicSoftsResponse2 = (LatestPublicSoftsResponse) obj) != null && isSuccess(latestPublicSoftsResponse2.getCode()) && (x431PadSoftList3 = latestPublicSoftsResponse2.getX431PadSoftList()) != null) {
                    for (X431PadDtoSoft x431PadDtoSoft5 : x431PadSoftList3) {
                        if (C2787z.m4820a(x431PadDtoSoft5.getVersionNo(), C2778n.m4910a(x431PadDtoSoft5.getSoftPackageID(), this.f11170Z, this.mContext))) {
                            x431PadDtoSoft5.setChecked(true);
                        } else {
                            x431PadDtoSoft5.setChecked(false);
                        }
                        if (!this.f11207as.contains(x431PadDtoSoft5)) {
                            this.f11207as.add(x431PadDtoSoft5);
                        }
                    }
                }
                request(2108);
                return;
            case 2107:
                if (obj != null && (latestDiagSoftsResponse2 = (LatestDiagSoftsResponse) obj) != null && isSuccess(latestDiagSoftsResponse2.getCode()) && (x431PadSoftList4 = latestDiagSoftsResponse2.getX431PadSoftList()) != null) {
                    for (X431PadDtoSoft x431PadDtoSoft6 : x431PadSoftList4) {
                        if (C2787z.m4820a(x431PadDtoSoft6.getVersionNo(), C2778n.m4909a(x431PadDtoSoft6.getSoftPackageID(), x431PadDtoSoft6.getLanId(), this.mContext, this.f11170Z))) {
                            x431PadDtoSoft6.setChecked(true);
                        } else {
                            x431PadDtoSoft6.setChecked(false);
                        }
                        if (!this.f11207as.contains(x431PadDtoSoft6)) {
                            this.f11207as.add(x431PadDtoSoft6);
                        }
                    }
                }
                C2778n.m4907a(this.f11207as);
                String m9591a2 = PreferencesManager.m9595a(this.mContext).m9591a("upgrade_center_version");
                int i3 = 0;
                for (X431PadDtoSoft x431PadDtoSoft7 : this.f11207as) {
                    if (x431PadDtoSoft7.isChecked() && !x431PadDtoSoft7.getMaxOldVersion().isEmpty() && (!m9591a2.equalsIgnoreCase("V2.0") || !x431PadDtoSoft7.getMaxOldVersion().isEmpty())) {
                        i3++;
                    }
                }
                PreferencesManager.m9595a(this.mContext).m9590a("unupdateSoftwareNumForHeavyduty", i3);
                this.mContext.sendBroadcast(new Intent("unupgradeSoftNumChanged"));
                if (i3 == 0 && PreferencesManager.m9595a(this.mContext).m9586b("update_time") == 0) {
                    PreferencesManager.m9595a(this.mContext).m9589a("update_time", System.currentTimeMillis());
                }
                PreferencesManager.m9595a(this.mContext).m9587a("isRequestUpdateDataOK", true);
                this.f11180aI = false;
                return;
            case 2108:
                if (obj != null && (publicSoftLatestVersionResult2 = (PublicSoftLatestVersionResult) obj) != null && isSuccess(publicSoftLatestVersionResult2.getCode()) && (publicSoftLatestVersionDetail2 = publicSoftLatestVersionResult2.getPublicSoftLatestVersionDetail()) != null) {
                    X431PadDtoSoft x431PadDtoSoft8 = new X431PadDtoSoft();
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(publicSoftLatestVersionDetail2.getPubVersionDetailId());
                    x431PadDtoSoft8.setVersionDetailId(sb2.toString());
                    x431PadDtoSoft8.setSoftName(publicSoftLatestVersionDetail2.getSoftName());
                    x431PadDtoSoft8.setSoftPackageID(publicSoftLatestVersionDetail2.getSoftPackageID());
                    x431PadDtoSoft8.setVersionNo("V" + publicSoftLatestVersionDetail2.getVersionNo());
                    x431PadDtoSoft8.setLanId(publicSoftLatestVersionDetail2.getLanId());
                    x431PadDtoSoft8.setType(1);
                    if (C2787z.m4820a(x431PadDtoSoft8.getVersionNo(), C2778n.m4910a(x431PadDtoSoft8.getSoftPackageID(), this.f11170Z, this.mContext))) {
                        x431PadDtoSoft8.setChecked(true);
                    } else {
                        x431PadDtoSoft8.setChecked(false);
                    }
                    this.f11207as.add(x431PadDtoSoft8);
                }
                request(2107);
                return;
            case 2200:
                if (obj != null) {
                    GetShopStatisticResponse getShopStatisticResponse = (GetShopStatisticResponse) obj;
                    if (getShopStatisticResponse != null && isSuccess(getShopStatisticResponse.getCode())) {
                        int data = getShopStatisticResponse.getData();
                        int m9585b = PreferencesManager.m9595a(this.mContext).m9585b("shopStatistics", 0);
                        if (data == 0 || data != m9585b) {
                            PreferencesManager.m9595a(this.mContext).m9590a("shopStatistics", data);
                            this.mContext.sendBroadcast(new Intent("notifyShopStatisticsChanged"));
                            return;
                        }
                        return;
                    }
                    PreferencesManager.m9595a(this.mContext).m9590a("shopStatistics", 0);
                    this.mContext.sendBroadcast(new Intent("notifyShopStatisticsChanged"));
                    return;
                }
                return;
            case 10010:
            case 10011:
                m7550f();
                m7548g();
                LoadDialog.m4681b(getActivity());
                this.f11178aG.postDelayed(new RunnableC2089c(this), 5000L);
                return;
            default:
                return;
        }
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public void onFailure(int i, int i2, Object obj) {
        this.f11180aI = false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int size;
        int size2;
        try {
            int currentItem = this.f11224l.getCurrentItem();
            if (C2744aa.m5148g()) {
                if (view.getId() == R.id.btn_all) {
                    PreferencesManager.m9595a(this.mContext).m9588a("serialNo", this.f11190aa);
                    PreferencesManager.m9595a(this.mContext).m9587a("is_select_heavyduty_area", false);
                    if (currentItem != 0) {
                        this.f11224l.setCurrentItem(0);
                        f11143al = 0;
                    }
                }
            } else {
                C2744aa.m5135m();
                if (C2744aa.m5166c() && !C2744aa.m5145h()) {
                    switch (view.getId()) {
                        case R.id.btn_all /* 2131296402 */:
                            PreferencesManager.m9595a(this.mContext).m9588a("serialNo", this.f11190aa);
                            PreferencesManager.m9595a(this.mContext).m9587a("is_select_heavyduty_area", false);
                            if (currentItem != 0) {
                                this.f11224l.setCurrentItem(0);
                                f11143al = 0;
                                break;
                            }
                            break;
                        case R.id.btn_america /* 2131296403 */:
                            PreferencesManager.m9595a(this.mContext).m9588a("serialNo", this.f11190aa);
                            PreferencesManager.m9595a(this.mContext).m9587a("is_select_heavyduty_area", false);
                            if (currentItem != 1) {
                                this.f11224l.setCurrentItem(1);
                                f11143al = 1;
                                break;
                            }
                            break;
                        case R.id.btn_asia /* 2131296405 */:
                            PreferencesManager.m9595a(this.mContext).m9588a("serialNo", this.f11190aa);
                            PreferencesManager.m9595a(this.mContext).m9587a("is_select_heavyduty_area", false);
                            if (currentItem != 3) {
                                this.f11224l.setCurrentItem(3);
                                f11143al = 3;
                                break;
                            }
                            break;
                        case R.id.btn_europe /* 2131296442 */:
                            PreferencesManager.m9595a(this.mContext).m9588a("serialNo", this.f11190aa);
                            PreferencesManager.m9595a(this.mContext).m9587a("is_select_heavyduty_area", false);
                            if (currentItem != 2) {
                                this.f11224l.setCurrentItem(2);
                                f11143al = 2;
                                break;
                            }
                            break;
                    }
                } else if (C2744aa.m5155e()) {
                    int id = view.getId();
                    if (id == R.id.btn_america) {
                        PreferencesManager.m9595a(this.mContext).m9588a("serialNo", this.f11190aa);
                        PreferencesManager.m9595a(this.mContext).m9587a("is_select_heavyduty_area", false);
                        if (currentItem != 0) {
                            this.f11224l.setCurrentItem(0);
                            f11143al = 0;
                        }
                    } else if (id == R.id.btn_asia) {
                        PreferencesManager.m9595a(this.mContext).m9588a("serialNo", this.f11190aa);
                        PreferencesManager.m9595a(this.mContext).m9587a("is_select_heavyduty_area", false);
                        if (currentItem != 2) {
                            this.f11224l.setCurrentItem(2);
                            f11143al = 2;
                        }
                    } else if (id == R.id.btn_europe) {
                        PreferencesManager.m9595a(this.mContext).m9588a("serialNo", this.f11190aa);
                        PreferencesManager.m9595a(this.mContext).m9587a("is_select_heavyduty_area", false);
                        if (currentItem != 1) {
                            this.f11224l.setCurrentItem(1);
                            f11143al = 1;
                        }
                    }
                } else {
                    int id2 = view.getId();
                    if (id2 == R.id.btn_america) {
                        PreferencesManager.m9595a(this.mContext).m9588a("serialNo", this.f11190aa);
                        PreferencesManager.m9595a(this.mContext).m9587a("is_select_heavyduty_area", false);
                        if (currentItem != 0) {
                            this.f11224l.setCurrentItem(0);
                            f11143al = 0;
                        }
                    } else if (id2 == R.id.btn_asia) {
                        PreferencesManager.m9595a(this.mContext).m9588a("serialNo", this.f11190aa);
                        PreferencesManager.m9595a(this.mContext).m9587a("is_select_heavyduty_area", false);
                        if (currentItem != 2) {
                            this.f11224l.setCurrentItem(2);
                            f11143al = 2;
                        }
                    } else if (id2 == R.id.btn_china) {
                        PreferencesManager.m9595a(this.mContext).m9588a("serialNo", this.f11190aa);
                        PreferencesManager.m9595a(this.mContext).m9587a("is_select_heavyduty_area", false);
                        if (currentItem != 3) {
                            this.f11224l.setCurrentItem(3);
                            f11143al = 3;
                        }
                    } else if (id2 == R.id.btn_europe) {
                        PreferencesManager.m9595a(this.mContext).m9588a("serialNo", this.f11190aa);
                        PreferencesManager.m9595a(this.mContext).m9587a("is_select_heavyduty_area", false);
                        if (currentItem != 1) {
                            this.f11224l.setCurrentItem(1);
                            f11143al = 1;
                        }
                    }
                }
            }
            switch (view.getId()) {
                case R.id.btn_History /* 2131296396 */:
                    this.textVinScan.setVisibility(8);
                    replaceFragment(HistoryFragment.class.getName(), 0, false);
                    return;
                case R.id.btn_favorites /* 2131296448 */:
                    PreferencesManager.m9595a(this.mContext).m9588a("serialNo", this.f11190aa);
                    PreferencesManager.m9595a(this.mContext).m9587a("is_select_heavyduty_area", false);
                    this.f11226n.size();
                    if (this.f11202an) {
                        size = this.f11226n.size() - 2;
                    } else {
                        size = this.f11226n.size() - 1;
                    }
                    if (currentItem != size) {
                        this.f11224l.setCurrentItem(size);
                        f11143al = size;
                    }
                    this.f11175aD = 0;
                    if (this.f11176aE == null || !this.f11176aE.isShowing()) {
                        return;
                    }
                    this.f11176aE.dismiss();
                    return;
                case R.id.btn_heavyduty /* 2131296472 */:
                    PreferencesManager.m9595a(this.mContext).m9588a("serialNo", this.f11170Z);
                    PreferencesManager.m9595a(this.mContext).m9587a("is_select_heavyduty_area", true);
                    this.f11226n.size();
                    if (this.f11179aH && this.f11202an) {
                        size2 = this.f11226n.size() - 3;
                    } else if ((this.f11179aH && !this.f11202an) || (!this.f11179aH && this.f11202an)) {
                        size2 = this.f11226n.size() - 2;
                    } else {
                        size2 = this.f11226n.size() - 1;
                    }
                    if (currentItem != size2) {
                        this.f11224l.setCurrentItem(size2);
                        f11143al = size2;
                        return;
                    }
                    return;
                case R.id.btn_reset /* 2131296538 */:
                    PreferencesManager.m9595a(this.mContext).m9588a("serialNo", this.f11190aa);
                    PreferencesManager.m9595a(this.mContext).m9587a("is_select_heavyduty_area", false);
                    C2744aa.m5135m();
                    if (currentItem != 4) {
                        this.f11224l.setCurrentItem(4);
                        f11143al = 4;
                        return;
                    }
                    return;
                case R.id.vinscan_list /* 2131298440 */:
                    if (MainActivity.m7907a()) {
                        return;
                    }
                    Intent intent = new Intent(this.mContext, VINSelectDialogActivity.class);
                    intent.setFlags(67108864);
                    startActivity(intent);
                    return;
                default:
                    return;
            }
        } catch (Exception e) {
            NLog.m9451c("Sanda", "Fragment Error:" + e.toString());
        }
    }

    @Override // android.support.p012v4.view.ViewPager.InterfaceC0176e
    /* renamed from: a */
    public final void mo1774a(int i) {
        if (((DiagnoseActivity) getActivity()) != null) {
            if (i == 0) {
                ((DiagnoseActivity) getActivity()).m7732g().setTouchModeAbove(1);
            } else {
                ((DiagnoseActivity) getActivity()).m7732g().setTouchModeAbove(2);
            }
        }
        m7560c(i);
    }

    /* renamed from: c */
    private void m7560c(int i) {
        if (C2744aa.m5150f(this.mContext) && C2744aa.m5164c(this.mContext)) {
            C2744aa.m5135m();
            if (C2744aa.m5166c() && !C2744aa.m5145h()) {
                switch (i) {
                    case 0:
                        this.radioGroup_head.check(R.id.btn_all);
                        this.f11191ab.requestFocus();
                        this.f11191ab.requestFocusFromTouch();
                        PreferencesManager.m9595a(this.mContext).m9588a("serialNo", this.f11190aa);
                        PreferencesManager.m9595a(this.mContext).m9587a("is_select_heavyduty_area", false);
                        f11143al = 0;
                        break;
                    case 1:
                        this.radioGroup_head.check(R.id.btn_america);
                        this.f11194ae.requestFocus();
                        this.f11194ae.requestFocusFromTouch();
                        PreferencesManager.m9595a(this.mContext).m9588a("serialNo", this.f11190aa);
                        PreferencesManager.m9595a(this.mContext).m9587a("is_select_heavyduty_area", false);
                        f11143al = 1;
                        break;
                    case 2:
                        this.radioGroup_head.check(R.id.btn_europe);
                        this.f11193ad.requestFocus();
                        this.f11193ad.requestFocusFromTouch();
                        PreferencesManager.m9595a(this.mContext).m9588a("serialNo", this.f11190aa);
                        PreferencesManager.m9595a(this.mContext).m9587a("is_select_heavyduty_area", false);
                        f11143al = 2;
                        break;
                    case 3:
                        this.radioGroup_head.check(R.id.btn_asia);
                        this.f11192ac.requestFocus();
                        this.f11192ac.requestFocusFromTouch();
                        PreferencesManager.m9595a(this.mContext).m9588a("serialNo", this.f11190aa);
                        PreferencesManager.m9595a(this.mContext).m9587a("is_select_heavyduty_area", false);
                        f11143al = 3;
                        break;
                    case 4:
                        if (C2744aa.m5154e(this.mContext)) {
                            this.radioGroup_head.check(R.id.btn_reset);
                            this.f11195af.requestFocus();
                            this.f11195af.requestFocusFromTouch();
                            PreferencesManager.m9595a(this.mContext).m9588a("serialNo", this.f11190aa);
                            PreferencesManager.m9595a(this.mContext).m9587a("is_select_heavyduty_area", false);
                        } else {
                            this.radioGroup_head.check(R.id.btn_heavyduty);
                            this.f11196ag.requestFocus();
                            this.f11196ag.requestFocusFromTouch();
                            PreferencesManager.m9595a(this.mContext).m9588a("serialNo", this.f11170Z);
                            PreferencesManager.m9595a(this.mContext).m9587a("is_select_heavyduty_area", true);
                        }
                        f11143al = 4;
                        break;
                }
            } else if (C2744aa.m5155e()) {
                switch (i) {
                    case 0:
                        this.radioGroup_head.check(R.id.btn_america);
                        this.f11194ae.requestFocus();
                        this.f11194ae.requestFocusFromTouch();
                        PreferencesManager.m9595a(this.mContext).m9588a("serialNo", this.f11190aa);
                        PreferencesManager.m9595a(this.mContext).m9587a("is_select_heavyduty_area", false);
                        f11143al = 0;
                        break;
                    case 1:
                        this.radioGroup_head.check(R.id.btn_europe);
                        this.f11193ad.requestFocus();
                        this.f11193ad.requestFocusFromTouch();
                        PreferencesManager.m9595a(this.mContext).m9588a("serialNo", this.f11190aa);
                        PreferencesManager.m9595a(this.mContext).m9587a("is_select_heavyduty_area", false);
                        f11143al = 1;
                        break;
                    case 2:
                        this.radioGroup_head.check(R.id.btn_asia);
                        this.f11192ac.requestFocus();
                        this.f11192ac.requestFocusFromTouch();
                        PreferencesManager.m9595a(this.mContext).m9588a("serialNo", this.f11190aa);
                        PreferencesManager.m9595a(this.mContext).m9587a("is_select_heavyduty_area", false);
                        f11143al = 2;
                        break;
                    case 3:
                        if (C2744aa.m5154e(this.mContext)) {
                            this.radioGroup_head.check(R.id.btn_reset);
                            this.f11195af.requestFocus();
                            this.f11195af.requestFocusFromTouch();
                            PreferencesManager.m9595a(this.mContext).m9588a("serialNo", this.f11190aa);
                            PreferencesManager.m9595a(this.mContext).m9587a("is_select_heavyduty_area", false);
                        } else {
                            this.radioGroup_head.check(R.id.btn_heavyduty);
                            this.f11196ag.requestFocus();
                            this.f11196ag.requestFocusFromTouch();
                            PreferencesManager.m9595a(this.mContext).m9588a("serialNo", this.f11170Z);
                            PreferencesManager.m9595a(this.mContext).m9587a("is_select_heavyduty_area", true);
                        }
                        f11143al = 3;
                        break;
                }
            } else {
                switch (i) {
                    case 0:
                        this.radioGroup_head.check(R.id.btn_america);
                        this.f11194ae.requestFocus();
                        this.f11194ae.requestFocusFromTouch();
                        PreferencesManager.m9595a(this.mContext).m9588a("serialNo", this.f11190aa);
                        PreferencesManager.m9595a(this.mContext).m9587a("is_select_heavyduty_area", false);
                        f11143al = 0;
                        break;
                    case 1:
                        this.radioGroup_head.check(R.id.btn_europe);
                        this.f11193ad.requestFocus();
                        this.f11193ad.requestFocusFromTouch();
                        PreferencesManager.m9595a(this.mContext).m9588a("serialNo", this.f11190aa);
                        PreferencesManager.m9595a(this.mContext).m9587a("is_select_heavyduty_area", false);
                        f11143al = 1;
                        break;
                    case 2:
                        this.radioGroup_head.check(R.id.btn_asia);
                        this.f11192ac.requestFocus();
                        this.f11192ac.requestFocusFromTouch();
                        PreferencesManager.m9595a(this.mContext).m9588a("serialNo", this.f11190aa);
                        PreferencesManager.m9595a(this.mContext).m9587a("is_select_heavyduty_area", false);
                        f11143al = 2;
                        break;
                    case 3:
                        this.radioGroup_head.check(R.id.btn_china);
                        this.f11199aj.requestFocus();
                        this.f11199aj.requestFocusFromTouch();
                        PreferencesManager.m9595a(this.mContext).m9588a("serialNo", this.f11190aa);
                        PreferencesManager.m9595a(this.mContext).m9587a("is_select_heavyduty_area", false);
                        f11143al = 3;
                        break;
                    case 4:
                        if (C2744aa.m5154e(this.mContext)) {
                            this.radioGroup_head.check(R.id.btn_reset);
                            this.f11195af.requestFocus();
                            this.f11195af.requestFocusFromTouch();
                            PreferencesManager.m9595a(this.mContext).m9588a("serialNo", this.f11190aa);
                            PreferencesManager.m9595a(this.mContext).m9587a("is_select_heavyduty_area", false);
                        } else {
                            this.radioGroup_head.check(R.id.btn_heavyduty);
                            this.f11196ag.requestFocus();
                            this.f11196ag.requestFocusFromTouch();
                            PreferencesManager.m9595a(this.mContext).m9588a("serialNo", this.f11170Z);
                            PreferencesManager.m9595a(this.mContext).m9587a("is_select_heavyduty_area", true);
                        }
                        f11143al = 4;
                        break;
                }
            }
            if (i == this.f11226n.size() - 1) {
                if (this.f11202an) {
                    this.radioGroup_head.check(R.id.btn_History);
                    this.f11197ah.requestFocus();
                    this.f11197ah.requestFocusFromTouch();
                    this.textVinScan.setVisibility(8);
                    this.f11224l.setCurrentItem(i - 1);
                } else if (this.f11179aH) {
                    this.radioGroup_head.check(R.id.btn_favorites);
                    this.f11198ai.requestFocus();
                    this.f11198ai.requestFocusFromTouch();
                    PreferencesManager.m9595a(this.mContext).m9588a("serialNo", this.f11190aa);
                    PreferencesManager.m9595a(this.mContext).m9587a("is_select_heavyduty_area", false);
                    f11143al = i;
                    this.f11175aD = 0;
                    PopupWindow popupWindow = this.f11176aE;
                    if (popupWindow == null || !popupWindow.isShowing()) {
                        return;
                    }
                    this.f11176aE.dismiss();
                } else {
                    this.radioGroup_head.check(R.id.btn_heavyduty);
                    this.f11196ag.requestFocus();
                    this.f11196ag.requestFocusFromTouch();
                    PreferencesManager.m9595a(this.mContext).m9588a("serialNo", this.f11170Z);
                    PreferencesManager.m9595a(this.mContext).m9587a("is_select_heavyduty_area", true);
                    f11143al = i;
                }
            } else if (i == this.f11226n.size() - 2) {
                if (this.f11202an && this.f11179aH) {
                    this.radioGroup_head.check(R.id.btn_favorites);
                    this.f11198ai.requestFocus();
                    this.f11198ai.requestFocusFromTouch();
                    PreferencesManager.m9595a(this.mContext).m9588a("serialNo", this.f11190aa);
                    PreferencesManager.m9595a(this.mContext).m9587a("is_select_heavyduty_area", false);
                    f11143al = i;
                    this.f11175aD = 0;
                    PopupWindow popupWindow2 = this.f11176aE;
                    if (popupWindow2 == null || !popupWindow2.isShowing()) {
                        return;
                    }
                    this.f11176aE.dismiss();
                } else if ((!this.f11179aH || this.f11202an) && (this.f11179aH || !this.f11202an)) {
                } else {
                    this.radioGroup_head.check(R.id.btn_heavyduty);
                    this.f11196ag.requestFocus();
                    this.f11196ag.requestFocusFromTouch();
                    PreferencesManager.m9595a(this.mContext).m9588a("serialNo", this.f11170Z);
                    PreferencesManager.m9595a(this.mContext).m9587a("is_select_heavyduty_area", true);
                    f11143al = i;
                }
            } else if (i == this.f11226n.size() - 3 && this.f11202an && this.f11179aH) {
                this.radioGroup_head.check(R.id.btn_heavyduty);
                this.f11196ag.requestFocus();
                this.f11196ag.requestFocusFromTouch();
                PreferencesManager.m9595a(this.mContext).m9588a("serialNo", this.f11170Z);
                PreferencesManager.m9595a(this.mContext).m9587a("is_select_heavyduty_area", true);
                f11143al = i;
            }
        } else if (!C2744aa.m5150f(this.mContext) && C2744aa.m5164c(this.mContext)) {
            switch (i) {
                case 0:
                    this.radioGroup_head.check(R.id.btn_heavyduty);
                    this.f11196ag.requestFocus();
                    this.f11196ag.requestFocusFromTouch();
                    PreferencesManager.m9595a(this.mContext).m9588a("serialNo", this.f11170Z);
                    PreferencesManager.m9595a(this.mContext).m9587a("is_select_heavyduty_area", true);
                    f11143al = 0;
                    return;
                case 1:
                    this.radioGroup_head.check(R.id.btn_History);
                    this.f11197ah.requestFocus();
                    this.f11197ah.requestFocusFromTouch();
                    this.textVinScan.setVisibility(8);
                    this.f11224l.setCurrentItem(0);
                    return;
                default:
                    return;
            }
        } else if (!C2744aa.m5150f(this.mContext) || C2744aa.m5164c(this.mContext)) {
        } else {
            C2744aa.m5135m();
            if (C2744aa.m5166c() && !C2744aa.m5145h()) {
                switch (i) {
                    case 0:
                        this.radioGroup_head.check(R.id.btn_all);
                        this.f11191ab.requestFocus();
                        this.f11191ab.requestFocusFromTouch();
                        PreferencesManager.m9595a(this.mContext).m9588a("serialNo", this.f11190aa);
                        PreferencesManager.m9595a(this.mContext).m9587a("is_select_heavyduty_area", false);
                        f11143al = 0;
                        break;
                    case 1:
                        this.radioGroup_head.check(R.id.btn_america);
                        this.f11194ae.requestFocus();
                        this.f11194ae.requestFocusFromTouch();
                        PreferencesManager.m9595a(this.mContext).m9588a("serialNo", this.f11190aa);
                        PreferencesManager.m9595a(this.mContext).m9587a("is_select_heavyduty_area", false);
                        f11143al = 1;
                        break;
                    case 2:
                        this.radioGroup_head.check(R.id.btn_europe);
                        this.f11193ad.requestFocus();
                        this.f11193ad.requestFocusFromTouch();
                        PreferencesManager.m9595a(this.mContext).m9588a("serialNo", this.f11190aa);
                        PreferencesManager.m9595a(this.mContext).m9587a("is_select_heavyduty_area", false);
                        f11143al = 2;
                        break;
                    case 3:
                        this.radioGroup_head.check(R.id.btn_asia);
                        this.f11192ac.requestFocus();
                        this.f11192ac.requestFocusFromTouch();
                        PreferencesManager.m9595a(this.mContext).m9588a("serialNo", this.f11190aa);
                        PreferencesManager.m9595a(this.mContext).m9587a("is_select_heavyduty_area", false);
                        f11143al = 3;
                        break;
                }
            } else if (C2744aa.m5155e()) {
                switch (i) {
                    case 0:
                        this.radioGroup_head.check(R.id.btn_america);
                        this.f11194ae.requestFocus();
                        this.f11194ae.requestFocusFromTouch();
                        PreferencesManager.m9595a(this.mContext).m9588a("serialNo", this.f11190aa);
                        f11143al = 0;
                        break;
                    case 1:
                        this.radioGroup_head.check(R.id.btn_europe);
                        this.f11193ad.requestFocus();
                        this.f11193ad.requestFocusFromTouch();
                        PreferencesManager.m9595a(this.mContext).m9588a("serialNo", this.f11190aa);
                        f11143al = 1;
                        break;
                    case 2:
                        this.radioGroup_head.check(R.id.btn_asia);
                        this.f11192ac.requestFocus();
                        this.f11192ac.requestFocusFromTouch();
                        PreferencesManager.m9595a(this.mContext).m9588a("serialNo", this.f11190aa);
                        f11143al = 2;
                        break;
                }
            } else {
                switch (i) {
                    case 0:
                        this.radioGroup_head.check(R.id.btn_america);
                        this.f11194ae.requestFocus();
                        this.f11194ae.requestFocusFromTouch();
                        PreferencesManager.m9595a(this.mContext).m9588a("serialNo", this.f11190aa);
                        f11143al = 0;
                        break;
                    case 1:
                        this.radioGroup_head.check(R.id.btn_europe);
                        this.f11193ad.requestFocus();
                        this.f11193ad.requestFocusFromTouch();
                        PreferencesManager.m9595a(this.mContext).m9588a("serialNo", this.f11190aa);
                        f11143al = 1;
                        break;
                    case 2:
                        this.radioGroup_head.check(R.id.btn_asia);
                        this.f11192ac.requestFocus();
                        this.f11192ac.requestFocusFromTouch();
                        PreferencesManager.m9595a(this.mContext).m9588a("serialNo", this.f11190aa);
                        f11143al = 2;
                        break;
                    case 3:
                        this.radioGroup_head.check(R.id.btn_china);
                        this.f11199aj.requestFocus();
                        this.f11199aj.requestFocusFromTouch();
                        PreferencesManager.m9595a(this.mContext).m9588a("serialNo", this.f11190aa);
                        f11143al = 3;
                        break;
                }
            }
            if (i == this.f11226n.size() - 1) {
                if (this.f11202an) {
                    this.radioGroup_head.check(R.id.btn_History);
                    this.f11197ah.requestFocus();
                    this.f11197ah.requestFocusFromTouch();
                    this.textVinScan.setVisibility(8);
                    this.f11224l.setCurrentItem(i - 1);
                } else if (this.f11179aH) {
                    this.radioGroup_head.check(R.id.btn_favorites);
                    this.f11198ai.requestFocus();
                    this.f11198ai.requestFocusFromTouch();
                    PreferencesManager.m9595a(this.mContext).m9588a("serialNo", this.f11190aa);
                    PreferencesManager.m9595a(this.mContext).m9587a("is_select_heavyduty_area", false);
                    f11143al = i;
                    this.f11175aD = 0;
                    PopupWindow popupWindow3 = this.f11176aE;
                    if (popupWindow3 == null || !popupWindow3.isShowing()) {
                        return;
                    }
                    this.f11176aE.dismiss();
                } else if (C2744aa.m5154e(this.mContext)) {
                    this.radioGroup_head.check(R.id.btn_reset);
                    this.f11195af.requestFocus();
                    this.f11195af.requestFocusFromTouch();
                    PreferencesManager.m9595a(this.mContext).m9588a("serialNo", this.f11190aa);
                    PreferencesManager.m9595a(this.mContext).m9587a("is_select_heavyduty_area", false);
                    f11143al = i;
                }
            } else if (i == this.f11226n.size() - 2) {
                if (this.f11202an && this.f11179aH) {
                    this.radioGroup_head.check(R.id.btn_favorites);
                    this.f11198ai.requestFocus();
                    this.f11198ai.requestFocusFromTouch();
                    PreferencesManager.m9595a(this.mContext).m9588a("serialNo", this.f11190aa);
                    PreferencesManager.m9595a(this.mContext).m9587a("is_select_heavyduty_area", false);
                    f11143al = i;
                    this.f11175aD = 0;
                    PopupWindow popupWindow4 = this.f11176aE;
                    if (popupWindow4 == null || !popupWindow4.isShowing()) {
                        return;
                    }
                    this.f11176aE.dismiss();
                } else if (((!this.f11179aH || this.f11202an) && (this.f11179aH || !this.f11202an)) || !C2744aa.m5154e(this.mContext)) {
                } else {
                    this.radioGroup_head.check(R.id.btn_reset);
                    this.f11195af.requestFocus();
                    this.f11195af.requestFocusFromTouch();
                    PreferencesManager.m9595a(this.mContext).m9588a("serialNo", this.f11190aa);
                    PreferencesManager.m9595a(this.mContext).m9587a("is_select_heavyduty_area", false);
                    f11143al = i;
                }
            } else if (i == this.f11226n.size() - 3 && this.f11202an && this.f11179aH && C2744aa.m5154e(this.mContext)) {
                this.radioGroup_head.check(R.id.btn_reset);
                this.f11195af.requestFocus();
                this.f11195af.requestFocusFromTouch();
                PreferencesManager.m9595a(this.mContext).m9588a("serialNo", this.f11190aa);
                PreferencesManager.m9595a(this.mContext).m9587a("is_select_heavyduty_area", false);
                f11143al = i;
            }
        }
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (MainActivity.m7895b()) {
            NToast.m9447b(getActivity(), (int) R.string.remotediag_wait_for_other);
        } else if (FileUtils.m5027a() < 5) {
            NToast.m9447b(getActivity(), (int) R.string.txt_less_storage_space);
        } else {
            DiagnoseConstants.DIAG_INPUT_TYPE = "0";
            if (LangManager.m9466b().equalsIgnoreCase("CN")) {
                CarIconUtils carIconUtils = new CarIconUtils(this.mContext);
                String str = ((CarIcon) adapterView.getItemAtPosition(i)).f15778b;
                List<CarIcon> arrayList = new ArrayList<>();
                if (!TextUtils.isEmpty(str)) {
                    QueryBuilder<CarIcon> queryBuilder = carIconUtils.f15881t.queryBuilder();
                    queryBuilder.where(CarIconDao.Properties.SoftPackageId.m321eq(str), new WhereCondition[0]);
                    arrayList = queryBuilder.list();
                }
                if (arrayList != null && !arrayList.isEmpty()) {
                    for (CarIcon carIcon : arrayList) {
                        carIcon.f15784h = m7562b(carIcon.f15784h);
                        DBManager.m5036a(this.mContext).f15794a.f15799b.update(carIcon);
                    }
                }
            }
            if (!PreferencesManager.m9595a(this.mContext).m9583b("tryFlag", false) || C1947h.f10551c || PreferencesManager.m9595a(this.mContext).m9586b("tryFlagStartTime") == 0 || PreferencesManager.m9595a(this.mContext).m9586b("tryFlagStartTime") + 2419200000L >= System.currentTimeMillis()) {
                DiagnoseConstants.DIAGNOSE_CURRENT_PATH = "";
                if (!C1947h.f10551c) {
                    m7573a(adapterView, i);
                    return;
                }
                CarIcon carIcon2 = (CarIcon) adapterView.getItemAtPosition(i);
                if (carIcon2.f15787k.booleanValue()) {
                    if (carIcon2.f15778b.equalsIgnoreCase("demo") || carIcon2.f15778b.equalsIgnoreCase("eobd2")) {
                        Bundle bundle = new Bundle();
                        bundle.putString("versionlist", carIcon2.f15786j);
                        bundle.putString("carname", carIcon2.f15779c);
                        bundle.putString("carname_zh", carIcon2.m5038a(this.mContext));
                        bundle.putString("softpackageid", carIcon2.f15778b);
                        bundle.putString("areaId", carIcon2.f15782f);
                        SelectSoftVersionFragment selectSoftVersionFragment = new SelectSoftVersionFragment();
                        selectSoftVersionFragment.setArguments(bundle);
                        getFragmentManager().beginTransaction().replace(R.id.layout_fragment_contanier, selectSoftVersionFragment).commit();
                        this.tv_title.setVisibility(0);
                        this.radioGroup_head.setVisibility(8);
                        this.searchInputCars.setVisibility(8);
                        return;
                    }
                    NToast.m9446b(getActivity(), getResources().getString(R.string.factory_restrict));
                    return;
                }
                C2744aa.m5165c(getActivity(), carIcon2.f15779c);
            }
        }
    }

    /* renamed from: b */
    private static String m7562b(String str) {
        if (TextUtils.isEmpty(str)) {
            return "9999";
        }
        try {
            return String.valueOf(Integer.valueOf(str).intValue() - 1);
        } catch (NumberFormatException unused) {
            return "9999";
        }
    }

    /* renamed from: a */
    private void m7573a(AdapterView<?> adapterView, int i) {
        boolean z;
        DiagnoseUtils.m5086a().m5079c();
        CarIcon carIcon = (CarIcon) adapterView.getItemAtPosition(i);
        if (carIcon.f15787k.booleanValue()) {
            if (this.f11179aH && this.radioGroup_head.getCheckedRadioButtonId() == R.id.btn_favorites && !TextUtils.isEmpty(carIcon.f15789m)) {
                File file = new File(carIcon.f15789m);
                if (file.exists()) {
                    File[] listFiles = file.listFiles();
                    if (listFiles == null || listFiles.length == 0) {
                        z = false;
                    } else {
                        ArrayList arrayList = new ArrayList();
                        for (File file2 : listFiles) {
                            if (file2.isDirectory() && file2.getName().startsWith("V")) {
                                arrayList.add(file2);
                                File[] listFiles2 = file2.listFiles();
                                if (listFiles2 == null || listFiles2.length == 0) {
                                    z = false;
                                    break;
                                }
                            }
                        }
                        z = true;
                        if (arrayList.isEmpty()) {
                            z = false;
                        }
                    }
                } else {
                    z = false;
                }
                if (!z) {
                    NToast.m9450a(this.mContext, (int) R.string.no_this_carversion);
                    FavoritesCarIconDao favoritesCarIconDao = FavoritesDBManager.m5033a(this.mContext).f15810a.f15814a;
                    QueryBuilder<CarIcon> queryBuilder = favoritesCarIconDao.queryBuilder();
                    queryBuilder.where(FavoritesCarIconDao.Properties.SoftPackageId.m321eq(carIcon.f15778b), FavoritesCarIconDao.Properties.SerialNo.m321eq(carIcon.f15790n), FavoritesCarIconDao.Properties.IsDownload.m321eq(Boolean.TRUE));
                    favoritesCarIconDao.deleteInTx(queryBuilder.list());
                    this.f11166V = new CarIconUtils(this.mContext).m4958c(this.f11190aa);
                    CarIconAdapter carIconAdapter = this.f11234v;
                    carIconAdapter.f11256a = this.f11166V;
                    carIconAdapter.notifyDataSetChanged();
                    return;
                }
            }
            Bundle bundle = new Bundle();
            bundle.putString("versionlist", carIcon.f15786j);
            bundle.putString("carname", carIcon.f15779c);
            bundle.putString("carname_zh", carIcon.m5038a(this.mContext));
            bundle.putString("softpackageid", carIcon.f15778b);
            bundle.putString("areaId", carIcon.f15782f);
            SelectSoftVersionFragment selectSoftVersionFragment = new SelectSoftVersionFragment();
            selectSoftVersionFragment.setArguments(bundle);
            getFragmentManager().beginTransaction().replace(R.id.layout_fragment_contanier, selectSoftVersionFragment).commitAllowingStateLoss();
            this.tv_title.setVisibility(0);
            this.radioGroup_head.setVisibility(8);
            this.searchInputCars.setVisibility(8);
            return;
        }
        C2744aa.m5165c(getActivity(), carIcon.f15779c);
    }

    @Override // android.widget.AdapterView.OnItemLongClickListener
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        CarIcon carIcon = (CarIcon) adapterView.getItemAtPosition(i);
        if (this.f11179aH) {
            this.f11212ax.setViewPager(this.f11224l);
            this.f11214az.setViewPager(this.f11224l);
            this.f11172aA.setViewPager(this.f11224l);
            this.f11173aB.setViewPager(this.f11224l);
            this.f11174aC.setViewPager(this.f11224l);
            this.f11213ay.setViewPager(this.f11224l);
            if (this.radioGroup_head.getCheckedRadioButtonId() == R.id.btn_all) {
                this.f11212ax.setDragImage(0);
                this.f11224l.setScrollable(true);
                ((DiagnoseActivity) getActivity()).m7732g().setSlidingEnabled(false);
            } else if (this.radioGroup_head.getCheckedRadioButtonId() == R.id.btn_america) {
                this.f11214az.setDragImage(0);
                this.f11224l.setScrollable(true);
                ((DiagnoseActivity) getActivity()).m7732g().setSlidingEnabled(false);
            } else if (this.radioGroup_head.getCheckedRadioButtonId() == R.id.btn_europe) {
                this.f11172aA.setDragImage(0);
                this.f11224l.setScrollable(true);
                ((DiagnoseActivity) getActivity()).m7732g().setSlidingEnabled(false);
            } else if (this.radioGroup_head.getCheckedRadioButtonId() == R.id.btn_asia) {
                this.f11173aB.setDragImage(0);
                this.f11224l.setScrollable(true);
                ((DiagnoseActivity) getActivity()).m7732g().setSlidingEnabled(false);
            } else if (this.radioGroup_head.getCheckedRadioButtonId() == R.id.btn_china) {
                this.f11174aC.setDragImage(0);
                this.f11224l.setScrollable(true);
                ((DiagnoseActivity) getActivity()).m7732g().setSlidingEnabled(false);
            } else if (this.radioGroup_head.getCheckedRadioButtonId() == R.id.btn_favorites) {
                this.f11213ay.setDragImage(1);
                this.f11224l.setScrollable(true);
                ((DiagnoseActivity) getActivity()).m7732g().setSlidingEnabled(false);
            }
        } else if (C2744aa.m5176a(carIcon.f15778b, carIcon.f15789m)) {
            CarIcon m4951e = new CarIconUtils(this.mContext).m4951e(carIcon.f15790n, C2744aa.m5152e(carIcon.f15789m));
            new MessageDialog(this.mContext).m4669a(this.mContext.getResources().getString(R.string.dialog_title_default), String.format(getString(R.string.delete_merge_child_tip), LangManager.m9469a().equalsIgnoreCase("zh") ? m4951e.m5038a(this.mContext) : m4951e.f15779c));
        } else {
            CarIconUtils carIconUtils = new CarIconUtils(this.mContext);
            List<String> m5156d = C2744aa.m5156d(PathUtils.m4858c() + carIcon.f15789m);
            if (!m5156d.isEmpty()) {
                StringBuffer stringBuffer = new StringBuffer();
                for (int i2 = 0; i2 < m5156d.size(); i2++) {
                    CarIcon m4951e2 = carIconUtils.m4951e(carIcon.f15790n, m5156d.get(i2));
                    String m5038a = LangManager.m9469a().equalsIgnoreCase("zh") ? m4951e2.m5038a(this.mContext) : m4951e2.f15779c;
                    if (i2 != m5156d.size() - 1) {
                        stringBuffer.append(m5038a);
                        stringBuffer.append("、");
                    } else {
                        stringBuffer.append(m5038a);
                        stringBuffer.append("。");
                    }
                }
                String m5038a2 = LangManager.m9469a().equalsIgnoreCase("zh") ? carIcon.m5038a(this.mContext) : carIcon.f15779c;
                new C2110d(this, m5156d, carIcon).m4606b(this.mContext, this.mContext.getResources().getString(R.string.dialog_title_default), (String.format(getString(R.string.delete_merge_parent_tip1), m5038a2) + stringBuffer.toString()) + String.format(getString(R.string.delete_merge_parent_tip2), m5038a2, m5038a2));
            } else {
                new C2185e(this, carIcon).m4606b(this.mContext, this.mContext.getResources().getString(R.string.dialog_title_default), String.format(getString(R.string.dialog_content_delthissoftfile), LangManager.m9469a().equalsIgnoreCase("zh") ? carIcon.m5038a(this.mContext) : carIcon.f15779c));
            }
        }
        return true;
    }

    @Override // android.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        int i;
        super.onConfigurationChanged(configuration);
        m7556d();
        if (this.searchInputCars != null && !TextUtils.isEmpty(this.searchInputCars.getText().toString())) {
            m7557c(this.searchInputCars.getText().toString());
        }
        if (this.f11177aF || (i = this.f11175aD) <= 0) {
            return;
        }
        m7555d(i);
        PopupWindow popupWindow = this.f11176aE;
        RadioButton radioButton = this.f11198ai;
        popupWindow.showAsDropDown(radioButton, radioButton.getWidth() - 15, -this.f11198ai.getHeight());
    }

    @Override // android.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.tv_title.setVisibility(0);
        this.radioGroup_head.setVisibility(8);
        if (this.searchInputCars != null) {
            this.searchInputCars.setVisibility(8);
            if (this.f11182aK != null) {
                this.searchInputCars.removeTextChangedListener(this.f11182aK);
                this.f11182aK = null;
            }
            this.searchInputCars.setOnFocusChangeListener(null);
        }
        LoadDialog.m4681b(this.mContext);
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        if (z && view.isInTouchMode()) {
            view.performClick();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m7552e() {
        CarIconUtils carIconUtils = new CarIconUtils(this.mContext);
        this.f11160P = carIconUtils.m4965b(this.f11190aa);
        this.f11161Q = carIconUtils.m4957c(CarIconUtils.f15862b, this.f11190aa);
        this.f11162R = carIconUtils.m4957c(CarIconUtils.f15864d, this.f11190aa);
        this.f11163S = carIconUtils.m4957c(CarIconUtils.f15865e, this.f11190aa);
        this.f11165U = carIconUtils.m4957c(CarIconUtils.f15868h, this.f11170Z);
        this.f11164T = carIconUtils.m4957c(CarIconUtils.f15866f, this.f11190aa);
        this.f11167W = carIconUtils.m4957c(CarIconUtils.f15863c, this.f11190aa);
        m7550f();
    }

    /* renamed from: f */
    private void m7550f() {
        if (this.searchInputCars == null || TextUtils.isEmpty(this.searchInputCars.getText().toString())) {
            return;
        }
        this.f11160P = m7567a(this.f11160P, this.searchInputCars.getText().toString());
        this.f11161Q = m7567a(this.f11161Q, this.searchInputCars.getText().toString());
        this.f11162R = m7567a(this.f11162R, this.searchInputCars.getText().toString());
        this.f11163S = m7567a(this.f11163S, this.searchInputCars.getText().toString());
        this.f11165U = m7567a(this.f11165U, this.searchInputCars.getText().toString());
        this.f11164T = m7567a(this.f11164T, this.searchInputCars.getText().toString());
        this.f11167W = m7567a(this.f11167W, this.searchInputCars.getText().toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public void m7548g() {
        if (C2744aa.m5148g()) {
            this.f11226n.clear();
            this.f11226n.add(this.f11154J);
            this.f11191ab.setVisibility(0);
            this.f11191ab.setText(R.string.app_name);
            this.f11192ac.setVisibility(8);
            this.f11193ad.setVisibility(8);
            this.f11194ae.setVisibility(8);
            this.f11199aj.setVisibility(8);
            this.f11196ag.setVisibility(8);
            this.f11195af.setVisibility(8);
            this.f11198ai.setVisibility(8);
            this.f11191ab.setText(R.string.app_name);
        } else if (C2744aa.m5150f(this.mContext) && C2744aa.m5164c(this.mContext)) {
            this.f11226n.clear();
            C2744aa.m5135m();
            if (C2744aa.m5166c() && !C2744aa.m5145h()) {
                this.f11226n.add(this.f11154J);
                this.f11226n.add(this.f11151G);
                this.f11226n.add(this.f11152H);
                this.f11226n.add(this.f11153I);
                this.f11191ab.setVisibility(0);
                this.f11192ac.setVisibility(0);
                this.f11193ad.setVisibility(0);
                this.f11194ae.setVisibility(0);
                this.f11199aj.setVisibility(8);
            } else if (C2744aa.m5155e()) {
                this.f11226n.add(this.f11151G);
                this.f11226n.add(this.f11152H);
                this.f11226n.add(this.f11153I);
                this.f11191ab.setVisibility(8);
                this.f11192ac.setVisibility(0);
                this.f11193ad.setVisibility(0);
                this.f11194ae.setVisibility(0);
                this.f11199aj.setVisibility(8);
            } else {
                this.f11226n.add(this.f11151G);
                this.f11226n.add(this.f11152H);
                this.f11226n.add(this.f11153I);
                this.f11226n.add(this.f11159O);
                this.f11191ab.setVisibility(8);
                this.f11192ac.setVisibility(0);
                this.f11193ad.setVisibility(0);
                this.f11194ae.setVisibility(0);
                this.f11199aj.setVisibility(0);
            }
            if (C2744aa.m5154e(this.mContext)) {
                this.f11226n.add(this.f11155K);
                this.f11195af.setVisibility(0);
            } else {
                this.f11195af.setVisibility(8);
            }
            this.f11226n.add(this.f11156L);
            this.f11196ag.setVisibility(0);
            if (this.f11179aH) {
                this.f11226n.add(this.f11158N);
                this.f11198ai.setVisibility(0);
            } else {
                this.f11198ai.setVisibility(8);
            }
            this.f11168X = PreferencesManager.m9595a(this.mContext).m9591a("serialNo");
            if (!TextUtils.isEmpty(this.f11168X) && C2744aa.m5177a(this.f11168X, this.mContext)) {
                C2744aa.m5135m();
            } else if (!TextUtils.isEmpty(this.f11168X) && C2744aa.m5168b(this.f11168X, this.mContext)) {
                C2744aa.m5135m();
                C2744aa.m5154e(this.mContext);
            }
        } else if (C2744aa.m5150f(this.mContext) && !C2744aa.m5164c(this.mContext)) {
            this.f11226n.clear();
            C2744aa.m5135m();
            if (C2744aa.m5166c() && !C2744aa.m5145h()) {
                this.f11226n.add(this.f11154J);
                this.f11226n.add(this.f11151G);
                this.f11226n.add(this.f11152H);
                this.f11226n.add(this.f11153I);
                this.f11191ab.setVisibility(0);
                this.f11192ac.setVisibility(0);
                this.f11193ad.setVisibility(0);
                this.f11194ae.setVisibility(0);
                this.f11199aj.setVisibility(8);
                this.f11196ag.setVisibility(8);
            } else if (C2744aa.m5155e()) {
                this.f11226n.add(this.f11151G);
                this.f11226n.add(this.f11152H);
                this.f11226n.add(this.f11153I);
                this.f11191ab.setVisibility(8);
                this.f11192ac.setVisibility(0);
                this.f11193ad.setVisibility(0);
                this.f11194ae.setVisibility(0);
                this.f11199aj.setVisibility(8);
                this.f11196ag.setVisibility(8);
            } else {
                this.f11226n.add(this.f11151G);
                this.f11226n.add(this.f11152H);
                this.f11226n.add(this.f11153I);
                this.f11226n.add(this.f11159O);
                this.f11191ab.setVisibility(8);
                this.f11192ac.setVisibility(0);
                this.f11193ad.setVisibility(0);
                this.f11194ae.setVisibility(0);
                this.f11199aj.setVisibility(0);
                this.f11196ag.setVisibility(8);
            }
            if (C2744aa.m5154e(this.mContext)) {
                this.f11226n.add(this.f11155K);
                this.f11195af.setVisibility(0);
            } else {
                this.f11195af.setVisibility(8);
            }
            if (this.f11179aH) {
                this.f11226n.add(this.f11158N);
                this.f11198ai.setVisibility(0);
            } else {
                this.f11198ai.setVisibility(8);
            }
        } else if (!C2744aa.m5150f(this.mContext)) {
            this.f11226n.clear();
            this.f11226n.add(this.f11156L);
            this.f11191ab.setVisibility(8);
            this.f11192ac.setVisibility(8);
            this.f11193ad.setVisibility(8);
            this.f11194ae.setVisibility(8);
            this.f11196ag.setVisibility(0);
            this.f11198ai.setVisibility(8);
            this.f11199aj.setVisibility(8);
            this.f11195af.setVisibility(8);
            f11143al = 0;
        }
        if (this.f11202an) {
            this.f11226n.add(this.f11157M);
            this.f11197ah.setVisibility(0);
            if (f11143al >= this.f11226n.size() - 1) {
                f11143al = 0;
            }
        } else {
            this.f11197ah.setVisibility(8);
        }
        CarIconAdapter carIconAdapter = this.f11227o;
        carIconAdapter.f11256a = this.f11160P;
        carIconAdapter.notifyDataSetChanged();
        CarIconAdapter carIconAdapter2 = this.f11228p;
        carIconAdapter2.f11256a = this.f11161Q;
        carIconAdapter2.notifyDataSetChanged();
        CarIconAdapter carIconAdapter3 = this.f11229q;
        carIconAdapter3.f11256a = this.f11162R;
        carIconAdapter3.notifyDataSetChanged();
        CarIconAdapter carIconAdapter4 = this.f11230r;
        carIconAdapter4.f11256a = this.f11163S;
        carIconAdapter4.notifyDataSetChanged();
        CarIconAdapter carIconAdapter5 = this.f11232t;
        carIconAdapter5.f11256a = this.f11165U;
        carIconAdapter5.notifyDataSetChanged();
        CarIconAdapter carIconAdapter6 = this.f11231s;
        carIconAdapter6.f11256a = this.f11164T;
        carIconAdapter6.notifyDataSetChanged();
        CarIconAdapter carIconAdapter7 = this.f11234v;
        carIconAdapter7.f11256a = this.f11166V;
        carIconAdapter7.notifyDataSetChanged();
        CarIconAdapter carIconAdapter8 = this.f11235w;
        carIconAdapter8.f11256a = this.f11167W;
        carIconAdapter8.notifyDataSetChanged();
        this.f11225m.mo6192b();
        this.f11224l.setAdapter(this.f11225m);
        m7560c(f11143al);
        this.f11224l.setCurrentItem(f11143al);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public void m7546h() {
        boolean m9583b = PreferencesManager.m9595a(this.mContext).m9583b("isRemindedAppUsageNum", false);
        if (!LangManager.m9466b().equalsIgnoreCase("CN") || m9583b) {
            return;
        }
        if (!new File(PathUtils.m4846j() + "loginInfo.dat").exists()) {
            File file = new File(PathUtils.m4846j() + "appRestUsageNum.dat");
            int i = 10;
            if (!file.exists()) {
                HashMap hashMap = new HashMap();
                hashMap.put("未注册登录剩余使用次数", DiagnoseConstants.DATA_TYPE_FROM_APK_TO_SO_SET_MENUPATH);
                AppUsageNumRecord.m4924a(hashMap);
            } else {
                try {
                    i = Integer.valueOf(AppUsageNumRecord.m4926a().get("未注册登录剩余使用次数")).intValue();
                } catch (NumberFormatException e) {
                    NLog.m9455a(e);
                }
            }
            this.f11203ao = new MessageDialog(this.mContext);
            if (i <= 0) {
                this.f11203ao.setCancelable(false);
            } else {
                this.f11203ao.setCancelable(true);
            }
            this.f11203ao.m4710i();
            this.f11203ao.m4715c(((Activity) this.mContext).getString(R.string.remind_register_warn_message, new Object[]{Integer.valueOf(i)}));
            this.f11203ao.m4719a(R.string.remind_register_button_now, true, new View$OnClickListenerC2199g(this));
            this.f11203ao.m4717b(R.string.common_login, true, new View$OnClickListenerC2200h(this));
            this.f11203ao.setOnCancelListener(new DialogInterface$OnCancelListenerC2201i(this));
            this.f11203ao.show();
        }
        PreferencesManager.m9595a(this.mContext).m9587a("isRemindedAppUsageNum", true);
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, com.cnlaunch.x431pro.activity.golo.p225b.OnGoloKeyDownListener
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getAction() == 0) {
            if (this.f11203ao != null) {
                this.f11203ao = null;
            }
            if (MainActivity.m7895b()) {
                Intent intent = new Intent();
                intent.setAction("StopRemotoDiagnose");
                this.mContext.sendBroadcast(intent);
                return true;
            }
            this.f11185aN = new C2202j(this);
            this.f11185aN.m4607b(this.mContext, R.string.common_exit_dialog_title, R.string.common_exit_dialog_content, true);
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public void m7544i() {
        NLog.m9456a(f11144b, "initRequestUpdateDataParameter enter.");
        PreferencesManager.m9595a(this.mContext).m9589a("outlineFirstUsageTime", System.currentTimeMillis());
        PreferencesManager.m9595a(this.mContext).m9587a("isRequestUpdateDataOK", false);
        PreferencesManager.m9595a(this.mContext).m9589a("update_time", 0L);
        PreferencesManager.m9595a(this.mContext).m9589a("remind_update_time", 0L);
        PreferencesManager.m9595a(this.mContext).m9590a("unupdateSoftwareNum", 0);
        PreferencesManager.m9595a(this.mContext).m9590a("unupdateSoftwareNumForHeavyduty", 0);
        this.mContext.sendBroadcast(new Intent("unupgradeSoftNumChanged"));
        this.f11180aI = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public PopupWindow m7555d(int i) {
        NLog.m9456a(f11144b, "count=".concat(String.valueOf(i)));
        PopupWindow popupWindow = this.f11176aE;
        if (popupWindow != null && popupWindow.isShowing()) {
            this.f11176aE.dismiss();
        }
        View inflate = getActivity().getLayoutInflater().inflate(R.layout.green_buttle, (ViewGroup) null);
        ((TextView) inflate.findViewById(R.id.pop_tv)).setText(String.valueOf(i));
        this.f11176aE = new PopupWindow((View) null, 50, 50);
        this.f11176aE.setContentView(inflate);
        this.f11176aE.setWidth(20);
        this.f11176aE.setHeight(20);
        return this.f11176aE;
    }

    @Override // android.app.Fragment
    public void onPause() {
        super.onPause();
        PopupWindow popupWindow = this.f11176aE;
        if (popupWindow != null && popupWindow.isShowing()) {
            this.f11176aE.dismiss();
            this.f11177aF = true;
            return;
        }
        this.f11177aF = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m7557c(String str) {
        NLog.m9456a("yhx", "filterCurrentAreaCars enter.searchKey=" + str + ",preSearchKey=" + this.f11183aL);
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(this.f11183aL) || !str.equals(this.f11183aL)) {
            this.f11183aL = str;
            m7552e();
            this.f11227o.f11256a = m7567a(this.f11160P, str);
            this.f11227o.notifyDataSetChanged();
            this.f11228p.f11256a = m7567a(this.f11161Q, str);
            this.f11228p.notifyDataSetChanged();
            this.f11229q.f11256a = m7567a(this.f11162R, str);
            this.f11229q.notifyDataSetChanged();
            this.f11230r.f11256a = m7567a(this.f11163S, str);
            this.f11230r.notifyDataSetChanged();
            this.f11232t.f11256a = m7567a(this.f11165U, str);
            this.f11232t.notifyDataSetChanged();
            this.f11231s.f11256a = m7567a(this.f11164T, str);
            this.f11231s.notifyDataSetChanged();
            this.f11234v.f11256a = m7567a(this.f11166V, str);
            this.f11234v.notifyDataSetChanged();
            this.f11235w.f11256a = m7567a(this.f11167W, str);
            this.f11235w.notifyDataSetChanged();
        }
    }

    /* renamed from: a */
    private List<CarIcon> m7567a(List<CarIcon> list, String str) {
        if (TextUtils.isEmpty(str) || list == null || list.isEmpty()) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        for (CarIcon carIcon : list) {
            if (LangManager.m9469a().equalsIgnoreCase("zh")) {
                if (LangManager.m9466b().contains("HK") || LangManager.m9466b().contains("TW")) {
                    if (carIcon.f15779c.toLowerCase().contains(str.toLowerCase())) {
                        arrayList.add(carIcon);
                    }
                } else {
                    String m5038a = carIcon.m5038a(this.mContext);
                    if (!TextUtils.isEmpty(m5038a)) {
                        String m4390a = CharacterParser.m4391a().m4390a(m5038a);
                        String m4875a = FirstLetterUtils.m4875a(m5038a);
                        if (!TextUtils.isEmpty(m4390a) || !TextUtils.isEmpty(m4875a)) {
                            if (m4390a.toLowerCase().contains(str.toLowerCase()) || m4875a.toLowerCase().contains(str.toLowerCase()) || m5038a.contains(str)) {
                                arrayList.add(carIcon);
                            }
                        }
                    }
                }
            } else if (carIcon.f15779c.toLowerCase().contains(str.toLowerCase())) {
                arrayList.add(carIcon);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: p */
    public static /* synthetic */ void m7536p(CarIconFragmentForAll carIconFragmentForAll) {
        carIconFragmentForAll.f11190aa = PreferencesManager.m9595a(carIconFragmentForAll.mContext).m9591a("carSerialNo");
        carIconFragmentForAll.f11170Z = PreferencesManager.m9595a(carIconFragmentForAll.mContext).m9591a("heavydutySerialNo");
        if (C2744aa.m5164c(carIconFragmentForAll.mContext)) {
            C2744aa.m5135m();
            if (C2744aa.m5154e(carIconFragmentForAll.mContext)) {
                if (f11143al == 5) {
                    PreferencesManager.m9595a(carIconFragmentForAll.mContext).m9588a("serialNo", carIconFragmentForAll.f11170Z);
                } else {
                    PreferencesManager.m9595a(carIconFragmentForAll.mContext).m9588a("serialNo", carIconFragmentForAll.f11190aa);
                }
            } else if (f11143al == 4) {
                PreferencesManager.m9595a(carIconFragmentForAll.mContext).m9588a("serialNo", carIconFragmentForAll.f11170Z);
            } else {
                PreferencesManager.m9595a(carIconFragmentForAll.mContext).m9588a("serialNo", carIconFragmentForAll.f11190aa);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00ab A[Catch: Exception -> 0x023e, TryCatch #0 {Exception -> 0x023e, blocks: (B:10:0x001e, B:12:0x005f, B:14:0x0063, B:24:0x007a, B:26:0x0082, B:28:0x008a, B:30:0x008e, B:32:0x0092, B:34:0x00ab, B:36:0x00b7, B:42:0x0104, B:44:0x0136, B:46:0x013e, B:48:0x0146, B:49:0x014c, B:37:0x00c8, B:39:0x00d4, B:40:0x00e5, B:41:0x00f2, B:50:0x0151, B:52:0x0177, B:54:0x017b, B:56:0x017f, B:58:0x0188, B:60:0x0191, B:62:0x0199, B:63:0x01ae, B:65:0x01b2, B:67:0x01ba, B:68:0x01cf, B:79:0x0203, B:81:0x0209, B:77:0x01e8, B:83:0x020d, B:85:0x0211, B:87:0x0221, B:89:0x022a, B:91:0x0233, B:18:0x006b), top: B:96:0x001e }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00f2 A[Catch: Exception -> 0x023e, TryCatch #0 {Exception -> 0x023e, blocks: (B:10:0x001e, B:12:0x005f, B:14:0x0063, B:24:0x007a, B:26:0x0082, B:28:0x008a, B:30:0x008e, B:32:0x0092, B:34:0x00ab, B:36:0x00b7, B:42:0x0104, B:44:0x0136, B:46:0x013e, B:48:0x0146, B:49:0x014c, B:37:0x00c8, B:39:0x00d4, B:40:0x00e5, B:41:0x00f2, B:50:0x0151, B:52:0x0177, B:54:0x017b, B:56:0x017f, B:58:0x0188, B:60:0x0191, B:62:0x0199, B:63:0x01ae, B:65:0x01b2, B:67:0x01ba, B:68:0x01cf, B:79:0x0203, B:81:0x0209, B:77:0x01e8, B:83:0x020d, B:85:0x0211, B:87:0x0221, B:89:0x022a, B:91:0x0233, B:18:0x006b), top: B:96:0x001e }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0146 A[Catch: Exception -> 0x023e, TryCatch #0 {Exception -> 0x023e, blocks: (B:10:0x001e, B:12:0x005f, B:14:0x0063, B:24:0x007a, B:26:0x0082, B:28:0x008a, B:30:0x008e, B:32:0x0092, B:34:0x00ab, B:36:0x00b7, B:42:0x0104, B:44:0x0136, B:46:0x013e, B:48:0x0146, B:49:0x014c, B:37:0x00c8, B:39:0x00d4, B:40:0x00e5, B:41:0x00f2, B:50:0x0151, B:52:0x0177, B:54:0x017b, B:56:0x017f, B:58:0x0188, B:60:0x0191, B:62:0x0199, B:63:0x01ae, B:65:0x01b2, B:67:0x01ba, B:68:0x01cf, B:79:0x0203, B:81:0x0209, B:77:0x01e8, B:83:0x020d, B:85:0x0211, B:87:0x0221, B:89:0x022a, B:91:0x0233, B:18:0x006b), top: B:96:0x001e }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x014c A[Catch: Exception -> 0x023e, TryCatch #0 {Exception -> 0x023e, blocks: (B:10:0x001e, B:12:0x005f, B:14:0x0063, B:24:0x007a, B:26:0x0082, B:28:0x008a, B:30:0x008e, B:32:0x0092, B:34:0x00ab, B:36:0x00b7, B:42:0x0104, B:44:0x0136, B:46:0x013e, B:48:0x0146, B:49:0x014c, B:37:0x00c8, B:39:0x00d4, B:40:0x00e5, B:41:0x00f2, B:50:0x0151, B:52:0x0177, B:54:0x017b, B:56:0x017f, B:58:0x0188, B:60:0x0191, B:62:0x0199, B:63:0x01ae, B:65:0x01b2, B:67:0x01ba, B:68:0x01cf, B:79:0x0203, B:81:0x0209, B:77:0x01e8, B:83:0x020d, B:85:0x0211, B:87:0x0221, B:89:0x022a, B:91:0x0233, B:18:0x006b), top: B:96:0x001e }] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0211 A[Catch: Exception -> 0x023e, TryCatch #0 {Exception -> 0x023e, blocks: (B:10:0x001e, B:12:0x005f, B:14:0x0063, B:24:0x007a, B:26:0x0082, B:28:0x008a, B:30:0x008e, B:32:0x0092, B:34:0x00ab, B:36:0x00b7, B:42:0x0104, B:44:0x0136, B:46:0x013e, B:48:0x0146, B:49:0x014c, B:37:0x00c8, B:39:0x00d4, B:40:0x00e5, B:41:0x00f2, B:50:0x0151, B:52:0x0177, B:54:0x017b, B:56:0x017f, B:58:0x0188, B:60:0x0191, B:62:0x0199, B:63:0x01ae, B:65:0x01b2, B:67:0x01ba, B:68:0x01cf, B:79:0x0203, B:81:0x0209, B:77:0x01e8, B:83:0x020d, B:85:0x0211, B:87:0x0221, B:89:0x022a, B:91:0x0233, B:18:0x006b), top: B:96:0x001e }] */
    /* JADX WARN: Removed duplicated region for block: B:98:? A[RETURN, SYNTHETIC] */
    /* renamed from: w */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static /* synthetic */ void m7529w(com.cnlaunch.x431pro.activity.diagnose.CarIconFragmentForAll r13) {
        /*
            Method dump skipped, instructions count: 602
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cnlaunch.x431pro.activity.diagnose.CarIconFragmentForAll.m7529w(com.cnlaunch.x431pro.activity.diagnose.a):void");
    }
}
