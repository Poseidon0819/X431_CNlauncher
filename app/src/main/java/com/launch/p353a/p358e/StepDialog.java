package com.launch.p353a.p358e;

import android.app.DialogFragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.p012v4.view.PagerAdapter;
import android.support.p012v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.mapapi.UIMsg;
import com.itextpdf.text.pdf.ColumnText;
import com.launch.p353a.p359f.ImageManager;
import com.launch.p353a.p360g.NavCloseView;
import com.launch.p353a.p361h.RunnableC3663d;
import com.launch.p353a.p364k.AdError;
import com.launch.p353a.p364k.DisplayUtils;
import com.launch.p353a.p364k.UrlUtils;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;

/* renamed from: com.launch.a.e.m */
/* loaded from: classes.dex */
public final class StepDialog extends DialogFragment implements View.OnTouchListener {

    /* renamed from: b */
    public static StepDialog f19904b;

    /* renamed from: a */
    ViewPager.InterfaceC0177f f19905a;

    /* renamed from: c */
    boolean f19906c;

    /* renamed from: d */
    InterfaceC3649a f19907d;

    /* renamed from: e */
    JSONArray f19908e;

    /* renamed from: f */
    AbstractInterstitialADListener f19909f;

    /* renamed from: g */
    private ArrayList<View> f19910g;

    /* renamed from: h */
    private int f19911h;

    /* renamed from: i */
    private boolean f19912i;

    /* renamed from: j */
    private boolean f19913j;

    /* renamed from: k */
    private ViewPager f19914k;

    /* renamed from: l */
    private int f19915l = UIMsg.m_AppUI.MSG_APP_SAVESCREEN;

    /* renamed from: m */
    private int f19916m = 0;

    /* renamed from: n */
    private int f19917n = 0;

    /* renamed from: o */
    private float f19918o = 40.0f;

    /* renamed from: p */
    private float f19919p = 1.0f;

    /* renamed from: q */
    private Handler f19920q = new Handler(new C3651n(this));

    /* compiled from: StepDialog.java */
    /* renamed from: com.launch.a.e.m$a */
    /* loaded from: classes.dex */
    public interface InterfaceC3649a {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: k */
    public static /* synthetic */ int m2672k(StepDialog stepDialog) {
        stepDialog.f19917n = 1;
        return 1;
    }

    /* renamed from: a */
    public static StepDialog m2689a() {
        if (f19904b == null) {
            f19904b = new StepDialog();
        }
        return f19904b;
    }

    @Override // android.app.DialogFragment
    public final void show(FragmentManager fragmentManager, String str) {
        if (isAdded()) {
            return;
        }
        FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
        beginTransaction.add(this, str);
        beginTransaction.commitAllowingStateLoss();
    }

    /* renamed from: b */
    public final void m2683b() {
        AbstractInterstitialADListener abstractInterstitialADListener = this.f19909f;
        if (abstractInterstitialADListener != null) {
            abstractInterstitialADListener.mo2698d();
        }
        Handler handler = this.f19920q;
        if (handler != null) {
            handler.removeCallbacksAndMessages(this);
        }
        this.f19920q = null;
        if (getDialog() != null) {
            dismiss();
        }
    }

