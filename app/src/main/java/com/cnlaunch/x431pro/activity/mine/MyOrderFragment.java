package com.cnlaunch.x431pro.activity.mine;

import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.support.p012v4.view.PagerAdapter;
import android.support.p012v4.view.ViewPager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.cnlaunch.p120d.p121a.PreferencesManager;
import com.cnlaunch.p120d.p125c.p128c.C1425f;
import com.cnlaunch.p120d.p130d.NToast;
import com.cnlaunch.x431pro.activity.BaseFragment;
import com.cnlaunch.x431pro.activity.diagnose.p218a.ViewPagerAdapter;
import com.cnlaunch.x431pro.module.p255e.p256a.PincardAction;
import com.cnlaunch.x431pro.module.p255e.p257b.CardConsumeDTO;
import com.cnlaunch.x431pro.module.p255e.p257b.CardConsumeListResult;
import com.cnlaunch.x431pro.module.p258f.p259a.PayAction;
import com.cnlaunch.x431pro.module.p258f.p260b.ConfigPriceResponse;
import com.cnlaunch.x431pro.module.p258f.p260b.ProductSoftResponse;
import com.cnlaunch.x431pro.module.p258f.p260b.UserOrderDTO;
import com.cnlaunch.x431pro.module.p258f.p260b.UserOrderListInfoResponse;
import com.cnlaunch.x431pro.p210a.ApplicationTheme;
import com.cnlaunch.x431pro.utils.C2744aa;
import com.cnlaunch.x431pro.utils.SerialNoUtils;
import com.cnlaunch.x431pro.widget.PagerSlidingTabStrip;
import com.cnlaunch.x431pro.widget.p290a.LoadDialog;
import com.ifoer.expedition.pro.R;
import com.mopub.common.MoPubBrowser;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: com.cnlaunch.x431pro.activity.mine.au */
/* loaded from: classes.dex */
public class MyOrderFragment extends BaseFragment implements ViewPager.InterfaceC0176e {

    /* renamed from: a */
    private PagerSlidingTabStrip f13694a;

    /* renamed from: i */
    private CardConsumeListResult f13702i;

    /* renamed from: j */
    private ConfigPriceResponse f13703j;

    /* renamed from: k */
    private UserOrderListInfoResponse f13704k;

    /* renamed from: b */
    private ViewPager f13695b = null;

    /* renamed from: c */
    private PagerAdapter f13696c = null;

    /* renamed from: d */
    private ArrayList<View> f13697d = new ArrayList<>();

    /* renamed from: e */
    private List<CardConsumeDTO> f13698e = null;

    /* renamed from: f */
    private List<UserOrderDTO> f13699f = null;

    /* renamed from: g */
    private List<UserOrderDTO> f13700g = null;

    /* renamed from: h */
    private PincardAction f13701h = null;

    /* renamed from: l */
    private Handler f13705l = null;

    @Override // android.support.p012v4.view.ViewPager.InterfaceC0176e
    /* renamed from: a */
    public final void mo1773a(int i, float f, int i2) {
    }

