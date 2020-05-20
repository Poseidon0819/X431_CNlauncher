package com.unionpay.mobile.android.widgets;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.baidu.mapapi.UIMsg;
import com.unionpay.mobile.android.global.C4149a;
import com.unionpay.mobile.android.resource.C4342c;
import com.unionpay.mobile.android.utils.C4386g;
import com.unionpay.mobile.android.utils.C4387h;
import com.unionpay.mobile.android.utils.C4390k;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: com.unionpay.mobile.android.widgets.bb */
/* loaded from: classes2.dex */
public final class C4455bb {

    /* renamed from: a */
    private static int f23413a = C4149a.f22129r;

    /* renamed from: b */
    private static int f23414b = 40;

    /* renamed from: i */
    private static List<Integer> f23415i = new ArrayList(10);

    /* renamed from: c */
    private Context f23416c;

    /* renamed from: d */
    private View.OnClickListener f23417d;

    /* renamed from: e */
    private PopupWindow f23418e;

    /* renamed from: f */
    private View f23419f;

    /* renamed from: g */
    private ScrollView f23420g;

    /* renamed from: h */
    private int f23421h = -1;

    /* renamed from: j */
    private PopupWindow.OnDismissListener f23422j = new C4458bc(this);

    /* renamed from: com.unionpay.mobile.android.widgets.bb$a */
    /* loaded from: classes2.dex */
    class C4456a extends BaseAdapter {
        private C4456a() {
        }

        /* synthetic */ C4456a(C4455bb c4455bb, byte b) {
            this();
        }

        @Override // android.widget.Adapter
        public final int getCount() {
            return C4455bb.f23415i.size() + 2;
        }

        @Override // android.widget.Adapter
        public final Object getItem(int i) {
            return null;
        }

        @Override // android.widget.Adapter
        public final long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public final View getView(int i, View view, ViewGroup viewGroup) {
            LinearLayout linearLayout = new LinearLayout(C4455bb.this.f23416c);
            Drawable m1037a = C4342c.m1036a(C4455bb.this.f23416c).m1037a(1022, -1, -1);
            Drawable m1037a2 = C4342c.m1036a(C4455bb.this.f23416c).m1037a(1022, -1, -1);
            linearLayout.setBackgroundDrawable(C4387h.m852a(m1037a, m1037a2, m1037a2, m1037a));
            linearLayout.setMinimumHeight(C4386g.m858a(C4455bb.this.f23416c, 55.0f));
            linearLayout.setClickable(true);
            linearLayout.setOnClickListener(C4455bb.this.f23417d);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
            layoutParams.gravity = 17;
            if (i == 9 || i == 11) {
                ImageView imageView = new ImageView(C4455bb.this.f23416c);
                int i2 = i != 9 ? 20 : 10;
                imageView.setImageDrawable(C4342c.m1036a(C4455bb.this.f23416c).m1037a(i == 9 ? 1024 : 1025, -1, C4386g.m858a(C4455bb.this.f23416c, 20.0f)));
                linearLayout.setId(i2);
                linearLayout.addView(imageView, layoutParams);
            } else {
                TextView textView = new TextView(C4455bb.this.f23416c);
                textView.setTextColor(-1);
                textView.getPaint().setFakeBoldText(true);
                textView.setTextSize(30.0f);
                textView.setGravity(17);
                if (i == 10) {
                    i = 9;
                }
                int intValue = ((Integer) C4455bb.f23415i.get(i)).intValue();
                linearLayout.setId(intValue);
                textView.setText(String.valueOf(intValue));
                linearLayout.addView(textView, layoutParams);
            }
            return linearLayout;
        }
    }