    @Override // android.app.Fragment
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int i;
        String string;
        String string2;
        String string3;
        String string4;
        RelativeLayout relativeLayout;
        ImageView imageView;
        this.f19910g = new ArrayList<>();
        getDialog().requestWindowFeature(1);
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(0));
        getDialog().setCanceledOnTouchOutside(this.f19906c);
        LinearLayout linearLayout = new LinearLayout(getActivity());
        int i2 = -1;
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.f19914k = new ViewPager(getActivity());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        Configuration configuration = getResources().getConfiguration();
        int identifier = getActivity().getResources().getIdentifier("lau", "drawable", getActivity().getPackageName());
        if (configuration.orientation == 2) {
            this.f19916m = 1;
            layoutParams.width = (int) Math.floor(DisplayUtils.m2646a(getActivity()) * 0.4f);
            layoutParams.height = (int) Math.floor(layoutParams.width * 0.77f);
            this.f19918o = (DisplayUtils.m2644b(getActivity()) / 375.0f) * this.f19918o;
            this.f19919p = DisplayUtils.m2644b(getActivity());
        } else {
            this.f19916m = 0;
            layoutParams.width = (int) Math.floor(DisplayUtils.m2646a(getActivity()) * 0.67f);
            layoutParams.height = (int) Math.floor(layoutParams.width * 1.3f);
            this.f19918o = (DisplayUtils.m2646a(getActivity()) / 375.0f) * this.f19918o;
            this.f19919p = DisplayUtils.m2644b(getActivity());
        }
        linearLayout.addView(this.f19914k, layoutParams);
        if (this.f19908e != null) {
            int i3 = 0;
            while (i3 < this.f19908e.length()) {
                try {
                    string = this.f19908e.getJSONObject(i3).getString("clickUrl");
                    string2 = this.f19908e.getJSONObject(i3).getString("urlType");
                    if (this.f19916m != 0 && !this.f19908e.getJSONObject(i3).getString("horImageUrl").isEmpty()) {
                        string3 = this.f19908e.getJSONObject(i3).getString("horImageUrl");
                    } else {
                        string3 = this.f19908e.getJSONObject(i3).getString("imageUrl");
                    }
                    string4 = this.f19908e.getJSONObject(i3).getString("viewId");
                    relativeLayout = new RelativeLayout(getActivity());
                    ImageView imageView2 = new ImageView(getActivity());
                    imageView2.setScaleType(ImageView.ScaleType.FIT_XY);
                    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(i2, i2);
                    layoutParams2.addRule(13);
                    imageView2.setLayoutParams(layoutParams2);
                    NavCloseView navCloseView = new NavCloseView(getActivity());
                    if (identifier == 0) {
                        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
                        layoutParams3.addRule(11);
                        TextView textView = new TextView(getActivity());
                        textView.setText("×");
                        textView.setGravity(16);
                        textView.setTextSize(this.f19918o);
                        navCloseView.setLayoutParams(layoutParams3);
                        textView.setLayoutParams(layoutParams3);
                        relativeLayout.addView(imageView2);
                        relativeLayout.addView(textView);
                        textView.setOnClickListener(new View$OnClickListenerC3652o(this));
                        imageView = imageView2;
                    } else {
                        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
                        layoutParams4.addRule(11);
                        layoutParams4.addRule(10);
                        layoutParams4.width = DisplayUtils.m2645a(getActivity(), 50.0f);
                        layoutParams4.height = DisplayUtils.m2645a(getActivity(), 50.0f);
                        ImageView imageView3 = new ImageView(getActivity());
                        imageView3.setImageResource(identifier);
                        imageView3.setLayoutParams(layoutParams4);
                        imageView3.setScaleType(ImageView.ScaleType.FIT_XY);
                        relativeLayout.addView(imageView2);
                        relativeLayout.addView(imageView3);
                        imageView3.setOnClickListener(new View$OnClickListenerC3653p(this));
                        imageView = imageView2;
                    }
                    i = i3;
                } catch (JSONException e) {
                    e = e;
                    i = i3;
                }
                try {
                    m2684a(string3, string4, string, string2, imageView);
                    this.f19910g.add(relativeLayout);
                } catch (JSONException e2) {
                    e = e2;
                    AbstractInterstitialADListener abstractInterstitialADListener = this.f19909f;
                    if (abstractInterstitialADListener != null) {
                        m2682b(abstractInterstitialADListener);
                    }
                    m2683b();
                    e.printStackTrace();
                    i3 = i + 1;
                    i2 = -1;
                }
                i3 = i + 1;
                i2 = -1;
            }
        }
        ViewPager viewPager = this.f19914k;
        ViewPager.InterfaceC0177f interfaceC0177f = this.f19905a;
        if (Build.VERSION.SDK_INT >= 11) {
            boolean z = interfaceC0177f != null;
            boolean z2 = z != (viewPager.f699d != null);
            viewPager.f699d = interfaceC0177f;
            viewPager.setChildrenDrawingOrderEnabledCompat(z);
            if (z) {
                viewPager.f701f = 2;
                viewPager.f700e = 2;
            } else {
                viewPager.f701f = 0;
            }
            if (z2) {
                viewPager.m14731c();
            }
        }
        this.f19914k.setAdapter(new C3650b());
        this.f19914k.m14742a(new C3654q(this));
        this.f19914k.setCurrentItem(0);
        if (this.f19920q != null && this.f19908e.length() > 1) {
            this.f19920q.sendEmptyMessageDelayed(0, this.f19915l);
        }
        return linearLayout;
    }

    @Override // android.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        m2683b();
        f19904b = null;
        this.f19908e = null;
    }

    @Override // android.app.DialogFragment, android.app.Fragment
    public final void onStart() {
        super.onStart();
        if (this.f19913j) {
            Window window = getDialog().getWindow();
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.dimAmount = ColumnText.GLOBAL_SPACE_CHAR_RATIO;
            window.setAttributes(attributes);
        }
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                Handler handler = this.f19920q;
                if (handler != null) {
                    handler.removeMessages(0);
                    break;
                }
                break;
            case 1:
                Handler handler2 = this.f19920q;
                if (handler2 != null) {
                    handler2.removeMessages(0);
                    this.f19920q.sendEmptyMessageDelayed(0, this.f19915l);
                    break;
                }
                break;
        }
        return false;
    }

    /* compiled from: StepDialog.java */
    /* renamed from: com.launch.a.e.m$b */
    /* loaded from: classes.dex */
    class C3650b extends PagerAdapter {
        @Override // android.support.p012v4.view.PagerAdapter
        /* renamed from: a */
        public final boolean mo1770a(View view, Object obj) {
            return view == obj;
        }

        C3650b() {
        }

        @Override // android.support.p012v4.view.PagerAdapter
        /* renamed from: a */
        public final int mo1771a() {
            return StepDialog.this.f19910g.size();
        }

        @Override // android.support.p012v4.view.PagerAdapter
        /* renamed from: a */
        public final Object mo1769a(ViewGroup viewGroup, int i) {
            viewGroup.addView((View) StepDialog.this.f19910g.get(i));
            return StepDialog.this.f19910g.get(i);
        }

        @Override // android.support.p012v4.view.PagerAdapter
        /* renamed from: a */
        public final void mo1768a(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView((View) StepDialog.this.f19910g.get(i));
        }
    }

    /* renamed from: a */
    private void m2684a(String str, String str2, String str3, String str4, ImageView imageView) {
        synchronized (imageView) {
            RunnableC3663d runnableC3663d = new RunnableC3663d(getActivity());
            runnableC3663d.f19880c = UrlUtils.m2627a(str2);
            runnableC3663d.f19879b = "GET";
            runnableC3663d.f19959f = new C3656s(this);
            runnableC3663d.m2655a();
            ImageManager imageManager = new ImageManager(getActivity());
            imageManager.f19949a = new C3655r(this, imageView, str2, str3, str4);
            imageManager.m2659a(str, imageView);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static void m2682b(AbstractInterstitialADListener abstractInterstitialADListener) {
        if (abstractInterstitialADListener != null) {
            new AdError();
            abstractInterstitialADListener.mo2690b();
        }
    }
}