    @Override // android.support.p012v4.view.ViewPager.InterfaceC0176e
    /* renamed from: a_ */
    public final void mo1772a_(int i) {
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment
    public View onCreateFragmentView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_my_order, viewGroup, false);
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        setTitle(R.string.mine_my_order);
        this.f13694a = (PagerSlidingTabStrip) getActivity().findViewById(R.id.tabs);
        this.f13694a.setShouldExpand(true);
        this.f13694a.setOnPageChangeListener(this);
        this.f13694a.setTextColorResource(ApplicationTheme.m7972d(getActivity()));
        this.f13694a.setIndicatorColorResource(ApplicationTheme.m7972d(getActivity()));
        this.f13694a.setTextSize(getResources().getInteger(R.integer.report_tip_title_textsize));
        this.f13695b = (ViewPager) getActivity().findViewById(R.id.pager);
        LayoutInflater layoutInflater = getActivity().getLayoutInflater();
        this.f13697d = new ArrayList<>();
        if (C2744aa.m5160d()) {
            this.f13697d.add(layoutInflater.inflate(R.layout.layout_container, (ViewGroup) null));
            this.f13696c = new C2409a(this.f13697d, getString(R.string.mine_order_payment));
        } else {
            this.f13697d.add(layoutInflater.inflate(R.layout.layout_container, (ViewGroup) null));
            this.f13697d.add(layoutInflater.inflate(R.layout.layout_container, (ViewGroup) null));
            this.f13696c = new C2409a(this.f13697d, getString(R.string.mine_order_without_payment), getString(R.string.mine_order_payment));
        }
        this.f13695b.setAdapter(this.f13696c);
        this.f13694a.setViewPager(this.f13695b);
        this.f13705l = new HandlerC2410av(this);
        SerialNoUtils.m4827a(this.mContext).m4828a();
        this.f13701h = new PincardAction(this.mContext);
        LoadDialog.m4680b(this.mContext, getString(R.string.refresh_txt));
        request(1001);
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        ViewPager viewPager = this.f13695b;
        if (viewPager != null) {
            viewPager.requestFocus();
        }
        ViewPager viewPager2 = this.f13695b;
        if ((viewPager2 != null ? viewPager2.getCurrentItem() : 0) == 0) {
            ((MineActivity) getActivity()).m7732g().setTouchModeAbove(1);
        } else {
            ((MineActivity) getActivity()).m7732g().setTouchModeAbove(2);
        }
    }

    @Override // android.support.p012v4.view.ViewPager.InterfaceC0176e
    /* renamed from: a */
    public final void mo1774a(int i) {
        View childAt;
        ViewPager viewPager = this.f13695b;
        if (viewPager != null && (childAt = viewPager.getChildAt(i)) != null) {
            childAt.requestFocus();
        }
        if (i == 0) {
            ((MineActivity) getActivity()).m7732g().setTouchModeAbove(1);
        } else {
            ((MineActivity) getActivity()).m7732g().setTouchModeAbove(2);
        }
    }

    /* compiled from: MyOrderFragment.java */
    /* renamed from: com.cnlaunch.x431pro.activity.mine.au$a */
    /* loaded from: classes.dex */
    public class C2409a extends ViewPagerAdapter {

        /* renamed from: c */
        private String[] f13707c;

        public C2409a(ArrayList<View> arrayList, String... strArr) {
            super(arrayList);
            this.f13707c = new String[0];
            this.f13707c = strArr;
        }

        @Override // android.support.p012v4.view.PagerAdapter
        /* renamed from: a */
        public final CharSequence mo5638a(int i) {
            String[] strArr = this.f13707c;
            return i > strArr.length ? "NULL TITLE" : strArr[i];
        }
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public Object doInBackground(int i) throws C1425f {
        if (1001 == i) {
            this.f13703j = new PayAction(this.mContext).m5337l(getBundle().getString("serialNo"));
            return this.f13703j;
        } else if (1002 == i) {
            this.f13702i = this.f13701h.m5355g(SerialNoUtils.m4827a(this.mContext).f15951a);
            if (this.f13702i.getCode() == 0) {
                this.f13698e = this.f13702i.getCardConsumeRecordList();
            }
            return this.f13702i;
        } else if (1003 == i) {
            this.f13704k = new PayAction(this.mContext).m5344b(PreferencesManager.m9595a(this.mContext).m9584b("user_id", ""), getBundle().getString("serialNo"));
            return this.f13704k;
        } else {
            return super.doInBackground(i);
        }
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public void onSuccess(int i, Object obj) {
        if (1001 == i) {
            if (obj != null && (obj instanceof ProductSoftResponse)) {
                ProductSoftResponse productSoftResponse = (ProductSoftResponse) obj;
                if (productSoftResponse.getCode() == 0) {
                    this.f13705l.sendMessage(this.f13705l.obtainMessage(100, i, productSoftResponse.getCode(), productSoftResponse));
                } else {
                    this.f13705l.sendMessage(this.f13705l.obtainMessage(101, i, productSoftResponse.getCode(), productSoftResponse.getMessage()));
                }
            }
            request(1002);
        } else if (1002 == i) {
            if (obj != null && (obj instanceof CardConsumeListResult)) {
                CardConsumeListResult cardConsumeListResult = (CardConsumeListResult) obj;
                if (cardConsumeListResult.getCode() == 0) {
                    this.f13705l.sendMessage(this.f13705l.obtainMessage(100, i, cardConsumeListResult.getCode(), cardConsumeListResult));
                } else {
                    this.f13705l.sendMessage(this.f13705l.obtainMessage(101, i, cardConsumeListResult.getCode(), cardConsumeListResult.getMessage()));
                }
            }
            request(1003);
        } else if (1003 == i && obj != null && (obj instanceof UserOrderListInfoResponse)) {
            UserOrderListInfoResponse userOrderListInfoResponse = (UserOrderListInfoResponse) obj;
            if (userOrderListInfoResponse.getCode() == 0) {
                this.f13705l.sendMessage(this.f13705l.obtainMessage(100, i, userOrderListInfoResponse.getCode(), userOrderListInfoResponse));
            } else {
                this.f13705l.sendMessage(this.f13705l.obtainMessage(101, i, userOrderListInfoResponse.getCode(), userOrderListInfoResponse.getMessage()));
            }
        }
        super.onSuccess(i, obj);
    }

    @Override // com.cnlaunch.x431pro.activity.BaseFragment, com.cnlaunch.p120d.p125c.p126a.OnDataListener
    public void onFailure(int i, int i2, Object obj) {
        this.f13705l.sendMessage(this.f13705l.obtainMessage(101, i, i2));
        if (-1 != i2) {
            if (1001 == i) {
                request(1002);
            } else if (1002 == i) {
                request(1003);
            }
        }
        super.onFailure(i, i2, obj);
    }

    @Override // android.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        setTitle(R.string.mine_my_order);
        if (this.mContentView != null) {
            int paddingTop = this.mContentView.getPaddingTop();
            int paddingRight = this.mContentView.getPaddingRight();
            int paddingBottom = this.mContentView.getPaddingBottom();
            if (paddingRight == 0) {
                this.mContentView.setPadding((int) getResources().getDimension(R.dimen.padding_left_multi_fragment), paddingTop, paddingRight, paddingBottom);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static /* synthetic */ void m6437a(MyOrderFragment myOrderFragment) {
        if (myOrderFragment.f13698e == null) {
            return;
        }
        Collections.sort(myOrderFragment.f13698e, new C2432bb(myOrderFragment));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public static /* synthetic */ void m6433b(MyOrderFragment myOrderFragment) {
        for (CardConsumeDTO cardConsumeDTO : myOrderFragment.f13698e) {
            if (cardConsumeDTO != null) {
                if (myOrderFragment.getActivity() == null || TextUtils.isEmpty(cardConsumeDTO.getCardNo())) {
                    return;
                }
                LayoutInflater layoutInflater = myOrderFragment.getActivity().getLayoutInflater();
                ArrayList<View> arrayList = myOrderFragment.f13697d;
                View inflate = layoutInflater.inflate(R.layout.item_order_payment_pin_card, (ViewGroup) null);
                ((LinearLayout) arrayList.get(arrayList.size() - 1).findViewById(R.id.container)).addView(inflate);
                ((TextView) inflate.findViewById(R.id.card_no)).setText(myOrderFragment.getString(R.string.mine_pin_card_number, new Object[]{cardConsumeDTO.getCardNo()}));
                ((TextView) inflate.findViewById(R.id.activate_date)).setText(cardConsumeDTO.getUpdateDate());
                ((TextView) inflate.findViewById(R.id.sn)).setText(myOrderFragment.getString(R.string.mine_sn, new Object[]{cardConsumeDTO.getSerialNo()}));
                ConfigPriceResponse configPriceResponse = myOrderFragment.f13703j;
                if (configPriceResponse != null && configPriceResponse.getCode() == 0 && myOrderFragment.f13703j.getSoftConfName() != null) {
                    ((TextView) inflate.findViewById(R.id.software_name)).setText(myOrderFragment.f13703j.getSoftConfName());
                }
                ((TextView) inflate.findViewById(R.id.expiration_date)).setText(myOrderFragment.getString(R.string.mine_expiration_date, new Object[]{cardConsumeDTO.getFreeEndTime()}));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: e */
    public static /* synthetic */ void m6428e(MyOrderFragment myOrderFragment) {
        if (myOrderFragment.f13699f == null) {
            return;
        }
        Collections.sort(myOrderFragment.f13699f, new C2433bc(myOrderFragment));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: f */
    public static /* synthetic */ void m6427f(MyOrderFragment myOrderFragment) {
        if (myOrderFragment.f13700g == null) {
            return;
        }
        Collections.sort(myOrderFragment.f13700g, new C2434bd(myOrderFragment));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: g */
    public static /* synthetic */ void m6426g(MyOrderFragment myOrderFragment) {
        List<UserOrderDTO> list = myOrderFragment.f13699f;
        if (list != null) {
            for (UserOrderDTO userOrderDTO : list) {
                if (myOrderFragment.getActivity() == null) {
                    return;
                }
                if (userOrderDTO.getStatus() == 0 && !C2744aa.m5166c()) {
                    LayoutInflater layoutInflater = myOrderFragment.getActivity().getLayoutInflater();
                    LinearLayout linearLayout = (LinearLayout) myOrderFragment.f13697d.get(0).findViewById(R.id.container);
                    View inflate = layoutInflater.inflate(R.layout.item_order_without_payment, (ViewGroup) null);
                    linearLayout.addView(inflate);
                    ((TextView) inflate.findViewById(R.id.SN)).setText(myOrderFragment.getString(R.string.mine_sn, new Object[]{userOrderDTO.getSerialno()}));
                    ((TextView) inflate.findViewById(R.id.order)).setText(userOrderDTO.getOrdersn());
                    ConfigPriceResponse configPriceResponse = myOrderFragment.f13703j;
                    if (configPriceResponse != null && configPriceResponse.getCode() == 0 && myOrderFragment.f13703j.getSoftConfName() != null) {
                        ((TextView) inflate.findViewById(R.id.software_name)).setText(myOrderFragment.f13703j.getSoftConfName());
                    }
                    ((TextView) inflate.findViewById(R.id.create_date)).setText(userOrderDTO.getOrdertime());
                    ((Button) inflate.findViewById(R.id.pay)).setOnClickListener(new View$OnClickListenerC2411aw(myOrderFragment, userOrderDTO));
                    ((Button) inflate.findViewById(R.id.cancel)).setOnClickListener(new View$OnClickListenerC2414az(myOrderFragment, userOrderDTO, linearLayout, inflate));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: h */
    public static /* synthetic */ void m6425h(MyOrderFragment myOrderFragment) {
        List<UserOrderDTO> list = myOrderFragment.f13700g;
        if (list != null) {
            for (UserOrderDTO userOrderDTO : list) {
                if (myOrderFragment.getActivity() == null) {
                    return;
                }
                if (1 == userOrderDTO.getStatus()) {
                    LayoutInflater layoutInflater = myOrderFragment.getActivity().getLayoutInflater();
                    ArrayList<View> arrayList = myOrderFragment.f13697d;
                    View inflate = layoutInflater.inflate(R.layout.item_order_payment_paypal, (ViewGroup) null);
                    ((LinearLayout) arrayList.get(arrayList.size() - 1).findViewById(R.id.container)).addView(inflate);
                    ((TextView) inflate.findViewById(R.id.SN)).setText(myOrderFragment.getString(R.string.mine_sn, new Object[]{userOrderDTO.getSerialno()}));
                    ((TextView) inflate.findViewById(R.id.order)).setText(userOrderDTO.getOrdersn());
                    TextView textView = (TextView) inflate.findViewById(R.id.title);
                    String str = userOrderDTO.getCurrencyid() == 0 ? "￥" : "$";
                    textView.setText(myOrderFragment.getString(R.string.mine_order_title, new Object[]{str + userOrderDTO.getTotalprice()}));
                    ConfigPriceResponse configPriceResponse = myOrderFragment.f13703j;
                    if (configPriceResponse != null && configPriceResponse.getCode() == 0 && myOrderFragment.f13703j.getSoftConfName() != null) {
                        ((TextView) inflate.findViewById(R.id.software_name)).setText(myOrderFragment.f13703j.getSoftConfName());
                    }
                    ((TextView) inflate.findViewById(R.id.activate_date)).setText(userOrderDTO.getPaytime());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static /* synthetic */ void m6436a(MyOrderFragment myOrderFragment, int i) {
        try {
            new PayAction(myOrderFragment.mContext);
            String m5335n = PayAction.m5335n(Integer.toString(i));
            if (TextUtils.isEmpty(m5335n)) {
                NToast.m9450a(myOrderFragment.mContext, (int) R.string.mine_error_paypal);
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString(MoPubBrowser.DESTINATION_URL_KEY, m5335n);
            myOrderFragment.replaceFragment(PayPalPayFragment.class.getName(), bundle, true);
        } catch (C1425f e) {
            e.printStackTrace();
            NToast.m9450a(myOrderFragment.mContext, (int) R.string.mine_error_paypal);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static /* synthetic */ void m6435a(MyOrderFragment myOrderFragment, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("order_sn", str);
        bundle.putBoolean("isFromOrder", true);
        myOrderFragment.replaceFragment(FragmentC2499z.class.getName(), bundle, true);
    }
}