    /* renamed from: com.unionpay.mobile.android.widgets.bb$b */
    /* loaded from: classes2.dex */
    class C4457b extends LinearLayout {
        public C4457b(Context context) {
            super(context);
            setOrientation(1);
            setBackgroundColor(-11316397);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.gravity = 17;
            LinearLayout linearLayout = new LinearLayout(context);
            int m858a = C4386g.m858a(context, 5.0f);
            linearLayout.setPadding(0, m858a, 0, m858a);
            linearLayout.setGravity(17);
            linearLayout.setBackgroundColor(-13816531);
            linearLayout.setOrientation(0);
            Drawable m1037a = C4342c.m1036a(context).m1037a(UIMsg.m_AppUI.MSG_GET_GL_OK, -1, C4386g.m858a(context, 24.0f));
            ImageView imageView = new ImageView(context);
            imageView.setImageDrawable(m1037a);
            linearLayout.addView(imageView);
            addView(linearLayout, layoutParams);
            Collections.shuffle(C4455bb.f23415i);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
            layoutParams2.gravity = 17;
            GridView gridView = new GridView(context);
            gridView.setNumColumns(3);
            gridView.setAdapter((ListAdapter) new C4456a(C4455bb.this, (byte) 0));
            gridView.setGravity(17);
            gridView.setStretchMode(2);
            gridView.setHorizontalScrollBarEnabled(false);
            gridView.setVerticalScrollBarEnabled(false);
            gridView.setEnabled(true);
            int m858a2 = C4386g.m858a(C4455bb.this.f23416c, 1.0f);
            gridView.setHorizontalSpacing(m858a2);
            gridView.setVerticalSpacing(m858a2);
            int i = -m858a2;
            gridView.setPadding(i, m858a2, i, i);
            addView(gridView, layoutParams2);
        }
    }

    static {
        for (int i = 0; i < 10; i++) {
            f23415i.add(Integer.valueOf(i));
        }
    }

    public C4455bb(Context context, View.OnClickListener onClickListener, View view) {
        this.f23416c = null;
        this.f23417d = null;
        this.f23418e = null;
        this.f23419f = null;
        this.f23420g = null;
        this.f23416c = context;
        this.f23417d = onClickListener;
        f23413a = C4386g.m858a(this.f23416c, 55.0f);
        f23414b = C4386g.m858a(this.f23416c, 40.0f);
        ViewParent viewParent = (ViewParent) view;
        while (true) {
            if (viewParent == null) {
                break;
            } else if (viewParent instanceof ScrollView) {
                ScrollView scrollView = (ScrollView) viewParent;
                this.f23420g = scrollView;
                C4390k.m838a("UPWidgetKeyBoard", "mSV : " + this.f23420g.toString());
                C4390k.m838a("UPWidgetKeyBoard", "mSV H:" + this.f23420g.getHeight());
                this.f23419f = scrollView.getChildAt(0);
                break;
            } else {
                viewParent = viewParent.getParent();
            }
        }
        RelativeLayout relativeLayout = new RelativeLayout(context);
        new RelativeLayout.LayoutParams(-1, -2).setMargins(0, 0, 0, 0);
        relativeLayout.setBackgroundColor(-1342177280);
        RelativeLayout relativeLayout2 = new RelativeLayout(context);
        relativeLayout2.setBackgroundColor(-13290188);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(0, 0, 0, 0);
        relativeLayout.addView(relativeLayout2, layoutParams);
        relativeLayout2.addView(new C4457b(this.f23416c), layoutParams);
        this.f23418e = new PopupWindow((View) relativeLayout, -1, -2, true);
        new RelativeLayout.LayoutParams(-1, -2);
        this.f23418e.setBackgroundDrawable(new BitmapDrawable());
        this.f23418e.setOutsideTouchable(false);
        this.f23418e.setFocusable(false);
        this.f23418e.setOnDismissListener(this.f23422j);
    }

    /* renamed from: d */
    private static int m658d() {
        int i = (f23413a * 4) + f23414b;
        C4390k.m836c("UPWidgetKeyBoard", "kbH=".concat(String.valueOf(i)));
        return i;
    }

    /* renamed from: a */
    public final void m665a() {
        PopupWindow popupWindow = this.f23418e;
        if (popupWindow != null) {
            popupWindow.dismiss();
        }
    }

    /* renamed from: a */
    public final void m664a(View view) {
        PopupWindow popupWindow = this.f23418e;
        if (popupWindow != null) {
            popupWindow.showAtLocation(view, 80, 0, 0);
            if (this.f23419f != null) {
                view.setVisibility(0);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f23420g.getLayoutParams();
                this.f23421h = marginLayoutParams.height;
                Rect rect = new Rect();
                view.getWindowVisibleDisplayFrame(rect);
                marginLayoutParams.height = ((C4149a.f22131t - rect.top) - C4149a.f22122k) - m658d();
                C4390k.m838a("UPWidgetKeyBoard", "height = " + marginLayoutParams.height);
                marginLayoutParams.bottomMargin = m658d();
                this.f23420g.setLayoutParams(marginLayoutParams);
            }
        }
    }

    /* renamed from: b */
    public final boolean m662b() {
        return this.f23418e.isShowing();
    }
}
